package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.dr.aidl.c;
import com.bytedance.tobshadow.bdtracker.j;

/* loaded from: classes3.dex */
public final class n extends b<com.bytedance.dr.aidl.c> {

    /* loaded from: classes3.dex */
    public class a implements j.b<com.bytedance.dr.aidl.c, String> {
        public a(n nVar) {
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public com.bytedance.dr.aidl.c a(IBinder iBinder) {
            return c.a.a(iBinder);
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public String a(com.bytedance.dr.aidl.c cVar) {
            return ((c.a.C0067a) cVar).a();
        }
    }

    public n() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public j.b<com.bytedance.dr.aidl.c, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Samsung";
    }
}
