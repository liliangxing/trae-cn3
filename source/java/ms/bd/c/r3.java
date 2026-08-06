package ms.bd.c;

import android.text.TextUtils;
import android.view.Display;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bouncycastle.math.ec.Tnaf;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class r3 {
    public static r3 j;
    public long a;
    public long b;
    public long c;
    public int d = 1;
    public long e;
    public String f;
    public String g;
    public String h;
    public boolean i;

    public static String a(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object a = a(display, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "ea21a1", new byte[]{121, 71, 72, 86, 78, 42, 103, 89, 74, 111, 114, 108}));
                sb2.append(a(a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f22b10", new byte[]{120, 39, 79, 19, 28, 23, 100, Tnaf.POW_2_WIDTH, 104, 51, 112, 53, 111, 23, 3, 34}))).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "4ba1b2", new byte[]{105}));
                sb2.append(a(a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "28fc58", new byte[]{37, 54, 20, Tnaf.POW_2_WIDTH, 25}))).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "56b230", new byte[]{104}));
                sb2.append(a(a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "cd029e", new byte[]{124, 103, 78, 67}))).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "fb719f", new byte[]{59}));
                sb2.append(a(a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "ed6bca", new byte[]{96, Byte.MAX_VALUE, 85, 19})));
                if (!sb.toString().contains(sb2.toString())) {
                    if (sb.length() > 0) {
                        sb.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "880e3e", new byte[]{114}));
                    }
                    sb.append((CharSequence) sb2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object a = a(display, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "7c6225", new byte[]{43, 78, 82, 72, 8, 48, 4, 67, 100, 105, 39, 102, 64, 104, 12, 47, 49}));
                if (a != null && !sb.toString().contains(a.toString())) {
                    sb.append(a);
                    sb.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "97fc79", new byte[]{115}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "9e49b9", new byte[]{47, 98, 83, 105, 88, 45, 54, 69, 119, 108, 44, 65, 78, 72, 81, 42}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "e3d03f", new byte[]{117, 37}), this.a);
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "2883e4", new byte[]{49, 46}), this.b);
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "43c9f0", new byte[]{33, 60}), this.d);
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "9a8558", new byte[]{44, 119}), this.e);
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f92e31", new byte[]{116, 58, 69}), this.i ? 1 : 0);
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f7ddf8", new byte[]{122, 49}), this.f);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "9dc04f", new byte[]{56, 109}), this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "033488", new byte[]{37, 56}), this.h);
            }
            this.c = System.currentTimeMillis();
            jSONObject.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "2d9c91", new byte[]{32, 114}), this.c / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
