package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class InputStreamWrap extends InputStream {
    private SsCall mRealCall;
    private InputStream mRealIn;

    public InputStreamWrap(InputStream inputStream, SsCall ssCall) {
        this.mRealIn = inputStream;
        this.mRealCall = ssCall;
    }

    public InputStreamWrap() {
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read;
        try {
            InputStream inputStream = this.mRealIn;
            if (inputStream != null) {
                read = inputStream.read(bArr);
            } else {
                read = super.read(bArr);
            }
            if (read == -1) {
                close();
            }
            return read;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        try {
            InputStream inputStream = this.mRealIn;
            if (inputStream != null) {
                read = inputStream.read(bArr, i, i2);
            } else {
                read = super.read(bArr, i, i2);
            }
            if (read == -1) {
                close();
            }
            return read;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            InputStream inputStream = this.mRealIn;
            int read = inputStream != null ? inputStream.read() : -1;
            if (read == -1) {
                close();
            }
            return read;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.mRealIn;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return super.skip(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.mRealIn;
        if (inputStream != null) {
            return inputStream.available();
        }
        return super.available();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        InputStream inputStream = this.mRealIn;
        if (inputStream != null) {
            inputStream.mark(i);
        } else {
            super.mark(i);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        InputStream inputStream = this.mRealIn;
        if (inputStream != null) {
            inputStream.reset();
        } else {
            super.reset();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.mRealIn;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return super.markSupported();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            InputStream inputStream = this.mRealIn;
            if (inputStream != null) {
                inputStream.close();
            }
            SsCall ssCall = this.mRealCall;
            if (ssCall != null) {
                ssCall.cancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.close();
    }
}
