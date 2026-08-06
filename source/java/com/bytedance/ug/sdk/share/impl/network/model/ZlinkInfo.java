package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class ZlinkInfo {

    @SerializedName("channel")
    private String channel;

    @SerializedName("zlink_url")
    private String zlink;

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getZlink() {
        return this.zlink;
    }

    public void setZlink(String str) {
        this.zlink = str;
    }
}
