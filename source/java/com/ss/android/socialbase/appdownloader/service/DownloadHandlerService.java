package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.DownloadHandlerServiceImpl;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHandlerService implements IDownloadHandlerService {
    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
    public void onStartCommand(Context context, Intent intent) {
        DownloadHandlerServiceImpl.onStartCommand(context, intent);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
    public void handleActionClickWithoutType(Context context, DownloadInfo downloadInfo, IAppDownloadEventHandler iAppDownloadEventHandler, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadHandlerServiceImpl.handleActionClickWithoutType(context, downloadInfo, iAppDownloadEventHandler, iDownloadNotificationEventListener);
    }
}
