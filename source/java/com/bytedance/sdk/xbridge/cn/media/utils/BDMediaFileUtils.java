package com.bytedance.sdk.xbridge.cn.media.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import coil3.util.Utils_commonKt;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class BDMediaFileUtils {
    public static String GALLEY_FOLDER_PATH = Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera";

    public static Uri createImageUri(Context context, String str) {
        return createImageUri(context, str, MediaUtils.INSTANCE.getImageMimeType(str, Utils_commonKt.MIME_TYPE_JPEG));
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        File file = new File(GALLEY_FOLDER_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return createImageUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createImageUri(Context context, String str, String str2, String str3) {
        return createImageUri(context, str, str2, str3, null);
    }

    public static Uri createImageUriAboveAndroidQ(Context context, String str) {
        return createImageUriAboveAndroidQ(context, str, MediaUtils.INSTANCE.getImageMimeType(str, Utils_commonKt.MIME_TYPE_JPEG));
    }

    public static Uri createImageUriAboveAndroidQ(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", str2);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
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
        if (isAndroidQOrLater()) {
            uri = MediaStore.Images.Media.getContentUri("external_primary");
            contentValues.put("relative_path", str3);
        } else {
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            contentValues.put("_data", removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str));
            uri = uri2;
        }
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static Uri createVideoUri(Context context, String str) {
        return createVideoUri(context, str, "video/mp4");
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        File file = new File(GALLEY_FOLDER_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return createVideoUri(context, str, str2, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createVideoUri(Context context, String str, String str2, String str3) {
        return createVideoUri(context, str, str2, str3, null);
    }

    public static Uri createVideoUriAboveAndroidQ(Context context, String str) {
        return createVideoUriAboveAndroidQ(context, str, "video/mp4");
    }

    public static Uri createVideoUriAboveAndroidQ(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", str2);
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
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
        if (isAndroidQOrLater()) {
            uri = MediaStore.Video.Media.getContentUri("external_primary");
            contentValues.put("relative_path", str3);
        } else {
            Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            contentValues.put("_data", removeDupSlash(Environment.getExternalStorageDirectory().getPath() + "/" + str3 + "/" + str));
            uri = uri2;
        }
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static boolean isAndroidQOrLater() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static String removeDupSlash(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '/' || c != '/') {
                charArray[i2] = c2;
                i2++;
            }
            i++;
            c = c2;
        }
        if (c == '/' && length > 1) {
            i2--;
        }
        return i2 != length ? new String(charArray, 0, i2) : str;
    }

    public static boolean removeFile(String str) {
        if (TextUtils.isEmpty(str) || !isSdcardWritable()) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
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

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            if (inputStream == null || outputStream == null) {
                throw new IOException("Failed to copy input:" + inputStream + "output:" + outputStream);
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
