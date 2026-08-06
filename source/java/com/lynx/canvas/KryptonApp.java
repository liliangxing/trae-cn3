package com.lynx.canvas;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.canvas.callback.FirstOnScreenCanvasFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallbackWrapper;
import com.lynx.canvas.callback.TimeToInteractiveCallback;
import com.lynx.canvas.loader.CanvasResourceLoader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonApp {
    private static final String TAG = "KryptonApp";
    private boolean mBootstrapped;
    private Context mContext;
    private boolean mDestroyed;
    private KryptonFeatureFlag mFeatureFlag;
    private Runnable mFirstOnScreenCanvasFrameCallback;
    private long mNativeHandler;
    private CanvasPermissionManager mPermissionManager;
    private RemoteDelegate mRemoteDelegate;
    private CanvasResourceLoader mResourceLoader;
    private Handler mRuntimeHandler;
    private TimeToInteractiveCallback mTimeToInteractiveCallback;
    private KryptonVSyncMonitor mVSyncMonitor;
    private Map<Class, KryptonService> mServiceMap = new ConcurrentHashMap();
    private Map<Class, KryptonServiceLazyLoader> mServiceLazyLoaderMap = new ConcurrentHashMap();
    private Map<Class, KryptonModule> mModuleMap = new ConcurrentHashMap();
    private long jsEnv = 0;
    private ScriptErrorHandler mUncaughtExceptionHandler = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class KryptonImageData {
        public int height;
        public ByteBuffer pixels;
        public int width;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface RemoteDelegate {
        void bootstrap(KryptonApp kryptonApp, long j);

        String getRemoteHookJS();

        void runBuffer(byte[] bArr, Consumer<byte[]> consumer);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface ScriptErrorHandler {
        void handle(String str);
    }

    private native void nativeBootstrap(long j, long j2);

    private native long nativeCreateInstance(KryptonFeatureFlag kryptonFeatureFlag, CanvasResourceLoader canvasResourceLoader, KryptonVSyncMonitor kryptonVSyncMonitor);

    private native long nativeCreateWeakPtr(long j);

    private native void nativeDestroyInstance(long j);

    private native String nativeGetAndResetPerformanceStatistics(long j);

    private native String nativeGetDrawCallStatistics(long j);

    private native int[] nativeGetSizeFromTheOnlyOneOnScreenCanvas(long j);

    private native void nativeOnHide(long j);

    private native void nativeOnShow(long j);

    private native void nativePause(long j, long j2);

    private native boolean nativeReadPixelsFromTheOnlyOneOnScreenCanvas(long j, ByteBuffer byteBuffer, int i, int i2);

    private native void nativeResume(long j, long j2);

    private native void nativeSetDevicePixelRatio(long j, float f);

    private native void nativeSetEnableDrawCallStatistics(long j, boolean z);

    private native void nativeSetEnablePerformanceStatistics(long j, boolean z);

    private native void nativeSetFirstOnScreenCanvasFrameCallback(long j, FirstOnScreenCanvasFrameCallback firstOnScreenCanvasFrameCallback);

    private native void nativeSetRenderFrameCallback(long j, RenderFrameCallbackWrapper renderFrameCallbackWrapper);

    private native void nativeSetRuntimeTaskRunner(long j, long j2);

    private native void nativeSetTimeToInteractiveCallback(long j, TimeToInteractiveCallback timeToInteractiveCallback);

    private native void nativeSetUncaughtExceptionHandler(long j, long j2);

    public KryptonApp(KryptonFeatureFlag kryptonFeatureFlag, Context context) {
        KryptonLLog.m2561i(TAG, "construct with " + kryptonFeatureFlag);
        this.mFeatureFlag = kryptonFeatureFlag;
        this.mContext = context;
        this.mPermissionManager = new CanvasPermissionManager();
        this.mResourceLoader = new CanvasResourceLoader(this);
        KryptonVSyncMonitor kryptonVSyncMonitor = new KryptonVSyncMonitor(this);
        this.mVSyncMonitor = kryptonVSyncMonitor;
        long nativeCreateInstance = nativeCreateInstance(this.mFeatureFlag, this.mResourceLoader, kryptonVSyncMonitor);
        this.mNativeHandler = nativeCreateInstance;
        if (nativeCreateInstance != 0) {
            nativeSetDevicePixelRatio(nativeCreateInstance, this.mContext.getResources().getDisplayMetrics().density);
        } else {
            KryptonLLog.m2560e(TAG, "construct error! nativeCreateInstance result null");
        }
    }

    protected void finalize() throws Throwable {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2560e(TAG, "Destroy function must be called to prevent native object leakage");
    }

    public <T extends KryptonService> void registerService(Class cls, T t) {
        if (this.mDestroyed) {
            return;
        }
        if (t == null || cls == null) {
            KryptonLLog.m2560e(TAG, "register service failed: empty interface class or service");
            return;
        }
        if (cls.isAssignableFrom(t.getClass())) {
            KryptonLLog.m2561i(TAG, "register " + cls.getName());
            this.mServiceLazyLoaderMap.remove(cls);
            registerServiceAutoBootstrap(cls, t);
        } else {
            if (KryptonServiceLazyLoader.class.isAssignableFrom(t.getClass())) {
                KryptonLLog.m2561i(TAG, "register " + cls.getName() + " lazy loader");
                this.mServiceMap.remove(cls);
                this.mServiceLazyLoaderMap.put(cls, (KryptonServiceLazyLoader) t);
                return;
            }
            KryptonLLog.m2560e(TAG, "register " + cls.getName() + " failed: service class type error");
        }
    }

    private void registerServiceAutoBootstrap(Class cls, final KryptonService kryptonService) {
        this.mServiceMap.put(cls, kryptonService);
        if (this.mRuntimeHandler == null || this.jsEnv == 0) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper.equals(this.mRuntimeHandler.getLooper())) {
            onBootstrapForService(kryptonService);
        } else {
            this.mRuntimeHandler.post(new Runnable() { // from class: com.lynx.canvas.KryptonApp.1
                @Override // java.lang.Runnable
                public void run() {
                    KryptonApp.this.onBootstrapForService(kryptonService);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBootstrapForService(KryptonService kryptonService) {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "run onBootstrap on register service after KryptonApp's bootstrap");
        kryptonService.onBootstrap(this);
    }

    public <T extends KryptonService> T getService(Class<T> cls) {
        if (this.mDestroyed) {
            return null;
        }
        T t = (T) this.mServiceMap.get(cls);
        if (t != null) {
            return t;
        }
        KryptonServiceLazyLoader kryptonServiceLazyLoader = this.mServiceLazyLoaderMap.get(cls);
        if (kryptonServiceLazyLoader == null) {
            return null;
        }
        this.mServiceLazyLoaderMap.remove(cls);
        T t2 = (T) kryptonServiceLazyLoader.createServiceInstance(cls);
        if (t2 == null) {
            KryptonLLog.m2560e(TAG, "lazy load service for " + cls.getName() + " failed");
            return null;
        }
        registerServiceAutoBootstrap(cls, t2);
        KryptonLLog.m2561i(TAG, "lazy load service for " + cls.getName() + " success");
        return t2;
    }

    public void bootstrap(long j) {
        if (this.mBootstrapped) {
            KryptonLLog.m2560e(TAG, "already bootstrapped.");
            return;
        }
        if (this.mDestroyed) {
            return;
        }
        this.jsEnv = j;
        KryptonLLog.m2561i(TAG, "bootstrap.");
        prepareRuntimeHandler();
        long j2 = this.mNativeHandler;
        if (j2 != 0) {
            nativeBootstrap(j2, j);
            if (this.mUncaughtExceptionHandler != null) {
                nativeSetUncaughtExceptionHandler(this.mNativeHandler, this.jsEnv);
            }
        }
        onBootstrap();
    }

    public void bootstrapRemote(RemoteDelegate remoteDelegate) {
        if (remoteDelegate == null) {
            KryptonLLog.m2560e(TAG, "bootstrapRemote failed: remote delegate is null");
            return;
        }
        if (this.mBootstrapped) {
            KryptonLLog.m2560e(TAG, "already bootstrapped.");
            return;
        }
        if (this.mDestroyed) {
            KryptonLLog.m2560e(TAG, "already destroyed.");
            return;
        }
        KryptonLLog.m2561i(TAG, "bootstrap remote.");
        prepareRuntimeHandler();
        this.mRemoteDelegate = remoteDelegate;
        remoteDelegate.bootstrap(this, this.mNativeHandler);
        onBootstrap();
    }

    private void prepareRuntimeHandler() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException("Looper.myLooper() null on bootstrap");
        }
        this.mRuntimeHandler = new Handler(myLooper);
    }

    private void onBootstrap() {
        this.mBootstrapped = true;
        Iterator<KryptonModule> it = this.mModuleMap.values().iterator();
        while (it.hasNext()) {
            it.next().onBootstrap(this);
        }
        Iterator<KryptonService> it2 = this.mServiceMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBootstrap(this);
        }
    }

    public String getRemoteHookJS() {
        RemoteDelegate remoteDelegate = this.mRemoteDelegate;
        if (remoteDelegate == null) {
            KryptonLLog.m2560e(TAG, "getRemoteHookJS failed: remote delegate is null");
            return null;
        }
        return remoteDelegate.getRemoteHookJS();
    }

    public void runBuffer(final byte[] bArr, final Consumer<byte[]> consumer) {
        if (bArr == null || bArr.length == 0) {
            KryptonLLog.m2560e(TAG, "runBuffer failed: data is null");
            return;
        }
        Handler handler = this.mRuntimeHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.lynx.canvas.KryptonApp.2
                @Override // java.lang.Runnable
                public void run() {
                    if (KryptonApp.this.mDestroyed) {
                        return;
                    }
                    if (KryptonApp.this.mRemoteDelegate != null) {
                        KryptonApp.this.mRemoteDelegate.runBuffer(bArr, consumer);
                    } else {
                        KryptonLLog.m2560e(KryptonApp.TAG, "runBuffer failed: remote delegate is null");
                    }
                }
            });
        }
    }

    public void destroy() {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, WebViewContainer.EVENT_destroy);
        this.mDestroyed = true;
        Iterator<KryptonService> it = this.mServiceMap.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mServiceMap.clear();
        Iterator<KryptonModule> it2 = this.mModuleMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onDestroy();
        }
        this.mModuleMap.clear();
        long j = this.mNativeHandler;
        if (j != 0) {
            synchronized (this) {
                this.mNativeHandler = 0L;
            }
            nativeDestroyInstance(j);
        }
        this.jsEnv = 0L;
    }

    public void pause() {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "pause");
        long j = this.mNativeHandler;
        if (j != 0) {
            nativePause(j, this.jsEnv);
        }
        Iterator<KryptonService> it = this.mServiceMap.values().iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
        Iterator<KryptonModule> it2 = this.mModuleMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onPause();
        }
    }

    public void resume() {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "resume");
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeResume(j, this.jsEnv);
        }
        Iterator<KryptonModule> it = this.mModuleMap.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        Iterator<KryptonService> it2 = this.mServiceMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onResume();
        }
    }

    public void onShow() {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "onShow");
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnShow(j);
        }
        Iterator<KryptonModule> it = this.mModuleMap.values().iterator();
        while (it.hasNext()) {
            it.next().onShow();
        }
        Iterator<KryptonService> it2 = this.mServiceMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onShow();
        }
    }

    public void onHide() {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "onHide");
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnHide(j);
        }
        Iterator<KryptonService> it = this.mServiceMap.values().iterator();
        while (it.hasNext()) {
            it.next().onHide();
        }
        Iterator<KryptonModule> it2 = this.mModuleMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onHide();
        }
    }

    public boolean isNativeReady() {
        boolean z;
        synchronized (this) {
            z = this.mNativeHandler != 0;
        }
        return z;
    }

    public long newNativeWeakPtr() {
        long nativeCreateWeakPtr;
        synchronized (this) {
            long j = this.mNativeHandler;
            nativeCreateWeakPtr = j != 0 ? nativeCreateWeakPtr(j) : 0L;
        }
        return nativeCreateWeakPtr;
    }

    public void setRuntimeTaskRunner(long j) {
        long j2 = this.mNativeHandler;
        if (j2 != 0) {
            nativeSetRuntimeTaskRunner(j2, j);
        } else {
            KryptonLLog.m2560e(TAG, "setRuntimeTaskRunner should be called after init");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public CanvasPermissionManager getPermissionManager() {
        return this.mPermissionManager;
    }

    @Deprecated
    public long getJsEnv() {
        return this.jsEnv;
    }

    public void setFirstOnScreenCanvasFrameCallback(Runnable runnable) {
        if (!this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen() && !this.mFeatureFlag.enableFirstFrameCallback()) {
            throw new IllegalStateException("KryptonFeatureFlag isFirstCanvasIsTheOnlyOnScreen and enableFirstFrameCallback is false");
        }
        if (this.mNativeHandler == 0) {
            KryptonLLog.m2560e(TAG, "setFirstOnScreenCanvasFrameCallback but no native handler");
            return;
        }
        this.mFirstOnScreenCanvasFrameCallback = runnable;
        nativeSetFirstOnScreenCanvasFrameCallback(this.mNativeHandler, new FirstOnScreenCanvasFrameCallback() { // from class: com.lynx.canvas.KryptonApp.3
            @Override // com.lynx.canvas.callback.FirstOnScreenCanvasFrameCallback
            public void onFirstFrame() {
                KryptonApp.this.mFirstOnScreenCanvasFrameCallback.run();
            }
        });
    }

    public void setRenderFrameCallback(RenderFrameCallback renderFrameCallback) {
        long j = this.mNativeHandler;
        if (j == 0) {
            KryptonLLog.m2560e(TAG, "setRenderFrameCallback but no native handler");
        } else {
            nativeSetRenderFrameCallback(j, new RenderFrameCallbackWrapper(renderFrameCallback));
        }
    }

    public void setTimeToInteractiveCallback(TimeToInteractiveCallback timeToInteractiveCallback) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long j = this.mNativeHandler;
        if (j == 0) {
            KryptonLLog.m2560e(TAG, "setTimeToInteractiveCallback but no native handler");
            return;
        }
        this.mTimeToInteractiveCallback = timeToInteractiveCallback;
        if (timeToInteractiveCallback == null) {
            KryptonLLog.m2563w(TAG, "setTimeToInteractiveCallback but with null");
        } else {
            nativeSetTimeToInteractiveCallback(j, timeToInteractiveCallback);
        }
    }

    public KryptonImageData screenshot() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long j = this.mNativeHandler;
        if (j == 0) {
            KryptonLLog.m2560e(TAG, "screenshot error without native handler");
            return null;
        }
        int[] nativeGetSizeFromTheOnlyOneOnScreenCanvas = nativeGetSizeFromTheOnlyOneOnScreenCanvas(j);
        if (nativeGetSizeFromTheOnlyOneOnScreenCanvas == null || nativeGetSizeFromTheOnlyOneOnScreenCanvas.length < 2) {
            KryptonLLog.m2563w(TAG, "screenshot get canvas size error");
            return null;
        }
        int i = nativeGetSizeFromTheOnlyOneOnScreenCanvas[0];
        int i2 = nativeGetSizeFromTheOnlyOneOnScreenCanvas[1];
        if (i <= 0 || i2 <= 0) {
            KryptonLLog.m2563w(TAG, "screenshot get canvas size result error: width = " + i + " height = " + i2);
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        if (!nativeReadPixelsFromTheOnlyOneOnScreenCanvas(this.mNativeHandler, allocateDirect, i, i2)) {
            KryptonLLog.m2563w(TAG, "screenshot read pixels error");
            return null;
        }
        KryptonImageData kryptonImageData = new KryptonImageData();
        kryptonImageData.width = i;
        kryptonImageData.height = i2;
        kryptonImageData.pixels = allocateDirect;
        return kryptonImageData;
    }

    private void checkFirstOnScreenCanvasIsTheOnlyOnScreen() {
        if (!this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen()) {
            throw new IllegalStateException("Only supported when KryptonFeatureFlag isFirstOnScreenCanvasIsTheOnlyOnScreen is true.");
        }
    }

    public String getAndResetPerformanceStatistics() {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long j = this.mNativeHandler;
        if (j != 0) {
            return nativeGetAndResetPerformanceStatistics(j);
        }
        KryptonLLog.m2563w(TAG, "native handler null");
        return null;
    }

    public void setEnablePerformanceStatistics(Boolean bool) {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeSetEnablePerformanceStatistics(j, bool.booleanValue());
        } else {
            KryptonLLog.m2563w(TAG, "native handler null");
        }
    }

    private void checkPerformanceStatisticsRelatedFeatureFlags() {
        if (!this.mFeatureFlag.enablePerformanceStatisticsRelatedInterface()) {
            throw new IllegalStateException("Only supported when KryptonFeatureFlag enablePerformanceStatisticsRelatedInterface is true.");
        }
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
    }

    public String getDrawCallStatistics() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long j = this.mNativeHandler;
        if (j != 0) {
            return nativeGetDrawCallStatistics(j);
        }
        KryptonLLog.m2563w(TAG, "native handler null");
        return null;
    }

    public void setEnableDrawCallStatistics(Boolean bool) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeSetEnableDrawCallStatistics(j, bool.booleanValue());
        } else {
            KryptonLLog.m2563w(TAG, "native handler null");
        }
    }

    public void setUncaughtExceptionHandler(ScriptErrorHandler scriptErrorHandler) {
        this.mUncaughtExceptionHandler = scriptErrorHandler;
        long j = this.jsEnv;
        if (j != 0) {
            long j2 = this.mNativeHandler;
            if (j2 != 0) {
                nativeSetUncaughtExceptionHandler(j2, j);
            }
        }
    }

    public KryptonFeatureFlag getFeatureFlag() {
        return this.mFeatureFlag;
    }

    public <T extends KryptonModule> void registerModule(Class cls, final T t) {
        if (this.mDestroyed) {
            return;
        }
        if (t == null || cls == null) {
            throw new IllegalArgumentException("do not support unregister module or register null module");
        }
        if (!cls.isAssignableFrom(t.getClass())) {
            KryptonLLog.m2563w(TAG, "module class type error");
            return;
        }
        KryptonLLog.m2561i(TAG, "register module: " + cls.getName());
        this.mModuleMap.put(cls, t);
        if (this.mRuntimeHandler == null || this.jsEnv == 0) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper.equals(this.mRuntimeHandler.getLooper())) {
            onBootstrapForModule(t);
        } else {
            this.mRuntimeHandler.post(new Runnable() { // from class: com.lynx.canvas.KryptonApp.4
                @Override // java.lang.Runnable
                public void run() {
                    KryptonApp.this.onBootstrapForModule(t);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBootstrapForModule(KryptonModule kryptonModule) {
        if (this.mDestroyed) {
            return;
        }
        KryptonLLog.m2561i(TAG, "run onBootstrap on register module after KryptonApp's bootstrap");
        kryptonModule.onBootstrap(this);
    }

    public <T extends KryptonModule> T getModule(Class<T> cls) {
        if (this.mDestroyed) {
            return null;
        }
        T t = (T) this.mModuleMap.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) KryptonReflectLoader.inst().getModuleDefaultInstance(cls, this);
        if (t2 != null) {
            registerModule(cls, t2);
            KryptonLLog.m2561i(TAG, "get default instance for module " + cls.getName() + " success, auto registered.");
        } else {
            KryptonLLog.m2563w(TAG, "get module " + cls.getName() + " failed");
        }
        return t2;
    }

    private static CanvasVSyncMonitor createCanvasVSyncMonitor(KryptonApp kryptonApp) {
        CanvasVSyncMonitor canvasVSyncMonitor = new CanvasVSyncMonitor();
        canvasVSyncMonitor.setFrameService((KryptonFrameService) kryptonApp.getService(KryptonFrameService.class));
        return canvasVSyncMonitor;
    }

    private void setPreferredFramesPerSecond(int i) {
        KryptonFrameService kryptonFrameService = (KryptonFrameService) getService(KryptonFrameService.class);
        if (kryptonFrameService != null) {
            KryptonLLog.m2561i(TAG, "setPreferredFramesPerSecond " + i);
            kryptonFrameService.setPreferredFramesPerSecond(i);
        }
    }

    private void onUncaughtException(String str) {
        KryptonLLog.m2560e(TAG, "onUncaughtException msg: " + str);
        ScriptErrorHandler scriptErrorHandler = this.mUncaughtExceptionHandler;
        if (scriptErrorHandler != null) {
            scriptErrorHandler.handle(str);
        }
    }

    public void sendToRemoteChannel(String str, long j, String str2, String str3) {
        KryptonRemoteChannelService kryptonRemoteChannelService = (KryptonRemoteChannelService) getService(KryptonRemoteChannelService.class);
        if (kryptonRemoteChannelService != null) {
            kryptonRemoteChannelService.send(str, j, str2, str3);
        } else {
            KryptonLLog.m2563w(TAG, "sendToRemoteChannel failed: channel not registered. class: " + str + ", type: " + str2);
        }
    }
}
