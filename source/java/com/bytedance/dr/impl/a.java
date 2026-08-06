package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.dr.aidl.e;
import com.bytedance.tobshadow.bdtracker.j;

/* loaded from: classes3.dex */
public final class a extends b<com.bytedance.dr.aidl.e> {

    /* renamed from: com.bytedance.dr.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0074a implements j.b<com.bytedance.dr.aidl.e, String> {
        public C0074a(a aVar) {
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public com.bytedance.dr.aidl.e a(IBinder iBinder) {
            return e.a.a(iBinder);
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public String a(com.bytedance.dr.aidl.e eVar) {
            com.bytedance.dr.aidl.e eVar2 = eVar;
            if (eVar2 == null) {
                return null;
            }
            e.a.C0069a c0069a = (e.a.C0069a) eVar2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0069a.a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public j.b<com.bytedance.dr.aidl.e, String> a() {
        return new C0074a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "ASUS";
    }
}
