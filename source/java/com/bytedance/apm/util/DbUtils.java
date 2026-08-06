package com.bytedance.apm.util;

import android.database.Cursor;

/* loaded from: classes3.dex */
public class DbUtils {
    public static void safeCloseCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }
}
