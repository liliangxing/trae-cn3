package com.bytedance.ug.sdk.share.impl.network.model;

import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class GetSignInfoResponse implements Serializable {

    @SerializedName("data")
    private SignInfo mSignInfo;

    @SerializedName(CommonConstants.KEY_ERROR_NO)
    private int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public SignInfo getSignInfo() {
        return this.mSignInfo;
    }

    public void setSignInfo(SignInfo signInfo) {
        this.mSignInfo = signInfo;
    }
}
