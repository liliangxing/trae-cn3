package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class LocalProxyConfiguration {
    public String localProxyIp;
    public String localProxyPassword;
    public int localProxyPort;
    public LocalProxyType localProxyType;
    public String localProxyUsername;

    public LocalProxyConfiguration(LocalProxyType localProxyType, String localProxyIp, int localProxyPort, String localProxyUsername, String localProxyPassword) {
        this.localProxyType = localProxyType;
        this.localProxyIp = localProxyIp;
        this.localProxyPort = localProxyPort;
        this.localProxyUsername = localProxyUsername;
        this.localProxyPassword = localProxyPassword;
    }
}
