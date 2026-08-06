package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.dr.aidl.d;
import com.bytedance.tobshadow.bdtracker.j;

/* loaded from: classes3.dex */
public final class h extends b<com.bytedance.dr.aidl.d> {

    /* loaded from: classes3.dex */
    public class a implements j.b<com.bytedance.dr.aidl.d, String> {
        public a(h hVar) {
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public com.bytedance.dr.aidl.d a(IBinder iBinder) {
            return d.a.a(iBinder);
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public String a(com.bytedance.dr.aidl.d dVar) {
            com.bytedance.dr.aidl.d dVar2 = dVar;
            if (dVar2 == null) {
                return null;
            }
            d.a.C0068a c0068a = (d.a.C0068a) dVar2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                c0068a.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public j.b<com.bytedance.dr.aidl.d, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
