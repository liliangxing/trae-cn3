package com.bytedance.crash.monitor;

/* loaded from: classes3.dex */
public class AppVersionModel {
    private long manifestVersionCode;
    private long updateVersionCode;
    private long versionCode;
    private String versionName;

    public AppVersionModel(long j, long j2, long j3, String str) {
        this.versionCode = j;
        this.manifestVersionCode = j3;
        this.versionName = str;
        this.updateVersionCode = j2;
    }

    public long getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public long getVersionCode() {
        return this.versionCode;
    }

    public long getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }
}
