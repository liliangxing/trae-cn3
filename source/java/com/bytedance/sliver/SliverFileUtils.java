package com.bytedance.sliver;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes5.dex */
class SliverFileUtils {
    static final int BUFFER = 8192;

    SliverFileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                                    throw new RuntimeException(str2 + " does not exist!");
                                }
                                compress(file2, zipOutputStream, "");
                            }
                            close(zipOutputStream);
                            close(checkedOutputStream);
                            close(fileOutputStream);
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
                        close(closeable);
                        close(file);
                        close(fileOutputStream);
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
                close(closeable);
                close(file);
                close(fileOutputStream);
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
            compressFile(file, zipOutputStream, str);
        }
    }

    private static void compressDirectory(File file, ZipOutputStream zipOutputStream, String str) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
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
            close(fileInputStream2);
            close(fileInputStream);
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
                    close(r2);
                    close(fileInputStream);
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
                close(fileInputStream2);
                close(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = r2;
            close(fileInputStream2);
            close(fileInputStream);
            throw th;
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
