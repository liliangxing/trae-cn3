package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.ThirdTokenResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class UpdateAuthorizeInfoResponse extends ThirdTokenResponse {
    public String extra;

    public UpdateAuthorizeInfoResponse(boolean z, String str, int i) {
        super(z, ThirdPartyNetConstants.API_UPDATE_AUTHORIZE_INFO, str, i);
    }

    public UpdateAuthorizeInfoResponse(boolean z, String str, String str2) {
        super(z, ThirdPartyNetConstants.API_UPDATE_AUTHORIZE_INFO, str, str2);
    }

    @Override // com.bytedance.sdk.account.api.call.ThirdTokenResponse
    public void parseSuccessResponse(JSONObject jSONObject, JSONObject jSONObject2) {
        super.parseSuccessResponse(jSONObject, jSONObject2);
        this.extra = jSONObject2.optString("extra");
    }
}
