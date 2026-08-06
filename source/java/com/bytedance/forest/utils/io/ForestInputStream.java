package com.bytedance.forest.utils.io;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.InternalReporter;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ForestInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\"\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/forest/utils/io/ForestInputStream;", "Ljava/io/InputStream;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "internalBuffer", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", "(Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/model/InMemoryByteBuffer;)V", "isClosed", "", "lastRead", "", "pos", "available", EventReport.DIALOG_CLOSE, "", "onException", "e", "", "functionName", "", "read", "b", "", "off", "len", "skip", "", "n", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestInputStream extends InputStream {
    private static final int DEAL_WITH_SIGN = 255;
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;
    private static final String TAG = "ForestInputStream";
    private final InMemoryByteBuffer internalBuffer;
    private boolean isClosed;
    private int lastRead;
    private int pos;
    private final Response response;

    public ForestInputStream(Response response, InMemoryByteBuffer inMemoryByteBuffer) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(inMemoryByteBuffer, "internalBuffer");
        this.response = response;
        this.internalBuffer = inMemoryByteBuffer;
        this.lastRead = -1;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.isClosed) {
            throw new IOException("input stream closed");
        }
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        if (this.isClosed) {
            throw new IOException("input stream closed");
        }
        if (b == null) {
            throw new NullPointerException();
        }
        try {
            int bytesAtRange$forest_release = this.internalBuffer.getBytesAtRange$forest_release(this.pos, b, off, len, this.response);
            if (this.internalBuffer.isCacheClear$forest_release()) {
                this.response.getRequest().getForest().getMemoryManager().removeCache(this.response.getRequest().getCacheKey$forest_release());
            }
            if (bytesAtRange$forest_release == -1) {
                return -1;
            }
            if (bytesAtRange$forest_release == 0 && this.lastRead == 0) {
                LogUtils.e$default(LogUtils.INSTANCE, TAG, "unexpected code reached, repeating read 0 byte", null, true, null, null, null, 112, null);
                return -1;
            }
            this.lastRead = bytesAtRange$forest_release;
            this.pos += bytesAtRange$forest_release;
            return bytesAtRange$forest_release;
        } catch (Throwable th) {
            onException(th, "read");
            throw th;
        }
    }

    private final void onException(Throwable e, String functionName) {
        LogUtils.e$default(LogUtils.INSTANCE, TAG, "error happens when executing " + functionName, e, true, null, null, null, 112, null);
        if (this.internalBuffer.isCacheClear$forest_release()) {
            this.response.getRequest().getForest().getMemoryManager().removeCache(this.response.getRequest().getCacheKey$forest_release());
            this.internalBuffer.getContext().getReporter().reportForestConsume$forest_release(this.response, e);
            throw e;
        }
        throw e;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InternalReporter.reportForestConsume$forest_release$default(this.internalBuffer.getContext().getReporter(), this.response, null, 2, null);
        this.isClosed = true;
        try {
            this.internalBuffer.close();
        } catch (Throwable th) {
            onException(th, EventReport.DIALOG_CLOSE);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        if (this.isClosed) {
            throw new IOException("input stream closed");
        }
        if (n <= 0) {
            return 0L;
        }
        try {
            int coerceAtMost = (int) RangesKt.coerceAtMost(2048, n);
            byte[] bArr = new byte[coerceAtMost];
            long j = n;
            while (j > 0) {
                int read = read(bArr, 0, (int) RangesKt.coerceAtMost(coerceAtMost, j));
                if (read < 0) {
                    break;
                }
                j -= read;
            }
            return n - j;
        } catch (Throwable th) {
            onException(th, "skip");
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.isClosed) {
            throw new IOException("input stream closed");
        }
        try {
            if (this.internalBuffer.isCacheProvided$forest_release()) {
                return this.internalBuffer.size() - this.pos;
            }
            return this.internalBuffer.size();
        } catch (Throwable th) {
            onException(th, "available");
            throw th;
        }
    }
}
