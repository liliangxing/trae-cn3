package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.p009dr.aidl.InterfaceC1062i;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.j;

/* renamed from: com.bytedance.dr.impl.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1068c extends AbstractC1067b<InterfaceC1062i> {

    /* renamed from: com.bytedance.dr.impl.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a implements j.b<InterfaceC1062i, String> {
        public a(C1068c c1068c) {
        }

        /* renamed from: a */
        public Object m263a(IBinder iBinder) {
            return InterfaceC1062i.a.m255a(iBinder);
        }

        /* renamed from: a */
        public Object m264a(Object obj) {
            InterfaceC1062i interfaceC1062i = (InterfaceC1062i) obj;
            if (interfaceC1062i == null) {
                return null;
            }
            return ((InterfaceC1062i.a.C1202a) interfaceC1062i).m256a();
        }
    }

    public C1068c() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public Intent mo258a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b
    /* renamed from: a */
    public j.b<InterfaceC1062i, String> mo259a() {
        return new a(this);
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Common";
    }

    @Override // com.bytedance.p009dr.impl.AbstractC1067b, com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            LoggerImpl.global().error(1, "startMsaklServer failed", e, new Object[0]);
        }
        return super.getOaid(context);
    }
}
