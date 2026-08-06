package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.dr.aidl.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1062i extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.i$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1062i {

        /* renamed from: com.bytedance.dr.aidl.i$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1202a implements InterfaceC1062i {

            /* renamed from: b */
            public static InterfaceC1062i f164b;

            /* renamed from: a */
            public IBinder f165a;

            public C1202a(IBinder iBinder) {
                this.f165a = iBinder;
            }

            /* renamed from: a */
            public String m256a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.f165a.transact(1, obtain, obtain2, 0) || a.m254a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C1202a) a.m254a()).m256a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f165a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1062i m254a() {
            return C1202a.f164b;
        }

        /* renamed from: a */
        public static InterfaceC1062i m255a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1062i)) ? new C1202a(iBinder) : (InterfaceC1062i) queryLocalInterface;
        }
    }
}
