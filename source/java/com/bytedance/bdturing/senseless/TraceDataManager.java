package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.cache.TuringSingleThreadPool;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.senseless.TimeOutWatchDog;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.ttnet.ITuringNetworkCallBack;
import com.bytedance.bdturing.ttnet.TuringCommonRequest;
import com.bytedance.bdturing.utils.EnCryptUtil;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.crash.entity.CrashBody;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TraceDataManager {
    public static final String DATA_TYPE_ASYNC = "async_collect";
    public static final String DATA_TYPE_PRE = "pre_collect";
    private static final String HTTPS_SCHEME = "https://";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String PATH_REPORT = "nocaptcha/report";
    private static volatile TraceDataManager sInstance;
    private long mAsyncCollectStartTime;
    private int mAsyncReportRetryNum;
    private int mPreReportRetryNum;
    private String mReportUrl;
    private TimeOutWatchDog mTouchEventDog;
    private long mTouchEventTimeOut;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface NoCaptchaVerifyCallBack {
        void onFail(int i, JSONObject jSONObject);

        void onNetWorkError(int i, JSONObject jSONObject);

        void onSuccess(int i, JSONObject jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface VerifyResultCallBack {
        void onFail(int i, JSONObject jSONObject);

        void onSuccess(int i, JSONObject jSONObject);
    }

    static /* synthetic */ int access$308(TraceDataManager traceDataManager) {
        int i = traceDataManager.mPreReportRetryNum;
        traceDataManager.mPreReportRetryNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$508(TraceDataManager traceDataManager) {
        int i = traceDataManager.mAsyncReportRetryNum;
        traceDataManager.mAsyncReportRetryNum = i + 1;
        return i;
    }

    private TraceDataManager() {
    }

    public static TraceDataManager getInstance() {
        if (sInstance == null) {
            synchronized (TraceDataManager.class) {
                sInstance = new TraceDataManager();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DataUploadTask implements Runnable {
        private NoCaptchaVerifyCallBack callback;
        private String detail;
        private String mReportType;
        private String mSubTYpe;
        private long mTs;

        public DataUploadTask(String str, long j, String str2, String str3, NoCaptchaVerifyCallBack noCaptchaVerifyCallBack) {
            this.mSubTYpe = str;
            this.mTs = j;
            this.mReportType = str2;
            this.detail = str3;
            this.callback = noCaptchaVerifyCallBack;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CpuReportEvent.PERF_DATA_TYPE, this.mReportType);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CrashBody.LAUNCH_TIME, EventReport.sAppLaunchTime);
                jSONObject2.put("is_back_ground", PageTracer.getInstance().isBackGround());
                long currentTimeMillis = System.currentTimeMillis() - EventReport.sAppLaunchTime;
                jSONObject2.put("runtime", currentTimeMillis);
                BdTuringConfig config = BdTuring.getInstance().getConfig();
                Activity topActivity = config != null ? config.getTopActivity() : null;
                if (topActivity != null) {
                    jSONObject2.put("page_id", topActivity.getClass().getName());
                }
                JSONArray pageHistory = PageTracer.getInstance().getPageHistory();
                jSONObject2.put("page_history", pageHistory);
                jSONObject2.put("page_profile", PageTracer.getInstance().getPageProfile());
                jSONObject2.put("first_touch_event", PageTracer.getInstance().getFirstTouchEvent());
                JSONArray touchEvent = PageTracer.getInstance().getTouchEvent();
                jSONObject2.put("touch_event", touchEvent);
                if (TraceDataManager.DATA_TYPE_ASYNC.equals(this.mReportType)) {
                    pageHistory = touchEvent;
                }
                Map<String, Long> processData = TraceDataProcessor.processData(currentTimeMillis, pageHistory, this.mSubTYpe, this.mReportType);
                for (String str : processData.keySet()) {
                    jSONObject2.put(str, processData.get(str));
                }
                jSONObject.put(SettingsManager.COMMON_SERVICE, jSONObject2);
                jSONObject.put("data_profile", PageTracer.getInstance().getDataProfile());
                jSONObject.put("sdk_runtime_info", PageTracer.getInstance().getRuntimeInfo());
                jSONObject.put("nocaptcha", NoCaptchaSetting.noCaptchaCfg());
                if (TraceDataManager.DATA_TYPE_ASYNC.equals(this.mReportType)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("async_touch_event_start_time", this.mTs);
                    jSONObject.put("async_collect_data", jSONObject3);
                }
                String mD5Hex = EnCryptUtil.getMD5Hex(this.detail);
                String aesEncrypt = EnCryptUtil.aesEncrypt(jSONObject.toString(), mD5Hex);
                if (!TextUtils.isEmpty(mD5Hex) && !TextUtils.isEmpty(aesEncrypt)) {
                    String reportUrl = TraceDataManager.getInstance().getReportUrl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("detail", this.detail);
                    hashMap.put("subtype", this.mSubTYpe);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("data", aesEncrypt);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("Content-Type", "application/json; charset=utf-8");
                    TuringCommonRequest turingCommonRequest = new TuringCommonRequest(reportUrl, hashMap, hashMap2, hashMap3);
                    EventReport.reportNoCaptchaData(SenselessVerifyService.getInstance().getRiskRequest());
                    turingCommonRequest.doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.DataUploadTask.1
                        @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                        public void onResponse(CommonResponse commonResponse) {
                            int i;
                            if (commonResponse.code == 200) {
                                if (DataUploadTask.this.callback != null) {
                                    DataUploadTask.this.callback.onSuccess(0, null);
                                    return;
                                }
                                return;
                            }
                            if (DataUploadTask.this.callback != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                JsonUtils.putValue(jSONObject4, "message", commonResponse.message);
                                JsonUtils.putValue(jSONObject4, "sec_message", commonResponse.sec_message);
                                JSONObject jSONObject5 = new JSONObject();
                                if (commonResponse.code == 201) {
                                    String optString = commonResponse.data.optString("decision");
                                    try {
                                        jSONObject5.put("detail", new JSONObject(optString).optString("detail"));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    JsonUtils.putValue(jSONObject4, "decision", optString);
                                    JsonUtils.putValue(jSONObject4, "query", jSONObject5);
                                    i = 10;
                                } else {
                                    i = 1;
                                }
                                DataUploadTask.this.callback.onFail(i, jSONObject4);
                            }
                        }

                        @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                        public void onError(Throwable th) {
                            if (DataUploadTask.this.callback != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                JsonUtils.putValue(jSONObject4, "errorMsg", "net work error:" + th);
                                DataUploadTask.this.callback.onNetWorkError(1, jSONObject4);
                            }
                        }
                    });
                    return;
                }
                if (this.callback != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("errorMsg", "params error");
                    this.callback.onNetWorkError(-1, jSONObject4);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.callback != null) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("error", e.getMessage());
                        this.callback.onNetWorkError(1, jSONObject5);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void startAsyncReport(final String str, final String str2, final VerifyResultCallBack verifyResultCallBack) {
        this.mTouchEventTimeOut = NoCaptchaSetting.asyncCollectTimeOut();
        TimeOutWatchDog timeOutWatchDog = this.mTouchEventDog;
        if (timeOutWatchDog != null) {
            timeOutWatchDog.cancel();
        }
        TimeOutWatchDog timeOutWatchDog2 = new TimeOutWatchDog(new TimeOutWatchDog.Listener() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.1
            @Override // com.bytedance.bdturing.senseless.TimeOutWatchDog.Listener
            public void onTimeOut() {
                TraceDataManager.this.uploadAsyncCollectData(str, str2, verifyResultCallBack);
            }
        });
        this.mTouchEventDog = timeOutWatchDog2;
        timeOutWatchDog2.start(this.mTouchEventTimeOut);
        this.mAsyncCollectStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReportUrl() {
        if (TextUtils.isEmpty(this.mReportUrl)) {
            String host = SettingsManager.INSTANCE.getHost(SettingsManager.VERIFY_SERVICE);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(host)) {
                if (!host.startsWith("https://")) {
                    sb.append("https://");
                }
                sb.append(host);
                if (!host.endsWith("/")) {
                    sb.append("/");
                }
            }
            this.mReportUrl = sb.append(PATH_REPORT).toString();
        }
        return this.mReportUrl;
    }

    public void reportPreCollectData(final String str, final String str2, final VerifyResultCallBack verifyResultCallBack) {
        this.mPreReportRetryNum = 0;
        reportPreCollectDataInner(str, str2, new NoCaptchaVerifyCallBack() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.2
            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onSuccess(int i, JSONObject jSONObject) {
                VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                if (verifyResultCallBack2 != null) {
                    verifyResultCallBack2.onSuccess(i, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onFail(int i, JSONObject jSONObject) {
                VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                if (verifyResultCallBack2 != null) {
                    verifyResultCallBack2.onFail(i, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onNetWorkError(int i, JSONObject jSONObject) {
                TraceDataManager.access$308(TraceDataManager.this);
                if (TraceDataManager.this.mPreReportRetryNum < 3) {
                    EventReport.sendRequestRetry(SenselessVerifyService.getInstance().getRiskRequest(), TraceDataManager.PATH_REPORT, TraceDataManager.this.mPreReportRetryNum, TraceDataManager.DATA_TYPE_PRE, jSONObject != null ? jSONObject.toString() : "");
                    TraceDataManager.this.reportPreCollectDataInner(str, str2, this, 1000L);
                } else {
                    VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                    if (verifyResultCallBack2 != null) {
                        verifyResultCallBack2.onFail(i, jSONObject);
                    }
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPreCollectDataInner(final String str, final String str2, final NoCaptchaVerifyCallBack noCaptchaVerifyCallBack, long j) {
        if (j > 0) {
            if (VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.3
                @Override // java.lang.Runnable
                public void run() {
                    TuringSingleThreadPool.getInstance().execute(new DataUploadTask(str, System.currentTimeMillis(), TraceDataManager.DATA_TYPE_PRE, str2, noCaptchaVerifyCallBack));
                }
            }, j) || noCaptchaVerifyCallBack == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "taskEnqueue fail");
            noCaptchaVerifyCallBack.onFail(1, jSONObject);
            return;
        }
        TuringSingleThreadPool.getInstance().execute(new DataUploadTask(str, System.currentTimeMillis(), DATA_TYPE_PRE, str2, noCaptchaVerifyCallBack));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadAsyncCollectData(final String str, final String str2, final VerifyResultCallBack verifyResultCallBack) {
        TimeOutWatchDog timeOutWatchDog = this.mTouchEventDog;
        if (timeOutWatchDog != null) {
            timeOutWatchDog.cancel();
        }
        this.mAsyncReportRetryNum = 0;
        reportAsyncData(str, str2, new NoCaptchaVerifyCallBack() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.4
            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onSuccess(int i, JSONObject jSONObject) {
                VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                if (verifyResultCallBack2 != null) {
                    verifyResultCallBack2.onSuccess(i, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onFail(int i, JSONObject jSONObject) {
                VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                if (verifyResultCallBack2 != null) {
                    verifyResultCallBack2.onFail(i, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.NoCaptchaVerifyCallBack
            public void onNetWorkError(int i, JSONObject jSONObject) {
                TraceDataManager.access$508(TraceDataManager.this);
                if (TraceDataManager.this.mAsyncReportRetryNum < 3) {
                    EventReport.sendRequestRetry(SenselessVerifyService.getInstance().getRiskRequest(), TraceDataManager.PATH_REPORT, TraceDataManager.this.mAsyncReportRetryNum, TraceDataManager.DATA_TYPE_ASYNC, jSONObject != null ? jSONObject.toString() : "");
                    TraceDataManager.this.reportAsyncData(str, str2, this, 1000L);
                } else {
                    VerifyResultCallBack verifyResultCallBack2 = verifyResultCallBack;
                    if (verifyResultCallBack2 != null) {
                        verifyResultCallBack2.onFail(i, jSONObject);
                    }
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAsyncData(final String str, final String str2, final NoCaptchaVerifyCallBack noCaptchaVerifyCallBack, long j) {
        if (j > 0) {
            if (VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.senseless.TraceDataManager.5
                @Override // java.lang.Runnable
                public void run() {
                    TuringSingleThreadPool.getInstance().execute(new DataUploadTask(str, TraceDataManager.this.mAsyncCollectStartTime, TraceDataManager.DATA_TYPE_ASYNC, str2, noCaptchaVerifyCallBack));
                }
            }, j) || noCaptchaVerifyCallBack == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "taskEnqueue fail");
            noCaptchaVerifyCallBack.onFail(1, jSONObject);
            return;
        }
        TuringSingleThreadPool.getInstance().execute(new DataUploadTask(str, this.mAsyncCollectStartTime, DATA_TYPE_ASYNC, str2, noCaptchaVerifyCallBack));
    }
}
