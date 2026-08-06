package com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.hihonor.cloudservice.oaid.IOAIDCallBack;

/* loaded from: classes6.dex */
public interface IOAIDService extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements IOAIDService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException {
        }
    }

    void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException;

    void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements IOAIDService {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDService";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isOAIDTrackingLimited = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOAIDService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOAIDService)) {
                return (IOAIDService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                basicTypes(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                getOAID(IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            isOAIDTrackingLimited(IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public static class Proxy implements IOAIDService {
            public static IOAIDService sDefaultImpl;
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

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeDouble(d);
                    obtain.writeString(str);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().basicTypes(i, j, z, f, d, str);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getOAID(iOAIDCallBack);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().isOAIDTrackingLimited(iOAIDCallBack);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOAIDService iOAIDService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOAIDService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOAIDService;
            return true;
        }

        public static IOAIDService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
