package bytedance.io;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import bytedance.util.DtfsUtils;
import coil3.util.Utils_commonKt;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class BdMediaFileSystem {
    private static final String COLUMN_DURATION = "duration";
    private static final String COLUMN_ORIENTATION = "orientation";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    private static final String SELECTION_ALL = "(media_type=? OR media_type=?) AND _size>0 AND width>0";
    private static final String[] IMAGE_PROJECTION_HIGH = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "relative_path", "_data", "datetaken", "orientation"};
    private static final String[] IMAGE_PROJECTION_LOW = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data", "datetaken", "orientation"};
    private static final String[] VIDEO_PROJECTION_HIGH = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "width", "height", "relative_path", "_data", "datetaken", "resolution", "orientation"};
    private static final String[] VIDEO_PROJECTION_LOW = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "width", "height", "_data", "datetaken", "resolution"};
    private static final String[] AUDIO_PROJECTION_HIGH = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "is_music", "album", "album_id", "artist", "title", "relative_path", "_data", "datetaken"};
    private static final String[] AUDIO_PROJECTION_LOW = {"_id", "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "album", "album_id", "artist", "title", "is_music", "_data"};
    private static final String COLUMN_BUCKET_ID = "bucket_id";
    private static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final String[] ALBUM_PROJECTION_HIGH = {"_id", "_display_name", "date_added", "mime_type", "_size", "width", "height", "duration", "relative_path", "_data", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "orientation"};
    private static final String[] ALBUM_COUNT_PROJECTION = {"_id", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
    private static final String[] ALBUM_PROJECTION_LOW = {"_id", "_display_name", "date_added", "mime_type", "_size", "width", "height", "duration", "_data", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "orientation"};
    private static final String[] SELECTION_ALL_ARGS = {String.valueOf(1), String.valueOf(3)};
    private static final String[] SELECT_IMAGE = {Utils_commonKt.MIME_TYPE_JPEG, "image/png", "image/gif", Utils_commonKt.MIME_TYPE_WEBP, "image/bmp"};
    private static final String[] SELECT_VIDEOS = {"video/webm", "video/mp4", "video/ogg", "video/flv", "video/avi", "video/wmv", "video/rmvb"};
    private static final String[] SELECT_AUDIOS = {"audio/mp3", "audio/midi", "audio/wav", "audio/m3u", "audio/m4a", "audio/ogg", "audio/ra"};

    public static long getLength(Context context, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath()).length();
        }
        if ("content".equals(uri.getScheme())) {
            try {
                return context.getContentResolver().openFileDescriptor(uri, DownloadFileUtils.MODE_READ).getStatSize();
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static Uri createImageUri(Context context, String str) {
        return createImageUri(context, str, Utils_commonKt.MIME_TYPE_JPEG);
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera");
        if (!file.exists()) {
            file.mkdirs();
        }
        return createImageUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createImageUri(Context context, String str, String str2, String str3) {
        return createImageUri(context, str, str2, str3, null);
    }

    public static Uri createImageUri(Context context, String str, String str2, String str3, ContentValues contentValues) {
        Uri uri;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + "/";
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", str2);
        if (DtfsUtils.isAndroidQOrLater()) {
            uri = MediaStore.Images.Media.getContentUri("external_primary");
            contentValues.put("relative_path", str3);
        } else {
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            contentValues.put("_data", DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str));
            uri = uri2;
        }
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static Uri createVideoUri(Context context, String str) {
        return createVideoUri(context, str, "video/mp4");
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera");
        if (!file.exists()) {
            file.mkdirs();
        }
        return createVideoUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createVideoUri(Context context, String str, String str2, String str3) {
        return createVideoUri(context, str, str2, str3, null);
    }

    public static Uri createVideoUri(Context context, String str, String str2, String str3, ContentValues contentValues) {
        Uri uri;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + "/";
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", str2);
        if (DtfsUtils.isAndroidQOrLater()) {
            uri = MediaStore.Video.Media.getContentUri("external_primary");
            contentValues.put("relative_path", str3);
        } else {
            Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            contentValues.put("_data", DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str));
            uri = uri2;
        }
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static Uri createMusicUri(Context context, String str) {
        return createMusicUri(context, str, "audio/mp3");
    }

    public static Uri createMusicUri(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_MUSIC);
        if (!file.exists()) {
            file.mkdirs();
        }
        return createMusicUri(context, str, str2, Environment.DIRECTORY_MUSIC + "/");
    }

    public static Uri createMusicUri(Context context, String str, String str2, String str3) {
        return createMusicUri(context, str, str2, str3, null);
    }

    public static Uri createMusicUri(Context context, String str, String str2, String str3, ContentValues contentValues) {
        Uri uri;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + "/";
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", str2);
        if (DtfsUtils.isAndroidQOrLater()) {
            uri = MediaStore.Audio.Media.getContentUri("external_primary");
            contentValues.put("relative_path", str3);
        } else {
            Uri uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            contentValues.put("_data", DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str));
            uri = uri2;
        }
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static List<BdMediaItem> getVideos(Context context, String str, String[] strArr, String str2, int i, int i2) {
        return getVideos(context, str, strArr, str2, i, i2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0277 A[FINALLY_INSNS] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<BdMediaItem> getVideos(Context context, String str, String[] strArr, String str2, int i, int i2, boolean z) {
        Cursor query;
        int i3;
        ArrayList arrayList;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3 = str2;
        ArrayList arrayList2 = new ArrayList();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = null;
        try {
            if (DtfsUtils.isAndroidROrLater()) {
                query = context.getContentResolver().query(uri, VIDEO_PROJECTION_HIGH, DtfsUtils.createQueryBundle(str, strArr, i, i2, str3), null);
            } else if (DtfsUtils.isAndroidQOrLater()) {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri, VIDEO_PROJECTION_HIGH, str, strArr, str3);
            } else {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri, VIDEO_PROJECTION_LOW, str, strArr, str3);
            }
            cursor = query;
        } finally {
            if (cursor != null) {
            }
        }
        if (cursor == null) {
            return arrayList2;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_added");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("mime_type");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("width");
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("height");
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("duration");
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("datetaken");
        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow("resolution");
        if (DtfsUtils.isAndroidQOrLater()) {
            i3 = cursor.getColumnIndexOrThrow("relative_path");
            i4 = cursor.getColumnIndexOrThrow("orientation");
            arrayList = arrayList2;
        } else {
            i3 = -1;
            arrayList = arrayList2;
            i4 = -1;
        }
        Uri uri2 = uri;
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("_data");
        int length = (Environment.getExternalStorageDirectory().getPath() + "/").length();
        while (cursor.moveToNext()) {
            BdMediaItem bdMediaItem = new BdMediaItem();
            int i13 = i3;
            int i14 = i4;
            long j = cursor.getLong(columnIndexOrThrow);
            bdMediaItem.setId(j);
            int i15 = columnIndexOrThrow;
            int i16 = cursor.getInt(columnIndexOrThrow7);
            int i17 = columnIndexOrThrow7;
            int i18 = cursor.getInt(columnIndexOrThrow8);
            int i19 = columnIndexOrThrow8;
            bdMediaItem.setName(cursor.getString(columnIndexOrThrow2));
            bdMediaItem.setModify(cursor.getLong(columnIndexOrThrow3));
            bdMediaItem.setDateAdded(cursor.getLong(columnIndexOrThrow4));
            bdMediaItem.setMimeType(cursor.getString(columnIndexOrThrow5));
            bdMediaItem.setFileSize(cursor.getLong(columnIndexOrThrow6));
            bdMediaItem.setWidth(i16);
            bdMediaItem.setHeight(i18);
            bdMediaItem.setDuration(cursor.getLong(columnIndexOrThrow9));
            bdMediaItem.setDateToken(cursor.getLong(columnIndexOrThrow10));
            bdMediaItem.setResolution(cursor.getString(columnIndexOrThrow11));
            if (DtfsUtils.isAndroidQOrLater()) {
                i8 = i13;
                String string = cursor.getString(i8);
                i5 = columnIndexOrThrow2;
                i11 = columnIndexOrThrow3;
                int i20 = cursor.getInt(i14);
                if (string == null) {
                    i10 = i14;
                    i9 = columnIndexOrThrow12;
                    i12 = columnIndexOrThrow4;
                    String string2 = cursor.getString(i9);
                    i6 = columnIndexOrThrow5;
                    i7 = columnIndexOrThrow6;
                    try {
                        string = string2.substring(length, string2.lastIndexOf(File.separator)) + File.separator;
                    } catch (IndexOutOfBoundsException unused) {
                        bdMediaItem.setRelativePath("");
                    }
                } else {
                    i10 = i14;
                    i6 = columnIndexOrThrow5;
                    i7 = columnIndexOrThrow6;
                    i9 = columnIndexOrThrow12;
                    i12 = columnIndexOrThrow4;
                }
                bdMediaItem.setRelativePath(string);
                bdMediaItem.setOrientation(i20);
                if (z && (i20 == 90 || i20 == 270)) {
                    bdMediaItem.setWidth(i18);
                    bdMediaItem.setHeight(i16);
                }
                Uri uri3 = uri2;
                bdMediaItem.setUri(ContentUris.withAppendedId(uri3, j));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(bdMediaItem);
                columnIndexOrThrow4 = i12;
                columnIndexOrThrow7 = i17;
                uri2 = uri3;
                columnIndexOrThrow12 = i9;
                arrayList = arrayList3;
                i3 = i8;
                i4 = i10;
                columnIndexOrThrow5 = i6;
                columnIndexOrThrow6 = i7;
                columnIndexOrThrow3 = i11;
                columnIndexOrThrow = i15;
                columnIndexOrThrow8 = i19;
                columnIndexOrThrow2 = i5;
            } else {
                i5 = columnIndexOrThrow2;
                i6 = columnIndexOrThrow5;
                i7 = columnIndexOrThrow6;
                i8 = i13;
                i9 = columnIndexOrThrow12;
                i10 = i14;
                i11 = columnIndexOrThrow3;
                i12 = columnIndexOrThrow4;
                String string3 = cursor.getString(i9);
                try {
                    bdMediaItem.setRelativePath(string3.substring(length, string3.lastIndexOf(File.separator)) + File.separator);
                } catch (IndexOutOfBoundsException unused2) {
                    bdMediaItem.setRelativePath("");
                }
                Uri uri32 = uri2;
                bdMediaItem.setUri(ContentUris.withAppendedId(uri32, j));
                ArrayList arrayList32 = arrayList;
                arrayList32.add(bdMediaItem);
                columnIndexOrThrow4 = i12;
                columnIndexOrThrow7 = i17;
                uri2 = uri32;
                columnIndexOrThrow12 = i9;
                arrayList = arrayList32;
                i3 = i8;
                i4 = i10;
                columnIndexOrThrow5 = i6;
                columnIndexOrThrow6 = i7;
                columnIndexOrThrow3 = i11;
                columnIndexOrThrow = i15;
                columnIndexOrThrow8 = i19;
                columnIndexOrThrow2 = i5;
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        ArrayList arrayList4 = arrayList;
        if (cursor != null) {
            cursor.close();
        }
        return arrayList4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x03bd, code lost:
    
        if (r11.isClosed() == false) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cf A[Catch: Exception -> 0x03b2, all -> 0x03c0, TryCatch #1 {all -> 0x03c0, blocks: (B:3:0x0012, B:5:0x0018, B:8:0x00b0, B:10:0x00c5, B:13:0x0104, B:15:0x0118, B:16:0x0125, B:17:0x014d, B:20:0x0159, B:25:0x01a5, B:26:0x01b2, B:28:0x01cf, B:30:0x01d9, B:33:0x01e9, B:34:0x020d, B:36:0x0248, B:38:0x025a, B:40:0x0267, B:41:0x0298, B:43:0x02a6, B:45:0x02d3, B:46:0x02e4, B:50:0x02dd, B:51:0x02f0, B:53:0x0323, B:55:0x032c, B:56:0x033d, B:59:0x0336, B:61:0x0274, B:63:0x027c, B:65:0x0288, B:70:0x0203, B:72:0x0215, B:74:0x0229, B:76:0x0244, B:77:0x01ac, B:79:0x0347, B:82:0x0357, B:91:0x03c4, B:102:0x002d, B:106:0x003d, B:107:0x0063, B:109:0x0076, B:110:0x009c), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02a6 A[Catch: Exception -> 0x03b2, all -> 0x03c0, TryCatch #1 {all -> 0x03c0, blocks: (B:3:0x0012, B:5:0x0018, B:8:0x00b0, B:10:0x00c5, B:13:0x0104, B:15:0x0118, B:16:0x0125, B:17:0x014d, B:20:0x0159, B:25:0x01a5, B:26:0x01b2, B:28:0x01cf, B:30:0x01d9, B:33:0x01e9, B:34:0x020d, B:36:0x0248, B:38:0x025a, B:40:0x0267, B:41:0x0298, B:43:0x02a6, B:45:0x02d3, B:46:0x02e4, B:50:0x02dd, B:51:0x02f0, B:53:0x0323, B:55:0x032c, B:56:0x033d, B:59:0x0336, B:61:0x0274, B:63:0x027c, B:65:0x0288, B:70:0x0203, B:72:0x0215, B:74:0x0229, B:76:0x0244, B:77:0x01ac, B:79:0x0347, B:82:0x0357, B:91:0x03c4, B:102:0x002d, B:106:0x003d, B:107:0x0063, B:109:0x0076, B:110:0x009c), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02f0 A[Catch: Exception -> 0x03b2, all -> 0x03c0, TryCatch #1 {all -> 0x03c0, blocks: (B:3:0x0012, B:5:0x0018, B:8:0x00b0, B:10:0x00c5, B:13:0x0104, B:15:0x0118, B:16:0x0125, B:17:0x014d, B:20:0x0159, B:25:0x01a5, B:26:0x01b2, B:28:0x01cf, B:30:0x01d9, B:33:0x01e9, B:34:0x020d, B:36:0x0248, B:38:0x025a, B:40:0x0267, B:41:0x0298, B:43:0x02a6, B:45:0x02d3, B:46:0x02e4, B:50:0x02dd, B:51:0x02f0, B:53:0x0323, B:55:0x032c, B:56:0x033d, B:59:0x0336, B:61:0x0274, B:63:0x027c, B:65:0x0288, B:70:0x0203, B:72:0x0215, B:74:0x0229, B:76:0x0244, B:77:0x01ac, B:79:0x0347, B:82:0x0357, B:91:0x03c4, B:102:0x002d, B:106:0x003d, B:107:0x0063, B:109:0x0076, B:110:0x009c), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0215 A[Catch: Exception -> 0x03b2, all -> 0x03c0, TRY_LEAVE, TryCatch #1 {all -> 0x03c0, blocks: (B:3:0x0012, B:5:0x0018, B:8:0x00b0, B:10:0x00c5, B:13:0x0104, B:15:0x0118, B:16:0x0125, B:17:0x014d, B:20:0x0159, B:25:0x01a5, B:26:0x01b2, B:28:0x01cf, B:30:0x01d9, B:33:0x01e9, B:34:0x020d, B:36:0x0248, B:38:0x025a, B:40:0x0267, B:41:0x0298, B:43:0x02a6, B:45:0x02d3, B:46:0x02e4, B:50:0x02dd, B:51:0x02f0, B:53:0x0323, B:55:0x032c, B:56:0x033d, B:59:0x0336, B:61:0x0274, B:63:0x027c, B:65:0x0288, B:70:0x0203, B:72:0x0215, B:74:0x0229, B:76:0x0244, B:77:0x01ac, B:79:0x0347, B:82:0x0357, B:91:0x03c4, B:102:0x002d, B:106:0x003d, B:107:0x0063, B:109:0x0076, B:110:0x009c), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<BdMediaFolder> getAlbums(Context context, String str, String[] strArr, String str2, int i, int i2) {
        ArrayList arrayList;
        Cursor query;
        ArrayList<BdMediaItem> arrayList2;
        int i3;
        HashMap hashMap;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        ArrayList<BdMediaItem> arrayList3;
        ArrayList<BdMediaItem> arrayList4;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        int i10;
        String str3 = str2;
        ArrayList arrayList5 = new ArrayList();
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Cursor cursor = null;
        try {
            try {
                if (DtfsUtils.isAndroidROrLater()) {
                    query = context.getContentResolver().query(contentUri, ALBUM_PROJECTION_HIGH, DtfsUtils.createQueryBundle(str, strArr, i, i2, str3), null);
                } else if (DtfsUtils.isAndroidQOrLater()) {
                    if (i > 0) {
                        str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                    }
                    query = context.getContentResolver().query(contentUri, ALBUM_PROJECTION_HIGH, str, strArr, str3);
                } else {
                    if (i > 0) {
                        str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                    }
                    query = context.getContentResolver().query(contentUri, ALBUM_PROJECTION_LOW, str, strArr, str3);
                }
                cursor = query;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            e = e;
            arrayList = arrayList5;
        }
        if (cursor != null) {
            ArrayList<BdMediaItem> arrayList6 = new ArrayList<>();
            ArrayList<BdMediaItem> arrayList7 = new ArrayList<>();
            ArrayList<BdMediaItem> arrayList8 = new ArrayList<>();
            if (cursor.getCount() > 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_added");
                int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("mime_type");
                int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("_size");
                int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("width");
                int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("height");
                int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("duration");
                int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("_data");
                int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow(COLUMN_BUCKET_ID);
                try {
                    int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow(COLUMN_BUCKET_DISPLAY_NAME);
                    ArrayList<BdMediaItem> arrayList9 = arrayList7;
                    int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("orientation");
                    if (DtfsUtils.isAndroidQOrLater()) {
                        arrayList2 = arrayList8;
                        i3 = cursor.getColumnIndexOrThrow("relative_path");
                    } else {
                        arrayList2 = arrayList8;
                        i3 = -1;
                    }
                    ArrayList<BdMediaItem> arrayList10 = arrayList6;
                    Uri uri = contentUri;
                    int length = (Environment.getExternalStorageDirectory().getPath() + "/").length();
                    HashMap hashMap2 = new HashMap();
                    while (true) {
                        hashMap = hashMap2;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        BdMediaItem bdMediaItem = new BdMediaItem();
                        int i11 = i3;
                        int i12 = columnIndexOrThrow11;
                        long j2 = cursor.getLong(columnIndexOrThrow);
                        bdMediaItem.setId(j2);
                        int i13 = columnIndexOrThrow;
                        bdMediaItem.setName(cursor.getString(columnIndexOrThrow2));
                        int i14 = columnIndexOrThrow2;
                        bdMediaItem.setDateAdded(cursor.getLong(columnIndexOrThrow3));
                        bdMediaItem.setMimeType(cursor.getString(columnIndexOrThrow4));
                        bdMediaItem.setFileSize(cursor.getLong(columnIndexOrThrow5));
                        int i15 = cursor.getInt(columnIndexOrThrow6);
                        int i16 = cursor.getInt(columnIndexOrThrow7);
                        int i17 = columnIndexOrThrow3;
                        int i18 = cursor.getInt(columnIndexOrThrow12);
                        bdMediaItem.setOrientation(i18);
                        int i19 = columnIndexOrThrow12;
                        if (i18 != 90 && i18 != 270) {
                            bdMediaItem.setWidth(i15);
                            bdMediaItem.setHeight(i16);
                            bdMediaItem.setDuration(cursor.getLong(columnIndexOrThrow8));
                            j = cursor.getLong(columnIndexOrThrow10);
                            String string = cursor.getString(i12);
                            bdMediaItem.setBucketId(j);
                            bdMediaItem.setBucketName(string);
                            if (!DtfsUtils.isAndroidQOrLater()) {
                                i4 = i12;
                                String string2 = cursor.getString(i11);
                                if (string2 == null) {
                                    i7 = i11;
                                    String string3 = cursor.getString(columnIndexOrThrow9);
                                    i5 = columnIndexOrThrow4;
                                    i6 = columnIndexOrThrow5;
                                    try {
                                        string2 = string3.substring(length, string3.lastIndexOf(File.separator)) + File.separator;
                                    } catch (IndexOutOfBoundsException unused) {
                                        bdMediaItem.setRelativePath("");
                                    }
                                } else {
                                    i7 = i11;
                                    i5 = columnIndexOrThrow4;
                                    i6 = columnIndexOrThrow5;
                                }
                                bdMediaItem.setRelativePath(string2);
                            } else {
                                i4 = i12;
                                i5 = columnIndexOrThrow4;
                                i6 = columnIndexOrThrow5;
                                i7 = i11;
                                String string4 = cursor.getString(columnIndexOrThrow9);
                                try {
                                    bdMediaItem.setRelativePath(string4.substring(length, string4.lastIndexOf(File.separator)) + File.separator);
                                } catch (IndexOutOfBoundsException unused2) {
                                    bdMediaItem.setRelativePath("");
                                }
                            }
                            Uri uri2 = uri;
                            bdMediaItem.setUri(ContentUris.withAppendedId(uri2, j2));
                            ArrayList<BdMediaItem> arrayList11 = arrayList10;
                            arrayList11.add(bdMediaItem);
                            if (bdMediaItem.getMimeType() == null && bdMediaItem.getMimeType().startsWith("video")) {
                                arrayList3 = arrayList2;
                                arrayList3.add(bdMediaItem);
                                z = false;
                                z2 = true;
                                arrayList4 = arrayList9;
                                i8 = length;
                            } else {
                                arrayList3 = arrayList2;
                                if (bdMediaItem.getMimeType() == null && bdMediaItem.getMimeType().startsWith("image")) {
                                    arrayList4 = arrayList9;
                                    arrayList4.add(bdMediaItem);
                                    i8 = length;
                                    z = true;
                                } else {
                                    arrayList4 = arrayList9;
                                    i8 = length;
                                    z = false;
                                }
                                z2 = false;
                            }
                            int i20 = columnIndexOrThrow6;
                            if (hashMap.containsKey(Long.valueOf(j))) {
                                BdMediaFolder bdMediaFolder = new BdMediaFolder();
                                bdMediaFolder.setFolderName(string);
                                bdMediaFolder.setBucketId(j);
                                bdMediaFolder.setFirstImagePath(bdMediaItem.getUri());
                                i9 = columnIndexOrThrow7;
                                i10 = columnIndexOrThrow8;
                                bdMediaFolder.setFirstDateAdded(bdMediaItem.getDateAdded());
                                bdMediaFolder.setFirstMimeType(bdMediaItem.getMimeType());
                                bdMediaFolder.getData().add(bdMediaItem);
                                if (z2) {
                                    bdMediaFolder.getVideos().add(bdMediaItem);
                                } else if (z) {
                                    bdMediaFolder.getImages().add(bdMediaItem);
                                }
                                bdMediaFolder.setFolderTotalNum(1);
                                hashMap.put(Long.valueOf(j), bdMediaFolder);
                            } else {
                                i9 = columnIndexOrThrow7;
                                i10 = columnIndexOrThrow8;
                                BdMediaFolder bdMediaFolder2 = (BdMediaFolder) hashMap.get(Long.valueOf(j));
                                if (bdMediaFolder2 != null) {
                                    bdMediaFolder2.getData().add(bdMediaItem);
                                    if (z2) {
                                        bdMediaFolder2.getVideos().add(bdMediaItem);
                                    } else if (z) {
                                        bdMediaFolder2.getImages().add(bdMediaItem);
                                    }
                                    bdMediaFolder2.setFolderTotalNum(bdMediaFolder2.getFolderTotalNum() + 1);
                                }
                            }
                            length = i8;
                            columnIndexOrThrow7 = i9;
                            columnIndexOrThrow8 = i10;
                            uri = uri2;
                            arrayList10 = arrayList11;
                            arrayList9 = arrayList4;
                            hashMap2 = hashMap;
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow2 = i14;
                            columnIndexOrThrow3 = i17;
                            columnIndexOrThrow12 = i19;
                            i3 = i7;
                            columnIndexOrThrow4 = i5;
                            columnIndexOrThrow5 = i6;
                            columnIndexOrThrow6 = i20;
                            arrayList2 = arrayList3;
                            columnIndexOrThrow11 = i4;
                        }
                        bdMediaItem.setWidth(i16);
                        bdMediaItem.setHeight(i15);
                        bdMediaItem.setDuration(cursor.getLong(columnIndexOrThrow8));
                        j = cursor.getLong(columnIndexOrThrow10);
                        String string5 = cursor.getString(i12);
                        bdMediaItem.setBucketId(j);
                        bdMediaItem.setBucketName(string5);
                        if (!DtfsUtils.isAndroidQOrLater()) {
                        }
                        Uri uri22 = uri;
                        bdMediaItem.setUri(ContentUris.withAppendedId(uri22, j2));
                        ArrayList<BdMediaItem> arrayList112 = arrayList10;
                        arrayList112.add(bdMediaItem);
                        if (bdMediaItem.getMimeType() == null) {
                        }
                        arrayList3 = arrayList2;
                        if (bdMediaItem.getMimeType() == null) {
                        }
                        arrayList4 = arrayList9;
                        i8 = length;
                        z = false;
                        z2 = false;
                        int i202 = columnIndexOrThrow6;
                        if (hashMap.containsKey(Long.valueOf(j))) {
                        }
                        length = i8;
                        columnIndexOrThrow7 = i9;
                        columnIndexOrThrow8 = i10;
                        uri = uri22;
                        arrayList10 = arrayList112;
                        arrayList9 = arrayList4;
                        hashMap2 = hashMap;
                        columnIndexOrThrow = i13;
                        columnIndexOrThrow2 = i14;
                        columnIndexOrThrow3 = i17;
                        columnIndexOrThrow12 = i19;
                        i3 = i7;
                        columnIndexOrThrow4 = i5;
                        columnIndexOrThrow5 = i6;
                        columnIndexOrThrow6 = i202;
                        arrayList2 = arrayList3;
                        columnIndexOrThrow11 = i4;
                    }
                    ArrayList<BdMediaItem> arrayList12 = arrayList9;
                    ArrayList<BdMediaItem> arrayList13 = arrayList2;
                    ArrayList<BdMediaItem> arrayList14 = arrayList10;
                    arrayList = arrayList5;
                    try {
                        arrayList.addAll(hashMap.values());
                        Collections.sort(arrayList, new Comparator<BdMediaFolder>() { // from class: bytedance.io.BdMediaFileSystem.1
                            @Override // java.util.Comparator
                            public int compare(BdMediaFolder bdMediaFolder3, BdMediaFolder bdMediaFolder4) {
                                return Long.compare(bdMediaFolder4.getFirstDateAdded(), bdMediaFolder3.getFirstDateAdded());
                            }
                        });
                        BdMediaFolder bdMediaFolder3 = new BdMediaFolder();
                        bdMediaFolder3.setFirstImagePath(arrayList14.get(0).getUri());
                        bdMediaFolder3.setFirstMimeType(arrayList14.get(0).getMimeType());
                        bdMediaFolder3.setFirstDateAdded(arrayList14.get(0).getDateAdded());
                        bdMediaFolder3.setFolderName("");
                        bdMediaFolder3.setBucketId(-1L);
                        bdMediaFolder3.setData(arrayList14);
                        bdMediaFolder3.setImages(arrayList12);
                        bdMediaFolder3.setVideos(arrayList13);
                        bdMediaFolder3.setFolderTotalNum(arrayList14.size());
                        bdMediaFolder3.setAllAblubm(true);
                        arrayList.add(0, bdMediaFolder3);
                        if (cursor != null) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return arrayList;
                    }
                } catch (Exception e3) {
                    e = e3;
                    arrayList = arrayList5;
                }
                return arrayList;
            }
        }
        arrayList = arrayList5;
        if (cursor != null) {
        }
        return arrayList;
    }

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
            if (DtfsUtils.isAndroidROrLater()) {
                query = context.getContentResolver().query(uri, IMAGE_PROJECTION_HIGH, DtfsUtils.createQueryBundle(str, strArr, i, i2, str3), null);
            } else if (DtfsUtils.isAndroidQOrLater()) {
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
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("orientation");
        int columnIndexOrThrow11 = DtfsUtils.isAndroidQOrLater() ? cursor.getColumnIndexOrThrow("relative_path") : -1;
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
            if (DtfsUtils.isAndroidQOrLater()) {
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

    public static List<BdMediaItem> getMusics(Context context, String str, String[] strArr, String str2, int i, int i2) {
        Cursor query;
        int i3;
        ArrayList arrayList;
        Uri uri;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        String str3 = str2;
        ArrayList arrayList2 = new ArrayList();
        Uri uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = null;
        try {
            if (DtfsUtils.isAndroidROrLater()) {
                query = context.getContentResolver().query(uri2, AUDIO_PROJECTION_HIGH, DtfsUtils.createQueryBundle(str, strArr, i, i2, str3), null);
            } else if (DtfsUtils.isAndroidQOrLater()) {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri2, AUDIO_PROJECTION_HIGH, str, strArr, str3);
            } else {
                if (i > 0) {
                    str3 = str3 + (" LIMIT " + i + " OFFSET " + i2);
                }
                query = context.getContentResolver().query(uri2, AUDIO_PROJECTION_LOW, str, strArr, str3);
            }
            cursor = query;
        } finally {
        }
        if (cursor == null) {
            return arrayList2;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_added");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("mime_type");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("is_music");
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("duration");
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("title");
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("album");
        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow("artist");
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("album_id");
        if (DtfsUtils.isAndroidQOrLater()) {
            int columnIndexOrThrow13 = cursor.getColumnIndexOrThrow("relative_path");
            arrayList = arrayList2;
            uri = uri2;
            i4 = cursor.getColumnIndexOrThrow("datetaken");
            i3 = columnIndexOrThrow13;
        } else {
            i3 = -1;
            arrayList = arrayList2;
            uri = uri2;
            i4 = -1;
        }
        int i11 = i4;
        int columnIndexOrThrow14 = cursor.getColumnIndexOrThrow("_data");
        int length = (Environment.getExternalStorageDirectory().getPath() + "/").length();
        while (cursor.moveToNext()) {
            BdMediaItem bdMediaItem = new BdMediaItem();
            int i12 = columnIndexOrThrow12;
            int i13 = i3;
            long j = cursor.getLong(columnIndexOrThrow);
            bdMediaItem.setId(j);
            int i14 = columnIndexOrThrow;
            bdMediaItem.setName(cursor.getString(columnIndexOrThrow2));
            int i15 = columnIndexOrThrow2;
            bdMediaItem.setModify(cursor.getLong(columnIndexOrThrow3));
            bdMediaItem.setDateAdded(cursor.getLong(columnIndexOrThrow4));
            bdMediaItem.setMimeType(cursor.getString(columnIndexOrThrow5));
            bdMediaItem.setFileSize(cursor.getLong(columnIndexOrThrow6));
            bdMediaItem.setMusicType(cursor.getInt(columnIndexOrThrow7));
            bdMediaItem.setDuration(cursor.getLong(columnIndexOrThrow8));
            bdMediaItem.setTitle(cursor.getString(columnIndexOrThrow9));
            bdMediaItem.setAlbum(cursor.getString(columnIndexOrThrow10));
            bdMediaItem.setArtist(cursor.getString(columnIndexOrThrow11));
            int i16 = columnIndexOrThrow3;
            bdMediaItem.setAlbumId(cursor.getLong(i12));
            if (DtfsUtils.isAndroidQOrLater()) {
                String string = cursor.getString(i13);
                if (string == null) {
                    i6 = i12;
                    i9 = columnIndexOrThrow14;
                    i10 = i13;
                    String string2 = cursor.getString(i9);
                    i7 = columnIndexOrThrow4;
                    i8 = columnIndexOrThrow5;
                    try {
                        string = string2.substring(length, string2.lastIndexOf(File.separator)) + File.separator;
                    } catch (IndexOutOfBoundsException unused) {
                        bdMediaItem.setRelativePath("");
                    }
                } else {
                    i6 = i12;
                    i7 = columnIndexOrThrow4;
                    i8 = columnIndexOrThrow5;
                    i9 = columnIndexOrThrow14;
                    i10 = i13;
                }
                bdMediaItem.setRelativePath(string);
                i5 = i11;
                bdMediaItem.setDateToken(cursor.getLong(i5));
                Uri uri3 = uri;
                bdMediaItem.setUri(ContentUris.withAppendedId(uri3, j));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(bdMediaItem);
                i3 = i10;
                columnIndexOrThrow12 = i6;
                columnIndexOrThrow14 = i9;
                i11 = i5;
                uri = uri3;
                arrayList = arrayList3;
                columnIndexOrThrow4 = i7;
                columnIndexOrThrow5 = i8;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow = i14;
                columnIndexOrThrow2 = i15;
            } else {
                i5 = i11;
                i6 = i12;
                i7 = columnIndexOrThrow4;
                i8 = columnIndexOrThrow5;
                i9 = columnIndexOrThrow14;
                i10 = i13;
                String string3 = cursor.getString(i9);
                try {
                    bdMediaItem.setRelativePath(string3.substring(length, string3.lastIndexOf(File.separator)) + File.separator);
                } catch (IndexOutOfBoundsException unused2) {
                    bdMediaItem.setRelativePath("");
                }
                Uri uri32 = uri;
                bdMediaItem.setUri(ContentUris.withAppendedId(uri32, j));
                ArrayList arrayList32 = arrayList;
                arrayList32.add(bdMediaItem);
                i3 = i10;
                columnIndexOrThrow12 = i6;
                columnIndexOrThrow14 = i9;
                i11 = i5;
                uri = uri32;
                arrayList = arrayList32;
                columnIndexOrThrow4 = i7;
                columnIndexOrThrow5 = i8;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow = i14;
                columnIndexOrThrow2 = i15;
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        ArrayList arrayList4 = arrayList;
        if (cursor != null) {
            cursor.close();
        }
        return arrayList4;
    }

    public static Uri getFileUri(Context context, File file) throws IOException {
        try {
            return new BdMeidaScanner(context, file).get();
        } catch (InterruptedException e) {
            throw new IOException("File failed to scan as a uri", e);
        }
    }

    public static String getMimeType(Context context, Uri uri) {
        return context.getContentResolver().getType(uri);
    }

    public static Bitmap getThumbnail(Context context, Uri uri, int i, int i2) throws IOException {
        return context.getContentResolver().loadThumbnail(uri, new Size(i, i2), null);
    }

    public static boolean isUriExists(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, DownloadFileUtils.MODE_READ);
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static Uri getVideoContentUri(Context context, String str) {
        return getVideoContentUri(context, str, null);
    }

    public static Uri getVideoContentUri(Context context, String str, String str2) {
        return getVideoContentUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri getVideoContentUri(Context context, String str, String str2, String str3) {
        Cursor query;
        Uri uri;
        Cursor cursor = null;
        Uri uri2 = null;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        Uri uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        if (DtfsUtils.isAndroidQOrLater()) {
            uri3 = MediaStore.Video.Media.getContentUri("external_primary");
        }
        try {
            String removeDupSlash = DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str);
            if (DtfsUtils.isAndroidQOrLater()) {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, DtfsUtils.createQueryBundle("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{str3, str3.substring(0, str3.length() - 1), str}, -1, 0), null);
            } else {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, "_data=?", new String[]{removeDupSlash}, null);
            }
            Cursor cursor2 = query;
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        ArrayList<BdMediaItem> arrayList = new ArrayList();
                        BdMediaItem bdMediaItem = new BdMediaItem();
                        bdMediaItem.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                        bdMediaItem.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                        arrayList.add(bdMediaItem);
                        while (cursor2.moveToNext()) {
                            BdMediaItem bdMediaItem2 = new BdMediaItem();
                            bdMediaItem2.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                            bdMediaItem2.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                            arrayList.add(bdMediaItem2);
                        }
                        if (arrayList.size() == 1) {
                            if (!TextUtils.isEmpty(str2) && !"video/*".equals(str2) && !str2.equals(((BdMediaItem) arrayList.get(0)).getMimeType())) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = ((BdMediaItem) arrayList.get(0)).getUri();
                        } else {
                            for (BdMediaItem bdMediaItem3 : arrayList) {
                                if (TextUtils.isEmpty(str2) || str2.equals(bdMediaItem3.getMimeType()) || "video/*".equals(str2)) {
                                    uri2 = bdMediaItem3.getUri();
                                    break;
                                }
                            }
                            if (uri2 == null) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = uri2;
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return uri;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri getImageContentUri(Context context, String str) {
        return getImageContentUri(context, str, null);
    }

    public static Uri getImageContentUri(Context context, String str, String str2) {
        return getImageContentUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri getImageContentUri(Context context, String str, String str2, String str3) {
        Cursor query;
        Uri uri;
        String str4 = str3;
        Cursor cursor = null;
        Uri uri2 = null;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        Uri uri3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (DtfsUtils.isAndroidQOrLater()) {
            uri3 = MediaStore.Images.Media.getContentUri("external_primary");
        }
        try {
            String removeDupSlash = DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str4 + "/" + str);
            if (DtfsUtils.isAndroidQOrLater()) {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, DtfsUtils.createQueryBundle("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{str4, str4.substring(0, str4.length() - 1), str}, -1, 0), null);
            } else {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, "_data=?", new String[]{removeDupSlash}, null);
            }
            Cursor cursor2 = query;
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        ArrayList<BdMediaItem> arrayList = new ArrayList();
                        BdMediaItem bdMediaItem = new BdMediaItem();
                        bdMediaItem.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                        bdMediaItem.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                        arrayList.add(bdMediaItem);
                        while (cursor2.moveToNext()) {
                            BdMediaItem bdMediaItem2 = new BdMediaItem();
                            bdMediaItem.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                            bdMediaItem.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                            arrayList.add(bdMediaItem2);
                        }
                        if (arrayList.size() == 1) {
                            if (!TextUtils.isEmpty(str2) && !"image/*".equals(str2) && !str2.equals(((BdMediaItem) arrayList.get(0)).getMimeType())) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = ((BdMediaItem) arrayList.get(0)).getUri();
                        } else {
                            for (BdMediaItem bdMediaItem3 : arrayList) {
                                if (TextUtils.isEmpty(str2) || "image/*".equals(str2) || str2.equals(bdMediaItem3.getMimeType())) {
                                    uri2 = bdMediaItem3.getUri();
                                    break;
                                }
                            }
                            if (uri2 == null) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = uri2;
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return uri;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri getMusicContentUri(Context context, String str) {
        return getMusicContentUri(context, str, null);
    }

    public static Uri getMusicContentUri(Context context, String str, String str2) {
        return getMusicContentUri(context, str, str2, Environment.DIRECTORY_MUSIC);
    }

    public static Uri getMusicContentUri(Context context, String str, String str2, String str3) {
        Cursor query;
        Uri uri;
        String str4 = str3;
        Cursor cursor = null;
        Uri uri2 = null;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        Uri uri3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        if (DtfsUtils.isAndroidQOrLater()) {
            uri3 = MediaStore.Audio.Media.getContentUri("external_primary");
        }
        try {
            String removeDupSlash = DtfsUtils.removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str4 + "/" + str);
            if (DtfsUtils.isAndroidQOrLater()) {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, DtfsUtils.createQueryBundle("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{str4, str4.substring(0, str4.length() - 1), str}, -1, 0), null);
            } else {
                query = context.getContentResolver().query(uri3, new String[]{"_id", "mime_type"}, "_data=?", new String[]{removeDupSlash}, null);
            }
            Cursor cursor2 = query;
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        ArrayList<BdMediaItem> arrayList = new ArrayList();
                        BdMediaItem bdMediaItem = new BdMediaItem();
                        bdMediaItem.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                        bdMediaItem.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                        arrayList.add(bdMediaItem);
                        while (cursor2.moveToNext()) {
                            BdMediaItem bdMediaItem2 = new BdMediaItem();
                            bdMediaItem2.setMimeType(cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")));
                            bdMediaItem2.setUri(ContentUris.withAppendedId(uri3, cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))));
                            arrayList.add(bdMediaItem2);
                        }
                        if (arrayList.size() == 1) {
                            if (!TextUtils.isEmpty(str2) && !"audio/*".equals(str2) && !str2.equals(((BdMediaItem) arrayList.get(0)).getMimeType())) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = ((BdMediaItem) arrayList.get(0)).getUri();
                        } else {
                            for (BdMediaItem bdMediaItem3 : arrayList) {
                                if (TextUtils.isEmpty(str2) || "audio/*".equals(str2) || str2.equals(bdMediaItem3.getMimeType())) {
                                    uri2 = bdMediaItem3.getUri();
                                    break;
                                }
                            }
                            if (uri2 == null) {
                                throw new IllegalArgumentException("Except mimetype is " + str2 + ", actual mimetype is " + ((BdMediaItem) arrayList.get(0)).getMimeType());
                            }
                            uri = uri2;
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return uri;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void updateMediaStore(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
        MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
    }
}
