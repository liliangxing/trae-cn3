package com.bytedance.apm6.util;

import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileUtils {
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:23:0x003c */
    public static byte[] readFileToByteArray(File file) {
        BufferedInputStream bufferedInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedInputStream.read(bArr, 0, length);
                    bufferedInputStream.close();
                    IOUtils.closeQuietly(bufferedInputStream);
                    return bArr;
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    IOUtils.closeQuietly(bufferedInputStream);
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    IOUtils.closeQuietly(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                IOUtils.closeQuietly(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(closeable2);
            throw th;
        }
    }

    public static boolean deleteFileWithResult(File file) {
        if (file != null && file.exists()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    public static long getAvailableStorage(String str) {
        return new StatFs(str).getAvailableBytes();
    }

    public static long getTotalStorageSize(String str) {
        return new StatFs(str).getTotalBytes();
    }
}
