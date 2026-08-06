package com.bytedance.sdk.account.mobile.query;

/* loaded from: classes5.dex */
public class MobileQuickAuthObj extends MobileQueryObj {
    public String mCaptcha;
    public String mCode;
    public String mMobile;
    public String mToken;

    public MobileQuickAuthObj(String str, String str2, String str3) {
        super(26);
        this.mMobile = str;
        this.mCode = str2;
        this.mCaptcha = str3;
    }

    public String getToken() {
        return this.mToken;
    }
}
