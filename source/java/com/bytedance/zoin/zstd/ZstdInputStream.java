package com.bytedance.zoin.zstd;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ZstdInputStream extends com.bytedance.compression.zstd.ZstdInputStream {
    private boolean finalize;

    public ZstdInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.finalize = true;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public ZstdInputStream setContinuous(boolean z) {
        super.setContinuous(z);
        return this;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public boolean getContinuous() {
        return super.getContinuous();
    }

    public void setFinalize(boolean z) {
        this.finalize = z;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public ZstdInputStream setDict(byte[] bArr) throws IOException {
        super.setDict(bArr);
        return this;
    }

    public ZstdInputStream setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        super.setDict((com.bytedance.compression.zstd.ZstdDictDecompress) zstdDictDecompress);
        return this;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return super.read(bArr, i, i2);
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return super.read();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return super.available();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return super.markSupported();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return super.skip(j);
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    protected void finalize() throws Throwable {
        if (this.finalize) {
            close();
        }
    }
}
