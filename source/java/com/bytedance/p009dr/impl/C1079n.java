package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.p009dr.aidl.InterfaceC1056c;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1079n extends AbstractC1067b<InterfaceC1056c> {

    /* renamed from: com.bytedance.dr.impl.n$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1056c, String> {
        public a(C1079n c1079n) {
        }

        /* renamed from: a */
        public Object m285a(IBinder iBinder) {
            return InterfaceC1056c.a.m246a(iBinder);
        }

        /* renamed from: a */
        public Object m286a(Object obj) {
            return ((InterfaceC1056c.a.C1197a) obj).m247a();
        }
    }

    public C1079n() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1056c, String> mo259a() {
        return new a(this);
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Samsung";
    }
}
