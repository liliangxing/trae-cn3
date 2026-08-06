package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.p009dr.aidl.InterfaceC1057d;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1073h extends AbstractC1067b<InterfaceC1057d> {

    /* renamed from: com.bytedance.dr.impl.h$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1057d, String> {
        public a(C1073h c1073h) {
        }

        /* renamed from: a */
        public Object m273a(IBinder iBinder) {
            return InterfaceC1057d.a.m248a(iBinder);
        }

        /* renamed from: a */
        public Object m274a(Object obj) {
            InterfaceC1057d interfaceC1057d = (InterfaceC1057d) obj;
            if (interfaceC1057d == null) {
                return null;
            }
            InterfaceC1057d.a.C1198a c1198a = (InterfaceC1057d.a.C1198a) interfaceC1057d;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                c1198a.f160a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public C1073h() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1057d, String> mo259a() {
        return new a(this);
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
