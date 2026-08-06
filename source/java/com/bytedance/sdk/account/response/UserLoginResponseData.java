package com.bytedance.sdk.account.response;

import com.bytedance.sdk.account.mobile.query.UserPasswordLoginQueryObj;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UserLoginResponseData extends MobileResponseData {
    public IBDAccountUserEntity mUserInfo;

    public UserLoginResponseData(UserPasswordLoginQueryObj userPasswordLoginQueryObj) {
        super(userPasswordLoginQueryObj);
        this.mUserInfo = userPasswordLoginQueryObj.mUserInfo;
    }
}
