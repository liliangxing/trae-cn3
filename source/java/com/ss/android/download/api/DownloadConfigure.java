package com.ss.android.download.api;

import com.ss.android.download.api.config.AppStatusChangeListener;
import com.ss.android.download.api.config.DownloadActionListener;
import com.ss.android.download.api.config.DownloadAutoInstallInterceptListener;
import com.ss.android.download.api.config.DownloadEventLogger;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.DownloadPermissionChecker;
import com.ss.android.download.api.config.DownloadSettings;
import com.ss.android.download.api.config.DownloadUIFactory;
import com.ss.android.download.api.config.GlobalInfoSettings;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface DownloadConfigure {
    DownloadConfigure setActionListener(DownloadActionListener downloadActionListener);

    DownloadConfigure setAppInfo(AppInfo appInfo);

    DownloadConfigure setAppStatusChangeListener(AppStatusChangeListener appStatusChangeListener);

    DownloadConfigure setDownloadAutoInstallInterceptListener(DownloadAutoInstallInterceptListener downloadAutoInstallInterceptListener);

    DownloadConfigure setDownloadMonitorListener(IAppDownloadMonitorListener iAppDownloadMonitorListener);

    DownloadConfigure setDownloadNetworkFactory(DownloadNetworkFactory downloadNetworkFactory);

    DownloadConfigure setDownloadPermissionChecker(DownloadPermissionChecker downloadPermissionChecker);

    DownloadConfigure setDownloadSettings(DownloadSettings downloadSettings);

    DownloadConfigure setDownloadUIFactory(DownloadUIFactory downloadUIFactory);

    DownloadConfigure setEventLogger(DownloadEventLogger downloadEventLogger);

    DownloadConfigure setGlobalInfoSettings(GlobalInfoSettings globalInfoSettings);
}
