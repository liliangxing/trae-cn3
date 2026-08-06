package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class EmailRegisterCodeVerifyResponse extends BaseApiResponse {
    private String emailTicket;

    public EmailRegisterCodeVerifyResponse(boolean z, int i) {
        super(z, i);
    }

    public String getEmailTicket() {
        return this.emailTicket;
    }

    public void setEmailTicket(String str) {
        this.emailTicket = str;
    }
}
