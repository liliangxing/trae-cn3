package com.bytedance.sdk.account.mobile.query;

import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.Map;

/* loaded from: classes5.dex */
public class QuickLoginContinueQueryObj extends MobileQueryObj implements IUserQueryObj {
    public Map mExtendInfo;
    public String mMobile;
    public String mSmsCodekey;
    public IBDAccountUserEntity mUserInfo;
    public int mVcdAuth;

    public QuickLoginContinueQueryObj(String str, String str2) {
        super(24);
        this.mMobile = str;
        this.mSmsCodekey = str2;
    }

    public QuickLoginContinueQueryObj(String str, String str2, int i, Map map) {
        super(24);
        this.mMobile = str;
        this.mSmsCodekey = str2;
        this.mVcdAuth = i;
        this.mExtendInfo = map;
    }

    @Override // com.bytedance.sdk.account.mobile.query.IUserQueryObj
    public IBDAccountUserEntity getUserInfo() {
        return this.mUserInfo;
    }
}
