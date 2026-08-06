package com.bytedance.compression.zstd;

/* loaded from: classes3.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public ZstdException(long j) {
        this(Zstd.getErrorCode(j), Zstd.getErrorName(j));
    }

    public ZstdException(long j, String str) {
        super(str);
        this.code = j;
    }

    public long getErrorCode() {
        return this.code;
    }
}
