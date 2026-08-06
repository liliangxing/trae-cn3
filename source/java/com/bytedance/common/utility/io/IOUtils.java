package com.bytedance.common.utility.io;

import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean mkdir(String str) {
        return new File(str).mkdirs();
    }

    public static boolean copyFile(File file, File file2) {
        if (!file.exists() || !file.isFile() || file2.isDirectory()) {
            return false;
        }
        if (file2.exists()) {
            file2.delete();
        }
        try {
            byte[] bArr = new byte[2048];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(new File(str), new File(str2));
    }

    public static String readFileFirstLine(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readLine;
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void deletePath(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                if (str3 != null) {
                    if (str.endsWith(File.separator)) {
                        str2 = str + str3;
                    } else {
                        str2 = str + File.separator + str3;
                    }
                    File file2 = new File(str2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        deletePath(str2);
                    }
                }
            }
            file.delete();
        }
    }

    public static void clearPath(String str) {
        String str2;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (String str3 : file.list()) {
                if (str.endsWith(File.separator)) {
                    str2 = str + str3;
                } else {
                    str2 = str + File.separator + str3;
                }
                File file2 = new File(str2);
                if (file2.isFile()) {
                    file2.delete();
                }
                if (file2.isDirectory()) {
                    deletePath(str2);
                }
            }
        }
    }

    public static long getFileSize(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                try {
                    length += getFileSize(file2.getAbsolutePath());
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    return 0L;
                } catch (StackOverflowError e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
        }
        return length;
    }

    public static String getFileName(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf + 1);
    }

    public static String getParentFilePath(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return null;
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf;
        String fileName = getFileName(str);
        return (fileName == null || fileName.length() <= 0 || (lastIndexOf = fileName.lastIndexOf(46)) <= 0) ? fileName : fileName.substring(0, lastIndexOf);
    }

    public static String getFileExtension(String str) {
        int lastIndexOf = str.lastIndexOf(LibrarianImpl.Constants.DOT);
        return (lastIndexOf < 0 || lastIndexOf >= str.length() + (-1)) ? "" : str.substring(lastIndexOf + 1).toUpperCase(Locale.getDefault());
    }

    public static boolean renameFile(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static long getAvailableBytes(String str) {
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(str);
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getAllBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                StatFs statFs = new StatFs(str);
                return statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static boolean canWrite(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(file, LibrarianImpl.Constants.DOT + System.currentTimeMillis());
        boolean mkdir = file2.mkdir();
        return mkdir ? file2.delete() : mkdir;
    }

    public static void setPermissions(String str, int i) {
        JavaCalls.callStaticMethod("android.os.FileUtils", str, Integer.valueOf(i), -1, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002c, code lost:
    
        if (r0 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void write(String str, String str2, boolean z) {
        FileWriter fileWriter = null;
        try {
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileWriter fileWriter2 = new FileWriter(str, z);
                    try {
                        fileWriter2.write(str2);
                        fileWriter2.close();
                    } catch (IOException e) {
                        e = e;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        th.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
            }
            throw th3;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void close(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
