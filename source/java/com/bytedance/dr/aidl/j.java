package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public interface j extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements j {

        /* renamed from: com.bytedance.dr.aidl.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0073a implements j {
            public IBinder a;

            public C0073a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new C0073a(iBinder) : (j) queryLocalInterface;
        }
    }
}
