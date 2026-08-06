package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.u0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1181u0 {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C1140f0 m1769a(String str, String str2, String str3, String str4) {
        C1140f0 c1140f0 = new C1140f0();
        c1140f0.m1589a(str);
        c1140f0.m1590b(AbstractC1173q0.m1701f());
        c1140f0.m1593e(str2);
        c1140f0.m1591c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3).append("qrt");
        c1140f0.m1592d(stringBuffer.toString());
        return c1140f0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C1157l m1770a(String str, String str2) {
        C1157l c1157l = new C1157l();
        c1157l.m1761a(C1151j.m1564a().m1565a(str, str2));
        return c1157l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C1189y0 m1771a(String str, String str2, String str3) {
        C1189y0 c1189y0 = new C1189y0();
        c1189y0.m1764c(AbstractC1173q0.m1708j());
        c1189y0.m1766e(AbstractC1173q0.m1710l());
        c1189y0.m1762a(str3);
        c1189y0.m1763b(C1151j.m1564a().m1568b(str2, str));
        return c1189y0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static C1147h1 m1772b(String str, String str2) {
        C1162m1.m1631d().m1633a(str, str2);
        if (!TextUtils.isEmpty(C1162m1.m1631d().m1632a())) {
            return new C1147h1(C1162m1.m1631d().m1635c());
        }
        C1182v.m1786f("hmsSdk", "event chifer is empty");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static Map<String, String> m1773c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", AbstractC1173q0.m1701f());
        hashMap.put("App-Ver", AbstractC1173q0.m1703g());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.315");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        C1182v.m1775a("hmsSdk", "sendData RequestId : " + str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
