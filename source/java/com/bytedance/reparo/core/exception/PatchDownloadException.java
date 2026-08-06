package com.bytedance.reparo.core.exception;

/* loaded from: classes4.dex */
public class PatchDownloadException extends PatchException {
    public static final int ERROR_TYPE_MD5_NOT_MATCH = 1;
    public static final int ERROR_TYPE_UNKNOWN = 0;

    public PatchDownloadException(String str) {
        this(str, 0);
    }

    public PatchDownloadException(String str, int i) {
        super(str, i);
    }

    public PatchDownloadException(String str, Exception exc) {
        this(str, exc, 0);
    }

    public PatchDownloadException(String str, Exception exc, int i) {
        super(str, exc, i);
    }
}
