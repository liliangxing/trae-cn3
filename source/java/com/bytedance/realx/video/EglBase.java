package com.bytedance.realx.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.bytedance.realx.video.EglBase10;
import com.bytedance.realx.video.EglBase14;

/* loaded from: classes4.dex */
public interface EglBase {

    @Deprecated
    public static final int[] CONFIG_PIXEL_BUFFER;

    @Deprecated
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER;

    @Deprecated
    public static final int[] CONFIG_PLAIN;

    @Deprecated
    public static final int[] CONFIG_RECORDABLE;

    @Deprecated
    public static final int[] CONFIG_RGBA;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static final int[] ES2_CONFIG_PIXEL_BUFFER;
    public static final int[] ES2_CONFIG_PIXEL_RGBA_BUFFER;
    public static final int[] ES2_CONFIG_PLAIN;
    public static final int[] ES2_CONFIG_RECORDABLE;
    public static final int[] ES2_CONFIG_RGBA;
    public static final String TAG = "EglBase";
    public static final Object lock = new Object();
    public static final int[] ES3_CONFIG_PLAIN = {12324, 8, 12323, 8, 12322, 8, 12352, 64, 12344};
    public static final int[] ES3_CONFIG_RGBA = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12344};
    public static final int[] ES3_CONFIG_PIXEL_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12352, 64, 12339, 1, 12344};
    public static final int[] ES3_CONFIG_PIXEL_RGBA_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12339, 1, 12344};
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int[] ES3_CONFIG_RECORDABLE = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, EGL_RECORDABLE_ANDROID, 1, 12344};

    /* loaded from: classes4.dex */
    public enum Config {
        CONFIG_PLAIN,
        CONFIG_RGBA,
        CONFIG_PIXEL_BUFFER,
        CONFIG_PIXEL_RGBA_BUFFER,
        CONFIG_RECORDABLE
    }

    /* loaded from: classes4.dex */
    public interface Context {
        public static final long NO_CONTEXT = 0;

        EGLContext getEgl14Context();

        int getGLESVersion();

        long getNativeEglContext();
    }

    /* loaded from: classes4.dex */
    public interface EglContextChecker {
        void EglContextDestoryEnd();

        void EglContextDestoryStart();
    }

    /* loaded from: classes4.dex */
    public static class EglLock {
        public static boolean enableEglLock = true;
    }

    void createDummyPbufferSurface();

    void createPbufferSurface(int width, int height);

    void createSurface(SurfaceTexture surfaceTexture);

    void createSurface(Surface surface);

    void detachCurrent();

    Context getEglBaseContext();

    int getGLESVersion();

    boolean hasSurface();

    void makeCurrent();

    void release();

    void releaseSurface();

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers();

    void swapBuffers(long presentationTimeStampNs);

    /* loaded from: classes4.dex */
    public static class EglVersion {
        public static final int EGL_VERSION_2 = 2;
        public static final int EGL_VERSION_3 = 3;
        private static int PREFERRED_EGL_VERSION = 2;

        public static void setPreferredEglVersion(int version) {
            PREFERRED_EGL_VERSION = version;
        }

        public static int getPreferredEglVersion() {
            return PREFERRED_EGL_VERSION;
        }
    }

    static {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
        ES2_CONFIG_PLAIN = iArr;
        int[] iArr2 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        ES2_CONFIG_RGBA = iArr2;
        int[] iArr3 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_BUFFER = iArr3;
        int[] iArr4 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_RGBA_BUFFER = iArr4;
        int[] iArr5 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
        ES2_CONFIG_RECORDABLE = iArr5;
        CONFIG_PLAIN = iArr;
        CONFIG_RGBA = iArr2;
        CONFIG_PIXEL_BUFFER = iArr3;
        CONFIG_PIXEL_RGBA_BUFFER = iArr4;
        CONFIG_RECORDABLE = iArr5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.EglBase$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$EglBase$Config;

        static {
            int[] iArr = new int[Config.values().length];
            $SwitchMap$com$bytedance$realx$video$EglBase$Config = iArr;
            try {
                iArr[Config.CONFIG_RGBA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PIXEL_BUFFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PIXEL_RGBA_BUFFER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_RECORDABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PLAIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static int[] getEGLConfig(int GLESVersion, Config config) {
        int i = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$EglBase$Config[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? GLESVersion == 3 ? ES3_CONFIG_PLAIN : ES2_CONFIG_PLAIN : GLESVersion == 3 ? ES3_CONFIG_RECORDABLE : ES2_CONFIG_RECORDABLE : GLESVersion == 3 ? ES3_CONFIG_PIXEL_RGBA_BUFFER : ES2_CONFIG_PIXEL_RGBA_BUFFER : GLESVersion == 3 ? ES3_CONFIG_PIXEL_BUFFER : ES2_CONFIG_PIXEL_BUFFER : GLESVersion == 3 ? ES3_CONFIG_RGBA : ES2_CONFIG_RGBA;
    }

    static int[] createModifiedEGLConfigArray(int[] EGL_CONFIG, int target, int expectedValue, int newValue) {
        int i;
        int[] iArr = (int[]) EGL_CONFIG.clone();
        int i2 = 0;
        while (true) {
            if (i2 < iArr.length) {
                if (iArr[i2] == target && (i = i2 + 1) < iArr.length && iArr[i] == expectedValue) {
                    iArr[i] = newValue;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return iArr;
    }

    static EglBase create(Context sharedContext, int[] configAttributes) {
        if (EglBase14.isEGL14Supported() && (sharedContext == null || (sharedContext instanceof EglBase14.Context))) {
            return new EglBase14(EglVersion.getPreferredEglVersion(), (EglBase14.Context) sharedContext, configAttributes);
        }
        return new EglBase10((EglBase10.Context) sharedContext, configAttributes);
    }

    static EglBase create() {
        return create(null, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
    }

    static EglBase create(Context sharedContext) {
        return create(sharedContext, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
    }

    static EglBase createEgl10(int[] configAttributes) {
        return new EglBase10(null, configAttributes);
    }

    static EglBase createEgl10(javax.microedition.khronos.egl.EGLContext sharedContext, int[] configAttributes) {
        return new EglBase10(new EglBase10.Context(sharedContext), createModifiedEGLConfigArray(configAttributes, 12352, 64, 4));
    }

    static EglBase createEgl14(int[] configAttributes) {
        return new EglBase14(EglVersion.getPreferredEglVersion(), null, configAttributes);
    }

    static EglBase createEgl14(EGLContext sharedContext, int[] configAttributes) {
        return new EglBase14(EglVersion.getPreferredEglVersion(), new EglBase14.Context(sharedContext, EglVersion.getPreferredEglVersion()), configAttributes);
    }

    static void setEglContextChecker(EglContextChecker contextChecker) {
        EglBaseCheckerHelper.setEglContextChecker(contextChecker);
    }

    static void eglContextDestoryStart() {
        EglBaseCheckerHelper.EglContextDestoryStart();
    }

    static void eglContextDestoryEnd() {
        EglBaseCheckerHelper.EglContextDestoryEnd();
    }
}
