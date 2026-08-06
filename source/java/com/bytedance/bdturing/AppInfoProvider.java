package com.bytedance.bdturing;

/* loaded from: classes3.dex */
public abstract class AppInfoProvider {
    public abstract String getDeviceId();

    public abstract String getInstallId();

    public abstract String getOpenUDid();

    public String getSessionId() {
        return "";
    }
}
