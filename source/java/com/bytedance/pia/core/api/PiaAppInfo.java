package com.bytedance.pia.core.api;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class PiaAppInfo {
    private static final Pattern versionPattern = Pattern.compile("^(\\d+(\\.\\d+){0,3})\\.*");
    public final long appID;
    public final String appName;
    public final String appVersion;
    public final String channel;
    public final String deviceID;
    public final String deviceType;
    public final boolean isDebuggable;
    public final String osVersion;
    public final long settingFrequency;
    public final String userID;
    public final List<String> whiteList;

    private PiaAppInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list, boolean z, long j, long j2) {
        this.userID = str;
        this.deviceID = str2;
        this.appName = str3;
        this.channel = str4;
        this.deviceType = str5;
        this.osVersion = str6;
        this.appVersion = str7;
        this.appID = j;
        this.settingFrequency = j2;
        this.isDebuggable = z;
        this.whiteList = list;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private List<String> whiteList;
        private long appID = 0;
        private long settingFrequency = -1;
        private String userID = "";
        private String deviceID = "";
        private String appName = "";
        private String channel = "";
        private String deviceType = Build.PRODUCT;
        private String osVersion = Build.VERSION.RELEASE;
        private String appVersion = "";
        private boolean isDebuggable = false;

        public Builder setWhiteList(List<String> list) {
            this.whiteList = list;
            return this;
        }

        public Builder setDebuggable(boolean z) {
            this.isDebuggable = z;
            return this;
        }

        public Builder setAppID(long j) {
            this.appID = j;
            return this;
        }

        public Builder setUserID(String str) {
            this.userID = str;
            return this;
        }

        public Builder setDeviceID(String str) {
            this.deviceID = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setDeviceType(String str) {
            this.deviceType = str;
            return this;
        }

        public Builder setOsVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setSettingFrequency(long j) {
            this.settingFrequency = j;
            return this;
        }

        public PiaAppInfo build() {
            if (this.appID != 0 && !TextUtils.isEmpty(this.deviceID)) {
                try {
                    Matcher matcher = PiaAppInfo.versionPattern.matcher(this.appVersion);
                    if (!matcher.find() || matcher.group(0) == null) {
                        return null;
                    }
                    this.appVersion = matcher.group(0);
                    if (this.settingFrequency <= 0) {
                        this.settingFrequency = -1L;
                    }
                    Matcher matcher2 = PiaAppInfo.versionPattern.matcher(this.osVersion);
                    if (matcher2.find() && matcher2.group(0) != null) {
                        this.osVersion = matcher2.group(0);
                    }
                    return new PiaAppInfo(this.userID, this.deviceID, this.appName, this.channel, this.deviceType, this.osVersion, this.appVersion, this.whiteList, this.isDebuggable, this.appID, this.settingFrequency);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }
}
