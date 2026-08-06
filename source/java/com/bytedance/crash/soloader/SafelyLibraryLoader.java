package com.bytedance.crash.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class SafelyLibraryLoader {
    public static String unpackLibrary(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String unpackLibrary = unpackLibrary(applicationInfo.sourceDir, str, file);
        if (unpackLibrary == null) {
            return null;
        }
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            for (String str2 : strArr) {
                unpackLibrary = unpackLibrary(str2, str, file);
                if (unpackLibrary == null) {
                    return null;
                }
            }
        }
        return unpackLibrary;
    }

    private static String unpackLibrary(String str, String str2, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str2));
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int indexOf = Build.CPU_ABI.indexOf(45);
            StringBuilder sb = new StringBuilder("lib/");
            String str3 = Build.CPU_ABI;
            if (indexOf <= 0) {
                indexOf = Build.CPU_ABI.length();
            }
            String sb2 = sb.append(str3.substring(0, indexOf)).append("/").append(System.mapLibraryName(str2)).toString();
            ZipEntry entry2 = zipFile.getEntry(sb2);
            if (entry2 == null) {
                message = "Library entry not found:" + sb2;
                FileSystemUtils.close((Closeable) null);
                FileSystemUtils.close((Closeable) null);
                FileSystemUtils.close(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th3) {
            inputStream = inputStream2;
            th = th3;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read <= 0) {
                    FileSystemUtils.setPermissions(file.getAbsolutePath(), 493);
                    FileSystemUtils.close(fileOutputStream);
                    FileSystemUtils.close(inputStream2);
                    FileSystemUtils.close(zipFile);
                    return null;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th4) {
            fileOutputStream2 = fileOutputStream;
            inputStream = inputStream2;
            th = th4;
            try {
                message = th.getMessage();
                FileSystemUtils.close(fileOutputStream2);
                FileSystemUtils.close(inputStream);
                FileSystemUtils.close(zipFile);
                return message;
            } catch (Throwable th5) {
                FileSystemUtils.close(fileOutputStream2);
                FileSystemUtils.close(inputStream);
                FileSystemUtils.close(zipFile);
                throw th5;
            }
        }
    }
}
