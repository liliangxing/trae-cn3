package com.huawei.hms.framework.network.grs.p022f;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C1119a;
import com.huawei.hms.framework.network.grs.local.model.C1120b;
import com.huawei.hms.framework.network.grs.local.model.C1121c;
import com.huawei.hms.framework.network.grs.local.model.C1122d;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p026h.C1114c;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1094a {

    /* renamed from: a */
    protected C1119a f1298a;

    /* renamed from: b */
    protected List<C1120b> f1299b;

    /* renamed from: c */
    protected boolean f1300c = false;

    /* renamed from: d */
    protected boolean f1301d = false;

    /* renamed from: e */
    protected Set<String> f1302e = new HashSet(16);

    /* renamed from: a */
    private Map<String, String> m1249a(List<C1120b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (C1120b c1120b : list) {
            if (c1120b.m1387a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), c1120b.m1390b());
            }
            if (c1120b.m1387a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), c1120b.m1390b());
            }
            if (c1120b.m1387a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), c1120b.m1390b());
            }
            if (c1120b.m1387a().contains(str)) {
                Logger.m1187v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, c1120b.m1390b());
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: b */
    private int m1250b(String str, Context context) {
        if (m1251h(C1114c.m1371a(str, context)) != 0) {
            return -1;
        }
        Logger.m1186i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    /* renamed from: h */
    private int m1251h(String str) {
        int mo1263c;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f1301d && (mo1263c = mo1263c(str)) != 0) {
            return mo1263c;
        }
        int mo1260b = mo1260b(str);
        return mo1260b != 0 ? mo1260b : mo1269g(str);
    }

    /* renamed from: i */
    private int m1252i(String str) {
        List<C1120b> list;
        int m1267e;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.f1301d || !((list = this.f1299b) == null || list.isEmpty()) || (m1267e = m1267e(str)) == 0) ? m1268f(str) : m1267e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1253a(String str, Context context) {
        return m1250b(new StringBuilder().append(GrsApp.getInstance().getBrand("/")).append(str).toString(), context) != 0 ? -1 : 0;
    }

    /* renamed from: a */
    public String m1254a(Context context, C1091a c1091a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        Map<String, String> m1257a = m1257a(context, c1091a, grsBaseInfo, str, z);
        if (m1257a != null) {
            return m1257a.get(str2);
        }
        Logger.m1191w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* renamed from: a */
    public String m1255a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<C1120b> list = this.f1299b;
        if (list != null && !list.isEmpty()) {
            for (C1120b c1120b : this.f1299b) {
                if (c1120b.m1387a().contains(str)) {
                    return c1120b.m1390b();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<C1120b> m1256a(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(16);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            C1120b c1120b = new C1120b();
            c1120b.m1391b(jSONObject.getString("id"));
            c1120b.m1393c(jSONObject.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME));
            c1120b.m1388a(jSONObject.getString(C0879b.f565i));
            String str = "countriesOrAreas";
            if (!jSONObject.has("countriesOrAreas")) {
                str = "countries";
                if (!jSONObject.has("countries")) {
                    Logger.m1189w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null || jSONArray2.length() == 0) {
                        return new ArrayList();
                    }
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        hashSet.add((String) jSONArray2.get(i2));
                    }
                    c1120b.m1389a(hashSet);
                    arrayList.add(c1120b);
                }
            }
            jSONArray2 = jSONObject.getJSONArray(str);
            HashSet hashSet2 = new HashSet(16);
            if (jSONArray2 != null) {
            }
            return new ArrayList();
        }
        return arrayList;
    }

    /* renamed from: a */
    public Map<String, String> m1257a(Context context, C1091a c1091a, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        C1119a c1119a = this.f1298a;
        if (c1119a == null) {
            Logger.m1189w("AbstractLocalManager", "application data is null.");
            return null;
        }
        C1121c m1381a = c1119a.m1381a(str);
        if (m1381a == null) {
            Logger.m1191w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String m1281b = C1098e.m1281b(context, c1091a, m1381a.m1398b(), grsBaseInfo, z);
        if (m1281b == null) {
            Logger.m1191w("AbstractLocalManager", "country not found by routeby in local config{%s}", m1381a.m1398b());
            return null;
        }
        List<C1120b> m1395a = m1381a.m1395a();
        C1122d m1394a = m1381a.m1394a((m1395a == null || m1395a.size() == 0) ? m1255a(m1281b) : m1249a(m1395a, grsBaseInfo, m1281b).get(m1281b));
        if (m1394a == null) {
            return null;
        }
        return m1394a.m1402a();
    }

    /* renamed from: a */
    public JSONObject m1258a() {
        JSONObject m1385b = this.f1298a.m1385b();
        if (this.f1299b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<C1120b> it = this.f1299b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m1392c());
            }
            m1385b.put("countryGroups", jSONArray);
        }
        return m1385b;
    }

    /* renamed from: a */
    public void m1259a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            Logger.m1180d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + str);
            if (TextUtils.isEmpty(str) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                Logger.m1181d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", str);
            } else if (m1252i(C1114c.m1371a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                Logger.m1181d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
            } else {
                Logger.m1191w("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
            }
        }
    }

    /* renamed from: b */
    public abstract int mo1260b(String str);

    /* renamed from: b */
    public C1119a m1261b() {
        return this.f1298a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1262b(JSONArray jSONArray) {
        List<C1120b> list;
        String str;
        Iterator<String> keys;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            C1121c c1121c = new C1121c();
            String string = jSONObject.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME);
            c1121c.m1399b(string);
            if (!this.f1302e.contains(string)) {
                this.f1302e.add(string);
                if (this.f1301d) {
                    c1121c.m1401c(jSONObject.getString("routeBy"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i2);
                        C1122d c1122d = new C1122d();
                        String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has("countryOrAreaGroup")) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has("countryGroup")) {
                                Logger.m1188v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", string);
                                str = "no-country";
                                c1122d.m1403a(str);
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    String string2 = jSONObject3.getString(next);
                                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(next, jSONObject3.getString(next));
                                    }
                                }
                                c1122d.m1404a(concurrentHashMap);
                                c1121c.m1396a(c1122d.m1405b(), c1122d);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        c1122d.m1403a(str);
                        JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                        keys = jSONObject32.keys();
                        while (keys.hasNext()) {
                        }
                        c1122d.m1404a(concurrentHashMap2);
                        c1121c.m1396a(c1122d.m1405b(), c1122d);
                    }
                    String str3 = "countryOrAreaGroups";
                    if (!jSONObject.has("countryOrAreaGroups")) {
                        str3 = "countryGroups";
                        if (!jSONObject.has("countryGroups")) {
                            Logger.m1185i("AbstractLocalManager", "service use default countryOrAreaGroup");
                            list = null;
                            c1121c.m1397a(list);
                            if (this.f1298a == null) {
                                this.f1298a = new C1119a();
                            }
                            this.f1298a.m1384a(string, c1121c);
                        }
                    }
                    list = m1256a(jSONObject.getJSONArray(str3));
                    c1121c.m1397a(list);
                    if (this.f1298a == null) {
                    }
                    this.f1298a.m1384a(string, c1121c);
                }
            }
        }
    }

    /* renamed from: c */
    public abstract int mo1263c(String str);

    /* renamed from: c */
    public Set<String> m1264c() {
        return this.f1302e;
    }

    /* renamed from: d */
    public boolean m1265d() {
        return this.f1300c;
    }

    /* renamed from: d */
    public boolean m1266d(String str) {
        String str2;
        try {
            this.f1298a = new C1119a();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(DefaultLogicExecutor.GLOBAL_EVENT_NAME)) {
                this.f1298a.m1386b(jSONObject.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME));
            }
            if (jSONObject.has("cacheControl")) {
                this.f1298a.m1383a(jSONObject.getLong("cacheControl"));
            }
            if (jSONObject.has("services")) {
                m1262b(jSONObject.getJSONArray("services"));
            }
            if (jSONObject.has("countryGroups")) {
                JSONArray jSONArray = jSONObject.getJSONArray("countryGroups");
                ArrayList arrayList = new ArrayList(16);
                this.f1299b = arrayList;
                arrayList.addAll(m1256a(jSONArray));
            }
            Logger.m1186i("AbstractLocalManager", "parse from sp services size : %d, countryGroups size: %d:", Integer.valueOf(this.f1302e.size()), Integer.valueOf(this.f1299b.size()));
            return true;
        } catch (JSONException unused) {
            str2 = "Parse local config from sp failed, JSONException";
            Logger.m1189w("AbstractLocalManager", str2);
            return false;
        } catch (Throwable th) {
            str2 = "Parse local config from sp failed, Throwable:" + StringUtils.anonymizeMessage(th.getMessage());
            Logger.m1189w("AbstractLocalManager", str2);
            return false;
        }
    }

    /* renamed from: e */
    public int m1267e(String str) {
        JSONArray jSONArray;
        this.f1299b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m1182e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f1299b.addAll(m1256a(jSONArray));
            return 0;
        } catch (JSONException e) {
            Logger.m1191w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* renamed from: f */
    public int m1268f(String str) {
        try {
            m1262b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e) {
            Logger.m1191w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* renamed from: g */
    public abstract int mo1269g(String str);
}
