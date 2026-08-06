package ms.bd.c;

import android.util.Base64;
import com.ss.android.update.UpdateDialogNewBase;
import com.ss.ttm.player.MediaPlayer;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class x1 {
    public static final String e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7ce50b", new byte[]{50});
    public static final String f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1ea8ad", new byte[]{50});
    public static final String g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "927675", new byte[]{59});
    public static final String h = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e19cea", new byte[]{114});
    public static final String i = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fdf624", new byte[]{116});
    public final int a;
    public final String b;
    public final String c;
    public final Throwable d;

    public x1(int i2, String str, String str2, Throwable th) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = th;
    }

    public final String[] a() {
        String str;
        String str2;
        String str3;
        String valueOf = String.valueOf(this.a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e, System.currentTimeMillis());
            jSONObject.put(f, this.a);
            if (this.d != null) {
                str2 = g;
                StringBuilder sb = new StringBuilder();
                sb.append(this.d.getMessage());
                StackTraceElement[] stackTrace = this.d.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    int i4 = i3 + 1;
                    if (i3 >= 3) {
                        break;
                    }
                    sb.append(UpdateDialogNewBase.TYPE);
                    sb.append(stackTraceElement.toString());
                    i2++;
                    i3 = i4;
                }
                str3 = sb.toString();
            } else {
                jSONObject.put(h, this.b);
                str2 = i;
                str3 = this.c;
            }
            jSONObject.put(str2, str3);
            str = Base64.encodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 2);
        } catch (Throwable unused) {
            str = "";
        }
        return new String[]{valueOf, str};
    }
}
