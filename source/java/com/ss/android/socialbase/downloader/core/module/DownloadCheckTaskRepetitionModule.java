package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckTaskRepetitionModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckTaskRepetitionModule";
    private static Object mLock = new Object();
    private static Set mDownloadingIdSet = new HashSet();

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (downloadCommonParams.mSetting.optInt(DownloadSettingKeys.FIX_TASK_REPETITION) > 0) {
            return super.init(downloadCommonParams);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        int id = this.mDownloadInfo.getId();
        synchronized (mLock) {
            if (mDownloadingIdSet.contains(Integer.valueOf(id))) {
                Logger.taskError(TAG, id, "proceed", "Repetitive task");
                return;
            }
            mDownloadingIdSet.add(Integer.valueOf(id));
            try {
                iDownloadModuleChain.proceed();
                synchronized (mLock) {
                    mDownloadingIdSet.remove(Integer.valueOf(id));
                }
            } catch (Throwable th) {
                synchronized (mLock) {
                    mDownloadingIdSet.remove(Integer.valueOf(id));
                    throw th;
                }
            }
        }
    }
}
