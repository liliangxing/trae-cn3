package com.bytedance.sdk.account.mobile.query;

import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class MobilePassAuthObj extends MobileQueryObj implements IUserQueryObj {
    public String mCaptcha;
    public String mMobile;
    public String mPassword;
    public String mToken;
    public IBDAccountUserEntity mUserInfo;
    public String mVerifyUserId;

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return null;
    }

    public MobilePassAuthObj(String str, String str2, String str3, String str4) {
        super(7);
        this.mMobile = str;
        this.mPassword = str2;
        this.mVerifyUserId = str3;
        this.mCaptcha = str4;
    }

    public String getToken() {
        return this.mToken;
    }
}
