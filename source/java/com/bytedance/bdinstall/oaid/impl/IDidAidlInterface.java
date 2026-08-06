package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IDidAidlInterface extends IInterface {
    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean support() throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int TRANSACTION_a = 2;
        static final int TRANSACTION_c = 4;
        static final int TRANSACTION_d = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_support = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDidAidlInterface)) {
                return (IDidAidlInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean support = support();
                parcel2.writeNoException();
                parcel2.writeInt(support ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String udid = getUDID();
                parcel2.writeNoException();
                parcel2.writeString(udid);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                String vaid = getVAID();
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            String aaid = getAAID();
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }

        /* loaded from: classes3.dex */
        private static class Proxy implements IDidAidlInterface {
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

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public boolean support() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getUDID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getVAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getAAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
