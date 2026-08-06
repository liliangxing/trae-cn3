package com.bytedance.forest.utils.io;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.InternalReporter;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: batch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0004J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\"\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/forest/utils/io/ForestBatchInputStream;", "Ljava/io/InputStream;", "provider", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "batchSize", "", "(Lcom/bytedance/forest/model/InMemoryByteBuffer;Lcom/bytedance/forest/model/Response;I)V", "cursor", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFinished", "readCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getReadCounter", "()Ljava/util/concurrent/atomic/AtomicInteger;", "available", EventReport.DIALOG_CLOSE, "", "getLogger", "Lcom/bytedance/forest/utils/ForestLogger;", "onException", "e", "", "functionName", "", "read", "b", "", "off", "len", "skip", "", "n", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ForestBatchInputStream extends InputStream {
    private final int batchSize;
    private int cursor;
    private final AtomicBoolean isClosed;
    private final AtomicBoolean isFinished;
    private final InMemoryByteBuffer provider;
    private final AtomicInteger readCounter;
    private final Response response;

    public ForestBatchInputStream(InMemoryByteBuffer inMemoryByteBuffer, Response response, int i) {
        Intrinsics.checkParameterIsNotNull(inMemoryByteBuffer, "provider");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.provider = inMemoryByteBuffer;
        this.response = response;
        this.batchSize = i;
        this.isFinished = new AtomicBoolean(false);
        this.isClosed = new AtomicBoolean(false);
        this.readCounter = new AtomicInteger(-1);
    }

    protected final AtomicInteger getReadCounter() {
        return this.readCounter;
    }

    @Override // java.io.InputStream
    public int read() {
        return read(new byte[1], 0, 1);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        int i;
        if (this.isClosed.get()) {
            throw new IOException("InputStream has been closed!");
        }
        if (this.isFinished.get()) {
            return -1;
        }
        int incrementAndGet = this.readCounter.incrementAndGet();
        if (b == null) {
            throw new NullPointerException("Input ByteArray is NULL!");
        }
        int hashCode = hashCode();
        int min = Math.min(b.length - off, len);
        if (min == 0) {
            return 0;
        }
        int size = this.provider.size();
        int i2 = this.cursor;
        if (min <= size - i2) {
            i = this.provider.getBytesAtRange$forest_release(i2, b, off, min, this.response);
        } else {
            int i3 = this.batchSize;
            int i4 = ((min / i3) + (min % i3 != 0 ? 1 : 0)) * i3;
            byte[] bArr = new byte[i4];
            int bytesAtRange$forest_release = this.provider.getBytesAtRange$forest_release(i2, bArr, 0, i4, this.response);
            if (bytesAtRange$forest_release > 0) {
                int min2 = Math.min(bytesAtRange$forest_release, min);
                System.arraycopy(bArr, 0, b, off, min2);
                i = min2;
            } else {
                i = bytesAtRange$forest_release;
            }
        }
        if (i == -1) {
            ForestLogger.print$default(getLogger(), 4, "Streaming", "[" + incrementAndGet + '-' + hashCode + "] read finished， cursor:" + this.cursor, false, null, null, 56, null);
            this.isFinished.set(true);
            this.cursor = this.provider.size();
        } else {
            this.cursor += i;
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InternalReporter.reportForestConsume$forest_release$default(this.provider.getContext().getReporter(), this.response, null, 2, null);
        this.isClosed.set(true);
        try {
            this.provider.close();
        } catch (Throwable th) {
            onException(th, EventReport.DIALOG_CLOSE);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        return super.skip(n);
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.isClosed.get()) {
            throw new IOException("InputStream has been closed!");
        }
        try {
            if (this.provider.isCacheProvided$forest_release()) {
                return this.provider.size() - this.cursor;
            }
            return this.provider.size();
        } catch (Throwable th) {
            onException(th, "available");
            throw th;
        }
    }

    private final void onException(Throwable e, String functionName) {
        ForestLogger.print$default(getLogger(), 6, "Streaming", "error happens when executing " + functionName, true, e, null, 32, null);
        if (this.provider.isCacheClear$forest_release()) {
            this.response.getRequest().getForest().getMemoryManager().removeCache(this.response.getRequest().getCacheKey$forest_release());
            this.provider.getContext().getReporter().reportForestConsume$forest_release(this.response, e);
        }
    }

    protected final ForestLogger getLogger() {
        return this.provider.getContext().getLogger();
    }
}
