package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    @Deprecated
    public void setFinalize(boolean z) {
    }

    public ZstdOutputStream(OutputStream outputStream, int i) throws IOException {
        this(outputStream, NoPool.INSTANCE);
        this.inner.setLevel(i);
    }

    public ZstdOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, NoPool.INSTANCE);
    }

    private ZstdOutputStream(OutputStream outputStream, BufferPool bufferPool) throws IOException {
        super(outputStream);
        this.inner = new ZstdOutputStreamNoFinalizer(outputStream, bufferPool);
    }

    protected void finalize() throws Throwable {
        close();
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    public ZstdOutputStream setChecksum(boolean z) throws IOException {
        this.inner.setChecksum(z);
        return this;
    }

    public ZstdOutputStream setLevel(int i) throws IOException {
        this.inner.setLevel(i);
        return this;
    }

    public ZstdOutputStream setLong(int i) throws IOException {
        this.inner.setLong(i);
        return this;
    }

    public ZstdOutputStream setWorkers(int i) throws IOException {
        this.inner.setWorkers(i);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean z) throws IOException {
        this.inner.setCloseFrameOnFlush(z);
        return this;
    }

    public ZstdOutputStream setDict(byte[] bArr) throws IOException {
        this.inner.setDict(bArr);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress zstdDictCompress) throws IOException {
        this.inner.setDict(zstdDictCompress);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.inner.write(bArr, i, i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.inner.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.inner.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }
}
