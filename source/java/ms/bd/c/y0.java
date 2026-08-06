package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* loaded from: classes8.dex */
public final class y0 {
    public final Context a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1024);
    public final x0 c = new x0(this);

    public y0(Context context) {
        this.a = context;
    }

    public final void a(y2 y2Var) {
        if (z2.a(this.a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "abb5f2", new byte[]{115, 111, 28, 15, 81, 48, 99, 84, 54, 108, 62, 104, 6, 72, 93}))) {
            Intent intent = new Intent((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "34ed76", new byte[]{33, 57, 27, 94, 29, 46, 52, 28, 39, 122, 45, 38, 19, 30, 12, 36, 38, 28, 55, 49, 108, 25, 38, 53, 38, 8, 20, 38, 11, 7, 7, 4, 32, 57, 43, 4}));
            intent.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b54fa8", new byte[]{112, 56, 74, 92, 86, 58, 96, 3, 96, Utf8.REPLACEMENT_BYTE, Base64.padSymbol, Utf8.REPLACEMENT_BYTE, 80, 27, 90}));
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    y2Var.a.a = new z0((IBinder) this.b.take()).a();
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
