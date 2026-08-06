package com.bytedance.ug.sdk.share.impl.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FileUtils {
    public static final String ALBUM_SAVE_PATH = "share_content_cache";
    public static final String CACHE_SAVE_PATH = "share_content_cache";
    public static String sAlbumDirPath;

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) {
        if (inputStream != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            Logger.m465e(e.toString());
                        }
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream == null) {
                        return true;
                    }
                    try {
                        inputStream.close();
                        return true;
                    } catch (Exception e2) {
                        Logger.m465e(e2.toString());
                        return true;
                    }
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            Logger.m465e(e3.toString());
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            Logger.m465e(e4.toString());
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static boolean saveBitmapToSD(Bitmap bitmap, String str, String str2) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file + "/" + str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            try {
                fileOutputStream2.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                fileOutputStream2.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    public static Bitmap getBitmapFromSD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            Bitmap decodeBitmapForQ = Build.VERSION.SDK_INT >= 29 ? decodeBitmapForQ(str) : null;
            return decodeBitmapForQ == null ? decodeBitmap(file) : decodeBitmapForQ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap decodeBitmap(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return decodeStream;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068 A[Catch: Exception -> 0x0064, TRY_LEAVE, TryCatch #6 {Exception -> 0x0064, blocks: (B:19:0x0060, B:11:0x0068), top: B:18:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap decodeBitmapForQ(String str) {
        Cursor cursor;
        ParcelFileDescriptor parcelFileDescriptor;
        Bitmap decodeFileDescriptor;
        Context appContext = ShareSdkManager.getInstance().getAppContext();
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        if (appContext == null) {
            return null;
        }
        try {
            ContentResolver contentResolver = appContext.getContentResolver();
            cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        parcelFileDescriptor = contentResolver.openFileDescriptor(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id"))), "r");
                        if (parcelFileDescriptor != null) {
                            try {
                                if (parcelFileDescriptor.getFileDescriptor() != null) {
                                    decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                                    parcelFileDescriptor2 = parcelFileDescriptor;
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (parcelFileDescriptor2 != null) {
                                        parcelFileDescriptor2.close();
                                    }
                                    return decodeFileDescriptor;
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    th.printStackTrace();
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            return null;
                                        }
                                    }
                                    if (parcelFileDescriptor == null) {
                                        return null;
                                    }
                                    parcelFileDescriptor.close();
                                    return null;
                                } catch (Throwable th2) {
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            throw th2;
                                        }
                                    }
                                    if (parcelFileDescriptor != null) {
                                        parcelFileDescriptor.close();
                                    }
                                    throw th2;
                                }
                            }
                        }
                        decodeFileDescriptor = null;
                        parcelFileDescriptor2 = parcelFileDescriptor;
                        if (cursor != null) {
                        }
                        if (parcelFileDescriptor2 != null) {
                        }
                        return decodeFileDescriptor;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    parcelFileDescriptor = null;
                }
            }
            decodeFileDescriptor = null;
            if (cursor != null) {
            }
            if (parcelFileDescriptor2 != null) {
            }
            return decodeFileDescriptor;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            parcelFileDescriptor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri getUriFromPath(Context context, String str, boolean z) {
        Cursor cursor;
        if (Build.VERSION.SDK_INT >= 29) {
            Uri uri = null;
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (context == null) {
                return null;
            }
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri2 = z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                cursor = contentResolver.query(uri2, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            uri = ContentUris.withAppendedId(uri2, cursor.getInt(cursor.getColumnIndex("_id")));
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (uri != null) {
                            }
                        } catch (Throwable th2) {
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            return uri != null ? ShareUtils.getFileProviderUri(str) : uri;
        }
        return ShareUtils.getFileProviderUri(str);
    }

    public static String getCacheFilePathDir() {
        Context appContext = ShareSdkManager.getInstance().getAppContext();
        if (appContext == null) {
            return null;
        }
        File file = new File(appContext.getExternalCacheDir(), "share_content_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String getAlbumDirPath() {
        if (!TextUtils.isEmpty(sAlbumDirPath)) {
            return sAlbumDirPath;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Context appContext = ShareSdkManager.getInstance().getAppContext();
            if (appContext == null) {
                return null;
            }
            File externalFilesDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DCIM);
            if (externalFilesDir != null && externalFilesDir.exists()) {
                sAlbumDirPath = externalFilesDir.getAbsolutePath();
            }
            return sAlbumDirPath;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = new File(externalStoragePublicDirectory, "Camera");
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            sAlbumDirPath = absolutePath;
            return absolutePath;
        }
        File file2 = new File(externalStoragePublicDirectory, "100MEDIA");
        if (file2.exists()) {
            String absolutePath2 = file2.getAbsolutePath();
            sAlbumDirPath = absolutePath2;
            return absolutePath2;
        }
        File file3 = new File(externalStoragePublicDirectory, "100ANDRO");
        if (file3.exists()) {
            String absolutePath3 = file3.getAbsolutePath();
            sAlbumDirPath = absolutePath3;
            return absolutePath3;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "share_content_cache";
        File file4 = new File(str);
        if (!file4.exists()) {
            file4.mkdirs();
        }
        sAlbumDirPath = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0 A[Catch: IOException -> 0x00dc, TRY_LEAVE, TryCatch #9 {IOException -> 0x00dc, blocks: (B:50:0x00d8, B:41:0x00e0), top: B:49:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f4 A[Catch: IOException -> 0x00f0, TRY_LEAVE, TryCatch #4 {IOException -> 0x00f0, blocks: (B:63:0x00ec, B:56:0x00f4), top: B:62:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri syncMediaToAlbum(Context context, String str, boolean z) {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        OutputStream openOutputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (Build.VERSION.SDK_INT < 29 || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (existMediaStore(contentResolver, file.getName(), z)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemaConstants.QUERY_KEY_TITLE, file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", z ? "image/*" : "video/mp4");
        contentValues.put("relative_path", z ? Environment.DIRECTORY_DCIM + "/Camera" : Environment.DIRECTORY_MOVIES);
        try {
            Uri insert = contentResolver.insert(z ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            if (insert != null) {
                try {
                    openOutputStream = contentResolver.openOutputStream(insert);
                } catch (IOException e) {
                    e = e;
                    outputStream = null;
                    try {
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                throw th;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    throw th;
                }
            } else {
                openOutputStream = null;
            }
            if (openOutputStream != null) {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        openOutputStream.write(bArr, 0, read);
                    }
                    openOutputStream.flush();
                } catch (IOException e3) {
                    outputStream = openOutputStream;
                    e = e3;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (outputStream != null) {
                        return null;
                    }
                    outputStream.close();
                    return null;
                } catch (Throwable th3) {
                    bufferedInputStream2 = bufferedInputStream;
                    outputStream = openOutputStream;
                    th = th3;
                    if (bufferedInputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    throw th;
                }
            }
            if (isShowTwoPicInAlbum()) {
                file.delete();
            }
            try {
                bufferedInputStream.close();
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return insert;
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
        }
    }

    private static boolean existMediaStore(ContentResolver contentResolver, String str, boolean z) {
        Cursor cursor = null;
        try {
            Uri uri = z ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            cursor = contentResolver.query(uri, new String[]{"_id"}, "_display_name=?", new String[]{str}, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
            contentResolver.openFileDescriptor(Uri.parse(uri.toString() + "/" + cursor.getString(0)), "r");
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        } catch (Throwable unused) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
    }

    private static boolean isShowTwoPicInAlbum() {
        return Build.MODEL.equals("M2002J9E");
    }
}
