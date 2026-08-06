package com.bytedance.applog;

/* loaded from: classes3.dex */
public interface ILogCompressor {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;

    CompressResult compress(byte[] bArr);
}
