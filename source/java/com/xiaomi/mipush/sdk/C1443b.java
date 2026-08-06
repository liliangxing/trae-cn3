package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1682i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1443b {

    /* renamed from: a */
    private static volatile C1443b f818a;

    /* renamed from: a */
    private Context f819a;

    /* renamed from: a */
    private a f820a;

    /* renamed from: a */
    String f821a;

    /* renamed from: a */
    private Map<String, a> f822a;

    /* renamed from: a */
    public static C1443b m1222a(Context context) {
        if (f818a == null) {
            synchronized (C1443b.class) {
                if (f818a == null) {
                    f818a = new C1443b(context);
                }
            }
        }
        return f818a;
    }

    private C1443b(Context context) {
        this.f819a = context;
        m1223c();
    }

    /* renamed from: c */
    private void m1223c() {
        this.f820a = new a(this.f819a);
        this.f822a = new HashMap();
        SharedPreferences m1221a = m1221a(this.f819a);
        this.f820a.f825a = m1221a.getString("appId", null);
        this.f820a.f827b = m1221a.getString("appToken", null);
        this.f820a.f829c = m1221a.getString("regId", null);
        this.f820a.f830d = m1221a.getString("regSec", null);
        this.f820a.f832f = m1221a.getString("devId", null);
        if (!TextUtils.isEmpty(this.f820a.f832f) && C1682i.m3387a(this.f820a.f832f)) {
            this.f820a.f832f = C1682i.m3401h(this.f819a);
            m1221a.edit().putString("devId", this.f820a.f832f).commit();
        }
        this.f820a.f831e = m1221a.getString("vName", null);
        this.f820a.f826a = m1221a.getBoolean("valid", true);
        this.f820a.f828b = m1221a.getBoolean("paused", false);
        this.f820a.f823a = m1221a.getInt("envType", 1);
        this.f820a.f833g = m1221a.getString("regResource", null);
        this.f820a.f834h = m1221a.getString("appRegion", null);
    }

    /* renamed from: a */
    public boolean m1233a() {
        Context context = this.f819a;
        return !TextUtils.equals(C1628g.m2683a(context, context.getPackageName()), this.f820a.f831e);
    }

    /* renamed from: a */
    public void m1229a(String str) {
        SharedPreferences.Editor edit = m1221a(this.f819a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f820a.f831e = str;
    }

    /* renamed from: b */
    public boolean m1240b() {
        if (this.f820a.m1257a()) {
            return true;
        }
        AbstractC1417b.m1089a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: a */
    public String m1226a() {
        return this.f820a.f825a;
    }

    /* renamed from: b */
    public String m1236b() {
        return this.f820a.f827b;
    }

    /* renamed from: c */
    public String m1241c() {
        return this.f820a.f829c;
    }

    /* renamed from: d */
    public String m1243d() {
        return this.f820a.f830d;
    }

    /* renamed from: e */
    public String m1245e() {
        return this.f820a.f833g;
    }

    /* renamed from: a */
    public boolean m1234a(String str, String str2) {
        return this.f820a.m1258a(str, str2);
    }

    /* renamed from: f */
    public String m1247f() {
        return this.f820a.f834h;
    }

    /* renamed from: a */
    public void m1231a(String str, String str2, String str3) {
        this.f820a.m1255a(str, str2, str3);
    }

    /* renamed from: b */
    public void m1239b(String str, String str2, String str3) {
        this.f820a.m1260b(str, str2, str3);
    }

    /* renamed from: a */
    public void m1227a() {
        this.f820a.m1252a();
    }

    /* renamed from: c */
    public boolean m1242c() {
        return this.f820a.m1257a();
    }

    /* renamed from: d */
    public boolean m1244d() {
        return (TextUtils.isEmpty(this.f820a.f825a) || TextUtils.isEmpty(this.f820a.f827b) || TextUtils.isEmpty(this.f820a.f829c) || TextUtils.isEmpty(this.f820a.f830d)) ? false : true;
    }

    /* renamed from: a */
    public a m1225a(String str) {
        if (this.f822a.containsKey(str)) {
            return this.f822a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences m1221a = m1221a(this.f819a);
        if (!m1221a.contains(str2)) {
            return null;
        }
        a m1249a = a.m1249a(this.f819a, m1221a.getString(str2, ""));
        this.f822a.put(str2, m1249a);
        return m1249a;
    }

    /* renamed from: a */
    public void m1230a(String str, a aVar) {
        this.f822a.put(str, aVar);
        m1221a(this.f819a).edit().putString("hybrid_app_info_" + str, a.m1251a(aVar)).commit();
    }

    /* renamed from: b */
    public void m1238b(String str) {
        this.f822a.remove(str);
        m1221a(this.f819a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: a */
    public boolean m1235a(String str, String str2, String str3) {
        a m1225a = m1225a(str3);
        return m1225a != null && TextUtils.equals(str, m1225a.f825a) && TextUtils.equals(str2, m1225a.f827b);
    }

    /* renamed from: com.xiaomi.mipush.sdk.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private Context f824a;

        /* renamed from: a */
        public String f825a;

        /* renamed from: b */
        public String f827b;

        /* renamed from: c */
        public String f829c;

        /* renamed from: d */
        public String f830d;

        /* renamed from: e */
        public String f831e;

        /* renamed from: f */
        public String f832f;

        /* renamed from: g */
        public String f833g;

        /* renamed from: h */
        public String f834h;

        /* renamed from: a */
        public boolean f826a = true;

        /* renamed from: b */
        public boolean f828b = false;

        /* renamed from: a */
        public int f823a = 1;

        public a(Context context) {
            this.f824a = context;
        }

        /* renamed from: a */
        public void m1255a(String str, String str2, String str3) {
            this.f825a = str;
            this.f827b = str2;
            this.f833g = str3;
            SharedPreferences.Editor edit = C1443b.m1221a(this.f824a).edit();
            edit.putString("appId", this.f825a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        /* renamed from: b */
        public void m1260b(String str, String str2, String str3) {
            this.f829c = str;
            this.f830d = str2;
            this.f832f = C1682i.m3401h(this.f824a);
            this.f831e = m1250a();
            this.f826a = true;
            this.f834h = str3;
            SharedPreferences.Editor edit = C1443b.m1221a(this.f824a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f832f);
            edit.putString("vName", m1250a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        /* renamed from: c */
        public void m1261c(String str, String str2, String str3) {
            this.f825a = str;
            this.f827b = str2;
            this.f833g = str3;
        }

        /* renamed from: a */
        public void m1254a(String str, String str2) {
            this.f829c = str;
            this.f830d = str2;
            this.f832f = C1682i.m3401h(this.f824a);
            this.f831e = m1250a();
            this.f826a = true;
        }

        /* renamed from: a */
        public boolean m1258a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f825a, str);
            boolean equals2 = TextUtils.equals(this.f827b, str2);
            boolean z = !TextUtils.isEmpty(this.f829c);
            boolean z2 = !TextUtils.isEmpty(this.f830d);
            boolean z3 = TextUtils.isEmpty(C1682i.m3390b(this.f824a)) || TextUtils.equals(this.f832f, C1682i.m3401h(this.f824a)) || TextUtils.equals(this.f832f, C1682i.m3400g(this.f824a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                AbstractC1417b.m1105e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        /* renamed from: a */
        public boolean m1257a() {
            return m1258a(this.f825a, this.f827b);
        }

        /* renamed from: a */
        private String m1250a() {
            Context context = this.f824a;
            return C1628g.m2683a(context, context.getPackageName());
        }

        /* renamed from: a */
        public void m1252a() {
            C1443b.m1221a(this.f824a).edit().clear().commit();
            this.f825a = null;
            this.f827b = null;
            this.f829c = null;
            this.f830d = null;
            this.f832f = null;
            this.f831e = null;
            this.f826a = false;
            this.f828b = false;
            this.f834h = null;
            this.f823a = 1;
        }

        /* renamed from: a */
        public void m1256a(boolean z) {
            this.f828b = z;
        }

        /* renamed from: a */
        public void m1253a(int i) {
            this.f823a = i;
        }

        /* renamed from: b */
        public void m1259b() {
            this.f826a = false;
            C1443b.m1221a(this.f824a).edit().putBoolean("valid", this.f826a).commit();
        }

        /* renamed from: a */
        public static a m1249a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f825a = jSONObject.getString("appId");
                aVar.f827b = jSONObject.getString("appToken");
                aVar.f829c = jSONObject.getString("regId");
                aVar.f830d = jSONObject.getString("regSec");
                aVar.f832f = jSONObject.getString("devId");
                aVar.f831e = jSONObject.getString("vName");
                aVar.f826a = jSONObject.getBoolean("valid");
                aVar.f828b = jSONObject.getBoolean("paused");
                aVar.f823a = jSONObject.getInt("envType");
                aVar.f833g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                AbstractC1417b.m1093a(th);
                return null;
            }
        }

        /* renamed from: a */
        public static String m1251a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f825a);
                jSONObject.put("appToken", aVar.f827b);
                jSONObject.put("regId", aVar.f829c);
                jSONObject.put("regSec", aVar.f830d);
                jSONObject.put("devId", aVar.f832f);
                jSONObject.put("vName", aVar.f831e);
                jSONObject.put("valid", aVar.f826a);
                jSONObject.put("paused", aVar.f828b);
                jSONObject.put("envType", aVar.f823a);
                jSONObject.put("regResource", aVar.f833g);
                return jSONObject.toString();
            } catch (Throwable th) {
                AbstractC1417b.m1093a(th);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static SharedPreferences m1221a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: b */
    public void m1237b() {
        this.f820a.m1259b();
    }

    /* renamed from: e */
    public boolean m1246e() {
        return this.f820a.f828b;
    }

    /* renamed from: a */
    public int m1224a() {
        return this.f820a.f823a;
    }

    /* renamed from: a */
    public void m1232a(boolean z) {
        this.f820a.m1256a(z);
        m1221a(this.f819a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a */
    public void m1228a(int i) {
        this.f820a.m1253a(i);
        m1221a(this.f819a).edit().putInt("envType", i).commit();
    }

    /* renamed from: f */
    public boolean m1248f() {
        return !this.f820a.f826a;
    }
}
