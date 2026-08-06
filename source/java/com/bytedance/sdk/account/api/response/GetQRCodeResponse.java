package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class GetQRCodeResponse extends BaseApiResponse {
    public String appName;
    public long expireTime;
    public JSONObject frontierParams;
    public boolean isFrontier;
    public String qrCode;
    public String qrCodeUrl;
    public String token;
    public String webName;

    public GetQRCodeResponse(boolean z, int i) {
        super(z, i);
    }
}
