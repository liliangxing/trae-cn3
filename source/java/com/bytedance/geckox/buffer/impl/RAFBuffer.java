package com.bytedance.geckox.buffer.impl;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RAFBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/RAFBuffer;", "Lcom/bytedance/geckox/buffer/Buffer;", "mLength", "", "mSwap", "Ljava/io/File;", "(JLjava/io/File;)V", "mCursor", "mRandomAccessFile", "Ljava/io/RandomAccessFile;", "mReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "length", "persistence", "", "position", SettingV2Monitor.REPORT_TYPE_READ, "", "bytes", "", "off", "len", "release", "skip", "swap", "write", "b", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class RAFBuffer implements Buffer {
    private long mCursor;
    private final long mLength;
    private RandomAccessFile mRandomAccessFile;
    private final AtomicBoolean mReleased;
    private final File mSwap;

    public RAFBuffer(long j, File mSwap) {
        Intrinsics.checkParameterIsNotNull(mSwap, "mSwap");
        this.mLength = j;
        this.mSwap = mSwap;
        this.mReleased = new AtomicBoolean(false);
        boolean mkdirs = mSwap.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(mSwap, "rw");
            randomAccessFile.setLength(j);
            this.mRandomAccessFile = randomAccessFile;
        } catch (Exception e) {
            boolean exists = this.mSwap.getParentFile().exists();
            if (e instanceof FileNotFoundException) {
                boolean mkdirs2 = this.mSwap.getParentFile().mkdirs();
                boolean exists2 = this.mSwap.getParentFile().exists();
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.mSwap, "rw");
                    randomAccessFile2.setLength(this.mLength);
                    this.mRandomAccessFile = randomAccessFile2;
                    return;
                } catch (Exception unused) {
                    CloseableUtils.close(this.mRandomAccessFile);
                    throw new IOException("create raf swap failed[2 dir mk:" + mkdirs2 + ",dir exist:+" + exists2 + ", dir mk:" + mkdirs + ",dir exist:+" + exists + "]! path: " + this.mSwap.getAbsolutePath() + " caused by: " + e.getMessage(), e);
                }
            }
            throw new IOException("create raf swap failed[1 dir mk:" + mkdirs + ",dir exist:+" + exists + "]! path: " + this.mSwap.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
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
        int skipBytes;
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        int i = (int) skip;
        if (i != skip) {
            throw new IOException("too large:" + skip);
        }
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwNpe();
        }
        skipBytes = randomAccessFile.skipBytes(i);
        RandomAccessFile randomAccessFile2 = this.mRandomAccessFile;
        if (randomAccessFile2 == null) {
            Intrinsics.throwNpe();
        }
        this.mCursor = randomAccessFile2.getFilePointer();
        return skipBytes;
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
            RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile == null) {
                Intrinsics.throwNpe();
            }
            randomAccessFile.write(bytes, off, len);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0014, code lost:
    
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
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwNpe();
        }
        randomAccessFile.seek(this.mCursor);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == 0) {
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
            RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile == null) {
                Intrinsics.throwNpe();
            }
            int read = randomAccessFile.read(bytes, off, len);
            if (read == -1) {
                return -1;
            }
            this.mCursor += read;
            return read;
        }
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void release() {
        if (this.mReleased.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.mRandomAccessFile);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    /* renamed from: swap, reason: from getter */
    public File getMSwap() {
        return this.mSwap;
    }
}
