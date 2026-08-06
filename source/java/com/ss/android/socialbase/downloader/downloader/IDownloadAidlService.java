package com.ss.android.socialbase.downloader.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadAidlService extends IInterface {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Default implements IDownloadAidlService {
        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener1(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean canResume(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void cancel(int i, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearData() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearDownloadData(int i, boolean z, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void dispatchProcessCallback(int i, int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public long getCurBytes(int i) throws RemoteException {
            return 0L;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadId(String str, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfo(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadWithIndependentProcessStatus(int i) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public INotificationClickAidlCallback getNotificationClickCallback(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getStatus(int i) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloading(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isHttpServiceInit() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pause(int i, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pauseAll() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadInfo(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadTaskData(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resetDownloadData(int i, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restart(int i) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resume(int i) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setLogLevel(int i) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setThrottleNetSpeed(int i, long j, int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadInfoFromOtherCache(int i) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
            return false;
        }
    }

    void addDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException;

    void addDownloadListener1(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws RemoteException;

    void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException;

    boolean canResume(int i) throws RemoteException;

    void cancel(int i, boolean z) throws RemoteException;

    void clearData() throws RemoteException;

    void clearDownloadData(int i, boolean z, boolean z2) throws RemoteException;

    void dispatchProcessCallback(int i, int i2) throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    long getCurBytes(int i) throws RemoteException;

    IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws RemoteException;

    int getDownloadId(String str, String str2) throws RemoteException;

    DownloadInfo getDownloadInfo(int i) throws RemoteException;

    DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws RemoteException;

    int getDownloadWithIndependentProcessStatus(int i) throws RemoteException;

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback(int i) throws RemoteException;

    int getStatus(int i) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException;

    boolean isDownloading(int i) throws RemoteException;

    boolean isHttpServiceInit() throws RemoteException;

    void pause(int i, boolean z) throws RemoteException;

    void pauseAll() throws RemoteException;

    boolean removeDownloadInfo(int i) throws RemoteException;

    void removeDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException;

    boolean removeDownloadTaskData(int i) throws RemoteException;

    void resetDownloadData(int i, boolean z) throws RemoteException;

    void restart(int i) throws RemoteException;

    void restartAllFailedDownloadTasks(List<String> list) throws RemoteException;

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException;

    void resume(int i) throws RemoteException;

    void setDownloadNotificationEventListener(int i, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException;

    void setDownloadWithIndependentProcessStatus(int i, boolean z) throws RemoteException;

    void setLogLevel(int i) throws RemoteException;

    void setThrottleNetSpeed(int i, long j, int i2) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int i) throws RemoteException;

    void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class Stub extends Binder implements IDownloadAidlService {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadListener = 25;
        static final int TRANSACTION_addDownloadListener1 = 26;
        static final int TRANSACTION_addProcessCallback = 39;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 37;
        static final int TRANSACTION_clearDownloadData = 22;
        static final int TRANSACTION_dispatchProcessCallback = 40;
        static final int TRANSACTION_getAllDownloadInfo = 18;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadFileUriProvider = 44;
        static final int TRANSACTION_getDownloadId = 13;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 14;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 17;
        static final int TRANSACTION_getDownloadInfosByFilters = 19;
        static final int TRANSACTION_getDownloadNotificationEventListener = 41;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 33;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 42;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 15;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 29;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 31;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 27;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 28;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeDownloadInfo = 35;
        static final int TRANSACTION_removeDownloadListener = 24;
        static final int TRANSACTION_removeDownloadTaskData = 36;
        static final int TRANSACTION_resetDownloadData = 23;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 20;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 21;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_setDownloadNotificationEventListener = 43;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 32;
        static final int TRANSACTION_setLogLevel = 30;
        static final int TRANSACTION_setThrottleNetSpeed = 45;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 38;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadInfo = 34;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDownloadAidlService)) {
                return (IDownloadAidlService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    tryDownload(DownloadAidlTask.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean canResume = canResume(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(canResume ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    resume(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    restart(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseAll();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    long curBytes = getCurBytes(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(curBytes);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int status = getStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(status);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloading = isDownloading(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloading ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo downloadInfo = getDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfo != null) {
                        parcel2.writeInt(1);
                        downloadInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfoList = getDownloadInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfoList);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadId = getDownloadId(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadId);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo downloadInfoByUrlAndPath = getDownloadInfoByUrlAndPath(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoByUrlAndPath != null) {
                        parcel2.writeInt(1);
                        downloadInfoByUrlAndPath.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> successedDownloadInfosWithMimeType = getSuccessedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(successedDownloadInfosWithMimeType);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadingDownloadInfosWithMimeType = getDownloadingDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadingDownloadInfosWithMimeType);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfosByFileExtension = getDownloadInfosByFileExtension(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfosByFileExtension);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> allDownloadInfo = getAllDownloadInfo();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDownloadInfo);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfosByFilters = getDownloadInfosByFilters(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfosByFilters);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllFailedDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllPauseReserveOnWifiDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearDownloadData(parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetDownloadData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeDownloadListener(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener1(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadSuccessAndFileNotExist = isDownloadSuccessAndFileNotExist(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadSuccessAndFileNotExist ? 1 : 0);
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isHttpServiceInit = isHttpServiceInit();
                    parcel2.writeNoException();
                    parcel2.writeInt(isHttpServiceInit ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> unCompletedDownloadInfosWithMimeType = getUnCompletedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unCompletedDownloadInfosWithMimeType);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLogLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadCacheSyncSuccess = isDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadWithIndependentProcessStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadWithIndependentProcessStatus = getDownloadWithIndependentProcessStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadWithIndependentProcessStatus);
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateDownloadInfo = updateDownloadInfo(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(updateDownloadInfo ? 1 : 0);
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadInfo = removeDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadInfo ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadTaskData = removeDownloadTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadTaskData ? 1 : 0);
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearData();
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfoFromOtherCache(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    addProcessCallback(ProcessAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    dispatchProcessCallback(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadNotificationEventListener(parcel.readInt(), IDownloadNotificationEventAidlListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlFileProvider downloadFileUriProvider = getDownloadFileUriProvider(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadFileUriProvider != null ? downloadFileUriProvider.asBinder() : null);
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    setThrottleNetSpeed(parcel.readInt(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static class Proxy implements IDownloadAidlService {
            public static IDownloadAidlService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(downloadAidlTask != null ? downloadAidlTask.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().tryDownload(downloadAidlTask);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pause(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancel(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().canResume(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resume(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().restart(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pauseAll();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurBytes(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStatus(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloading(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfoList(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadId(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfosByFileExtension(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfosByFilters(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().restartAllFailedDownloadTasks(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    int i2 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().clearDownloadData(i, z, z2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resetDownloadData(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeDownloadListener(i, i2, iDownloadAidlListener, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addDownloadListener(i, i2, iDownloadAidlListener, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int i, int i2, IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    try {
                        if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().addDownloadListener1(i, i2, iDownloadAidlListener, i3, z, z2);
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isHttpServiceInit();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLogLevel(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateDownloadInfo(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadTaskData(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().clearData();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(processAidlCallback != null ? processAidlCallback.asBinder() : null);
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addProcessCallback(processAidlCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dispatchProcessCallback(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(41, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadNotificationEventListener(i);
                    }
                    obtain2.readException();
                    return IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public INotificationClickAidlCallback getNotificationClickCallback(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNotificationClickCallback(i);
                    }
                    obtain2.readException();
                    return INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iDownloadNotificationEventAidlListener != null ? iDownloadNotificationEventAidlListener.asBinder() : null);
                    if (!this.mRemote.transact(43, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDownloadNotificationEventListener(i, iDownloadNotificationEventAidlListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadFileUriProvider(i);
                    }
                    obtain2.readException();
                    return IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int i, long j, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setThrottleNetSpeed(i, j, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDownloadAidlService iDownloadAidlService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadAidlService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadAidlService;
            return true;
        }

        public static IDownloadAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
