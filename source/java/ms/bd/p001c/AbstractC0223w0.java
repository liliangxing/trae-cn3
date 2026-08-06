package ms.bd.p001c;

import android.opengl.EGL14;
import android.opengl.GLES20;

/* renamed from: ms.bd.c.w0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0223w0 {

    /* renamed from: a */
    public static volatile String f444a;

    /* renamed from: b */
    public static final String f445b = (String) AbstractC0190p2.m166a(16777217, 0, 0, "b306cc", new byte[]{50, 36, 77, 81, 73, 100, 113, 29, 115, 114, 118, 53, 2});

    /* renamed from: c */
    public static final String f446c = (String) AbstractC0190p2.m166a(16777217, 0, 0, "8bcf51", new byte[]{104, 101, 2, 0, 75});

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static String m205a() {
        C0218v0 c0218v0;
        Throwable th;
        if (f444a != null) {
            return f444a;
        }
        synchronized (AbstractC0223w0.class) {
            if (f444a != null) {
                return f444a;
            }
            C0218v0 c0218v02 = null;
            C0218v0 c0218v03 = null;
            try {
                try {
                    c0218v0 = new C0218v0();
                } catch (Throwable th2) {
                    c0218v0 = c0218v02;
                    th = th2;
                }
            } catch (Exception unused) {
            }
            try {
                c0218v0.m201a(EGL14.EGL_NO_SURFACE);
                StringBuilder sb = new StringBuilder();
                sb.append(GLES20.glGetString(7936)).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fd58ac", new byte[]{107}));
                sb.append(GLES20.glGetString(7937)).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e3ea61", new byte[]{104}));
                sb.append(GLES20.glGetString(7938));
                String sb2 = sb.toString();
                f444a = sb2;
                c0218v0.m200a();
                c0218v02 = sb2;
            } catch (Exception unused2) {
                c0218v03 = c0218v0;
                f444a = f446c;
                c0218v02 = c0218v03;
                if (c0218v03 != null) {
                    c0218v03.m200a();
                    c0218v02 = c0218v03;
                }
                return f444a;
            } catch (Throwable th3) {
                th = th3;
                if (c0218v0 != null) {
                    c0218v0.m200a();
                }
                throw th;
            }
            return f444a;
        }
    }
}
