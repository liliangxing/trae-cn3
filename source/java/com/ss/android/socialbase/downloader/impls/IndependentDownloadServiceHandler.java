package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    private static final String TAG = "IndependentDownloadServiceHandler";
    private IDownloadAidlService aidlService;
    private IDownloadServiceConnectionListener connectionListener;
    private int logLevel = -1;

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "startService", "BindService");
            }
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context context, ServiceConnection serviceConnection) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "stopService", "Run");
        }
        this.isServiceAlive = false;
        Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onBind", "IndependentDownloadBinder");
        }
        return new IndependentDownloadBinder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, downloadTask.getDownloadId(), "tryDownload", "AidlService == null:" + (this.aidlService == null));
        }
        if (this.aidlService == null) {
            pendDownloadTask(downloadTask);
            startService(DownloadComponentManager.getAppContext(), this);
            return;
        }
        resumePendingTaskForIndependent();
        try {
            this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(downloadTask));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void resumePendingTaskForIndependent() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.pendingTasks) {
                clone = this.pendingTasks.clone();
                this.pendingTasks.clear();
            }
            if (clone == null || clone.size() <= 0 || DownloadComponentManager.getDownloadEngine() == null) {
                return;
            }
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(it.next()));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "resumePendingTaskForIndependent", "Exception:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(downloadTask.getDownloadId(), true);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.tryDownload(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onServiceConnected", "Run");
        }
        this.aidlService = IDownloadAidlService.Stub.asInterface(iBinder);
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceConnection(iBinder);
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onServiceConnected", "AidlService!=null" + (this.aidlService != null) + " pendingTasks.size:" + this.pendingTasks.size());
        }
        if (this.aidlService != null) {
            DownloadProcessDispatcher.getInstance().dispatchDownloaderProcessConnectedEvent();
            this.isServiceAlive = true;
            this.isInvokeStartService.set(false);
            int i = this.logLevel;
            if (i != -1) {
                try {
                    this.aidlService.setLogLevel(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            if (this.aidlService != null) {
                resumePendingTaskForIndependent();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onServiceDisconnected", "Run");
        }
        this.aidlService = null;
        this.isServiceAlive = false;
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.aidlService = null;
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
        this.connectionListener = iDownloadServiceConnectionListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i) {
        IDownloadAidlService iDownloadAidlService = this.aidlService;
        if (iDownloadAidlService == null) {
            this.logLevel = i;
            return;
        }
        try {
            iDownloadAidlService.setLogLevel(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.aidlService == null) {
            startService(DownloadComponentManager.getAppContext(), this);
        }
    }
}
