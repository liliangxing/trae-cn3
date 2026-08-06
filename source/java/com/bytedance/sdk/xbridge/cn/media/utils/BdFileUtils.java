package com.bytedance.sdk.xbridge.cn.media.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.caverock.androidsvg.SVGParser;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class BdFileUtils {
    public static String convertUriToPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || "file".equals(scheme)) {
            return uri.getPath();
        }
        if ("http".equals(scheme)) {
            return uri.toString();
        }
        if ("content".equals(scheme) && SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(uri.getAuthority())) {
            return getDataColumn(context, uri, null, null);
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (TextUtils.equals("com.android.externalstorage.documents", uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if (TextUtils.equals("com.android.providers.downloads.documents", uri.getAuthority())) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId != null && documentId.startsWith("raw:")) {
                        return documentId.substring(4);
                    }
                    String dataColumn = getDataColumn(context, Build.VERSION.SDK_INT < 26 ? ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()) : uri, null, null);
                    if (dataColumn == null) {
                        try {
                            String absolutePath = new File(context.getCacheDir(), "uri_tmp").getAbsolutePath();
                            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, DownloadFileUtils.MODE_READ);
                            if (openFileDescriptor == null) {
                                return null;
                            }
                            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    fileInputStream.close();
                                    fileOutputStream.close();
                                    return new File(absolutePath).getAbsolutePath();
                                }
                            }
                        } catch (IOException unused) {
                        }
                    }
                    return dataColumn;
                }
                if (TextUtils.equals("com.android.providers.media.documents", uri.getAuthority())) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                    String str = split2[0];
                    if (TextUtils.equals("image", str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (TextUtils.equals("video", str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (TextUtils.equals("audio", str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        }
        if (!"content".equals(scheme)) {
            return null;
        }
        context.getContentResolver();
        if ("com.google.android.apps.photos.contentprovider".equals(uri.getAuthority())) {
            String str2 = uri.getPathSegments().get(2);
            if (str2.startsWith("content")) {
                return getDataColumn(context, Uri.parse(str2), null, null);
            }
        } else if (("com.android.fileexplorer.myprovider".equals(uri.getAuthority()) || "com.mi.android.globalFileexplorer.myprovider".equals(uri.getAuthority())) && !TextUtils.isEmpty(uri.getPath())) {
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            arrayList.remove(0);
            StringBuilder sb = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append("/").append((String) it.next());
            }
            return sb.toString();
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.startsWith("/storage/emulated/")) {
            return lastPathSegment;
        }
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.contains(Constants.COLON_SEPARATOR)) {
            lastPathSegment = lastPathSegment.split(Constants.COLON_SEPARATOR)[1];
        }
        return getDataColumn(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id= ?", new String[]{lastPathSegment});
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
    
        if (r8 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        r8.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (IllegalArgumentException unused) {
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (IllegalArgumentException unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getCacheDirAbsolutePath(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            return null;
        }
        return externalCacheDir.getAbsolutePath();
    }
}
