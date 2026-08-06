package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class s {
    public static s f;
    public final SharedPreferences a;
    public ArrayList b = new ArrayList(10);
    public static final String c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e5c990", new byte[]{59, 52, 17, 93, 18, 36, 110, 21, 125, Byte.MAX_VALUE, 113, 37, 25, 75, 31});
    public static final String d = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ad8651", new byte[]{Utf8.REPLACEMENT_BYTE, 118, 74, 81, 25, 54, 109, 87, 125, 41, 125, 105, 73, 75, 6, 35, 45, 72, 102, 100, 121, 106, 78, 125, 9, 39, 112, 65, 86, 106, Byte.MAX_VALUE, 97, 66, 76, 69});
    public static final String e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "83d835", new byte[]{102, 33, 22, 95, 31, 50, 52, 0, 33, 39, 36, 62, 21, 69, 0, 39, 116, 1, 56, 123, 22, Base64.padSymbol, 24, 75, 5, 44, 116});
    public static final String g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "741fa3", new byte[]{52, 51, 69, 23, 70, 27, 57, 26, 100, 51, 25, 58, 75, 1, 74});

    public s(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.a = defaultSharedPreferences;
        a(defaultSharedPreferences.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "593f0d", new byte[]{54, 62, 71, 23, 23, 76, 59, 23, 102, 51, 27, 55, 73, 1, 27}), ""), false);
        if (this.b.size() < 1) {
            Object a = p2.a(33554445, 3, 0L, null, null);
            Object a2 = p2.a(33554445, 2, 0L, null, null);
            Object a3 = p2.a(33554445, 1, 0L, null, null);
            if (a != null && ((Integer) a).intValue() != 0) {
                this.b.add(new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0a0e5c", new byte[]{110, 96, 66, 1, 30, 119, 59, 65, 46, 35, 36, 113, 74, 23, 19}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "095e8a", new byte[]{50, 34, 72, 18})));
            }
            if (a2 != null && ((Integer) a2).intValue() == 1) {
                this.b.add(new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "e61670", new byte[]{59, 36, 67, 81, 27, 55, 105, 5, 116, 41, 121, 59, 64, 75, 4, 34, 41, 26, 111, 100, 125, 56, 71, 125, 11, 38, 116, 19, 95, 106, 123, 51, 75, 76, 71}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "3beb37", new byte[]{49, 121, 24, 21})));
            }
            if (a3 == null || ((Integer) a3).intValue() != 1) {
                return;
            }
            this.b.add(new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "9c7828", new byte[]{103, 113, 69, 95, 30, Utf8.REPLACEMENT_BYTE, 53, 80, 114, 39, 37, 110, 70, 69, 1, 42, 117, 81, 107, 123, 23, 109, 75, 75, 4, 33, 117}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d04d13", new byte[]{102, 43, 73, 19})));
        }
    }

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (s.class) {
            if (f == null) {
                f = new s(context);
            }
            sVar = f;
        }
        return sVar;
    }

    public final synchronized void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList(20);
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b0e83b", new byte[]{101, 55, 4, 95, 5, 122, 111}));
        String string2 = jSONObject.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "02e611", new byte[]{51, 37, 26, 71, 29}));
        if (((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "abfd97", new byte[]{33})).equals(string) && string2 != null) {
            for (String str2 : string2.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "34e61f", new byte[]{30, 42}))) {
                String[] split = str2.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "7beba9", new byte[]{124}));
                if (split != null && split.length >= 2) {
                    arrayList.add(new r(new String(q.b(split[0])), split[1]));
                }
            }
        }
        this.b = arrayList;
        if (z) {
            this.a.edit().putString(g, str).apply();
        }
    }
}
