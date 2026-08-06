package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Cleaner {
    private static final String TAG = "Cleaner";
    private volatile CleanerConfig mCleanerConfig = new CleanerConfig();
    private static AtomicBoolean mIsRunCleaner = new AtomicBoolean();
    private static volatile Cleaner INSTANCE = null;

    public static Cleaner getInstance() {
        if (INSTANCE == null) {
            synchronized (Cleaner.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Cleaner();
                }
            }
        }
        return INSTANCE;
    }

    public void init() {
        long currentTimeMillis = Logger.debug() ? System.currentTimeMillis() : 0L;
        this.mCleanerConfig.init();
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "init", "Cleaner init cost time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean isExistInCleanSet(int i) {
        if (i == 0) {
            return false;
        }
        return this.mCleanerConfig.isExistInCleanSet(i);
    }

    public void removeFromCleanSet(int i) {
        this.mCleanerConfig.removeFromCleanDownloadIdSet(i);
    }

    public void start() {
        start(false);
    }

    public void start(boolean z) {
        if (mIsRunCleaner.compareAndSet(false, true)) {
            startImpl(z);
        }
    }

    private void startImpl(boolean z) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "start", "enter Cleaner start");
        }
        if (!DownloadHelper.isMainProcess()) {
            this.mCleanerConfig.finish();
            return;
        }
        FastDownloadCleaner.start();
        CacheStatistics.start(this.mCleanerConfig);
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.START_CLEAN_DELAY_TIME_S);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "run", "Run cleaner startCleanDelayTime: " + optInt + " isCacheCleanEnabled:" + this.mCleanerConfig.isCacheCleanEnabled());
        }
        if (optInt <= 0 || !this.mCleanerConfig.isCacheCleanEnabled()) {
            this.mCleanerConfig.finish();
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.Cleaner.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new CleanerImpl(Cleaner.this.mCleanerConfig).startSync();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        };
        if (z) {
            runnable.run();
        } else {
            DownloadComponentManager.submitScheduleTask(runnable, optInt, TimeUnit.SECONDS);
        }
    }

    public boolean isNeedClean() {
        return this.mCleanerConfig.isNeedClean();
    }

    public boolean updateCleanDownloadId(DownloadInfo downloadInfo) {
        return updateCleanDownloadId(new CleanDownloadInfo(downloadInfo));
    }

    public boolean forceUpdateCleanDownloadId(DownloadInfo downloadInfo, boolean z) {
        return forceUpdateCleanDownloadId(new CleanDownloadInfo(downloadInfo), z);
    }

    public boolean updateCleanDownloadId(CleanDownloadInfo cleanDownloadInfo) {
        return this.mCleanerConfig.updateCleanDownloadId(cleanDownloadInfo);
    }

    public boolean forceUpdateCleanDownloadId(CleanDownloadInfo cleanDownloadInfo, boolean z) {
        return this.mCleanerConfig.forceUpdateCleanDownloadId(cleanDownloadInfo, z);
    }

    public CacheKeyCleaner getCacheKeyCleaner() {
        return new CacheKeyCleaner(null, this.mCleanerConfig);
    }

    public CleanerConfig getCleanerConfig() {
        return this.mCleanerConfig;
    }
}
