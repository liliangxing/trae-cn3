package com.bytedance.pia.core.misc;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class DetectableInputStream extends FilterInputStream {
    private int bytesRead;
    private final Detector detector;
    private int markPosition;
    private boolean reachEnd;

    /* loaded from: classes4.dex */
    public static class Detector {
        public void onException(Throwable th) {
        }

        public void onFinished(int i, boolean z) {
        }
    }

    public DetectableInputStream(InputStream inputStream, Detector detector) {
        super(inputStream);
        this.detector = detector;
        this.bytesRead = 0;
        this.markPosition = 0;
        this.reachEnd = false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int read = super.read();
            if (read == -1) {
                this.reachEnd = true;
            } else {
                this.bytesRead++;
            }
            return read;
        } catch (Throwable th) {
            this.detector.onException(th);
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = super.read(bArr, i, i2);
            if (read <= 0) {
                this.reachEnd = true;
            } else {
                this.bytesRead += read;
            }
            return read;
        } catch (Throwable th) {
            this.detector.onException(th);
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            long skip = super.skip(j);
            if (skip > 0) {
                this.bytesRead += (int) skip;
            }
            return skip;
        } catch (Throwable th) {
            this.detector.onException(th);
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            super.reset();
            int i = this.bytesRead;
            int i2 = this.markPosition;
            if (i > i2) {
                this.reachEnd = false;
            }
            this.bytesRead = i2;
        } catch (Throwable th) {
            this.detector.onException(th);
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        try {
            super.mark(i);
            this.markPosition = this.bytesRead;
        } catch (Throwable th) {
            this.detector.onException(th);
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } catch (Throwable th) {
            try {
                this.detector.onException(th);
                throw th;
            } finally {
                this.detector.onFinished(this.bytesRead, this.reachEnd);
            }
        }
    }
}
