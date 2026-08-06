package com.huawei.hms.framework.network.grs.p021e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.C1087a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p023g.C1102d;
import com.huawei.hms.framework.network.grs.p023g.C1105g;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import com.huawei.hms.framework.network.grs.p026h.C1116e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1091a {

    /* renamed from: e */
    private static final String f1288e = "a";

    /* renamed from: f */
    private static final Map<String, Map<String, Map<String, String>>> f1289f = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final Map<String, Long> f1290a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private final C1093c f1291b;

    /* renamed from: c */
    private final C1093c f1292c;

    /* renamed from: d */
    private final C1105g f1293d;

    public C1091a(C1093c c1093c, C1093c c1093c2, C1105g c1105g) {
        this.f1292c = c1093c2;
        this.f1291b = c1093c;
        this.f1293d = c1105g;
        c1105g.m1342a(this);
    }

    /* renamed from: a */
    private void m1232a(GrsBaseInfo grsBaseInfo, C1092b c1092b, Context context, String str) {
        Long l = this.f1290a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (C1116e.m1375a(l)) {
            c1092b.m1241a(2);
            return;
        }
        if (C1116e.m1376a(l, 300000L)) {
            this.f1293d.m1343a(new C1110c(grsBaseInfo, context), null, str, this.f1292c, -1);
        }
        c1092b.m1241a(1);
    }

    /* renamed from: a */
    private void m1233a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (C1116e.m1376a(this.f1290a.get(str), 300000L)) {
            this.f1293d.m1343a(new C1110c(grsBaseInfo, context), null, null, this.f1292c, -1);
        }
    }

    /* renamed from: a */
    public C1093c m1234a() {
        return this.f1291b;
    }

    /* renamed from: a */
    public Map<String, String> m1235a(GrsBaseInfo grsBaseInfo, String str, C1092b c1092b, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f1289f;
        Map<String, Map<String, String>> map2 = map.get(grsParasKey);
        if (map2 == null || map2.isEmpty()) {
            Logger.m1180d(f1288e, "Cache size is: " + map.size());
            return new HashMap();
        }
        m1232a(grsBaseInfo, c1092b, context, str);
        return map2.get(str);
    }

    /* renamed from: a */
    public void m1236a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f1291b.m1248b(grsParasKey + CrashHianalyticsData.TIME, AddressParam.TYPE_DISAPPROVE);
        this.f1290a.remove(grsParasKey + CrashHianalyticsData.TIME);
        Map<String, Map<String, Map<String, String>>> map = f1289f;
        map.remove(grsParasKey);
        Logger.m1180d(f1288e, "Cache size is: " + map.size());
        this.f1293d.m1344a(grsParasKey);
    }

    /* renamed from: a */
    public void m1237a(GrsBaseInfo grsBaseInfo, C1102d c1102d, Context context, C1110c c1110c) {
        if (c1102d.m1324f() == 2) {
            Logger.m1189w(f1288e, "update cache from server failed");
            return;
        }
        if (c1110c.m1356d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (c1102d.m1331m()) {
                f1289f.put(grsParasKey, C1087a.m1194a(this.f1291b.m1244a(grsParasKey, "")));
            } else {
                this.f1291b.m1248b(grsParasKey, c1102d.m1328j());
                f1289f.put(grsParasKey, C1087a.m1194a(c1102d.m1328j()));
            }
            if (!TextUtils.isEmpty(c1102d.m1323e())) {
                this.f1291b.m1248b(grsParasKey + "ETag", c1102d.m1323e());
            }
            this.f1291b.m1248b(grsParasKey + CrashHianalyticsData.TIME, c1102d.m1314a());
            this.f1290a.put(grsParasKey, Long.valueOf(Long.parseLong(c1102d.m1314a())));
        } else {
            this.f1291b.m1248b("geoipCountryCode", c1102d.m1328j());
            this.f1291b.m1248b("geoipCountryCodetime", c1102d.m1314a());
        }
        Logger.m1180d(f1288e, "Cache size is: " + f1289f.size());
    }

    /* renamed from: b */
    public C1105g m1238b() {
        return this.f1293d;
    }

    /* renamed from: b */
    public void m1239b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String m1244a = this.f1291b.m1244a(grsParasKey, "");
        String m1244a2 = this.f1291b.m1244a(grsParasKey + CrashHianalyticsData.TIME, AddressParam.TYPE_DISAPPROVE);
        long j = 0;
        if (!TextUtils.isEmpty(m1244a2) && m1244a2.matches("\\d+")) {
            try {
                j = Long.parseLong(m1244a2);
            } catch (NumberFormatException e) {
                Logger.m1190w(f1288e, "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f1289f;
        map.put(grsParasKey, C1087a.m1194a(m1244a));
        Logger.m1180d(f1288e, "Cache size is: " + map.size());
        this.f1290a.put(grsParasKey, Long.valueOf(j));
        m1233a(grsBaseInfo, grsParasKey, context);
    }

    /* renamed from: c */
    public C1093c m1240c() {
        return this.f1292c;
    }
}
