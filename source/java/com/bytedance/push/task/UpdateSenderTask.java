package com.bytedance.push.task;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.frontier.setting.FrontierLocalSetting;
import com.bytedance.push.interfaze.ISenderService;
import com.bytedance.push.model.PushNotificationChannel;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UpdateSenderTask {
    private static final String TAG = "UpdateSenderTask";
    private volatile AtomicBoolean hasRegisteredWithLastChannels = new AtomicBoolean(false);
    private volatile boolean hasRequestedUpdateSender;
    private final ISenderService mSenderService;

    public UpdateSenderTask(ISenderService iSenderService) {
        this.mSenderService = iSenderService;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0187 A[Catch: all -> 0x0358, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x0042, B:9:0x011c, B:10:0x0143, B:12:0x0151, B:14:0x0157, B:16:0x015d, B:18:0x0163, B:20:0x0169, B:29:0x0187, B:31:0x018d, B:33:0x0197, B:62:0x02da, B:64:0x02de, B:65:0x02e8, B:78:0x0315, B:80:0x0342, B:82:0x0348, B:86:0x0353, B:89:0x016f), top: B:3:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0342 A[Catch: all -> 0x0358, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x0042, B:9:0x011c, B:10:0x0143, B:12:0x0151, B:14:0x0157, B:16:0x015d, B:18:0x0163, B:20:0x0169, B:29:0x0187, B:31:0x018d, B:33:0x0197, B:62:0x02da, B:64:0x02de, B:65:0x02e8, B:78:0x0315, B:80:0x0342, B:82:0x0348, B:86:0x0353, B:89:0x016f), top: B:3:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0353 A[Catch: all -> 0x0358, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x0042, B:9:0x011c, B:10:0x0143, B:12:0x0151, B:14:0x0157, B:16:0x015d, B:18:0x0163, B:20:0x0169, B:29:0x0187, B:31:0x018d, B:33:0x0197, B:62:0x02da, B:64:0x02de, B:65:0x02e8, B:78:0x0315, B:80:0x0342, B:82:0x0348, B:86:0x0353, B:89:0x016f), top: B:3:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void runTasks(boolean z) {
        String str;
        boolean z2;
        boolean z3;
        HashMap hashMap;
        Application application;
        Application app = AppProvider.getApp();
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(app, LocalFrequencySettings.class);
        PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(app, PushOnlineSettings.class);
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        long lastUpdateSenderTime = localFrequencySettings.getLastUpdateSenderTime();
        boolean z4 = Math.abs(currentTimeMillis - lastUpdateSenderTime) < pushOnlineSettings.getUpdateSenderIntervalTimeInMs();
        String lastUpdateSenderDid = localFrequencySettings.getLastUpdateSenderDid();
        String lastUpdateSenderVersionCode = localFrequencySettings.getLastUpdateSenderVersionCode();
        String lastUpdateSenderUpdateVersionCode = localFrequencySettings.getLastUpdateSenderUpdateVersionCode();
        String lastUpdateSenderChannel = localFrequencySettings.getLastUpdateSenderChannel();
        String lastUpdateSenderAlias = localFrequencySettings.getLastUpdateSenderAlias();
        Map<String, String> commonParams = PushSupporter.get().getCommonParams();
        String str2 = commonParams.get(CommonConstants.KEY_DID);
        String str3 = commonParams.get("version_code");
        String str4 = commonParams.get("update_version_code");
        String str5 = commonParams.get("channel");
        String str6 = commonParams.get("alias");
        Logger.m274i(TAG, "handleAppLogUpdate requestFrequent=" + z4 + ",lastDeviceId=" + lastUpdateSenderDid + ",deviceId=" + str2 + ",lastVersionCode=" + lastUpdateSenderVersionCode + ",versionCode=" + str3 + ",lastUpdateVersionCode=" + lastUpdateSenderUpdateVersionCode + ",updateVersionCode=" + str4 + ",lastChannel=" + lastUpdateSenderChannel + ",channel=" + str5 + ",lastAlias=" + lastUpdateSenderAlias + ",alias=" + str6 + ",forceUpdate=" + z);
        if (z4) {
            str = lastUpdateSenderAlias;
            Logger.m274i(TAG, "requestFrequent is true,current=" + currentTimeMillis + ",lastTime=" + lastUpdateSenderTime);
        } else {
            str = lastUpdateSenderAlias;
        }
        boolean isSenderChanged = this.mSenderService.isSenderChanged(app);
        if (TextUtils.equals(lastUpdateSenderDid, str2) && TextUtils.equals(lastUpdateSenderVersionCode, str3) && TextUtils.equals(lastUpdateSenderUpdateVersionCode, str4) && TextUtils.equals(lastUpdateSenderChannel, str5) && ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str6)) || TextUtils.equals(str, str6))) {
            z2 = false;
            if (z4 && !z2 && !isSenderChanged) {
                z3 = false;
                if ((!z3 && !this.hasRequestedUpdateSender) || z) {
                    ITracingMonitor iTracingMonitor = (ITracingMonitor) UgBusFramework.getService(ITracingMonitor.class);
                    if (iTracingMonitor != null) {
                        iTracingMonitor.startRequestSender();
                    }
                    try {
                        commonParams.put(SccResult.LABEL_NOTICE, PushSetting.getInstance().isPushNotifyEnable() ? ViewVisibleBridge.INVISIBLE : "1");
                        commonParams.put("system_notify_status", ToolUtils.areNotificationsEnabled(AppProvider.getApp()) + "");
                        if (!TextUtils.isEmpty(str6)) {
                            commonParams.put("device_login_id", str6);
                        }
                        String str7 = "";
                        try {
                            if (ToolUtils.isHuaweiDevice()) {
                                str7 = AppProvider.getApp().getPackageManager().getPackageInfo("com.huawei.android.pushagent", 0).versionName;
                            } else if (ToolUtils.isOppoDevice()) {
                                str7 = AppProvider.getApp().getPackageManager().getPackageInfo("com.heytap.mcs", 0).versionName;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            Logger.m272e(TAG, "error when parse push service version ", th);
                        }
                        Logger.m268d(TAG, "sysPushVersion:" + str7);
                        if (!TextUtils.isEmpty(str7)) {
                            commonParams.put("sys_push_version", str7);
                        }
                        String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getUpdateSenderUrl(), commonParams);
                        ArrayList arrayList = new ArrayList();
                        String jSONArray = PushChannelHelper.inst(app).buildApplogHeader().toString();
                        arrayList.add(new Pair("push_sdk", jSONArray));
                        arrayList.add(new Pair("live_activity_oem_version", ToolUtils.getFocusPermissionVersion(app)));
                        String launchActivity = ToolUtils.getLaunchActivity(app);
                        if (!TextUtils.isEmpty(launchActivity)) {
                            arrayList.add(new Pair("launcher", launchActivity));
                        }
                        Logger.m274i("Start", "start request sender. support ：" + jSONArray + ", " + addUrlParam);
                        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
                        reqContext.addCommonParams = false;
                        String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
                        Logger.m268d("Start", "UpdateSenderTask response = " + post);
                        application = app;
                        try {
                            parseResponse(post, app, jSONArray, str2, str3, str4, str5, str6);
                            this.hasRequestedUpdateSender = true;
                        } catch (Throwable th2) {
                            th = th2;
                            doWithRequestFailed(application, 301, th instanceof CommonHttpException ? ((CommonHttpException) th).getResponseCode() : -100, th.getMessage(), Log.getStackTraceString(th));
                            Logger.m271e("Start", "run: UPDATE_SENDER_URL e = " + th.getMessage());
                            th.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        application = app;
                    }
                } else {
                    hashMap = new HashMap();
                    PushCommonSetting.getInstance().getSSIDs(hashMap);
                    if ((!StringUtils.isEmpty((String) hashMap.get("clientudid")) || StringUtils.isEmpty((String) hashMap.get(CommonConstants.KEY_DID)) || StringUtils.isEmpty((String) hashMap.get("install_id"))) ? false : true) {
                        tryRegisterWithLastValidChannels(app);
                    }
                }
            }
            z3 = true;
            if (!z3) {
            }
            hashMap = new HashMap();
            PushCommonSetting.getInstance().getSSIDs(hashMap);
            if ((!StringUtils.isEmpty((String) hashMap.get("clientudid")) || StringUtils.isEmpty((String) hashMap.get(CommonConstants.KEY_DID)) || StringUtils.isEmpty((String) hashMap.get("install_id"))) ? false : true) {
            }
        }
        z2 = true;
        if (z4) {
            z3 = false;
            if (!z3) {
            }
            hashMap = new HashMap();
            PushCommonSetting.getInstance().getSSIDs(hashMap);
            if ((!StringUtils.isEmpty((String) hashMap.get("clientudid")) || StringUtils.isEmpty((String) hashMap.get(CommonConstants.KEY_DID)) || StringUtils.isEmpty((String) hashMap.get("install_id"))) ? false : true) {
            }
        }
        z3 = true;
        if (!z3) {
        }
        hashMap = new HashMap();
        PushCommonSetting.getInstance().getSSIDs(hashMap);
        if ((!StringUtils.isEmpty((String) hashMap.get("clientudid")) || StringUtils.isEmpty((String) hashMap.get(CommonConstants.KEY_DID)) || StringUtils.isEmpty((String) hashMap.get("install_id"))) ? false : true) {
        }
    }

    private void parseResponse(String str, Application application, String str2, String str3, String str4, String str5, String str6, String str7) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            doWithRequestFailed(application, 304, -1, null, str);
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (!TextUtils.equals("success", jSONObject.optString("message"))) {
            doWithRequestFailed(application, 302, -1, null, str);
            return;
        }
        PushSupporter.get().setFrontierSetting(jSONObject.optJSONObject(FrontierLocalSetting.KEY_FRONTIER_SETTING));
        parseChannels(application, jSONObject.optJSONArray("channels"));
        String optString = jSONObject.optString("allow_push_list");
        if (TextUtils.isEmpty(optString)) {
            doWithRequestFailed(application, 303, -1, null, str);
            return;
        }
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(application, LocalFrequencySettings.class);
        localFrequencySettings.setLastUpdateSenderTime(ToolUtils.currentTimeMillis());
        localFrequencySettings.setLastUpdateSenderDid(str3);
        localFrequencySettings.setLastUpdateSenderVersionCode(str4);
        localFrequencySettings.setLastUpdateSenderUpdateVersionCode(str5);
        localFrequencySettings.setLastUpdateSenderUpdateChannel(str6);
        localFrequencySettings.setSupportSender(str2);
        localFrequencySettings.setLastUpdateSenderAlias(str7);
        boolean z = false;
        try {
            if (new JSONArray(optString).length() > 0) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!z) {
            doWithRequestFailed(application, 303, -1, null, str);
        } else {
            PushSupporter.monitor().markUpdateSenderSuccess();
        }
        this.hasRegisteredWithLastChannels.set(true);
        tryRegisterAllSelectedPush(AppProvider.getApp(), optString, true);
    }

    private void parseChannels(Application application, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("name");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    arrayList.add(new PushNotificationChannel(jSONObject));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        PushSupporter.get().getNotificationService().createChannels(application, arrayList);
    }

    private void tryRegisterAllSelectedPush(Context context, String str, boolean z) {
        ITracingMonitor iTracingMonitor = (ITracingMonitor) UgBusFramework.getService(ITracingMonitor.class);
        if (iTracingMonitor != null) {
            iTracingMonitor.startSenderCheck(str, z);
        }
        boolean hasSupportChannel = PushChannelHelper.inst(context).hasSupportChannel(str);
        Logger.m274i("Start", "tryRegisterServerPush " + str + " hasSupport = " + hasSupportChannel);
        boolean z2 = false;
        if (z && !hasSupportChannel) {
            str = PushSetting.getInstance().getPushChannelsJsonArray();
            if (!PushChannelHelper.inst(context).hasSupportChannel(str)) {
                PushSupporter.monitor().monitorSenderSupport(false, str);
                if (iTracingMonitor != null) {
                    iTracingMonitor.endSenderCheck(str, false);
                    return;
                }
                return;
            }
        }
        Logger.m274i("Start", "tryRegisterAllSelectedPush: the senders = " + str);
        if (z && hasSupportChannel) {
            z2 = true;
        }
        PushChannelHelper.handlerApplogConfig(str, z2);
        if (iTracingMonitor != null) {
            iTracingMonitor.endSenderCheck(str, true);
        }
        PushSupporter.monitor().monitorSenderSupport(this.mSenderService.registerAllSender(context), str);
    }

    private void doWithRequestFailed(Context context, int i, int i2, String str, String str2) {
        PushSupporter.monitor().markUpdateSenderFailed(i, i2, str, str2);
        Logger.m271e("Start", "request UPDATE_SENDER_URL failed: " + str2);
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (i == 301) {
            if (pushCommonConfiguration.mIsDebugMode && pushCommonConfiguration.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError()) {
                throw new RuntimeException("error when request /cloudpush/update_sender/ , please check whether to configure TLB, url is " + MessageConstants.getUpdateSenderUrl());
            }
            Logger.m271e(TAG, "error when request /cloudpush/update_sender/ , please check whether to configure TLB, url is " + MessageConstants.getUpdateSenderUrl());
        }
        tryRegisterWithLastValidChannels(context);
    }

    private void tryRegisterWithLastValidChannels(Context context) {
        if (this.hasRegisteredWithLastChannels.compareAndSet(false, true)) {
            tryRegisterAllSelectedPush(context, PushSetting.getInstance().getPushChannelsJsonArray(), false);
        }
    }
}
