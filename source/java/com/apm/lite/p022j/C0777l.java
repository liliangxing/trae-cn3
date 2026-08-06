package com.apm.lite.p022j;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.apm.lite.j.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0777l extends GZIPOutputStream {
    public C0777l(OutputStream outputStream) {
        super(outputStream);
    }

    /* renamed from: a */
    public void m734a() {
        super.close();
    }

    /* renamed from: b */
    public void m735b() {
        super.finish();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public void finish() {
    }
}
