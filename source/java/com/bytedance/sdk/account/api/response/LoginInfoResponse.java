package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.user.LoginInfoEntity;
import java.util.Map;

/* loaded from: classes5.dex */
public class LoginInfoResponse extends BaseApiResponse {
    public Map<Integer, LoginInfoEntity> loginInfoEntityMap;

    public LoginInfoResponse(boolean z, int i) {
        super(z, i);
    }

    @Override // com.bytedance.sdk.account.api.call.BaseApiResponse
    public String toString() {
        return "LoginInfoResponse{loginInfoEntityMap=" + this.loginInfoEntityMap + ", success=" + this.success + ", error=" + this.error + ", errorMsg='" + this.errorMsg + "'}";
    }
}
