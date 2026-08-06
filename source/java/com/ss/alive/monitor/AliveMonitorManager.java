package com.ss.alive.monitor;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.Logger;
import com.ss.alive.monitor.MonitorLiveSetting;
import com.ss.alive.monitor.hook.ActivityThreadHookHelper;
import com.ss.alive.monitor.p002db.MonitorLiveDBHelperDBHelper;
import com.ss.alive.monitor.p002db.ProcessStartDbInfo;
import com.ss.alive.monitor.track.ActivityAliveTracker;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AliveMonitorManager {
    private static final int FLAG_ERROR = 4;
    private static final int FLAG_INSTALL_AND_ACTIVE = 0;
    private static final int FLAG_INSTALL_AND_NOT_ACTIVE = 1;
    private static final int FLAG_NOT_INSTALL = 2;
    private static final int FLAG_NO_DATA_DIR = 5;
    private static final int FLAG_NO_PERMISSIONS = 3;
    private static final int FLAG_NO_SDCARD_DIR = 6;
    private static final String TAG = "AliveMonitorManager";
    private static volatile AliveMonitorManager sAliveMonitorManager;
    private boolean isFirstProcess;
    private final ActivityAliveTracker mActivityAliveTracker;
    private ActivityThreadHandler mActivityThreadHandler;
    private Application mContext;
    private ExclusiveFileLock mFileLock = new ExclusiveFileLock("process.lock");
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public void init() {
    }

    public static AliveMonitorManager inst(Context context) {
        if (sAliveMonitorManager == null) {
            synchronized (AliveMonitorManager.class) {
                if (sAliveMonitorManager == null) {
                    sAliveMonitorManager = new AliveMonitorManager(context);
                }
            }
        }
        return sAliveMonitorManager;
    }

    private AliveMonitorManager(Context context) {
        if (context instanceof Application) {
            this.mContext = (Application) context;
        } else {
            this.mContext = (Application) context.getApplicationContext();
        }
        this.isFirstProcess = this.mFileLock.isFirstLockFile(this.mContext);
        ActivityAliveTracker activityAliveTracker = new ActivityAliveTracker(this.mContext, this.isFirstProcess);
        this.mActivityAliveTracker = activityAliveTracker;
        activityAliveTracker.monitorFirstActivity();
    }

    public void hookActivityThread() {
        ActivityThreadHookHelper.inst(this.mContext).hook(getActivityThreadHandler());
    }

    public void hookActivityThread(Context context) {
        hookActivityThread();
    }

    public void handActivityThreadMessage(Message message) {
        getActivityThreadHandler().handleMessage(message);
    }

    public ActivityThreadHandler getActivityThreadHandler() {
        if (this.mActivityThreadHandler == null) {
            this.mActivityThreadHandler = new ActivityThreadHandler(this.mContext, this.mActivityAliveTracker);
        }
        return this.mActivityThreadHandler;
    }

    public List<ProcessStartDbInfo> getProcessStartDbInfoList() {
        return MonitorLiveDBHelperDBHelper.getInstance(this.mContext).getProcessStartDbInfoList(0L, MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().maxSendStartInfoNum);
    }

    public boolean isFirstProcess() {
        return this.isFirstProcess;
    }

    public synchronized void startMonitorLiveTime() {
        MonitorLiveTimeHelper.inst(this.mContext).startMonitorLiveTime();
    }

    public void sendMonitorData() {
        Logger.d(TAG, "sendMonitorData called");
        sendMonitorData(TimeUnit.SECONDS.toMillis(15L));
    }

    public void sendMonitorData(long j) {
        Logger.d(TAG, "sendMonitorDataInternal after " + j + " mill");
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.alive.monitor.AliveMonitorManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AliveMonitorManager.this.sendMonitorDataInternal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMonitorDataInternal() {
        boolean z = MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().isMonitorAliveEnable;
        Logger.d(TAG, "sendMonitorDataInternal,isMonitorAliveEnable is  " + z);
        if (z) {
            long longValue = MonitorLiveSetting.getInstance(this.mContext).getLastSendDatdaTime().longValue();
            int sendDataIntervalSecond = MonitorLiveSetting.getInstance(this.mContext).getSendDataIntervalSecond();
            long currentTimeMillis = ToolUtils.currentTimeMillis();
            if ((currentTimeMillis - longValue) / 1000 < sendDataIntervalSecond) {
                Logger.d(TAG, "sendMonitorDataInternal,do nothing because frequency, lastSendTime is " + longValue + " currentTimeMillis is " + currentTimeMillis + " sendInterval is " + sendDataIntervalSecond);
            } else {
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.AliveMonitorManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            List<ProcessStartDbInfo> processStartDbInfoList = AliveMonitorManager.this.getProcessStartDbInfoList();
                            Logger.e(AliveMonitorManager.TAG, "run: processStartDbInfos = " + processStartDbInfoList);
                            if (processStartDbInfoList.size() <= 1) {
                                Logger.d(AliveMonitorManager.TAG, "not request because processStartDbInfos.size() is  " + processStartDbInfoList.size());
                                return;
                            }
                            JSONArray jSONArray = new JSONArray();
                            if (processStartDbInfoList != null && processStartDbInfoList.size() > 1) {
                                for (int i = 0; i < processStartDbInfoList.size() - 1; i++) {
                                    ProcessStartDbInfo processStartDbInfo = processStartDbInfoList.get(i);
                                    JSONObject jSONObject = new JSONObject(processStartDbInfo.dataJson);
                                    jSONObject.put("end_time", processStartDbInfo.endTime);
                                    jSONArray.put(jSONObject);
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("launches", jSONArray);
                            try {
                                AliveMonitorManager.this.tryAddUnActiveApps(jSONObject2);
                            } catch (Throwable th) {
                                Logger.d(AliveMonitorManager.TAG, th.getMessage(), th);
                            }
                            Logger.e(AliveMonitorManager.TAG, "run: jsonObject = " + jSONObject2);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new Pair("data", jSONObject2.toString()));
                            String str = AliveMonitorConstant.REPORT_URL;
                            Map<String, String> httpCommonParams = MessageAppHooks.getPushHook().getHttpCommonParams();
                            httpCommonParams.put("invoke_mode", ToolUtils.isApplicationForeground(AliveMonitorManager.this.mContext, AliveMonitorManager.this.mContext.getPackageName()) ? "0" : PushClient.DEFAULT_REQUEST_ID);
                            httpCommonParams.put("disable_local_push", PushServiceManager.get().getPullExternalService().isUseNewOnlineLocalPushApi() ? PushClient.DEFAULT_REQUEST_ID : "0");
                            if (Logger.debug()) {
                                httpCommonParams.put("debug_mode", "true");
                                httpCommonParams.put("invoke_mode", PushClient.DEFAULT_REQUEST_ID);
                            }
                            httpCommonParams.put("local_push", MonitorLiveSetting.getInstance(AliveMonitorManager.this.mContext).isLocalPushEnable() ? PushClient.DEFAULT_REQUEST_ID : "0");
                            String addUrlParam = ToolUtils.addUrlParam(str, httpCommonParams);
                            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
                            reqContext.addCommonParams = false;
                            String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader(null), reqContext);
                            if (Logger.debug()) {
                                Logger.d(AliveMonitorManager.TAG, "doInBackground: response = " + post);
                            }
                            if (StringUtils.isEmpty(post)) {
                                return;
                            }
                            MonitorLiveSetting.getInstance(AliveMonitorManager.this.mContext).setLastSendDatdaTime(ToolUtils.currentTimeMillis());
                            try {
                                JSONObject jSONObject3 = new JSONObject(post);
                                if (jSONObject3.optInt(MonitorConstants.CODE, -1) == 0) {
                                    if (processStartDbInfoList != null && processStartDbInfoList.size() > 1) {
                                        for (int i2 = 0; i2 < processStartDbInfoList.size() - 1; i2++) {
                                            MonitorLiveDBHelperDBHelper.getInstance(AliveMonitorManager.this.mContext).deleteProcessStartDbInfo(processStartDbInfoList.get(i2).f31id);
                                        }
                                    }
                                    int optInt = jSONObject3.optInt("next_interval");
                                    if (optInt > 0) {
                                        MonitorLiveSetting.getInstance(AliveMonitorManager.this.mContext).setSendDataIntervalSecond(optInt);
                                    }
                                    LocalPushHelper.handlerSendMonitorResponse(AliveMonitorManager.this.mContext, jSONObject3);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void localPush() {
        if (MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().isMonitorAliveEnable) {
            Logger.d(TAG, "localPush() called");
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.AliveMonitorManager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        List<ProcessStartDbInfo> processStartDbInfoList = AliveMonitorManager.this.getProcessStartDbInfoList();
                        if (Logger.debug()) {
                            Logger.e(AliveMonitorManager.TAG, "run: processStartDbInfos = " + processStartDbInfoList);
                        }
                        JSONArray jSONArray = new JSONArray();
                        if (processStartDbInfoList.size() > 1 && processStartDbInfoList != null && processStartDbInfoList.size() > 1) {
                            for (int i = 0; i < processStartDbInfoList.size() - 1; i++) {
                                ProcessStartDbInfo processStartDbInfo = processStartDbInfoList.get(i);
                                JSONObject jSONObject = new JSONObject(processStartDbInfo.dataJson);
                                jSONObject.put("end_time", processStartDbInfo.endTime);
                                jSONArray.put(jSONObject);
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("launches", jSONArray);
                        try {
                            AliveMonitorManager.this.tryAddUnActiveApps(jSONObject2);
                        } catch (Throwable th) {
                            Logger.d(AliveMonitorManager.TAG, th.getMessage(), th);
                        }
                        Logger.d(AliveMonitorManager.TAG, "run: jsonObject = " + jSONObject2);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new Pair("data", jSONObject2.toString()));
                        String str = AliveMonitorConstant.REPORT_URL;
                        Map<String, String> httpCommonParams = MessageAppHooks.getPushHook().getHttpCommonParams();
                        httpCommonParams.put("invoke_mode", ToolUtils.isApplicationForeground(AliveMonitorManager.this.mContext, AliveMonitorManager.this.mContext.getPackageName()) ? "0" : PushClient.DEFAULT_REQUEST_ID);
                        if (Logger.debug()) {
                            httpCommonParams.put("debug_mode", "true");
                            httpCommonParams.put("invoke_mode", PushClient.DEFAULT_REQUEST_ID);
                        }
                        httpCommonParams.put("local_push", PushClient.DEFAULT_REQUEST_ID);
                        String addUrlParam = ToolUtils.addUrlParam(str, httpCommonParams);
                        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
                        reqContext.addCommonParams = false;
                        String post = NetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader(null), reqContext);
                        if (Logger.debug()) {
                            Logger.d(AliveMonitorManager.TAG, "doInBackground: response = " + post);
                        }
                        if (StringUtils.isEmpty(post)) {
                            return;
                        }
                        MonitorLiveSetting.getInstance(AliveMonitorManager.this.mContext).setLastSendDatdaTime(ToolUtils.currentTimeMillis());
                        try {
                            JSONObject jSONObject3 = new JSONObject(post);
                            if (jSONObject3.optInt(MonitorConstants.CODE, -1) == 0) {
                                if (processStartDbInfoList != null && processStartDbInfoList.size() > 1) {
                                    for (int i2 = 0; i2 < processStartDbInfoList.size() - 1; i2++) {
                                        MonitorLiveDBHelperDBHelper.getInstance(AliveMonitorManager.this.mContext).deleteProcessStartDbInfo(processStartDbInfoList.get(i2).f31id);
                                    }
                                }
                                int optInt = jSONObject3.optInt("next_interval");
                                if (optInt > 0) {
                                    MonitorLiveSetting.getInstance(AliveMonitorManager.this.mContext).setSendDataIntervalSecond(optInt);
                                }
                                LocalPushHelper.handlerSendMonitorResponse(AliveMonitorManager.this.mContext, jSONObject3);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryAddUnActiveApps(JSONObject jSONObject) {
        MonitorLiveSetting.ConfigModel monitorAliveConfigModel;
        List<String> list;
        JSONArray installAndUnActiveAppPackages;
        if (jSONObject == null || (monitorAliveConfigModel = MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel()) == null || !monitorAliveConfigModel.isMonitorAliveEnable || !monitorAliveConfigModel.enableUploadActiveApps || (list = monitorAliveConfigModel.uploadActiveAppPackages) == null || list.size() <= 0 || (installAndUnActiveAppPackages = getInstallAndUnActiveAppPackages(list)) == null || installAndUnActiveAppPackages.length() == 0) {
            return;
        }
        try {
            jSONObject.put("unactive_apps", installAndUnActiveAppPackages);
        } catch (Exception e) {
            Logger.d(TAG, e.getMessage(), e);
        }
    }

    private JSONArray getInstallAndUnActiveAppPackages(List<String> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            int isPackageInstallAndNotActive = isPackageInstallAndNotActive(str);
            if (Logger.debug()) {
                Logger.d(TAG, "check app :" + str + " active : " + isPackageInstallAndNotActive);
            }
            int appLastCheckStatus = MonitorLiveSetting.getInstance(this.mContext).getAppLastCheckStatus(str);
            MonitorLiveSetting.getInstance(this.mContext).setAppLastCheckStatus(str, isPackageInstallAndNotActive);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.PACKAGE_NAME, str);
                jSONObject.put("pre_status", appLastCheckStatus);
                jSONObject.put("cur_status", isPackageInstallAndNotActive);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                Logger.d(TAG, e.getMessage(), e);
            }
        }
        return jSONArray;
    }

    private int isPackageInstallAndNotActive(String str) {
        if (TextUtils.isEmpty(str) || this.mContext == null) {
            return 4;
        }
        try {
            if (!isAppInstalled(str)) {
                if (!Logger.debug()) {
                    return 2;
                }
                Logger.d(TAG, "package : " + str + " not installed");
                return 2;
            }
            File dataFileDir = getDataFileDir();
            if (dataFileDir == null) {
                return 5;
            }
            if (new File(new File(dataFileDir, str), "databases").exists()) {
                return 0;
            }
            File sdcardAppFileDir = getSdcardAppFileDir();
            if (sdcardAppFileDir == null) {
                return 6;
            }
            return new File(sdcardAppFileDir, str).exists() ? 0 : 1;
        } catch (Exception e) {
            Logger.d(TAG, e.getMessage(), e);
            return 4;
        }
    }

    private File getSdcardAppFileDir() {
        File externalCacheDir;
        File parentFile;
        Application application = this.mContext;
        if (application == null || (externalCacheDir = application.getExternalCacheDir()) == null || (parentFile = externalCacheDir.getParentFile()) == null) {
            return null;
        }
        return parentFile.getParentFile();
    }

    private File getDataFileDir() {
        File cacheDir;
        File parentFile;
        Application application = this.mContext;
        if (application == null || (cacheDir = application.getCacheDir()) == null || (parentFile = cacheDir.getParentFile()) == null) {
            return null;
        }
        return parentFile.getParentFile();
    }

    private boolean isAppInstalled(String str) {
        if (this.mContext == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.mContext.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public void addBlackListActivity(String str) {
        com.ss.alive.monitor.util.ToolUtils.addBlackListActivity(str);
    }
}
