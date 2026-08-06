package ms.bd.c;

import android.content.Context;
import android.os.Process;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public abstract class d3 {
    public static boolean a(String... strArr) {
        try {
            Context context = d2.b.a;
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        return a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5c1e9e", new byte[]{37, 111, 70, 3, 9, 123, 50, 12, 112, 48, 54, 108, 75, 2, 21, 123, 57, 76, 46, 20, 7, 66, 103, 34, 53, 77, 1, 107, 70, 28, 27, 82, 118, 48, 50, 87}));
    }
}
