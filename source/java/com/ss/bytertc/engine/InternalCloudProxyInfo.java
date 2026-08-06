package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.CloudProxyInfo;

/* loaded from: classes7.dex */
public class InternalCloudProxyInfo {
    public String cloudProxyIp;
    public int cloudProxyPort;

    public InternalCloudProxyInfo(String cloudProxyIp, int cloudProxyPort) {
        this.cloudProxyIp = cloudProxyIp;
        this.cloudProxyPort = cloudProxyPort;
    }

    public InternalCloudProxyInfo(CloudProxyInfo info) {
        this.cloudProxyIp = info.cloudProxyIp;
        this.cloudProxyPort = info.cloudProxyPort;
    }

    public String getCloudProxyIp() {
        String str = this.cloudProxyIp;
        return str == null ? "" : str;
    }

    public int getCloudProxyPort() {
        return this.cloudProxyPort;
    }
}
