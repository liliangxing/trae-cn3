package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class TokenRefluxInfo {

    @SerializedName("identifier")
    private String mId;

    @SerializedName("reflex_url")
    private String mReflexUrl;

    @SerializedName("token")
    private String mToken;

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public String getReflexUrl() {
        return this.mReflexUrl;
    }

    public void setReflexUrl(String str) {
        this.mReflexUrl = str;
    }
}
