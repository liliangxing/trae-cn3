package com.bytedance.gkfs.io;

import kotlin.Metadata;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSError;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NO_ERROR", "TINY_FILE", "CDC_ERROR", "CDC_NO_CHUNK", "HEADER_WRITE_ERROR", "CHUNK_WRITE_ERROR", "TAIL_WRITE_ERROR", "SOURCE_FILE_NOT_EXISTS", "MAJOR_FILE_ERROR", "MAJOR_FILE_RENAME_FAILED", "STORE_GENERIC_ERROR", "HEADER_READ_ERROR", "CHUNK_CONTENT_READ_ERROR", "TAIL_READ_ERROR", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public enum GkFSError {
    NO_ERROR(-1),
    TINY_FILE(0),
    CDC_ERROR(1),
    CDC_NO_CHUNK(2),
    HEADER_WRITE_ERROR(100),
    CHUNK_WRITE_ERROR(101),
    TAIL_WRITE_ERROR(102),
    SOURCE_FILE_NOT_EXISTS(103),
    MAJOR_FILE_ERROR(104),
    MAJOR_FILE_RENAME_FAILED(105),
    STORE_GENERIC_ERROR(106),
    HEADER_READ_ERROR(1001),
    CHUNK_CONTENT_READ_ERROR(1002),
    TAIL_READ_ERROR(1003);

    private final int code;

    GkFSError(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
