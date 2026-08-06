package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface b extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.bytedance.dr.aidl.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0066a implements b {
            public static b b;
            public IBinder a;

            public C0066a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.a.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0066a) a.a()).a(str);
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

        public static b a() {
            return C0066a.b;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0066a(iBinder) : (b) queryLocalInterface;
        }
    }
}
