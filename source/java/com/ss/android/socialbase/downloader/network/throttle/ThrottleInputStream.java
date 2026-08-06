package com.ss.android.socialbase.downloader.network.throttle;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class ThrottleInputStream extends InputStream {
    public static final int DEFAULT_THROTTLE_SMOOTHNESS = 40;
    private final InputStream in;
    private long overReadAndSleepTime;
    protected long periodStartTime;
    private long readBytesInPeriod;
    protected long throttleNetSpeed;
    protected volatile long throttlePeriod;
    private volatile long throttlePeriodBytes;
    protected int throttleSmoothness = 40;

    public ThrottleInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public void setThrottleNetSpeed(long j) {
        setThrottleNetSpeed(j, 0);
    }

    public void setThrottleNetSpeed(long j, int i) {
        this.throttleNetSpeed = j;
        if (i >= 1 && i <= 100) {
            this.throttleSmoothness = i;
        }
        this.throttlePeriod = 1000 / this.throttleSmoothness;
        this.throttlePeriodBytes = j / this.throttleSmoothness;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.throttlePeriodBytes > 0) {
            if (this.periodStartTime == 0) {
                this.periodStartTime = System.currentTimeMillis();
            }
            long j = this.throttlePeriodBytes - this.readBytesInPeriod;
            if (j > 0 && i2 > j) {
                i2 = (int) j;
            }
            int read = this.in.read(bArr, i, i2);
            if (read != -1) {
                this.readBytesInPeriod += read;
            }
            if (this.readBytesInPeriod >= this.throttlePeriodBytes) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = currentTimeMillis - this.periodStartTime;
                this.periodStartTime = currentTimeMillis;
                long j3 = this.throttlePeriod - j2;
                if (j3 > 0) {
                    long j4 = this.overReadAndSleepTime;
                    if (j3 > j4) {
                        long j5 = j3 - j4;
                        this.overReadAndSleepTime = 0L;
                        if (j5 > 0) {
                            this.periodStartTime += j5;
                            try {
                                Thread.sleep(j5);
                            } catch (InterruptedException e) {
                                throw new IOException(e);
                            }
                        }
                    } else {
                        this.overReadAndSleepTime = j4 - j3;
                    }
                } else if (j3 < 0) {
                    long j6 = this.overReadAndSleepTime + (-j3);
                    this.overReadAndSleepTime = j6;
                    if (j6 > 100) {
                        this.overReadAndSleepTime = 100L;
                    }
                }
                this.readBytesInPeriod = 0L;
            }
            return read;
        }
        return this.in.read(bArr, i, i2);
    }

    public int superRead(byte[] bArr, int i, int i2) throws IOException {
        return super.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.in.skip(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }
}
