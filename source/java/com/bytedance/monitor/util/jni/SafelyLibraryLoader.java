package com.bytedance.monitor.util.jni;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.monitor.util.IoUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
public class SafelyLibraryLoader {
    private static final String LIB_DIR = "libso";
    private static List<String> sLoadedLibs = new ArrayList();

    public static synchronized boolean loadLibrary(Context context, String str) {
        synchronized (SafelyLibraryLoader.class) {
            if (sLoadedLibs.contains(str)) {
                return true;
            }
            try {
                System.loadLibrary(str);
                sLoadedLibs.add(str);
            } catch (UnsatisfiedLinkError e) {
                File libraryFile = getLibraryFile(context, str);
                if (libraryFile == null) {
                    return false;
                }
                if (libraryFile.exists()) {
                    libraryFile.delete();
                }
                String unpackLibrary = unpackLibrary(context, str, libraryFile);
                if (unpackLibrary != null) {
                    Log.e("loadLibrary", e.getMessage() + "[" + unpackLibrary + "]");
                    return false;
                }
                try {
                    System.load(libraryFile.getAbsolutePath());
                    sLoadedLibs.add(str);
                } catch (Throwable unused) {
                    return false;
                }
            } catch (Throwable unused2) {
                return false;
            }
            return true;
        }
    }

    private static File getLibraryFolder(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), LIB_DIR);
        if (!file.exists()) {
            IoUtil.mkdir(file.getAbsolutePath());
        }
        return file;
    }

    private static File getLibraryFile(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File libraryFolder = getLibraryFolder(context);
        if (libraryFolder != null) {
            return new File(libraryFolder, mapLibraryName);
        }
        return null;
    }

    public static String unpackLibrary(Context context, String str, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
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
            String str2 = Build.CPU_ABI;
            if (indexOf <= 0) {
                indexOf = Build.CPU_ABI.length();
            }
            String sb2 = sb.append(str2.substring(0, indexOf)).append("/").append(System.mapLibraryName(str)).toString();
            ZipEntry entry2 = zipFile.getEntry(sb2);
            if (entry2 == null) {
                message = "Library entry not found:" + sb2;
                IoUtil.safeClose((Closeable) null);
                IoUtil.safeClose((Closeable) null);
                IoUtil.safeClose(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read <= 0) {
                        IoUtil.setPermissions(file.getAbsolutePath(), 493);
                        IoUtil.safeClose(fileOutputStream2);
                        IoUtil.safeClose(inputStream2);
                        IoUtil.safeClose(zipFile);
                        return null;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                th = th3;
                try {
                    message = th.getMessage();
                    IoUtil.safeClose(fileOutputStream);
                    IoUtil.safeClose(inputStream);
                    IoUtil.safeClose(zipFile);
                    return message;
                } catch (Throwable th4) {
                    IoUtil.safeClose(fileOutputStream);
                    IoUtil.safeClose(inputStream);
                    IoUtil.safeClose(zipFile);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            inputStream = inputStream2;
            th = th5;
        }
    }
}
