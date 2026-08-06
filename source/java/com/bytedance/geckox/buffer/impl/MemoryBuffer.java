package com.bytedance.geckox.buffer.impl;

import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.LibLoader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0004J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0003H\u0082 J!\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0003H\u0082 J1\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082 J\u0019\u0010\u001a\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0082 J1\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082 J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\"\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MemoryBuffer;", "Lcom/bytedance/geckox/buffer/Buffer;", "mLength", "", "swap", "Ljava/io/File;", "(JLjava/io/File;)V", "mCursor", "mReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "nPtr", "finalize", "", "length", "nCreate", "path", "", "nFlush", "ptr", "nRead", "cursor", "bytes", "", "off", "", "len", "nRelease", "nWrite", "offset", "persistence", "position", "read", "release", "skip", "write", "b", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MemoryBuffer implements Buffer {
    private long mCursor;
    private final long mLength;
    private final AtomicBoolean mReleased;
    private long nPtr;
    private final File swap;

    private final native long nCreate(String path, long length) throws IOException;

    private final native void nFlush(long ptr, String path, long length) throws IOException;

    private final native void nRead(long ptr, long cursor, byte[] bytes, int off, int len);

    private final native void nRelease(long nPtr, long length);

    private final native void nWrite(long ptr, long offset, byte[] bytes, int off, int len);

    public MemoryBuffer(long j, File file) {
        Intrinsics.checkParameterIsNotNull(file, "swap");
        this.mLength = j;
        this.swap = file;
        this.mReleased = new AtomicBoolean(false);
        if (j < 0) {
            throw new IOException("length < 0, " + j);
        }
        file.getParentFile().mkdirs();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "swap.absolutePath");
        this.nPtr = nCreate(absolutePath, j);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void finish() {
        Buffer.DefaultImpls.finish(this);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void releaseAndDeleteSwap() {
        Buffer.DefaultImpls.releaseAndDeleteSwap(this);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void persistence() throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        long j = this.nPtr;
        String absolutePath = this.swap.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "swap.absolutePath");
        nFlush(j, absolutePath, this.mLength);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    /* renamed from: length, reason: from getter */
    public long getMLength() {
        return this.mLength;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void write(byte[] bytes) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        write(bytes, 0, bytes.length);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public synchronized long skip(long skip) throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        if (skip <= 0) {
            return 0L;
        }
        long j = this.mCursor;
        long j2 = skip + j;
        this.mCursor = j2;
        if (j2 < 0) {
            this.mCursor = 0L;
        } else {
            long j3 = this.mLength;
            if (j2 > j3) {
                this.mCursor = j3;
            }
        }
        return this.mCursor - j;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int write(byte[] bytes, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        if (bytes.length == 0 || len < 1 || off < 0 || off >= bytes.length) {
            return 0;
        }
        if (off + len > bytes.length) {
            len = bytes.length - off;
        }
        synchronized (this) {
            long j = this.mCursor;
            long j2 = this.mLength;
            if (j == j2) {
                return 0;
            }
            if (len + j > j2) {
                len = (int) (j2 - j);
            }
            nWrite(this.nPtr, j, bytes, off, len);
            this.mCursor += len;
            Unit unit = Unit.INSTANCE;
            return len;
        }
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public long position() throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        return this.mCursor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r4 > r0) goto L6;
     */
    @Override // com.bytedance.geckox.buffer.Buffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void position(long position) throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        long j = 0;
        if (position >= 0) {
            j = this.mLength;
        }
        position = j;
        this.mCursor = position;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int read(byte[] bytes) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return read(bytes, 0, bytes.length);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int read(byte[] bytes, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        if (len < 1 || off < 0 || off >= bytes.length) {
            return 0;
        }
        if (off + len > bytes.length) {
            len = bytes.length - off;
        }
        synchronized (this) {
            long j = this.mCursor;
            long j2 = this.mLength;
            if (j == j2) {
                return -1;
            }
            if (len + j > j2) {
                len = (int) (j2 - j);
            }
            nRead(this.nPtr, j, bytes, off, len);
            this.mCursor += len;
            return len;
        }
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void release() {
        if (this.mReleased.getAndSet(true)) {
            return;
        }
        nRelease(this.nPtr, this.mLength);
        this.nPtr = 0L;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    /* renamed from: swap, reason: from getter */
    public File getSwap() {
        return this.swap;
    }

    protected final void finalize() {
        try {
            release();
        } catch (Exception e) {
            GeckoLogger.m303w("finalize:", e);
        }
    }

    static {
        LibLoader.INSTANCE.loadLib("buffer");
    }
}
