package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.manager.C1420a;
import com.xiaomi.push.C1470ad;

/* renamed from: com.xiaomi.push.bi */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1502bi extends C1470ad.a {

    /* renamed from: a */
    private Context f1071a;

    @Override // com.xiaomi.push.C1470ad.a
    /* renamed from: a */
    public String mo1133a() {
        return "100887";
    }

    public C1502bi(Context context) {
        this.f1071a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m1660a()) {
                C1420a.m1108a(this.f1071a).m1132c();
                AbstractC1417b.m1101c(this.f1071a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            AbstractC1417b.m1103d("fail to send perf data. " + e);
        }
    }

    /* renamed from: a */
    private boolean m1660a() {
        return C1420a.m1108a(this.f1071a).m1123a().isPerfUploadSwitchOpen();
    }
}
