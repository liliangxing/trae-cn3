package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.dr.aidl.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1055b extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1055b {

        /* renamed from: com.bytedance.dr.aidl.b$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1196a implements InterfaceC1055b {

            /* renamed from: b */
            public static InterfaceC1055b f157b;

            /* renamed from: a */
            public IBinder f158a;

            public C1196a(IBinder iBinder) {
                this.f158a = iBinder;
            }

            /* renamed from: a */
            public String m245a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.f158a.transact(2, obtain, obtain2, 0) || a.m243a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C1196a) a.m243a()).m245a(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f158a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1055b m243a() {
            return C1196a.f157b;
        }

        /* renamed from: a */
        public static InterfaceC1055b m244a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1055b)) ? new C1196a(iBinder) : (InterfaceC1055b) queryLocalInterface;
        }
    }
}
