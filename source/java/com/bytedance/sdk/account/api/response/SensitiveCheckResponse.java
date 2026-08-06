package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SensitiveCheckResponse extends BaseApiResponse {
    public JSONObject rawData;
    public Map<String, JSONObject> sensitiveInfos;

    public SensitiveCheckResponse(boolean z) {
        super(z, 30004);
    }
}
