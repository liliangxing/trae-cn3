package ms.bd.p001c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.v0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0218v0 {

    /* renamed from: a */
    public EGLDisplay f427a;

    /* renamed from: b */
    public EGLContext f428b;

    public C0218v0() {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f427a = eGLDisplay;
        this.f428b = EGL14.EGL_NO_CONTEXT;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "cdf379", new byte[]{87, 65, 57, 7, 9, 34, 114, 64, 54, 103, 107, 38, 6, 66, 28, 110, 117, 85}));
        }
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f427a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a86f90", new byte[]{101, 52, 68, Tnaf.POW_2_WIDTH, 10, 34, 34, 13, 104, 118, 119, Utf8.REPLACEMENT_BYTE, 81, 82, 35, 0, 78, 72, 51, 118, 116, 51, 86, 2, 10, 38, 123}));
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.f427a = null;
            throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "1a01ef", new byte[]{53, 109, 66, 71, 86, 116, 114, 84, 110, 33, 41, 109, 74, 81, 83, 112, 62, 73, 123, 100, 96, 70, 100, 105, 11, 37}));
        }
        EGLConfig m199a = m199a(3);
        if (m199a != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f427a, m199a, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.f428b = eglCreateContext;
            }
        }
        if (this.f428b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig m199a2 = m199a(2);
            if (m199a2 != null) {
                EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f427a, m199a2, eGLContext, new int[]{12440, 2, 12344}, 0);
                String str = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "2aa14c", new byte[]{38, 100, 30, 102, 25, 113, 48, 84, 53, 66, 44, 109, 6, 64, 19, 96});
                int eglGetError = EGL14.eglGetError();
                if (eglGetError == 12288) {
                    this.f428b = eglCreateContext2;
                } else {
                    throw new RuntimeException(str + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ea2690", new byte[]{46, 35, 100, 101, 42, 103, 99, 82, 113, 105, 102, 57, 1, 18, 30})) + Integer.toHexString(eglGetError));
                }
            } else {
                throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "532263", new byte[]{17, Utf8.REPLACEMENT_BYTE, 64, 68, 5, 33, 118, 6, 108, 34, 34, 56, 79, 66, 73, 37, 118, 1, 118, 107, 48, 48, 67, 74, 12, 100, 19, 53, 79, 65, 43, Utf8.REPLACEMENT_BYTE, 71, 79, 14}));
            }
        }
        EGL14.eglQueryContext(this.f427a, this.f428b, 12440, new int[1], 0);
    }

    /* renamed from: a */
    public final EGLConfig m199a(int i) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i >= 3 ? 68 : 4, 12344, 0, 12344};
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f427a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        return null;
    }

    public final void finalize() {
        try {
            if (this.f427a != EGL14.EGL_NO_DISPLAY) {
                m200a();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: a */
    public final void m201a(EGLSurface eGLSurface) {
        if (!EGL14.eglMakeCurrent(this.f427a, eGLSurface, eGLSurface, this.f428b)) {
            throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5bafab", new byte[]{33, 103, 30, Utf8.REPLACEMENT_BYTE, 95, 126, 51, 96, 37, 36, 54, 101, 28, 6, 30, 115, 55, 74, 60, 51, 32}));
        }
    }

    /* renamed from: a */
    public final void m200a() {
        EGLDisplay eGLDisplay = this.f427a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroyContext(eGLDisplay, this.f428b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f427a);
        }
        this.f427a = EGL14.EGL_NO_DISPLAY;
        this.f428b = EGL14.EGL_NO_CONTEXT;
    }
}
