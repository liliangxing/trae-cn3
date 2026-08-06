package ms.bd.c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.HandlerThread;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class u3 {
    public static volatile u3 f;
    public final HandlerThread a;
    public final Context b;
    public boolean c = false;
    public DisplayManager d;
    public e0 e;

    public u3(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context context2 = null;
            try {
                context2 = (Application) Class.forName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "47a00e", new byte[]{36, 59, 22, 86, 0, 123, 51, 88, 49, 112, 53, 123, 51, 71, 27, 123, 33, 31, 36, 121, 17, Base64.padSymbol, 0, 65, 14, 118})).getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "23394a", new byte[]{32, 36, 82, 95, 14, 120, 37, 51, 114, 121, 47, 56, 67, 76, 31, Byte.MAX_VALUE, 62, 28}), null).invoke(null, null);
            } catch (Throwable unused) {
            }
            this.b = context2 == null ? this.b : context2;
        }
        this.a = new HandlerThread((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "a1e5d9", new byte[]{93, 0, 37, 115}));
    }

    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        new Thread(new t3(this)).start();
    }

    public final void finalize() {
        e0 e0Var;
        synchronized (this) {
            try {
                DisplayManager displayManager = this.d;
                if (displayManager != null && (e0Var = this.e) != null) {
                    displayManager.unregisterDisplayListener(e0Var);
                }
            } catch (Throwable unused) {
            }
            HandlerThread handlerThread = this.a;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Throwable unused2) {
                }
            }
        }
        super.finalize();
    }
}
