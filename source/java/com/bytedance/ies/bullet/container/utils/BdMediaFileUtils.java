package com.bytedance.ies.bullet.container.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import com.bytedance.bdturing.EventReport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class BdMediaFileUtils {
    private static final String[] IMAGE_PROJECTION_HIGH = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "relative_path", "_data", "datetaken", EventReport.SCREEN_ORIENTATION};
    private static final String[] IMAGE_PROJECTION_LOW = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data", "datetaken", EventReport.SCREEN_ORIENTATION};
    public static final String QUERY_ARG_SQL_LIMIT = "android:query-arg-sql-limit";
    private static final String RELATIVE_PATH = "relative_path";

    public static List<BdMediaItem> getImages(Context context, String str, String[] strArr, String str2, int i, int i2) {
        Cursor query;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str3 = str2;
        ArrayList arrayList = new ArrayList();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = null;
        try {
            if (isAndroidROrLater()) {
                query = context.getContentResolver().query(uri, IMAGE_PROJECTION_HIGH, createQueryBundle(str, strArr, i, i2), null);
            } else if (isAndroidQOrLater()) {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri, IMAGE_PROJECTION_HIGH, str, strArr, str3);
            } else {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri, IMAGE_PROJECTION_LOW, str, strArr, str3);
            }
            cursor = query;
        } finally {
        }
        if (cursor == null) {
            return arrayList;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_added");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("mime_type");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("width");
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("height");
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("datetaken");
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow(EventReport.SCREEN_ORIENTATION);
        int columnIndexOrThrow11 = isAndroidQOrLater() ? cursor.getColumnIndexOrThrow("relative_path") : 0;
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("_data");
        ArrayList arrayList2 = arrayList;
        int length = (Environment.getExternalStorageDirectory().getPath() + "/").length();
        while (cursor.moveToNext()) {
            BdMediaItem bdMediaItem = new BdMediaItem();
            int i8 = columnIndexOrThrow11;
            int i9 = columnIndexOrThrow12;
            long j = cursor.getLong(columnIndexOrThrow);
            bdMediaItem.setId(j);
            int i10 = columnIndexOrThrow;
            bdMediaItem.setName(cursor.getString(columnIndexOrThrow2));
            int i11 = columnIndexOrThrow2;
            bdMediaItem.setModify(cursor.getLong(columnIndexOrThrow3));
            bdMediaItem.setDateAdded(cursor.getLong(columnIndexOrThrow4));
            bdMediaItem.setMimeType(cursor.getString(columnIndexOrThrow5));
            bdMediaItem.setFileSize(cursor.getLong(columnIndexOrThrow6));
            bdMediaItem.setWidth(cursor.getInt(columnIndexOrThrow7));
            bdMediaItem.setHeight(cursor.getInt(columnIndexOrThrow8));
            bdMediaItem.setDateToken(cursor.getLong(columnIndexOrThrow9));
            bdMediaItem.setOrientation(cursor.getInt(columnIndexOrThrow10));
            if (isAndroidQOrLater()) {
                String string = cursor.getString(i8);
                if (string == null) {
                    i7 = i8;
                    i3 = i9;
                    i4 = columnIndexOrThrow3;
                    String string2 = cursor.getString(i3);
                    i5 = columnIndexOrThrow4;
                    i6 = columnIndexOrThrow5;
                    try {
                        string = string2.substring(length, string2.lastIndexOf(File.separator)) + File.separator;
                    } catch (IndexOutOfBoundsException unused) {
                        bdMediaItem.setRelativePath("");
                    }
                } else {
                    i7 = i8;
                    i5 = columnIndexOrThrow4;
                    i6 = columnIndexOrThrow5;
                    i3 = i9;
                    i4 = columnIndexOrThrow3;
                }
                bdMediaItem.setRelativePath(string);
                bdMediaItem.setUri(ContentUris.withAppendedId(uri, j));
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(bdMediaItem);
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow11 = i7;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow5 = i6;
                columnIndexOrThrow12 = i3;
                arrayList2 = arrayList3;
                columnIndexOrThrow = i10;
                columnIndexOrThrow2 = i11;
            } else {
                i3 = i9;
                i4 = columnIndexOrThrow3;
                i5 = columnIndexOrThrow4;
                i6 = columnIndexOrThrow5;
                i7 = i8;
                String string3 = cursor.getString(i3);
                try {
                    bdMediaItem.setRelativePath(string3.substring(length, string3.lastIndexOf(File.separator)) + File.separator);
                } catch (IndexOutOfBoundsException unused2) {
                    bdMediaItem.setRelativePath("");
                }
                bdMediaItem.setUri(ContentUris.withAppendedId(uri, j));
                ArrayList arrayList32 = arrayList2;
                arrayList32.add(bdMediaItem);
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow11 = i7;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow5 = i6;
                columnIndexOrThrow12 = i3;
                arrayList2 = arrayList32;
                columnIndexOrThrow = i10;
                columnIndexOrThrow2 = i11;
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        ArrayList arrayList4 = arrayList2;
        if (cursor != null) {
            cursor.close();
        }
        return arrayList4;
    }

    public static Bundle createQueryBundle(String str, String[] strArr, int i, int i2) {
        Bundle bundle = new Bundle();
        if (isAndroidQOrLater()) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            if (isAndroidQOrLater() && i > 0) {
                bundle.putString(QUERY_ARG_SQL_LIMIT, i + " offset " + i2);
            }
        }
        return bundle;
    }

    public static boolean isAndroidROrLater() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAndroidQOrLater() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
