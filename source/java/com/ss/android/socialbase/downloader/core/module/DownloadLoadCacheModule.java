package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadLoadCacheModule extends AbsDownloadModule {
    private static final String TAG = "DownloadLoadCacheModule";

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
        checkFileName();
        doLoadCache();
        if (checkTaskFinishByUser()) {
            return;
        }
        iDownloadModuleChain.proceed();
    }

    private void checkFileName() throws BaseException {
        if (this.mSetting.optInt(DownloadSettingKeys.FIX_VULNERABILITY_FILE_NAME, 1) > 0 && !TextUtils.isEmpty(this.mDownloadInfo.getName()) && this.mDownloadInfo.getName().contains(DownloadConstants.VULNERABILITY_PATH)) {
            throw new BaseException(1093, "File name error:" + this.mDownloadInfo.getName());
        }
    }

    private void doLoadCache() {
        int id = this.mDownloadInfo.getId();
        boolean ensureDownloadCacheSyncSuccess = this.mDownloadCache.ensureDownloadCacheSyncSuccess();
        DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(id);
        if (downloadInfo == null && (!ensureDownloadCacheSyncSuccess || DownloadHelper.hitSkipDbInitScene(DownloadHelper.getSkipDbInitSceneSet(), DownloadHelper.getSkipDbInitExpectMimeTypeSet(), DownloadHelper.getDbInitSceneSet(), this.mDownloadInfo.getMimeType(), this.mDownloadInfo.getMonitorScene()))) {
            downloadInfo = ((DefaultDownloadCache) this.mDownloadCache).getSqlDownloadCache().getDownloadInfo(id);
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "Find Cache:" + ensureDownloadCacheSyncSuccess + "CacheDownloadInfo" + downloadInfo);
        }
        boolean z = true;
        if (downloadInfo == null || downloadInfo.isNewTask() || downloadInfo.isForce() || this.mDownloadInfo.getStartOffset() != downloadInfo.getStartOffset() || this.mDownloadInfo.getEndOffset() != downloadInfo.getEndOffset()) {
            this.mDownloadInfo.reset();
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "Download reset");
            }
        } else {
            this.mDownloadInfo.copyFromCacheData(downloadInfo, true);
            if (this.mSetting.optInt(DownloadSettingKeys.ENABLE_REPLACE_EXTERNAL_PATH) > 0 && TextUtils.isEmpty(this.mDownloadInfo.getMd5()) && !TextUtils.isEmpty(downloadInfo.getMd5())) {
                this.mDownloadInfo.setMd5(downloadInfo.getMd5());
            }
            boolean z2 = downloadInfo != this.mDownloadInfo;
            if (this.mDownloadInfo.getSavePath().equals(downloadInfo.getSavePath()) && downloadInfo.isDownloaded()) {
                this.mCommonParams.mExistTargetFileName = downloadInfo.getName();
                this.mCommonParams.mExistTargetFilePath = downloadInfo.getSavePath();
            } else if (DownloadComponentManager.getDownloadId(downloadInfo) != id) {
                this.mDownloadCache.removeDownloadTaskData(id);
            }
            z = z2;
        }
        if (z) {
            this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "After load:" + this.mDownloadInfo);
        }
    }
}
