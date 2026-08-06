package com.ss.android.socialbase.downloader.impls;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class IndependentProcessDownloadHandler implements IDownloadProxy, IDownloadServiceConnectionListener {
    private static final String TAG = "IndependentProcessDownloadHandler";
    private volatile IDownloadAidlService aidlService;
    private IDownloadProxy downloadProxy = new ProcessDownloadHandler();
    private IDownloadServiceHandler<IndependentProcessDownloadService> downloadServiceHandler;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosBySavePath(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    public IndependentProcessDownloadHandler() {
        IDownloadServiceHandler<IndependentProcessDownloadService> independentDownloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setServiceConnectionListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pause(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.cancel(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.canResume(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.resume(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.restart(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pauseAll();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i) {
        if (this.aidlService == null) {
            return 0L;
        }
        try {
            return this.aidlService.getCurBytes(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i) {
        if (this.aidlService == null) {
            return 0;
        }
        try {
            return this.aidlService.getStatus(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.isDownloading(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfo(i);
        }
        try {
            return this.aidlService.getDownloadInfo(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfoList(str);
        }
        try {
            return this.aidlService.getDownloadInfoList(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(getDownloadId(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getSuccessedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getSuccessedDownloadInfosWithMimeType(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        if (this.aidlService == null) {
            return this.downloadProxy.getAllDownloadInfo();
        }
        try {
            return this.aidlService.getAllDownloadInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfosByFilters(str, str2);
        }
        try {
            return this.aidlService.getDownloadInfosByFilters(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllFailedDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllFailedDownloadTasks(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllPauseReserveOnWifiDownloadTasks(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i, boolean z, boolean z2) {
        if (this.aidlService == null) {
            this.downloadProxy.clearDownloadData(i, z, z2);
            return;
        }
        try {
            this.aidlService.clearDownloadData(i, z, z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i, boolean z) {
        if (this.aidlService == null) {
            this.downloadProxy.resetDownloadData(i, z);
            return;
        }
        try {
            this.aidlService.resetDownloadData(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener(i, i2, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener1(i, i2, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z, z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.removeDownloadListener(i, i2, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
        }
        try {
            this.aidlService.isDownloadSuccessAndFileNotExist(downloadInfo);
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getUnCompletedDownloadInfosWithMimeType(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return this.aidlService.getDownloadingDownloadInfosWithMimeType(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfosByFileExtension(str);
        }
        try {
            return this.aidlService.getDownloadInfosByFileExtension(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.setLogLevel(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadCacheSyncSuccess();
        }
        try {
            return this.aidlService.isDownloadCacheSyncSuccess();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setDownloadWithIndependentProcessStatus(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i) {
        if (this.aidlService == null) {
            return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i);
        }
        try {
            return this.aidlService.getDownloadWithIndependentProcessStatus(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.updateDownloadInfo(downloadInfo);
        }
        try {
            return this.aidlService.updateDownloadInfo(downloadInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadInfo(i);
        }
        try {
            return this.aidlService.removeDownloadInfo(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadTaskData(i);
        }
        try {
            return this.aidlService.removeDownloadTaskData(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        if (this.aidlService == null) {
            this.downloadProxy.clearData();
            return;
        }
        try {
            this.aidlService.clearData();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i) {
        if (this.aidlService == null) {
            this.downloadProxy.syncDownloadInfoFromOtherCache(i);
            return;
        }
        try {
            this.aidlService.syncDownloadInfoFromOtherCache(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        return this.aidlService != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        if (this.aidlService != null) {
            try {
                this.aidlService.addProcessCallback(IPCUtils.convertProcessCallbackToAidl(processCallback));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i, int i2) {
        if (this.aidlService != null) {
            try {
                this.aidlService.dispatchProcessCallback(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertDownloadNotificationEventListenerFromAidl(this.aidlService.getDownloadNotificationEventListener(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertNotificationClickCallbackFromAidl(this.aidlService.getNotificationClickCallback(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (this.aidlService != null) {
            try {
                this.aidlService.setDownloadNotificationEventListener(i, IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadNotificationEventListener));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertFileProviderFromAidl(this.aidlService.getDownloadFileUriProvider(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceConnection(IBinder iBinder) {
        this.aidlService = IDownloadAidlService.Stub.asInterface(iBinder);
        if (DownloadHelper.isMainProcess()) {
            addProcessCallback(new ProcessCallback() { // from class: com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler.1
                @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
                public void callback(int i, int i2) {
                    if (i2 == 1) {
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).pause(i);
                    } else if (i2 == 2) {
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceDisConnection() {
        this.aidlService = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i, long j, int i2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setThrottleNetSpeed(i, j, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
