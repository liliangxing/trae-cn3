package com.bytedance.geckox.model;

@Deprecated
/* loaded from: classes3.dex */
public class LocalPackageModel {
    private String accessKey;
    private String channel;
    private String channelPath;
    private long latestVersion;

    public LocalPackageModel(String str, String str2) {
        this.accessKey = str;
        this.channel = str2;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public void setLatestVersion(long j) {
        this.latestVersion = j;
    }

    public String getChannelPath() {
        return this.channelPath;
    }

    public void setChannelPath(String str) {
        this.channelPath = str;
    }
}
