package com.lynx.animax.util;

import com.lynx.animax.base.Status;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes6.dex */
public class UnzipUtil {
    private static final String TAG = "UnzipUtil";

    public static Status unzip(String str, String str2) {
        ZipInputStream zipInputStream = getZipInputStream(str);
        if (zipInputStream == null) {
            return new Status("open zip file error");
        }
        if (!makeDirectory(str2)) {
            return new Status("make dst directory error");
        }
        while (true) {
            ZipEntry nextEntry = getNextEntry(zipInputStream);
            if (nextEntry != null) {
                processEntry(zipInputStream, nextEntry, str2);
                closeEntry(zipInputStream);
            } else {
                closeZipInputStream(zipInputStream);
                return new Status(true);
            }
        }
    }

    private static ZipInputStream getZipInputStream(String str) {
        FileInputStream fileInputStream;
        if (str == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            AnimaXLog.e(TAG, "new FileInputStream error: " + e.getMessage());
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new ZipInputStream(fileInputStream);
    }

    private static void closeZipInputStream(ZipInputStream zipInputStream) {
        try {
            zipInputStream.close();
        } catch (IOException e) {
            AnimaXLog.e(TAG, "zipInputStream close error: " + e.getMessage());
        }
    }

    private static boolean makeDirectory(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private static ZipEntry getNextEntry(ZipInputStream zipInputStream) {
        try {
            return zipInputStream.getNextEntry();
        } catch (IOException e) {
            AnimaXLog.e(TAG, "getNextEntry error: " + e.getMessage());
            return null;
        }
    }

    private static void closeEntry(ZipInputStream zipInputStream) {
        try {
            zipInputStream.closeEntry();
        } catch (IOException e) {
            AnimaXLog.e(TAG, "closeEntry error: " + e.getMessage());
        }
    }

    private static boolean processEntry(ZipInputStream zipInputStream, ZipEntry zipEntry, String str) {
        String name = zipEntry.getName();
        if (name == null) {
            return false;
        }
        if (name.contains("__MACOSX") || name.contains(".DS_Store") || name.contains("../")) {
            return true;
        }
        if (zipEntry.isDirectory()) {
            return new File(str + File.separator + name).mkdirs();
        }
        return extractFile(zipInputStream, str + File.separator + name);
    }

    private static boolean extractFile(ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        int readZipFile;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (FileNotFoundException e) {
            AnimaXLog.e(TAG, "extractFile, create FileOutputStream error: " + e.getMessage());
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bArr = new byte[4096];
        try {
            do {
                readZipFile = readZipFile(zipInputStream, bArr);
                if (-1 != readZipFile) {
                }
                bufferedOutputStream.close();
                return true;
            } while (writeToStream(bArr, readZipFile, bufferedOutputStream));
            bufferedOutputStream.close();
            return true;
        } catch (IOException e2) {
            AnimaXLog.e(TAG, "close bufferedOutputStream error: " + e2.getMessage());
            return true;
        }
    }

    private static int readZipFile(ZipInputStream zipInputStream, byte[] bArr) {
        try {
            return zipInputStream.read(bArr);
        } catch (IOException e) {
            AnimaXLog.e(TAG, "readZipFile error: " + e.getMessage());
            return -1;
        }
    }

    private static boolean writeToStream(byte[] bArr, int i, BufferedOutputStream bufferedOutputStream) {
        try {
            bufferedOutputStream.write(bArr, 0, i);
            return true;
        } catch (IOException e) {
            AnimaXLog.e(TAG, "writeToStream error: " + e.getMessage());
            return false;
        }
    }
}
