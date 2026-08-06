package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadMonitorHelperService implements IDownloadMonitorHelperService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSend(DownloadTask downloadTask, BaseException baseException, int i) {
        DownloadMonitorHelper.monitorSend(downloadTask, baseException, i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i) {
        DownloadMonitorHelper.monitorSendWithTaskMonitor(iDownloadMonitorDepend, downloadInfo, baseException, i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorDownloadApp(DownloadInfo downloadInfo, String str, int i) {
        DownloadMonitorHelper.monitorDownloadApp(downloadInfo, str, i);
    }
}
