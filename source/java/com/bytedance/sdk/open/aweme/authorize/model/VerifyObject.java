package com.bytedance.sdk.open.aweme.authorize.model;

import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class VerifyObject {

    @SerializedName(IDouYin2Service.Extra.VERIFY_OPENID)
    public String verifyOpenId;

    @SerializedName(IDouYin2Service.Extra.VERIFY_SCOPE)
    public String verifyScope;

    @SerializedName(IDouYin2Service.Extra.VERIFY_TIC)
    public String verifyTic;

    public VerifyObject(String str, String str2, String str3) {
        this.verifyScope = str;
        this.verifyTic = str2;
        this.verifyOpenId = str3;
    }
}
