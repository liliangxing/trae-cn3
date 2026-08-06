package com.bytedance.sdk.account.information.method.oauth_profile;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class OauthProfileResponse extends BaseApiResponse {
    public String avatarUrl;
    public JSONObject extraInfo;
    public String name;

    public OauthProfileResponse(boolean z, int i) {
        super(z, i);
    }

    public String getName() {
        return this.name;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }
}
