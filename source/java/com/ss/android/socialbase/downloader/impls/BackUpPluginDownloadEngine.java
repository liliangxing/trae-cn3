package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackUpPluginDownloadEngine {
    private static final int NORMAL_PLUGIN_POOL_SIZE = 2;
    private static final int PLUGIN_POOL_KEEP_ALIVE_TIME = 15;
    private static final String TAG = "BackUpPluginDownloadEngine";
    private ThreadPoolExecutor mBackUpPluginImmediateExecutor;
    private ThreadPoolExecutor mBackUpPluginNormalExecutor;
    private AbsDownloadEngine mDownloadEngine = DownloadComponentManager.getDownloadEngine();

    public BackUpPluginDownloadEngine() {
        long j = 15;
        this.mBackUpPluginImmediateExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, j, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-bi-plugin", true)) { // from class: com.ss.android.socialbase.downloader.impls.BackUpPluginDownloadEngine.1
            {
                try {
                    allowCoreThreadTimeOut(true);
                } catch (Throwable th) {
                    Logger.globalError(BackUpPluginDownloadEngine.TAG, "allowCoreThreadTimeOut", "Error1:" + th);
                }
            }
        };
        this.mBackUpPluginNormalExecutor = new ThreadPoolExecutor(2, 2, j, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-bn-plugin", true)) { // from class: com.ss.android.socialbase.downloader.impls.BackUpPluginDownloadEngine.2
            {
                try {
                    allowCoreThreadTimeOut(true);
                } catch (Throwable th) {
                    Logger.globalError(BackUpPluginDownloadEngine.TAG, "allowCoreThreadTimeOut", "Error2:" + th);
                }
            }
        };
    }

    public void download(DownloadTask downloadTask) {
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        downloadInfo.safePutToDBJsonData(DownloadSettingKeys.FIX_TASK_REPETITION, 1);
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "download", "Run type:" + downloadInfo.getEnqueueType().ordinal());
        }
        this.mDownloadEngine.doDownload(downloadTask);
    }

    public ExecutorService getPluginExecutor(EnqueueType enqueueType) {
        return enqueueType == EnqueueType.NEW_ENQUEUE_IMMEDIATE ? this.mBackUpPluginImmediateExecutor : this.mBackUpPluginNormalExecutor;
    }
}
