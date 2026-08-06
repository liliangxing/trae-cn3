package com.bytedance.ug.sdk.share.api.depend;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareConfig {
    private IShareAppConfig mAppConfig;
    private IShareAsyncThreadConfig mAsyncThreadConfig;
    private IShareClipboardConfig mClipboardConfig;
    private IShareDownloadConfig mDownloadConfig;
    private IShareEventConfig mEventConfig;
    private IShareImageConfig mImageConfig;
    private IShareImageTokenConfig mImageTokenConfig;
    private boolean mIsBoe;
    private boolean mIsDebug;
    private boolean mIsLocalMode;
    private IShareKeyConfig mKeyConfig;
    private IShareLifecycleConfig mLifecycleConfig;
    private IShareNetworkConfig mNetworkConfig;
    private IShareNewRuleConfig mNewRuleConfig;
    private ISharePermissionConfig mPermissionConfig;
    private IShareQrScanConfig mQrScanConfig;
    private IShareSpConfig mSpConfig;
    private IShareTokenConfig mTokenConfig;
    private IShareUIConfig mUIConfig;
    private IShareVideoFrameConfig mVideoFrameConfig;
    private IShareVideoWmConfig mVideoWatermarkConfig;

    private ShareConfig() {
    }

    public IShareAppConfig getAppConfig() {
        return this.mAppConfig;
    }

    public IShareNewRuleConfig getNewRuleConfig() {
        return this.mNewRuleConfig;
    }

    public IShareDownloadConfig getDownloadConfig() {
        return this.mDownloadConfig;
    }

    public IShareEventConfig getEventConfig() {
        return this.mEventConfig;
    }

    public IShareImageConfig getImageConfig() {
        return this.mImageConfig;
    }

    public IShareKeyConfig getKeyConfig() {
        return this.mKeyConfig;
    }

    public IShareLifecycleConfig getLifecycleConfig() {
        return this.mLifecycleConfig;
    }

    public IShareNetworkConfig getNetworkConfig() {
        return this.mNetworkConfig;
    }

    public IShareAsyncThreadConfig getAsyncThreadConfig() {
        return this.mAsyncThreadConfig;
    }

    public IShareClipboardConfig getClipboardConfig() {
        return this.mClipboardConfig;
    }

    public ISharePermissionConfig getPermissionConfig() {
        return this.mPermissionConfig;
    }

    public IShareQrScanConfig getQrScanConfig() {
        return this.mQrScanConfig;
    }

    public IShareVideoWmConfig getVideoWatermarkConfig() {
        return this.mVideoWatermarkConfig;
    }

    public IShareVideoFrameConfig getVideoFrameConfig() {
        return this.mVideoFrameConfig;
    }

    public IShareImageTokenConfig getImageTokenConfig() {
        return this.mImageTokenConfig;
    }

    public IShareUIConfig getUIConfig() {
        return this.mUIConfig;
    }

    public IShareTokenConfig getTokenConfig() {
        return this.mTokenConfig;
    }

    public IShareSpConfig getSpConfig() {
        return this.mSpConfig;
    }

    public boolean isLocalMode() {
        return this.mIsLocalMode;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public boolean isBoe() {
        return this.mIsBoe;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Builder {
        private ShareConfig config = new ShareConfig();

        public Builder setAppConfig(IShareAppConfig iShareAppConfig) {
            this.config.mAppConfig = iShareAppConfig;
            return this;
        }

        public Builder setNewRuleConfig(IShareNewRuleConfig iShareNewRuleConfig) {
            this.config.mNewRuleConfig = iShareNewRuleConfig;
            return this;
        }

        public Builder setDownloadConfig(IShareDownloadConfig iShareDownloadConfig) {
            this.config.mDownloadConfig = iShareDownloadConfig;
            return this;
        }

        public Builder setEventConfig(IShareEventConfig iShareEventConfig) {
            this.config.mEventConfig = iShareEventConfig;
            return this;
        }

        public Builder setImageConfig(IShareImageConfig iShareImageConfig) {
            this.config.mImageConfig = iShareImageConfig;
            return this;
        }

        public Builder setKeyConfig(IShareKeyConfig iShareKeyConfig) {
            this.config.mKeyConfig = iShareKeyConfig;
            return this;
        }

        public Builder setLifecycleConfig(IShareLifecycleConfig iShareLifecycleConfig) {
            this.config.mLifecycleConfig = iShareLifecycleConfig;
            return this;
        }

        public Builder setNetworkConfig(IShareNetworkConfig iShareNetworkConfig) {
            this.config.mNetworkConfig = iShareNetworkConfig;
            return this;
        }

        public Builder setAsyncThreadConfig(IShareAsyncThreadConfig iShareAsyncThreadConfig) {
            this.config.mAsyncThreadConfig = iShareAsyncThreadConfig;
            return this;
        }

        public Builder setClipboardConfig(IShareClipboardConfig iShareClipboardConfig) {
            this.config.mClipboardConfig = iShareClipboardConfig;
            return this;
        }

        public Builder setPermissionConfig(ISharePermissionConfig iSharePermissionConfig) {
            this.config.mPermissionConfig = iSharePermissionConfig;
            return this;
        }

        public Builder setQrScanConfig(IShareQrScanConfig iShareQrScanConfig) {
            this.config.mQrScanConfig = iShareQrScanConfig;
            return this;
        }

        private Builder setVideoWatermarkConfig(IShareVideoWmConfig iShareVideoWmConfig) {
            this.config.mVideoWatermarkConfig = iShareVideoWmConfig;
            return this;
        }

        public Builder setVideoFrameConfig(IShareVideoFrameConfig iShareVideoFrameConfig) {
            this.config.mVideoFrameConfig = iShareVideoFrameConfig;
            return this;
        }

        public Builder setImageTokenConfig(IShareImageTokenConfig iShareImageTokenConfig) {
            this.config.mImageTokenConfig = iShareImageTokenConfig;
            return this;
        }

        public Builder setUIConfig(IShareUIConfig iShareUIConfig) {
            this.config.mUIConfig = iShareUIConfig;
            return this;
        }

        public Builder setTokenConfig(IShareTokenConfig iShareTokenConfig) {
            this.config.mTokenConfig = iShareTokenConfig;
            return this;
        }

        public Builder setSpConfig(IShareSpConfig iShareSpConfig) {
            this.config.mSpConfig = iShareSpConfig;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.config.mIsDebug = z;
            return this;
        }

        public Builder setLocalMode(boolean z) {
            this.config.mIsLocalMode = z;
            return this;
        }

        public Builder setBoe(boolean z) {
            this.config.mIsBoe = z;
            return this;
        }

        public ShareConfig build() {
            return this.config;
        }
    }
}
