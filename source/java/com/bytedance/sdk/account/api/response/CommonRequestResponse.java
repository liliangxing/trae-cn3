package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CommonRequestResponse extends UserApiResponse {
    public JSONObject data;

    public CommonRequestResponse(boolean z, int i) {
        super(z, i);
    }
}
