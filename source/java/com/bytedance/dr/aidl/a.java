package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0064a extends Binder implements a {

        /* renamed from: com.bytedance.dr.aidl.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0065a implements a {
            public static a b;
            public IBinder a;

            public C0065a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qiku.id.IOAIDInterface");
                    if (this.a.transact(3, obtain, obtain2, 0) || AbstractBinderC0064a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0065a) AbstractBinderC0064a.a()).a();
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

        public static a a() {
            return C0065a.b;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qiku.id.IOAIDInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0065a(iBinder) : (a) queryLocalInterface;
        }
    }
}
