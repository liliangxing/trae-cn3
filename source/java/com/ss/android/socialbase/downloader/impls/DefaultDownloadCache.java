package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p005db.EmptySqlDownloadCache;
import com.ss.android.socialbase.downloader.p005db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.p005db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private int bizCloseDBBatchInit;
    private final DownloadCache downloadCache;
    private volatile boolean hasInitSqlDownloadCache;
    private int loadDBWaitTime;
    private boolean mThreadLoadDownloadCacheOnlyOnce;
    private ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;
    private static AtomicBoolean isRunInit = new AtomicBoolean(false);
    private static AtomicBoolean isInitFinish = new AtomicBoolean(false);
    private ThreadLocal<Boolean> mThreadDownloadCacheLoaded = new ThreadLocal<>();
    private WeakDownloadHandler.IHandler IHandler = new WeakDownloadHandler.IHandler() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1
        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message.what == 1) {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DefaultDownloadCache.this.resumeUnCompleteTask();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };

    public DefaultDownloadCache() {
        this.mThreadLoadDownloadCacheOnlyOnce = false;
        this.weakHandler = null;
        if (DownloadUtils.isMultiProcessNoDBMode() && !DownloadHelper.isMainProcess()) {
            this.sqlDownloadCache = new EmptySqlDownloadCache();
        } else if (DownloadHelper.isMainProcess() || !DownloadComponentManager.supportMultiProc()) {
            this.sqlDownloadCache = new SqlDownloadCache();
        } else {
            DownloadComponentManager.IndependentHolderCreator independentHolderCreator = DownloadComponentManager.getIndependentHolderCreator();
            if (independentHolderCreator != null) {
                this.sqlDownloadCache = independentHolderCreator.createCache(new DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.2
                    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener
                    public void onRebindError() {
                        DefaultDownloadCache.this.sqlDownloadCache = new SqlDownloadCache();
                        Logger.globalError(DefaultDownloadCache.TAG, "onRebindError", "Rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.sqlDownloadCache = new SqlDownloadCache();
            }
        }
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        boolean z = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE, 0) > 0 || DownloadHelper.getCacheSettingInt(DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE) > 0;
        if (z) {
            Logger.alogE(TAG, "Construct enableLru");
        } else {
            Logger.alogE(TAG, "Construct disableLru:" + Log.getStackTraceString(new Throwable("LruConstruct")));
        }
        if ((z || DownloadComponentManager.isEnableLruCache()) && !(this.sqlDownloadCache instanceof EmptySqlDownloadCache)) {
            this.downloadCache = new LruDownloadCache(this.sqlDownloadCache);
        } else {
            this.downloadCache = new DownloadCache(this.sqlDownloadCache);
        }
        this.loadDBWaitTime = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.LOAD_DB_WAIT_TIME_MS, 5000);
        this.bizCloseDBBatchInit = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.BIZ_CLOSE_DB_BATCH_INIT, 0);
        this.mThreadLoadDownloadCacheOnlyOnce = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.THREAD_LOAD_DOWNLOAD_CACHE_ONLY_ONCE) > 0;
        Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.3
            @Override // java.lang.Runnable
            public void run() {
                DefaultDownloadCache.this.initImmediately();
            }
        };
        long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_INIT_DOWNLOAD_CACHE_MS);
        if (optLong > 0) {
            DownloadComponentManager.submitScheduleTask(runnable, optLong, TimeUnit.MILLISECONDS);
        } else {
            runnable.run();
        }
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i) {
        DownloadInfo onDownloadTaskStart = this.downloadCache.onDownloadTaskStart(i);
        updateDownloadInfoInDB(onDownloadTaskStart);
        return onDownloadTaskStart;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean z) {
        if (isRunInit.compareAndSet(false, true)) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "init", "Run");
            }
            DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
            final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            this.downloadCache.copyDownloadInfoMap(sparseArray);
            this.sqlDownloadCache.init(sparseArray, this.downloadCache.getUnreadDBSet(), this.downloadCache.getAutoResumeList(), this.downloadCache.getMimeTypes(), new SqlCacheLoadCompleteCallback() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.4
                @Override // com.ss.android.socialbase.downloader.p005db.SqlCacheLoadCompleteCallback
                public void callback(boolean z2) {
                    if (sparseArray != null) {
                        for (int i = 0; i < sparseArray.size(); i++) {
                            int keyAt = sparseArray.keyAt(i);
                            if (keyAt != 0) {
                                DefaultDownloadCache.this.downloadCache.addToDownloadCacheInfoMap((DownloadInfo) sparseArray.get(keyAt));
                            }
                        }
                    }
                    if (Logger.debug()) {
                        Logger.globalDebug(DefaultDownloadCache.TAG, "callback", "Finish:" + z2);
                    }
                    if (z2) {
                        DefaultDownloadCache.this.initFinish();
                    }
                }
            });
            int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.INIT_DOWNLOAD_CACHE_TIMEOUT_MS);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "init", "InitTimeout:" + optInt);
            }
            if (optInt <= 0) {
                return;
            }
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.5
                @Override // java.lang.Runnable
                public void run() {
                    DefaultDownloadCache.this.initFinish();
                }
            }, optInt, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFinish() {
        if (isInitFinish.compareAndSet(false, true)) {
            onDownloadCacheSyncSuccess();
            resumeUnCompleteTaskMayDelayed();
            DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "initImmediately", "Run isRunInit:" + isRunInit.get());
        }
        init(this.downloadCache instanceof LruDownloadCache);
    }

    private void onDownloadCacheSyncSuccess() {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onDownloadCacheSyncSuccess", "Run");
        }
        if (this.downloadCache.isActiveLoadDownloadCache()) {
            newOnDownloadCacheSyncSuccess();
            return;
        }
        synchronized (this) {
            this.hasInitSqlDownloadCache = true;
            notifyAll();
        }
    }

    private void newOnDownloadCacheSyncSuccess() {
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        synchronized (downloadEngine) {
            this.hasInitSqlDownloadCache = true;
            downloadEngine.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        ISqlDownloadCache iSqlDownloadCache;
        if (this.hasInitSqlDownloadCache) {
            return true;
        }
        if (this.downloadCache.isActiveLoadDownloadCache()) {
            newEnsureDownloadCacheSyncSuccess();
            return this.hasInitSqlDownloadCache;
        }
        synchronized (this) {
            if (!this.hasInitSqlDownloadCache) {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.loadDBWaitTime);
                }
                if (this.bizCloseDBBatchInit > 0 && (iSqlDownloadCache = this.sqlDownloadCache) != null && (iSqlDownloadCache instanceof SqlDownloadCache)) {
                    ((SqlDownloadCache) iSqlDownloadCache).resetNewBatchInit();
                }
                waitDBLoad(this);
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting end");
                }
            }
        }
        return this.hasInitSqlDownloadCache;
    }

    private void newEnsureDownloadCacheSyncSuccess() {
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        synchronized (downloadEngine) {
            if (!this.hasInitSqlDownloadCache) {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting start");
                }
                initImmediately();
                waitDBLoad(downloadEngine);
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting end");
                }
            }
        }
    }

    private void waitDBLoad(Object obj) {
        if (this.mThreadLoadDownloadCacheOnlyOnce) {
            if (this.mThreadDownloadCacheLoaded.get() != null) {
                return;
            } else {
                this.mThreadDownloadCacheLoaded.set(true);
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "waitDBLoad", "Run loadDBWaitTime:" + this.loadDBWaitTime);
        }
        try {
            int i = this.loadDBWaitTime;
            if (i > 0) {
                obj.wait(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "waitDBLoad", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    public void resumeUnCompleteTaskMayDelayed() {
        this.weakHandler.sendMessageDelayed(this.weakHandler.obtainMessage(1), 4000L);
    }

    public void resumeUnCompleteTask() {
        if (this.hasInitSqlDownloadCache) {
            if (this.unCompleteTaskResumed) {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "resumeUnCompleteTask", "Has resumed, return");
                    return;
                }
                return;
            }
            this.unCompleteTaskResumed = true;
            if (DownloadHelper.isMainProcess() || DownloadUtils.optimizeMultiProcess()) {
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                List<DownloadInfo> autoResumeList = this.downloadCache.getAutoResumeList();
                if (downloadLaunchHandler == null || autoResumeList == null || autoResumeList.isEmpty()) {
                    return;
                }
                downloadLaunchHandler.onLaunchResume(autoResumeList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i) {
        return this.downloadCache.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        return this.downloadCache.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        return this.downloadCache.getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        return this.downloadCache.getDownloadInfosByFilters(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean updateDownloadInfo = this.downloadCache.updateDownloadInfo(downloadInfo);
        updateDownloadInfoInDB(downloadInfo);
        return updateDownloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        try {
            if (DownloadHelper.needNotifyDownloaderProcess() && !DownloadUtils.optimizeMultiProcess()) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.removeDownloadInfo(i);
                } else {
                    this.sqlDownloadCache.removeDownloadInfo(i);
                }
            } else {
                this.sqlDownloadCache.removeDownloadInfo(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.downloadCache.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        if (DownloadHelper.needNotifyDownloaderProcess() && !DownloadUtils.optimizeMultiProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.removeDownloadTaskData(i);
            } else {
                this.sqlDownloadCache.removeDownloadTaskData(i);
            }
        } else {
            this.sqlDownloadCache.removeDownloadTaskData(i);
        }
        return this.downloadCache.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            this.downloadCache.clearData();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (DownloadHelper.needNotifyDownloaderProcess() && !DownloadUtils.optimizeMultiProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.clearData();
                return;
            } else {
                this.sqlDownloadCache.clearData();
                return;
            }
        }
        this.sqlDownloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double d) {
        try {
            this.downloadCache.clearMemoryCacheData(d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        DownloadInfo OnDownloadTaskConnected = this.downloadCache.OnDownloadTaskConnected(i, j, str, str2);
        updateDownloadInfoInDB(OnDownloadTaskConnected);
        return OnDownloadTaskConnected;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        DownloadInfo OnDownloadTaskProgress = this.downloadCache.OnDownloadTaskProgress(i, j);
        updateDownloadInfoInDB(OnDownloadTaskProgress, false);
        return OnDownloadTaskProgress;
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo) {
        updateDownloadInfoInDB(downloadInfo, true);
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!DownloadHelper.needNotifyDownloaderProcess() || DownloadUtils.optimizeMultiProcess()) {
            this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            return;
        }
        if (z) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(downloadInfo);
            } else {
                this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        DownloadInfo OnDownloadTaskError = this.downloadCache.OnDownloadTaskError(i, j);
        syncDownloadInfoFromOtherCache(i);
        return OnDownloadTaskError;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i) {
        DownloadInfo OnDownloadTaskRetry = this.downloadCache.OnDownloadTaskRetry(i);
        updateDownloadInfoInDB(OnDownloadTaskRetry);
        return OnDownloadTaskRetry;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        DownloadInfo OnDownloadTaskCompleted = this.downloadCache.OnDownloadTaskCompleted(i, j);
        syncDownloadInfoFromOtherCache(i);
        return OnDownloadTaskCompleted;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        DownloadInfo OnDownloadTaskPause = this.downloadCache.OnDownloadTaskPause(i, j);
        syncDownloadInfoFromOtherCache(i);
        return OnDownloadTaskPause;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        DownloadInfo OnDownloadTaskCancel = this.downloadCache.OnDownloadTaskCancel(i, j);
        syncDownloadInfoFromOtherCache(i);
        return OnDownloadTaskCancel;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        DownloadInfo OnDownloadTaskPrepare = this.downloadCache.OnDownloadTaskPrepare(i);
        updateDownloadInfoInDB(OnDownloadTaskPrepare);
        return OnDownloadTaskPrepare;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        DownloadInfo OnDownloadTaskIntercept = this.downloadCache.OnDownloadTaskIntercept(i);
        updateDownloadInfoInDB(OnDownloadTaskIntercept);
        return OnDownloadTaskIntercept;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i) {
        try {
            updateDownloadInfo(this.downloadCache.getDownloadInfo(i));
            if (DownloadHelper.needNotifyDownloaderProcess() && !DownloadUtils.optimizeMultiProcess()) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.syncDownloadInfoFromOtherCache(i);
                } else {
                    this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i);
                }
            } else {
                this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i) {
        List<Segment> segments = this.downloadCache.getSegments(i);
        return (segments == null || segments.size() == 0) ? this.sqlDownloadCache.getSegments(i) : segments;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        Map<Long, Segment> segmentMap = this.downloadCache.getSegmentMap(i);
        if (segmentMap != null && !segmentMap.isEmpty()) {
            return segmentMap;
        }
        Map<Long, Segment> segmentMap2 = this.sqlDownloadCache.getSegmentMap(i);
        this.downloadCache.updateSegments(i, segmentMap2);
        return segmentMap2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        this.downloadCache.updateSegments(i, map);
        this.sqlDownloadCache.updateSegments(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        this.downloadCache.removeSegments(i);
        this.sqlDownloadCache.removeSegments(i);
    }

    public void updateDownloadSpInfo() {
        final Context appContext;
        if (this.hasInitSqlDownloadCache && (appContext = DownloadComponentManager.getAppContext()) != null) {
            DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SharedPreferences sharedPreferences = appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0);
                        HashMap hashMap = new HashMap();
                        List allDownloadInfo = Downloader.getInstance(appContext).getAllDownloadInfo();
                        if (allDownloadInfo != null) {
                            Iterator it = allDownloadInfo.iterator();
                            while (it.hasNext()) {
                                int id = ((DownloadInfo) it.next()).getId();
                                String string = sharedPreferences.getString(Long.toString(id), "");
                                if (!TextUtils.isEmpty(string)) {
                                    hashMap.put(Integer.toString(id), string);
                                }
                            }
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.clear();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            edit.putString((String) entry.getKey(), (String) entry.getValue());
                        }
                        edit.apply();
                    } catch (Throwable th) {
                        Logger.globalError(DefaultDownloadCache.TAG, "updateDownloadSpInfo", "Error:" + th);
                    }
                }
            });
        }
    }
}
