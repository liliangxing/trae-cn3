package com.ss.android.socialbase.downloader.p005db;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p005db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SqlDownloadCacheAidlWrapper implements ISqlDownloadCache, ServiceConnection {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;
    private ISqlDownloadCacheAidl mISqlDownloadCache;
    private DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener mRebindErrorListener;
    private Future<?> mSetInitCallbackFuture;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ISqlCacheLoadCompleteCallbackAidl mPengingCallback = null;
    private Runnable mCheckAliveRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            if (SqlDownloadCacheAidlWrapper.sIsMainProcessAlive || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                return;
            }
            SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
        }
    };
    private CountDownLatch mInitLock = new CountDownLatch(1);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnMainProcessRebindErrorListener {
        void onRebindError();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double d) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        return false;
    }

    public SqlDownloadCacheAidlWrapper() {
        SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), this);
    }

    public void setOnMainProcessRebindErrorCallback(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        this.mRebindErrorListener = onMainProcessRebindErrorListener;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        try {
            this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (SqlDownloadCacheAidlWrapper.this.mPengingCallback != null && SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache != null) {
                                SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache.setInitCallback(SqlDownloadCacheAidlWrapper.this.mPengingCallback);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                }
                            };
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        try {
                            Logger.globalError(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected", "Exception: " + th2);
                            if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                                SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                            }
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                }
                            };
                        } finally {
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                        if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                            return;
                                        }
                                        SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindMainProcessDelayed() {
        if (Build.VERSION.SDK_INT >= 26 || sIsMainProcessAlive) {
            return false;
        }
        if (sBindMainProcessTimes > 5) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "bindMainProcessDelayed", "Bind too many times");
            }
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastBindMainProcessTimeMills < NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "bindMainProcessDelayed", "Time too short since last bin");
            }
            return false;
        }
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = currentTimeMillis;
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> sparseArray, final Set<Integer> set, final List<DownloadInfo> list, List<String> list2, final SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
                Future future;
                SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                    @Override // com.ss.android.socialbase.downloader.p005db.ISqlCacheLoadCompleteCallbackAidl
                    public void callback(Map map, List list3, Map map2, boolean z2) {
                        DownloadHelper.sparseArrayPutAll(sparseArray, map);
                        if (set != null && list3 != null) {
                            set.addAll(list3);
                        }
                        DownloadHelper.mapConvertToList(map2, list);
                        sqlCacheLoadCompleteCallback.callback(z2);
                        if (z2) {
                            SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                        }
                    }
                });
                boolean z2 = false;
                try {
                    z = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                    future.cancel(true);
                }
                SqlDownloadCacheAidlWrapper sqlDownloadCacheAidlWrapper = SqlDownloadCacheAidlWrapper.this;
                if (set != null && list != null) {
                    z2 = true;
                }
                sqlDownloadCacheAidlWrapper.init(z2);
                if (!z || (sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback) == null) {
                    return;
                }
                sqlCacheLoadCompleteCallback2.callback(true);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        synchronized (this) {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                try {
                    iSqlDownloadCacheAidl.setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.mPengingCallback = iSqlCacheLoadCompleteCallbackAidl;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean z) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.init(z);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.cacheExist(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfo(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfoList(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getSuccessedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getUnCompletedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfosByFileExtension(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getAllDownloadInfo();
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfosByFilters(str, str2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateDownloadInfo(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadInfo(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadTaskData(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.clearData();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.onDownloadTaskStart(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskConnected(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskProgress(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskError(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskRetry(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCompleted(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPause(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCancel(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPrepare(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskIntercept(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.isDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.ensureDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfo(downloadInfo);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfoFromOtherCache(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
