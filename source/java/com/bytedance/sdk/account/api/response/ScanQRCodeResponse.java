package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class ScanQRCodeResponse extends BaseApiResponse {
    public String confirmedUrl;
    public String csrfToken;
    public String desc;
    public long expireTime;
    public String extra;
    public String query;
    public String sourceIcon;
    public String title;

    public ScanQRCodeResponse(boolean z, int i) {
        super(z, i);
    }
}
