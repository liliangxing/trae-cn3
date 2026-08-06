package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.b;
import com.bytedance.tobshadow.bdtracker.j;

/* loaded from: classes3.dex */
public class d extends b<com.bytedance.dr.aidl.b> {
    public final Context c;

    /* loaded from: classes3.dex */
    public class a implements j.b<com.bytedance.dr.aidl.b, String> {
        public a() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public com.bytedance.dr.aidl.b a(IBinder iBinder) {
            return b.a.a(iBinder);
        }

        @Override // com.bytedance.tobshadow.bdtracker.j.b
        public String a(com.bytedance.dr.aidl.b bVar) {
            com.bytedance.dr.aidl.b bVar2 = bVar;
            if (bVar2 == null) {
                return null;
            }
            return ((b.a.C0066a) bVar2).a(d.this.c.getPackageName());
        }
    }

    public d(Context context) {
        super("com.coolpad.deviceidsupport");
        this.c = context;
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public j.b<com.bytedance.dr.aidl.b, String> a() {
        return new a();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "coolpad";
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                OaidApi.a aVar = new OaidApi.a();
                aVar.a = string;
                return aVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getOaid(context);
    }
}
