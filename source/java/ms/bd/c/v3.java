package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import com.ss.ttm.player.MediaPlayer;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class v3 {
    public static volatile v3 d;
    public static final JSONObject e = new JSONObject();
    public final Context a;
    public boolean b = false;
    public s3 c;

    public v3(Context context) {
        this.a = context.getApplicationContext();
    }

    public static v3 a(Context context) {
        if (d == null) {
            synchronized (v3.class) {
                if (d == null) {
                    d = new v3(context);
                }
            }
        }
        return d;
    }

    public final synchronized void b() {
        Context context;
        try {
            if (this.b && (context = this.a) != null && Build.VERSION.SDK_INT >= 35) {
                this.c = new s3();
                ((WindowManager) context.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d87c2f", new byte[]{98, 51, 74, 19, 2, 102}))).addScreenRecordingCallback(this.a.getMainExecutor(), this.c);
            }
        } catch (Throwable unused) {
        }
    }

    public final void finalize() {
        synchronized (this) {
            if (this.b && Build.VERSION.SDK_INT >= 35) {
                if (this.c != null) {
                    ((WindowManager) this.a.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d54e11", new byte[]{98, 62, 73, 21, 1, 49}))).removeScreenRecordingCallback(this.c);
                }
                this.b = false;
            }
        }
        super.finalize();
    }

    public final synchronized void a() {
        if (this.b) {
            return;
        }
        this.b = true;
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        b();
    }
}
