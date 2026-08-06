package com.bytedance.applog.monitor.p006v3;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorV3AppLogConfig {
    private final String appId;
    private final String appName;
    private final String cdid;
    private final String channel;
    private final boolean devtoolsEnabled;
    private final boolean frequencyControlEnabled;
    private final boolean logEnabled;
    private final boolean logEventFilterEnabled;
    private final String logSdkVersion;
    private final boolean touristMode;
    private final long updateVersionCode;
    private final String version;

    private MonitorV3AppLogConfig(Builder builder) {
        this.appId = builder.appId;
        this.channel = builder.channel;
        this.version = builder.version;
        this.appName = builder.appName;
        this.updateVersionCode = builder.updateVersionCode;
        this.logEnabled = builder.logEnabled;
        this.touristMode = builder.touristMode;
        this.frequencyControlEnabled = builder.frequencyControlEnabled;
        this.logEventFilterEnabled = builder.logEventFilterEnabled;
        this.logSdkVersion = builder.logSdkVersion;
        this.cdid = builder.cdid;
        this.devtoolsEnabled = builder.devtoolsEnabled;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getVersion() {
        return this.version;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public boolean isLogEnabled() {
        return this.logEnabled;
    }

    public boolean isTouristMode() {
        return this.touristMode;
    }

    public boolean isFrequencyControlEnabled() {
        return this.frequencyControlEnabled;
    }

    public boolean isLogEventFilterEnabled() {
        return this.logEventFilterEnabled;
    }

    public String getLogSdkVersion() {
        return this.logSdkVersion;
    }

    public String getCdid() {
        return this.cdid;
    }

    public boolean isDevtoolsEnabled() {
        return this.devtoolsEnabled;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        private String appId;
        private String appName;
        private String cdid;
        private String channel;
        private boolean devtoolsEnabled;
        private boolean frequencyControlEnabled;
        private boolean logEnabled;
        private boolean logEventFilterEnabled;
        private String logSdkVersion;
        private boolean touristMode;
        private long updateVersionCode;
        private String version;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder channel(String str) {
            this.channel = str;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public Builder updateVersionCode(long j) {
            this.updateVersionCode = j;
            return this;
        }

        public Builder logEnabled(boolean z) {
            this.logEnabled = z;
            return this;
        }

        public Builder touristMode(boolean z) {
            this.touristMode = z;
            return this;
        }

        public Builder frequencyControlEnabled(boolean z) {
            this.frequencyControlEnabled = z;
            return this;
        }

        public Builder logEventFilterEnabled(boolean z) {
            this.logEventFilterEnabled = z;
            return this;
        }

        public Builder logSdkVersion(String str) {
            this.logSdkVersion = str;
            return this;
        }

        public Builder cdid(String str) {
            this.cdid = str;
            return this;
        }

        public Builder devtoolsEnabled(boolean z) {
            this.devtoolsEnabled = z;
            return this;
        }

        public MonitorV3AppLogConfig build() {
            return new MonitorV3AppLogConfig(this);
        }
    }
}
