package com.bytedance.crash.util;

import com.bytedance.crash.diagnose.NpthMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes3.dex */
public class SerializeFactory {
    private static final String BACKUP_SUFFIX = ".bk";

    public static Object load(File file) {
        FileInputStream fileInputStream;
        try {
            if (!file.exists()) {
                File file2 = new File(file.getAbsolutePath() + BACKUP_SUFFIX);
                if (!file2.exists()) {
                    return null;
                }
                file2.renameTo(file);
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        Object readObject = new ObjectInputStream(fileInputStream).readObject();
                        FileSystemUtils.close(fileInputStream);
                        return readObject;
                    } catch (Exception e) {
                        e = e;
                        FileUtils.deleteFile(file);
                        NpthMonitor.reportInnerException(e);
                        FileSystemUtils.close(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    FileSystemUtils.close(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                FileSystemUtils.close(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            NpthMonitor.reportInnerException(th3);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void store(File file, Object obj) {
        boolean z;
        FileOutputStream fileOutputStream;
        try {
            File file2 = new File(file.getAbsolutePath() + BACKUP_SUFFIX);
            if (file.isDirectory()) {
                FileUtils.deleteFile(file);
            } else if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            ?? r1 = 0;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                new ObjectOutputStream(fileOutputStream).writeObject(obj);
                FileSystemUtils.close(fileOutputStream);
                z = true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                NpthMonitor.reportInnerException(e);
                FileSystemUtils.close(fileOutputStream2);
                z = false;
                r1 = file2.exists();
                if (r1 == 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = fileOutputStream;
                FileSystemUtils.close((Closeable) r1);
                throw th;
            }
            r1 = file2.exists();
            if (r1 == 0) {
                if (z) {
                    FileUtils.deleteFile(file2);
                    return;
                }
                if (file.exists()) {
                    FileUtils.deleteFile(file);
                }
                file2.renameTo(file);
            }
        } catch (Throwable th3) {
            NpthMonitor.reportInnerException(th3);
        }
    }
}
