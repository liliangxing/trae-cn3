package com.ttnet.org.chromium.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

/* loaded from: classes7.dex */
public class GpuUtils {
    private static String TAG = "GpuUtils";
    private static String sGlRenderer = "unknown";
    private static String sGlVendor = "unknown";
    private static final Object sGpuInfoLock = new Object();
    private static boolean sInitialized;

    /* JADX WARN: Removed duplicated region for block: B:11:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean initialize() {
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        boolean z;
        if (sInitialized) {
            return true;
        }
        EGLDisplay eGLDisplay = null;
        boolean z2 = false;
        try {
            EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
            try {
                try {
                    if (eglGetCurrentContext != null) {
                        try {
                            if (!eglGetCurrentContext.equals(EGL14.EGL_NO_CONTEXT)) {
                                z = false;
                                if (!z) {
                                    try {
                                        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                                        if (eglGetDisplay != null) {
                                            try {
                                                if (!eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                                                    int[] iArr = new int[2];
                                                    if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                                                        throw new Exception("eglInitialize error");
                                                    }
                                                    int[] iArr2 = new int[1];
                                                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                                                    if (!EGL14.eglChooseConfig(eglGetDisplay, new int[]{12344}, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
                                                        throw new Exception("eglChooseConfig error");
                                                    }
                                                    if (iArr2[0] <= 0) {
                                                        throw new Exception("no egl config chosen");
                                                    }
                                                    EGLConfig eGLConfig = eGLConfigArr[0];
                                                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12344}, 0);
                                                    if (eglCreateContext == null || eglCreateContext.equals(EGL14.EGL_NO_CONTEXT)) {
                                                        throw new Exception("eglCreateContext error");
                                                    }
                                                    EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12344}, 0);
                                                    if (eglCreatePbufferSurface == null || eglCreatePbufferSurface.equals(EGL14.EGL_NO_SURFACE)) {
                                                        throw new Exception("eglCreatePbufferSurface error");
                                                    }
                                                    if (!EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                                                        throw new Exception("eglMakeCurrent error");
                                                    }
                                                    eGLContext = eglCreateContext;
                                                    eGLSurface = eglCreatePbufferSurface;
                                                    eGLDisplay = eglGetDisplay;
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                eGLContext = eglGetCurrentContext;
                                                eGLSurface = null;
                                                eGLDisplay = eglGetDisplay;
                                                e.printStackTrace();
                                                if (z) {
                                                }
                                                return false;
                                            } catch (Throwable th) {
                                                th = th;
                                                eGLContext = eglGetCurrentContext;
                                                z2 = z;
                                                eGLSurface = null;
                                                eGLDisplay = eglGetDisplay;
                                                if (z2) {
                                                }
                                                throw th;
                                            }
                                        }
                                        throw new Exception("eglGetDisplay error");
                                    } catch (Exception e2) {
                                        e = e2;
                                        eGLContext = eglGetCurrentContext;
                                        eGLSurface = null;
                                        e.printStackTrace();
                                        if (z) {
                                        }
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        eGLContext = eglGetCurrentContext;
                                        z2 = z;
                                        eGLSurface = null;
                                        if (z2) {
                                        }
                                        throw th;
                                    }
                                }
                                eGLContext = eglGetCurrentContext;
                                eGLSurface = null;
                                synchronized (sGpuInfoLock) {
                                    sGlVendor = GLES20.glGetString(7936);
                                    sGlRenderer = GLES20.glGetString(7937);
                                }
                                if (z) {
                                    try {
                                        EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                                        if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                                            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                                        }
                                        if (eGLContext != null && !eGLContext.equals(EGL14.EGL_NO_CONTEXT)) {
                                            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                                        }
                                        if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                                            EGL14.eglTerminate(eGLDisplay);
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                sInitialized = true;
                                return true;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            z = false;
                            eGLContext = eglGetCurrentContext;
                            eGLSurface = null;
                            e.printStackTrace();
                            if (z) {
                            }
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            eGLContext = eglGetCurrentContext;
                            eGLSurface = null;
                            if (z2) {
                            }
                            throw th;
                        }
                    }
                    synchronized (sGpuInfoLock) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (z) {
                        try {
                            EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                            if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                                EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                            }
                            if (eGLContext != null && !eGLContext.equals(EGL14.EGL_NO_CONTEXT)) {
                                EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                            }
                            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                                EGL14.eglTerminate(eGLDisplay);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th4) {
                th = th4;
                z2 = z;
                if (z2) {
                    try {
                        EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                        if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                        }
                        if (eGLContext != null && !eGLContext.equals(EGL14.EGL_NO_CONTEXT)) {
                            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                        }
                        if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                            EGL14.eglTerminate(eGLDisplay);
                        }
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e5) {
            e = e5;
            eGLSurface = null;
            eGLContext = null;
            z = false;
        } catch (Throwable th5) {
            th = th5;
            eGLSurface = null;
            eGLContext = null;
        }
    }

    public static String getGPUVendor() {
        String str;
        synchronized (sGpuInfoLock) {
            str = sGlVendor;
        }
        return str;
    }

    public static String getGPUModel() {
        String str;
        synchronized (sGpuInfoLock) {
            str = sGlRenderer;
        }
        return str;
    }
}
