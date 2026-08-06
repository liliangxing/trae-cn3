package com.huawei.secure.android.common.ssl.util;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.huawei.secure.android.common.ssl.util.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1301d {

    /* renamed from: a */
    private static final String f2206a = "IOUtil";

    /* renamed from: b */
    private static final int f2207b = 4096;

    /* renamed from: a */
    public static void m2395a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static byte[] m2403b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m2392a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m2400a(Reader reader) {
        m2396a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m2401a(Writer writer) {
        m2396a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m2398a(InputStream inputStream) {
        m2396a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m2399a(OutputStream outputStream) {
        m2396a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m2396a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C1302e.m2407b(f2206a, "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    public static long m2392a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m2393a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m2393a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* renamed from: a */
    public static InputStream m2394a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public static void m2397a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        C1302e.m2407b(f2206a, "deleteSecure exception");
    }

    /* renamed from: a */
    public static void m2402a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m2397a(new File(str));
    }
}
