package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1092b;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p022f.C1095b;
import com.huawei.hms.framework.network.grs.p023g.C1102d;
import com.huawei.hms.framework.network.grs.p023g.C1105g;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1087a {

    /* renamed from: e */
    private static final String f1251e = "a";

    /* renamed from: a */
    private final GrsBaseInfo f1252a;

    /* renamed from: b */
    private C1091a f1253b;

    /* renamed from: c */
    private C1105g f1254c;

    /* renamed from: d */
    private C1093c f1255d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class a implements InterfaceC1088b {

        /* renamed from: a */
        String f1256a;

        /* renamed from: b */
        Map<String, String> f1257b;

        /* renamed from: c */
        IQueryUrlsCallBack f1258c;

        /* renamed from: d */
        Context f1259d;

        /* renamed from: e */
        GrsBaseInfo f1260e;

        /* renamed from: f */
        C1091a f1261f;

        a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, C1091a c1091a) {
            this.f1256a = str;
            this.f1257b = map;
            this.f1258c = iQueryUrlsCallBack;
            this.f1259d = context;
            this.f1260e = grsBaseInfo;
            this.f1261f = c1091a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC1088b
        /* renamed from: a */
        public void mo1203a() {
            Map<String, String> map = this.f1257b;
            if (map != null && !map.isEmpty()) {
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f1256a, StringUtils.anonymizeMessage(new JSONObject(this.f1257b).toString()));
                this.f1258c.onCallBackSuccess(this.f1257b);
                return;
            }
            if (this.f1257b != null) {
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f1256a);
                this.f1258c.onCallBackFail(-3);
                return;
            }
            Logger.m1185i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> m1274a = C1095b.m1270a(this.f1259d.getPackageName()).m1274a(this.f1259d, this.f1261f, this.f1260e, this.f1256a, true);
            if (m1274a == null || m1274a.isEmpty()) {
                Logger.m1184e(C1087a.f1251e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f1256a);
            }
            if (m1274a == null) {
                m1274a = new ConcurrentHashMap<>();
            }
            Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f1256a, StringUtils.anonymizeMessage(new JSONObject(m1274a).toString()));
            this.f1258c.onCallBackSuccess(m1274a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC1088b
        /* renamed from: a */
        public void mo1204a(C1102d c1102d) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String m1328j = c1102d.m1328j();
            Map<String, String> m1196a = C1087a.m1196a(m1328j, this.f1256a);
            if (m1196a.isEmpty()) {
                Map<String, String> map = this.f1257b;
                if (map == null || map.isEmpty()) {
                    if (this.f1257b != null) {
                        Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f1256a);
                        this.f1258c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(m1328j)) {
                        Logger.m1184e(C1087a.f1251e, "The serviceName[%s] is not configured on the GRS server.", this.f1256a);
                    }
                    Logger.m1185i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map<String, String> m1274a = C1095b.m1270a(this.f1259d.getPackageName()).m1274a(this.f1259d, this.f1261f, this.f1260e, this.f1256a, true);
                    if (m1274a == null || m1274a.isEmpty()) {
                        Logger.m1184e(C1087a.f1251e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f1256a);
                    }
                    if (m1274a == null) {
                        m1274a = new ConcurrentHashMap<>();
                    }
                    Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f1256a, StringUtils.anonymizeMessage(new JSONObject(m1274a).toString()));
                    this.f1258c.onCallBackSuccess(m1274a);
                    return;
                }
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f1256a, StringUtils.anonymizeMessage(new JSONObject(this.f1257b).toString()));
                iQueryUrlsCallBack = this.f1258c;
                m1196a = this.f1257b;
            } else {
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f1256a, StringUtils.anonymizeMessage(new JSONObject(m1196a).toString()));
                iQueryUrlsCallBack = this.f1258c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(m1196a);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.a$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class b implements InterfaceC1088b {

        /* renamed from: a */
        String f1262a;

        /* renamed from: b */
        String f1263b;

        /* renamed from: c */
        IQueryUrlCallBack f1264c;

        /* renamed from: d */
        String f1265d;

        /* renamed from: e */
        Context f1266e;

        /* renamed from: f */
        GrsBaseInfo f1267f;

        /* renamed from: g */
        C1091a f1268g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, C1091a c1091a) {
            this.f1262a = str;
            this.f1263b = str2;
            this.f1264c = iQueryUrlCallBack;
            this.f1265d = str3;
            this.f1266e = context;
            this.f1267f = grsBaseInfo;
            this.f1268g = c1091a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC1088b
        /* renamed from: a */
        public void mo1203a() {
            if (!TextUtils.isEmpty(this.f1265d)) {
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f1262a, this.f1263b, StringUtils.anonymizeMessage(this.f1265d));
                this.f1264c.onCallBackSuccess(this.f1265d);
                return;
            }
            if (!TextUtils.isEmpty(this.f1265d)) {
                Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f1262a, this.f1263b);
                this.f1264c.onCallBackFail(-3);
                return;
            }
            Logger.m1185i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String m1273a = C1095b.m1270a(this.f1266e.getPackageName()).m1273a(this.f1266e, this.f1268g, this.f1267f, this.f1262a, this.f1263b, true);
            if (m1273a == null || m1273a.isEmpty()) {
                Logger.m1184e(C1087a.f1251e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f1262a, this.f1263b);
            }
            Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f1262a, this.f1263b, StringUtils.anonymizeMessage(m1273a));
            this.f1264c.onCallBackSuccess(m1273a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC1088b
        /* renamed from: a */
        public void mo1204a(C1102d c1102d) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String m1328j = c1102d.m1328j();
            Map<String, String> m1196a = C1087a.m1196a(m1328j, this.f1262a);
            if (m1196a.containsKey(this.f1263b)) {
                String str2 = C1087a.f1251e;
                String str3 = this.f1263b;
                Logger.m1186i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f1262a, str3, StringUtils.anonymizeMessage(m1196a.get(str3)));
                iQueryUrlCallBack = this.f1264c;
                str = m1196a.get(this.f1263b);
            } else {
                if (TextUtils.isEmpty(this.f1265d)) {
                    if (!TextUtils.isEmpty(this.f1265d)) {
                        Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f1262a, this.f1263b);
                        this.f1264c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(m1328j)) {
                        Logger.m1184e(C1087a.f1251e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f1262a, this.f1263b);
                    }
                    Logger.m1185i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String m1273a = C1095b.m1270a(this.f1266e.getPackageName()).m1273a(this.f1266e, this.f1268g, this.f1267f, this.f1262a, this.f1263b, true);
                    if (m1273a == null || m1273a.isEmpty()) {
                        Logger.m1184e(C1087a.f1251e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f1262a, this.f1263b);
                    }
                    Logger.m1186i(C1087a.f1251e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f1262a, this.f1263b, StringUtils.anonymizeMessage(m1273a));
                    this.f1264c.onCallBackSuccess(m1273a);
                    return;
                }
                String str4 = C1087a.f1251e;
                String str5 = this.f1263b;
                Logger.m1186i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f1262a, str5, StringUtils.anonymizeMessage(m1196a.get(str5)));
                iQueryUrlCallBack = this.f1264c;
                str = this.f1265d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public C1087a(GrsBaseInfo grsBaseInfo, C1091a c1091a, C1105g c1105g, C1093c c1093c) {
        this.f1252a = grsBaseInfo;
        this.f1253b = c1091a;
        this.f1254c = c1105g;
        this.f1255d = c1093c;
    }

    /* renamed from: a */
    public static CountryCodeBean m1192a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    /* renamed from: a */
    public static Map<String, Map<String, String>> m1194a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.m1187v(f1251e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, m1197a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e) {
            Logger.m1191w(f1251e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    private Map<String, String> m1195a(String str, C1092b c1092b, Context context) {
        Map<String, String> m1235a = this.f1253b.m1235a(this.f1252a, str, c1092b, context);
        if (m1235a != null && !m1235a.isEmpty()) {
            Logger.m1185i(f1251e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return m1235a;
        }
        Map<String, String> m1274a = C1095b.m1270a(context.getPackageName()).m1274a(context, this.f1253b, this.f1252a, str, false);
        Logger.m1185i(f1251e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return m1274a != null ? m1274a : new HashMap();
    }

    /* renamed from: a */
    public static Map<String, String> m1196a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.m1189w(f1251e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.m1191w(f1251e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.m1191w(f1251e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return hashMap;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m1197a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e) {
            Logger.m1191w(f1251e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    public String m1198a(Context context, String str, int i) {
        C1102d m1341a = this.f1254c.m1341a(new C1110c(this.f1252a, context), str, this.f1255d, i);
        return m1341a == null ? "" : m1341a.m1331m() ? this.f1253b.m1234a().m1244a(this.f1252a.getGrsParasKey(true, true, context), "") : m1341a.m1328j();
    }

    /* renamed from: a */
    public String m1199a(String str, String str2, Context context, int i) {
        C1092b c1092b = new C1092b();
        String str3 = m1195a(str, c1092b, context).get(str2);
        if (c1092b.m1242a() && !TextUtils.isEmpty(str3)) {
            Logger.m1186i(f1251e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        String m1198a = m1198a(context, str, i);
        String str4 = m1196a(m1198a, str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.m1186i(f1251e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str4));
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(m1198a)) {
                Logger.m1184e(f1251e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str5 = f1251e;
            Logger.m1185i(str5, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = C1095b.m1270a(context.getPackageName()).m1273a(context, this.f1253b, this.f1252a, str, str2, true);
            if (str3 == null || str3.isEmpty()) {
                Logger.m1184e(str5, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.m1186i(f1251e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
        return str3;
    }

    /* renamed from: a */
    public Map<String, String> m1200a(String str, Context context, int i) {
        C1092b c1092b = new C1092b();
        Map<String, String> m1195a = m1195a(str, c1092b, context);
        if (c1092b.m1242a() && !m1195a.isEmpty()) {
            Logger.m1186i(f1251e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m1195a).toString()));
            return m1195a;
        }
        String m1198a = m1198a(context, str, i);
        Map<String, String> m1196a = m1196a(m1198a, str);
        if (!m1196a.isEmpty()) {
            Logger.m1186i(f1251e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m1196a).toString()));
            return m1196a;
        }
        if (m1195a.isEmpty()) {
            if (!TextUtils.isEmpty(m1198a)) {
                Logger.m1184e(f1251e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str2 = f1251e;
            Logger.m1185i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            m1195a = C1095b.m1270a(context.getPackageName()).m1274a(context, this.f1253b, this.f1252a, str, true);
            if (m1195a == null || m1195a.isEmpty()) {
                Logger.m1184e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str3 = f1251e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(m1195a != null ? new JSONObject(m1195a).toString() : "");
        Logger.m1186i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return m1195a;
    }

    /* renamed from: a */
    public void m1201a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i) {
        C1092b c1092b = new C1092b();
        Map<String, String> m1195a = m1195a(str, c1092b, context);
        if (!c1092b.m1242a()) {
            this.f1254c.m1343a(new C1110c(this.f1252a, context), new a(str, m1195a, iQueryUrlsCallBack, context, this.f1252a, this.f1253b), str, this.f1255d, i);
            return;
        }
        if (m1195a.isEmpty()) {
            Logger.m1186i(f1251e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f1251e;
            Logger.m1186i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m1195a).toString()));
            Logger.m1186i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(m1195a).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(m1195a);
        }
    }

    /* renamed from: a */
    public void m1202a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i) {
        C1092b c1092b = new C1092b();
        String str3 = m1195a(str, c1092b, context).get(str2);
        if (!c1092b.m1242a()) {
            this.f1254c.m1343a(new C1110c(this.f1252a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f1252a, this.f1253b), str, this.f1255d, i);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.m1186i(f1251e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.m1186i(f1251e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
