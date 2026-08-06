package com.bytedance.apm.entity;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class LocalVersionInfo {
    public String appVersion;
    public long id;
    public String manifestVersionCode;
    public String updateVersionCode;
    public String versionCode;
    public String versionName;

    public LocalVersionInfo(long j, String str, String str2, String str3, String str4, String str5) {
        this.id = j;
        this.versionCode = str;
        this.versionName = str2;
        this.manifestVersionCode = str3;
        this.updateVersionCode = str4;
        this.appVersion = str5;
    }

    public LocalVersionInfo(String str, String str2, String str3, String str4, String str5) {
        this.versionCode = str;
        this.versionName = str2;
        this.manifestVersionCode = str3;
        this.updateVersionCode = str4;
        this.appVersion = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalVersionInfo localVersionInfo = (LocalVersionInfo) obj;
        return TextUtils.equals(this.versionCode, localVersionInfo.versionCode) && TextUtils.equals(this.versionName, localVersionInfo.versionName) && TextUtils.equals(this.manifestVersionCode, localVersionInfo.manifestVersionCode) && TextUtils.equals(this.updateVersionCode, localVersionInfo.updateVersionCode) && TextUtils.equals(this.appVersion, localVersionInfo.appVersion);
    }

    public int hashCode() {
        return hashCode(this.versionCode) + hashCode(this.versionName) + hashCode(this.manifestVersionCode) + hashCode(this.updateVersionCode) + hashCode(this.appVersion);
    }

    private static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
