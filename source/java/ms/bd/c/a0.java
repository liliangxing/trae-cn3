package ms.bd.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.TimeZone;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public abstract class a0 {
    public static String a() {
        String str;
        int i;
        TimeZone timeZone;
        try {
            timeZone = TimeZone.getDefault();
            str = timeZone.getID();
        } catch (Throwable unused) {
            str = null;
        }
        try {
            i = ((timeZone.getRawOffset() / 60) / 60) / 1000;
        } catch (Throwable unused2) {
            i = 0;
            return str + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "703361", new byte[]{106})) + i;
        }
        return str + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "703361", new byte[]{106})) + i;
    }

    public static int a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "226a9b", new byte[]{51, Utf8.REPLACEMENT_BYTE, 82, Tnaf.POW_2_WIDTH, 20}));
        if (powerManager == null) {
            return 0;
        }
        if (!powerManager.isInteractive()) {
            return 1;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "a5a2be", new byte[]{123, 50, 11, 65, 72, 115, 112, Tnaf.POW_2_WIDTH}));
        if (keyguardManager == null) {
            return 0;
        }
        return keyguardManager.inKeyguardRestrictedInputMode() ? 2 : 3;
    }
}
