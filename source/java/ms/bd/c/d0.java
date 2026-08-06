package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class d0 {
    public final y2 a;

    public d0(y2 y2Var) {
        this.a = y2Var;
    }

    public static String a(d0 d0Var) {
        return Build.MANUFACTURER.toUpperCase();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x015e, code lost:
    
        if (r1 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        Cursor cursor;
        String str;
        try {
            cursor = context.getContentResolver().query(Uri.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "c47dca", new byte[]{113, 57, 74, 4, 89, 120, 116, 79, 41, 123, 113, 57, 73, 94, 91, 121, 111, 18, 106, 49, 60, 55, 74, 20, 78, 121, 105, 17, 40, 51, 97, 48, 10, 23, 79, 115, 114, 3, 111, 55, 119, 37})), null, null, new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "6c3e01", new byte[]{38, 111, 68, 3, 0, 47, 49, 125, 107, 49})}, null);
        } catch (Exception unused) {
            str = null;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        }
        str = null;
        try {
            if (cursor.moveToFirst() && cursor.getColumnCount() >= 2) {
                str = cursor.getString(1);
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
        return str;
    }

    public static String a(Context context) {
        c0 c0Var = new c0();
        Intent intent = new Intent((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "1b5831", new byte[]{35, 111, 75, 2, 11, 41, Base64.padSymbol, 68, 104, 109, 110, 97, 72, 72, 30, 41, 59, 71, 42, 111, 45, 115, 8, 77, 8, 53, 124, 74, 96, 109, 46, 116, 79, 74, 5, 35, 32, 13, 119, 109, 50, 118, 79, 79, 9, 104, 1, 119, 69, 90, 20}));
        intent.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "df794c", new byte[]{118, 107, 73, 3, 12, 123, 104, 64, 106, 108, 59, 101, 74, 73, 25, 123, 110, 67, 40, 110, 120, 119}));
        if (!context.bindService(intent, c0Var, 1)) {
            return null;
        }
        try {
            return c0Var.a();
        } finally {
            context.unbindService(c0Var);
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "cc3972", new byte[]{115, 111, 68, 95, 7, 44, 100, 12, 109, 122, 60, 82, 89, 94, 28, 32, 109, 114, 112, 102, 98, 100, 82, 89, 1, 32, 115}));
            return (String) cls.getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "924615", new byte[]{47, 53, 83}), String.class, String.class).invoke(cls, str, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "099260", new byte[]{52, 53, 65, 72, 6, 48, Base64.padSymbol}));
        } catch (Exception unused) {
            return null;
        }
    }
}
