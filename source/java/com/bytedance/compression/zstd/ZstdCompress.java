package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;

/* loaded from: classes3.dex */
public class ZstdCompress {
    public static native long compressBound(long j);

    public static native int defaultCompressionLevel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int loadDictCompress(long j, byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int loadFastDictCompress(long j, ZstdDictCompress zstdDictCompress);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setCompressionChecksums(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setCompressionLevel(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setCompressionLong(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setCompressionWorkers(long j, int i);

    static {
        Native.load();
    }

    public static byte[] compress(byte[] bArr) throws ZstdException {
        return compress(bArr, defaultCompressionLevel());
    }

    public static byte[] compress(byte[] bArr, int i) throws ZstdException {
        ZstdCompressCtx zstdCompressCtx = new ZstdCompressCtx();
        try {
            zstdCompressCtx.setLevel(i);
            return zstdCompressCtx.compress(bArr);
        } finally {
            zstdCompressCtx.close();
        }
    }

    public static int compress(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5) throws ZstdException {
        ZstdCompressCtx zstdCompressCtx = new ZstdCompressCtx();
        try {
            zstdCompressCtx.setLevel(i5);
            return zstdCompressCtx.compressByteArray(bArr, i, i2, bArr2, i3, i4);
        } finally {
            zstdCompressCtx.close();
        }
    }

    public static byte[] compress(byte[] bArr, ZstdDictCompress zstdDictCompress) throws ZstdException {
        ZstdCompressCtx zstdCompressCtx = new ZstdCompressCtx();
        try {
            zstdCompressCtx.loadDict(zstdDictCompress);
            zstdCompressCtx.setLevel(zstdDictCompress.level());
            return zstdCompressCtx.compress(bArr);
        } finally {
            zstdCompressCtx.close();
        }
    }

    public static int compress(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, ZstdDictCompress zstdDictCompress) throws ZstdException {
        ZstdCompressCtx zstdCompressCtx = new ZstdCompressCtx();
        try {
            zstdCompressCtx.loadDict(zstdDictCompress);
            zstdCompressCtx.setLevel(zstdDictCompress.level());
            return zstdCompressCtx.compressByteArray(bArr, i, i2, bArr2, i3, i4);
        } finally {
            zstdCompressCtx.close();
        }
    }

    public static byte[] compress(byte[] bArr, byte[] bArr2, int i) throws ZstdException {
        ZstdCompressCtx zstdCompressCtx = new ZstdCompressCtx();
        try {
            zstdCompressCtx.loadDict(bArr2);
            zstdCompressCtx.setLevel(i);
            return zstdCompressCtx.compress(bArr);
        } finally {
            zstdCompressCtx.close();
        }
    }
}
