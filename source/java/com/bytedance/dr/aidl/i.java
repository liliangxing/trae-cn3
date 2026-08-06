package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface i extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements i {

        /* renamed from: com.bytedance.dr.aidl.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0072a implements i {
            public static i b;
            public IBinder a;

            public C0072a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0072a) a.a()).a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static i a() {
            return C0072a.b;
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0072a(iBinder) : (i) queryLocalInterface;
        }
    }
}
