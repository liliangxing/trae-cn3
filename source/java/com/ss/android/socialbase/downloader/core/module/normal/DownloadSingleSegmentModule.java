package com.ss.android.socialbase.downloader.core.module.normal;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadSingleSegmentModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadSingleSegmentModule";
    private DownloadSingleResponseHandler mDownloadResponseHandler;
    private IDownloadHttpConnection mHttpConnection;

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (hasRunNetworkProceed(iDownloadModuleChain, true) || checkTaskFinishByUser()) {
            return;
        }
        try {
            doDownload();
            closeConnection(this.mHttpConnection);
            iDownloadModuleChain.proceed();
        } catch (Throwable th) {
            closeConnection(this.mHttpConnection);
            throw th;
        }
    }

    private void doDownload() throws BaseException {
        String connectionUrl = this.mDownloadInfo.getConnectionUrl();
        long firstOffset = DownloadHelper.getFirstOffset(this.mDownloadInfo);
        int optInt = this.mSetting.optInt(DownloadSettingKeys.VERIFY_RESPONSE_PRE_FILE_LENGTH);
        if (optInt > 0 && optInt < DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE) {
            long j = optInt;
            if (firstOffset > j) {
                this.mDownloadInfo.setVerifyCurBytes(firstOffset);
                firstOffset -= j;
                this.mDownloadInfo.setCurBytes(firstOffset);
            }
        }
        long startOffset = this.mDownloadInfo.getStartOffset() + firstOffset;
        List<HttpHeader> buildRequestHeader = buildRequestHeader(startOffset, this.mDownloadInfo.getEndOffset(), true);
        this.mCommonParams.mFailoverStrategy.handleHeader(buildRequestHeader);
        this.mDownloadInfo.setHttpRequestHeader(buildRequestHeader.toString());
        this.mHttpConnection = sendRequest(connectionUrl, buildRequestHeader, startOffset);
        if (checkTaskFinishByUser()) {
            return;
        }
        handleResponseHeader(connectionUrl, firstOffset, this.mHttpConnection);
        long totalBytes = this.mDownloadInfo.getTotalBytes();
        checkMaxBytes(totalBytes, this.mDownloadInfo.getMaxBytes());
        if (checkTaskFinishByUser()) {
            return;
        }
        DownloadSingleResponseHandler downloadSingleResponseHandler = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, startOffset, totalBytes - firstOffset, this);
        this.mDownloadResponseHandler = downloadSingleResponseHandler;
        downloadSingleResponseHandler.handleResponse();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        DownloadSingleResponseHandler downloadSingleResponseHandler = this.mDownloadResponseHandler;
        if (downloadSingleResponseHandler != null) {
            downloadSingleResponseHandler.pause();
        } else {
            closeConnection(this.mHttpConnection);
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        DownloadSingleResponseHandler downloadSingleResponseHandler = this.mDownloadResponseHandler;
        if (downloadSingleResponseHandler != null) {
            downloadSingleResponseHandler.cancel();
        } else {
            closeConnection(this.mHttpConnection);
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long j, int i) {
        if (DownloadSetting.obtain(this.mDownloadInfo.getId()).optInt(DownloadSettingKeys.USE_DEFAULT_THROTTLE_SPEED, 1) != 1) {
            IDownloadHttpConnection iDownloadHttpConnection = this.mHttpConnection;
            if (iDownloadHttpConnection == null || !(iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
                return;
            }
            try {
                ((AbsDownloadHttpConnection) iDownloadHttpConnection).setThrottleNetSpeedWhenRunning(j);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        DownloadSingleResponseHandler downloadSingleResponseHandler = this.mDownloadResponseHandler;
        if (downloadSingleResponseHandler != null) {
            downloadSingleResponseHandler.setThrottleNetSpeed(j, i);
        }
    }
}
