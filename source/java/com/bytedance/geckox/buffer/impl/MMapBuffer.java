package com.bytedance.geckox.buffer.impl;

import com.bytedance.forest.model.Timing;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.LibLoader;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MMapBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000f\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0004J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J1\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0082 J\u0019\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J1\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0082 J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010 \u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010#\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MMapBuffer;", "Lcom/bytedance/geckox/buffer/Buffer;", "length", "", "swap", "Ljava/io/File;", "(JLjava/io/File;)V", "mCursor", "mFinished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mReleased", "ptr", "finalize", "", Timing.SUFFIX_FINISH, "nCreate", "path", "", "nFlush", "", "nRead", "cursor", "bytes", "", "off", "len", "nRelease", "nPtr", "nWrite", "offset", "persistence", "position", "read", "release", "skip", "write", "b", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MMapBuffer implements Buffer {
    private final long length;
    private long mCursor;
    private final AtomicBoolean mFinished;
    private final AtomicBoolean mReleased;
    private long ptr;
    private final File swap;

    private final native long nCreate(String path, long length) throws IOException;

    private final native int nFlush(long ptr, long length) throws IOException;

    private final native void nRead(long ptr, long cursor, byte[] bytes, int off, int len);

    private final native int nRelease(long nPtr, long length);

    private final native void nWrite(long ptr, long offset, byte[] bytes, int off, int len);

    public MMapBuffer(long j, File file) {
        Intrinsics.checkParameterIsNotNull(file, "swap");
        this.length = j;
        this.swap = file;
        this.mReleased = new AtomicBoolean(false);
        this.mFinished = new AtomicBoolean(false);
        file.getParentFile().mkdirs();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "swap.absolutePath");
        this.ptr = nCreate(absolutePath, j);
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
        nFlush(this.ptr, this.length);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    /* renamed from: length, reason: from getter */
    public long getLength() {
        return this.length;
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
            long j3 = this.length;
            if (j2 > j3) {
                this.mCursor = j3;
            }
        }
        return this.mCursor - j;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int write(byte[] bytes, int off, int len) throws IOException {
        int i = len;
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (bytes.length == 0 || i < 1 || off < 0 || off >= bytes.length) {
            return 0;
        }
        if (off + i > bytes.length) {
            i = bytes.length - off;
        }
        synchronized (this) {
            long j = this.mCursor;
            long j2 = this.length;
            if (j == j2) {
                return 0;
            }
            if (i + j > j2) {
                i = (int) (j2 - j);
            }
            int i2 = i;
            if (this.mReleased.get()) {
                String str = "MMapBuffer write after release: " + this + '-' + this.length + '-' + this.swap.getAbsolutePath();
                GeckoLogger.m300w(str);
                new EventMessageModel(EventSubType.WRITE_AFTER_RELEASE, (String) null, (String) null, str, (String) null, 0L, 54, (DefaultConstructorMarker) null).upload();
                return 0;
            }
            if (this.mFinished.get()) {
                String str2 = "MMapBuffer write after finish: " + this + '-' + this.length + '-' + this.swap.getAbsolutePath();
                GeckoLogger.m300w(str2);
                new EventMessageModel(EventSubType.WRITE_AFTER_FINISH, (String) null, (String) null, str2, (String) null, 0L, 54, (DefaultConstructorMarker) null).upload();
                return 0;
            }
            nWrite(this.ptr, this.mCursor, bytes, off, i2);
            this.mCursor += i2;
            Unit unit = Unit.INSTANCE;
            return i2;
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
            j = this.length;
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
            long j2 = this.length;
            if (j == j2) {
                return -1;
            }
            if (len + j > j2) {
                len = (int) (j2 - j);
            }
            nRead(this.ptr, j, bytes, off, len);
            this.mCursor += len;
            return len;
        }
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void release() {
        if (this.mReleased.getAndSet(true)) {
            return;
        }
        nRelease(this.ptr, this.length);
        this.ptr = 0L;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void finish() {
        this.mFinished.set(true);
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
