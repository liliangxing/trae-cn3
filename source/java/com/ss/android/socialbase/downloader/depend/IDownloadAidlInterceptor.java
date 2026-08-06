package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes7.dex */
public interface IDownloadAidlInterceptor extends IInterface {

    /* loaded from: classes7.dex */
    public static class Default implements IDownloadAidlInterceptor {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
        public boolean intercept() throws RemoteException {
            return false;
        }
    }

    boolean intercept() throws RemoteException;

    /* loaded from: classes7.dex */
    public static abstract class Stub extends Binder implements IDownloadAidlInterceptor {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor";
        static final int TRANSACTION_intercept = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlInterceptor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDownloadAidlInterceptor)) {
                return (IDownloadAidlInterceptor) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean intercept = intercept();
            parcel2.writeNoException();
            parcel2.writeInt(intercept ? 1 : 0);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public static class Proxy implements IDownloadAidlInterceptor {
            public static IDownloadAidlInterceptor sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
            public boolean intercept() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().intercept();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDownloadAidlInterceptor iDownloadAidlInterceptor) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadAidlInterceptor == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadAidlInterceptor;
            return true;
        }

        public static IDownloadAidlInterceptor getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
