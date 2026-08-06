package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DeepLink;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SimpleDownloadModel implements DownloadModel {
    private String mDownloadUrl;
    private long mExtraValue;
    private String mFileName;
    private String mFilePath;
    private Map<String, String> mHeaders;
    private long mId;
    private boolean mIsInExternalPublicDir;
    private boolean mIsNeedWifi;
    private boolean mIsShowNotification;
    private boolean mIsShowToast;
    private boolean mIsVisibleInDownloadsUi;
    private String mMimeType;
    private String mName;
    private String mPackageName;

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getAppIcon() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getClickTrackUrl() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public DeepLink getDeepLink() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getExtra() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getLogExtra() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        return false;
    }

    private SimpleDownloadModel(Builder builder) {
        this.mId = builder.mId;
        this.mExtraValue = builder.mExtraValue;
        this.mDownloadUrl = builder.mDownloadUrl;
        this.mName = builder.mName;
        this.mMimeType = builder.mMimeType;
        this.mHeaders = builder.mHeaders;
        this.mIsShowToast = builder.mIsShowToast;
        this.mIsShowNotification = builder.mIsShowNotification;
        this.mIsNeedWifi = builder.mNeedWifi;
        this.mIsInExternalPublicDir = builder.mIsInExternalPublicDir;
        this.mIsVisibleInDownloadsUi = builder.mIsVisibleInDownloadsUi;
        this.mFilePath = builder.mFilePath;
        this.mFileName = builder.mFileName;
        this.mPackageName = builder.mPackageName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        return this.mId;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getName() {
        return this.mName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        return this.mIsNeedWifi;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return this.mIsVisibleInDownloadsUi;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        this.mIsNeedWifi = true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getPackageName() {
        return this.mPackageName;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private String mDownloadUrl;
        private long mExtraValue;
        private String mFileName;
        private String mFilePath;
        private Map<String, String> mHeaders;
        private long mId;
        private String mMimeType;
        private String mName;
        private String mPackageName;
        private boolean mIsShowToast = true;
        private boolean mIsShowNotification = true;
        private boolean mNeedWifi = false;
        private boolean mIsInExternalPublicDir = true;
        private boolean mIsVisibleInDownloadsUi = true;

        public Builder setId(long j) {
            this.mId = j;
            return this;
        }

        public Builder setExtraValue(long j) {
            this.mExtraValue = j;
            return this;
        }

        public Builder setDownloadUrl(String str) {
            this.mDownloadUrl = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.mHeaders = map;
            return this;
        }

        public Builder setIsShowToast(boolean z) {
            this.mIsShowToast = z;
            return this;
        }

        public Builder setIsShowNotification(boolean z) {
            this.mIsShowNotification = z;
            return this;
        }

        public Builder setNeedWifi(boolean z) {
            this.mNeedWifi = z;
            return this;
        }

        public Builder setIsInExternalPublicDir(boolean z) {
            this.mIsInExternalPublicDir = z;
            return this;
        }

        public Builder setIsVisibleInDownloadsUi(boolean z) {
            this.mIsVisibleInDownloadsUi = z;
            return this;
        }

        public Builder setFilePath(String str) {
            this.mFilePath = str;
            return this;
        }

        public Builder setFileName(String str) {
            this.mFileName = str;
            return this;
        }

        public Builder setPackagName(String str) {
            this.mPackageName = str;
            return this;
        }

        public SimpleDownloadModel build() {
            return new SimpleDownloadModel(this);
        }
    }
}
