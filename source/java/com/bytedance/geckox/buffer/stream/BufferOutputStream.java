package com.bytedance.geckox.buffer.stream;

import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.net.HttpRequestInfo;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferOutputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cJ&\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/geckox/buffer/stream/BufferOutputStream;", "Ljava/io/OutputStream;", "mBuffer", "Lcom/bytedance/geckox/buffer/Buffer;", "updateParams", "Lcom/bytedance/geckox/GeckoUpdateParams;", IPiaCacheProvider.CacheConfig.FIELD_META, "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "totalSize", "", "(Lcom/bytedance/geckox/buffer/Buffer;Lcom/bytedance/geckox/GeckoUpdateParams;Lcom/bytedance/iesgurd/meta/PrepareMeta;J)V", "currentSize", "httpRequestInfo", "Lcom/bytedance/geckox/net/HttpRequestInfo;", "getHttpRequestInfo", "()Lcom/bytedance/geckox/net/HttpRequestInfo;", "setHttpRequestInfo", "(Lcom/bytedance/geckox/net/HttpRequestInfo;)V", "lastCallbackTime", "close", "", "flush", "onProgress", "size", "", "position", "write", "b", "", "off", "len", "offset", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class BufferOutputStream extends OutputStream {
    private long currentSize;
    private HttpRequestInfo httpRequestInfo;
    private long lastCallbackTime;
    private Buffer mBuffer;
    private PrepareMeta meta;
    private long totalSize;
    private GeckoUpdateParams updateParams;

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
    }

    public BufferOutputStream(Buffer mBuffer, GeckoUpdateParams updateParams, PrepareMeta meta, long j) {
        Intrinsics.checkParameterIsNotNull(mBuffer, "mBuffer");
        Intrinsics.checkParameterIsNotNull(updateParams, "updateParams");
        Intrinsics.checkParameterIsNotNull(meta, "meta");
        this.mBuffer = mBuffer;
        this.updateParams = updateParams;
        this.meta = meta;
        this.totalSize = j;
    }

    public final HttpRequestInfo getHttpRequestInfo() {
        return this.httpRequestInfo;
    }

    public final void setHttpRequestInfo(HttpRequestInfo httpRequestInfo) {
        this.httpRequestInfo = httpRequestInfo;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.mBuffer.write(b);
        onProgress(4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        this.mBuffer.write(b);
        onProgress(b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        this.mBuffer.write(b, off, len);
        onProgress(len);
    }

    public final void write(long offset, int b) throws IOException {
        synchronized (this) {
            this.mBuffer.position(offset);
            this.mBuffer.write(b);
            onProgress(4);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void write(long offset, byte[] b) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        synchronized (this) {
            this.mBuffer.position(offset);
            this.mBuffer.write(b);
            onProgress(b.length);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void write(long offset, byte[] b, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        synchronized (this) {
            this.mBuffer.position(offset);
            this.mBuffer.write(b, off, len);
            onProgress(len);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    public final void position(long position) throws IOException {
        this.mBuffer.position(position);
    }

    public final long position() throws IOException {
        return this.mBuffer.position();
    }

    private final void onProgress(int size) {
        this.currentSize += size;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastCallbackTime >= 100 || this.currentSize >= this.totalSize) {
            this.lastCallbackTime = currentTimeMillis;
            this.updateParams.onUpdateProgress$geckox_noasanRelease(this.meta.getPack(), this.totalSize, this.currentSize);
        }
    }
}
