package com.huawei.secure.android.common.encrypt.utils;

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

/* renamed from: com.huawei.secure.android.common.encrypt.utils.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1289a {

    /* renamed from: a */
    private static final String f2071a = "IOUtil";

    /* renamed from: b */
    private static final int f2072b = 4096;

    /* renamed from: a */
    public static void m2304a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static byte[] m2312b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m2301a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m2309a(Reader reader) {
        m2305a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m2310a(Writer writer) {
        m2305a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m2307a(InputStream inputStream) {
        m2305a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m2308a(OutputStream outputStream) {
        m2305a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m2305a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C1290b.m2316b(f2071a, "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    public static long m2301a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m2302a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m2302a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
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
    public static InputStream m2303a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public static void m2306a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        C1290b.m2316b(f2071a, "deleteSecure exception");
    }

    /* renamed from: a */
    public static void m2311a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m2306a(new File(str));
    }
}
