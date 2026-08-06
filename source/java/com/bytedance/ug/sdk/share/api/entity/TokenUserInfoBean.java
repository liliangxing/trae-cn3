package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class TokenUserInfoBean implements Serializable {

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("name")
    private String mName;

    @SerializedName("source_open_url")
    private String mSourceOpenUrl;

    @SerializedName("user_id")
    private long mUserId;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public String getSourceOpenUrl() {
        return this.mSourceOpenUrl;
    }

    public void setSourceOpenUrl(String str) {
        this.mSourceOpenUrl = str;
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }
}
