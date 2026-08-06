package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.bytedance.dr.aidl.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1060g extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1060g {

        /* renamed from: com.bytedance.dr.aidl.g$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1200a implements InterfaceC1060g {

            /* renamed from: a */
            public IBinder f162a;

            public C1200a(IBinder iBinder) {
                this.f162a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f162a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1060g m252a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1060g)) ? new C1200a(iBinder) : (InterfaceC1060g) queryLocalInterface;
        }
    }
}
