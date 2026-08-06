package com.apm.lite.j;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class l extends GZIPOutputStream {
    public l(OutputStream outputStream) {
        super(outputStream);
    }

    public void a() {
        super.close();
    }

    public void b() {
        super.finish();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public void finish() {
    }
}
