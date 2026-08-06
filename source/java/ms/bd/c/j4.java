package ms.bd.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* loaded from: classes8.dex */
public final class j4 {
    public final Context a;

    public j4(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x01c2, code lost:
    
        if (r6 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a() {
        int i;
        String str = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "755524", new byte[]{54, 50, 84, 82, 4, 48, 32, 90, 119, 124, 53, 121, 79, 69, 8, 45, 32, 29, 98, 108, 35, 37, 79, 69, 67, 48, 33, 4, 116, 106, 52, 35, 67, 69});
        String str2 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "cbe188", new byte[]{34});
        try {
            i = 2;
            try {
                Class<?> cls = Class.forName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "55cbfc", new byte[]{37, 57, 20, 4, 86, 125, 50, 90, Base64.padSymbol, 33, 106, 4, 9, 5, 77, 113, 59, 36, 32, Base64.padSymbol, 52, 50, 2, 2, 80, 113, 37}));
                str2 = (String) cls.getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "014728", new byte[]{38, 54, 83}), String.class, String.class).invoke(cls, str, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "4b9c57", new byte[]{48, 110, 65, 25, 5, 55, 57}));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 2;
        }
        String str3 = null;
        if (!str2.equals((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b77b5c", new byte[]{34}))) {
            return null;
        }
        Cursor query = this.a.getContentResolver().query(Uri.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0b0883", new byte[]{34, 111, 77, 88, 2, 42, 39, 25, 46, 39, 34, 111, 78, 2, 17, 45, 37, 76, 47, 126, 44, 115, 13, 101, 3, 20, 33, 76, 119, 97, 37, 101, 81, 3, 46, 32, 54, 77, 117, 97, 39, 105, 70, 94, 46, 32, 124, 108, 64, 65, 5})), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    byte[] bArr = new byte[5];
                    bArr[0] = 49;
                    bArr[1] = 54;
                    bArr[i] = 27;
                    bArr[3] = 84;
                    bArr[4] = 94;
                    str3 = query.getString(query.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "65d5d9", bArr)));
                }
            } finally {
                try {
                    try {
                    } catch (Throwable unused3) {
                        return str3;
                    }
                } finally {
                    try {
                        query.close();
                    } catch (Throwable unused4) {
                    }
                }
            }
        }
    }
}
