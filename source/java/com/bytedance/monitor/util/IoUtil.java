package com.bytedance.monitor.util;

import com.bytedance.monitor.util.jni.JavaCalls;
import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
public class IoUtil {
    private IoUtil() {
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void safeClose(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean mkdir(String str) {
        return new File(str).mkdirs();
    }

    public static void setPermissions(String str, int i) {
        JavaCalls.callStaticMethod("android.os.FileUtils", "setPermissions", str, Integer.valueOf(i), -1, -1);
    }
}
