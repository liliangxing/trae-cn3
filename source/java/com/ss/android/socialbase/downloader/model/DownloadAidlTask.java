package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface DownloadAidlTask extends IInterface {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Default implements DownloadAidlTask {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByHashCode(int i, int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int[] getDownloadListenerHashCodeLists(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException {
            return null;
        }
    }

    IDownloadAidlDepend getDepend() throws RemoteException;

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException;

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException;

    int getDownloadCompleteHandlerSize() throws RemoteException;

    DownloadInfo getDownloadInfo() throws RemoteException;

    IDownloadAidlListener getDownloadListenerByHashCode(int i, int i2) throws RemoteException;

    int[] getDownloadListenerHashCodeLists(int i) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException;

    IDownloadAidlFileProvider getFileProvider() throws RemoteException;

    IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException;

    IDownloadAidlInterceptor getInterceptor() throws RemoteException;

    IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException;

    IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getDepend = 8;
        static final int TRANSACTION_getDiskSpaceHandler = 10;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 14;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 13;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByHashCode = 3;
        static final int TRANSACTION_getDownloadListenerHashCodeLists = 2;
        static final int TRANSACTION_getDownloadNotificationEventListener = 5;
        static final int TRANSACTION_getFileProvider = 12;
        static final int TRANSACTION_getForbiddenHandler = 9;
        static final int TRANSACTION_getInterceptor = 7;
        static final int TRANSACTION_getMonitorDepend = 11;
        static final int TRANSACTION_getNotificationClickCallback = 6;
        static final int TRANSACTION_getSingleDownloadListener = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static DownloadAidlTask asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof DownloadAidlTask)) {
                return (DownloadAidlTask) queryLocalInterface;
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
                    DownloadInfo downloadInfo = getDownloadInfo();
                    parcel2.writeNoException();
                    if (downloadInfo != null) {
                        parcel2.writeInt(1);
                        downloadInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] downloadListenerHashCodeLists = getDownloadListenerHashCodeLists(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(downloadListenerHashCodeLists);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlListener downloadListenerByHashCode = getDownloadListenerByHashCode(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadListenerByHashCode != null ? downloadListenerByHashCode.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlListener singleDownloadListener = getSingleDownloadListener(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(singleDownloadListener != null ? singleDownloadListener.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlInterceptor interceptor = getInterceptor();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(interceptor != null ? interceptor.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlDepend depend = getDepend();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(depend != null ? depend.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadForbiddenAidlHandler forbiddenHandler = getForbiddenHandler();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(forbiddenHandler != null ? forbiddenHandler.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadDiskSpaceAidlHandler diskSpaceHandler = getDiskSpaceHandler();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(diskSpaceHandler != null ? diskSpaceHandler.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlMonitorDepend monitorDepend = getMonitorDepend();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(monitorDepend != null ? monitorDepend.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlFileProvider fileProvider = getFileProvider();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fileProvider != null ? fileProvider.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadCompleteHandlerSize = getDownloadCompleteHandlerSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadCompleteHandlerSize);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = getDownloadCompleteAidlHandlerByIndex(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadCompleteAidlHandlerByIndex != null ? downloadCompleteAidlHandlerByIndex.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static class Proxy implements DownloadAidlTask {
            public static DownloadAidlTask sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int[] getDownloadListenerHashCodeLists(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadListenerHashCodeLists(i);
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByHashCode(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadListenerByHashCode(i, i2);
                    }
                    obtain2.readException();
                    return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSingleDownloadListener(i);
                    }
                    obtain2.readException();
                    return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadNotificationEventListener();
                    }
                    obtain2.readException();
                    return IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNotificationClickCallback();
                    }
                    obtain2.readException();
                    return INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInterceptor();
                    }
                    obtain2.readException();
                    return IDownloadAidlInterceptor.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDepend();
                    }
                    obtain2.readException();
                    return IDownloadAidlDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getForbiddenHandler();
                    }
                    obtain2.readException();
                    return IDownloadForbiddenAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDiskSpaceHandler();
                    }
                    obtain2.readException();
                    return IDownloadDiskSpaceAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMonitorDepend();
                    }
                    obtain2.readException();
                    return IDownloadAidlMonitorDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFileProvider();
                    }
                    obtain2.readException();
                    return IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadCompleteHandlerSize();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(i);
                    }
                    obtain2.readException();
                    return IDownloadCompleteAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(DownloadAidlTask downloadAidlTask) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (downloadAidlTask == null) {
                return false;
            }
            Proxy.sDefaultImpl = downloadAidlTask;
            return true;
        }

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
