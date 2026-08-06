package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.mobile.query.IUserQueryObj;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class GetAccountInfoResponse extends UserApiResponse implements IUserQueryObj {
    public String errorName;

    public GetAccountInfoResponse(boolean z, int i) {
        super(z, i);
    }

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return this.userInfo;
    }
}
