package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes7.dex */
public interface IAppDownloadMonitorListener {
    void onAppDownloadMonitorSend(DownloadInfo downloadInfo, BaseException baseException, int i);
}
