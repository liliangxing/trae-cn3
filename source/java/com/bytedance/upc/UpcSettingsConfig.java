package com.bytedance.upc;

/* loaded from: classes.dex */
public class UpcSettingsConfig {
    private final long delayInitReceiverTime;

    private UpcSettingsConfig(Builder builder) {
        this.delayInitReceiverTime = builder.delayInitReceiverTime;
    }

    public long getDelayInitReceiverTime() {
        return this.delayInitReceiverTime;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private long delayInitReceiverTime = 0;

        public Builder setDelayInitReceiverTime(int i) {
            this.delayInitReceiverTime = i;
            return this;
        }

        public UpcSettingsConfig build() {
            return new UpcSettingsConfig(this);
        }
    }
}
