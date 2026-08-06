package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class EmailChangeBindResponse extends BaseApiResponse {
    private String email;

    public EmailChangeBindResponse(boolean z, int i) {
        super(z, i);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }
}
