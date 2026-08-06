package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;

/* loaded from: classes3.dex */
public class ZstdDictCompress extends SharedDictBase {
    private int level;
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i, int i2, int i3);

    @Override // com.bytedance.compression.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        Native.load();
    }

    public ZstdDictCompress(byte[] bArr, int i) {
        this(bArr, 0, bArr.length, i);
    }

    public ZstdDictCompress(byte[] bArr, int i, int i2, int i3) {
        this.nativePtr = 0L;
        ZstdCompress.defaultCompressionLevel();
        this.level = i3;
        if (bArr.length - i < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i, i2, i3);
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createCDict failed");
        }
        storeFence();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int level() {
        return this.level;
    }

    @Override // com.bytedance.compression.zstd.AutoCloseBase
    void doClose() {
        if (this.nativePtr != 0) {
            free();
            this.nativePtr = 0L;
        }
    }
}
