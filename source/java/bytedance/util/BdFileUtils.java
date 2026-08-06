package bytedance.util;

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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BdFileUtils {
    static List<String> THIRD_PROVIDER = Arrays.asList("com.kuaishou.nebula.fileprovider", "com.kwai.videoeditor.kyfileprovider", "com.lemon.lvoverseas.provider", "com.lwcx.lw121.fileprovider", "com.zivn.cloudbrush3.utilcode.provider", "com.tencent.mtt.fileprovider", "com.campmobile.snowcamera.fileprovider", "com.android.fileexplorer.myprovider", "com.ifeimo.videoeditor.provider", "com.mi.android.globalFileexplorer.myprovider");
    static List<String> THIRD_FULL_PROVIDER = Arrays.asList("com.jk.cutout.application", "com.zone2345.fileprovider", "com.mobile.kadian.fileprovider");

    @Deprecated
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
        if ("content".equals(scheme)) {
            context.getContentResolver();
            if (isNewGooglePhotosUri(uri)) {
                try {
                    String path = uri.getPath();
                    if (path.contains("mediakey")) {
                        return getNewGooglephotosFilePath(context, uri);
                    }
                    int lastIndexOf = path.lastIndexOf("/ORIGINAL");
                    if (lastIndexOf < 0) {
                        lastIndexOf = path.lastIndexOf("/ACTUAL");
                    }
                    if (lastIndexOf < 0) {
                        return null;
                    }
                    return getDataColumn(context, Uri.parse(path.substring(path.indexOf("content"), path.lastIndexOf("/ORIGINAL"))), null, null);
                } catch (Exception unused2) {
                    return null;
                }
            }
            if (THIRD_PROVIDER.contains(uri.getAuthority())) {
                if (!TextUtils.isEmpty(uri.getPath())) {
                    ArrayList arrayList = new ArrayList(uri.getPathSegments());
                    arrayList.remove(0);
                    StringBuilder sb = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append("/").append((String) it.next());
                    }
                    return sb.toString();
                }
            } else if (THIRD_FULL_PROVIDER.contains(uri.getAuthority())) {
                String path2 = uri.getPath();
                if (!TextUtils.isEmpty(path2)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath() + path2;
                }
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.startsWith("/storage/emulated/")) {
                return lastPathSegment;
            }
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.contains(Constants.COLON_SEPARATOR)) {
                lastPathSegment = lastPathSegment.split(Constants.COLON_SEPARATOR)[1];
            }
            if (TextUtils.isDigitsOnly(lastPathSegment)) {
                return getDataColumn(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id= ?", new String[]{lastPathSegment});
            }
        }
        return null;
    }

    public static boolean isNewGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.contentprovider".equals(uri.getAuthority());
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

    private static File createImageFile(Context context, String str) {
        File file = new File(context.getCacheDir(), "uritemp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str);
    }

    private static String getNewGooglephotosFilePath(Context context, Uri uri) throws Exception {
        BufferedOutputStream bufferedOutputStream;
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, DownloadFileUtils.MODE_READ);
        FileInputStream fileInputStream = null;
        if (openFileDescriptor == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
                File createImageFile = createImageFile(context, uri.getPath().substring(uri.getPath().lastIndexOf("/")) + ".jpg");
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createImageFile));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read > 0) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream2.close();
                            bufferedOutputStream.close();
                            return createImageFile.getAbsolutePath();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }
}
