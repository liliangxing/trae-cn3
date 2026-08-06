package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.dr.aidl.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1056c extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1056c {

        /* renamed from: com.bytedance.dr.aidl.c$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1197a implements InterfaceC1056c {

            /* renamed from: a */
            public IBinder f159a;

            public C1197a(IBinder iBinder) {
                this.f159a = iBinder;
            }

            /* renamed from: a */
            public String m247a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f159a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f159a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1056c m246a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1056c)) ? new C1197a(iBinder) : (InterfaceC1056c) queryLocalInterface;
        }
    }
}
