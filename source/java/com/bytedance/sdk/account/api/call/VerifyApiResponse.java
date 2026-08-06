package com.bytedance.sdk.account.api.call;

/* loaded from: classes5.dex */
public class VerifyApiResponse extends BaseApiResponse {
    private boolean isVerified;

    public VerifyApiResponse(boolean z, int i) {
        super(z, i);
        this.isVerified = false;
    }

    public boolean isVerified() {
        return this.isVerified;
    }

    public void setVerified(boolean z) {
        this.isVerified = z;
    }
}
