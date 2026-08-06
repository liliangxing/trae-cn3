package com.ss.android.download.api.download;

/* loaded from: classes7.dex */
public class SimpleDownloadEventConfig implements DownloadEventConfig {
    private String mClickButtonTag;
    private String mClickContinueLabel;
    private String mClickInstallLabel;
    private String mClickLabel;
    private String mClickOpenLabel;
    private String mClickPauseLabel;
    private String mClickStartLabel;
    private String mDownloadFailedLabel;
    private Object mExtraEventObject;
    private boolean mIsEnableClickEvent;
    private boolean mIsEnableCompletedEvent;
    private boolean mIsEnableNoChargeClickEvent;
    private boolean mIsEnableV3Event;
    private String mOpenLabel;
    private String mStorageDenyLabel;

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickOpenTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getCompletedEventTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getOpenTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyTag() {
        return null;
    }

    public SimpleDownloadEventConfig() {
    }

    private SimpleDownloadEventConfig(Builder builder) {
        this.mClickButtonTag = builder.mClickButtonTag;
        this.mIsEnableClickEvent = builder.mIsEnableClickEvent;
        this.mClickLabel = builder.mClickLabel;
        this.mClickStartLabel = builder.mClickStartLabel;
        this.mClickPauseLabel = builder.mClickPauseLabel;
        this.mClickContinueLabel = builder.mClickContinueLabel;
        this.mClickInstallLabel = builder.mClickInstallLabel;
        this.mClickOpenLabel = builder.mClickOpenLabel;
        this.mOpenLabel = builder.mOpenLabel;
        this.mStorageDenyLabel = builder.mStorageDenyLabel;
        this.mDownloadFailedLabel = builder.mDownloadFailedLabel;
        this.mExtraEventObject = builder.mExtraEventObject;
        this.mIsEnableV3Event = builder.mIsEnableV3Event;
        this.mIsEnableNoChargeClickEvent = builder.mIsEnableNoChargeClickEvent;
        this.mIsEnableCompletedEvent = builder.mIsEnableCompletedEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.mClickButtonTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.mClickLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.mClickStartLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.mClickPauseLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.mClickContinueLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.mClickInstallLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickOpenLabel() {
        return this.mClickOpenLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getOpenLabel() {
        return this.mOpenLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.mStorageDenyLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getDownloadFailedLabel() {
        return this.mDownloadFailedLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.mExtraEventObject;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.mIsEnableClickEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableNoChargeClickEvent() {
        return this.mIsEnableNoChargeClickEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableCompletedEvent() {
        return this.mIsEnableCompletedEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.mIsEnableV3Event;
    }

    public void setExtraEventObject(Object obj) {
        this.mExtraEventObject = obj;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private String mClickButtonTag;
        private String mClickContinueLabel;
        private String mClickInstallLabel;
        private String mClickLabel;
        private String mClickOpenLabel;
        private String mClickPauseLabel;
        private String mClickStartLabel;
        private String mDownloadFailedLabel;
        private Object mExtraEventObject;
        private boolean mIsEnableClickEvent;
        private boolean mIsEnableCompletedEvent;
        private boolean mIsEnableNoChargeClickEvent;
        private boolean mIsEnableV3Event;
        private String mOpenLabel;
        private String mStorageDenyLabel;

        public Builder setClickButtonTag(String str) {
            this.mClickButtonTag = str;
            return this;
        }

        public Builder setIsEnableClickEvent(boolean z) {
            this.mIsEnableClickEvent = z;
            return this;
        }

        public Builder setClickLabel(String str) {
            this.mClickLabel = str;
            return this;
        }

        public Builder setClickStartLabel(String str) {
            this.mClickStartLabel = str;
            return this;
        }

        public Builder setClickPauseLabel(String str) {
            this.mClickPauseLabel = str;
            return this;
        }

        public Builder setClickContinueLabel(String str) {
            this.mClickContinueLabel = str;
            return this;
        }

        public Builder setClickInstallLabel(String str) {
            this.mClickInstallLabel = str;
            return this;
        }

        public Builder setClickOpenLabel(String str) {
            this.mClickOpenLabel = str;
            return this;
        }

        public Builder setOpenLabel(String str) {
            this.mOpenLabel = str;
            return this;
        }

        public Builder setStorageDenyLabel(String str) {
            this.mStorageDenyLabel = str;
            return this;
        }

        public Builder setDownloadFailedLabel(String str) {
            this.mDownloadFailedLabel = str;
            return this;
        }

        public Builder setExtraEventObject(Object obj) {
            this.mExtraEventObject = obj;
            return this;
        }

        public Builder setIsEnableV3Event(boolean z) {
            this.mIsEnableV3Event = z;
            return this;
        }

        public Builder setIsEnableNoChargeClickEvent(boolean z) {
            this.mIsEnableNoChargeClickEvent = z;
            return this;
        }

        public Builder setIsEnableCompletedEvent(boolean z) {
            this.mIsEnableCompletedEvent = z;
            return this;
        }

        public SimpleDownloadEventConfig build() {
            return new SimpleDownloadEventConfig(this);
        }
    }
}
