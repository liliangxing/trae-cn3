package com.bytedance.geckox.buffer.stream;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import com.bytedance.geckox.buffer.Buffer;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/geckox/buffer/stream/BufferInputStream;", "Ljava/io/InputStream;", "mBuffer", "Lcom/bytedance/geckox/buffer/Buffer;", "(Lcom/bytedance/geckox/buffer/Buffer;)V", "mark", "", "available", "", "close", "", "readlimit", "markSupported", "", SettingV2Monitor.REPORT_TYPE_READ, "b", "", "off", "len", "reset", "skip", AirActionConstant.ActionId.ACTION_ID_NAME, "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class BufferInputStream extends InputStream {
    private final Buffer mBuffer;
    private long mark;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public BufferInputStream(Buffer mBuffer) {
        Intrinsics.checkParameterIsNotNull(mBuffer, "mBuffer");
        this.mBuffer = mBuffer;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        return this.mBuffer.read(b);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        return this.mBuffer.read(b, off, len);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return this.mBuffer.skip(n);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long length = this.mBuffer.length() - this.mBuffer.position();
        if (length > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) length;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.mark = readlimit;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.mBuffer.position(this.mark);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.mBuffer.read();
    }
}
