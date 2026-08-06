package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PluginDownloadEngine {
    private static volatile PluginDownloadEngine mInstance;
    private static volatile IDownloadPluginDegradeListener sDownloadPluginDegradeListener;
    private static volatile boolean sUsingBackupEngine;
    private CorePluginDownloadEngine mCorePluginDownloadEngine = new CorePluginDownloadEngine();
    private BackUpPluginDownloadEngine mBackUpPluginDownloadEngine = new BackUpPluginDownloadEngine();

    private PluginDownloadEngine() {
    }

    public static PluginDownloadEngine getInstance() {
        if (mInstance == null) {
            synchronized (PluginDownloadEngine.class) {
                if (mInstance == null) {
                    mInstance = new PluginDownloadEngine();
                }
            }
        }
        return mInstance;
    }

    public void download(DownloadTask downloadTask) {
        if (sUsingBackupEngine) {
            this.mBackUpPluginDownloadEngine.download(downloadTask);
        } else {
            this.mCorePluginDownloadEngine.download(downloadTask);
        }
    }

    public ExecutorService getPluginExecutor(EnqueueType enqueueType) {
        return sUsingBackupEngine ? this.mBackUpPluginDownloadEngine.getPluginExecutor(enqueueType) : this.mCorePluginDownloadEngine.getPluginExecutor();
    }

    public static void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener) {
        if (iDownloadPluginDegradeListener == null) {
            return;
        }
        sDownloadPluginDegradeListener = iDownloadPluginDegradeListener;
    }

    public static IDownloadPluginDegradeListener getDownloadPluginDegradeListener() {
        return sDownloadPluginDegradeListener;
    }

    public static boolean isEnabledDownloadPluginOpt(DownloadInfo downloadInfo) {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.ENABLE_PLUGIN_DOWNLOAD_OPT) > 0 && (downloadInfo.getEnqueueType() == EnqueueType.NEW_ENQUEUE_NORMAL || downloadInfo.getEnqueueType() == EnqueueType.NEW_ENQUEUE_IMMEDIATE);
    }

    public static boolean isBackupEngine() {
        return sUsingBackupEngine;
    }

    public static void setBackupEngine(boolean z) {
        sUsingBackupEngine = z;
    }
}
