package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadThreadPool {
    private static String TAG = "DownloadThreadPool";
    private Map<Integer, DownloadRunnable> downloadRunnablePool = new ConcurrentHashMap();
    private AtomicInteger clearTimes = new AtomicInteger(0);

    public Future execute(DownloadRunnable downloadRunnable) {
        downloadRunnable.prepareDownload();
        if (this.clearTimes.compareAndSet(MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE, 0)) {
            clearRunnableNotAlive();
        }
        this.clearTimes.incrementAndGet();
        this.downloadRunnablePool.put(Integer.valueOf(downloadRunnable.getDownloadId()), downloadRunnable);
        DownloadTask downloadTask = downloadRunnable.getDownloadTask();
        try {
            downloadTask.getTimingInfo().beforeThreadExecuteTime = System.currentTimeMillis();
            ExecutorService downloadExecutorService = getDownloadExecutorService(downloadRunnable);
            if (Logger.debugScene(downloadRunnable.getDownloadInfo())) {
                Logger.taskDebug(TAG, downloadRunnable.getDownloadInfo(), "execute", "Executor:" + downloadExecutorService);
            }
            Future<?> submit = downloadExecutorService.submit(downloadRunnable);
            downloadRunnable.setFuture(submit);
            return submit;
        } catch (Exception e) {
            Logger.taskError(TAG, downloadRunnable.getDownloadId(), "execute", "Error:" + e);
            if (downloadTask != null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(e, "DownloadThreadPoolExecute")), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
            e.printStackTrace();
            return null;
        }
    }

    private void clearRunnableNotAlive() {
        Iterator<Map.Entry<Integer, DownloadRunnable>> it = this.downloadRunnablePool.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isAlive()) {
                it.remove();
            }
        }
    }

    public void removeUnAliveDownloadRunnable(DownloadRunnable downloadRunnable) {
        if (downloadRunnable == null) {
            return;
        }
        Iterator<Map.Entry<Integer, DownloadRunnable>> it = this.downloadRunnablePool.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == downloadRunnable) {
                it.remove();
                return;
            }
        }
    }

    public boolean containsTask(int i) {
        DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(Integer.valueOf(i));
        return downloadRunnable != null && downloadRunnable.isAlive();
    }

    public DownloadRunnable cancel(int i) {
        clearRunnableNotAlive();
        DownloadRunnable remove = this.downloadRunnablePool.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.cancel();
            removeFromThreadPool(remove);
        }
        return remove;
    }

    public void pause(int i, boolean z) {
        clearRunnableNotAlive();
        DownloadRunnable remove = this.downloadRunnablePool.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.pause();
            if (z) {
                removeFromThreadPool(remove);
            }
        }
    }

    private void removeFromThreadPool(DownloadRunnable downloadRunnable) {
        if (downloadRunnable == null) {
            return;
        }
        try {
            ExecutorService downloadExecutorService = getDownloadExecutorService(downloadRunnable);
            if (downloadExecutorService instanceof ThreadPoolExecutor) {
                ((ThreadPoolExecutor) downloadExecutorService).remove(downloadRunnable);
                Future future = downloadRunnable.getFuture();
                if (future != null) {
                    future.cancel(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ExecutorService getDownloadExecutorService(DownloadRunnable downloadRunnable) {
        try {
            try {
                DownloadInfo downloadInfo = downloadRunnable.getDownloadTask().getDownloadInfo();
                ExecutorService fastThreadExecutor = downloadInfo.isFastDownload() ? DownloadComponentManager.getFastThreadExecutor() : null;
                if (fastThreadExecutor == null) {
                    int executorGroup = downloadInfo.getExecutorGroup();
                    if (executorGroup == 3) {
                        fastThreadExecutor = DownloadComponentManager.getMixFrequentThreadExecutor();
                    } else if (executorGroup == 4) {
                        fastThreadExecutor = DownloadComponentManager.getMixApkThreadExecutor();
                    } else if (executorGroup == 7) {
                        fastThreadExecutor = DownloadComponentManager.getCustomThreadExecutor();
                    }
                }
                if (fastThreadExecutor == null && canUseSegmentThreadPool(downloadInfo, downloadRunnable)) {
                    fastThreadExecutor = DownloadComponentManager.getSegmentDownloadThreadExecutorService();
                }
                if (fastThreadExecutor == null && PluginDownloadEngine.isEnabledDownloadPluginOpt(downloadInfo)) {
                    fastThreadExecutor = PluginDownloadEngine.getInstance().getPluginExecutor(downloadInfo.getEnqueueType());
                }
                if (fastThreadExecutor != null) {
                    return fastThreadExecutor;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (0 != 0) {
                    return null;
                }
            }
            return DownloadComponentManager.getMixDefaultThreadExecutor();
        } catch (Throwable th) {
            if (0 == 0) {
                DownloadComponentManager.getMixDefaultThreadExecutor();
            }
            throw th;
        }
    }

    private boolean canUseSegmentThreadPool(DownloadInfo downloadInfo, DownloadRunnable downloadRunnable) {
        if (downloadInfo.getExpectFileLength() <= 0) {
            return false;
        }
        JSONObject optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
        long optLong = optJSONObject != null ? optJSONObject.optLong(DownloadSettingKeys.SegmentConfig.EXPECT_MIN_DOWNLOAD_SIZE) : 0L;
        if (optLong < 104857600) {
            return false;
        }
        if (downloadInfo.getExpectFileLength() > optLong) {
            return true;
        }
        downloadRunnable.setEnableSegmentDownload(false);
        return false;
    }

    public List<Integer> getAllAliveDownloadIds() {
        clearRunnableNotAlive();
        return new ArrayList(this.downloadRunnablePool.keySet());
    }

    public void setThrottleNetSpeed(int i, long j, int i2) {
        DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(Integer.valueOf(i));
        if (downloadRunnable != null) {
            downloadRunnable.setThrottleNetSpeed(j, i2);
        }
    }
}
