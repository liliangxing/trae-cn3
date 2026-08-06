package com.mcs.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes7.dex */
public interface INotifiPermissionCallback extends IInterface {

    /* loaded from: classes7.dex */
    public static class Default implements INotifiPermissionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onFail(int i, String str) {
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onSuccess() {
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class Stub extends Binder implements INotifiPermissionCallback {
        private static final String DESCRIPTOR = "com.mcs.aidl.INotifiPermissionCallback";
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public static class Proxy implements INotifiPermissionCallback {
            public static INotifiPermissionCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onFail(int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFail(i, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onSuccess() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotifiPermissionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INotifiPermissionCallback)) ? new Proxy(iBinder) : (INotifiPermissionCallback) queryLocalInterface;
        }

        public static INotifiPermissionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INotifiPermissionCallback iNotifiPermissionCallback) {
            if (Proxy.sDefaultImpl != null || iNotifiPermissionCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNotifiPermissionCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onFail(parcel.readInt(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFail(int i, String str);

    void onSuccess();
}
