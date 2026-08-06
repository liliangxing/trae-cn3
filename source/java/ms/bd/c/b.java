package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class b {
    public final Context a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    public final a c = new a(this);

    public b(Context context) {
        this.a = context;
    }

    public final void a(y2 y2Var) {
        if (z2.a(this.a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "50f1b7", new byte[]{39, Base64.padSymbol, 24, 11, 92, 51, 35, 2, 121, 108, 55, 51, 91, 118, 72, 48, 38, 29, 50, 108, 33, 60, 1, 68, 79, 57, 18, 56, 19}))) {
            Intent intent = new Intent();
            intent.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d94fdc", new byte[]{118, 52, 74, 92, 90, 103, 114, 11, 43, 59, 102, 58, 9, 19, 88, 96, 110, 23, 107, 120, 84, 24, 100, 55, 104, 71, 88, 60, 76, 18}));
            intent.setComponent(new ComponentName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "18d7cd", new byte[]{35, 53, 26, 13, 93, 96, 39, 10, 123, 106, 51, 59, 89, 112, 73, 99, 34, 21, 48, 106, 37, 52, 3, 66, 78, 106, 22, 48, 17}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d147fd", new byte[]{118, 60, 74, 13, 88, 96, 114, 3, 43, 106, 102, 50, 9, 112, 76, 99, 119, 28, 96, 106, 112, Base64.padSymbol, 83, 66, 75, 106, 67, 57, 65, 41, 70, 38, 87, 83, 85, 118, 106, 21, 107, 115, 116, 33, 94, 103, 112, 87, 84, 21, 119, 113, 124, 48, 66})));
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    y2Var.a.a = new c((IBinder) this.b.take()).a();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.a.unbindService(this.c);
                    throw th;
                }
                this.a.unbindService(this.c);
            }
        }
    }
}
