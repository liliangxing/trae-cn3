package com.bytedance.sdk.account.api.call;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MultiLogoutApiResponse extends LogoutApiResponse {
    public String mLogoutType;
    public int mMultiLogoutType;
    public String mToSecUid;

    public MultiLogoutApiResponse(BaseApiResponse baseApiResponse, String str, String str2) {
        super(baseApiResponse.success, 10001);
        JSONObject optJSONObject;
        copyFromBase(baseApiResponse);
        if (baseApiResponse instanceof LogoutApiResponse) {
            this.mSessionKey = ((LogoutApiResponse) baseApiResponse).mSessionKey;
        }
        this.mLogoutType = str;
        this.mLogoutScene = str2;
        if (baseApiResponse.result == null || (optJSONObject = baseApiResponse.result.optJSONObject("data")) == null) {
            return;
        }
        this.mMultiLogoutType = optJSONObject.optInt("multi_account_logout_type");
        this.mToSecUid = optJSONObject.optString("to_sec_uid");
    }
}
