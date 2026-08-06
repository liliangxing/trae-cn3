package com.bytedance.sync.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class SubscribeResponse {

    @SerializedName("data")
    private String data;

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
