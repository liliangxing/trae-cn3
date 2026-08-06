package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ZstdDecompress {
    private static native long decompressedSize0(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int loadDictDecompress(long j, byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int loadFastDictDecompress(long j, ZstdDictDecompress zstdDictDecompress);

    static {
        Native.load();
    }

    public static byte[] decompress(byte[] bArr) throws ZstdException {
        long decompressedSize = decompressedSize(bArr);
        if (decompressedSize > 2147483647L) {
            throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
        }
        return decompress(bArr, (int) decompressedSize);
    }

    public static byte[] decompress(byte[] bArr, int i) throws ZstdException {
        ZstdDecompressCtx zstdDecompressCtx = new ZstdDecompressCtx();
        try {
            return zstdDecompressCtx.decompress(bArr, i);
        } finally {
            zstdDecompressCtx.close();
        }
    }

    public static byte[] decompress(byte[] bArr, ZstdDictDecompress zstdDictDecompress) throws ZstdException {
        long decompressedSize = decompressedSize(bArr);
        if (decompressedSize > 2147483647L) {
            throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
        }
        return decompress(bArr, zstdDictDecompress, (int) decompressedSize);
    }

    public static byte[] decompress(byte[] bArr, ZstdDictDecompress zstdDictDecompress, int i) throws ZstdException {
        ZstdDecompressCtx zstdDecompressCtx = new ZstdDecompressCtx();
        try {
            zstdDecompressCtx.loadDict(zstdDictDecompress);
            return zstdDecompressCtx.decompress(bArr, i);
        } finally {
            zstdDecompressCtx.close();
        }
    }

    public static byte[] decompress(byte[] bArr, byte[] bArr2) throws ZstdException {
        long decompressedSize = decompressedSize(bArr);
        if (decompressedSize > 2147483647L) {
            throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
        }
        return decompress(bArr, bArr2, (int) decompressedSize);
    }

    public static byte[] decompress(byte[] bArr, byte[] bArr2, int i) throws ZstdException {
        ZstdDecompressCtx zstdDecompressCtx = new ZstdDecompressCtx();
        try {
            zstdDecompressCtx.loadDict(bArr2);
            return zstdDecompressCtx.decompress(bArr, i);
        } finally {
            zstdDecompressCtx.close();
        }
    }

    public static long decompressedSize(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int i3 = i + i2;
        if (i3 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
        return decompressedSize0(bArr, i, i2);
    }

    public static long decompressedSize(byte[] bArr, int i) {
        return decompressedSize(bArr, i, bArr.length - i);
    }

    public static long decompressedSize(byte[] bArr) {
        return decompressedSize(bArr, 0);
    }
}
