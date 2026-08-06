package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class OpenTokenInfoResponse extends BaseApiResponse {
    public String clientKey;
    public String openId;
    public ArrayList<String> scopes;

    public OpenTokenInfoResponse(boolean z) {
        super(z, ThirdPartyNetConstants.API_OPEN_TOKEN_INFO);
    }
}
