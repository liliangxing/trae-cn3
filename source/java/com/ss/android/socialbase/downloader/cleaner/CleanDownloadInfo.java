package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CleanDownloadInfo {
    private int mId;
    private String mMonitorScene;
    private String mName;
    private String mSavePath;
    private String mTempPath;
    private String mUrl;

    public CleanDownloadInfo() {
    }

    public CleanDownloadInfo(DownloadInfo downloadInfo) {
        this.mId = downloadInfo.getId();
        this.mSavePath = downloadInfo.getSavePath();
        this.mTempPath = downloadInfo.getTempPath();
        this.mName = downloadInfo.getName();
        this.mMonitorScene = downloadInfo.getMonitorScene();
        this.mUrl = downloadInfo.getUrl();
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }

    public void setTempPath(String str) {
        this.mTempPath = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setMonitorScene(String str) {
        this.mMonitorScene = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public int getId() {
        return this.mId;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public String getTempPath() {
        return this.mTempPath;
    }

    public String getName() {
        return this.mName;
    }

    public String getMonitorScene() {
        return this.mMonitorScene;
    }

    public String getUrl() {
        return this.mUrl;
    }
}
