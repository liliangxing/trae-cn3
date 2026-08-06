package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class GetLoginDevicesResponse extends BaseApiResponse {
    public JSONObject rawData;

    public GetLoginDevicesResponse(boolean z, int i) {
        super(z, i);
    }
}
