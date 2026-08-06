package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.bdinstall.util.Constants;

/* loaded from: classes3.dex */
public class InstallUrl implements Cloneable {
    private final String mUriActive;
    private final String mUriRegister;
    private String mUriVerify;

    public static InstallUrl createUriByDomain(String str) {
        return createUriByDomain(str, false);
    }

    public static InstallUrl createUriByDomain(String str, boolean z) {
        String str2 = str + "/service/2/device_register/";
        String str3 = str + "/service/2/app_alert_check/";
        if (z) {
            return new InstallUrl(str2, str3, str + Constants.PATH_VERIFY);
        }
        return new InstallUrl(str2, str3);
    }

    public InstallUrl(String str, String str2) {
        this.mUriVerify = "";
        this.mUriRegister = forceHttpsUrl(str);
        this.mUriActive = forceHttpsUrl(str2);
    }

    public InstallUrl(String str, String str2, String str3) {
        this.mUriVerify = "";
        this.mUriRegister = forceHttpsUrl(str);
        this.mUriActive = forceHttpsUrl(str2);
        this.mUriVerify = forceHttpsUrl(str3);
    }

    private String forceHttpsUrl(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        throw new IllegalArgumentException("url protocol should be https");
    }

    public String getRegisterUri() {
        return this.mUriRegister;
    }

    public String getActiveUri() {
        return this.mUriActive;
    }

    public String getVerifyUri() {
        return this.mUriVerify;
    }

    public String toString() {
        return "{r='" + this.mUriRegister + "', a='" + this.mUriActive + "', v='" + this.mUriVerify + "'}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallUrl)) {
            return false;
        }
        InstallUrl installUrl = (InstallUrl) obj;
        return TextUtils.equals(this.mUriActive, installUrl.mUriActive) && TextUtils.equals(this.mUriRegister, installUrl.mUriRegister) && TextUtils.equals(this.mUriVerify, installUrl.mUriVerify);
    }
}
