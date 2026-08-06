package com.ss.bytertc.engine.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;

/* loaded from: classes7.dex */
public class GLUtils {
    private static int[] defaultEGLConfAttr = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
    private static int[] ctxAttr = {12440, 2, 12344};

    public static EGLDisplay getEglDisplay() {
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

    public static EGLConfig getEglConfig(EGLDisplay eglDisplay) {
        return getEglConfig(eglDisplay, defaultEGLConfAttr);
    }

    public static EGLConfig getEglConfig(EGLDisplay eglDisplay, int[] configAttributes) {
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

    public static EGLContext createEglContext(EGLDisplay eglDisplay, EGLConfig eglConfig, EGLContext context) {
        return EGL14.eglCreateContext(eglDisplay, eglConfig, context, ctxAttr, 0);
    }

    public static int loadShader(int shaderType, String source) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, source);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
