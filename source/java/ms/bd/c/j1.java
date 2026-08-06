package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import com.ss.ttm.player.MediaPlayer;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public final class j1 {
    public final Context a;
    public k1 b;
    public final i1 c = new i1(this);

    public j1(Context context) {
        this.a = context;
    }

    public final void a(y2 y2Var) {
        Intent intent = new Intent();
        intent.setClassName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "24610a", new byte[]{32, 57, 72, 11, 21, 99, 56, 91, 99, 100, 53, Utf8.REPLACEMENT_BYTE, 70, 64, 6, 114, 34, Tnaf.POW_2_WIDTH, 117, 119, 42, 53, 64}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "da27f1", new byte[]{118, 108, 76, 13, 67, 51, 110, 14, 103, 98, 99, 106, 66, 70, 80, 34, 116, 69, 113, 113, 124, 96, 68, 13, 125, 35, 113, 73, 96, 98, 124, 103, 114, 70, 75, 48, 110, 67, 102}));
        if (this.a.bindService(intent, this.c, 1)) {
            try {
                k1 k1Var = this.b;
                if (k1Var != null) {
                    y2Var.a.a = k1Var.a();
                }
            } catch (Throwable unused) {
            }
            this.a.unbindService(this.c);
        }
    }
}
