package com.ttnet.org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

@JNINamespace("base::android")
/* loaded from: classes7.dex */
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = new Function() { // from class: com.ttnet.org.chromium.base.FileUtils$$ExternalSyntheticLambda0
        @Override // com.ttnet.org.chromium.base.Function
        public final Object apply(Object obj) {
            return FileUtils.lambda$static$0((String) obj);
        }
    };
    private static final String TAG = "FileUtils";

    /* loaded from: classes7.dex */
    public interface Natives {
        String getAbsoluteFilePath(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$static$0(String str) {
        return true;
    }

    public static boolean recursivelyDeleteFile(File file, Function<String, Boolean> function) {
        File[] listFiles;
        if (!file.exists()) {
            file.delete();
            return true;
        }
        if (function != null && !function.apply(file.getPath()).booleanValue()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                recursivelyDeleteFile(file2, function);
            }
        }
        boolean delete = file.delete();
        if (!delete) {
            Log.e("FileUtils", "Failed to delete: %s", file);
        }
        return delete;
    }

    public static void batchDeleteFiles(List<String> list, Function<String, Boolean> function) {
        for (String str : list) {
            if (function == null || function.apply(str).booleanValue()) {
                if (ContentUriUtils.isContentUri(str)) {
                    ContentUriUtils.delete(str);
                } else {
                    File file = new File(str);
                    if (file.exists()) {
                        recursivelyDeleteFile(file, function);
                    }
                }
            }
        }
    }

    public static long getFileSizeBytes(File file) {
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j += getFileSizeBytes(file2);
            }
            return j;
        }
        return file.length();
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void copyStreamToFile(InputStream inputStream, File file) throws IOException {
        File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            Log.i("FileUtils", "Writing to %s", file);
            copyStream(inputStream, fileOutputStream);
            fileOutputStream.close();
            if (!file2.renameTo(file)) {
                throw new IOException();
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Uri getUriForFile(File file) {
        Uri uri;
        try {
            uri = ContentUriUtils.getContentUriFromFile(file);
        } catch (IllegalArgumentException e) {
            Log.e("FileUtils", "Could not create content uri: " + e, new Object[0]);
            uri = null;
        }
        return uri == null ? Uri.fromFile(file) : uri;
    }

    public static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        return lastIndexOf >= lastIndexOf2 ? "" : str.substring(lastIndexOf2 + 1).toLowerCase(Locale.US);
    }

    public static Bitmap queryBitmapFromContentProvider(Context context, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, DownloadFileUtils.MODE_READ);
            try {
                if (openFileDescriptor == null) {
                    Log.w("FileUtils", "Null ParcelFileDescriptor from uri " + uri, new Object[0]);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                if (fileDescriptor == null) {
                    Log.w("FileUtils", "Null FileDescriptor from uri " + uri, new Object[0]);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                if (decodeFileDescriptor != null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return decodeFileDescriptor;
                }
                Log.w("FileUtils", "Failed to decode image from uri " + uri, new Object[0]);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            } finally {
            }
        } catch (IOException unused) {
            Log.w("FileUtils", "IO exception when reading uri " + uri, new Object[0]);
            return null;
        }
    }

    public static String getAbsoluteFilePath(String str) {
        return FileUtilsJni.get().getAbsoluteFilePath(str);
    }
}
