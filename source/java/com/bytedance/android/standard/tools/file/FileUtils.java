package com.bytedance.android.standard.tools.file;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.logging.Logger;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.Set;

/* loaded from: classes3.dex */
public final class FileUtils {
    private static final byte[] GIF87A = {71, 73, 70, 56, 55, 97};
    private static final byte[] GIF89A = {71, 73, 70, 56, 57, 97};
    private static final byte[] JPEG = {-1, -40, -1};
    private static final byte[] PNG = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final String TAG = "FileUtils";

    /* loaded from: classes3.dex */
    public enum ImageType {
        UNKNOWN,
        JPG,
        PNG,
        GIF
    }

    private FileUtils() {
    }

    public static long getFileOrFolderSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            return getFolderSize(file);
        }
        if (file.isFile()) {
            return getFileSize(file);
        }
        return 0L;
    }

    public static long getFileSize(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            j = fileInputStream.available();
            fileInputStream.close();
        } catch (FileNotFoundException e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return j;
        } catch (IOException e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
        return j;
    }

    public static long getFolderSize(File file) {
        long fileSize;
        long j = 0;
        if (file != null && (file.exists() || file.isDirectory())) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        fileSize = getFolderSize(file2);
                    } else if (file2.isFile()) {
                        fileSize = getFileSize(file2);
                    }
                    j += fileSize;
                }
            }
        }
        return j;
    }

    public static long getDirSize(String str) {
        long j = 0;
        if (isSdcardWritable() && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return 0L;
                }
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        j += file2.length();
                    }
                }
            }
        }
        return j;
    }

    public static void deleteFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            deleteFile(file);
        } else if (file.isDirectory()) {
            deleteFolder(file);
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public static void deleteFolder(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (file2.isDirectory()) {
                    deleteFolder(file2);
                    file2.delete();
                } else if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }

    public static boolean isDirectoryExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && file.exists();
    }

    public static boolean isDirectoryNotEmpty(String str) {
        String[] list;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && file.exists() && (list = file.list()) != null && list.length > 0;
    }

    public static void ensureDirExists(File file) {
        if (file == null || file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.renameTo(new File(str2));
    }

    public static boolean removeFile(String str) {
        if (!isSdcardWritable()) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canWrite() && file.delete();
    }

    public static boolean checkFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdcardStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean isSdcardAvailable() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState)) {
                if (!"mounted_ro".equals(externalStorageState)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long getSDAvailableSize() {
        if (isSdcardAvailable()) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes();
        }
        return 0L;
    }

    public static long getTotalStorageSize() {
        if (isSdcardAvailable()) {
            return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getTotalBytes();
        }
        return 0L;
    }

    public static boolean copyWithNio(String str, String str2) {
        return copyWithNio(new File(str), new File(str2));
    }

    public static boolean copyWithNio(File file, File file2) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3 = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel3 = new FileOutputStream(file2).getChannel();
                fileChannel3.transferFrom(channel, 0L, channel.size());
                boolean exists = file2.exists();
                safelyClose(channel);
                safelyClose(fileChannel3);
                return exists;
            } catch (Exception unused) {
                FileChannel fileChannel4 = fileChannel3;
                fileChannel3 = channel;
                fileChannel2 = fileChannel4;
                safelyClose(fileChannel3);
                safelyClose(fileChannel2);
                return false;
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel5 = fileChannel3;
                fileChannel3 = channel;
                fileChannel = fileChannel5;
                safelyClose(fileChannel3);
                safelyClose(fileChannel);
                throw th;
            }
        } catch (Exception unused2) {
            fileChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    private static void safelyClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static InputStream getInputStream(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static byte[] getByteArray(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) fileInputStream.read();
            }
            fileInputStream.close();
            return bArr;
        } catch (Exception e) {
            try {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static boolean copyFile(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2) || StringUtils.isEmpty(str3)) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean saveInputStream = saveInputStream(fileInputStream, str2, str3);
            try {
                fileInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return saveInputStream;
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
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
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    Logger.d("FileUtils", "save inputstream error: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public static ImageType getImageType(String str) {
        if (!StringUtils.isEmpty(str)) {
            return getImageType(new File(str));
        }
        return ImageType.UNKNOWN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0072 -> B:35:0x0075). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (file == null || !file.exists()) {
            return ImageType.UNKNOWN;
        }
        ImageType imageType = ImageType.UNKNOWN;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            fileInputStream2 = fileInputStream2;
        }
        try {
            bArr = new byte[8];
            fileInputStream.read(bArr);
        } catch (Exception e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            e.printStackTrace();
            fileInputStream2 = fileInputStream3;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
                fileInputStream2 = fileInputStream3;
            }
            return imageType;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (!checkSignature(bArr, GIF89A) && !checkSignature(bArr, GIF87A)) {
            if (checkSignature(bArr, JPEG)) {
                ImageType imageType2 = ImageType.JPG;
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return imageType2;
            }
            byte[] bArr2 = PNG;
            if (!checkSignature(bArr, bArr2)) {
                fileInputStream.close();
                fileInputStream2 = bArr2;
                return imageType;
            }
            ImageType imageType3 = ImageType.PNG;
            try {
                fileInputStream.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return imageType3;
        }
        ImageType imageType4 = ImageType.GIF;
        try {
            fileInputStream.close();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return imageType4;
    }

    public static boolean isGif(File file) {
        return getImageType(file) == ImageType.GIF;
    }

    public static boolean exists(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private static boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void chmod(String str, int i) {
        Method method;
        int intValue;
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            if (cls == null || (method = cls.getMethod("setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)) == null || (intValue = ((Integer) method.invoke(null, str, Integer.valueOf(i), -1, -1)).intValue()) == 0) {
                return;
            }
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + intValue + " for '" + str + "', probably didn't work.");
        } catch (ClassNotFoundException unused) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        } catch (IllegalAccessException unused2) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        } catch (NoSuchMethodException unused3) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        } catch (InvocationTargetException unused4) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        } catch (Throwable unused5) {
        }
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf;
        String name = new File(str).getName();
        return (StringUtils.isEmpty(name) || -1 == (lastIndexOf = name.lastIndexOf(LibrarianImpl.Constants.DOT))) ? "" : name.substring(0, lastIndexOf);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(LibrarianImpl.Constants.DOT);
        return lastIndexOf == -1 ? "" : str.substring(lastIndexOf + 1);
    }

    public static void clearDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath());
                } else if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public static void removeDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath());
                } else {
                    listFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static void clearDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath(), set);
                } else if (listFiles[i].isFile()) {
                    String name = listFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static void removeDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath(), set);
                } else {
                    String name = listFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        long j = 0;
        if (!file.exists() && file.isDirectory()) {
            return 0L;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                length = getDirectorySize(file2, z);
            } else if (file2.isFile()) {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCacheDirPath(Context context) throws NullPointerException {
        String path;
        if (context == null) {
            throw new NullPointerException("Context is NUll");
        }
        String str = null;
        if (context.getCacheDir() != null) {
            path = context.getCacheDir().getPath();
        } else {
            File dir = context.getDir("/data/data/" + context.getPackageName() + "/cache/", 0);
            if (dir != null) {
                path = dir.getPath();
            }
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            throw new NullPointerException("Cannot Create Cache Dir");
        }
        str = path;
        if (StringUtils.isEmpty(str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFilesDirPath(Context context) throws NullPointerException {
        String path;
        if (context == null) {
            throw new NullPointerException("Context is NUll");
        }
        String str = null;
        if (context.getFilesDir() != null) {
            path = context.getFilesDir().getPath();
        } else {
            File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
            if (dir != null) {
                path = dir.getPath();
            }
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            throw new NullPointerException("Cannot Create Files Dir");
        }
        str = path;
        if (StringUtils.isEmpty(str)) {
        }
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static ByteArrayOutputStream cloneBuffer(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream;
    }

    public static boolean makeSureFileExist(File file) {
        if (!makesureParentDirExist(file)) {
            return false;
        }
        if (file.isFile()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                Logger.e("FileUtils", "catch", e);
                return false;
            }
        }
        if (file.isDirectory()) {
            return file.mkdir();
        }
        return false;
    }

    private static boolean makesureParentDirExist(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return true;
        }
        return mkdirs(parentFile);
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        return file.mkdirs();
    }

    public static boolean deleteInnerFile(File file, Context context) {
        boolean z = false;
        if (file != null && context != null && file.exists()) {
            String absolutePath = file.getAbsolutePath();
            File externalFilesDir = context.getExternalFilesDir(null);
            File externalCacheDir = context.getExternalCacheDir();
            File cacheDir = context.getCacheDir();
            String absolutePath2 = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
            String absolutePath3 = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : "";
            String absolutePath4 = cacheDir != null ? cacheDir.getAbsolutePath() : "";
            if (TextUtils.isEmpty(absolutePath)) {
                return false;
            }
            if ((!TextUtils.isEmpty(absolutePath2) && absolutePath.startsWith(absolutePath2)) || ((!TextUtils.isEmpty(absolutePath3) && absolutePath.startsWith(absolutePath3)) || (!TextUtils.isEmpty(absolutePath4) && absolutePath.startsWith(absolutePath4)))) {
                z = true;
            }
            if (z) {
                try {
                    deleteFile(file);
                } catch (Exception e) {
                    Logger.w("FileUtils.deleteInnerFile", e.toString());
                }
            }
        }
        return z;
    }
}
