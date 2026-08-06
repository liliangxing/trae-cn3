package com.bytedance.apm.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class FileUtils {
    static final int BUFFER = 8192;
    public static final String TAG = "FileUtils";

    public static String getFormatSize(double d) {
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return d + "Byte(s)";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }

    public static void removeDir(String str) {
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

    public static boolean copyFile(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
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
            IoUtil.safeClose(fileInputStream);
            return saveInputStream;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            IoUtil.safeClose(fileInputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            IoUtil.safeClose(fileInputStream2);
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
                if (file.exists() || file.mkdirs()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                inputStream.close();
                                IoUtil.safeClose((Closeable) null);
                                IoUtil.safeClose(inputStream);
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        Log.d(TAG, "save inputstream error: " + e);
                        IoUtil.safeClose(fileOutputStream);
                        IoUtil.safeClose(inputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        IoUtil.safeClose(fileOutputStream);
                        IoUtil.safeClose(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            IoUtil.safeClose(fileOutputStream);
            IoUtil.safeClose(inputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void compress(String str, String... strArr) {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        Exception e;
        ?? file = new File(str);
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file);
                try {
                    CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
                        try {
                            for (String str2 : strArr) {
                                File file2 = new File(str2);
                                if (!file2.exists()) {
                                    throw new RuntimeException(str2 + "not exist！");
                                }
                                compress(file2, zipOutputStream, "");
                            }
                            IoUtil.safeClose(zipOutputStream);
                            IoUtil.safeClose(checkedOutputStream);
                            IoUtil.safeClose(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            throw new RuntimeException(e);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e = e;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        file = checkedOutputStream;
                        th = th;
                        IoUtil.safeClose(closeable);
                        IoUtil.safeClose((Closeable) file);
                        IoUtil.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                IoUtil.safeClose(closeable);
                IoUtil.safeClose((Closeable) file);
                IoUtil.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            file = 0;
            fileOutputStream = null;
            closeable = null;
        }
    }

    private static void compress(File file, ZipOutputStream zipOutputStream, String str) {
        if (file.isDirectory()) {
            compressDirectory(file, zipOutputStream, str + file.getName() + File.separator);
        } else {
            System.out.println("compress：" + str + file.getName());
            compressFile(file, zipOutputStream, str);
        }
    }

    private static void compressDirectory(File file, ZipOutputStream zipOutputStream, String str) {
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                compress(file2, zipOutputStream, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private static void compressFile(File file, ZipOutputStream zipOutputStream, String str) {
        FileInputStream fileInputStream;
        ?? r2;
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            r2 = 0;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            r2 = new BufferedInputStream(fileInputStream);
        } catch (Exception e2) {
            e = e2;
            r2 = 0;
        } catch (Throwable th2) {
            th = th2;
            IoUtil.safeClose(fileInputStream2);
            IoUtil.safeClose(fileInputStream);
            throw th;
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = r2.read(bArr, 0, 8192);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    IoUtil.safeClose((Closeable) r2);
                    IoUtil.safeClose(fileInputStream);
                    return;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            r2 = r2;
            try {
                throw new RuntimeException(e);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                fileInputStream2 = r2;
                IoUtil.safeClose(fileInputStream2);
                IoUtil.safeClose(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = r2;
            IoUtil.safeClose(fileInputStream2);
            IoUtil.safeClose(fileInputStream);
            throw th;
        }
    }

    public static String getFileNameWithoutSuffix(File file) {
        String[] split = file.getName().split("\\.");
        return split.length > 1 ? split[split.length - 2] : "";
    }

    public static long getSize(File file) {
        long j = -1;
        if (!file.exists()) {
            return -1L;
        }
        if (file.isFile()) {
            return file.length();
        }
        if (file.isDirectory()) {
            j = 0;
            for (File file2 : file.listFiles()) {
                j += getSize(file2);
            }
        }
        return j;
    }

    public static File getExternalRootDir(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            file = context.getExternalFilesDir(null);
            do {
                file = file.getParentFile();
            } while (file.getAbsolutePath().contains("/Android"));
        } catch (Throwable unused) {
        }
        return file;
    }
}
