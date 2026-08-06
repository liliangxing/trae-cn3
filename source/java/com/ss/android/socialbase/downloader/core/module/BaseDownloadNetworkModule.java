package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHttpUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseDownloadNetworkModule extends AbsDownloadModule implements IDownloadRunnableCallback {
    private static final String TAG = "AbsDownloadNetworkModule";

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void handleFirstConnection(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws BaseException {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
    }

    public boolean hasRunNetworkProceed(IDownloadModuleChain iDownloadModuleChain, boolean z) throws BaseException {
        if (this.mCommonParams.mHasRunNetworkModule) {
            iDownloadModuleChain.proceed();
            return true;
        }
        this.mCommonParams.mHasRunNetworkModule = z;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long j) throws BaseException {
        return this.mStatusHandler.onProgress(j);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveData(byte[] bArr, int i) {
        this.mStatusHandler.onReceiveData(bArr, i);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveSegmentData(long j, byte[] bArr, int i) {
        this.mStatusHandler.onReceiveSegmentData(j, bArr, i);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveHeader(List<Pair<String, String>> list) {
        this.mStatusHandler.onReceiveHeader(list);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveRequestLog(String str) {
        this.mStatusHandler.onReceiveRequestLog(str);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void checkMaxBytes(long j, int i) throws BaseException {
        if (j > 0 && i > 0 && j > i) {
            throw new BaseException(DownloadErrorCode.ERROR_MAX_BYTE_LIMIT, "Current Bytes:" + j + "Limit bytes:" + i);
        }
    }

    public List<HttpHeader> buildRequestHeader(long j, long j2, boolean z) {
        boolean z2;
        String str;
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "buildRequestHeader", "CurrentOffset: endOffset:" + j2 + " handleBody:" + z);
        }
        List<HttpHeader> extraHeaders = this.mDownloadInfo.getExtraHeaders();
        ArrayList arrayList = new ArrayList();
        String str2 = DownloadHelper.GZIP;
        boolean z3 = false;
        if (extraHeaders == null || extraHeaders.size() <= 0) {
            z2 = false;
        } else {
            z2 = false;
            for (HttpHeader httpHeader : extraHeaders) {
                if (httpHeader != null) {
                    if (DownloadHelper.ACCEPT_ENCODING.equalsIgnoreCase(httpHeader.getName()) && DownloadHelper.GZIP.equalsIgnoreCase(httpHeader.getValue())) {
                        z2 = true;
                    } else {
                        arrayList.add(httpHeader);
                    }
                }
            }
        }
        String str3 = this.mDownloadInfo.geteTag();
        if (this.mCommonParams.mNeedCheckIfModified) {
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new HttpHeader("If-None-Match", str3));
            }
            if (!TextUtils.isEmpty(this.mDownloadInfo.getLastModified())) {
                arrayList.add(new HttpHeader(DownloadHelper.IF_MODIFIED_SINCE, this.mDownloadInfo.getLastModified()));
                arrayList.add(new HttpHeader(DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE, DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE));
            }
        } else if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new HttpHeader(DownloadHelper.IF_MATCH, str3));
        }
        if (j2 > 0) {
            str = String.format(Locale.US, "bytes=%d-%d", Long.valueOf(j), Long.valueOf(j2));
        } else if (j > 0) {
            str = String.format(Locale.US, "bytes=%d-", Long.valueOf(j));
        } else {
            str = !z ? "bytes=0-0" : null;
        }
        if (str != null) {
            arrayList.add(new HttpHeader("Range", str));
        } else {
            z3 = z2;
        }
        if (!z3) {
            str2 = "identity";
        }
        arrayList.add(new HttpHeader(DownloadHelper.ACCEPT_ENCODING, str2));
        arrayList.add(new HttpHeader("extra_download_id", String.valueOf(this.mDownloadInfo.getId())));
        DownloadHelper.addTTNetParam(this.mSetting, arrayList, this.mDownloadInfo);
        this.mCommonParams.mFailoverStrategy.handleHeader(extraHeaders);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0077 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:11:0x0077, B:13:0x007f, B:14:0x0084, B:16:0x0092, B:17:0x009a, B:18:0x009f, B:26:0x00b3, B:28:0x00be, B:29:0x00c7, B:30:0x00d7, B:34:0x00e1, B:36:0x00e5, B:38:0x00ee, B:39:0x00f3, B:40:0x00f8, B:42:0x00fb, B:47:0x010a, B:48:0x010f, B:52:0x011a, B:53:0x0123), top: B:9:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IDownloadHttpConnection sendRequest(String str, List<HttpHeader> list, long j) throws BaseException {
        IDownloadHttpConnection iDownloadHttpConnection;
        Throwable th;
        int i;
        IDownloadHttpConnection iDownloadHttpConnection2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            iDownloadHttpConnection = DownloadComponentManager.downloadWithConnection(this.mDownloadInfo.isNeedDefaultHttpServiceBackUp(), this.mDownloadInfo.getMaxBytes(), str, null, list, this.mSetting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), false, this.mDownloadInfo);
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    int responseCode = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(th);
                    setHttpResponseStatus(iDownloadHttpConnection, responseCode);
                    DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, th, this.mDownloadTask.getCdnListener());
                    IDownloadHttpConnection iDownloadHttpConnection3 = iDownloadHttpConnection;
                    th = th;
                    i = responseCode;
                    iDownloadHttpConnection2 = iDownloadHttpConnection3;
                    try {
                        if (i != 304) {
                        }
                    } catch (Throwable th3) {
                        if (iDownloadHttpConnection2 != null) {
                            iDownloadHttpConnection2.end();
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    setHttpResponseStatus(iDownloadHttpConnection, -1);
                    DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, null, this.mDownloadTask.getCdnListener());
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            iDownloadHttpConnection = null;
        }
        if (iDownloadHttpConnection == null) {
            throw new BaseException(1022, new IOException("Connection is null"));
        }
        i = iDownloadHttpConnection.getResponseCode();
        setHttpResponseStatus(iDownloadHttpConnection, i);
        DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, null, this.mDownloadTask.getCdnListener());
        iDownloadHttpConnection2 = iDownloadHttpConnection;
        th = null;
        if (i != 304) {
            if (!this.mDownloadInfo.isDownloaded()) {
                handleResponseCodeError("Status 304 file not found", null);
            }
            if (System.currentTimeMillis() > this.mDownloadInfo.getCacheExpiredTime()) {
                setMaxAge(new HttpResponse(str, iDownloadHttpConnection2, 304));
            }
            throw new DownloadFileExistException();
        }
        if (i == 403) {
            throw new BaseException(1047, "Status Error:403", th);
        }
        if ((i > 0 && i < 200) || i >= 300) {
            DownloadTTNetException tTNetException = th != null ? DownloadHelper.getTTNetException(th, "sendRequest") : null;
            if (tTNetException == null) {
                tTNetException = new DownloadTTNetException(i + 2000, "Status Error");
            }
            handleResponseCodeError("Http Status Error: " + i, tTNetException);
        }
        if (this.mCommonParams.mNeedCheckIfModified) {
            if (i >= 200 && i < 300) {
                resetDownloadInfo();
                return iDownloadHttpConnection2;
            }
            if (!DownloadUtils.isFileDownloaded(this.mDownloadInfo, false, (String) null)) {
                handleResponseCodeError("CheckIfModified file not found", null);
            }
            throw new DownloadFileExistException();
        }
        if (th != null) {
            DownloadHelper.parseException(th, "DoConnect");
        }
        if (i != 206 && j > 0) {
            handleResponseCodeError("Http range not support", null);
        }
        this.mDownloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis);
        return iDownloadHttpConnection2;
    }

    public void handleResponseHeader(String str, long j, IDownloadHttpConnection iDownloadHttpConnection) throws BaseException {
        String str2;
        long j2;
        try {
            HttpResponse httpResponse = new HttpResponse(str, iDownloadHttpConnection);
            int i = httpResponse.responseCode;
            String contentType = httpResponse.getContentType();
            if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) && !TextUtils.isEmpty(contentType)) {
                this.mDownloadInfo.setMimeType(contentType);
            }
            this.mDownloadInfo.setSupportPartial(httpResponse.acceptPartial());
            String etag = httpResponse.getEtag();
            if (!TextUtils.isEmpty(etag)) {
                this.mDownloadInfo.seteTag(etag);
            }
            String lastModified = httpResponse.getLastModified();
            if (!TextUtils.isEmpty(lastModified)) {
                this.mDownloadInfo.setLastModified(lastModified);
            }
            this.mDownloadInfo.setContentEncoding(httpResponse.getContentEncoding());
            if (DownloadHelper.GZIP.equalsIgnoreCase(this.mDownloadInfo.getContentEncoding())) {
                this.mDownloadInfo.setIgnoreDataVerify(true);
            }
            setMaxAge(httpResponse);
            if (Logger.debugScene(this.mDownloadInfo)) {
                str2 = etag;
                Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "ResponseCode=" + i + " last_modified=" + lastModified + " CACHE_CONTROL=" + httpResponse.getCacheControl() + " max-age=" + httpResponse.getMaxAge() + " isDeleteCacheIfCheckFailed=" + this.mDownloadInfo.isDeleteCacheIfCheckFailed());
                Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", " cur=" + lastModified + " before=" + this.mDownloadInfo.getLastModified() + " cur=" + httpResponse.getTotalLength() + " before=" + this.mDownloadInfo.getTotalBytes());
            } else {
                str2 = etag;
            }
            if (iDownloadHttpConnection instanceof AbsDownloadHttpConnection) {
                String redirectPartialUrlResults = ((AbsDownloadHttpConnection) iDownloadHttpConnection).getRedirectPartialUrlResults();
                if (!TextUtils.isEmpty(redirectPartialUrlResults)) {
                    this.mDownloadInfo.setRedirectPartialUrlResults(redirectPartialUrlResults);
                }
            }
            if (!httpResponse.isChunked()) {
                String contentRange = httpResponse.getContentRange();
                if (Logger.debugScene(this.mDownloadInfo)) {
                    Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "ContentRange:" + contentRange);
                }
                if (!TextUtils.isEmpty(contentRange)) {
                    j2 = DownloadHelper.parseContentRangeOfInstanceLength(contentRange);
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "TotalLength:" + j2);
                    }
                } else {
                    long contentLength = j + httpResponse.getContentLength();
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "TotalLength2:" + contentLength);
                    }
                    j2 = contentLength;
                }
            } else {
                this.mDownloadInfo.setXTotalBytes(httpResponse.getXContentLength());
                j2 = -1;
            }
            if (this.mDownloadInfo.getStartOffset() > 0 || this.mDownloadInfo.getEndOffset() >= 0) {
                if (this.mDownloadInfo.getStartOffset() < 0 || this.mDownloadInfo.getEndOffset() >= j2 || (this.mDownloadInfo.getEndOffset() >= 0 && this.mDownloadInfo.getStartOffset() > this.mDownloadInfo.getEndOffset())) {
                    throw new BaseException(1084, "startOffset = " + this.mDownloadInfo.getStartOffset() + ", endOffset = " + this.mDownloadInfo.getEndOffset() + ", totalLength = " + j2);
                }
                if (this.mDownloadInfo.getEndOffset() < 0) {
                    j2 -= this.mDownloadInfo.getStartOffset();
                } else {
                    j2 = 1 + (this.mDownloadInfo.getEndOffset() - this.mDownloadInfo.getStartOffset());
                }
            }
            if (!TextUtils.isEmpty(this.mDownloadInfo.getTaskKey()) && this.mDownloadInfo.getTotalBytes() > 0 && j2 != this.mDownloadInfo.getTotalBytes()) {
                handleResponseCodeError("file totalLength changed", null);
            }
            if (checkTaskFinishByUser()) {
                return;
            }
            if (this.mDownloadInfo.getExpectFileLength() > 0 && this.mSetting.optInt(DownloadSettingKeys.FORCE_CHECK_FILE_LENGTH) == 1 && this.mDownloadInfo.getExpectFileLength() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.mDownloadInfo.getExpectFileLength() + " , totalLength = " + j2);
            }
            if (DownloadMimeTypeInterceptModule.checkGlobalIntercept(this.mDownloadInfo)) {
                throw new BaseException(1083, "download global intercept");
            }
            this.mStatusHandler.onFirstConnectionSuccessed(j2, str2, this.mDownloadInfo.getName());
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th) {
            DownloadHelper.parseException(th, "handleResponseHeader");
        }
    }

    public void closeConnection(final IDownloadHttpConnection iDownloadHttpConnection) {
        if (iDownloadHttpConnection == null) {
            return;
        }
        DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule.1
            @Override // java.lang.Runnable
            public void run() {
                IDownloadHttpConnection iDownloadHttpConnection2 = iDownloadHttpConnection;
                if (iDownloadHttpConnection2 == null) {
                    return;
                }
                try {
                    iDownloadHttpConnection2.end();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, true);
    }

    private void setMaxAge(HttpResponse httpResponse) {
        if (!TextUtils.isEmpty(httpResponse.getCacheControl()) && httpResponse.getMaxAge() > 0) {
            this.mDownloadInfo.setCacheExpiredTime(System.currentTimeMillis() + (httpResponse.getMaxAge() * 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleResponseCodeError(String str, Throwable th) throws BaseException {
        resetDownloadInfo();
        throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, str, th);
    }

    private void resetDownloadInfo() {
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mCommonParams.mNeedCheckIfModified = false;
        this.mDownloadInfo.resetDataForEtagEndure("");
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
    }

    private void setHttpResponseStatus(IDownloadHttpConnection iDownloadHttpConnection, int i) {
        String responseHeaderField;
        if (iDownloadHttpConnection == null) {
            return;
        }
        try {
            this.mDownloadInfo.setHttpStatusCode(i);
            this.mDownloadInfo.setHttpStatusMessage(DownloadHttpUtils.httpCodeToMessage(i));
            List<String> accessHttpHeaderKeys = this.mDownloadInfo.getAccessHttpHeaderKeys();
            if (accessHttpHeaderKeys == null || accessHttpHeaderKeys.isEmpty()) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str : accessHttpHeaderKeys) {
                if (str != null && (responseHeaderField = iDownloadHttpConnection.getResponseHeaderField(str)) != null) {
                    hashMap.put(str, responseHeaderField);
                }
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.mDownloadInfo.setHttpHeaders(hashMap);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                this.mDownloadInfo.setHttpStatusCode(-1);
                this.mDownloadInfo.setHttpStatusMessage("");
            }
        }
    }
}
