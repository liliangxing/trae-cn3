package com.bytedance.p009dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.bytedance.dr.aidl.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface InterfaceC1057d extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class a extends Binder implements InterfaceC1057d {

        /* renamed from: com.bytedance.dr.aidl.d$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class C1198a implements InterfaceC1057d {

            /* renamed from: a */
            public IBinder f160a;

            public C1198a(IBinder iBinder) {
                this.f160a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f160a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1057d m248a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1057d)) ? new C1198a(iBinder) : (InterfaceC1057d) queryLocalInterface;
        }
    }
}
