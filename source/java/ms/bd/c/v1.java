package ms.bd.c;

import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* loaded from: classes8.dex */
public final class v1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;

    static {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v1() {
        Object a;
        Object a2;
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.f = false;
        String str = (String) p2.a(16777224, 0, 0L, null, null);
        if (TextUtils.isEmpty(str)) {
            this.e = true;
            a2 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f8fdd7", new byte[]{71, 59, 7, 3, 94, 96, 102, 22, 57, 50, 126, Base64.padSymbol, 85, 22, 90, 41, 105, 28, 51, 116, 120, 40, 85, 4, 83, 37, 37, 26, 56, 58, 113, 51, 18, 80, 76, 33, 118, 89, 57, 59, 99, 122, 6, 21, 79, 110});
        } else {
            String[] split = str.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "7acdf4", new byte[]{26, Byte.MAX_VALUE}));
            if (split.length != 3) {
                this.e = true;
                a2 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "dd709b", new byte[]{86, 105, 74, 66, 15, 114, 39, 82, 103, 115, 53, 111, 74, 4, 18, 125, 98, 5, 113, 114, 122, 104, 67, 4, 0, 122, 117, 72, 103, 116, 59});
            } else {
                int parseInt = Integer.parseInt(split[0]);
                this.a = parseInt;
                int parseInt2 = Integer.parseInt(split[1]);
                this.b = parseInt2;
                int parseInt3 = Integer.parseInt(split[2]);
                this.c = parseInt3;
                if (parseInt < 0 || parseInt2 < 0 || parseInt < parseInt2 || parseInt3 == 0) {
                    this.e = true;
                    a = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b78485", new byte[]{80, 58, 69, 70, 14, 37, 33, 1, 104, 119, 51, 38, 78, 84, 71, 43, 111, 86, 125, 108, 118, 117, 92, 82, 8, 44, 102, 86, 126, 101, 106, 123});
                } else {
                    if (parseInt2 != 0 || parseInt != 0) {
                        this.f = true;
                        if (this.f) {
                            this.d = this.a - this.b;
                            return;
                        }
                        return;
                    }
                    a = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "620ed8", new byte[]{4, Utf8.REPLACEMENT_BYTE, 77, 23, 82, 40, 117, 4, 96, 38, 103, 35, 70, 5, 27, 43, 60, 0, 96, 55, 43, 53, 71, 95});
                }
                if (this.f) {
                }
            }
        }
        if (this.f) {
        }
    }

    public final String toString() {
        return String.format(Locale.US, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5570fb", new byte[]{33, 37, 86, 30, 28, 102, 42, 17, 104, 97, 38, 59, 65, 64, 3, 48, 37, 8, 35, 100, 104, 114, 64, 8, 28, 113}), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
    }
}
