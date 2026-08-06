package com.facebook.imagepipeline.exception;

/* loaded from: classes6.dex */
public class BDException extends IllegalStateException implements IBDException {
    private final int mErrorCode;
    private final String mErrorMessage;

    public BDException(int i, String str) {
        super(str);
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    public BDException(int i, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    @Override // com.facebook.imagepipeline.exception.IBDException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.facebook.imagepipeline.exception.IBDException
    public String getErrorMessage() {
        return this.mErrorMessage;
    }
}
