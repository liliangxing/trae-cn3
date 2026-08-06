package com.ss.android.socialbase.downloader.core.module.fast;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadFastModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadFastModule";
    private DownloadSingleResponseHandler mDownloadResponseHandler;
    private IDownloadHttpConnection mHttpConnection;

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (!downloadCommonParams.mDownloadInfo.isFastDownload()) {
            return null;
        }
        if (downloadCommonParams.mDownloadCache instanceof DefaultDownloadCache) {
            downloadCommonParams.mDownloadCache = ((DefaultDownloadCache) downloadCommonParams.mDownloadCache).getDownloadCache();
        }
        return super.init(downloadCommonParams);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (hasRunNetworkProceed(iDownloadModuleChain, true) || checkTaskFinishByUser() || checkFileExists()) {
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

    private boolean checkFileExists() {
        if (!new DownloadFile(this.mDownloadInfo.getSavePath(), this.mDownloadInfo.getName()).exists()) {
            return false;
        }
        this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        this.mCommonParams.mDownloadInfo.setCacheExistsInDownloading(true);
        return true;
    }

    private void doDownload() throws BaseException {
        String connectionUrl = this.mDownloadInfo.getConnectionUrl();
        IDownloadHttpConnection sendRequest = sendRequest(connectionUrl, buildRequestHeader());
        this.mHttpConnection = sendRequest;
        handleResponseHeader(connectionUrl, sendRequest);
        if (checkTaskFinishByUser()) {
            return;
        }
        DownloadSingleResponseHandler downloadSingleResponseHandler = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, 0L, this.mDownloadInfo.getTotalBytes(), this);
        this.mDownloadResponseHandler = downloadSingleResponseHandler;
        downloadSingleResponseHandler.handleResponse();
    }

    public List<HttpHeader> buildRequestHeader() {
        boolean z;
        List<HttpHeader> extraHeaders = this.mDownloadInfo.getExtraHeaders();
        ArrayList arrayList = new ArrayList();
        String str = DownloadHelper.GZIP;
        if (extraHeaders != null) {
            z = false;
            for (HttpHeader httpHeader : extraHeaders) {
                if (httpHeader != null) {
                    if (DownloadHelper.ACCEPT_ENCODING.equalsIgnoreCase(httpHeader.getName()) && DownloadHelper.GZIP.equalsIgnoreCase(httpHeader.getValue())) {
                        z = true;
                    } else {
                        arrayList.add(httpHeader);
                    }
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            str = "identity";
        }
        arrayList.add(new HttpHeader(DownloadHelper.ACCEPT_ENCODING, str));
        int optInt = this.mSetting.optInt(DownloadSettingKeys.TTNET_ERROR_PROTO_TYPE, 0);
        if (optInt > 0) {
            arrayList.add(new HttpHeader(DownloadHelper.TTNET_PROTO_TYPE, String.valueOf(optInt)));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:25:0x005b, B:12:0x0067, B:13:0x0070, B:15:0x0082), top: B:24:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {all -> 0x0063, blocks: (B:25:0x005b, B:12:0x0067, B:13:0x0070, B:15:0x0082), top: B:24:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IDownloadHttpConnection sendRequest(String str, List<HttpHeader> list) throws BaseException {
        IDownloadHttpConnection iDownloadHttpConnection;
        Throwable th;
        int responseCode;
        DownloadTTNetException downloadTTNetException = null;
        try {
            iDownloadHttpConnection = DownloadComponentManager.downloadWithConnection(this.mDownloadInfo.isNeedDefaultHttpServiceBackUp(), this.mDownloadInfo.getMaxBytes(), str, null, list, this.mSetting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), false, this.mDownloadInfo);
            try {
            } catch (Throwable th2) {
                th = th2;
                th = th;
                responseCode = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(th);
                if (responseCode > 0) {
                    if (th != null) {
                    }
                    if (downloadTTNetException == null) {
                    }
                    handleResponseCodeError("Http Status Error: " + responseCode, downloadTTNetException);
                    if (th != null) {
                    }
                    return iDownloadHttpConnection;
                }
                if (th != null) {
                }
                if (downloadTTNetException == null) {
                }
                handleResponseCodeError("Http Status Error: " + responseCode, downloadTTNetException);
                if (th != null) {
                }
                return iDownloadHttpConnection;
            }
        } catch (Throwable th3) {
            th = th3;
            iDownloadHttpConnection = null;
        }
        if (iDownloadHttpConnection == null) {
            throw new BaseException(1022, new IOException("Connection is null"));
        }
        responseCode = iDownloadHttpConnection.getResponseCode();
        th = null;
        if ((responseCode > 0 && responseCode < 200) || responseCode >= 300) {
            if (th != null) {
                try {
                    downloadTTNetException = DownloadHelper.getTTNetException(th, "sendRequest");
                } catch (Throwable th4) {
                    if (iDownloadHttpConnection != null) {
                        iDownloadHttpConnection.end();
                    }
                    throw th4;
                }
            }
            if (downloadTTNetException == null) {
                downloadTTNetException = new DownloadTTNetException(responseCode + 2000, "Status Error");
            }
            handleResponseCodeError("Http Status Error: " + responseCode, downloadTTNetException);
        }
        if (th != null) {
            DownloadHelper.parseException(th, "DoConnect");
        }
        return iDownloadHttpConnection;
    }

    public void handleResponseHeader(String str, IDownloadHttpConnection iDownloadHttpConnection) throws BaseException {
        long j;
        try {
            HttpResponse httpResponse = new HttpResponse(str, iDownloadHttpConnection);
            String contentType = httpResponse.getContentType();
            if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) && !TextUtils.isEmpty(contentType)) {
                this.mDownloadInfo.setMimeType(contentType);
            }
            this.mDownloadInfo.setContentEncoding(httpResponse.getContentEncoding());
            if (DownloadHelper.GZIP.equalsIgnoreCase(this.mDownloadInfo.getContentEncoding())) {
                this.mDownloadInfo.setIgnoreDataVerify(true);
            }
            if (!httpResponse.isChunked()) {
                String contentRange = httpResponse.getContentRange();
                if (!TextUtils.isEmpty(contentRange)) {
                    j = DownloadHelper.parseContentRangeOfInstanceLength(contentRange);
                } else {
                    j = httpResponse.getContentLength();
                }
            } else {
                this.mDownloadInfo.setXTotalBytes(httpResponse.getXContentLength());
                j = -1;
            }
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "totalLength:" + j);
            }
            if (checkTaskFinishByUser()) {
                return;
            }
            this.mDownloadInfo.setCurBytes(0L);
            this.mStatusHandler.onFirstConnectionSuccessed(j, null, this.mDownloadInfo.getName());
        } catch (Throwable th) {
            DownloadHelper.parseException(th, "handleResponseHeader");
        }
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
}
