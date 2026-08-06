package com.huawei.hms.framework.network.grs.p023g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.C1087a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import com.huawei.hms.framework.network.grs.p026h.C1116e;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.g.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1100b {

    /* renamed from: a */
    private final Context f1316a;

    /* renamed from: b */
    private final GrsBaseInfo f1317b;

    /* renamed from: c */
    private final C1091a f1318c;

    public C1100b(Context context, C1091a c1091a, GrsBaseInfo grsBaseInfo) {
        this.f1316a = context;
        this.f1317b = grsBaseInfo;
        this.f1318c = c1091a;
    }

    /* renamed from: a */
    public String m1289a(boolean z) {
        String str;
        String str2 = C1087a.m1196a(this.f1318c.m1234a().m1244a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.m1185i("GeoipCountry", "geoIpCountry is: " + str2);
        String m1244a = this.f1318c.m1234a().m1244a("geoipCountryCodetime", AddressParam.TYPE_DISAPPROVE);
        long j = 0;
        if (!TextUtils.isEmpty(m1244a) && m1244a.matches("\\d+")) {
            try {
                j = Long.parseLong(m1244a);
            } catch (NumberFormatException e) {
                Logger.m1190w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (TextUtils.isEmpty(str2) || C1116e.m1375a(Long.valueOf(j))) {
            C1110c c1110c = new C1110c(this.f1317b, this.f1316a);
            c1110c.m1353a("geoip.countrycode");
            C1093c m1240c = this.f1318c.m1240c();
            if (m1240c != null) {
                try {
                    str = C1106h.m1345a(m1240c.m1244a("services", ""), c1110c.m1355c());
                } catch (JSONException e2) {
                    Logger.m1191w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    m1240c.m1248b("services", str);
                }
            }
            if (z) {
                C1102d m1341a = this.f1318c.m1238b().m1341a(c1110c, "geoip.countrycode", m1240c, -1);
                if (m1341a != null) {
                    str2 = C1087a.m1196a(m1341a.m1328j(), "geoip.countrycode").get("ROOT");
                }
                Logger.m1185i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                Logger.m1185i("GeoipCountry", "async request to query geoip.countrycode");
                this.f1318c.m1238b().m1343a(c1110c, null, "geoip.countrycode", m1240c, -1);
            }
        }
        return str2;
    }
}
