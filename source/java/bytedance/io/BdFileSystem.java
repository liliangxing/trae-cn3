package bytedance.io;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import bytedance.util.BdFileUtils;
import bytedance.util.DtfsUtils;
import bytedance.util.FConstants;
import bytedance.util.FsLogger;
import coil3.util.Utils_commonKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BdFileSystem {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public static BdFileInputStream getFileInputStream(String str) throws FileNotFoundException, IllegalPathException {
        return new BdFileInputStream(str);
    }

    public static BdFileInputStream openFileInput(String str) throws FileNotFoundException, IllegalPathException {
        return new BdFileInputStream(str);
    }

    public static BdFileReader getFileReader(String str) throws FileNotFoundException, IllegalPathException {
        return new BdFileReader(str);
    }

    public static BdFileOutputStream getFileOutputStream(String str) throws FileNotFoundException, IllegalPathException {
        return new BdFileOutputStream(str);
    }

    public static BdFileOutputStream getFileOutputStream(String str, boolean z) throws FileNotFoundException, IllegalPathException {
        return new BdFileOutputStream(str, z);
    }

    public static BdFileWriter getFileWriter(String str) throws IOException {
        return new BdFileWriter(str);
    }

    public static BdFileWriter getFileWriter(String str, boolean z) throws IOException {
        return new BdFileWriter(str, z);
    }

    public static BdPrintStream getPrintStream(String str) throws FileNotFoundException, IllegalPathException {
        return new BdPrintStream(str);
    }

    public static BdPrintStream getPrintStream(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        return new BdPrintStream(str, str2);
    }

    public static BdPrintWriter getPrintWriter(String str) throws FileNotFoundException, IllegalPathException {
        return new BdPrintWriter(str);
    }

    public static BdPrintWriter getPrintWriter(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        return new BdPrintWriter(str, str2);
    }

    public static BdFile getFile(String str) throws IOException, IllegalPathException {
        return new BdFile(str);
    }

    public static BdFile getFile(File file, String str) throws IOException {
        return new BdFile(file, str);
    }

    public static BdFile getFile(String str, String str2) throws IOException {
        return new BdFile(str, str2);
    }

    public static BdRandomAccessFile getRandomAccessFile(String str, String str2) throws FileNotFoundException, IllegalPathException {
        return new BdRandomAccessFile(str, str2);
    }

    public static BdRandomAccessFile getRandomAccessFile(File file, String str) throws FileNotFoundException, IllegalPathException {
        return new BdRandomAccessFile(file, str);
    }

    public static boolean renameTo(File file, File file2) throws IllegalPathException {
        return file.renameTo(fms.resolve(file2));
    }

    public static boolean renameTo(String str, String str2) throws IOException, IllegalPathException {
        return getFile(str).renameTo(getFile(str2));
    }

    public static boolean delete(File file) throws IllegalPathException {
        return fms.resolve(file).delete();
    }

    public static boolean delete(String str) throws IOException {
        return getFile(str).delete();
    }

    public static boolean deleteByToken(String str) throws IOException {
        return getFile(str).delete();
    }

    public static void deleteOnExit(File file) throws IllegalPathException {
        fms.resolve(file).deleteOnExit();
    }

    public static void deleteOnExit(String str) throws IOException {
        getFile(str).deleteOnExit();
    }

    public static void deleteOnExitByToken(String str) throws IOException {
        getFile(str).deleteOnExit();
    }

    public static BdFile[] listFiles(String str) throws IOException {
        return getFile(str).listFiles();
    }

    public static void deleteFiles(List<BdFile> list) throws IllegalPathException {
        Iterator<BdFile> it = list.iterator();
        while (it.hasNext()) {
            fms.resolve(it.next()).delete();
        }
    }

    public static void deleteFiles(List<BdFile> list, boolean z) throws IllegalPathException {
        if (z) {
            for (BdFile bdFile : list) {
                FileManagerService fileManagerService = fms;
                if (fileManagerService.resolve(bdFile).isDirectory()) {
                    deleteFiles(new ArrayList(Arrays.asList(fileManagerService.resolve(bdFile).listFiles())));
                }
                if (!bdFile.isDirectory()) {
                    bdFile.delete();
                } else if (bdFile.listFiles().length == 0) {
                    bdFile.delete();
                }
            }
            return;
        }
        deleteFiles(list);
    }

    public static void doFileOperation(BdFileSystemCall bdFileSystemCall) {
        if (bdFileSystemCall == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 28) {
            bdFileSystemCall.onLegacySystem();
        } else if (Build.VERSION.SDK_INT == 29 && Environment.isExternalStorageLegacy()) {
            bdFileSystemCall.onLegacySystem();
        } else {
            bdFileSystemCall.onScopeSystem();
        }
    }

    public static void copyFile(String str, String str2) throws IOException {
        copyFile(getFile(str), getFile(str2));
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileManagerService fileManagerService = fms;
        BdFile resolve = fileManagerService.resolve(file);
        BdFile resolve2 = fileManagerService.resolve(file2);
        if (!resolve.exists()) {
            throw new FileNotFoundException("Failed to copy from->" + resolve + "to->" + resolve2 + "because of srcFile not exist");
        }
        if (resolve.getCanonicalPath().equals(resolve2.getCanonicalPath())) {
            throw new IOException("Failed to copy same path from->" + resolve + " to->" + resolve2);
        }
        if (resolve2.getParentFile() != null && !resolve2.getParentFile().exists() && !resolve2.getParentFile().mkdirs()) {
            throw new IOException("Failed to copy from->" + resolve + " to->" + resolve2 + " because of dest parent mkdir failed");
        }
        if (resolve2.exists() && !resolve2.canWrite()) {
            throw new IOException("Failed to copy from->" + resolve + " to->" + resolve2 + "because of destFile cant write!");
        }
        if (resolve.length() == -1) {
            throw new IOException("Failed to copy from->" + resolve + " to->" + resolve2 + " fileLen=-1");
        }
        FsLogger.m143d("begin to copy from->" + resolve + " to->" + resolve2);
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[4096];
            FileInputStream fileInputStream2 = new FileInputStream(resolve);
            try {
                fileOutputStream = new FileOutputStream(resolve2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read < 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        DtfsUtils.closeQuietly(fileInputStream);
                        DtfsUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                DtfsUtils.closeQuietly(fileInputStream2);
                DtfsUtils.closeQuietly(fileOutputStream);
                if (resolve.length() != resolve2.length()) {
                    throw new IOException("Failed to copy full contents from->" + resolve + " to->" + resolve2);
                }
                resolve2.setLastModified(resolve.lastModified());
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void copyFile(File file, FileOutputStream fileOutputStream) throws IOException {
        BdFile resolve = fms.resolve(file);
        if (!resolve.exists()) {
            throw new FileNotFoundException("Failed to copy from->" + resolve + "to->" + fileOutputStream.getFD() + "because of srcFile not exist");
        }
        if (resolve.length() == -1) {
            throw new IOException("Failed to copy from->" + resolve + " to->" + fileOutputStream.getFD() + " fileLen=-1");
        }
        FsLogger.m143d("begin to copy from->" + resolve + " to->" + fileOutputStream.getFD());
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[4096];
            FileInputStream fileInputStream2 = new FileInputStream(resolve);
            while (true) {
                try {
                    int read = fileInputStream2.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        DtfsUtils.closeQuietly(fileInputStream2);
                        DtfsUtils.closeQuietly(fileOutputStream);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    DtfsUtils.closeQuietly(fileInputStream);
                    DtfsUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void copyFile(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            if (inputStream == null || fileOutputStream == null) {
                throw new IOException("Failed to copy input:" + inputStream + "output:" + fileOutputStream);
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    return;
                }
            }
        } finally {
            DtfsUtils.closeQuietly(inputStream);
            DtfsUtils.closeQuietly(fileOutputStream);
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            if (inputStream == null || outputStream == null) {
                throw new IOException("Failed to copy input:" + inputStream + "output:" + outputStream);
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            DtfsUtils.closeQuietly(inputStream);
            DtfsUtils.closeQuietly(outputStream);
        }
    }

    public static ParcelFileDescriptor getFileDescriptor(Context context, Uri uri, String str) throws IOException {
        return context.getContentResolver().openFileDescriptor(uri, str);
    }

    public static ParcelFileDescriptor getReadFileDescriptor(Context context, Uri uri) throws IOException {
        return getFileDescriptor(context, uri, "r");
    }

    public static ParcelFileDescriptor getWriteFileDescriptor(Context context, Uri uri) throws IOException {
        return getFileDescriptor(context, uri, "rw");
    }

    public static InputStream getInputStream(Context context, Uri uri) throws FileNotFoundException {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || Utils_commonKt.SCHEME_FILE.equals(scheme)) {
            return new FileInputStream(uri.getPath());
        }
        if (DocumentsContract.isDocumentUri(context, uri) && TextUtils.equals(FConstants.MEDIA_DOCUMENTS, uri.getAuthority())) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            String str = split[0];
            if (TextUtils.equals("image", str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Images.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals("video", str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Video.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals(FConstants.URI_AUDIO, str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Audio.Media.getContentUri("external_primary");
                }
            } else {
                uri2 = null;
            }
            if (TextUtils.isEmpty(split[1])) {
                return null;
            }
            return context.getContentResolver().openInputStream(ContentUris.withAppendedId(uri2, Long.parseLong(split[1])));
        }
        if (StrategyConstants.CONTENT.equals(scheme) && "media".equals(uri.getAuthority())) {
            return context.getContentResolver().openInputStream(uri);
        }
        String convertUriToPath = BdFileUtils.convertUriToPath(context, uri);
        if (TextUtils.isEmpty(convertUriToPath) || !new File(convertUriToPath).exists()) {
            return null;
        }
        return new FileInputStream(new File(convertUriToPath));
    }

    public static OutputStream getOutputStream(Context context, Uri uri) throws FileNotFoundException {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || Utils_commonKt.SCHEME_FILE.equals(scheme)) {
            return new FileOutputStream(uri.getPath());
        }
        if (DocumentsContract.isDocumentUri(context, uri) && TextUtils.equals(FConstants.MEDIA_DOCUMENTS, uri.getAuthority())) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            String str = split[0];
            if (TextUtils.equals("image", str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Images.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals("video", str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Video.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals(FConstants.URI_AUDIO, str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                if (DtfsUtils.isAndroidQOrLater()) {
                    uri2 = MediaStore.Audio.Media.getContentUri("external_primary");
                }
            } else {
                uri2 = null;
            }
            if (TextUtils.isEmpty(split[1])) {
                return null;
            }
            return context.getContentResolver().openOutputStream(ContentUris.withAppendedId(uri2, Long.parseLong(split[1])));
        }
        if (StrategyConstants.CONTENT.equals(scheme) && "media".equals(uri.getAuthority())) {
            return context.getContentResolver().openOutputStream(uri);
        }
        String convertUriToPath = BdFileUtils.convertUriToPath(context, uri);
        if (TextUtils.isEmpty(convertUriToPath) || !new File(convertUriToPath).exists()) {
            return null;
        }
        return new FileOutputStream(new File(convertUriToPath));
    }

    private static Uri downloadFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read > 0) {
                bufferedOutputStream.write(bArr, 0, read);
                bufferedOutputStream.flush();
            } else {
                bufferedOutputStream.close();
                bufferedInputStream.close();
                return Uri.fromFile(file);
            }
        }
    }

    public static Uri downloadPublicFile(InputStream inputStream, String str, Context context) throws IOException {
        if (Build.VERSION.SDK_INT < 29) {
            return downloadFile(inputStream, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str));
        }
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
        contentValues.put("_display_name", str);
        contentValues.put("is_pending", (Integer) 1);
        Uri insert = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
        try {
            if (insert == null) {
                DtfsUtils.uploadEvent(500);
                throw new IOException("Failed to get Downloads uri");
            }
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(openOutputStream);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    contentResolver.update(insert, contentValues, null, null);
                    return insert;
                }
            }
        } catch (Exception e) {
            DtfsUtils.uploadEvent(FConstants.DOWNLOAD_FAIL_CODE);
            contentResolver.delete(insert, null, null);
            throw e;
        }
    }

    public static long getLength(Context context, Uri uri) {
        return BdMediaFileSystem.getLength(context, uri);
    }

    public static Uri createImageUri(Context context, String str) {
        return BdMediaFileSystem.createImageUri(context, str);
    }

    public static Uri createVideoUri(Context context, String str) {
        return BdMediaFileSystem.createVideoUri(context, str);
    }

    public static Uri createMusicUri(Context context, String str) {
        return BdMediaFileSystem.createMusicUri(context, str);
    }

    public static String getExternalDir(Context context) {
        return context.getExternalCacheDir().getParent();
    }

    public static long getAvailableStorageSize(Context context) {
        if (Environment.getDataDirectory() != null) {
            return getDirectoryAvailableSize(context.getFilesDir().getParent());
        }
        return -1L;
    }

    public static long getTotalStorageSize(Context context) {
        if (Environment.getDataDirectory() != null) {
            return getDirectoryTotalSize(context.getFilesDir().getParent());
        }
        return -1L;
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (DtfsUtils.isAndroidJB2OrLater()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (DtfsUtils.isAndroidJB2OrLater()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    public static boolean isUriExists(Context context, Uri uri) {
        return BdMediaFileSystem.isUriExists(context, uri);
    }
}
