package com.bytedance.webx.seclink.request;

import android.text.TextUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.base.Constants;
import com.bytedance.webx.seclink.base.INetApi;
import com.bytedance.webx.seclink.cache.UrlSecLinkCache;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.ExceptionUtil;
import com.bytedance.webx.seclink.util.Log;
import com.bytedance.webx.seclink.util.MD5Util;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.bytedance.webx.seclink.util.SecLinkHelper;
import com.bytedance.webx.seclink.util.SecLinkTaskExecutor;
import com.bytedance.webx.seclink.util.UrlBuilder;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CheckUrlSecManager {
    private static final long MIN_TIME_DELAY = 300;
    private static final String TAG = "CheckUrlSecManager";
    private static long errorDurationTime = 1800000;
    private static int errorNum = 0;
    private static long errorStartTime = 0;
    private static volatile CheckUrlSecManager instance = null;
    private static long maxErrorNum = 50;
    private static INetApi netApi = null;
    private static long shieldDurationTime = 1800000;
    private static long shieldStartTime;
    private CheckRecord mLastCheckRecord;
    private final ConcurrentHashMap<String, List<CheckUrlTask>> mPendingTaskMap = new ConcurrentHashMap<>();

    static /* synthetic */ int access$408() {
        int i = errorNum;
        errorNum = i + 1;
        return i;
    }

    private CheckUrlSecManager() {
    }

    public static CheckUrlSecManager getInstance() {
        if (instance == null) {
            synchronized (CheckUrlSecManager.class) {
                if (instance == null) {
                    instance = new CheckUrlSecManager();
                }
            }
        }
        return instance;
    }

    public void check(CheckUrlTask checkUrlTask) {
        if (isValid(checkUrlTask, true)) {
            checkInner(checkUrlTask);
        }
    }

    public static void setNetApi(INetApi iNetApi) {
        netApi = iNetApi;
    }

    public static void setErrorConfig(int i, long j, long j2) {
        if (i > 0) {
            maxErrorNum = i;
        }
        if (j > 0) {
            errorDurationTime = j;
        }
        if (j2 > 0) {
            shieldDurationTime = j2;
        }
    }

    public boolean isShielding() {
        return System.currentTimeMillis() - shieldStartTime < shieldDurationTime;
    }

    private void checkInner(CheckUrlTask checkUrlTask) {
        SecLinkTaskExecutor.getInstance().execute(new checkUrlRunnable(checkUrlTask));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckEnable(CheckUrlTask checkUrlTask) {
        if (checkUrlTask == null) {
            return false;
        }
        String scene = checkUrlTask.getScene();
        String target = checkUrlTask.getTarget();
        if (TextUtils.isEmpty(target)) {
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(target, "url is empty");
            }
            return false;
        }
        if (!SettingManager.isSafeCheckEnable(scene)) {
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(target, "scene:" + scene + ",sec_link is disable by sec_link_sdk setting cfg");
            }
            return false;
        }
        if (!SecLinkHelper.startWithSecHost(target)) {
            return true;
        }
        Log.m49e(TAG, "url start with SecConstant.SEC_MIDDLE_PAGE");
        if (checkUrlTask.getCallback() != null) {
            checkUrlTask.getCallback().onFail(target, "url start with sec Host");
        }
        return false;
    }

    private boolean isValid(CheckUrlTask checkUrlTask, boolean z) {
        if (checkUrlTask == null) {
            return false;
        }
        String scene = checkUrlTask.getScene();
        String target = checkUrlTask.getTarget();
        if (!SettingManager.isSafeCheckEnable(scene)) {
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(target, "scene:" + scene + ",sec_link is disable by sec_link_sdk setting cfg");
            }
            return false;
        }
        if (TextUtils.isEmpty(target)) {
            Log.m49e(TAG, "url is empty.");
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(target, "url is empty");
            }
            return false;
        }
        if (SecLinkHelper.startWithSecHost(target)) {
            Log.m49e(TAG, "url start with SecConstant.SEC_MIDDLE_PAGE");
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(target, "url start with sec Host");
            }
            return false;
        }
        CheckUrlResponse validCache = UrlSecLinkCache.getInstance().getValidCache(checkUrlTask.getScene(), checkUrlTask.getTarget());
        if (validCache != null) {
            Log.m49e(TAG, "url response is in valid time");
            ReportUtil.hitCache(target, scene, checkUrlTask.getBizTag(), validCache.isNeedShowPage(), "task_check");
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onSuccess(target, validCache);
            }
            return false;
        }
        String buildRecordKey = CheckRecord.buildRecordKey(checkUrlTask.getAid(), checkUrlTask.getScene(), checkUrlTask.getTarget());
        CheckRecord checkRecord = this.mLastCheckRecord;
        if (checkRecord == null || !checkRecord.getRecordKey().equals(buildRecordKey) || System.currentTimeMillis() - this.mLastCheckRecord.getCreateTime() >= 300) {
            this.mLastCheckRecord = new CheckRecord(checkUrlTask.getAid(), checkUrlTask.getScene(), checkUrlTask.getTarget());
            return true;
        }
        if (z) {
            if (this.mLastCheckRecord.isFinish()) {
                CheckUrlResponse checkResult = this.mLastCheckRecord.getCheckResult();
                String errorMessage = this.mLastCheckRecord.getErrorMessage();
                if (checkResult != null && checkResult.success()) {
                    if (checkUrlTask.getCallback() != null) {
                        checkUrlTask.getCallback().onSuccess(target, checkResult);
                    }
                } else if (checkUrlTask.getCallback() != null) {
                    checkUrlTask.getCallback().onFail(target, errorMessage);
                }
            } else {
                cacheConflictTask(buildRecordKey, checkUrlTask);
            }
        } else if (checkUrlTask.getCallback() != null) {
            checkUrlTask.getCallback().onFail(target, "same url invoke multi_times  u should take a breath");
        }
        return false;
    }

    private void cacheConflictTask(String str, CheckUrlTask checkUrlTask) {
        if (checkUrlTask == null) {
            return;
        }
        try {
            List<CheckUrlTask> list = this.mPendingTaskMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mPendingTaskMap.put(str, list);
            }
            if (list.contains(checkUrlTask)) {
                return;
            }
            list.add(checkUrlTask);
        } catch (Exception e) {
            e.printStackTrace();
            if (checkUrlTask.getCallback() != null) {
                checkUrlTask.getCallback().onFail(checkUrlTask.getTarget(), "same url invoke multi_times  u should take a breath");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchVerifyResult(CheckUrlTask checkUrlTask, CheckUrlResponse checkUrlResponse, String str) {
        if (checkUrlTask == null) {
            return;
        }
        String buildRecordKey = CheckRecord.buildRecordKey(checkUrlTask.getAid(), checkUrlTask.getScene(), checkUrlTask.getTarget());
        if (TextUtils.isEmpty(buildRecordKey)) {
            return;
        }
        CheckRecord checkRecord = this.mLastCheckRecord;
        if (checkRecord != null) {
            checkRecord.setFinish(true);
            this.mLastCheckRecord.setVerifyResult(checkUrlResponse, str);
        }
        try {
            List<CheckUrlTask> remove = this.mPendingTaskMap.remove(buildRecordKey);
            if (remove == null || remove.size() <= 0) {
                return;
            }
            for (int i = 0; i < remove.size(); i++) {
                CheckUrlTask checkUrlTask2 = remove.get(i);
                if (checkUrlTask2 != null) {
                    try {
                        if (checkUrlTask2.getCallback() != null) {
                            if (checkUrlResponse != null && checkUrlResponse.success()) {
                                checkUrlTask2.getCallback().onSuccess(checkUrlTask.getTarget(), checkUrlResponse);
                            } else {
                                checkUrlTask2.getCallback().onFail(checkUrlTask.getTarget(), str);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Future<CheckUrlResponse> syncCheck(CheckUrlTask checkUrlTask) {
        return SecLinkTaskExecutor.getInstance().submit(new CheckUrlCallable(checkUrlTask));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class CheckUrlCallable extends AbsUrlCall implements Callable<CheckUrlResponse> {
        protected CheckUrlCallable(CheckUrlTask checkUrlTask) {
            super(checkUrlTask);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public CheckUrlResponse call() {
            boolean z;
            boolean z2;
            int i;
            String target = this.task != null ? this.task.getTarget() : "";
            String scene = this.task != null ? this.task.getScene() : "";
            String bizTag = this.task != null ? this.task.getBizTag() : "";
            if (TextUtils.isEmpty(bizTag)) {
                bizTag = SystemUtils.UNKNOWN;
            }
            String str = bizTag;
            if (!CheckUrlSecManager.getInstance().isCheckEnable(this.task)) {
                return new CheckUrlResponse(target);
            }
            CheckUrlResponse validCache = UrlSecLinkCache.getInstance().getValidCache(scene, target);
            if (validCache != null && validCache.success()) {
                ReportUtil.hitCache(target, scene, str, validCache.isNeedShowPage(), "send_http_sync");
            }
            long currentTimeMillis = System.currentTimeMillis();
            String localHost = SecLinkHelper.getLocalHost();
            if (validCache == null || !validCache.success()) {
                try {
                    if (CheckUrlSecManager.netApi == null) {
                        INetApi unused = CheckUrlSecManager.netApi = new DefaultApi();
                    }
                    String execute = CheckUrlSecManager.netApi.execute(getURL(), getTaskInfo());
                    if (!TextUtils.isEmpty(execute)) {
                        try {
                            CheckUrlResponse handleResponseBody = handleResponseBody(target, execute);
                            if (SettingManager.getInstance().useCache()) {
                                UrlSecLinkCache.getInstance().saveCache(this.task.getScene(), this.task.getTarget(), handleResponseBody);
                            }
                            validCache = handleResponseBody;
                        } catch (JSONException e) {
                            CheckUrlResponse checkUrlResponse = new CheckUrlResponse(target);
                            handleFail("source:  " + execute + "  case : " + e.getMessage(), 2);
                            validCache = checkUrlResponse;
                        }
                    } else {
                        handleFail("response body is empty", 1);
                        validCache = new CheckUrlResponse(target);
                    }
                } catch (Exception e2) {
                    validCache = new CheckUrlResponse(target);
                    handleFail(e2.getMessage(), 3);
                    ExceptionUtil.handleException(e2);
                }
            }
            if (validCache == null || !validCache.success()) {
                z = false;
                z2 = false;
                i = 0;
            } else {
                i = validCache.getRisk();
                z2 = validCache.isNeedShowPage();
                z = true;
            }
            ReportUtil.verifyResult(localHost, z, this.task.getScene(), this.task.getTarget(), str, z2, System.currentTimeMillis() - currentTimeMillis, 1, "", i);
            return validCache;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class checkUrlRunnable extends AbsUrlCall implements Runnable {
        protected checkUrlRunnable(CheckUrlTask checkUrlTask) {
            super(checkUrlTask);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            final long currentTimeMillis = System.currentTimeMillis();
            final String bizTag = !TextUtils.isEmpty(this.task.getBizTag()) ? this.task.getBizTag() : SystemUtils.UNKNOWN;
            final String localHost = SecLinkHelper.getLocalHost();
            try {
                CheckUrlResponse validCache = UrlSecLinkCache.getInstance().getValidCache(this.task.getScene(), this.task.getTarget());
                if (validCache == null || !validCache.success()) {
                    if (CheckUrlSecManager.netApi == null) {
                        INetApi unused = CheckUrlSecManager.netApi = new DefaultApi();
                    }
                    str = bizTag;
                    try {
                        CheckUrlSecManager.netApi.post(getURL(), getTaskInfo(), new INetApi.NetListener() { // from class: com.bytedance.webx.seclink.request.CheckUrlSecManager.checkUrlRunnable.1
                            @Override // com.bytedance.webx.seclink.base.INetApi.NetListener
                            public void onSuccess(String str2) {
                                try {
                                    if (TextUtils.isEmpty(str2)) {
                                        checkUrlRunnable.this.handleFail("response body is empty", 1);
                                        ReportUtil.verifyResult(localHost, false, checkUrlRunnable.this.task.getScene(), checkUrlRunnable.this.task.getTarget(), bizTag, false, System.currentTimeMillis() - currentTimeMillis, 0, "json exception", 0);
                                        return;
                                    }
                                    CheckUrlResponse handleResponseBody = checkUrlRunnable.this.handleResponseBody(checkUrlRunnable.this.task.getTarget(), str2);
                                    if (handleResponseBody != null && handleResponseBody.success()) {
                                        if (SettingManager.getInstance().useCache()) {
                                            UrlSecLinkCache.getInstance().saveCache(checkUrlRunnable.this.task.getScene(), checkUrlRunnable.this.task.getTarget(), handleResponseBody);
                                        }
                                        ReportUtil.verifyResult(localHost, true, checkUrlRunnable.this.task.getScene(), checkUrlRunnable.this.task.getTarget(), bizTag, handleResponseBody.isNeedShowPage(), System.currentTimeMillis() - currentTimeMillis, 0, "", handleResponseBody.getRisk());
                                    }
                                    checkUrlRunnable.this.handleSuccess(handleResponseBody);
                                } catch (JSONException e) {
                                    ReportUtil.verifyResult(localHost, false, checkUrlRunnable.this.task.getScene(), checkUrlRunnable.this.task.getTarget(), bizTag, false, System.currentTimeMillis() - currentTimeMillis, 0, "json exception", 0);
                                    checkUrlRunnable.this.handleFail("source:  " + str2 + "  case : " + e.getMessage(), 2);
                                }
                            }

                            @Override // com.bytedance.webx.seclink.base.INetApi.NetListener
                            public void onFail(String str2) {
                                ReportUtil.verifyResult(localHost, false, checkUrlRunnable.this.task.getScene(), checkUrlRunnable.this.task.getTarget(), bizTag, false, System.currentTimeMillis() - currentTimeMillis, 0, str2, 0);
                                checkUrlRunnable.this.handleFail(str2, 1);
                            }
                        });
                        return;
                    } catch (Exception e) {
                        e = e;
                        ReportUtil.verifyResult(localHost, false, this.task.getScene(), this.task.getTarget(), str, false, System.currentTimeMillis() - currentTimeMillis, 0, e.getMessage(), 0);
                        handleFail(e.getMessage(), 3);
                        ExceptionUtil.handleException(e);
                        return;
                    }
                }
                if (this.task.getCallback() != null) {
                    this.task.getCallback().onSuccess(this.task.getTarget(), validCache);
                }
                CheckUrlSecManager.getInstance().dispatchVerifyResult(this.task, validCache, "");
                ReportUtil.hitCache(this.task.getTarget(), this.task.getScene(), bizTag, validCache.isNeedShowPage(), "send_http_async");
                ReportUtil.verifyResult(localHost, true, this.task.getScene(), this.task.getTarget(), bizTag, validCache.isNeedShowPage(), System.currentTimeMillis() - currentTimeMillis, 0, "", validCache.getRisk());
            } catch (Exception e2) {
                e = e2;
                str = bizTag;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class AbsUrlCall {
        static final int ERROR_DATA_FORMAT = 2;
        static final int ERROR_NET_WORK = 1;
        static final int ERROR_OTHER = 3;
        protected final CheckUrlTask task;

        protected AbsUrlCall(CheckUrlTask checkUrlTask) {
            this.task = checkUrlTask;
        }

        protected String getURL() {
            String str;
            if (SecLinkHelper.getLocalHost().endsWith("/")) {
                str = SecLinkHelper.getLocalHost() + "api/verify/v1";
            } else {
                str = SecLinkHelper.getLocalHost() + "/api/verify/v1";
            }
            Map<String, String> commonQueryParam = UrlBuilder.getCommonQueryParam();
            commonQueryParam.put("aid", this.task.getAid());
            String bizTag = this.task.getBizTag();
            if (!TextUtils.isEmpty(bizTag)) {
                commonQueryParam.put("sec_link_biz_tag", bizTag);
            }
            return UrlBuilder.addCommonParam(str, commonQueryParam);
        }

        protected final JSONObject getTaskInfo() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            Map<String, Object> extraInfo = this.task.getExtraInfo();
            if (extraInfo != null && extraInfo.size() > 0) {
                for (String str : extraInfo.keySet()) {
                    Object obj = extraInfo.get(str);
                    if (!TextUtils.isEmpty(str) && obj != null) {
                        jSONObject.put(str, obj);
                    }
                }
            }
            jSONObject.put("aid", this.task.getAid());
            jSONObject.put(ReportUtil.Params.SCENE, this.task.getScene());
            jSONObject.put("ts", this.task.getTs());
            jSONObject.put("target", this.task.getTarget());
            jSONObject.put("sync", this.task.useBizConfig());
            if (this.task.getGrade() < 3) {
                jSONObject.put("flag", true);
            } else {
                jSONObject.put("flag", false);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.task.getAid()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR).append(this.task.getScene()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR).append(this.task.getTarget()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR).append(this.task.getTs()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR).append(this.task.getSalt());
            jSONObject.put("token", MD5Util.getMd5(sb.toString()));
            return jSONObject;
        }

        protected void handleSuccess(CheckUrlResponse checkUrlResponse) {
            if (checkUrlResponse != null && checkUrlResponse.getDuration() > 0) {
                SecLinkFacade.setCacheValidTime(checkUrlResponse.getDuration() * 1000);
            }
            if (this.task.getCallback() != null) {
                this.task.getCallback().onSuccess(this.task.getTarget(), checkUrlResponse);
            }
            CheckUrlSecManager.getInstance().dispatchVerifyResult(this.task, checkUrlResponse, "");
        }

        protected CheckUrlResponse handleResponseBody(String str, String str2) throws JSONException {
            JSONObject jSONObject = new JSONObject(str2);
            CheckUrlResponse checkUrlResponse = new CheckUrlResponse(str);
            checkUrlResponse.setRisk(jSONObject.getInt(ReportUtil.Params.RISK));
            checkUrlResponse.setNeedShowPage(jSONObject.getBoolean(ReportUtil.Params.SHOW_MID_PAGE));
            checkUrlResponse.setDuration(jSONObject.getLong("safe_duration"));
            checkUrlResponse.setShowBanner(jSONObject.optBoolean("show_banner", false));
            checkUrlResponse.setBannerText(jSONObject.optString("banner_text"));
            if (jSONObject.optBoolean("need_update_setting", false)) {
                ReportUtil.startPullSetting(Constants.PULL_SETTING_SCENE_VERSION, "");
                SettingManager.getInstance().updateSetting();
            }
            checkUrlResponse.success(true);
            return checkUrlResponse;
        }

        protected void handleFail(String str, int i) {
            ReportUtil.reportError(ReportUtil.ERROR_TYPE.Other.getType(), -1, str);
            if (this.task.getCallback() != null) {
                this.task.getCallback().onFail(this.task.getTarget(), str);
            }
            CheckUrlSecManager.getInstance().dispatchVerifyResult(this.task, null, str);
            if (1 == i) {
                SettingManager.getInstance().updateVerifyHostIndex();
            }
            if (CheckUrlSecManager.errorNum == 0) {
                int unused = CheckUrlSecManager.errorNum = 1;
                long unused2 = CheckUrlSecManager.errorStartTime = System.currentTimeMillis();
            } else if (CheckUrlSecManager.errorNum < CheckUrlSecManager.maxErrorNum) {
                if (System.currentTimeMillis() - CheckUrlSecManager.errorStartTime >= CheckUrlSecManager.errorDurationTime) {
                    int unused3 = CheckUrlSecManager.errorNum = 1;
                    long unused4 = CheckUrlSecManager.errorStartTime = System.currentTimeMillis();
                } else {
                    CheckUrlSecManager.access$408();
                }
            }
            if (CheckUrlSecManager.errorNum >= CheckUrlSecManager.maxErrorNum) {
                ReportUtil.startPullSetting("shield", "");
                SettingManager.getInstance().updateSetting();
                CheckUrlTask checkUrlTask = this.task;
                String target = checkUrlTask != null ? checkUrlTask.getTarget() : "";
                CheckUrlTask checkUrlTask2 = this.task;
                ReportUtil.shield(target, checkUrlTask2 != null ? checkUrlTask2.getScene() : "", CheckUrlSecManager.maxErrorNum, CheckUrlSecManager.errorDurationTime, CheckUrlSecManager.shieldDurationTime);
                int unused5 = CheckUrlSecManager.errorNum = 0;
                long unused6 = CheckUrlSecManager.errorStartTime = 0L;
                long unused7 = CheckUrlSecManager.shieldStartTime = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DefaultApi implements INetApi {
        private DefaultApi() {
        }

        @Override // com.bytedance.webx.seclink.base.INetApi
        public String execute(String str, JSONObject jSONObject) throws Exception {
            if (TextUtils.isEmpty(str) || jSONObject == null) {
                return "";
            }
            SecLinkVerifyApi secLinkVerifyApi = (SecLinkVerifyApi) RetrofitUtils.createSsService(SettingManager.getInstance().getVerifyHost(), SecLinkVerifyApi.class);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Header("Content-Type", "application/json"));
            return (String) secLinkVerifyApi.executePost(str, new TypedByteArray((String) null, jSONObject.toString().getBytes(Charset.forName(Utf8Charset.NAME)), new String[0]), arrayList).execute().body();
        }

        @Override // com.bytedance.webx.seclink.base.INetApi
        public void post(String str, JSONObject jSONObject, final INetApi.NetListener netListener) {
            SecLinkVerifyApi secLinkVerifyApi = (SecLinkVerifyApi) RetrofitUtils.createSsService(SettingManager.getInstance().getVerifyHost(), SecLinkVerifyApi.class);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Header("Content-Type", "application/json"));
            secLinkVerifyApi.executePost(str, new TypedByteArray((String) null, jSONObject.toString().getBytes(Charset.forName(Utf8Charset.NAME)), new String[0]), arrayList).enqueue(new Callback<String>() { // from class: com.bytedance.webx.seclink.request.CheckUrlSecManager.DefaultApi.1
                public void onResponse(Call<String> call, SsResponse<String> ssResponse) {
                    INetApi.NetListener netListener2 = netListener;
                    if (netListener2 != null) {
                        netListener2.onSuccess(ssResponse != null ? (String) ssResponse.body() : "");
                    }
                }

                public void onFailure(Call<String> call, Throwable th) {
                    INetApi.NetListener netListener2 = netListener;
                    if (netListener2 != null) {
                        netListener2.onFail(th != null ? th.getMessage() : "");
                    }
                }
            });
        }
    }
}
