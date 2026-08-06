package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class AuthCodeAccessTokenResponse extends BaseApiResponse {
    public String accessToken;
    public long expiresIn;
    public String openId;
    public long refreshExpiresIn;
    public String refreshToken;
    public String scopes;

    public AuthCodeAccessTokenResponse(boolean z) {
        super(z, ThirdPartyNetConstants.API_AUTH_CODE_ACCESS_TOKEN);
    }

    @Override // com.bytedance.sdk.account.api.call.BaseApiResponse
    public String toString() {
        return "AuthCodeAccessTokenResponse{accessToken='" + this.accessToken + "', expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + "', refreshExpiresIn=" + this.refreshExpiresIn + ", openId='" + this.openId + "', scopes='" + this.scopes + "'}";
    }
}
