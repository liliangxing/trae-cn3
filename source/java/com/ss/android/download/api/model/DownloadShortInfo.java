package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes7.dex */
public class DownloadShortInfo {
    public String fileName;
    public long id = -1;
    public int status = -1;
    public long totalBytes = -1;
    public long currentBytes = -1;

    public boolean equals(Object obj) {
        if ((obj instanceof DownloadShortInfo) && obj != null) {
            DownloadShortInfo downloadShortInfo = (DownloadShortInfo) obj;
            return ((this.id > downloadShortInfo.id ? 1 : (this.id == downloadShortInfo.id ? 0 : -1)) == 0) && (this.status == downloadShortInfo.status) && ((this.totalBytes > downloadShortInfo.totalBytes ? 1 : (this.totalBytes == downloadShortInfo.totalBytes ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.fileName) && TextUtils.isEmpty(downloadShortInfo.fileName)) || (!TextUtils.isEmpty(this.fileName) && !TextUtils.isEmpty(downloadShortInfo.fileName) && this.fileName.equals(downloadShortInfo.fileName)));
        }
        return super.equals(obj);
    }

    public void updateFromNewDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.status = DownloadUtils.translateStatusFromDownloadInfo(downloadInfo.getStatus());
        this.currentBytes = downloadInfo.getCurBytes();
        this.totalBytes = downloadInfo.getTotalBytes();
        this.fileName = downloadInfo.getTargetFilePath();
    }
}
