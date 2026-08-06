package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.util.Locale;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class u1 implements Cloneable {
    public long a;
    public long b;
    public long c;
    public long d;
    public final t1 e = new t1();
    public long f;

    static {
    }

    public final String toString() {
        this.e.getClass();
        Locale locale = Locale.US;
        String str = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "607e6f", new byte[]{98, 54, 8, 84, 13, Base64.padSymbol, 112, 21, 42, 112, 35, 126, 1, 2});
        Long valueOf = Long.valueOf(this.a);
        Long valueOf2 = Long.valueOf(this.b);
        Long valueOf3 = Long.valueOf(this.c);
        long j = this.d;
        return String.format(locale, str, valueOf, valueOf2, valueOf3, Long.valueOf(j != 0 ? this.f - j : 0L), this.e);
    }

    public final u1 clone() {
        try {
            return (u1) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
