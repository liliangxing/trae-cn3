package com.lynx.canvas;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonReflectLoader {
    public static final String TAG = "KryptonReflectLoader";
    private static volatile KryptonReflectLoader sInstance;
    private Class<KryptonAudioModule> mAudioModuleClass;
    private KryptonRTCModule mDefaultRTCModuleInstance;
    private KryptonVECameraModule mDefaultVECameraModuleInstance;
    private Class<KryptonEffectConfigService> mEffectConfigServiceClass;
    private Class<KryptonLiveModule> mKryptonDefaultLiveModuleClass;
    private boolean mNoAudioModule;
    private boolean mNoEffectConfig;
    private boolean mNoLiveModule;
    private boolean mNoRTCModule;
    private boolean mNoVECameraModule;
    private boolean mNoVideoPlayerService;
    private boolean mUseAurumAudioEngine;
    private KryptonVideoPlayerService mVideoPlayerServiceInstance;

    public static KryptonReflectLoader inst() {
        if (sInstance == null) {
            synchronized (KryptonReflectLoader.class) {
                if (sInstance == null) {
                    sInstance = new KryptonReflectLoader();
                }
            }
        }
        return sInstance;
    }

    public <T extends KryptonService> T getHybridServiceInstance(Class<T> cls) {
        if (KryptonVideoPlayerService.class.isAssignableFrom(cls)) {
            if (this.mVideoPlayerServiceInstance == null && !this.mNoVideoPlayerService) {
                loadVideoPlayerService();
                this.mNoVideoPlayerService = this.mVideoPlayerServiceInstance == null;
            }
            return this.mVideoPlayerServiceInstance;
        }
        if (KryptonEffectConfigService.class.isAssignableFrom(cls)) {
            if (this.mEffectConfigServiceClass == null && !this.mNoEffectConfig) {
                loadEffectConfigService();
                this.mNoEffectConfig = this.mEffectConfigServiceClass == null;
            }
            Class<KryptonEffectConfigService> cls2 = this.mEffectConfigServiceClass;
            if (cls2 != null) {
                try {
                    return cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    KryptonLLog.m2563w(TAG, "create HybridCanvasEffectConfigServiceClass instance error " + e.getMessage());
                }
            }
        }
        return null;
    }

    public <T extends KryptonModule> T getModuleDefaultInstance(Class<T> cls, KryptonApp kryptonApp) {
        if (KryptonAudioModule.class.isAssignableFrom(cls)) {
            this.mUseAurumAudioEngine = kryptonApp.getFeatureFlag().getUseAurumAudioEngine();
            if (this.mAudioModuleClass == null && !this.mNoAudioModule) {
                loadAudioModuleClass();
                this.mNoAudioModule = this.mAudioModuleClass == null;
            }
            return newAudioModuleInstance();
        }
        if (KryptonRTCModule.class.isAssignableFrom(cls)) {
            if (this.mDefaultRTCModuleInstance == null && !this.mNoRTCModule) {
                loadDefaultRTCModule();
                this.mNoRTCModule = this.mDefaultRTCModuleInstance == null;
            }
            return this.mDefaultRTCModuleInstance;
        }
        if (KryptonLiveModule.class.isAssignableFrom(cls)) {
            if (this.mKryptonDefaultLiveModuleClass == null && !this.mNoLiveModule) {
                loadDefaultLiveModule();
                this.mNoLiveModule = this.mKryptonDefaultLiveModuleClass == null;
            }
            return newKryptonDefaultLiveModuleInstance();
        }
        if (!KryptonVECameraModule.class.isAssignableFrom(cls)) {
            return null;
        }
        if (this.mDefaultVECameraModuleInstance == null && !this.mNoVECameraModule) {
            loadDefaultVECameraModule();
            this.mNoVECameraModule = this.mDefaultVECameraModuleInstance == null;
        }
        return this.mDefaultVECameraModuleInstance;
    }

    private KryptonReflectLoader() {
    }

    private void loadAudioModuleClass() {
        String concat = "com.lynx.canvas.audio.".concat(this.mUseAurumAudioEngine ? "KryptonAurumAudioModule" : "KryptonAudioModuleImpl");
        try {
            Class cls = Class.forName(concat);
            if (KryptonAudioModule.class.isAssignableFrom(cls)) {
                this.mAudioModuleClass = cls;
            } else {
                KryptonLLog.m2560e(TAG, "reflect find " + concat + " instance type error");
            }
        } catch (ClassCastException e) {
            KryptonLLog.m2560e(TAG, "can not cast to KryptonAudioModule: " + concat + e.getMessage());
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find module class not found: " + concat + ", maybe audio module is not used.");
        }
    }

    private KryptonAudioModule newAudioModuleInstance() {
        Class<KryptonAudioModule> cls = this.mAudioModuleClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            KryptonLLog.m2563w(TAG, "create mAudioModuleClass instance error " + e.getMessage());
            return null;
        }
    }

    private boolean loadVideoPlayerService() {
        return loadVideoPlayerService("com.bytedance.ies.bullet.lynx.element.LynxCanvasTTPlayer") || loadVideoPlayerService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasTTPlayer");
    }

    private boolean loadVideoPlayerService(String str) {
        Class<?> cls;
        final Constructor<?> constructor;
        try {
            cls = Class.forName(str);
            constructor = cls.getConstructor(Context.class, Map.class);
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find service class not found: " + str);
        } catch (NoSuchMethodException e) {
            KryptonLLog.m2560e(TAG, "not find construct method for " + str + e.getMessage());
        } catch (SecurityException e2) {
            KryptonLLog.m2560e(TAG, "security exception for " + str + e2.getMessage());
        }
        if (KryptonVideoPlayer.class.isAssignableFrom(cls) && constructor != null) {
            this.mVideoPlayerServiceInstance = new KryptonVideoPlayerService() { // from class: com.lynx.canvas.KryptonReflectLoader.1
                @Override // com.lynx.canvas.KryptonVideoPlayerService
                public KryptonVideoPlayer createVideoPlayer(Map<String, String> map) {
                    try {
                        return (KryptonVideoPlayer) constructor.newInstance(Krypton.inst().getContext(), map);
                    } catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e3) {
                        KryptonLLog.m2563w(KryptonReflectLoader.TAG, "create KryptonVideoPlayer instance error" + e3.getMessage());
                        return null;
                    }
                }
            };
            KryptonLLog.m2561i(TAG, "found video player service class: " + str);
            return true;
        }
        KryptonLLog.m2560e(TAG, "reflect find service for LynxCanvasTTPlayer instance type error");
        return false;
    }

    private boolean loadEffectConfigService() {
        return loadEffectConfigService("com.bytedance.ies.bullet.lynx.element.LynxCanvasEffectHandler") || loadEffectConfigService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasEffectHandler");
    }

    private boolean loadEffectConfigService(String str) {
        try {
            Class cls = Class.forName(str);
            if (KryptonEffectConfigService.class.isAssignableFrom(cls)) {
                this.mEffectConfigServiceClass = cls;
                KryptonLLog.m2561i(TAG, "found effect config service class: " + str);
                return true;
            }
            KryptonLLog.m2560e(TAG, "reflect find service for LynxCanvasEffectHandler instance type error");
            return false;
        } catch (ClassCastException e) {
            KryptonLLog.m2560e(TAG, "service class can not cast to KryptonEffectConfigService: " + str + e.getMessage());
            return false;
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find service class not found: " + str);
            return false;
        }
    }

    private void loadDefaultRTCModule() {
        try {
            Object invoke = Class.forName("com.lynx.canvas.rtc.KryptonDefaultRTCModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);
            if (KryptonRTCModule.class.isInstance(invoke)) {
                this.mDefaultRTCModuleInstance = (KryptonRTCModule) invoke;
            } else {
                KryptonLLog.m2560e(TAG, "reflect find module for com.lynx.canvas.rtc.KryptonDefaultRTCModule instance type error");
            }
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find module class not found: com.lynx.canvas.rtc.KryptonDefaultRTCModule, maybe Krypton/RTC is not used.");
        } catch (IllegalAccessException e) {
            e = e;
            KryptonLLog.m2560e(TAG, "invoke method inst in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule failed " + e.getMessage());
        } catch (NoSuchMethodException e2) {
            KryptonLLog.m2560e(TAG, "find module inst method not found in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule" + e2.getMessage());
        } catch (InvocationTargetException e3) {
            e = e3;
            KryptonLLog.m2560e(TAG, "invoke method inst in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule failed " + e.getMessage());
        }
    }

    private void loadDefaultLiveModule() {
        try {
            Class cls = Class.forName("com.lynx.canvas.live.KryptonDefaultLiveModule");
            if (KryptonLiveModule.class.isAssignableFrom(cls)) {
                this.mKryptonDefaultLiveModuleClass = cls;
            } else {
                KryptonLLog.m2560e(TAG, "reflect find default KryptonLiveModule instance type error");
            }
        } catch (ClassCastException e) {
            KryptonLLog.m2560e(TAG, "can not cast to KryptonLiveModule: com.lynx.canvas.live.KryptonDefaultLiveModule" + e.getMessage());
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find module class not found: com.lynx.canvas.live.KryptonDefaultLiveModule, maybe Krypton/Live is not used.");
        }
    }

    private KryptonLiveModule newKryptonDefaultLiveModuleInstance() {
        Class<KryptonLiveModule> cls = this.mKryptonDefaultLiveModuleClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            KryptonLLog.m2563w(TAG, "create mKryptonDefaultLiveModuleClass instance error" + e.getMessage());
            return null;
        }
    }

    private void loadDefaultVECameraModule() {
        try {
            Object invoke = Class.forName("com.lynx.canvas.vecamera.KryptonDefaultVECameraModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);
            if (KryptonVECameraModule.class.isInstance(invoke)) {
                this.mDefaultVECameraModuleInstance = (KryptonVECameraModule) invoke;
            } else {
                KryptonLLog.m2563w(TAG, "reflect find module for com.lynx.canvas.vecamera.KryptonDefaultVECameraModule instance type error");
            }
        } catch (ClassNotFoundException unused) {
            KryptonLLog.m2563w(TAG, "find module class not found: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule, maybe Krypton/VECamera is not used.");
        } catch (IllegalAccessException e) {
            e = e;
            KryptonLLog.m2563w(TAG, "invoke method inst in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule failed " + e.getMessage());
        } catch (NoSuchMethodException e2) {
            KryptonLLog.m2563w(TAG, "find module inst method not found in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule" + e2.getMessage());
        } catch (InvocationTargetException e3) {
            e = e3;
            KryptonLLog.m2563w(TAG, "invoke method inst in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule failed " + e.getMessage());
        }
    }
}
