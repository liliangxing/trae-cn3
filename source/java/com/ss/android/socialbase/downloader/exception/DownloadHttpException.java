package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes7.dex */
public class DownloadHttpException extends BaseException {
    private final int httpStatusCode;

    public DownloadHttpException(int i, int i2, String str) {
        super(i, str);
        this.httpStatusCode = i2;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
