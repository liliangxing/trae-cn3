package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckWifiTaskValidModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckWifiTaskValidModule";

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (downloadCommonParams.mDownloadInfo.isFastDownload()) {
            return null;
        }
        return super.init(downloadCommonParams);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        checkWifiTaskValid(this.mDownloadInfo);
        iDownloadModuleChain.proceed();
    }

    public static void checkWifiTaskValid(DownloadInfo downloadInfo) throws DownloadRetryNeedlessException {
        if (downloadInfo.isFastDownload() || DeviceBandwidthSampler.isWifi()) {
            return;
        }
        if (downloadInfo.isOnlyWifi()) {
            DeviceBandwidthSampler.updateNetworkStatus();
            if (DeviceBandwidthSampler.isMobileNet()) {
                throw new DownloadOnlyWifiException();
            }
        }
        if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
            DeviceBandwidthSampler.updateNetworkStatus();
            if (DeviceBandwidthSampler.isMobileNet()) {
                throw new DownloadPauseReserveWifiException();
            }
        }
    }
}
