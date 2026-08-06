package com.bytedance.realx.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;

/* loaded from: classes4.dex */
public class EglBase14 implements EglBase {
    private static final int EGLExt_SDK_VERSION = 18;
    private static final String TAG = "EglBase14";
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface = EGL14.EGL_NO_SURFACE;
    private int glesVersion = -1;
    private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
    private static int egl14ContextCount = 0;

    public static boolean isEGL14Supported() {
        StringBuilder sb = new StringBuilder("SDK version: ");
        int i = CURRENT_SDK_VERSION;
        Log.d(TAG, sb.append(i).append(". isEGL14Supported: ").append(i >= 18).toString());
        return i >= 18;
    }

    /* loaded from: classes4.dex */
    public static class Context implements EglBase.Context {
        private final EGLContext egl14Context;
        private final int glesVersion;

        @Override // com.bytedance.realx.video.EglBase.Context
        public long getNativeEglContext() {
            return EglBase14.CURRENT_SDK_VERSION >= 21 ? this.egl14Context.getNativeHandle() : this.egl14Context.getHandle();
        }

        @Override // com.bytedance.realx.video.EglBase.Context
        public EGLContext getEgl14Context() {
            return this.egl14Context;
        }

        @Override // com.bytedance.realx.video.EglBase.Context
        public int getGLESVersion() {
            return this.glesVersion;
        }

        public Context(EGLContext eglContext, int glesVersion) {
            this.egl14Context = eglContext;
            this.glesVersion = glesVersion;
        }

        public Context(EGLContext eglContext) {
            this.egl14Context = eglContext;
            this.glesVersion = 2;
        }
    }

    public EglBase14(Context sharedContext, int[] configAttributes) {
        init(EglBase.EglVersion.getPreferredEglVersion(), sharedContext, configAttributes);
    }

    public EglBase14(int glesVersion, Context sharedContext, int[] configAttributes) {
        init(glesVersion, sharedContext, configAttributes);
    }

    private void init(int glesVersion, Context sharedContext, int[] configAttributes) {
        this.glesVersion = glesVersion;
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        try {
            EGLConfig eglConfig = getEglConfig(eglDisplay, configAttributes);
            this.eglConfig = eglConfig;
            this.eglContext = createEglContext(sharedContext, glesVersion, this.eglDisplay, eglConfig);
        } catch (RuntimeException e) {
            if (glesVersion != 3) {
                RXLogging.w(TAG, "EGL14 GLES context create failed.");
                throw e;
            }
            RXLogging.w(TAG, "EGL14 GLES3 context create failed: " + e.toString() + ". trying falback to EGLS2");
            EGLConfig eglConfig2 = getEglConfig(this.eglDisplay, EglBase.createModifiedEGLConfigArray(configAttributes, 12352, 64, 4));
            this.eglConfig = eglConfig2;
            this.eglContext = createEglContext(sharedContext, 2, this.eglDisplay, eglConfig2);
        }
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createSurface(Surface surface) {
        createSurfaceInternal(surface);
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture);
    }

