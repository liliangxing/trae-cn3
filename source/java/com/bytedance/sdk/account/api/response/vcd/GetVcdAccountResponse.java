package com.bytedance.sdk.account.api.response.vcd;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class GetVcdAccountResponse extends BaseApiResponse {
    public String mIsCurrentUser;
    public IBDAccountUserEntity userInfo;

    public GetVcdAccountResponse(boolean z, int i) {
        super(z, i);
    }
}
