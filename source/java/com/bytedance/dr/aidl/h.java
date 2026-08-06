package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public interface h extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements h {

        /* renamed from: com.bytedance.dr.aidl.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0071a implements h {
            public IBinder a;

            public C0071a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new C0071a(iBinder) : (h) queryLocalInterface;
        }
    }
}
