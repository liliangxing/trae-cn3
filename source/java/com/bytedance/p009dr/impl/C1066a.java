package com.bytedance.p009dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.p009dr.aidl.InterfaceC1058e;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1066a extends AbstractC1067b<InterfaceC1058e> {

    /* renamed from: com.bytedance.dr.impl.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1058e, String> {
        public a(C1066a c1066a) {
        }

        /* renamed from: a */
        public Object m260a(IBinder iBinder) {
            return InterfaceC1058e.a.m249a(iBinder);
        }

        /* renamed from: a */
        public Object m261a(Object obj) {
            InterfaceC1058e interfaceC1058e = (InterfaceC1058e) obj;
            if (interfaceC1058e == null) {
                return null;
            }
            InterfaceC1058e.a.C1199a c1199a = (InterfaceC1058e.a.C1199a) interfaceC1058e;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c1199a.f161a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public C1066a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1058e, String> mo259a() {
        return new a(this);
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "ASUS";
    }
}
