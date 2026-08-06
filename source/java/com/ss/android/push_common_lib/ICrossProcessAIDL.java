package com.ss.android.push_common_lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes7.dex */
public interface ICrossProcessAIDL extends IInterface {

    /* loaded from: classes7.dex */
    public static class Default implements ICrossProcessAIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.push_common_lib.ICrossProcessAIDL
        public String invoke(String str, String str2, List list) throws RemoteException {
            return null;
        }
    }

    String invoke(String str, String str2, List list) throws RemoteException;

    /* loaded from: classes7.dex */
    public static abstract class Stub extends Binder implements ICrossProcessAIDL {
        private static final String DESCRIPTOR = "com.ss.android.push_common_lib.ICrossProcessAIDL";
        static final int TRANSACTION_invoke = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICrossProcessAIDL asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICrossProcessAIDL)) {
                return (ICrossProcessAIDL) queryLocalInterface;
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
            String invoke = invoke(parcel.readString(), parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
            parcel2.writeNoException();
            parcel2.writeString(invoke);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public static class Proxy implements ICrossProcessAIDL {
            public static ICrossProcessAIDL sDefaultImpl;
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

            @Override // com.ss.android.push_common_lib.ICrossProcessAIDL
            public String invoke(String str, String str2, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeList(list);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().invoke(str, str2, list);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICrossProcessAIDL iCrossProcessAIDL) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCrossProcessAIDL == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCrossProcessAIDL;
            return true;
        }

        public static ICrossProcessAIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
