package com.apm.lite.p023k;

import com.apm.lite.p018f.C0755a;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* renamed from: com.apm.lite.k.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0788k {
    /* renamed from: a */
    public static void m813a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m814a(String str, int i) {
        C0755a.m617a("android.os.FileUtils", "setPermissions", str, Integer.valueOf(i), -1, -1);
    }

    /* renamed from: a */
    public static void m815a(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
