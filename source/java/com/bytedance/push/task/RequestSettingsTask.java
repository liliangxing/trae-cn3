package com.bytedance.push.task;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.UiAdaptationUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestSettingsTask implements Runnable {
    private static final String TAG = "RequestSettingsTask";
    private static final Object lock = new Object();
    private final String KEY_CALLER_NAME = "caller_name";
    private final String KEY_DEVICE_PLATFORM = CommonConstants.KEY_DEVICE_PLATFORM;
    private boolean mAutoRequestSettings;
    private boolean mForceRequestSettings;
    private List<String> mNeedRequestSdk;
    private boolean mSynchronous;

    public RequestSettingsTask(boolean z, boolean z2) {
        this.mAutoRequestSettings = z;
        this.mForceRequestSettings = z2;
    }

    public RequestSettingsTask(boolean z, boolean z2, List<String> list, boolean z3) {
        this.mAutoRequestSettings = z;
        this.mForceRequestSettings = z2;
        this.mNeedRequestSdk = list;
        this.mSynchronous = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Application app;
        Map<String, String> commonParams;
        synchronized (lock) {
            try {
                app = AppProvider.getApp();
                if (!this.mForceRequestSettings) {
                    boolean z = this.mAutoRequestSettings;
                    if (!z && PushServiceManager.get().getIPermissionBootExternalService().sdkNeedRequestSettings()) {
                        Logger.m268d(TAG, "set allow sdk request to true because PermissionBootExternalService");
                        if (this.mNeedRequestSdk == null) {
                            ArrayList arrayList = new ArrayList();
                            this.mNeedRequestSdk = arrayList;
                            arrayList.add("PushSDK");
                        }
                        z = true;
                    }
                    if (!z) {
                        Logger.m268d(TAG, "sdk not request because allowRequest is false");
                        return;
                    }
                    Logger.m268d(TAG, "allow request is true,mAutoRequestSettings:" + this.mAutoRequestSettings);
                    if (!checkFrequency()) {
                        Logger.m268d(TAG, "RequestSettingsTask checkFrequency false");
                        return;
                    }
                } else {
                    Logger.m268d(TAG, "request now because mForceRequestSettings is true");
                }
                commonParams = PushSupporter.get().getCommonParams();
            } catch (Exception e) {
                Logger.m271e(TAG, "RequestSettingsTask parse failed：" + Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(commonParams.get(CommonConstants.KEY_DID))) {
                Logger.m268d(TAG, "RequestSettingsTask device_id is empty");
                return;
            }
            commonParams.putAll(UiAdaptationUtils.buildUiAdaptationParams(app));
            String str = commonParams.get("version_code");
            String str2 = commonParams.get("update_version_code");
            String str3 = commonParams.get("channel");
            List<String> list = this.mNeedRequestSdk;
            if (list == null) {
                requestSettings(app, "PushSDK", commonParams);
                requestSettings(app, "alliance_sdk", commonParams);
            } else {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    requestSettings(app, it.next(), commonParams);
                }
            }
            LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(app, LocalFrequencySettings.class);
            localFrequencySettings.setLastRequestSettingsTime(System.currentTimeMillis());
            localFrequencySettings.setLastRequestSettingsVersionCode(str);
            localFrequencySettings.setLastRequestSettingsUpdateVersionCode(str2);
            localFrequencySettings.setLastRequestSettingsChannel(str3);
        }
    }

    private void requestSettings(Context context, String str, Map<String, String> map) throws Exception {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("caller_name", str);
        map.put(CommonConstants.KEY_DEVICE_PLATFORM, "android");
        String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getRequestSettingsUrl(), map);
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = true;
        String str2 = PushNetworkClient.getDefault().get(addUrlParam, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
        JSONObject jSONObject = new JSONObject(str2);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (!TextUtils.equals(optString, "success") || optJSONObject == null) {
            return;
        }
        Logger.m268d(TAG, "auto updateSettings resp for " + str + ":" + str2);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(ErrorType.SETTINGS);
        if (this.mSynchronous) {
            UpdateSettingsTask.updateSettingsSynchronous(context, optJSONObject2, PushSupporter.get().getConfiguration().mIsPreInstallVersion, UpdateSettingsTask.UPDATE_SOURCE_SDK);
        } else {
            UpdateSettingsTask.updateSettings(context, optJSONObject2, PushSupporter.get().getConfiguration().mIsPreInstallVersion, UpdateSettingsTask.UPDATE_SOURCE_SDK);
        }
    }

    private boolean checkFrequency() {
        Application app = AppProvider.getApp();
        PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(app, PushOnlineSettings.class);
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(app, LocalFrequencySettings.class);
        long requestSettingsInterval = pushOnlineSettings.getRequestSettingsInterval();
        long lastRequestSettingsTime = localFrequencySettings.getLastRequestSettingsTime();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - lastRequestSettingsTime > requestSettingsInterval;
        Map<String, String> commonParams = PushSupporter.get().getCommonParams();
        String str = commonParams.get("version_code");
        String str2 = commonParams.get("update_version_code");
        String str3 = commonParams.get("channel");
        String lastRequestSettingsVersionCode = localFrequencySettings.getLastRequestSettingsVersionCode();
        String lastRequestSettingsUpdateVersionCode = localFrequencySettings.getLastRequestSettingsUpdateVersionCode();
        String lastRequestSettingsChannel = localFrequencySettings.getLastRequestSettingsChannel();
        Logger.m268d(TAG, "frequency = " + z + " lastRequestSettingsTime =" + lastRequestSettingsTime + " currentTimeMillis = " + currentTimeMillis + " requestSettingsInterval = " + requestSettingsInterval + " versionCode：" + str + " lastVersionCode：" + lastRequestSettingsVersionCode + " updateVersionCode：" + str2 + " lastUpdateVersionCode：" + lastRequestSettingsUpdateVersionCode + " channel：" + str3 + " lastChannel：" + lastRequestSettingsChannel);
        return (!z && TextUtils.equals(str, lastRequestSettingsVersionCode) && TextUtils.equals(str2, lastRequestSettingsUpdateVersionCode) && TextUtils.equals(str3, lastRequestSettingsChannel)) ? false : true;
    }
}
