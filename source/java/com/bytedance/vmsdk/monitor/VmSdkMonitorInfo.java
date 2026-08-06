package com.bytedance.vmsdk.monitor;

import android.content.Context;

/* loaded from: classes6.dex */
public class VmSdkMonitorInfo {
    private String appVersion;
    private String channel;
    private Context context;
    private String deviceId;
    private String hostAid;
    private boolean oversea;
    private String updateVersionCode;

    public VmSdkMonitorInfo(String str, String str2, String str3, String str4, String str5) {
        this.deviceId = str;
        this.channel = str2;
        this.hostAid = str3;
        this.appVersion = str4;
        this.updateVersionCode = str5;
    }

    public VmSdkMonitorInfo(String str, String str2, String str3, String str4, String str5, Context context, boolean z) {
        this.deviceId = str;
        this.channel = str2;
        this.hostAid = str3;
        this.appVersion = str4;
        this.updateVersionCode = str5;
        this.context = context;
        this.oversea = z;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getHostAid() {
        return this.hostAid;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isOversea() {
        return this.oversea;
    }
}
