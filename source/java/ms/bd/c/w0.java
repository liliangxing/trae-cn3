package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.GLES20;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public abstract class w0 {
    public static volatile String a;
    public static final String b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b306cc", new byte[]{50, 36, 77, 81, 73, 100, 113, 29, 115, 114, 118, 53, 2});
    public static final String c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8bcf51", new byte[]{104, 101, 2, 0, 75});

    /* JADX WARN: Multi-variable type inference failed */
    public static String a() {
        v0 v0Var;
        Throwable th;
        if (a != null) {
            return a;
        }
        synchronized (w0.class) {
            if (a != null) {
                return a;
            }
            v0 v0Var2 = null;
            v0 v0Var3 = null;
            try {
                try {
                    v0Var = new v0();
                } catch (Throwable th2) {
                    v0Var = v0Var2;
                    th = th2;
                }
            } catch (Exception unused) {
            }
            try {
                v0Var.a(EGL14.EGL_NO_SURFACE);
                StringBuilder sb = new StringBuilder();
                sb.append(GLES20.glGetString(7936)).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "fd58ac", new byte[]{107}));
                sb.append(GLES20.glGetString(7937)).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "e3ea61", new byte[]{104}));
                sb.append(GLES20.glGetString(7938));
                String sb2 = sb.toString();
                a = sb2;
                v0Var.a();
                v0Var2 = sb2;
            } catch (Exception unused2) {
                v0Var3 = v0Var;
                a = c;
                v0Var2 = v0Var3;
                if (v0Var3 != null) {
                    v0Var3.a();
                    v0Var2 = v0Var3;
                }
                return a;
            } catch (Throwable th3) {
                th = th3;
                if (v0Var != null) {
                    v0Var.a();
                }
                throw th;
            }
            return a;
        }
    }
}
