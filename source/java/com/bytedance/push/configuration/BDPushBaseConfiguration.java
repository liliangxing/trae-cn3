package com.bytedance.push.configuration;

import com.bytedance.push.AppInfo;

/* loaded from: classes4.dex */
public class BDPushBaseConfiguration {
    private AppInfo mAppInfo;
    private String mHost;
    private boolean mIsI18n;

    public BDPushBaseConfiguration(AppInfo appInfo, String str, boolean z) {
        this.mAppInfo = appInfo;
        this.mHost = str;
        this.mIsI18n = z;
    }

    public boolean isI18n() {
        return this.mIsI18n;
    }

    public BDPushBaseConfiguration setI18n(boolean z) {
        this.mIsI18n = z;
        return this;
    }

    public AppInfo getAppInfo() {
        return this.mAppInfo;
    }

    public BDPushBaseConfiguration setAppInfo(AppInfo appInfo) {
        this.mAppInfo = appInfo;
        return this;
    }

    public String getHost() {
        return this.mHost;
    }

    public BDPushBaseConfiguration setHost(String str) {
        this.mHost = str;
        return this;
    }
}
