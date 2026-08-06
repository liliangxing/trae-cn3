package com.ss.ttm.player.UnifiedCodec.surface;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.surface.BackupSurfaceTexture;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes7.dex */
public class GLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final int[] GL_CONFIG_ATTRIBUTES = {12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344};
    public static final String TAG = "GLSurfaceTexture";
    public boolean mFrameAvailable;
    public EGLContext mGlContext;
    public EGL10 mGlCore;
    public EGLDisplay mGlDisplay;
    public EGLSurface mGlSurface;
    public Surface mSurface;
    public BackupSurfaceTexture mSurfaceTexture;
    public final Object mSyncObject = new Object();
    private final int[] mTextureIdHolder;

    public GLSurfaceTexture(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.mTextureIdHolder = new int[1];
        eglSetup(width, height);
        makeCurrent();
        setup();
    }

    public void checkEglError(String errorMsg) {
        boolean z = false;
        while (this.mGlCore.eglGetError() != 12288) {
            z = true;
        }
        if (z) {
            throw new RuntimeException("Hint EGL error! msg =" + errorMsg);
        }
    }

    public void eglSetup(int width, int height) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mGlCore = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mGlDisplay = eglGetDisplay;
        if (this.mGlCore.eglInitialize(eglGetDisplay, null)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.mGlCore.eglChooseConfig(this.mGlDisplay, GL_CONFIG_ATTRIBUTES, eGLConfigArr, 1, new int[1])) {
                this.mGlContext = this.mGlCore.eglCreateContext(this.mGlDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                checkEglError("eglCreateContext");
                if (this.mGlContext != null) {
                    this.mGlSurface = this.mGlCore.eglCreatePbufferSurface(this.mGlDisplay, eGLConfigArr[0], new int[]{12375, width, 12374, height, 12344});
                    checkEglError("eglCreatePbufferSurface");
                    if (this.mGlSurface == null) {
                        throw new RuntimeException("GLSurface is null!");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find pbuffer EGL config");
        }
        throw new RuntimeException("egl init failed");
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void makeCurrent() {
        if (this.mGlCore != null) {
            checkEglError("before makeCurrent");
            EGL10 egl10 = this.mGlCore;
            EGLDisplay eGLDisplay = this.mGlDisplay;
            EGLSurface eGLSurface = this.mGlSurface;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mGlContext)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mSyncObject) {
            if (!this.mFrameAvailable) {
                this.mFrameAvailable = true;
                this.mSyncObject.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    public void release() {
        GLES20.glDeleteTextures(1, this.mTextureIdHolder, 0);
        EGL10 egl10 = this.mGlCore;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.mGlContext)) {
                this.mGlCore.eglMakeCurrent(this.mGlDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            }
            this.mGlCore.eglDestroySurface(this.mGlDisplay, this.mGlSurface);
            this.mGlCore.eglDestroyContext(this.mGlDisplay, this.mGlContext);
        }
        this.mSurface.release();
        this.mGlDisplay = null;
        this.mGlContext = null;
        this.mGlSurface = null;
        this.mGlCore = null;
        this.mSurface = null;
        this.mSurfaceTexture = null;
    }

    public void setup() {
        GLES20.glGenTextures(1, this.mTextureIdHolder, 0);
        checkEglError("generate texture id!");
        BackupSurfaceTexture backupSurfaceTexture = new BackupSurfaceTexture(this.mTextureIdHolder[0]);
        this.mSurfaceTexture = backupSurfaceTexture;
        backupSurfaceTexture.setCallback(new BackupSurfaceTexture.Callback() { // from class: com.ss.ttm.player.UnifiedCodec.surface.GLSurfaceTexture.1
            @Override // com.ss.ttm.player.UnifiedCodec.surface.BackupSurfaceTexture.Callback
            public void onReleased() {
                GLSurfaceTexture.this.release();
            }
        });
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        this.mSurface = new BackupSurface(this.mSurfaceTexture);
    }
}
