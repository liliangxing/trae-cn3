package com.bytedance.memory.common;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes4.dex */
public class ZipUtil {
    private static final String SUFFIX_ZIP = ".zip";

    public static File compressFile(File file, boolean z) {
        File file2 = new File(file.getParentFile(), file.getName().substring(0, file.getName().lastIndexOf(LibrarianImpl.Constants.DOT)) + SUFFIX_ZIP);
        compressFile(file, file2);
        if (file2.exists() && z) {
            file.delete();
        }
        return file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0045 -> B:9:0x0048). Please report as a decompilation issue!!! */
    public static void compressFile(File file, File file2) {
        ZipOutputStream zipOutputStream;
        long currentTimeMillis = System.currentTimeMillis();
        ?? r3 = 0;
        ZipOutputStream zipOutputStream2 = null;
        r3 = 0;
        try {
            try {
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            r3 = r3;
        }
        try {
            compress(file, zipOutputStream, file.getName());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            MemoryLog.i("Compress over cost： %d ms", Long.valueOf(currentTimeMillis2));
            zipOutputStream.close();
            r3 = currentTimeMillis2;
        } catch (Exception e3) {
            e = e3;
            zipOutputStream2 = zipOutputStream;
            MemoryLog.d(e, "HeapFile compress failed", new Object[0]);
            r3 = zipOutputStream2;
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
                r3 = zipOutputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            r3 = zipOutputStream;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static void compress(File file, ZipOutputStream zipOutputStream, String str) throws Exception {
        byte[] bArr = new byte[2048];
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                zipOutputStream.closeEntry();
                fileInputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0073 -> B:21:0x0076). Please report as a decompilation issue!!! */
    public static void deflater(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        DeflaterOutputStream deflaterOutputStream;
        long currentTimeMillis = System.currentTimeMillis();
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        deflaterOutputStream = new DeflaterOutputStream(new FileOutputStream(file2));
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    deflaterOutputStream.write(bArr, 0, read);
                }
            }
            r3 = "Compress over cost： %d ms";
            MemoryLog.i("Compress over cost： %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (file2.exists() && z) {
                file.delete();
            }
            try {
                deflaterOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            fileInputStream.close();
        } catch (Exception e5) {
            e = e5;
            r3 = deflaterOutputStream;
            MemoryLog.d(e, "HeapFile compress failed", new Object[0]);
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            r3 = deflaterOutputStream;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }
}
