package com.bytedance.push.monitor;

import android.os.Build;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.push.utils.Singleton;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushSDKMonitor implements ISDKMonitor {
    private static final String AID_SLARDAR = "3405";
    private final Singleton<SDKMonitor> sInst = new Singleton<SDKMonitor>() { // from class: com.bytedance.push.monitor.PushSDKMonitor.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.push.utils.Singleton
        public SDKMonitor create(Object... objArr) {
            SDKMonitorUtils.setDefaultReportUrl(PushSDKMonitor.AID_SLARDAR, Collections.singletonList("https://mon.snssdk.com/monitor/collect/"));
            SDKMonitorUtils.setConfigUrl(PushSDKMonitor.AID_SLARDAR, Collections.singletonList("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));
            return SDKMonitorUtils.getInstance(PushSDKMonitor.AID_SLARDAR);
        }
    };

    @Override // com.bytedance.push.interfaze.ISDKMonitor
    public void ensureNotReachHere(Throwable th) {
    }

    @Override // com.bytedance.push.interfaze.ISDKMonitor
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObject4 = jSONObject == null ? new JSONObject() : jSONObject;
        try {
            jSONObject4.put("ab_tag", PushSetting.getInstance().getPushOnLineSettings().getAbTag());
            jSONObject4.put("brand", Build.BRAND.toLowerCase(Locale.ROOT));
            jSONObject4.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Logger.debug()) {
            JSONObject jSONObject5 = new JSONObject();
            try {
                jSONObject5.put("service_name", str);
                jSONObject5.put("category", jSONObject);
                jSONObject5.put("metric", jSONObject2);
                jSONObject5.put("extra", jSONObject3);
                Logger.m267d(jSONObject5.toString());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.sInst.get(new Object[0]).monitorEvent(str, jSONObject4, jSONObject2, jSONObject3);
    }

    @Override // com.bytedance.push.interfaze.ISDKMonitor
    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        this.sInst.get(new Object[0]).monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
    }

    @Override // com.bytedance.push.interfaze.ISDKMonitor
    public void onUserActive() {
        Configuration configuration = PushSupporter.get().getConfiguration();
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap hashMap = new HashMap();
            PushCommonSetting.getInstance().getSSIDs(hashMap);
            jSONObject.put(CommonConstants.KEY_DID, hashMap.get(CommonConstants.KEY_DID));
            jSONObject.put("host_aid", configuration.mAid);
            jSONObject.put(CommonConstants.SDK_VERSION, "3.9.19-alpha.51");
            jSONObject.put("channel", configuration.mChannel);
            jSONObject.put("app_version", configuration.mVersionName);
            jSONObject.put("update_version_code", configuration.mUpdateVersionCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKMonitorUtils.initMonitor(AppProvider.getApp(), AID_SLARDAR, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.push.monitor.PushSDKMonitor.2
            public String getSessionId() {
                return null;
            }

            public Map<String, String> getCommonParams() {
                Map<String, String> httpCommonParams = UgBusFramework.getService(MessageAppHooks.PushHook.class).getHttpCommonParams();
                httpCommonParams.put("oversea", ViewVisibleBridge.INVISIBLE);
                httpCommonParams.remove(CommonConstants.KEY_AID);
                return httpCommonParams;
            }
        });
    }
}
