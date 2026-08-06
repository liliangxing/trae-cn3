package com.bytedance.sdk.account.api.response.vcd;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class GetVcdAuthAccountResponse extends BaseApiResponse {
    public IBDAccountUserEntity mCanSwitchUserInfo;
    public String mCurrentLoginWay;
    public IBDAccountUserEntity mCurrentUserInfo;

    public GetVcdAuthAccountResponse(boolean z, int i) {
        super(z, i);
    }
}
