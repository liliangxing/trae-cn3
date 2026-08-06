package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class GetTvQRCodeResponse extends BaseApiResponse {
    public String qrcode;
    public String status;
    public String token;

    public GetTvQRCodeResponse(boolean z, int i) {
        super(z, i);
    }
}
