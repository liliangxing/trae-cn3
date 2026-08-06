package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.bytedance.dr.aidl.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1061h extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.h$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1061h {

        /* renamed from: com.bytedance.dr.aidl.h$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1201a implements InterfaceC1061h {

            /* renamed from: a */
            public IBinder f163a;

            public C1201a(IBinder iBinder) {
                this.f163a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f163a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1061h m253a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1061h)) ? new C1201a(iBinder) : (InterfaceC1061h) queryLocalInterface;
        }
    }
}
