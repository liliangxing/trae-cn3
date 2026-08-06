package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class TokenLogInfoBean implements Serializable {

    @SerializedName("group_id")
    private String mGroupId;

    @SerializedName("group_type")
    private String mGroupType;

    @SerializedName("item_id")
    private String mItemId;

    @SerializedName("log_pb")
    private JsonObject mLogPb;

    @SerializedName("share_user_id")
    private String mShareUserId;

    @SerializedName("tma_share")
    private String mTmaShare;

    @SerializedName("user_id")
    private String mUserId;

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public void setItemId(String str) {
        this.mItemId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getShareUserId() {
        return this.mShareUserId;
    }

    public void setShareUserId(String str) {
        this.mShareUserId = str;
    }

    public String getGroupType() {
        return this.mGroupType;
    }

    public void setGroupType(String str) {
        this.mGroupType = str;
    }

    public JsonObject getLogPb() {
        return this.mLogPb;
    }

    public void setLogPb(JsonObject jsonObject) {
        this.mLogPb = jsonObject;
    }

    public String getTmaShare() {
        return this.mTmaShare;
    }

    public void setTmaShare(String str) {
        this.mTmaShare = str;
    }
}
