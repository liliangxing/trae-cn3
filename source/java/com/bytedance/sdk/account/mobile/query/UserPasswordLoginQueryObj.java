package com.bytedance.sdk.account.mobile.query;

import com.bytedance.sdk.account.param.UserLoginParam;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: classes5.dex */
public class UserPasswordLoginQueryObj extends MobileQueryObj implements IUserQueryObj {
    public String mAccount;
    public String mCaptcha;
    public String mEmail;
    public String mMobile;
    public String mPassword;
    public int mScene;
    public String mToken;
    public IBDAccountUserEntity mUserInfo;
    public String mUserName;

    public UserPasswordLoginQueryObj(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        super(7);
        this.mEmail = str;
        this.mCaptcha = str7;
        this.mUserName = str2;
        this.mMobile = str3;
        this.mAccount = str4;
        this.mPassword = str5;
        this.mToken = str6;
        this.mScene = i;
    }

    public UserPasswordLoginQueryObj(UserLoginParam userLoginParam) {
        super(7);
        this.mEmail = userLoginParam.email;
        this.mPassword = userLoginParam.password;
        this.mCaptcha = null;
        this.mUserName = userLoginParam.username;
        this.mMobile = userLoginParam.mobile;
        this.mAccount = userLoginParam.account;
        this.mToken = userLoginParam.token;
        this.mScene = userLoginParam.scene;
    }

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return this.mUserInfo;
    }
}
