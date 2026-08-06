package com.bytedance.p009dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.p009dr.aidl.InterfaceC1055b;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class C1069d extends AbstractC1067b<InterfaceC1055b> {

    /* renamed from: c */
    public final Context f172c;

    /* renamed from: com.bytedance.dr.impl.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1055b, String> {
        public a() {
        }

        /* renamed from: a */
        public Object m265a(IBinder iBinder) {
            return InterfaceC1055b.a.m244a(iBinder);
        }

        /* renamed from: a */
        public Object m266a(Object obj) {
            InterfaceC1055b interfaceC1055b = (InterfaceC1055b) obj;
            if (interfaceC1055b == null) {
                return null;
            }
            return ((InterfaceC1055b.a.C1196a) interfaceC1055b).m245a(C1069d.this.f172c.getPackageName());
        }
    }

    public C1069d(Context context) {
        super("com.coolpad.deviceidsupport");
        this.f172c = context;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1055b, String> mo259a() {
        return new a();
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "coolpad";
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b, com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                OaidApi.C1053a c1053a = new OaidApi.C1053a();
                c1053a.f153a = string;
                return c1053a;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getOaid(context);
    }
}
