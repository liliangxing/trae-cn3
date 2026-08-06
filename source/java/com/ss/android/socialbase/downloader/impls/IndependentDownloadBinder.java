package com.ss.android.socialbase.downloader.impls;

import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class IndependentDownloadBinder extends IDownloadAidlService.Stub {
    private static final String TAG = "IndependentDownloadBinder";
    private final IDownloadProxy downloadProxy = new ProcessDownloadHandler(true);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.tryDownloadWithEngine(IPCUtils.convertDownloadTaskFromAidl(downloadAidlTask));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pause(int i, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pause(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void cancel(int i, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.cancel(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean canResume(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.canResume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resume(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.resume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restart(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pauseAll() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public long getCurBytes(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0L;
        }
        return iDownloadProxy.getCurBytes(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getStatus(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloading(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfo(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadId(String str, String str2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfosByFilters(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearDownloadData(int i, boolean z, boolean z2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i, z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resetDownloadData(int i, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i, z, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.removeDownloadListener(i, i2, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadHelper.convertListenerType(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i, i2, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadHelper.convertListenerType(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener1(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i, i2, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadHelper.convertListenerType(i3), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setThrottleNetSpeed(int i, long j, int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setThrottleNetSpeed(i, j, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isHttpServiceInit() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setLogLevel(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadCacheSyncSuccess() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws RemoteException {
        DownloadProcessDispatcher.getInstance().setDownloadIndependentProcessStatus(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadWithIndependentProcessStatus(int i) throws RemoteException {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadInfo(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadTaskData(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearData() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadInfoFromOtherCache(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.syncDownloadInfoFromOtherCache(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addProcessCallback(IPCUtils.convertProcessAidlCallbackFromAidl(processAidlCallback));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void dispatchProcessCallback(int i, int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.dispatchProcessCallback(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadProxy.getDownloadNotificationEventListener(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public INotificationClickAidlCallback getNotificationClickCallback(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertNotificationClickCallbackToAidl(iDownloadProxy.getNotificationClickCallback(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setDownloadNotificationEventListener(i, IPCUtils.convertDownloadNotificationEventListenerFromAidl(iDownloadNotificationEventAidlListener));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertFileProviderToAidl(iDownloadProxy.getDownloadFileUriProvider(i));
    }
}
