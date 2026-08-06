package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.mobile.query.IUserQueryObj;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class LoginByTicketResponse extends BaseApiResponse implements IUserQueryObj {
    public long mCancelApplyTime;
    public String mCancelAvatarUrl;
    public String mCancelNickName;
    public long mCancelTime;
    public String mCancelToken;
    public String mErrorCaptcha;
    public String mSmsCodeKey;
    public IBDAccountUserEntity mUserInfo;
    public JSONObject rawData;

    public LoginByTicketResponse(boolean z, int i) {
        super(z, i);
    }

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return this.mUserInfo;
    }
}
