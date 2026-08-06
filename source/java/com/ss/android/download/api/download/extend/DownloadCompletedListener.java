package com.ss.android.download.api.download.extend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface DownloadCompletedListener {
    void onCanceled(DownloadInfo downloadInfo);

    void onDownloadFailed(DownloadInfo downloadInfo, BaseException baseException, String str);

    void onDownloadFinished(DownloadInfo downloadInfo, String str);

    void onInstalled(DownloadInfo downloadInfo, String str);
}
