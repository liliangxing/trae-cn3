package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.manager.C1420a;
import com.xiaomi.push.C1470ad;

/* renamed from: com.xiaomi.push.bh */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1501bh extends C1470ad.a {

    /* renamed from: a */
    private Context f1070a;

    @Override // com.xiaomi.push.C1470ad.a
    /* renamed from: a */
    public String mo1133a() {
        return "100886";
    }

    public C1501bh(Context context) {
        this.f1070a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m1659a()) {
                AbstractC1417b.m1101c(this.f1070a.getPackageName() + " begin upload event");
                C1420a.m1108a(this.f1070a).m1131b();
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
    }

    /* renamed from: a */
    private boolean m1659a() {
        return C1420a.m1108a(this.f1070a).m1123a().isEventUploadSwitchOpen();
    }
}
