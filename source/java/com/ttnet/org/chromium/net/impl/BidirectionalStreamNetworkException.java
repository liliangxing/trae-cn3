package com.ttnet.org.chromium.net.impl;

/* loaded from: classes7.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public BidirectionalStreamNetworkException(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int i = this.mCronetInternalErrorCode;
        if (i == -358 || i == -352) {
            return true;
        }
        return super.immediatelyRetryable();
    }
}
