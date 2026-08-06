package com.apm.lite.p018f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0788k;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.apm.lite.f.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0757c {

    /* renamed from: a */
    private static List<String> f473a = new ArrayList();

    /* renamed from: a */
    public static String m633a(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String m634a = m634a(applicationInfo.sourceDir, str, file);
        if (m634a == null) {
            return null;
        }
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            for (String str2 : strArr) {
                m634a = m634a(str2, str, file);
                if (m634a == null) {
                    return null;
                }
            }
        }
        try {
            ClassLoader classLoader = C0757c.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return m634a;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String str3 : (String[]) declaredField2.get(obj)) {
                File file2 = new File(str3, System.mapLibraryName(str));
                if (file2.exists()) {
                    C0786i.m787a(file2, file);
                    C0788k.m814a(file.getAbsolutePath(), 493);
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    /* renamed from: a */
    public static String m634a(String str, String str2, File file) {
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
                C0788k.m813a((Closeable) null);
                C0788k.m813a((Closeable) null);
                C0788k.m815a(zipFile);
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
                    C0788k.m814a(file.getAbsolutePath(), 493);
                    C0788k.m813a(fileOutputStream);
                    C0788k.m813a(inputStream2);
                    C0788k.m815a(zipFile);
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
                C0788k.m813a(fileOutputStream2);
                C0788k.m813a(inputStream);
                C0788k.m815a(zipFile);
                return message;
            } catch (Throwable th5) {
                C0788k.m813a(fileOutputStream2);
                C0788k.m813a(inputStream);
                C0788k.m815a(zipFile);
                throw th5;
            }
        }
    }
}
