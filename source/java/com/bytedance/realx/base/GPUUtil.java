package com.bytedance.realx.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;

/* loaded from: classes4.dex */
public class GPUUtil {
    private static String glRenderer = "unknown";
    private static String glVendor = "unknown";
    private static boolean initialized;

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|2|3|(3:125|126|(6:128|(5:70|71|(3:75|76|(2:78|(2:80|(2:82|(2:84|(2:104|105)(4:88|(3:92|93|(2:95|(1:97)(2:98|99)))|90|91))(2:106|107))(2:108|109))(2:110|111)))|73|74)(1:7)|8|9|10|(6:12|(1:16)|(1:20)|(1:27)|24|25)(1:29)))|5|(0)(0)|8|9|10|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0163, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0164, code lost:
    
        r21 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015c, code lost:
    
        r21 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void Initialize() {
        EGLDisplay eGLDisplay;
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        EGLContext eglGetCurrentContext;
        boolean z;
        EGLSurface eGLSurface2;
        initialized = true;
        boolean z2 = false;
        try {
            eglGetCurrentContext = EGL14.eglGetCurrentContext();
        } catch (Exception e) {
            e = e;
            eGLDisplay = null;
            eGLSurface = null;
            eGLContext = null;
        } catch (Throwable th) {
            th = th;
            eGLDisplay = null;
            eGLSurface = null;
            eGLContext = null;
        }
        if (eglGetCurrentContext != null) {
            try {
            } catch (Exception e2) {
                e = e2;
                eGLContext = eglGetCurrentContext;
                eGLDisplay = null;
                eGLSurface = null;
                try {
                    Log.e("gpm", e.toString());
                    if (z2) {
                        return;
                    }
                    EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                    if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                        EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                    }
                    if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                        EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                    }
                    if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                        return;
                    }
                    EGL14.eglTerminate(eGLDisplay);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (z2) {
                        EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                        }
                        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                        }
                        if (eGLDisplay != null && eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                            EGL14.eglTerminate(eGLDisplay);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eGLContext = eglGetCurrentContext;
                eGLDisplay = null;
                eGLSurface = null;
                if (z2) {
                }
                throw th;
            }
            if (eglGetCurrentContext != EGL14.EGL_NO_CONTEXT) {
                z = false;
                if (z) {
                    eGLSurface2 = null;
                    eGLDisplay = null;
                } else {
                    try {
                        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                        if (eglGetDisplay != null) {
                            try {
                                if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                                    int[] iArr = new int[2];
                                    if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                                        throw new Exception("eglInitialize error");
                                    }
                                    int[] iArr2 = new int[1];
                                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                                    if (!EGL14.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
                                        throw new Exception("eglChooseConfig error");
                                    }
                                    if (iArr2[0] <= 0) {
                                        throw new Exception("no egl config chosen");
                                    }
                                    EGLConfig eGLConfig = eGLConfigArr[0];
                                    eglGetCurrentContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                                    if (eglGetCurrentContext == null || eglGetCurrentContext == EGL14.EGL_NO_CONTEXT) {
                                        throw new Exception("eglCreateContext error");
                                    }
                                    EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
                                    if (eglCreatePbufferSurface != null) {
                                        try {
                                            if (eglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
                                                if (!EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglGetCurrentContext)) {
                                                    throw new Exception("eglMakeCurrent error");
                                                }
                                                eGLSurface2 = eglCreatePbufferSurface;
                                                eGLDisplay = eglGetDisplay;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            z2 = z;
                                            eGLContext = eglGetCurrentContext;
                                            eGLSurface = eglCreatePbufferSurface;
                                            eGLDisplay = eglGetDisplay;
                                            Log.e("gpm", e.toString());
                                            if (z2) {
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            z2 = z;
                                            eGLContext = eglGetCurrentContext;
                                            eGLSurface = eglCreatePbufferSurface;
                                            eGLDisplay = eglGetDisplay;
                                            if (z2) {
                                            }
                                            throw th;
                                        }
                                    }
                                    throw new Exception("eglCreatePbufferSurface error");
                                }
                            } catch (Exception e4) {
                                e = e4;
                                z2 = z;
                                eGLDisplay = eglGetDisplay;
                                eGLContext = eglGetCurrentContext;
                                eGLSurface = null;
                                Log.e("gpm", e.toString());
                                if (z2) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                z2 = z;
                                eGLDisplay = eglGetDisplay;
                                eGLContext = eglGetCurrentContext;
                                eGLSurface = null;
                                if (z2) {
                                }
                                throw th;
                            }
                        }
                        throw new Exception("eglGetDisplay error");
                    } catch (Exception e5) {
                        e = e5;
                        z2 = z;
                        eGLDisplay = null;
                    } catch (Throwable th6) {
                        th = th6;
                        z2 = z;
                        eGLDisplay = null;
                    }
                }
                glVendor = GLES20.glGetString(7936);
                glRenderer = GLES20.glGetString(7937);
                if (z) {
                    return;
                }
                EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                if (eGLSurface2 != null && eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                    EGL14.eglDestroySurface(eGLDisplay, eGLSurface2);
                }
                if (eglGetCurrentContext != null && eglGetCurrentContext != EGL14.EGL_NO_CONTEXT) {
                    EGL14.eglDestroyContext(eGLDisplay, eglGetCurrentContext);
                }
                if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                    return;
                }
                EGL14.eglTerminate(eGLDisplay);
                return;
            }
        }
        z = true;
        if (z) {
        }
        glVendor = GLES20.glGetString(7936);
        glRenderer = GLES20.glGetString(7937);
        if (z) {
        }
    }

    public static String getGPURenderer() {
        if (!initialized) {
            Initialize();
        }
        return glRenderer;
    }

    public static String getGPURendererFallback() {
        return glRenderer;
    }
}
