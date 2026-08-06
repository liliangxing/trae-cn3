package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.ThirdTokenResponse;

/* loaded from: classes5.dex */
public class GetOauthTokenResponse extends ThirdTokenResponse {
    public int bindStatus;
    public String oauthTokenResult;
    public String oauthTokenVersion;
    public String tokenInfoResult;
    public int tokenValid;

    public GetOauthTokenResponse(boolean z, String str, int i) {
        super(z, ThirdPartyNetConstants.API_GET_OAUTH_TOKEN, str, i);
        this.bindStatus = -1;
        this.tokenValid = -1;
    }

    public GetOauthTokenResponse(boolean z, String str, String str2) {
        super(z, ThirdPartyNetConstants.API_GET_OAUTH_TOKEN, str, str2);
        this.bindStatus = -1;
        this.tokenValid = -1;
    }
}
