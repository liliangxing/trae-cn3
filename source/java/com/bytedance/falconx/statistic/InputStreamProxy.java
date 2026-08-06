package com.bytedance.falconx.statistic;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class InputStreamProxy extends InputStream {
    private InputStream mOrigin;

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReadException(IOException iOException) {
    }

    public InputStreamProxy(InputStream inputStream) {
        this.mOrigin = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.mOrigin.read(bArr);
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.mOrigin.read(bArr, i, i2);
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.mOrigin.skip(j);
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.mOrigin.available();
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.mOrigin.close();
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.mOrigin.mark(i);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.mOrigin.reset();
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.mOrigin.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.mOrigin.read();
        } catch (IOException e) {
            onReadException(e);
            throw e;
        }
    }
}
