package com.bytedance.news.common.settings;

/* loaded from: classes4.dex */
public class SettingsLazyConfig {
    private Extras extras;

    private SettingsLazyConfig(Extras extras) {
        this.extras = extras;
    }

    public String getUpdateVersionCode() {
        return this.extras.updateVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Extras {
        public String updateVersionCode;

        private Extras() {
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private String updateVersionCode;

        public Builder updateVersionCode(String str) {
            this.updateVersionCode = str;
            return this;
        }

        public SettingsLazyConfig build() {
            Extras extras = new Extras();
            extras.updateVersionCode = this.updateVersionCode;
            return new SettingsLazyConfig(extras);
        }
    }
}
