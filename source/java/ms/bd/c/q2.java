package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class q2 {
    public final Context a;

    public q2(Context context) {
        this.a = context;
    }

    public final void a(y2 y2Var) {
        Cursor cursor;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager != null) {
                if (packageManager.resolveContentProvider((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "c6f554", new byte[]{113, 59, 24, 15, 7, 38, 105, 13, 34, 43, 116, 56, 12, 76, 15, 109, 111, 7, 50, 107, 123, 48, 6, 69, 1}), 0) != null) {
                    Uri parse = Uri.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "ecc3d9", new byte[]{119, 110, 30, 83, 94, 32, 114, 24, 125, 44, 119, 110, 29, 9, 86, 43, 111, 88, 39, 45, 114, 109, 9, 74, 94, 96, 105, 82, 55, 109, 125, 101, 3, 67, 80, 97}));
                    try {
                        cursor = this.a.getContentResolver().query(parse, null, null, new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "ff1844", new byte[]{120, 101, 75, 72})}, null);
                    } catch (Throwable unused) {
                        cursor = null;
                    }
                    try {
                        y2Var.a.a = a(cursor);
                        if (cursor == null) {
                            return;
                        }
                    } catch (Throwable unused2) {
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                    cursor.close();
                }
            }
        } catch (Exception unused3) {
        }
    }

    public static String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "de1552", new byte[]{99, 102, 78, 84, 15}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "213e40", new byte[]{32, 60, 68, 20}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "05cbbf", new byte[]{36, 47, 0, 31, 79, 116, 55}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }
}
