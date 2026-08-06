package com.bytedance.push.monitor;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.push.Configuration;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.ss.android.pushmanager.ApiConstants;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushMonitor {
    private static IPushMonitor sMonitor;

    private static IPushMonitor getMonitor() {
        if (sMonitor == null && Configuration.get().mEnableLazy) {
            synchronized (ApiConstants.class) {
                if (sMonitor == null) {
                    sMonitor = Configuration.get().mMonitor;
                }
            }
        }
        return sMonitor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMonitorImpl(IPushMonitor iPushMonitor) {
        sMonitor = iPushMonitor;
    }

    public static void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("is_new_user", Configuration.get().mIsNewUser);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("rom_version", RomVersionParamHelper.getParameter());
            jSONObject.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
            String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
            if (!TextUtils.isEmpty(harmonyOsVersion)) {
                jSONObject.put("extra_rom_version", harmonyOsVersion);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Logger.m268d(IPushService.TAG_PUSH_MONITOR, "serviceName=" + str + ", category=" + jSONObject + ", metric=" + jSONObject2 + ", extraLog=" + jSONObject3);
        if (getMonitor() != null) {
            getMonitor().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        } else {
            Logger.m278w(IPushService.TAG_PUSH_MONITOR, "host monitor impl is null when send event = " + str + " ,it will be report by sdk monitor");
        }
        ((ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class)).monitorEvent(str, copy(jSONObject), copy(jSONObject2), copy(jSONObject3));
    }

    private static JSONObject copy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Looper getLooper() {
        return Looper.getMainLooper();
    }
}
