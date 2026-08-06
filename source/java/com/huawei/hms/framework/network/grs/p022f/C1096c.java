package com.huawei.hms.framework.network.grs.p022f;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C1119a;
import com.huawei.hms.framework.network.grs.local.model.C1120b;
import com.huawei.hms.framework.network.grs.local.model.C1121c;
import com.huawei.hms.framework.network.grs.local.model.C1122d;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1096c extends AbstractC1094a {
    public C1096c(Context context, boolean z) {
        this.f1301d = z;
        if (m1253a("grs_sdk_global_route_config.json", context) == 0) {
            this.f1300c = true;
        }
    }

    /* renamed from: a */
    private List<C1120b> m1278a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C1120b c1120b = new C1120b();
                c1120b.m1391b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                c1120b.m1393c(jSONObject2.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME));
                c1120b.m1388a(jSONObject2.getString(C0879b.f565i));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.m1189w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    c1120b.m1389a(hashSet);
                    arrayList.add(c1120b);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    /* renamed from: a */
    public List<C1120b> m1279a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : m1278a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: b */
    public int mo1260b(String str) {
        this.f1298a = new C1119a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME);
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f1298a.m1386b(string);
            this.f1298a.m1383a(j);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: c */
    public int mo1263c(String str) {
        JSONObject jSONObject;
        this.f1299b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.m1182e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.f1299b.addAll(m1278a(jSONObject));
            }
            return 0;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo1269g(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Iterator<String> keys;
        String str3 = "countryGroup";
        String str4 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next = keys2.next();
                C1121c c1121c = new C1121c();
                c1121c.m1399b(next);
                if (!this.f1302e.contains(next)) {
                    this.f1302e.add(next);
                    if (this.f1301d) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        c1121c.m1401c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i);
                            C1122d c1122d = new C1122d();
                            if (jSONObject4.has(str4)) {
                                string = jSONObject4.getString(str4);
                            } else if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else {
                                Logger.m1187v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                str2 = "no-country";
                                c1122d.m1403a(str2);
                                JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                String str5 = str3;
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject5.keys();
                                while (keys.hasNext()) {
                                    Iterator<String> it = keys;
                                    String next2 = keys.next();
                                    String string2 = jSONObject5.getString(next2);
                                    if (TextUtils.isEmpty(next2) || TextUtils.isEmpty(string2)) {
                                        keys = it;
                                    } else {
                                        concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                        keys = it;
                                        str4 = str4;
                                    }
                                }
                                c1122d.m1404a(concurrentHashMap);
                                c1121c.m1396a(c1122d.m1405b(), c1122d);
                                i++;
                                str3 = str5;
                                str4 = str4;
                            }
                            str2 = string;
                            c1122d.m1403a(str2);
                            JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                            String str52 = str3;
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            keys = jSONObject52.keys();
                            while (keys.hasNext()) {
                            }
                            c1122d.m1404a(concurrentHashMap2);
                            c1121c.m1396a(c1122d.m1405b(), c1122d);
                            i++;
                            str3 = str52;
                            str4 = str4;
                        }
                        String str6 = str3;
                        String str7 = str4;
                        List<C1120b> list = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else if (jSONObject3.has("countryGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryGroups");
                        } else {
                            Logger.m1187v("LocalManagerV1", "service use default countryOrAreaGroup");
                            c1121c.m1397a(list);
                            if (this.f1298a == null) {
                                this.f1298a = new C1119a();
                            }
                            this.f1298a.m1384a(next, c1121c);
                            str3 = str6;
                            str4 = str7;
                        }
                        list = m1279a((JSONArray) null, jSONObject);
                        c1121c.m1397a(list);
                        if (this.f1298a == null) {
                        }
                        this.f1298a.m1384a(next, c1121c);
                        str3 = str6;
                        str4 = str7;
                    }
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
