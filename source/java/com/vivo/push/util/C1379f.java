package com.vivo.push.util;

import android.text.TextUtils;
import com.vivo.push.C1306m;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.C1313a;
import java.util.HashMap;

/* compiled from: ClientReportUtil.java */
/* renamed from: com.vivo.push.util.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1379f {
    /* renamed from: a */
    public static boolean m994a(long j, long j2) {
        C1393t.m1048d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        C1228y c1228y = new C1228y(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String mo854a = C1313a.m810a().m815e().mo854a();
        if (!TextUtils.isEmpty(mo854a)) {
            hashMap.put("remoteAppId", mo854a);
        }
        c1228y.m636a(hashMap);
        C1306m.m762a().m776a(c1228y);
        return true;
    }

    /* renamed from: a */
    public static boolean m995a(long j, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            C1393t.m1034a("ClientReportUtil", "reportParams is null");
            return false;
        }
        C1228y c1228y = new C1228y(j);
        c1228y.m636a(hashMap);
        c1228y.m637e();
        C1306m.m762a().m776a(c1228y);
        return true;
    }
}
