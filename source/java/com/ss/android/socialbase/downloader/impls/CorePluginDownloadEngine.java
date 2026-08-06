package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CorePluginDownloadEngine implements IDownloadTaskExecuteListener {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final String MONITOR_SCENE = "morpheus_plugin_download";
    private static final String TAG = "CorePluginDownloadEngine";
    private int mDegradeTimeout;
    private AbsDownloadEngine mDownloadEngine;
    private Queue<PluginInfo> mDownloadingPluginQueue;
    private Map<Integer, Future> mFutureTaskRecords;
    private AtomicInteger mIndex;
    private Future mMonitorFuture;
    private ThreadPoolExecutor mPluginExecutor;
    private int mPluginPoolSize = getPluginThreadPoolSize();
    private volatile boolean mRegisterTaskListener;
    private ThreadPoolExecutor mSingleOPExecutor;
    private Set<Integer> mStartDownloadId;
    private Queue<PluginInfo> mWaitingPluginQueue;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener
    public void onFinish(DownloadTask downloadTask, int i) {
    }

    public CorePluginDownloadEngine() {
        int i = this.mPluginPoolSize;
        this.mPluginExecutor = new ThreadPoolExecutor(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-plugin", true)) { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.1
            {
                try {
                    allowCoreThreadTimeOut(true);
                } catch (Throwable th) {
                    Logger.globalError(CorePluginDownloadEngine.TAG, "allowCoreThreadTimeOut", "Error1:" + th);
                }
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void afterExecute(final Runnable runnable, final Throwable th) {
                if (Logger.debug()) {
                    Logger.globalDebug(CorePluginDownloadEngine.TAG, "afterExecute", "Runnable:" + runnable + " Error:" + th);
                }
                CorePluginDownloadEngine.this.runWithSingleOPExecutor(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Logger.debug()) {
                            Logger.globalDebug(CorePluginDownloadEngine.TAG, "afterExecute_run", "Runnable:" + runnable + " Error:" + th);
                        }
                        Iterator it = CorePluginDownloadEngine.this.mFutureTaskRecords.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            Future future = (Future) entry.getValue();
                            if (future != null && future.isDone()) {
                                it.remove();
                                CorePluginDownloadEngine.this.tryDownloadNext(((Integer) entry.getKey()).intValue());
                                return;
                            }
                        }
                        CorePluginDownloadEngine.this.degradeBackupDownloadEngine("Plugin State Error:" + CorePluginDownloadEngine.this.mFutureTaskRecords.size());
                    }
                });
            }
        };
        this.mSingleOPExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-plugin-single", true)) { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.2
            {
                try {
                    allowCoreThreadTimeOut(true);
                } catch (Throwable th) {
                    Logger.globalError(CorePluginDownloadEngine.TAG, "allowCoreThreadTimeOut", "Error2:" + th);
                }
            }
        };
        this.mDownloadEngine = DownloadComponentManager.getDownloadEngine();
        this.mDownloadingPluginQueue = new PriorityQueue(11, new Comparator<PluginInfo>() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.3
            @Override // java.util.Comparator
            public int compare(PluginInfo pluginInfo, PluginInfo pluginInfo2) {
                return CorePluginDownloadEngine.this.compareImpl(pluginInfo, pluginInfo2);
            }
        });
        this.mWaitingPluginQueue = new PriorityQueue(11, new Comparator<PluginInfo>() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.4
            @Override // java.util.Comparator
            public int compare(PluginInfo pluginInfo, PluginInfo pluginInfo2) {
                return CorePluginDownloadEngine.this.compareImpl(pluginInfo2, pluginInfo);
            }
        });
        this.mIndex = new AtomicInteger();
        this.mFutureTaskRecords = new HashMap();
        this.mRegisterTaskListener = false;
        this.mDegradeTimeout = getPluginDegradeTimeout();
        this.mStartDownloadId = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class PluginInfo {
        DownloadTask mDownloadTask;
        int mId;
        int mIndex;
        int mType;

        private PluginInfo() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.mId == ((PluginInfo) obj).mId;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mId));
        }

        public String toString() {
            return "PluginInfo{type=" + this.mType + ", index=" + this.mIndex + ", id=" + this.mId + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compareImpl(PluginInfo pluginInfo, PluginInfo pluginInfo2) {
        int compare = Integer.compare(pluginInfo.mType, pluginInfo2.mType);
        if (compare != 0) {
            return compare;
        }
        if (pluginInfo.mType == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
            return Integer.compare(pluginInfo2.mIndex, pluginInfo.mIndex);
        }
        return Integer.compare(pluginInfo.mIndex, pluginInfo2.mIndex);
    }

    public void download(final DownloadTask downloadTask) {
        runWithSingleOPExecutor(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.5
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                int id = downloadInfo.getId();
                int ordinal = downloadInfo.getEnqueueType().ordinal();
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "Run type:" + ordinal + " Before DownloadingPluginQueueSize:" + CorePluginDownloadEngine.this.mDownloadingPluginQueue.size() + " WaitingPluginQueueSize:" + CorePluginDownloadEngine.this.mWaitingPluginQueue.size());
                    Iterator it = CorePluginDownloadEngine.this.mDownloadingPluginQueue.iterator();
                    while (it.hasNext()) {
                        Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "Before DownloadingPlugin:" + ((PluginInfo) it.next()));
                    }
                    Iterator it2 = CorePluginDownloadEngine.this.mWaitingPluginQueue.iterator();
                    while (it2.hasNext()) {
                        Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "Before WaitingPlugin:" + ((PluginInfo) it2.next()));
                    }
                }
                CorePluginDownloadEngine.this.downloadImpl(id, ordinal, downloadTask, downloadInfo);
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "After DownloadingPluginQueueSize:" + CorePluginDownloadEngine.this.mDownloadingPluginQueue.size() + " WaitingPluginQueueSize:" + CorePluginDownloadEngine.this.mWaitingPluginQueue.size());
                    Iterator it3 = CorePluginDownloadEngine.this.mDownloadingPluginQueue.iterator();
                    while (it3.hasNext()) {
                        Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "After DownloadingPlugin:" + ((PluginInfo) it3.next()));
                    }
                    Iterator it4 = CorePluginDownloadEngine.this.mWaitingPluginQueue.iterator();
                    while (it4.hasNext()) {
                        Logger.taskDebug(CorePluginDownloadEngine.TAG, downloadInfo, "download", "After WaitingPlugin:" + ((PluginInfo) it4.next()));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadImpl(int i, int i2, DownloadTask downloadTask, DownloadInfo downloadInfo) {
        startMonitor(i, i2);
        PluginInfo findPlugin = findPlugin(this.mDownloadingPluginQueue, i);
        if (findPlugin != null) {
            if (i2 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) {
                if (findPlugin.mType == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
                    findPlugin.mType = i2;
                } else {
                    findPlugin.mIndex = this.mIndex.incrementAndGet();
                }
                this.mDownloadingPluginQueue.remove(findPlugin);
                this.mDownloadingPluginQueue.add(findPlugin);
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "In DownloadingQueue reorder");
                    return;
                }
                return;
            }
            return;
        }
        PluginInfo findPlugin2 = findPlugin(this.mWaitingPluginQueue, i);
        if (this.mDownloadingPluginQueue.size() >= this.mPluginPoolSize) {
            if (findPlugin2 != null) {
                if (i2 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
                    if (Logger.debugScene(downloadInfo)) {
                        Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "In WaitingQueue wait");
                        return;
                    }
                    return;
                }
                findPlugin2.mType = i2;
                findPlugin2.mIndex = this.mIndex.incrementAndGet();
                this.mWaitingPluginQueue.remove(findPlugin2);
                this.mWaitingPluginQueue.add(findPlugin2);
                PluginInfo poll = this.mDownloadingPluginQueue.poll();
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "Pause:" + poll.mId + " Move WaitingQueue");
                }
                doPause(poll);
                return;
            }
            PluginInfo pluginInfo = new PluginInfo();
            pluginInfo.mId = i;
            pluginInfo.mType = i2;
            pluginInfo.mIndex = this.mIndex.incrementAndGet();
            pluginInfo.mDownloadTask = downloadTask;
            if (i2 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "Add WaitingQueue");
                }
                this.mWaitingPluginQueue.add(pluginInfo);
                return;
            } else {
                this.mWaitingPluginQueue.add(pluginInfo);
                PluginInfo poll2 = this.mDownloadingPluginQueue.poll();
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "Pause:" + poll2.mId + " Add WaitingQueue");
                }
                doPause(poll2);
                return;
            }
        }
        if (this.mWaitingPluginQueue.isEmpty() && !this.mFutureTaskRecords.containsKey(Integer.valueOf(downloadTask.getDownloadId()))) {
            PluginInfo pluginInfo2 = new PluginInfo();
            pluginInfo2.mId = i;
            pluginInfo2.mType = i2;
            pluginInfo2.mIndex = this.mIndex.incrementAndGet();
            pluginInfo2.mDownloadTask = downloadTask;
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "New doDownload");
            }
            doDownload(pluginInfo2);
            return;
        }
        if (findPlugin2 != null) {
            if (i2 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) {
                if (findPlugin2.mType == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
                    findPlugin2.mType = i2;
                } else {
                    findPlugin2.mIndex = this.mIndex.incrementAndGet();
                }
                this.mWaitingPluginQueue.remove(findPlugin2);
                this.mWaitingPluginQueue.add(findPlugin2);
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "Update Waiting Queue");
                    return;
                }
                return;
            }
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "downloadImpl", "In Waiting Queue");
                return;
            }
            return;
        }
        PluginInfo pluginInfo3 = new PluginInfo();
        pluginInfo3.mId = i;
        pluginInfo3.mType = i2;
        pluginInfo3.mIndex = this.mIndex.incrementAndGet();
        pluginInfo3.mDownloadTask = downloadTask;
        this.mWaitingPluginQueue.add(pluginInfo3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener
    public void onStart(DownloadTask downloadTask, int i) {
        this.mStartDownloadId.add(Integer.valueOf(downloadTask.getDownloadId()));
    }

    private void startMonitor(final int i, int i2) {
        if (Logger.debugScene(MONITOR_SCENE)) {
            Logger.taskDebug(TAG, i, "startMonitor", "Run");
        }
        if (this.mDegradeTimeout <= 0 || i2 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal() || this.mStartDownloadId.contains(Integer.valueOf(i))) {
            if (Logger.debugScene(MONITOR_SCENE)) {
                Logger.taskDebug(TAG, i, "startMonitor", "Return");
                return;
            }
            return;
        }
        if (Logger.debugScene(MONITOR_SCENE)) {
            Logger.taskDebug(TAG, i, "startMonitor", "Real DegradeTimeout:" + this.mDegradeTimeout);
        }
        Future future = this.mMonitorFuture;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                Logger.taskError(TAG, i, "startMonitor", "Error:" + th);
            }
        }
        if (!this.mRegisterTaskListener) {
            this.mRegisterTaskListener = true;
            DownloadComponentManager.registerDownloadTaskExecuteListener(this);
        }
        final Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.6
            @Override // java.lang.Runnable
            public void run() {
                if (!CorePluginDownloadEngine.this.mRegisterTaskListener || CorePluginDownloadEngine.this.mStartDownloadId.contains(Integer.valueOf(i))) {
                    if (CorePluginDownloadEngine.this.mWaitingPluginQueue.isEmpty() && CorePluginDownloadEngine.this.mDownloadingPluginQueue.isEmpty()) {
                        if (Logger.debugScene(CorePluginDownloadEngine.MONITOR_SCENE)) {
                            Logger.taskDebug(CorePluginDownloadEngine.TAG, i, CorePluginDownloadEngine.MONITOR_SCENE, "startMonitor_run", "Stop Monitor", false);
                        }
                        CorePluginDownloadEngine.this.stopMonitor();
                        return;
                    }
                    return;
                }
                CorePluginDownloadEngine.this.degradeBackupDownloadEngine("Start download timeout, Id:" + i);
            }
        };
        this.mMonitorFuture = DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.CorePluginDownloadEngine.7
            @Override // java.lang.Runnable
            public void run() {
                CorePluginDownloadEngine.this.runWithSingleOPExecutor(runnable);
            }
        }, this.mDegradeTimeout, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMonitor() {
        if (this.mRegisterTaskListener) {
            this.mRegisterTaskListener = false;
            DownloadComponentManager.unRegisterDownloadTaskExecuteListener(this);
            this.mStartDownloadId.clear();
        }
    }

    private PluginInfo findPlugin(Collection<PluginInfo> collection, int i) {
        for (PluginInfo pluginInfo : collection) {
            if (pluginInfo.mId == i) {
                return pluginInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDownloadNext(int i) {
        Future future;
        PluginInfo pluginInfo = new PluginInfo();
        pluginInfo.mId = i;
        this.mDownloadingPluginQueue.remove(pluginInfo);
        if (this.mDownloadingPluginQueue.size() >= this.mPluginPoolSize) {
            if (Logger.debugScene(MONITOR_SCENE)) {
                Logger.taskDebug(TAG, i, MONITOR_SCENE, "tryDownloadNext", "DownloadingPluginQueue full", false);
                return;
            }
            return;
        }
        if (this.mWaitingPluginQueue.isEmpty() && this.mDownloadingPluginQueue.isEmpty() && (future = this.mMonitorFuture) != null && future.isDone()) {
            if (Logger.debugScene(MONITOR_SCENE)) {
                Logger.taskDebug(TAG, i, MONITOR_SCENE, "tryDownloadNext", "Stop Monitor", false);
            }
            stopMonitor();
            return;
        }
        Iterator<PluginInfo> it = this.mWaitingPluginQueue.iterator();
        while (it.hasNext()) {
            PluginInfo next = it.next();
            if (!this.mFutureTaskRecords.containsKey(Integer.valueOf(next.mId))) {
                it.remove();
                if (Logger.debugScene(MONITOR_SCENE)) {
                    Logger.taskDebug(TAG, i, MONITOR_SCENE, "tryDownloadNext", "Remove " + i + " Try doDownload:" + next, false);
                }
                doDownload(next);
                return;
            }
        }
    }

    private void doDownload(PluginInfo pluginInfo) {
        this.mDownloadingPluginQueue.add(pluginInfo);
        this.mFutureTaskRecords.put(Integer.valueOf(pluginInfo.mId), this.mDownloadEngine.doDownload(pluginInfo.mDownloadTask));
    }

    private void doPause(PluginInfo pluginInfo) {
        this.mWaitingPluginQueue.add(pluginInfo);
        this.mDownloadEngine.doPause(pluginInfo.mId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void degradeBackupDownloadEngine(String str) {
        if (PluginDownloadEngine.isBackupEngine()) {
            return;
        }
        IDownloadPluginDegradeListener downloadPluginDegradeListener = PluginDownloadEngine.getDownloadPluginDegradeListener();
        if (downloadPluginDegradeListener != null) {
            downloadPluginDegradeListener.onDegrade(str);
        }
        Logger.globalError(TAG, "degradeBackupDownloadEngine", "Error:" + str);
        DownloadMonitorHelper.monitorDownloadOtherError(new Throwable(str));
        PluginDownloadEngine.setBackupEngine(true);
        Logger.globalError(TAG, "degradeBackupDownloadEngine", "Stop Monitor");
        stopMonitor();
    }

    private int getPluginThreadPoolSize() {
        int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PLUGIN_THREAD_POOL_SIZE, 2);
        int i = optInt > 0 ? optInt : 2;
        if (Logger.debugScene(MONITOR_SCENE)) {
            Logger.globalDebug(TAG, "getPluginThreadPoolSize", "Size:" + i);
        }
        return i;
    }

    private int getPluginDegradeTimeout() {
        int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PLUGIN_DEGRADE_BACKUP_TIMEOUT_S);
        if (optInt <= 0) {
            optInt = 30;
        }
        if (Logger.debugScene(MONITOR_SCENE)) {
            Logger.globalDebug(TAG, "getPluginDegradeTimeout", "Time:" + optInt);
        }
        return optInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runWithSingleOPExecutor(Runnable runnable) {
        this.mSingleOPExecutor.execute(runnable);
    }

    public ExecutorService getPluginExecutor() {
        return this.mPluginExecutor;
    }
}
