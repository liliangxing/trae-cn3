package com.xiaomi.push;

import android.text.TextUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.C1755am;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.ep */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1590ep {
    /* renamed from: a */
    public static void m2424a(C1755am.b bVar, String str, AbstractC1600ez abstractC1600ez) {
        String m1593a;
        C1562do.c cVar = new C1562do.c();
        if (!TextUtils.isEmpty(bVar.f3001c)) {
            cVar.m2132a(bVar.f3001c);
        }
        if (!TextUtils.isEmpty(bVar.f3003e)) {
            cVar.m2141d(bVar.f3003e);
        }
        if (!TextUtils.isEmpty(bVar.f3004f)) {
            cVar.m2144e(bVar.f3004f);
        }
        cVar.m2135b(bVar.f2997a ? PushClient.DEFAULT_REQUEST_ID : "0");
        if (!TextUtils.isEmpty(bVar.f3002d)) {
            cVar.m2138c(bVar.f3002d);
        } else {
            cVar.m2138c("XIAOMI-SASL");
        }
        C1591eq c1591eq = new C1591eq();
        c1591eq.m2454c(bVar.f2999b);
        c1591eq.m2434a(Integer.parseInt(bVar.f3005g));
        c1591eq.m2448b(bVar.f2995a);
        c1591eq.m2438a("BIND", (String) null);
        c1591eq.m2437a(c1591eq.m2455e());
        AbstractC1417b.m1089a("[Slim]: bind id=" + c1591eq.m2455e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f3001c);
        hashMap.put("chid", bVar.f3005g);
        hashMap.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, bVar.f2999b);
        hashMap.put("id", c1591eq.m2455e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f2997a) {
            hashMap.put("kick", PushClient.DEFAULT_REQUEST_ID);
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.f3003e)) {
            hashMap.put("client_attrs", bVar.f3003e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f3004f)) {
            hashMap.put("cloud_attrs", bVar.f3004f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.f3002d.equals("XIAOMI-PASS") || bVar.f3002d.equals("XMPUSH-PASS")) {
            m1593a = C1491ay.m1593a(bVar.f3002d, null, hashMap, bVar.f3006h);
        } else {
            bVar.f3002d.equals("XIAOMI-SASL");
            m1593a = null;
        }
        cVar.m2147f(m1593a);
        c1591eq.m2440a(cVar.mo2060a(), (String) null);
        abstractC1600ez.mo2494b(c1591eq);
    }

    /* renamed from: a */
    public static void m2425a(String str, String str2, AbstractC1600ez abstractC1600ez) {
        C1591eq c1591eq = new C1591eq();
        c1591eq.m2454c(str2);
        c1591eq.m2434a(Integer.parseInt(str));
        c1591eq.m2438a("UBND", (String) null);
        abstractC1600ez.mo2494b(c1591eq);
    }
}
