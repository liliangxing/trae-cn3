package com.bytedance.sdk.account.api.call;

/* loaded from: classes5.dex */
public class LogoutApiResponse extends BaseApiResponse {
    public String mLogoutScene;
    protected String mSessionKey;

    public LogoutApiResponse(boolean z, int i) {
        super(z, i);
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public void setSessionKey(String str) {
        this.mSessionKey = str;
    }
}
