package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class AuthorInfo implements Serializable {

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("extra")
    private JsonObject mExtra;

    @SerializedName("name")
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    public JsonObject getExtra() {
        return this.mExtra;
    }

    public void setExtra(JsonObject jsonObject) {
        this.mExtra = jsonObject;
    }
}
