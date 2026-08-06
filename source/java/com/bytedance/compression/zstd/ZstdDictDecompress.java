package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;

/* loaded from: classes3.dex */
public class ZstdDictDecompress extends SharedDictBase {
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i, int i2);

    @Override // com.bytedance.compression.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        Native.load();
    }

    public ZstdDictDecompress(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ZstdDictDecompress(byte[] bArr, int i, int i2) {
        this.nativePtr = 0L;
        init(bArr, i, i2);
        if (this.nativePtr == 0) {
            throw new IllegalStateException("ZSTD_createDDict failed");
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
}
