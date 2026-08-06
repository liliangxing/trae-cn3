package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.bytedance.dr.aidl.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1063j extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.j$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1063j {

        /* renamed from: com.bytedance.dr.aidl.j$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1203a implements InterfaceC1063j {

            /* renamed from: a */
            public IBinder f166a;

            public C1203a(IBinder iBinder) {
                this.f166a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f166a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1063j m257a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1063j)) ? new C1203a(iBinder) : (InterfaceC1063j) queryLocalInterface;
        }
    }
}
