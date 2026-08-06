package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.ProxyInputStream
    protected synchronized void afterRead(int i) {
        if (i != -1) {
            this.count += i;
        }
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= SieveCacheKt.NodeLinkMask) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= SieveCacheKt.NodeLinkMask) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long skip;
        skip = super.skip(j);
        this.count += skip;
        return skip;
    }
}
