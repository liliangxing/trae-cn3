package ms.bd.p001c;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import java.util.TimeZone;
import kotlinx.datetime.internal.DateCalculationsKt;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.a0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0102a0 {
    /* renamed from: a */
    public static String m68a() {
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
            i = ((timeZone.getRawOffset() / 60) / 60) / DateCalculationsKt.MILLIS_PER_ONE;
        } catch (Throwable unused2) {
            i = 0;
            return str + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "703361", new byte[]{106})) + i;
        }
        return str + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "703361", new byte[]{106})) + i;
    }

    /* renamed from: a */
    public static int m67a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "226a9b", new byte[]{51, Utf8.REPLACEMENT_BYTE, 82, Tnaf.POW_2_WIDTH, 20}));
        if (powerManager == null) {
            return 0;
        }
        if (!powerManager.isInteractive()) {
            return 1;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a5a2be", new byte[]{123, 50, 11, 65, 72, 115, 112, Tnaf.POW_2_WIDTH}));
        if (keyguardManager == null) {
            return 0;
        }
        return keyguardManager.inKeyguardRestrictedInputMode() ? 2 : 3;
    }
}
