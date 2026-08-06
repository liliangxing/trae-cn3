package com.bytedance.applog.monitor.p006v3;

import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SentryConfig {
    private boolean enabled;
    private Map<String, Integer> eventsMap;
    private int launchSamplingRate;

    private SentryConfig(Builder builder) {
        this.enabled = false;
        this.launchSamplingRate = 0;
        setEnabled(builder.enabled);
        this.launchSamplingRate = builder.launchSamplingRate;
        this.eventsMap = builder.eventsMap;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        private boolean enabled;
        private Map<String, Integer> eventsMap;
        private int launchSamplingRate;

        public Builder enabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public Builder launchSamplingRate(int i) {
            this.launchSamplingRate = i;
            return this;
        }

        public Builder eventsMap(Map<String, Integer> map) {
            this.eventsMap = map;
            return this;
        }

        public SentryConfig build() {
            return new SentryConfig(this);
        }
    }
}
