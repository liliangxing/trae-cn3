package ms.bd.p001c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: ms.bd.c.q2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0195q2 {

    /* renamed from: a */
    public final Context f323a;

    public C0195q2(Context context) {
        this.f323a = context;
    }

    /* renamed from: a */
    public final void m173a(C0235y2 c0235y2) {
        Cursor cursor;
        try {
            PackageManager packageManager = this.f323a.getPackageManager();
            if (packageManager != null) {
                if (packageManager.resolveContentProvider((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c6f554", new byte[]{113, 59, 24, 15, 7, 38, 105, 13, 34, 43, 116, 56, 12, 76, 15, 109, 111, 7, 50, 107, 123, 48, 6, 69, 1}), 0) != null) {
                    Uri parse = Uri.parse((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ecc3d9", new byte[]{119, 110, 30, 83, 94, 32, 114, 24, 125, 44, 119, 110, 29, 9, 86, 43, 111, 88, 39, 45, 114, 109, 9, 74, 94, 96, 105, 82, 55, 109, 125, 101, 3, 67, 80, 97}));
                    try {
                        cursor = this.f323a.getContentResolver().query(parse, null, null, new String[]{(String) AbstractC0190p2.m166a(16777217, 0, 0L, "ff1844", new byte[]{120, 101, 75, 72})}, null);
                    } catch (Throwable unused) {
                        cursor = null;
                    }
                    try {
                        c0235y2.f473a.f479a = m172a(cursor);
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

    /* renamed from: a */
    public static String m172a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) AbstractC0190p2.m166a(16777217, 0, 0L, "de1552", new byte[]{99, 102, 78, 84, 15}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) AbstractC0190p2.m166a(16777217, 0, 0L, "213e40", new byte[]{32, 60, 68, 20}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) AbstractC0190p2.m166a(16777217, 0, 0L, "05cbbf", new byte[]{36, 47, 0, 31, 79, 116, 55}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }
}
