package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.C1788q;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.cu */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1541cu {

    /* renamed from: a */
    private final String f1246a = "power_consumption_stats";

    /* renamed from: b */
    private final String f1247b = "off_up_ct";

    /* renamed from: c */
    private final String f1248c = "off_dn_ct";

    /* renamed from: d */
    private final String f1249d = "off_ping_ct";

    /* renamed from: e */
    private final String f1250e = "off_pong_ct";

    /* renamed from: f */
    private final String f1251f = "off_dur";

    /* renamed from: g */
    private final String f1252g = "on_up_ct";

    /* renamed from: h */
    private final String f1253h = "on_dn_ct";

    /* renamed from: i */
    private final String f1254i = "on_ping_ct";

    /* renamed from: j */
    private final String f1255j = "on_pong_ct";

    /* renamed from: k */
    private final String f1256k = "on_dur";

    /* renamed from: l */
    private final String f1257l = "start_time";

    /* renamed from: m */
    private final String f1258m = "end_time";

    /* renamed from: n */
    private final String f1259n = "xmsf_vc";

    /* renamed from: o */
    private final String f1260o = "android_vc";

    /* renamed from: p */
    private final String f1261p = "uuid";

    /* renamed from: a */
    public void m1967a(Context context, C1540ct c1540ct) {
        if (c1540ct == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("off_up_ct", Integer.valueOf(c1540ct.m1939a()));
        hashMap.put("off_dn_ct", Integer.valueOf(c1540ct.m1943b()));
        hashMap.put("off_ping_ct", Integer.valueOf(c1540ct.m1947c()));
        hashMap.put("off_pong_ct", Integer.valueOf(c1540ct.m1951d()));
        hashMap.put("off_dur", Long.valueOf(c1540ct.m1940a()));
        hashMap.put("on_up_ct", Integer.valueOf(c1540ct.m1955e()));
        hashMap.put("on_dn_ct", Integer.valueOf(c1540ct.m1957f()));
        hashMap.put("on_ping_ct", Integer.valueOf(c1540ct.m1959g()));
        hashMap.put("on_pong_ct", Integer.valueOf(c1540ct.m1961h()));
        hashMap.put("on_dur", Long.valueOf(c1540ct.m1944b()));
        hashMap.put("start_time", Long.valueOf(c1540ct.m1948c()));
        hashMap.put("end_time", Long.valueOf(c1540ct.m1952d()));
        hashMap.put("xmsf_vc", Integer.valueOf(c1540ct.m1963i()));
        hashMap.put("android_vc", Integer.valueOf(c1540ct.m1965j()));
        hashMap.put("uuid", C1788q.m3957a(context));
        C1581eg.m2343a().mo2342a("power_consumption_stats", hashMap);
    }
}
