package com.ss.android.socialbase.downloader.p005db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p005db.ISqlCacheLoadCompleteCallbackAidl;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ISqlDownloadCacheAidl extends IInterface {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Default implements ISqlDownloadCacheAidl {
        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCancel(int i, long j) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCompleted(int i, long j) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskError(int i, long j) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskIntercept(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPause(int i, long j) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPrepare(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskProgress(int i, long j) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskRetry(int i) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean cacheExist(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public void clearData() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean ensureDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo getDownloadInfo(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public void init(boolean z) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean isDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public DownloadInfo onDownloadTaskStart(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean removeDownloadInfo(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean removeDownloadTaskData(int i) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public void syncDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public void syncDownloadInfoFromOtherCache(int i) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
        public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
            return false;
        }
    }

    DownloadInfo OnDownloadTaskCancel(int i, long j) throws RemoteException;

    DownloadInfo OnDownloadTaskCompleted(int i, long j) throws RemoteException;

    DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) throws RemoteException;

    DownloadInfo OnDownloadTaskError(int i, long j) throws RemoteException;

    DownloadInfo OnDownloadTaskIntercept(int i) throws RemoteException;

    DownloadInfo OnDownloadTaskPause(int i, long j) throws RemoteException;

    DownloadInfo OnDownloadTaskPrepare(int i) throws RemoteException;

    DownloadInfo OnDownloadTaskProgress(int i, long j) throws RemoteException;

    DownloadInfo OnDownloadTaskRetry(int i) throws RemoteException;

    boolean cacheExist(int i) throws RemoteException;

    void clearData() throws RemoteException;

    boolean ensureDownloadCacheSyncSuccess() throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    DownloadInfo getDownloadInfo(int i) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException;

    void init(boolean z) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    DownloadInfo onDownloadTaskStart(int i) throws RemoteException;

    boolean removeDownloadInfo(int i) throws RemoteException;

    boolean removeDownloadTaskData(int i) throws RemoteException;

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws RemoteException;

    void syncDownloadInfo(DownloadInfo downloadInfo) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int i) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class Stub extends Binder implements ISqlDownloadCacheAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
        static final int TRANSACTION_OnDownloadTaskCancel = 21;
        static final int TRANSACTION_OnDownloadTaskCompleted = 19;
        static final int TRANSACTION_OnDownloadTaskConnected = 15;
        static final int TRANSACTION_OnDownloadTaskError = 17;
        static final int TRANSACTION_OnDownloadTaskIntercept = 23;
        static final int TRANSACTION_OnDownloadTaskPause = 20;
        static final int TRANSACTION_OnDownloadTaskPrepare = 22;
        static final int TRANSACTION_OnDownloadTaskProgress = 16;
        static final int TRANSACTION_OnDownloadTaskRetry = 18;
        static final int TRANSACTION_cacheExist = 2;
        static final int TRANSACTION_clearData = 13;
        static final int TRANSACTION_ensureDownloadCacheSyncSuccess = 25;
        static final int TRANSACTION_getAllDownloadInfo = 8;
        static final int TRANSACTION_getDownloadInfo = 3;
        static final int TRANSACTION_getDownloadInfoList = 4;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 7;
        static final int TRANSACTION_getDownloadInfosByFilters = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 5;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 24;
        static final int TRANSACTION_onDownloadTaskStart = 14;
        static final int TRANSACTION_removeDownloadInfo = 11;
        static final int TRANSACTION_removeDownloadTaskData = 12;
        static final int TRANSACTION_setInitCallback = 28;
        static final int TRANSACTION_syncDownloadInfo = 26;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 27;
        static final int TRANSACTION_updateDownloadInfo = 10;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISqlDownloadCacheAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISqlDownloadCacheAidl)) {
                return (ISqlDownloadCacheAidl) queryLocalInterface;
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
                    init(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean cacheExist = cacheExist(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cacheExist ? 1 : 0);
                    return true;
                case 3:
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
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfoList = getDownloadInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfoList);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> successedDownloadInfosWithMimeType = getSuccessedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(successedDownloadInfosWithMimeType);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> unCompletedDownloadInfosWithMimeType = getUnCompletedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unCompletedDownloadInfosWithMimeType);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfosByFileExtension = getDownloadInfosByFileExtension(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfosByFileExtension);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> allDownloadInfo = getAllDownloadInfo();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDownloadInfo);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfosByFilters = getDownloadInfosByFilters(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfosByFilters);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateDownloadInfo = updateDownloadInfo(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(updateDownloadInfo ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadInfo = removeDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadInfo ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadTaskData = removeDownloadTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadTaskData ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearData();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo onDownloadTaskStart = onDownloadTaskStart(parcel.readInt());
                    parcel2.writeNoException();
                    if (onDownloadTaskStart != null) {
                        parcel2.writeInt(1);
                        onDownloadTaskStart.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskConnected = OnDownloadTaskConnected(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (OnDownloadTaskConnected != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskConnected.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskProgress = OnDownloadTaskProgress(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskProgress != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskProgress.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskError = OnDownloadTaskError(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskError != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskError.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskRetry = OnDownloadTaskRetry(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskRetry != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskRetry.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskCompleted = OnDownloadTaskCompleted(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskCompleted != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskCompleted.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskPause = OnDownloadTaskPause(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskPause != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskPause.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskCancel = OnDownloadTaskCancel(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskCancel != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskCancel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskPrepare = OnDownloadTaskPrepare(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskPrepare != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskPrepare.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo OnDownloadTaskIntercept = OnDownloadTaskIntercept(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskIntercept != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskIntercept.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadCacheSyncSuccess = isDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean ensureDownloadCacheSyncSuccess = ensureDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(ensureDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfo(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfoFromOtherCache(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    setInitCallback(ISqlCacheLoadCompleteCallbackAidl.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static class Proxy implements ISqlDownloadCacheAidl {
            public static ISqlDownloadCacheAidl sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public void init(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().init(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public boolean cacheExist(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cacheExist(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo getDownloadInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfoList(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFileExtension(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfosByFileExtension(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfosByFilters(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
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
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateDownloadInfo(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public boolean removeDownloadInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public boolean removeDownloadTaskData(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadTaskData(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public void clearData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().clearData();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo onDownloadTaskStart(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onDownloadTaskStart(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskConnected(i, j, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskProgress(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskProgress(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskError(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskError(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskRetry(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskRetry(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCompleted(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskCompleted(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPause(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskPause(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCancel(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskCancel(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPrepare(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskPrepare(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskIntercept(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnDownloadTaskIntercept(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public boolean ensureDownloadCacheSyncSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ensureDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public void syncDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().syncDownloadInfo(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public void syncDownloadInfoFromOtherCache(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
            public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSqlCacheLoadCompleteCallbackAidl != null ? iSqlCacheLoadCompleteCallbackAidl.asBinder() : null);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISqlDownloadCacheAidl iSqlDownloadCacheAidl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSqlDownloadCacheAidl == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSqlDownloadCacheAidl;
            return true;
        }

        public static ISqlDownloadCacheAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
