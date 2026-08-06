package com.bytedance.compression.zstd;

import androidx.collection.SieveCacheKt;
import com.bytedance.compression.zstd.util.Native;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ZstdDecompressCtx extends AutoCloseBase {
    private long nativePtr = 0;
    private ZstdDictDecompress decompression_dict = null;

    private native long decompressByteArray0(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    private native void free();

    private native void init();

    private native long loadDDict0(byte[] bArr);

    private native long loadDDictFast0(ZstdDictDecompress zstdDictDecompress);

    private native long reset0();

    @Override // com.bytedance.compression.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        Native.load();
    }

    public ZstdDecompressCtx() {
        init();
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
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

    public ZstdDecompressCtx loadDict(ZstdDictDecompress zstdDictDecompress) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Decompression context is closed");
        }
        acquireSharedLock();
        zstdDictDecompress.acquireSharedLock();
        try {
            long loadDDictFast0 = loadDDictFast0(zstdDictDecompress);
            if (Zstd.isError(loadDDictFast0)) {
                throw new ZstdException(loadDDictFast0);
            }
            this.decompression_dict = zstdDictDecompress;
            return this;
        } finally {
            zstdDictDecompress.releaseSharedLock();
            releaseSharedLock();
        }
    }

    public ZstdDecompressCtx loadDict(byte[] bArr) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Compression context is closed");
        }
        acquireSharedLock();
        try {
            long loadDDict0 = loadDDict0(bArr);
            if (Zstd.isError(loadDDict0)) {
                throw new ZstdException(loadDDict0);
            }
            this.decompression_dict = null;
            return this;
        } finally {
            releaseSharedLock();
        }
    }

    public void reset() {
        ensureOpen();
        long reset0 = reset0();
        if (Zstd.isError(reset0)) {
            throw new ZstdException(reset0);
        }
    }

    private void ensureOpen() {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Decompression context is closed");
        }
    }

    public int decompressByteArray(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Decompression context is closed");
        }
        acquireSharedLock();
        try {
            long decompressByteArray0 = decompressByteArray0(bArr, i, i2, bArr2, i3, i4);
            if (Zstd.isError(decompressByteArray0)) {
                throw new ZstdException(decompressByteArray0);
            }
            if (decompressByteArray0 > SieveCacheKt.NodeLinkMask) {
                throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");
            }
            return (int) decompressByteArray0;
        } finally {
            releaseSharedLock();
        }
    }

    public int decompress(byte[] bArr, byte[] bArr2) {
        return decompressByteArray(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public byte[] decompress(byte[] bArr, int i) throws ZstdException {
        byte[] bArr2 = new byte[i];
        int decompress = decompress(bArr2, bArr);
        return decompress != i ? Arrays.copyOfRange(bArr2, 0, decompress) : bArr2;
    }
}
