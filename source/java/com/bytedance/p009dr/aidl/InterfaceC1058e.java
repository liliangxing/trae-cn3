package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.bytedance.dr.aidl.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1058e extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1058e {

        /* renamed from: com.bytedance.dr.aidl.e$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1199a implements InterfaceC1058e {

            /* renamed from: a */
            public IBinder f161a;

            public C1199a(IBinder iBinder) {
                this.f161a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f161a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1058e m249a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1058e)) ? new C1199a(iBinder) : (InterfaceC1058e) queryLocalInterface;
        }
    }
}
