package com.lynx.canvas;

import android.content.Context;
import com.lynx.canvas.Krypton;
import com.lynx.canvas.KryptonFeatureFlag;
import com.lynx.canvas.callback.RenderFrameCallback;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.krypton.ICanvasManager;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.EnvUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CanvasManager extends ICanvasManager {
    private static final String TAG = "KryptonCanvasManager";
    private static boolean sIsAudioForceUseAdaptiveSampler = false;
    private static boolean sIsEventReportEnabled = false;
    private static boolean sIsSettingsCached = false;
    private static boolean sIsUseAurumAudioEngine = true;
    private Context mContext;
    private KryptonApp mKryptonApp;
    private LynxKryptonDefaultServiceLazyLoader mServiceLazyLoader;
    private String mTemporaryDirectory;

    private native long nativeGetLogFunctionPtr();

    private static native void nativeRegisterTraceFunc();

    public void onRuntimeMediatorDestroy() {
    }

    public CanvasManager() {
        initJavaLoggerForKrypton();
        if (Krypton.inst().hasInitialized()) {
            return;
        }
        Krypton.inst().init(null, LynxEnv.inst().getAppContext());
    }

    public boolean init(LynxContext lynxContext) {
        if (!tryLoadLynxKryptonSo()) {
            LLog.m2577e(TAG, "Load lynx_krypton.so failed !");
            return false;
        }
        registerLogFunc();
        this.mContext = lynxContext.getApplicationContext();
        this.mKryptonApp = createKryptonApp();
        LynxKryptonDefaultServiceLazyLoader lynxKryptonDefaultServiceLazyLoader = new LynxKryptonDefaultServiceLazyLoader(lynxContext);
        this.mServiceLazyLoader = lynxKryptonDefaultServiceLazyLoader;
        lynxKryptonDefaultServiceLazyLoader.registerToKryptonApp(this.mKryptonApp);
        LLog.m2578i(TAG, "Canvas manager init success");
        return true;
    }

    private boolean tryLoadLynxKryptonSo() {
        if (!Krypton.inst().hasInitialized()) {
            LLog.m2577e(TAG, "Krypton not initialized, Ensure that the host has added the krypton AAR dependency and current device supports OpenGL ES3.0 .");
            return false;
        }
        try {
            if (LynxEnv.inst().getLibraryLoader() != null) {
                LynxEnv.inst().getLibraryLoader().loadLibrary("lynx_krypton");
                LLog.m2578i(TAG, "lynx_krypton.so loaded via library loader");
                return true;
            }
            System.loadLibrary("lynx_krypton");
            LLog.m2578i(TAG, "lynx_krypton.so loaded via system loader");
            return true;
        } catch (ExceptionInInitializerError unused) {
            LLog.m2577e(TAG, "lynx_krypton.so load failed! Ensure that the host has added the krypton-lynx AAR dependency.");
            return false;
        }
    }

    private void registerLogFunc() {
        Krypton.inst().nativeRegisterLogger("Lynx", nativeGetLogFunctionPtr());
        if (TraceEvent.enableTrace()) {
            LLog.m2578i(TAG, "now in lynx debugmode, load trace func");
            nativeRegisterTraceFunc();
        }
    }

    public void registerCanvasBehavior(BehaviorRegistry behaviorRegistry) {
        boolean z = false;
        behaviorRegistry.addBehavior(new Behavior("canvas", z) { // from class: com.lynx.canvas.CanvasManager.1
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                try {
                    return new UICanvas(lynxContext, obj);
                } catch (Throwable th) {
                    LLog.m2577e(CanvasManager.TAG, "canvas init error" + th.toString());
                    return null;
                }
            }
        });
        behaviorRegistry.addBehavior(new Behavior("canvas-ng", z) { // from class: com.lynx.canvas.CanvasManager.2
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                try {
                    return new UICanvas(lynxContext, obj);
                } catch (Throwable th) {
                    LLog.m2577e(CanvasManager.TAG, "canvas-ng createUI error" + th.toString());
                    return null;
                }
            }
        });
        behaviorRegistry.addBehavior(new Behavior("surface-canvas-experiment", z) { // from class: com.lynx.canvas.CanvasManager.3
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                try {
                    return new UISurfaceCanvas(lynxContext, obj);
                } catch (Throwable th) {
                    LLog.m2577e(CanvasManager.TAG, "surface-canvas createUI error" + th.toString());
                    return null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LynxKryptonJavaLogger implements Krypton.IKryptonJavaLogger {
        private LynxKryptonJavaLogger() {
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        /* renamed from: v */
        public void mo2557v(String str, String str2) {
            LLog.m2579v(str, str2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        /* renamed from: d */
        public void mo2554d(String str, String str2) {
            LLog.m2576d(str, str2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        /* renamed from: i */
        public void mo2556i(String str, String str2) {
            LLog.m2578i(str, str2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        /* renamed from: w */
        public void mo2558w(String str, String str2) {
            LLog.m2580w(str, str2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        /* renamed from: e */
        public void mo2555e(String str, String str2) {
            LLog.m2577e(str, str2);
        }
    }

    private void initJavaLoggerForKrypton() {
        Krypton.inst().registerLogger("Lynx", new LynxKryptonJavaLogger());
    }

    public void deInit() {
        LLog.m2578i(TAG, "Canvas manager deInit ");
    }

    public long newNativeCanvasAppWeakPtr() {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            return kryptonApp.newNativeWeakPtr();
        }
        return 0L;
    }

    public KryptonApp getKryptonApp() {
        return this.mKryptonApp;
    }

    public boolean isNativeCanvasAppReady() {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            return kryptonApp.isNativeReady();
        }
        return false;
    }

    private void makeSureSettingsCached() {
        if (sIsSettingsCached || LynxServiceCenter.inst().getService(ILynxTrailService.class) == null) {
            return;
        }
        sIsEventReportEnabled = LynxSettingsUtils.booleanValueForKey("krypton_enable_event_report", false);
        sIsUseAurumAudioEngine = LynxSettingsUtils.booleanValueForKey("krypton_use_aurum_audio_engine", true);
        sIsAudioForceUseAdaptiveSampler = LynxSettingsUtils.booleanValueForKey("krypton_audio_force_use_adaptive_sampler", false);
        sIsSettingsCached = true;
    }

    private KryptonApp createKryptonApp() {
        makeSureSettingsCached();
        KryptonFeatureFlag.Builder builder = new KryptonFeatureFlag.Builder();
        builder.setEnableSar(true);
        builder.setUseVsyncMonitorFromService(false);
        builder.setEnableEventReport(sIsEventReportEnabled);
        builder.setUseAurumAudioEngine(sIsUseAurumAudioEngine);
        builder.setAudioForceUseAdaptiveSampler(sIsAudioForceUseAdaptiveSampler);
        return new KryptonApp(builder.build(), this.mContext);
    }

    public void registerService(Class<?> cls, Object obj) {
        if (!(obj instanceof KryptonService)) {
            LLog.m2577e(TAG, "register service class error");
            return;
        }
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp == null) {
            LLog.m2577e(TAG, "register service failed : canvas app is null");
        } else {
            kryptonApp.registerService(cls, (KryptonService) obj);
        }
    }

    public void setTemporaryDirectory(String str) {
        this.mTemporaryDirectory = str;
        LynxKryptonDefaultServiceLazyLoader lynxKryptonDefaultServiceLazyLoader = this.mServiceLazyLoader;
        if (lynxKryptonDefaultServiceLazyLoader != null) {
            lynxKryptonDefaultServiceLazyLoader.setTemporaryDirectory(str);
        } else {
            LLog.m2577e(TAG, "setTemporaryDirectory should be called after init");
        }
    }

    public String getTemporaryDirectory() {
        String str = this.mTemporaryDirectory;
        if (str != null && str.length() > 0) {
            return this.mTemporaryDirectory;
        }
        return EnvUtils.getCacheDir();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class KryptonRenderFrameCallbackWrapper implements RenderFrameCallback {
        private final com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback mCallback;

        KryptonRenderFrameCallbackWrapper(com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback renderFrameCallback) {
            this.mCallback = renderFrameCallback;
        }

        @Override // com.lynx.canvas.callback.RenderFrameCallback
        public void onFrameRender(String str, long j, long j2) {
            this.mCallback.onFrameRender(str, j, j2);
        }
    }

    public void setRenderFrameCallback(com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback renderFrameCallback) {
        this.mKryptonApp.setRenderFrameCallback(new KryptonRenderFrameCallbackWrapper(renderFrameCallback));
    }

    public void onRuntimeInit(long j) {
        LLog.m2578i(TAG, "CanvasManager runtime init");
    }

    public void setTaskRunner(long j) {
        this.mKryptonApp.setRuntimeTaskRunner(j);
    }

    public void onRuntimeMediatorReady(long j) {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp == null) {
            return;
        }
        kryptonApp.registerService(KryptonFrameService.class, new LynxKryptonFrameService(j));
    }

    public void onNapiEnvReady(long j) {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            kryptonApp.bootstrap(j);
        }
    }

    public void onRuntimeDetach() {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            kryptonApp.destroy();
            this.mKryptonApp = null;
        }
    }

    public void onAppEnterBackground() {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            kryptonApp.onHide();
        }
    }

    public void onAppEnterForeground() {
        KryptonApp kryptonApp = this.mKryptonApp;
        if (kryptonApp != null) {
            kryptonApp.onShow();
        }
    }
}
