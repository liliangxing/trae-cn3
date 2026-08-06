package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class FetchTokenResponse implements Serializable {

    @SerializedName("data")
    private JsonObject data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public JsonObject getData() {
        return this.data;
    }

    public void setData(JsonObject jsonObject) {
        this.data = jsonObject;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
