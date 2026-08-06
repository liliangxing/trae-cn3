package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ZstdCompressCtx extends AutoCloseBase {
    private long nativePtr = 0;
    private ZstdDictCompress compression_dict = null;

    private native long compressByteArray0(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] bArr);

    private native long loadCDictFast0(ZstdDictCompress zstdDictCompress);

    private native long reset0();

    private native void setChecksum0(boolean z);

    private native void setContentSize0(boolean z);

    private native void setDictID0(boolean z);

    private native void setLevel0(int i);

    private native long setPledgedSrcSize0(long j);

    @Override // com.bytedance.compression.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        Native.load();
    }

    public ZstdCompressCtx() {
        init();
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createCompressCtx failed");
        }
        storeFence();
    }

    @Override // com.bytedance.compression.zstd.AutoCloseBase
    void doClose() {
        if (this.nativePtr != 0) {
            free();
            this.nativePtr = 0L;
        }
    }

    public ZstdCompressCtx setLevel(int i) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        setLevel0(i);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setChecksum(boolean z) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        setChecksum0(z);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setWorkers(int i) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, i);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setContentSize(boolean z) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        setContentSize0(z);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setDictID(boolean z) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        setDictID0(z);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setLong(int i) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, i);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress zstdDictCompress) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        zstdDictCompress.acquireSharedLock();
        try {
            long loadCDictFast0 = loadCDictFast0(zstdDictCompress);
            if (Zstd.isError(loadCDictFast0)) {
                throw new ZstdException(loadCDictFast0);
            }
            this.compression_dict = zstdDictCompress;
            return this;
        } finally {
            zstdDictCompress.releaseSharedLock();
            releaseSharedLock();
        }
    }

    public ZstdCompressCtx loadDict(byte[] bArr) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        try {
            long loadCDict0 = loadCDict0(bArr);
            if (Zstd.isError(loadCDict0)) {
                throw new ZstdException(loadCDict0);
            }
            this.compression_dict = null;
            return this;
        } finally {
            releaseSharedLock();
        }
    }

    private void ensureOpen() {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
    }

    public void reset() {
        ensureOpen();
        long reset0 = reset0();
        if (Zstd.isError(reset0)) {
            throw new ZstdException(reset0);
        }
    }

    public void setPledgedSrcSize(long j) {
        ensureOpen();
        long pledgedSrcSize0 = setPledgedSrcSize0(j);
        if (Zstd.isError(pledgedSrcSize0)) {
            throw new ZstdException(pledgedSrcSize0);
        }
    }

    public int compressByteArray(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        try {
            long compressByteArray0 = compressByteArray0(bArr, i, i2, bArr2, i3, i4);
            if (Zstd.isError(compressByteArray0)) {
                throw new ZstdException(compressByteArray0);
            }
            if (compressByteArray0 > 2147483647L) {
                throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");
            }
            return (int) compressByteArray0;
        } finally {
            releaseSharedLock();
        }
    }

    public int compress(byte[] bArr, byte[] bArr2) {
        return compressByteArray(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public byte[] compress(byte[] bArr) {
        long compressBound = ZstdCompress.compressBound(bArr.length);
        if (compressBound > 2147483647L) {
            throw new ZstdException(Zstd.errGeneric(), "Max output size is greater than MAX_INT");
        }
        int i = (int) compressBound;
        byte[] bArr2 = new byte[i];
        return Arrays.copyOfRange(bArr2, 0, compressByteArray(bArr2, 0, i, bArr, 0, bArr.length));
    }
}
