package com.bytedance.sdk.account.api.call;

/* loaded from: classes5.dex */
public class ValidateCodeResponse extends BaseApiResponse {
    private String ticket;

    public ValidateCodeResponse(boolean z, int i) {
        super(z, i);
        this.ticket = null;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }
}
