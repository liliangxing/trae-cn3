package com.bytedance.realx.video;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.realx.video.EglBase;

/* loaded from: classes4.dex */
public class EglBaseUtils {
    public static long getNativeContextFromEGLBaseContext(EglBase.Context eglBaseContext) {
        if (eglBaseContext != null) {
            return eglBaseContext.getNativeEglContext();
        }
        return 0L;
    }

    public static EGLContext getCurrentContext() {
        return EGL14.eglGetCurrentContext();
    }

    public static EglBase.Context getEGLBaseContext(EglBase eglBase) {
        if (eglBase != null) {
            return eglBase.getEglBaseContext();
        }
        return null;
    }

    public static EglBase createEGLBase(EGLContext eglContext14) {
        if (eglContext14 == EGL14.EGL_NO_CONTEXT || eglContext14 == null) {
            return EglBase.createEgl14(EglBase.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
        }
        return EglBase.createEgl14(eglContext14, EglBase.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
    }

    public static void releaseEGLBase(EglBase eglBase) {
        if (eglBase != null) {
            eglBase.release();
        }
    }

    public static long getNativeEGLContext(EGLContext egl14Context) {
        if (egl14Context == null) {
            return 0L;
        }
        return egl14Context.getNativeHandle();
    }

    public static void setPreferredEglVersion(int version) {
        EglBase.EglVersion.setPreferredEglVersion(version);
    }

    public static int getPreferredEglVersion() {
        return EglBase.EglVersion.getPreferredEglVersion();
    }
}
