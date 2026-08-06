package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("cronet")
/* loaded from: classes7.dex */
public class TTCompressManager {
    private static native byte[] nativeCompressData(byte[] bArr, int i, int i2, int i3);

    private static native byte[] nativeDecompressData(byte[] bArr, int i, int i2);

    /* loaded from: classes7.dex */
    public enum CompressType {
        GZIP(1),
        BROTLI(2),
        ZSTD(3);

        final int mType;

        CompressType(int i) {
            this.mType = i;
        }

        public int getValue() {
            return this.mType;
        }
    }

    public static byte[] compressData(byte[] bArr, int i, int i2, CompressType compressType) {
        return nativeCompressData(bArr, i, i2, compressType.getValue());
    }

    public static byte[] decompressData(byte[] bArr, int i, CompressType compressType) {
        return nativeDecompressData(bArr, i, compressType.getValue());
    }
}
