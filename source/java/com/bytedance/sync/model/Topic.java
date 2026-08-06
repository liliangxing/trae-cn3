package com.bytedance.sync.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class Topic {

    @SerializedName("business")
    private final long business;

    @SerializedName("deviceid")
    private String did;

    @SerializedName("topic")
    private final String topic;

    @SerializedName("secuid")
    private String uid;

    public Topic(String str, long j) {
        this.topic = str;
        this.business = j;
    }

    public String getTopic() {
        return this.topic;
    }

    public long getBusiness() {
        return this.business;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "Topic{topic='" + this.topic + "', business=" + this.business + ", did='" + this.did + "', uid='" + this.uid + "'}";
    }
}
