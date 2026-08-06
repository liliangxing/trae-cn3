package com.bytedance.sdk.account.mobile.query;

import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class QuickLoginQueryObj extends MobileQueryObj implements IUserQueryObj {
    public Integer mAuthOpposite;
    public String mCaptcha;
    public String mCode;
    public String mMobile;
    public IBDAccountUserEntity mUserInfo;

    public QuickLoginQueryObj(String str, String str2, Integer num, String str3) {
        super(24);
        this.mMobile = str;
        this.mCode = str2;
        this.mAuthOpposite = num;
        this.mCaptcha = str3;
    }

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return this.mUserInfo;
    }
}
