package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadExtListener extends AbsDownloadListener implements IDownloadExtListener {
    private static final String TAG = "AbsDownloadExtListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onWaitingDownloadCompleteHandler", "Name:" + downloadInfo.getName());
    }
}
