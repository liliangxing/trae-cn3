package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadMonitorHelperService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadMonitorHelperService implements IDownloadMonitorHelperService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorDownloadApp(DownloadInfo downloadInfo, String str, int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSend(DownloadTask downloadTask, BaseException baseException, int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i) {
        }
    }

    void monitorDownloadApp(DownloadInfo downloadInfo, String str, int i);

    void monitorSend(DownloadTask downloadTask, BaseException baseException, int i);

    void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i);
}
