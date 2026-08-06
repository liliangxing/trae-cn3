package com.bytedance.crash.mira;

import org.json.JSONArray;

/* loaded from: classes3.dex */
public class NpthMiraApi {
    static MiraCallbackImpl sMiraCallbackImpl;
    private static boolean sMiraInited;
    private static PluginInfoCallback sPluginInfoCallback;

    /* loaded from: classes3.dex */
    interface MiraCallbackImpl {
        void setMiraCallbackImpl(MiraPluginEventListener miraPluginEventListener);
    }

    /* loaded from: classes3.dex */
    public static class MiraPluginEventListener {
        public void onPluginInstallResult(String str, boolean z) {
        }

        public void onPluginLoaded(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public interface PluginInfoCallback {
        JSONArray getPluginInfo();
    }

    public static void setPluginInfoCallback(PluginInfoCallback pluginInfoCallback) {
        sPluginInfoCallback = pluginInfoCallback;
    }

    public static JSONArray getPluginInfo() {
        PluginInfoCallback pluginInfoCallback = sPluginInfoCallback;
        if (pluginInfoCallback == null) {
            return null;
        }
        try {
            return pluginInfoCallback.getPluginInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean miraInited() {
        return sMiraInited;
    }

    public static void setMiraInited() {
        sMiraInited = true;
    }

    public static void registerMiraCallback(MiraPluginEventListener miraPluginEventListener) {
        MiraCallbackImpl miraCallbackImpl = sMiraCallbackImpl;
        if (miraCallbackImpl != null) {
            try {
                miraCallbackImpl.setMiraCallbackImpl(miraPluginEventListener);
            } catch (Throwable unused) {
            }
        }
    }

    static void setMiraCallbackImpl(MiraCallbackImpl miraCallbackImpl) {
        sMiraCallbackImpl = miraCallbackImpl;
    }
}
