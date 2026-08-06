package com.huawei.hms.framework.network.grs.p022f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p023g.C1100b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.framework.network.grs.f.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1098e {

    /* renamed from: a */
    private static final String f1306a = "e";

    /* renamed from: b */
    public static final Set<String> f1307b = Collections.unmodifiableSet(new a(16));

    /* renamed from: com.huawei.hms.framework.network.grs.f.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class a extends HashSet<String> {
        a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    /* renamed from: a */
    private static String m1280a(Context context, C1091a c1091a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str3 : str.split(">")) {
            if (f1307b.contains(str3.trim())) {
                if (!"ser_country".equals(str3.trim()) || TextUtils.isEmpty(serCountry) || GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    if ("reg_country".equals(str3.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                        Logger.m1185i(f1306a, "current route_by is regCountry and routerCountry is: " + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str3.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                        Logger.m1185i(f1306a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str3.trim())) {
                        serCountry = new C1100b(context, c1091a, grsBaseInfo).m1289a(z);
                        str2 = f1306a;
                        sb = new StringBuilder("current route_by is geo_ip and routerCountry is: ");
                    }
                } else {
                    str2 = f1306a;
                    sb = new StringBuilder("current route_by is serCountry and routerCountry is: ");
                }
                Logger.m1185i(str2, sb.append(serCountry).toString());
                return serCountry;
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m1281b(Context context, C1091a c1091a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.m1189w(f1306a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return m1280a(context, c1091a, str, grsBaseInfo, z);
        }
        Logger.m1187v(f1306a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
