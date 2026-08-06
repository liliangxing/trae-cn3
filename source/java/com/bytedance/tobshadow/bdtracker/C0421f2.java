package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.f2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0421f2 {

    /* renamed from: m */
    public static final String[] f583m = {Constant.KEY_CHANNEL, "package", Constant.KEY_APP_VERSION};

    /* renamed from: a */
    public volatile boolean f584a;

    /* renamed from: b */
    public final Context f585b;

    /* renamed from: c */
    public final C0407d2 f586c;

    /* renamed from: e */
    public boolean f588e;

    /* renamed from: g */
    public final IKVStore f590g;

    /* renamed from: h */
    public final C0466l5 f591h;

    /* renamed from: i */
    public final C0467m f592i;

    /* renamed from: d */
    public volatile JSONObject f587d = new JSONObject();

    /* renamed from: f */
    public final Set<AbstractC0553y1> f589f = new LinkedHashSet(32);

    /* renamed from: j */
    public int f593j = 0;

    /* renamed from: k */
    public final Set<String> f594k = new HashSet(4);

    /* renamed from: l */
    public final Set<String> f595l = new HashSet();

    /* renamed from: com.bytedance.tobshadow.bdtracker.f2$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", C0421f2.this.f592i.f784m);
                jSONObject.put("did", C0421f2.this.f587d.optString("device_id", ""));
                jSONObject.put("bdDid", C0421f2.this.m415d());
                jSONObject.put("ssid", C0421f2.this.m428j());
                jSONObject.put("installId", C0421f2.this.m422g());
                jSONObject.put("uuid", C0421f2.this.m431l());
                jSONObject.put("uuidType", C0421f2.this.m432m());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.f2$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ JSONObject f597a;

        public b(JSONObject jSONObject) {
            this.f597a = jSONObject;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            C0411e.m375c(this.f597a, jSONObject);
            try {
                jSONObject.put("appId", C0421f2.this.f592i.f784m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0421f2(C0467m c0467m, Context context, C0407d2 c0407d2) {
        this.f592i = c0467m;
        this.f585b = context;
        this.f586c = c0407d2;
        this.f590g = c0407d2.f505f;
        this.f591h = c0467m.f775d.m454a(c0467m, context, c0407d2);
        boolean z = c0407d2.f505f.getBoolean("is_first_app_launch", true);
        String userUniqueId = c0407d2.f502c.getUserUniqueId();
        String userUniqueIdType = c0407d2.f502c.getUserUniqueIdType();
        if (C0411e.m379d(userUniqueId) && z) {
            m427i(userUniqueId);
        }
        if (C0411e.m379d(userUniqueIdType) && z) {
            m429j(userUniqueIdType);
        }
        if (z) {
            c0407d2.f505f.putBoolean("is_first_app_launch", false);
        }
    }

    /* renamed from: a */
    public static void m398a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* renamed from: e */
    public static boolean m399e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return (C0411e.m361a(jSONObject.optString("device_id", "")) || C0411e.m361a(jSONObject.optString("bd_did", ""))) && C0411e.m361a(jSONObject.optString("install_id", "")) && C0411e.m361a(jSONObject.optString("ssid", ""));
    }

    /* renamed from: a */
    public final String m401a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(IWeiboService.Scope.EMPTY_SCOPE);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final synchronized void m403a(String str) {
        String optString = this.f587d.optString("ab_sdk_version");
        if (!TextUtils.isEmpty(optString)) {
            for (String str2 : optString.split(IWeiboService.Scope.EMPTY_SCOPE)) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), C0380a.m251a("addExposedVid ready added: ", optString), new Object[0]);
                    return;
                }
            }
            str = optString + IWeiboService.Scope.EMPTY_SCOPE + str;
        }
        m421f(str);
        m404a(str, this.f586c.m316c());
    }

    /* renamed from: b */
    public void m410b(String str) {
        C0466l5 c0466l5 = this.f591h;
        if (c0466l5 instanceof C0466l5) {
            c0466l5.f756e.f764D.debug(c0466l5.f758g, "DeviceParamsProvider#clearDidAndIid clearKey=" + str + " sDeviceId=" + C0466l5.f750l, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                C0466l5.f750l = null;
                String m251a = C0380a.m251a("clear_key_prefix", str);
                InitConfig initConfig = c0466l5.f757f.f502c;
                IKVStore m439a = C0424f5.m439a(initConfig, c0466l5.f752a, initConfig.getSpName());
                if (!m439a.getBoolean(m251a, false)) {
                    m439a.putBoolean(m251a, true);
                    if (m439a.contains("device_id")) {
                        m439a.remove("device_id");
                    }
                    if (m439a.contains("install_id")) {
                        m439a.remove("install_id");
                    }
                    c0466l5.f753b.mo530a("device_id");
                    c0466l5.f756e.f764D.debug(c0466l5.f758g, "clearKey:{} installId and deviceId finish", str);
                } else {
                    c0466l5.f756e.f764D.debug(c0466l5.f758g, "clearKey:{} is already cleared", str);
                }
            }
        }
        this.f586c.f505f.remove("device_token");
    }

    /* renamed from: b */
    public final void m411b(JSONObject jSONObject) {
        this.f587d = jSONObject;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("set_header", new b(jSONObject));
    }

    /* renamed from: c */
    public String m412c() {
        return this.f586c.f502c.getAid();
    }

    /* renamed from: c */
    public final Set<String> m413c(String str) {
        String[] split;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (split = str.split(IWeiboService.Scope.EMPTY_SCOPE)) != null && split.length > 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: d */
    public String m415d() {
        return this.f587d.optString("bd_did", "");
    }

    /* renamed from: d */
    public void m416d(String str) {
        JSONObject m418e;
        if (TextUtils.isEmpty(str) || (m418e = m418e()) == null || !m418e.has(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        C0411e.m351a(jSONObject, m418e);
        jSONObject.remove(str);
        m414c(jSONObject);
    }

    /* renamed from: e */
    public final JSONObject m418e() {
        if (this.f584a) {
            return this.f587d.optJSONObject("custom");
        }
        C0407d2 c0407d2 = this.f586c;
        if (c0407d2 != null) {
            try {
                return new JSONObject(c0407d2.f503d.getString("header_custom_info", null));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: f */
    public JSONObject m420f() {
        if (this.f584a) {
            return this.f587d;
        }
        return null;
    }

    /* renamed from: g */
    public String m422g() {
        return this.f587d.optString("install_id", "");
    }

    /* renamed from: h */
    public String m424h() {
        return this.f587d.optString("openudid", "");
    }

    /* renamed from: h */
    public boolean m425h(String str) {
        if (!m407a("ssid", (Object) str)) {
            return false;
        }
        this.f590g.putString(this.f586c.m318e(), str);
        return true;
    }

    /* renamed from: i */
    public int m426i() {
        if (m399e(this.f587d)) {
            return this.f590g.getInt("version_code", 0) == this.f587d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: j */
    public String m428j() {
        if (this.f584a) {
            return this.f587d.optString("ssid", "");
        }
        C0407d2 c0407d2 = this.f586c;
        return c0407d2 != null ? c0407d2.f505f.getString(c0407d2.m318e(), "") : "";
    }

    /* renamed from: k */
    public String m430k() {
        return this.f587d.optString("udid", "");
    }

    /* renamed from: l */
    public String m431l() {
        if (this.f584a) {
            return this.f587d.optString("user_unique_id", "");
        }
        C0407d2 c0407d2 = this.f586c;
        return c0407d2 != null ? c0407d2.m319f() : "";
    }

    /* renamed from: m */
    public String m432m() {
        return this.f587d.optString("user_unique_id_type", this.f586c.m320g());
    }

    /* renamed from: n */
    public int m433n() {
        int optInt = this.f584a ? this.f587d.optInt("version_code", -1) : C0508r5.m640a(this.f585b);
        for (int i = 0; i < 3 && optInt == -1; i++) {
            optInt = this.f584a ? this.f587d.optInt("version_code", -1) : C0508r5.m640a(this.f585b);
        }
        return optInt;
    }

    /* renamed from: o */
    public String m434o() {
        String optString = this.f584a ? this.f587d.optString(Constant.KEY_APP_VERSION) : C0508r5.m643b(this.f585b);
        for (int i = 0; i < 3 && TextUtils.isEmpty(optString); i++) {
            optString = this.f584a ? this.f587d.optString(Constant.KEY_APP_VERSION) : C0508r5.m643b(this.f585b);
        }
        return optString;
    }

    /* renamed from: p */
    public boolean m435p() {
        return this.f584a && m399e(this.f587d);
    }

    /* renamed from: q */
    public boolean m436q() {
        return this.f588e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x016a, code lost:
    
        if ((!r16.f586c.m323j() && r11.f1256d) != false) goto L92;
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m437r() {
        C0497q1 c0497q1;
        this.f589f.add(new C0560z1(this.f592i, this.f586c));
        this.f589f.add(new C0399c2(this.f592i, this.f585b, this.f586c));
        this.f589f.add(new C0442i2(this.f592i, this.f585b));
        this.f589f.add(new C0456k2(this.f585b));
        this.f589f.add(new C0491p2(this.f585b, this.f586c, this, this.f592i.getInitConfig() != null ? this.f592i.getInitConfig().getSensitiveInfoProvider() : null));
        this.f589f.add(new C0463l2(this.f585b));
        this.f589f.add(new C0477n2(this.f592i, this.f585b, this.f586c));
        this.f589f.add(new C0484o2());
        this.f589f.add(new C0498q2(this.f585b, this.f586c, this));
        this.f589f.add(new C0505r2(this.f592i, this.f585b));
        this.f589f.add(new C0512s2(this.f586c, this.f585b));
        this.f589f.add(new C0428g2(this.f585b, this.f586c, this));
        this.f589f.add(new C0391b2(this.f586c));
        this.f589f.add(new C0532v1(this.f585b));
        this.f589f.add(new C0383a2(this.f592i));
        this.f589f.add(new C0449j2(this.f585b, this.f586c));
        this.f589f.add(new C0470m2(this.f585b, this.f586c));
        JSONObject jSONObject = this.f587d;
        JSONObject jSONObject2 = new JSONObject();
        C0411e.m351a(jSONObject2, jSONObject);
        Iterator<AbstractC0553y1> it = this.f589f.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            AbstractC0553y1 next = it.next();
            if (this.f586c.f502c.getLoaderFilters().contains(next.mo253a())) {
                this.f592i.f764D.debug(C0380a.m252a("Filter ").append(next.mo253a()).append(" Loader").toString(), new Object[0]);
            } else {
                if (next.f1253a && !next.f1255c) {
                }
                try {
                    next.f1253a = next.mo255a(jSONObject2);
                } catch (SecurityException e) {
                    if (!next.f1254b) {
                        i++;
                        this.f592i.f764D.warn(Collections.singletonList("DeviceManager"), C0380a.m252a("loadHeader mCountPermission: ").append(this.f593j).toString(), e);
                        if (!next.f1253a && this.f593j > 10) {
                            next.f1253a = true;
                        }
                    }
                    this.f592i.m522b().mo639a(e, "load SecurityException");
                } catch (JSONException e2) {
                    this.f592i.f764D.error("loader load error", e2, new Object[0]);
                    this.f592i.m522b().mo639a(e2, "load JSONException");
                } catch (Throwable th) {
                    this.f592i.m522b().mo639a(th, "load");
                }
                if (!next.f1253a && !next.f1254b) {
                    i2++;
                }
                this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), "Loader:{} is ready:{}", next.mo253a(), Boolean.valueOf(next.f1253a));
                z &= next.f1253a || next.f1254b;
            }
        }
        if (z) {
            for (String str : f583m) {
                boolean isEmpty = TextUtils.isEmpty(jSONObject2.optString(str));
                z &= !isEmpty;
                if (isEmpty) {
                    this.f592i.f764D.warn(Collections.singletonList("DeviceManager"), "Key " + str + " is empty!", new Object[0]);
                }
            }
        }
        synchronized (this) {
            JSONObject jSONObject3 = this.f587d;
            for (String str2 : this.f594k) {
                this.f592i.f764D.debug("Loader newHeader remove " + str2, new Object[0]);
                jSONObject2.remove(str2);
            }
            m411b(jSONObject2);
            Iterator<String> keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String next2 = keys.next();
                m407a(next2, jSONObject3.opt(next2));
            }
            this.f584a = z;
        }
        this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), "Loader header ready:{}, permission count:{}, header:{}", Boolean.valueOf(this.f584a), Integer.valueOf(this.f593j), this.f587d);
        if (i > 0 && i == i2) {
            this.f593j++;
            if (m426i() != 0) {
                this.f593j += 10;
            }
        }
        if (this.f584a && (c0497q1 = this.f592i.f796y) != null) {
            c0497q1.onIdLoaded(m415d(), m422g(), m428j());
        }
        if (!LogUtils.isDisabled() && C0411e.m379d(m428j())) {
            LogUtils.sendJsonFetcher("local_did_load", new a());
        }
        return this.f584a;
    }

    /* renamed from: c */
    public final void m414c(JSONObject jSONObject) {
        if (m407a("custom", jSONObject)) {
            this.f586c.f503d.putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "");
        }
    }

    /* renamed from: f */
    public void m421f(String str) {
        if (m407a("ab_sdk_version", (Object) str)) {
            this.f586c.f503d.putString("ab_sdk_version", str);
        }
    }

    /* renamed from: d */
    public final synchronized void m417d(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f592i.f764D.warn("null abconfig", new Object[0]);
        }
        String optString = this.f587d.optString("ab_sdk_version");
        if (!TextUtils.isEmpty(optString)) {
            Set<String> m413c = m413c(optString);
            HashSet hashSet = new HashSet();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                hashSet.add(jSONObject.getJSONObject(str).optString("vid"));
                            } catch (JSONException e) {
                                this.f592i.f764D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", e, new Object[0]);
                            }
                        }
                    }
                }
            }
            String m316c = this.f586c.m316c();
            hashSet.addAll(m413c(m316c));
            m413c.retainAll(hashSet);
            String m401a = m401a(m413c);
            m421f(m401a);
            if (!TextUtils.equals(optString, m401a)) {
                m404a(m401a, m316c);
            }
        }
    }

    /* renamed from: g */
    public synchronized void m423g(String str) {
        Set<String> m413c = m413c(this.f586c.m316c());
        String m316c = this.f586c.m316c();
        Set<String> m413c2 = m413c(this.f587d.optString("ab_sdk_version"));
        m413c2.removeAll(m413c);
        m413c2.addAll(m413c(str));
        C0407d2 c0407d2 = this.f586c;
        c0407d2.f501b.f764D.debug(Collections.singletonList("ConfigManager"), "setExternalAbVersion:{}", str);
        c0407d2.f503d.putString("external_ab_version", str);
        c0407d2.f507h = null;
        m421f(m401a(m413c2));
        if (!C0411e.m362a(m316c, this.f586c.m316c())) {
            m404a(m409b(), this.f586c.m316c());
        }
    }

    /* renamed from: a */
    public void m402a() {
        m421f(null);
        m423g("");
        m406a((JSONObject) null);
        this.f595l.clear();
    }

    /* renamed from: e */
    public final void m419e(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ab_sdk_version", str);
            this.f592i.onEventV3("abtest_exposure", jSONObject, 0);
        } catch (Throwable th) {
            this.f592i.f764D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
            this.f592i.m522b().mo639a(th, "sendAbTestExposureEvent");
        }
    }

    /* renamed from: j */
    public void m429j(String str) {
        if (m407a("user_unique_id_type", (Object) str)) {
            this.f586c.f503d.putString("user_unique_id_type", str);
        }
    }

    /* renamed from: a */
    public <T> T m400a(String str, T t, Class<T> cls) {
        return (T) this.f592i.f781j.m500a(this.f587d, str, (String) t, (Class<String>) cls);
    }

    /* renamed from: i */
    public boolean m427i(String str) {
        if (!m407a("user_unique_id", (Object) str)) {
            return false;
        }
        this.f586c.f503d.putString("user_unique_id", C0411e.m347a((Object) str));
        return true;
    }

    /* renamed from: a */
    public final void m404a(String str, String str2) {
        if (this.f586c.m321h() && this.f586c.f502c.isAbEnable()) {
            Set<String> m413c = m413c(str);
            m413c.removeAll(m413c(str2));
            C0497q1 c0497q1 = this.f592i.f796y;
            if (c0497q1 != null) {
                c0497q1.onAbVidsChange(m401a(m413c), str2);
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m408a(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), "saveRegisterInfo -> uuid:" + str + ", did:" + str2 + ", iid:" + str3 + ", ssid:" + str4 + ", did:" + str5 + ", cd:" + str6 + ", response:{}", jSONObject);
        if (!C0411e.m362a(m431l(), str)) {
            this.f592i.f764D.debug(1, "saveRegisterInfo interrupted for uuid is changed", new Object[0]);
            return false;
        }
        this.f588e = jSONObject.optInt("new_user", 0) > 0;
        String optString = jSONObject.optString("device_token", "");
        boolean m361a = C0411e.m361a(str2);
        boolean m361a2 = C0411e.m361a(str3);
        boolean m361a3 = C0411e.m361a(str5);
        boolean m361a4 = C0411e.m361a(str6);
        boolean m361a5 = C0411e.m361a(str4);
        try {
            int i = this.f590g.getInt("version_code", 0);
            int optInt = this.f587d.optInt("version_code", 0);
            if (i != optInt) {
                this.f590g.putInt("version_code", optInt);
            }
            String string = this.f590g.getString(Constant.KEY_CHANNEL, "");
            String optString2 = this.f587d.optString(Constant.KEY_CHANNEL, "");
            if (!TextUtils.equals(string, optString2)) {
                this.f590g.putString(Constant.KEY_CHANNEL, optString2);
            }
            this.f590g.putString("device_token", optString);
            if ((m361a || (m361a3 && m361a4)) && m361a2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f590g.putLong("register_time", currentTimeMillis);
                m407a("register_time", Long.valueOf(currentTimeMillis));
            } else if (!m361a && (!m361a3 || !m361a4)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                this.f592i.onEventV3("tt_fetch_did_error", jSONObject2, 0);
            }
            String m512b = this.f591h.m512b();
            String string2 = this.f590g.getString("bd_did", null);
            this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), "device: od=" + m512b + " nd=" + str2 + " ck=" + m361a, new Object[0]);
            if (m361a) {
                if (str2.equals(this.f587d.optString("device_id"))) {
                    z = false;
                } else {
                    JSONObject jSONObject3 = this.f587d;
                    JSONObject jSONObject4 = new JSONObject();
                    C0411e.m351a(jSONObject4, jSONObject3);
                    jSONObject4.put("device_id", str2);
                    m411b(jSONObject4);
                    this.f591h.m513b(str2);
                    z = true;
                }
                if (!str2.equals(m512b)) {
                    z = true;
                }
            } else {
                z = false;
            }
            if (m361a3 && m407a("bd_did", (Object) str5)) {
                this.f590g.putString("bd_did", str5);
                z = true;
            }
            String optString3 = this.f587d.optString("install_id", "");
            if (m361a2 && m407a("install_id", (Object) str3)) {
                this.f590g.putString("install_id", str3);
                z = true;
            }
            String optString4 = this.f587d.optString("ssid", "");
            boolean z2 = (m361a5 && m425h(str4)) ? true : z;
            if (this.f592i.f796y != null) {
                this.f592i.f796y.onRemoteIdGet(z2, string2, str5, optString3, str3, optString4, m361a5 ? str4 : "");
            }
            if (!m361a5 || (!m361a3 && !m361a)) {
                this.f592i.m522b().mo639a(new Throwable("device register failed, ssid:" + str4 + ", bdDid: " + str5), "saveRegisterInfo");
            }
        } catch (Throwable th) {
            this.f592i.f764D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
            this.f592i.m522b().mo639a(th, "saveRegisterInfo");
        }
        return (m361a || (m361a3 && m361a4)) && m361a2 && m361a5;
    }

    /* renamed from: b */
    public String m409b() {
        if (this.f584a) {
            return this.f587d.optString("ab_sdk_version", "");
        }
        C0407d2 c0407d2 = this.f586c;
        return c0407d2 != null ? c0407d2.f503d.getString("ab_sdk_version", "") : "";
    }

    /* renamed from: a */
    public void m406a(JSONObject jSONObject) {
        C0407d2 c0407d2 = this.f586c;
        c0407d2.f501b.f764D.debug(Collections.singletonList("ConfigManager"), "setAbConfig:{}", jSONObject);
        c0407d2.f503d.putString("ab_configure", jSONObject == null ? "" : jSONObject.toString());
        c0407d2.f506g = null;
        if (!LogUtils.isDisabled()) {
            LogUtils.sendJsonFetcher("set_abconfig", new C0414e2(c0407d2, jSONObject));
        }
        m417d(jSONObject);
    }

    /* renamed from: a */
    public void m405a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject;
        if (hashMap == null || hashMap.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONObject m418e = m418e();
            if (m418e != null) {
                C0411e.m351a(jSONObject, m418e);
            }
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                this.f592i.f764D.error(Collections.singletonList("DeviceManager"), "Set custom header failed", th, new Object[0]);
            }
        }
        m414c(jSONObject);
    }

    /* renamed from: a */
    public final boolean m407a(String str, Object obj) {
        Object opt = this.f587d.opt(str);
        if (obj == opt || (obj != null && obj.equals(opt))) {
            if (this.f584a || obj != null || opt != null) {
                return false;
            }
            this.f592i.f764D.debug(C0380a.m251a("未初始化时都为 null 无法做到赋值的: ", str), new Object[0]);
            return true;
        }
        synchronized (this) {
            try {
                JSONObject jSONObject = this.f587d;
                JSONObject jSONObject2 = new JSONObject();
                C0411e.m351a(jSONObject2, jSONObject);
                jSONObject2.put(str, obj);
                if (!this.f584a && obj == null) {
                    this.f594k.add(str);
                }
                m411b(jSONObject2);
            } catch (JSONException e) {
                this.f592i.f764D.error(Collections.singletonList("DeviceManager"), "Update header:{} to value:{} failed", e, str, obj);
                this.f592i.m522b().mo639a(e, "updateHeader");
            }
        }
        this.f592i.f764D.debug(Collections.singletonList("DeviceManager"), "Update header:{} from old:{} to new value:{}", str, opt, obj);
        return true;
    }
}
