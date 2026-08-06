package com.bytedance.fresco.cloudcontrol;

import android.content.Context;

/* loaded from: classes2.dex */
public final class InitConfig {
    public static final int BOE = 4;
    public static final int CHINA = 1;
    public static final int SINGAPORE = 2;
    public static final int US_EAST = 3;
    final String aid;
    final String appName;
    final String channel;
    final Context context;
    final String deviceId;
    private boolean enableAddRequestHeader;
    final int uriConfig;
    final String versionCode;
    final String versionName;

    public InitConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this(context, str, str2, str3, str4, str5, str6, i, false);
    }

    public InitConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.context = context;
        this.aid = str;
        this.appName = str2;
        this.channel = str3;
        this.versionName = str4;
        this.versionCode = str5;
        this.deviceId = str6;
        this.uriConfig = i;
        this.enableAddRequestHeader = z;
    }

    public Context getContext() {
        return this.context;
    }

    public String getAid() {
        return this.aid;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getUriConfig() {
        return this.uriConfig;
    }

    public boolean isEnableAddRequestHeader() {
        return this.enableAddRequestHeader;
    }
}
