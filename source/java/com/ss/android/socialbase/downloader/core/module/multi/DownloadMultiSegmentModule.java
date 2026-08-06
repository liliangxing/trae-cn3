package com.ss.android.socialbase.downloader.core.module.multi;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.segment.SegmentStrategy;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadMultiSegmentModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadMultiSegmentModule";
    private SegmentDispatcher mSegmentDispatcher;

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (hasRunNetworkProceed(iDownloadModuleChain, false) || checkTaskFinishByUser()) {
            return;
        }
        doDownload();
        iDownloadModuleChain.proceed();
    }

    private void doDownload() throws BaseException {
        if (!this.mDownloadInfo.isExpiredRedownload() && this.mDownloadInfo.getChunkCount() == 1 && this.mDownloadInfo.getThrottleNetSpeed() <= 0 && this.mCommonParams.mEnableSegmentDownload) {
            JSONObject optJSONObject = this.mSetting.optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
            List<Segment> segments = this.mDownloadCache.getSegments(this.mDownloadInfo.getId());
            if (this.mDownloadInfo.getCurBytes() > 0) {
                if (segments == null || segments.isEmpty()) {
                    return;
                }
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
            }
            if (optJSONObject == null) {
                return;
            }
            this.mSegmentDispatcher = new SegmentDispatcher(this.mDownloadTask, this.mDownloadInfo, SegmentStrategy.from(optJSONObject), this);
            if (checkTaskFinishByUser()) {
                if (Logger.debugScene(this.mDownloadInfo)) {
                    Logger.taskDebug(TAG, this.mDownloadInfo, "downloadSegments", "Stopped by user");
                }
                if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_CANCELED) {
                    this.mSegmentDispatcher.cancel();
                    return;
                } else {
                    this.mSegmentDispatcher.pause();
                    return;
                }
            }
            this.mCommonParams.mHasRunNetworkModule = true;
            try {
                this.mSegmentDispatcher.downloadSegments(segments);
            } catch (BaseException e) {
                throw new DownloadMultiSegmentException(e.getErrorCode(), e.getErrorMessage());
            } catch (Throwable th) {
                throw new DownloadMultiSegmentException(1000, th.getMessage());
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void handleFirstConnection(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws BaseException {
        boolean z;
        long j2;
        if (iDownloadHeadHttpConnection == null) {
            return;
        }
        try {
            HttpResponse httpResponse = new HttpResponse(str, iDownloadHeadHttpConnection);
            int i = httpResponse.responseCode;
            String contentType = httpResponse.getContentType();
            if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) && !TextUtils.isEmpty(contentType)) {
                this.mDownloadInfo.setMimeType(contentType);
            }
            boolean acceptPartial = httpResponse.acceptPartial();
            this.mDownloadInfo.setSupportPartial(acceptPartial);
            boolean isResponseDataFromBegin = httpResponse.isResponseDataFromBegin();
            String str2 = this.mDownloadInfo.geteTag();
            String etag = httpResponse.getEtag();
            if (Logger.debugScene(this.mDownloadInfo)) {
                z = acceptPartial;
                Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "ResponseCode=" + i + " isDeleteCacheIfCheckFailed=" + this.mDownloadInfo.isDeleteCacheIfCheckFailed());
                Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "firstOffset=" + j + " cur=" + httpResponse.getTotalLength() + " before=" + this.mDownloadInfo.getTotalBytes());
            } else {
                z = acceptPartial;
            }
            if (iDownloadHeadHttpConnection instanceof AbsDownloadHttpConnection) {
                String redirectPartialUrlResults = ((AbsDownloadHttpConnection) iDownloadHeadHttpConnection).getRedirectPartialUrlResults();
                if (!TextUtils.isEmpty(redirectPartialUrlResults)) {
                    this.mDownloadInfo.setRedirectPartialUrlResults(redirectPartialUrlResults);
                }
            }
            String str3 = etag;
            if (isResponseCodeError(i, str2, str3, isResponseDataFromBegin, z)) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str3)) {
                    str3 = "";
                }
                handleResponseCodeError(str3, "eTag of server file changed");
            }
            if (!z && !isResponseDataFromBegin) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                if (this.mDownloadInfo.getStartOffset() >= 0 && (this.mDownloadInfo.getEndOffset() < 0 || this.mDownloadInfo.getStartOffset() <= this.mDownloadInfo.getEndOffset())) {
                    throw new DownloadHttpException(1004, i, "response code error : " + i);
                }
                throw new BaseException(1084, "startOffset = " + this.mDownloadInfo.getStartOffset() + ", endOffset = " + this.mDownloadInfo.getEndOffset() + ", response code error : " + i);
            }
            if (isResponseDataFromBegin && j > 0) {
                handleResponseCodeError("", "isResponseFromBegin but firstOffset > 0");
            }
            long contentLength = httpResponse.getContentLength();
            if (!httpResponse.isChunked()) {
                String respHeadFieldIgnoreCase = DownloadUtils.getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, DownloadUtils.CONTENT_RANGE);
                if (Logger.debugScene(this.mDownloadInfo)) {
                    Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "ContentRange:" + respHeadFieldIgnoreCase);
                }
                if (!TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
                    j2 = DownloadHelper.parseContentRangeOfInstanceLength(respHeadFieldIgnoreCase);
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "TotalLength:" + j2);
                    }
                } else {
                    j2 = j + contentLength;
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "TotalLength2:" + j2);
                    }
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
                    j2 = (this.mDownloadInfo.getEndOffset() - this.mDownloadInfo.getStartOffset()) + 1;
                }
            }
            if (!TextUtils.isEmpty(this.mDownloadInfo.getTaskKey()) && this.mDownloadInfo.getTotalBytes() > 0 && j2 != this.mDownloadInfo.getTotalBytes()) {
                handleResponseCodeError("", "file totalLength changed");
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
            this.mStatusHandler.onFirstConnectionSuccessed(j2, str3, this.mDownloadInfo.getName());
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th) {
            DownloadHelper.parseException(th, "HandleFirstConnection");
        }
    }

    private void handleResponseCodeError(String str, String str2) throws BaseException {
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadInfo.resetDataForEtagEndure(str);
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, str2);
    }

    private boolean isResponseCodeError(int i, String str, String str2, boolean z, boolean z2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(z || z2)) {
            return (i == 201 || i == 416) && this.mDownloadInfo.getCurBytes() > 0;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        SegmentDispatcher segmentDispatcher = this.mSegmentDispatcher;
        if (segmentDispatcher != null) {
            segmentDispatcher.pause();
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        SegmentDispatcher segmentDispatcher = this.mSegmentDispatcher;
        if (segmentDispatcher != null) {
            segmentDispatcher.cancel();
        }
    }
}
