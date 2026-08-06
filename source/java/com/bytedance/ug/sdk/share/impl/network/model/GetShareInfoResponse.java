package com.bytedance.ug.sdk.share.impl.network.model;

import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class GetShareInfoResponse implements Serializable {

    @SerializedName("share_info_list")
    List<ShareInfo> mShareInfoList;

    @SerializedName("share_policy")
    private int mSharePolicy;

    @SerializedName(CommonConstants.KEY_ERROR_NO)
    private int mStatus;

    @SerializedName(CommonConstants.KEY_ERROR_TIPS)
    private String mTips;

    public List<ShareInfo> getShareInfoList() {
        return this.mShareInfoList;
    }

    public void setShareInfoList(List<ShareInfo> list) {
        this.mShareInfoList = list;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public String getTips() {
        return this.mTips;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public void setSharePolicy(int i) {
        this.mSharePolicy = i;
    }

    public int getSharePolicy() {
        return this.mSharePolicy;
    }
}
