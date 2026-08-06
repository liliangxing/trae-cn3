package com.lynx.tasm;

/* loaded from: classes6.dex */
public final class TemplateBundleOption {
    private int mContextPoolSize;
    private boolean mEnableContextAutoRefill;
    private final String mUrl;

    private TemplateBundleOption(int i, boolean z, String str) {
        this.mContextPoolSize = i;
        this.mEnableContextAutoRefill = z;
        this.mUrl = str;
    }

    public int getContextPoolSize() {
        return this.mContextPoolSize;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean getEnableContextAutoRefill() {
        return this.mEnableContextAutoRefill;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private int mContextPoolSize = 0;
        private boolean mEnableContextAutoRefill = false;
        private String mUrl;

        public Builder setContextPoolSize(int i) {
            this.mContextPoolSize = i;
            return this;
        }

        public Builder setEnableContextAutoRefill(boolean z) {
            this.mEnableContextAutoRefill = z;
            return this;
        }

        public Builder setUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public TemplateBundleOption build() {
            return new TemplateBundleOption(this.mContextPoolSize, this.mEnableContextAutoRefill, this.mUrl);
        }
    }
}
