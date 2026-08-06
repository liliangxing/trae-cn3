package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public interface e extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements e {

        /* renamed from: com.bytedance.dr.aidl.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0069a implements e {
            public IBinder a;

            public C0069a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0069a(iBinder) : (e) queryLocalInterface;
        }
    }
}
