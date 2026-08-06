package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.dr.aidl.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1054a extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1054a {

        /* renamed from: com.bytedance.dr.aidl.a$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1195a implements InterfaceC1054a {

            /* renamed from: b */
            public static InterfaceC1054a f155b;

            /* renamed from: a */
            public IBinder f156a;

            public C1195a(IBinder iBinder) {
                this.f156a = iBinder;
            }

            /* renamed from: a */
            public String m242a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qiku.id.IOAIDInterface");
                    if (this.f156a.transact(3, obtain, obtain2, 0) || a.m240a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C1195a) a.m240a()).m242a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f156a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1054a m240a() {
            return C1195a.f155b;
        }

        /* renamed from: a */
        public static InterfaceC1054a m241a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qiku.id.IOAIDInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1054a)) ? new C1195a(iBinder) : (InterfaceC1054a) queryLocalInterface;
        }
    }
}
