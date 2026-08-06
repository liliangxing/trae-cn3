package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import okio.Utf8;

/* loaded from: classes8.dex */
public final class p3 {
    public final Context a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    public final o3 c = new o3(this);

    public p3(Context context) {
        this.a = context;
    }

    public final void a(y2 y2Var) {
        if (z2.a(this.a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "be8b06", new byte[]{112, 104, 70, 88, 28, 32, 108, 87, 124, 60, 116, 41, 74, 24, 11, 51, 110, 77, 109, 124, 119, 98, 93, 31, 12, 36, 104, 64, 122, 55, 97, 113, 66, 21, 10}))) {
            boolean z = false;
            try {
                this.a.getPackageManager().getPackageInfo((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "531ba1", new byte[]{39, 62, 79, 88, 77, 39, 59, 1, 117, 60, 35, Byte.MAX_VALUE, 67, 24, 90, 52, 57, 27, 100, 124, 32, 52, 84, 31, 93, 35, Utf8.REPLACEMENT_BYTE, 22, 115, 55, 54, 39, 75, 21, 91}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent();
            intent.setClassName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "6bd7f3", new byte[]{36, 111, 26, 13, 74, 37, 56, 80, 32, 105, 32, 46, 22, 77, 93, 54, 58, 74, 49, 41, 35, 101, 1, 74, 90, 33, 60, 71, 38, 98, 53, 118, 30, 64, 92}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5ca9c7", new byte[]{39, 110, 31, 3, 79, 33, 59, 81, 37, 103, 35, 47, 19, 67, 88, 50, 57, 75, 52, 39, 32, 100, 4, 68, 95, 37, Utf8.REPLACEMENT_BYTE, 70, 35, 108, 54, 119, 27, 78, 89, 110, 18, 71, 38, 96, 39, 100, 59, 73, 111, 37, 36, 84, 57, 106, 33}));
            try {
                z = this.a.bindService(intent, this.c, 1);
                if (z) {
                    y2Var.a.a = new q3((IBinder) this.b.take()).a();
                }
                if (!z) {
                    return;
                }
            } catch (Exception unused2) {
                if (!z) {
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    this.a.unbindService(this.c);
                }
                throw th;
            }
            this.a.unbindService(this.c);
        }
    }
}
