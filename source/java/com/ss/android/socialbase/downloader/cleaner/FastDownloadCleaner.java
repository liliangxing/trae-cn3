package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FastDownloadCleaner {
    private static final String TAG = "FastDownloadCleaner";

    public static void start() {
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FAST_DOWNLOAD_CLEAN_TEMP_PATH_DELAY_TIME_S, 0);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "start", "DelayTime: " + optInt);
        }
        if (optInt <= 0) {
            return;
        }
        DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.FastDownloadCleaner.1
            @Override // java.lang.Runnable
            public void run() {
                if (Logger.debug()) {
                    Logger.globalDebug(FastDownloadCleaner.TAG, "run", "Run");
                }
                try {
                    DownloadHelper.deleteDir(new File(DownloadDirUtils.getDownloadFastTempPath()).getParent(), String.valueOf(DownloadDirUtils.CALL_TIME));
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.globalError(FastDownloadCleaner.TAG, "run", "Exception: " + th);
                }
            }
        }, optInt, TimeUnit.SECONDS);
    }
}
