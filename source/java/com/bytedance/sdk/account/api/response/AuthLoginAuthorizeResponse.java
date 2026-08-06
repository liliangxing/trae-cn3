package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AuthLoginAuthorizeResponse extends BaseApiResponse {
    public String token;
    public long tokenCreateTime;
    public long tokenExpireTime;
    public String userId;
    public JSONObject userInfo;

    public AuthLoginAuthorizeResponse(boolean z) {
        super(z, ThirdPartyNetConstants.API_AUTH_LOGIN_AUTHORIZE);
    }
}
