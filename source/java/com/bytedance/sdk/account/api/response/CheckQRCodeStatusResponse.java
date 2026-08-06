package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class CheckQRCodeStatusResponse extends UserApiResponse {
    public String appName;
    public String extra;
    public String qrCode;
    public String qrCodeUrl;
    public String redirectUrl;
    public int scanAppId;
    public String status;
    public String token;
    public String webName;

    public CheckQRCodeStatusResponse(boolean z, int i) {
        super(z, i);
    }

    public IBDAccountUserEntity getUserInfo() {
        return this.userInfo;
    }
}
