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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/FileBuffer;", "Lcom/bytedance/geckox/buffer/Buffer;", "mSwap", "Ljava/io/File;", "(Ljava/io/File;)V", "mRandomAccessFile", "Ljava/io/RandomAccessFile;", "mReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "length", "", "persistence", "", "position", SettingV2Monitor.REPORT_TYPE_READ, "", "bytes", "", "off", "len", "release", "skip", "swap", "write", "b", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class FileBuffer implements Buffer {
    private RandomAccessFile mRandomAccessFile;
    private final AtomicBoolean mReleased;
    private final File mSwap;

    public FileBuffer(File mSwap) {
        RandomAccessFile randomAccessFile;
        Intrinsics.checkParameterIsNotNull(mSwap, "mSwap");
        this.mSwap = mSwap;
        this.mReleased = new AtomicBoolean(false);
        boolean mkdirs = mSwap.getParentFile().mkdirs();
        try {
            randomAccessFile = new RandomAccessFile(mSwap, "rw");
        } catch (Exception e) {
            boolean exists = this.mSwap.getParentFile().exists();
            RandomAccessFile randomAccessFile2 = this.mRandomAccessFile;
            if (randomAccessFile2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
            }
            CloseableUtils.close(randomAccessFile2);
            if (e instanceof FileNotFoundException) {
                boolean mkdirs2 = this.mSwap.getParentFile().mkdirs();
                boolean exists2 = this.mSwap.getParentFile().exists();
                try {
                    randomAccessFile = new RandomAccessFile(this.mSwap, "rw");
                } catch (Exception unused) {
                    RandomAccessFile randomAccessFile3 = this.mRandomAccessFile;
                    if (randomAccessFile3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
                    }
                    CloseableUtils.close(randomAccessFile3);
                    throw new IOException("create raf mSwap failed![2 dir mk:" + mkdirs2 + ",dir exist:+" + exists2 + ", dir mk:" + mkdirs + ",dir exist:+" + exists + "] path: " + this.mSwap.getAbsolutePath() + " caused by: " + e.getMessage(), e);
                }
            } else {
                throw new IOException("create raf mSwap failed![1 dir mk:" + mkdirs + ",dir exist:+" + exists + "] path: " + this.mSwap.getAbsolutePath() + " caused by: " + e.getMessage(), e);
            }
        }
        this.mRandomAccessFile = randomAccessFile;
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
    public long length() throws IOException {
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
        }
        return randomAccessFile.length();
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
        if (((int) skip) != skip) {
            throw new IOException("too large:" + skip);
        }
        if (this.mRandomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
        }
        return r5.skipBytes(r1);
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
            RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
            }
            randomAccessFile.write(bytes, off, len);
        }
        return len;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public long position() throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
        }
        return randomAccessFile.getFilePointer();
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void position(long position) throws IOException {
        if (this.mReleased.get()) {
            throw new IOException("released!");
        }
        if (position < 0) {
            position = 0;
        }
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
        }
        randomAccessFile.seek(position);
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
        int read;
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
            RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
            }
            read = randomAccessFile.read(bytes, off, len);
        }
        return read;
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    public void release() {
        if (this.mReleased.getAndSet(true)) {
            return;
        }
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
        }
        CloseableUtils.close(randomAccessFile);
    }

    @Override // com.bytedance.geckox.buffer.Buffer
    /* renamed from: swap, reason: from getter */
    public File getMSwap() {
        return this.mSwap;
    }
}