    private void createSurfaceInternal(Object surface) {
        if (!(surface instanceof Surface) && !(surface instanceof SurfaceTexture)) {
            Log.e(TAG, "Input must be either a Surface or SurfaceTexture");
            throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
        }
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
            Log.e(TAG, "Already has an EGLSurface");
            throw new RuntimeException("Already has an EGLSurface");
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, new int[]{12344}, 0);
        this.eglSurface = eglCreateWindowSurface;
        if (eglCreateWindowSurface != EGL14.EGL_NO_SURFACE) {
            return;
        }
        Log.e(TAG, "Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createPbufferSurface(int width, int height) {
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
            Log.e(TAG, "Already has an EGLSurface");
            throw new RuntimeException("Already has an EGLSurface");
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, width, 12374, height, 12344}, 0);
        this.eglSurface = eglCreatePbufferSurface;
        if (eglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
            return;
        }
        Log.e(TAG, "Failed to create pixel buffer surface with size " + width + "x" + height + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
        throw new RuntimeException("Failed to create pixel buffer surface with size " + width + "x" + height + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public Context getEglBaseContext() {
        return new Context(this.eglContext, this.glesVersion);
    }

    @Override // com.bytedance.realx.video.EglBase
    public int getGLESVersion() {
        return this.glesVersion;
    }

    @Override // com.bytedance.realx.video.EglBase
    public boolean hasSurface() {
        return this.eglSurface != EGL14.EGL_NO_SURFACE;
    }

    @Override // com.bytedance.realx.video.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr, 0);
        return iArr[0];
    }

    @Override // com.bytedance.realx.video.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr, 0);
        return iArr[0];
    }

    @Override // com.bytedance.realx.video.EglBase
    public void releaseSurface() {
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = EGL14.EGL_NO_SURFACE;
        }
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY || this.eglContext == EGL14.EGL_NO_CONTEXT || this.eglConfig == null) {
            Log.e(TAG, "This object has been released");
            throw new RuntimeException("This object has been released");
        }
    }

    @Override // com.bytedance.realx.video.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        EglBase.eglContextDestoryStart();
        EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        EglBase.eglContextDestoryEnd();
        if (!GlReleaseThreadByPass.isEglReleaseThreadByPass()) {
            EGL14.eglReleaseThread();
        }
        EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglConfig = null;
        egl14ContextCount--;
        RXLogging.w(TAG, "EGL14 context destroy. current count is:" + egl14ContextCount);
    }

    private void eglMakeCurrent() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
            return;
        }
        Log.e(TAG, "eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
            Log.e(TAG, "No EGLSurface - can't make current");
            throw new RuntimeException("No EGLSurface - can't make current");
        }
        if (EglBase.EglLock.enableEglLock) {
            synchronized (EglBase.lock) {
                eglMakeCurrent();
            }
            return;
        }
        eglMakeCurrent();
    }

    private void eglDetachCurrent() {
        if (EGL14.eglMakeCurrent(this.eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            return;
        }
        Log.e(TAG, "eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public void detachCurrent() {
        if (EglBase.EglLock.enableEglLock) {
            synchronized (EglBase.lock) {
                eglDetachCurrent();
            }
            return;
        }
        eglDetachCurrent();
    }

    @Override // com.bytedance.realx.video.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
            Log.e(TAG, "No EGLSurface - can't swap buffers");
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
        if (EglBase.EglLock.enableEglLock) {
            synchronized (EglBase.lock) {
                EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
            return;
        }
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }

    @Override // com.bytedance.realx.video.EglBase
    public void swapBuffers(long timeStampNs) {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
            Log.e(TAG, "No EGLSurface - can't swap buffers");
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
        if (EglBase.EglLock.enableEglLock) {
            synchronized (EglBase.lock) {
                EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, timeStampNs);
                EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
            return;
        }
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, timeStampNs);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }

    private static EGLDisplay getEglDisplay() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            return eglGetDisplay;
        }
        throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    private static EGLConfig getEglConfig(EGLDisplay eglDisplay, int[] configAttributes) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        if (!EGL14.eglChooseConfig(eglDisplay, configAttributes, 0, eGLConfigArr, 0, 1, iArr, 0)) {
            throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        if (iArr[0] <= 0) {
            throw new RuntimeException("Unable to find any matching EGL config");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new RuntimeException("eglChooseConfig returned null");
    }

    private static EGLContext createEglContext(Context sharedContext, int glesVersion, EGLDisplay eglDisplay, EGLConfig eglConfig) {
        EGLContext eglCreateContext;
        if (sharedContext == null || sharedContext.egl14Context != EGL14.EGL_NO_CONTEXT) {
            int[] iArr = {12440, glesVersion, 12344};
            EGLContext eGLContext = (sharedContext == null || sharedContext.egl14Context == null) ? EGL14.EGL_NO_CONTEXT : sharedContext.egl14Context;
            synchronized (EglBase.lock) {
                eglCreateContext = EGL14.eglCreateContext(eglDisplay, eglConfig, eGLContext, iArr, 0);
            }
            if (eglCreateContext == EGL14.EGL_NO_CONTEXT) {
                Log.e(TAG, "Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
                throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
            egl14ContextCount++;
            RXLogging.w(TAG, "EGL14 context create. current count is:" + egl14ContextCount);
            return eglCreateContext;
        }
        Log.e(TAG, "Invalid sharedContext");
        throw new RuntimeException("Invalid sharedContext");
    }
}
