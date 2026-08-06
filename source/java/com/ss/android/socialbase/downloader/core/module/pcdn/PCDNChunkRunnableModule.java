package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.Process;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.pcdn.PCDNBandwidthSampler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PCDNChunkRunnableModule extends BaseDownloadNetworkModule implements Runnable, PCDNBandwidthSampler.LowSpeedListener {
    private static final String TAG = "PCDNChunkRunnableModule";
    private int mChunkRetryCount;
    private IDownloadChunkCallback mDownloadChunkCallback;
    private Future mFuture;
    private IDownloadHttpConnection mHttpConnection;
    private boolean mIsStop = false;
    private PCDNChunkUrlPolicy mOuterPcdnChunkUrlPolicy;
    private PCDNBandwidthSampler mPcdnBandwidthSampler;
    private PCDNChunk mPcdnChunk;
    private PCDNChunkAllocater mPcdnChunkAllocater;
    private PCDNChunkProgressManager mPcdnChunkProgressManager;
    private PCDNChunkUrlPolicy mPcdnChunkUrlPolicy;
    private PCDNRetryPolicy mPcdnRetryPolicy;
    private PCDNStats mPcdnStats;
    private DownloadSingleResponseHandler mSingleResponseHandler;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IDownloadChunkCallback {
        void onError(Throwable th);
    }

    public PCDNChunkRunnableModule(PCDNChunkProgressManager pCDNChunkProgressManager, PCDNChunkAllocater pCDNChunkAllocater, PCDNBandwidthSampler pCDNBandwidthSampler, PCDNStats pCDNStats, PCDNChunkUrlPolicy pCDNChunkUrlPolicy, int i, IDownloadChunkCallback iDownloadChunkCallback) {
        this.mPcdnChunkProgressManager = pCDNChunkProgressManager;
        this.mPcdnChunkAllocater = pCDNChunkAllocater;
        this.mPcdnBandwidthSampler = pCDNBandwidthSampler;
        pCDNBandwidthSampler.register(this);
        this.mPcdnStats = pCDNStats;
        this.mOuterPcdnChunkUrlPolicy = pCDNChunkUrlPolicy;
        this.mChunkRetryCount = i;
        this.mDownloadChunkCallback = iDownloadChunkCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "run", "Run");
        }
        this.mPcdnBandwidthSampler.startSampling();
        while (!checkStop()) {
            PCDNChunk obtainPCDNChunk = this.mPcdnChunkAllocater.obtainPCDNChunk();
            this.mPcdnChunk = obtainPCDNChunk;
            if (obtainPCDNChunk == null) {
                return;
            } else {
                downloadChunk();
            }
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "run", "Run End");
        }
    }

    private void downloadChunk() {
        PCDNChunkUrlPolicy pCDNChunkUrlPolicy = this.mOuterPcdnChunkUrlPolicy;
        if (pCDNChunkUrlPolicy != null && !pCDNChunkUrlPolicy.isPCDN()) {
            this.mPcdnChunkUrlPolicy = this.mOuterPcdnChunkUrlPolicy.copy();
        } else {
            this.mPcdnChunkUrlPolicy = new PCDNChunkUrlPolicy(this.mDownloadInfo.getPcdnUrls(), this.mDownloadInfo.getCdnUrls());
        }
        this.mPcdnRetryPolicy = new PCDNRetryPolicy(this.mChunkRetryCount);
        do {
            Throwable doDownload = doDownload(this.mPcdnChunkUrlPolicy.obtainUrl(), this.mPcdnChunkUrlPolicy.isPCDN());
            if (doDownload == null) {
                return;
            }
            if (!this.mPcdnRetryPolicy.canRetry(true)) {
                if (checkStop()) {
                    return;
                }
                this.mDownloadChunkCallback.onError(doDownload);
                return;
            }
        } while (!checkStop());
    }

    private Throwable doDownload(String str, boolean z) {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "Before Url:" + str + " isPcdn:" + z + " index:" + this.mPcdnChunk.mIndex);
        }
        this.mPcdnStats.beforeDownload(str, z);
        List<HttpHeader> buildRequestHeader = buildRequestHeader(this.mPcdnChunk.mStartOffset, this.mPcdnChunk.mEndOffset, true);
        long j = (this.mPcdnChunk.mEndOffset - this.mPcdnChunk.mStartOffset) + 1;
        try {
            this.mHttpConnection = sendRequest(str, buildRequestHeader, this.mPcdnChunk.mStartOffset);
            DownloadSingleResponseHandler downloadSingleResponseHandler = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, this.mPcdnChunk.mStartOffset, j, this);
            this.mSingleResponseHandler = downloadSingleResponseHandler;
            downloadSingleResponseHandler.handleResponse();
            this.mPcdnChunkProgressManager.onDownloadChunkFinish(this.mPcdnChunk.mIndex);
            th = null;
        } catch (Throwable th) {
            th = th;
            th.printStackTrace();
            this.mPcdnChunkUrlPolicy.onError();
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "OnError index:" + this.mPcdnChunk.mIndex);
            }
        }
        this.mPcdnStats.afterDownload(str, this.mPcdnChunk.mStartOffset, z, checkStop(), this.mHttpConnection, this.mSingleResponseHandler, th);
        DownloadSingleResponseHandler downloadSingleResponseHandler2 = this.mSingleResponseHandler;
        if (downloadSingleResponseHandler2 != null) {
            this.mPcdnChunk.mStartOffset = downloadSingleResponseHandler2.getCurOffset();
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "After Url:" + str + " isPcdn:" + z + " index:" + this.mPcdnChunk.mIndex);
        }
        return th;
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long j) throws BaseException {
        if (this.mPcdnChunkUrlPolicy.isPCDN()) {
            this.mPcdnBandwidthSampler.addPcdnSample(j);
        }
        return this.mPcdnChunkProgressManager.onProgress(this.mPcdnChunk.mIndex, j);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.pcdn.PCDNBandwidthSampler.LowSpeedListener
    public void onLowSpeed() {
        PCDNChunkUrlPolicy pCDNChunkUrlPolicy;
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "onLowSpeed", "Run");
        }
        PCDNRetryPolicy pCDNRetryPolicy = this.mPcdnRetryPolicy;
        if (pCDNRetryPolicy == null || !pCDNRetryPolicy.canRetry(false) || (pCDNChunkUrlPolicy = this.mPcdnChunkUrlPolicy) == null || !pCDNChunkUrlPolicy.switchToCdn()) {
            return;
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "onLowSpeed", "Run switch cdn");
        }
        closeConnection(this.mHttpConnection);
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        this.mIsStop = true;
        DownloadSingleResponseHandler downloadSingleResponseHandler = this.mSingleResponseHandler;
        if (downloadSingleResponseHandler != null) {
            downloadSingleResponseHandler.cancel();
        } else {
            closeConnection(this.mHttpConnection);
        }
        cancelThread();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        this.mIsStop = true;
        DownloadSingleResponseHandler downloadSingleResponseHandler = this.mSingleResponseHandler;
        if (downloadSingleResponseHandler != null) {
            downloadSingleResponseHandler.pause();
        } else {
            closeConnection(this.mHttpConnection);
        }
        cancelThread();
    }

    private void cancelThread() {
        try {
            this.mFuture.cancel(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean checkStop() {
        return checkTaskFinishByUser() || this.mIsStop;
    }

    public void setFuture(Future future) {
        this.mFuture = future;
    }

    public Future getFuture() {
        return this.mFuture;
    }
}
