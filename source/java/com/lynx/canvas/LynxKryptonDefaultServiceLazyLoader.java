package com.lynx.canvas;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaMetadataRetriever;
import com.lynx.canvas.camera.KryptonDefaultCamera;
import com.lynx.canvas.hardware.KryptonDefaultSensorService;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.lynx.canvas.telemetry.KryptonTelemetryService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxSystemInvokeService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.EnvUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class LynxKryptonDefaultServiceLazyLoader extends KryptonServiceLazyLoader {
    private static final String TAG = "LynxKryptonDefaultServiceLazyLoader";
    private static String mEnableUsingGenericFetcherInCanvasKey = "lynx_canvas_enable_using_generic_fetcher";
    private final Context mApplicationContext;
    private KryptonLoaderService mCurrentLoaderService;
    private final WeakReference<LynxContext> mLynxContext;
    private String mTemporaryDirectory;

    static /* synthetic */ KryptonDefaultCamera.Invoker access$100() {
        return createCameraInvoker();
    }

    static /* synthetic */ KryptonDefaultMediaRecorder.Invoker access$300() {
        return createMediaRecorderInvoker();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxKryptonDefaultServiceLazyLoader(LynxContext lynxContext) {
        this.mLynxContext = new WeakReference<>(lynxContext);
        this.mApplicationContext = lynxContext.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTemporaryDirectory(String str) {
        this.mTemporaryDirectory = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerToKryptonApp(KryptonApp kryptonApp) {
        kryptonApp.registerService(KryptonLoaderService.class, this);
        kryptonApp.registerService(KryptonCameraService.class, this);
        kryptonApp.registerService(KryptonMediaRecorderService.class, this);
        kryptonApp.registerService(KryptonSettingsService.class, this);
        kryptonApp.registerService(KryptonSensorService.class, this);
        kryptonApp.registerService(KryptonTelemetryService.class, this);
    }

    boolean usingGenericFetcherInCanvas() {
        LynxContext lynxContext = this.mLynxContext.get();
        return (!LynxSettingsUtils.booleanValueForKey(mEnableUsingGenericFetcherInCanvasKey, false) || lynxContext.getGenericResourceFetcher() == null || lynxContext.getMediaResourceFetcher() == null) ? false : true;
    }

    @Override // com.lynx.canvas.KryptonServiceLazyLoader
    public <T extends KryptonService> T createServiceInstance(Class<T> cls) {
        if (cls == KryptonLoaderService.class) {
            if (usingGenericFetcherInCanvas()) {
                LLog.m2578i(TAG, "Krypton using Lynx generic fetcher to load canvas resources.");
                this.mCurrentLoaderService = new LynxKryptonLoaderServiceImpl(this.mLynxContext);
            } else {
                LLog.m2578i(TAG, "Krypton using resource fetcher to load canvas resources.");
                this.mCurrentLoaderService = new CanvasLoaderService(this.mLynxContext);
            }
            return this.mCurrentLoaderService;
        }
        if (cls == KryptonCameraService.class) {
            return new KryptonCameraService() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.1
                @Override // com.lynx.canvas.KryptonCameraService
                public KryptonCamera createCamera() {
                    return new KryptonDefaultCamera(LynxKryptonDefaultServiceLazyLoader.this.mApplicationContext, LynxKryptonDefaultServiceLazyLoader.access$100());
                }
            };
        }
        if (cls == KryptonMediaRecorderService.class) {
            return new KryptonMediaRecorderService() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.2
                @Override // com.lynx.canvas.KryptonMediaRecorderService
                public KryptonMediaRecorder createMediaRecorder() {
                    return new KryptonDefaultMediaRecorder(LynxKryptonDefaultServiceLazyLoader.this.createMediaRecorderDelegate(), LynxKryptonDefaultServiceLazyLoader.access$300());
                }
            };
        }
        if (cls == KryptonSettingsService.class) {
            return new LynxKryptonSettingsService();
        }
        if (cls == KryptonSensorService.class) {
            return new KryptonDefaultSensorService(this.mApplicationContext, createSensorInvoker());
        }
        if (cls == KryptonTelemetryService.class) {
            return new LynxKryptonTelemetryService(this.mLynxContext);
        }
        return null;
    }

    private static ILynxSystemInvokeService getSystemInvokeService() {
        return LynxServiceCenter.inst().getService(ILynxSystemInvokeService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public KryptonDefaultMediaRecorder.Delegate createMediaRecorderDelegate() {
        return new KryptonDefaultMediaRecorder.Delegate() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.3
            @Override // com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.Delegate
            public KryptonDefaultMediaRecorder.VideoPathInfo getVideoPathInfo(String str, boolean z) {
                return null;
            }

            @Override // com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.Delegate
            public String getVideoDirectory(String str, boolean z) {
                if (LynxKryptonDefaultServiceLazyLoader.this.mTemporaryDirectory != null && LynxKryptonDefaultServiceLazyLoader.this.mTemporaryDirectory.length() > 0) {
                    return LynxKryptonDefaultServiceLazyLoader.this.mTemporaryDirectory;
                }
                return EnvUtils.getCacheDir();
            }

            @Override // com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.Delegate
            public KryptonDefaultMediaRecorder.VideoFileManagementPolicy getVideoFileManagementPolicy() {
                return KryptonDefaultMediaRecorder.VideoFileManagementPolicy.USER_DEFINED;
            }
        };
    }

    private static KryptonDefaultMediaRecorder.Invoker createMediaRecorderInvoker() {
        final ILynxSystemInvokeService systemInvokeService = getSystemInvokeService();
        if (systemInvokeService == null) {
            return null;
        }
        return new KryptonDefaultMediaRecorder.Invoker() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.4
            @Override // com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.Invoker
            public String extractMetadata(MediaMetadataRetriever mediaMetadataRetriever, int i) {
                return systemInvokeService.extractMetadata(mediaMetadataRetriever, i);
            }
        };
    }

    private static KryptonDefaultCamera.Invoker createCameraInvoker() {
        final ILynxSystemInvokeService systemInvokeService = getSystemInvokeService();
        if (systemInvokeService == null) {
            return null;
        }
        return new KryptonDefaultCamera.Invoker() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.5
            @Override // com.lynx.canvas.camera.KryptonDefaultCamera.Invoker
            public Camera openCamera(int i) throws RuntimeException {
                return systemInvokeService.openCamera(i);
            }

            @Override // com.lynx.canvas.camera.KryptonDefaultCamera.Invoker
            public void releaseCamera(Camera camera) {
                systemInvokeService.releaseCamera(camera);
            }
        };
    }

    private static KryptonDefaultSensorService.Invoker createSensorInvoker() {
        final ILynxSystemInvokeService systemInvokeService = getSystemInvokeService();
        if (systemInvokeService == null) {
            return null;
        }
        return new KryptonDefaultSensorService.Invoker() { // from class: com.lynx.canvas.LynxKryptonDefaultServiceLazyLoader.6
            @Override // com.lynx.canvas.hardware.KryptonDefaultSensorService.Invoker
            public boolean registerSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i) {
                return systemInvokeService.registerSensorListener(sensorManager, sensorEventListener, sensor, i);
            }

            @Override // com.lynx.canvas.hardware.KryptonDefaultSensorService.Invoker
            public void unregisterSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener) {
                systemInvokeService.unregisterSensorListener(sensorManager, sensorEventListener);
            }
        };
    }
}
