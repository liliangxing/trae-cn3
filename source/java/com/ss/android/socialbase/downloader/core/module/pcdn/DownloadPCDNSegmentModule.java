package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.pcdn.PCDNChunkRunnableModule;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadPCDNSegmentModule extends BaseDownloadNetworkModule implements PCDNChunkRunnableModule.IDownloadChunkCallback {
    private static final String TAG = "DownloadPCDNSegmentModule";
    private int mChunkRetryCount;
    private List<PCDNChunkRunnableModule> mChunkRunnables = new CopyOnWriteArrayList();
    private int mChunkThreadCount;
    private IDownloadHttpConnection mConnection;
    private Throwable mError;
    private long mMaxChunkLength;
    private PCDNBandwidthSampler mPcdnBandwidthSampler;
    private PCDNChunkAllocater mPcdnChunkAllocater;
    private PCDNChunkProgressManager mPcdnChunkProgressManager;
    private PCDNChunkUrlPolicy mPcdnChunkUrlPolicy;
    private long mPcdnDegradeBandWidthLimit;
    private int mPcdnDegradeSampleCount;
    private PCDNStats mPcdnStats;

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        JSONObject optJSONObject = downloadCommonParams.mSetting.optJSONObject(DownloadSettingKeys.PCDN_CONFIG);
        if (optJSONObject == null) {
            return null;
        }
        if ((downloadCommonParams.mDownloadInfo.getPcdnUrls() == null || downloadCommonParams.mDownloadInfo.getPcdnUrls().isEmpty()) && (downloadCommonParams.mDownloadInfo.getCdnUrls() == null || downloadCommonParams.mDownloadInfo.getCdnUrls().isEmpty())) {
            return null;
        }
        initImpl(optJSONObject);
        return super.init(downloadCommonParams);
    }

    private void initImpl(JSONObject jSONObject) {
        this.mMaxChunkLength = jSONObject.optLong(DownloadSettingKeys.PCDNConfig.MAX_CHUNK_LENGTH);
        this.mChunkThreadCount = jSONObject.optInt("thread_count");
        this.mChunkRetryCount = jSONObject.optInt(DownloadSettingKeys.PCDNConfig.CHUNK_RETRY_COUNT);
        this.mPcdnDegradeBandWidthLimit = jSONObject.optLong(DownloadSettingKeys.PCDNConfig.PCDN_DEGRADE_BANDWIDTH_LIMIT);
        int optInt = jSONObject.optInt(DownloadSettingKeys.PCDNConfig.PCDN_DEGRADE_SAMPLE_COUNT);
        this.mPcdnDegradeSampleCount = optInt;
        if (this.mMaxChunkLength <= 0) {
            this.mMaxChunkLength = 2097152L;
        }
        if (this.mChunkThreadCount <= 0) {
            this.mChunkThreadCount = 3;
        }
        if (this.mChunkThreadCount > 6) {
            this.mChunkThreadCount = 6;
        }
        if (this.mChunkRetryCount > 20) {
            this.mChunkRetryCount = 20;
        }
        if (optInt < 3) {
            this.mPcdnDegradeSampleCount = 3;
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (hasRunNetworkProceed(iDownloadModuleChain, true)) {
            return;
        }
        try {
            checkTotalSize();
            if (checkTaskFinishByUser()) {
                return;
            }
            init();
            doDownload();
            iDownloadModuleChain.proceed();
        } catch (DownloadFileExistException e) {
            throw e;
        } catch (BaseException e2) {
            throw new DownloadPCDNException(e2.getErrorCode(), e2.getErrorMessage());
        } catch (Throwable th) {
            throw new DownloadPCDNException(1000, th.getMessage());
        }
    }

    private void checkTotalSize() throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "checkTotalSize", "Run");
        }
        long totalBytes = this.mDownloadInfo.getTotalBytes();
        if (totalBytes <= 0 || this.mCommonParams.mNeedCheckIfModified) {
            fetchTotalSize();
            totalBytes = this.mDownloadInfo.getTotalBytes();
        }
        if (totalBytes <= 0) {
            throw new BaseException(1090, "pcdn content-length empty");
        }
        checkMaxBytes(totalBytes, this.mDownloadInfo.getMaxBytes());
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "checkTotalSize", "TotalSize: " + totalBytes);
        }
    }

    private void fetchTotalSize() throws BaseException {
        boolean debugScene;
        this.mPcdnChunkUrlPolicy = new PCDNChunkUrlPolicy(this.mDownloadInfo.getPcdnUrls(), this.mDownloadInfo.getCdnUrls());
        PCDNRetryPolicy pCDNRetryPolicy = new PCDNRetryPolicy(this.mChunkRetryCount);
        String str = null;
        while (!checkTaskFinishByUser()) {
            try {
                try {
                    str = this.mPcdnChunkUrlPolicy.obtainUrl();
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "Before Url:" + str + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
                    }
                    IDownloadHttpConnection sendRequest = sendRequest(str, buildRequestHeader(this.mDownloadInfo.getStartOffset(), this.mDownloadInfo.getEndOffset(), false), this.mDownloadInfo.getStartOffset());
                    this.mConnection = sendRequest;
                    handleResponseHeader(str, 0L, sendRequest);
                    if (debugScene) {
                        return;
                    } else {
                        return;
                    }
                } catch (DownloadFileExistException e) {
                    throw e;
                }
            } catch (BaseException e2) {
                try {
                    e2.printStackTrace();
                    if (!pCDNRetryPolicy.canRetry(true)) {
                        throw e2;
                    }
                    this.mPcdnChunkUrlPolicy.onError();
                    IDownloadHttpConnection iDownloadHttpConnection = this.mConnection;
                    if (iDownloadHttpConnection != null) {
                        iDownloadHttpConnection.end();
                    }
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "After Url:" + str + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
                    }
                } finally {
                    IDownloadHttpConnection iDownloadHttpConnection2 = this.mConnection;
                    if (iDownloadHttpConnection2 != null) {
                        iDownloadHttpConnection2.end();
                    }
                    if (Logger.debugScene(this.mDownloadInfo)) {
                        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "After Url:" + str + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
                    }
                }
            }
        }
    }

    private void init() {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "init", "Run");
        }
        this.mPcdnChunkProgressManager = new PCDNChunkProgressManager(this, this.mCommonParams.mDownloadCache, this.mCommonParams.mDownloadInfo);
        this.mPcdnChunkAllocater = new PCDNChunkAllocater(this.mCommonParams.mDownloadInfo, this.mMaxChunkLength);
        this.mPcdnBandwidthSampler = new PCDNBandwidthSampler(this.mCommonParams.mDownloadInfo.getId(), this.mPcdnDegradeBandWidthLimit, this.mPcdnDegradeSampleCount);
        if (this.mPcdnStats == null) {
            this.mPcdnStats = new PCDNStats(this.mDownloadInfo, this.mChunkRetryCount);
        }
        this.mChunkRunnables.clear();
        this.mError = null;
    }

    private void doDownload() throws BaseException {
        Throwable th;
        long firstOffset = DownloadHelper.getFirstOffset(this.mDownloadInfo) + this.mDownloadInfo.getStartOffset();
        int ceil = (int) Math.ceil(((this.mDownloadInfo.getTotalBytes() - firstOffset) * 1.0d) / this.mMaxChunkLength);
        int i = this.mChunkThreadCount;
        if (ceil < i) {
            i = ceil;
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "StartOffset:" + firstOffset + " chunkCount:" + ceil + " threadCount:" + i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            PCDNChunkRunnableModule pCDNChunkRunnableModule = new PCDNChunkRunnableModule(this.mPcdnChunkProgressManager, this.mPcdnChunkAllocater, this.mPcdnBandwidthSampler, this.mPcdnStats, this.mPcdnChunkUrlPolicy, this.mChunkRetryCount, this);
            pCDNChunkRunnableModule.init(this.mCommonParams);
            pCDNChunkRunnableModule.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(pCDNChunkRunnableModule));
            this.mChunkRunnables.add(pCDNChunkRunnableModule);
        }
        Iterator<PCDNChunkRunnableModule> it = this.mChunkRunnables.iterator();
        while (it.hasNext()) {
            try {
                it.next().getFuture().get();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "ChunkRunnable End");
        }
        this.mPcdnBandwidthSampler.stopSampling();
        this.mPcdnStats.collectPCDNStats();
        if (checkTaskFinishByUser() || (th = this.mError) == null) {
            return;
        }
        if (th instanceof BaseException) {
            throw ((BaseException) th);
        }
        throw new BaseException(1000, this.mError);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.pcdn.PCDNChunkRunnableModule.IDownloadChunkCallback
    public void onError(Throwable th) {
        this.mError = th;
        cancel();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        closeConnection(this.mConnection);
        Iterator<PCDNChunkRunnableModule> it = this.mChunkRunnables.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        closeConnection(this.mConnection);
        Iterator<PCDNChunkRunnableModule> it = this.mChunkRunnables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }
}
