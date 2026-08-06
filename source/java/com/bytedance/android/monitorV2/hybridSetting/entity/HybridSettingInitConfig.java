package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class HybridSettingInitConfig {
    private String aid;
    private String channel;
    private List<String> configUrls;
    private List<String> defaultReportUrls;
    private String deviceId;
    private String host;
    private String installId;
    private String language;
    private String os;
    private String osVersion;
    private String region;
    private IThirdConfig thirdConfig;
    private String updateVersionCode;
    private String versionCode;

    /* loaded from: classes3.dex */
    public static abstract class IThirdConfig {
        public boolean isThirdPartyUrl(String str) {
            return false;
        }
    }

    public String getAid() {
        return this.aid;
    }

    public String getHost() {
        return this.host;
    }

    public String getOs() {
        return this.os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getInstallId() {
        return this.installId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public String getRegion() {
        return this.region;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<String> getConfigUrls() {
        if (CollectionUtils.isEmpty(this.configUrls)) {
            if (isOversea()) {
                this.configUrls = Collections.singletonList(new String(Base64.decode(InternalWatcher.CONFIG_URL_OVERSEA_BASE64, 0)));
            } else {
                this.configUrls = Collections.singletonList(new String(Base64.decode(InternalWatcher.CONFIG_URL_BASE64, 0)));
            }
        }
        return this.configUrls;
    }

    public List<String> getDefaultReportUrls() {
        if (CollectionUtils.isEmpty(this.defaultReportUrls)) {
            if (isOversea()) {
                this.defaultReportUrls = Collections.singletonList(new String(Base64.decode(InternalWatcher.REPORT_URL_OVERSEA_BASE64, 0)));
            } else {
                this.defaultReportUrls = Collections.singletonList(new String(Base64.decode(InternalWatcher.REPORT_URL_BASE64, 0)));
            }
        }
        return this.defaultReportUrls;
    }

    public boolean isOversea() {
        return TextUtils.equals(getHost(), MonitorConstant.CONFIG_HOST_OVERSEA);
    }

    public IThirdConfig getThirdConfig() {
        return this.thirdConfig;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String aid;
        private String channel;
        private List<String> configUrls;
        private List<String> defaultReportUrls;
        private String deviceId;
        private String host;
        private String installId;
        private String language;
        private String region;
        private IThirdConfig thirdConfig;
        private String updateVersionCode;
        private String versionCode;

        public Builder setAid(String str) {
            this.aid = str;
            return this;
        }

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setInstallId(String str) {
            this.installId = str;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setVersionCode(String str) {
            this.versionCode = str;
            return this;
        }

        public Builder setUpdateVersionCode(String str) {
            this.updateVersionCode = str;
            return this;
        }

        public Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder setConfigUrls(List<String> list) {
            this.configUrls = list;
            return this;
        }

        public Builder setDefaultReportUrls(List<String> list) {
            this.defaultReportUrls = list;
            return this;
        }

        public Builder setThirdConfig(IThirdConfig iThirdConfig) {
            this.thirdConfig = iThirdConfig;
            return this;
        }

        public HybridSettingInitConfig build() {
            String str = this.host;
            if (str == null || "".equals(str)) {
                throw new RuntimeException("host is undefined");
            }
            HybridSettingInitConfig hybridSettingInitConfig = new HybridSettingInitConfig();
            hybridSettingInitConfig.aid = this.aid;
            hybridSettingInitConfig.host = this.host;
            hybridSettingInitConfig.os = "Android";
            hybridSettingInitConfig.osVersion = String.valueOf(Build.VERSION.RELEASE);
            hybridSettingInitConfig.installId = this.installId;
            hybridSettingInitConfig.deviceId = this.deviceId;
            hybridSettingInitConfig.channel = this.channel;
            hybridSettingInitConfig.versionCode = this.versionCode;
            hybridSettingInitConfig.updateVersionCode = this.updateVersionCode;
            hybridSettingInitConfig.region = this.region;
            hybridSettingInitConfig.language = this.language;
            hybridSettingInitConfig.configUrls = this.configUrls;
            hybridSettingInitConfig.defaultReportUrls = this.defaultReportUrls;
            hybridSettingInitConfig.thirdConfig = this.thirdConfig;
            return hybridSettingInitConfig;
        }
    }
}
