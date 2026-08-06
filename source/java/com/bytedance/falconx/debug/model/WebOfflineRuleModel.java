package com.bytedance.falconx.debug.model;

import android.net.Uri;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class WebOfflineRuleModel {
    private String accessKey;
    private String appVersion;
    private List<Uri> cacheDir;
    private List<Pattern> cachePrefix;
    private String deviceId;
    private String host;
    private boolean isNeedServerMonitor;
    private String region;

    public WebOfflineRuleModel() {
    }

    public WebOfflineRuleModel(String str, List<Pattern> list, List<Uri> list2, String str2, boolean z, String str3, String str4, String str5) {
        this.accessKey = str;
        this.cachePrefix = list;
        this.cacheDir = list2;
        this.deviceId = str2;
        this.isNeedServerMonitor = z;
        this.appVersion = str3;
        this.host = str4;
        this.region = str5;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public List<Pattern> getCachePrefix() {
        return this.cachePrefix;
    }

    public void setCachePrefix(List<Pattern> list) {
        this.cachePrefix = list;
    }

    public List<Uri> getCacheDir() {
        return this.cacheDir;
    }

    public void setCacheDir(List<Uri> list) {
        this.cacheDir = list;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public boolean isNeedServerMonitor() {
        return this.isNeedServerMonitor;
    }

    public void setNeedServerMonitor(boolean z) {
        this.isNeedServerMonitor = z;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        this.region = str;
    }
}
