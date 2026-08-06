package com.lynx.canvas;

import com.lynx.canvas.KryptonPluginLoaderService;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PluginLoaderWrapper {
    private static final String TAG = "PluginLoaderWrapper";

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnFinishCallback(long j, String str, boolean z, String str2, String str3);

    public static void preloadPlugin(KryptonApp kryptonApp, long j, String str) {
        KryptonPluginLoaderService kryptonPluginLoaderService = (KryptonPluginLoaderService) kryptonApp.getService(KryptonPluginLoaderService.class);
        if (kryptonPluginLoaderService == null) {
            boolean postLoadPluginSuccess = postLoadPluginSuccess(kryptonApp, str, null);
            String str2 = postLoadPluginSuccess ? "plugin loader service not exits, default return success" : "post load plugin failed";
            KryptonLLog.m2563w(TAG, str2);
            nativeOnFinishCallback(j, str, postLoadPluginSuccess, str2, "");
            return;
        }
        KryptonLLog.m2561i(TAG, "loading plugin " + str + " async ...");
        kryptonPluginLoaderService.loadPluginAsync(str, new KryptonPluginLoaderService.Callback(j, str, new WeakReference(kryptonApp), kryptonPluginLoaderService) { // from class: com.lynx.canvas.PluginLoaderWrapper.1
            private long mSavedCallback;
            final /* synthetic */ long val$callback;
            final /* synthetic */ KryptonPluginLoaderService val$loader;
            final /* synthetic */ String val$pluginName;
            final /* synthetic */ WeakReference val$weakApp;

            {
                this.val$callback = j;
                this.val$pluginName = str;
                this.val$weakApp = r4;
                this.val$loader = kryptonPluginLoaderService;
                this.mSavedCallback = j;
            }

            @Override // com.lynx.canvas.KryptonPluginLoaderService.Callback
            public void onFinish(boolean z, String str3) {
                String str4;
                String str5;
                long j2 = this.mSavedCallback;
                if (j2 == 0) {
                    KryptonLLog.m2560e(PluginLoaderWrapper.TAG, "loading plugin " + this.val$pluginName + " callback more than once. ");
                    return;
                }
                this.mSavedCallback = 0L;
                KryptonApp kryptonApp2 = (KryptonApp) this.val$weakApp.get();
                if (kryptonApp2 == null) {
                    KryptonLLog.m2561i(PluginLoaderWrapper.TAG, "app has been released");
                    return;
                }
                if (z) {
                    String pluginPath = this.val$loader.getPluginPath(this.val$pluginName);
                    boolean postLoadPluginSuccess2 = PluginLoaderWrapper.postLoadPluginSuccess(kryptonApp2, this.val$pluginName, pluginPath);
                    if (!postLoadPluginSuccess2) {
                        str3 = "post load plugin failed";
                    }
                    str4 = str3;
                    str5 = pluginPath;
                    z = postLoadPluginSuccess2;
                } else {
                    str4 = str3;
                    str5 = null;
                }
                if (z) {
                    KryptonLLog.m2561i(PluginLoaderWrapper.TAG, "loading plugin " + this.val$pluginName + " success, path:" + str5);
                    PluginLoaderWrapper.nativeOnFinishCallback(j2, this.val$pluginName, true, "success", str5);
                } else {
                    KryptonLLog.m2560e(PluginLoaderWrapper.TAG, "loading plugin " + this.val$pluginName + " error :" + str4);
                    PluginLoaderWrapper.nativeOnFinishCallback(j2, this.val$pluginName, false, str4, "");
                }
            }
        });
    }

    public static boolean preloadPluginSync(KryptonApp kryptonApp, String str) {
        KryptonPluginLoaderService kryptonPluginLoaderService = (KryptonPluginLoaderService) kryptonApp.getService(KryptonPluginLoaderService.class);
        if (kryptonPluginLoaderService == null) {
            KryptonLLog.m2560e(TAG, "plugin loader service not exits, default return true on sync load");
            return true;
        }
        if (!kryptonPluginLoaderService.loadPluginSync(str)) {
            return false;
        }
        KryptonLLog.m2561i(TAG, "plugin " + str + " load sync success ");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean postLoadPluginSuccess(KryptonApp kryptonApp, String str, String str2) {
        KryptonAudioModule kryptonAudioModule;
        if (KryptonRTCModule.moduleName().equals(str)) {
            KryptonRTCModule kryptonRTCModule = (KryptonRTCModule) kryptonApp.getModule(KryptonRTCModule.class);
            if (kryptonRTCModule != null) {
                return kryptonRTCModule.load(str2);
            }
            return true;
        }
        if (!KryptonAudioModule.moduleName().equals(str) || (kryptonAudioModule = (KryptonAudioModule) kryptonApp.getModule(KryptonAudioModule.class)) == null) {
            return true;
        }
        return kryptonAudioModule.loadAudioModule() && kryptonAudioModule.loadAudioEffectModule(str2);
    }

    public static boolean loadModuleService(KryptonApp kryptonApp, String str) {
        if (KryptonAudioModule.moduleName().equals(str)) {
            KryptonAudioModule kryptonAudioModule = (KryptonAudioModule) kryptonApp.getModule(KryptonAudioModule.class);
            if (kryptonAudioModule != null) {
                return kryptonAudioModule.loadAudioModule();
            }
            KryptonLLog.m2563w(TAG, "no audio module found for " + str);
            return false;
        }
        if (KryptonRTCModule.moduleName().equals(str)) {
            KryptonRTCModule kryptonRTCModule = (KryptonRTCModule) kryptonApp.getModule(KryptonRTCModule.class);
            if (kryptonRTCModule != null) {
                return kryptonRTCModule.load(null);
            }
            KryptonLLog.m2563w(TAG, "no rtc module found for " + str);
            return false;
        }
        if (KryptonVECameraModule.moduleName().equals(str)) {
            KryptonVECameraModule kryptonVECameraModule = (KryptonVECameraModule) kryptonApp.getModule(KryptonVECameraModule.class);
            if (kryptonVECameraModule != null) {
                return kryptonVECameraModule.load(null);
            }
            KryptonLLog.m2563w(TAG, "no ve-camera module found for " + str);
            return false;
        }
        KryptonLLog.m2563w(TAG, "no module for " + str);
        return false;
    }
}
