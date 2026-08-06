package ms.bd.c;

import android.os.HandlerThread;
import android.os.Message;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class k0 {
    public static volatile k0 c;
    public final h0 a;
    public j0 b;

    static {
        c = null;
    }

    public k0() {
        HandlerThread handlerThread = new HandlerThread((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "6a8263", new byte[]{3, 122, 102, 85, 14, 21, 32, 69, 124, 103}));
        handlerThread.start();
        this.a = new h0(this, handlerThread.getLooper());
    }

    public static k0 a() {
        if (c == null) {
            synchronized (k0.class) {
                if (c == null) {
                    c = new k0();
                }
            }
        }
        return c;
    }

    public final boolean a(i0 i0Var, String str) {
        h0 h0Var = this.a;
        if (h0Var == null) {
            return false;
        }
        if (i0Var == i0.d) {
            h0Var.removeMessages(i0Var.a);
            return true;
        }
        Message message = new Message();
        message.what = i0Var.ordinal();
        message.obj = str;
        return this.a.sendMessage(message);
    }
}
