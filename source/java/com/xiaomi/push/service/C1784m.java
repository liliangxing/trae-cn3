package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.lynx.tasm.event.LynxSwiperEvent;
import com.optimize.statistics.FrescoMonitorConst;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1487au;
import com.xiaomi.push.C1607ff;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1631gc;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1697m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1784m {

    /* renamed from: a */
    private static volatile C1784m f3152a;

    /* renamed from: a */
    private long f3154a;

    /* renamed from: a */
    private final Context f3155a;

    /* renamed from: a */
    private final SharedPreferences f3156a;

    /* renamed from: b */
    private final boolean f3163b;

    /* renamed from: c */
    private final boolean f3165c;

    /* renamed from: a */
    private final AtomicInteger f3158a = new AtomicInteger(0);

    /* renamed from: a */
    private String f3157a = null;

    /* renamed from: a */
    private volatile boolean f3159a = false;

    /* renamed from: b */
    private String f3161b = null;

    /* renamed from: b */
    private final AtomicInteger f3162b = new AtomicInteger(0);

    /* renamed from: c */
    private final AtomicInteger f3164c = new AtomicInteger(0);

    /* renamed from: a */
    private int f3153a = -1;

    /* renamed from: b */
    private long f3160b = -1;

    /* renamed from: d */
    private final boolean f3166d = m3890g();

    /* renamed from: a */
    public void m3892a() {
    }

    private C1784m(Context context) {
        this.f3155a = context;
        this.f3165c = C1694j.m3427a(context);
        this.f3163b = C1750ah.m3674a(context).m3686a(EnumC1638gj.IntelligentHeartbeatSwitchBoolean.m2760a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f3156a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.m3904c(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.m3904c(), currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.m3910i(), -1L);
        this.f3154a = j;
        if (j == -1) {
            this.f3154a = currentTimeMillis;
            sharedPreferences.edit().putLong(a.m3910i(), currentTimeMillis).apply();
        }
    }

    /* renamed from: a */
    public static C1784m m3872a(Context context) {
        if (f3152a == null) {
            synchronized (C1784m.class) {
                if (f3152a == null) {
                    f3152a = new C1784m(context);
                }
            }
        }
        return f3152a;
    }

    /* renamed from: a */
    public synchronized void m3894a(C1487au c1487au) {
        if (m3884d()) {
            String str = null;
            if (c1487au != null) {
                if (c1487au.m1557a() == 0) {
                    String m1563b = c1487au.m1563b();
                    if (!TextUtils.isEmpty(m1563b) && !"UNKNOWN".equalsIgnoreCase(m1563b)) {
                        str = "M-" + m1563b;
                    }
                    m3877b(str);
                    this.f3153a = 0;
                } else {
                    if (c1487au.m1557a() != 1 && c1487au.m1557a() != 6) {
                        m3877b(null);
                        this.f3153a = -1;
                    }
                    m3877b("WIFI-ID-UNKNOWN");
                    this.f3153a = 1;
                }
            } else {
                m3877b(null);
                this.f3153a = -1;
            }
        }
    }

    /* renamed from: a */
    public synchronized void m3895a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m3885e();
        }
        if (m3884d() && !TextUtils.isEmpty(str)) {
            m3877b("W-" + str);
        }
    }

    /* renamed from: b */
    private void m3877b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f3157a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.f3166d) {
                    this.f3157a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f3157a = null;
                }
            }
        } else {
            this.f3157a = str;
        }
        int i = this.f3156a.getInt(a.m3901a(this.f3157a), -1);
        long j = this.f3156a.getLong(a.m3903b(this.f3157a), -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (i != -1) {
            if (j == -1) {
                this.f3156a.edit().putLong(a.m3903b(this.f3157a), currentTimeMillis + m3882d()).apply();
            } else if (currentTimeMillis > j) {
                this.f3156a.edit().remove(a.m3901a(this.f3157a)).remove(a.m3903b(this.f3157a)).apply();
            }
        }
        this.f3158a.getAndSet(0);
        if (TextUtils.isEmpty(this.f3157a) || m3871a() != -1) {
            this.f3159a = false;
        } else {
            this.f3159a = true;
        }
        AbstractC1417b.m1089a(String.format("[HB] network changed, netid:%s, %s", this.f3157a, Boolean.valueOf(this.f3159a)));
    }

    /* renamed from: b */
    public void m3897b() {
        if (m3884d()) {
            m3887f();
            if (this.f3159a && !TextUtils.isEmpty(this.f3157a) && this.f3157a.equals(this.f3161b)) {
                this.f3158a.getAndIncrement();
                AbstractC1417b.m1089a("[HB] ping timeout count:" + this.f3158a);
                if (m3875a()) {
                    AbstractC1417b.m1089a("[HB] change hb interval for net:" + this.f3157a);
                    m3880c(this.f3157a);
                    this.f3159a = false;
                    this.f3158a.getAndSet(0);
                    m3883d(this.f3157a);
                }
            }
        }
    }

    /* renamed from: c */
    public void m3898c() {
        if (m3884d()) {
            this.f3161b = this.f3157a;
        }
    }

    /* renamed from: d */
    public void m3899d() {
        if (m3884d()) {
            m3889g();
            if (this.f3159a) {
                this.f3158a.getAndSet(0);
            }
        }
    }

    /* renamed from: a */
    public void m3893a(int i) {
        this.f3156a.edit().putLong(a.m3911j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    /* renamed from: c */
    private long m3879c() {
        return this.f3156a.getLong(a.m3911j(), -1L);
    }

    /* renamed from: a */
    private boolean m3875a() {
        return this.f3158a.get() >= Math.max(C1750ah.m3674a(this.f3155a).m3678a(EnumC1638gj.IntelligentHeartbeatNATCountInt.m2760a(), 3), 3);
    }

    /* renamed from: a */
    public long m3891a() {
        int m3871a;
        long m2547b = C1607ff.m2547b();
        if (this.f3165c && !m3878b() && ((C1750ah.m3674a(this.f3155a).m3686a(EnumC1638gj.IntelligentHeartbeatSwitchBoolean.m2760a(), true) || m3879c() >= System.currentTimeMillis()) && (m3871a = m3871a()) != -1)) {
            m2547b = m3871a;
        }
        if (!TextUtils.isEmpty(this.f3157a) && !"WIFI-ID-UNKNOWN".equals(this.f3157a) && this.f3153a == 1) {
            m3874a(m2547b < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL);
        }
        this.f3160b = m2547b;
        AbstractC1417b.m1089a("[HB] ping interval:" + m2547b);
        return m2547b;
    }

    /* renamed from: b */
    public long m3896b() {
        return this.f3160b;
    }

    /* renamed from: b */
    private boolean m3878b() {
        if (!TextUtils.isEmpty(this.f3157a)) {
            if (this.f3157a.startsWith("M-")) {
                if (!C1750ah.m3674a(this.f3155a).m3686a(EnumC1638gj.IntelligentHeartbeatUseInMobileNetworkBoolean.m2760a(), false)) {
                    return true;
                }
            } else if (this.f3157a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m3890g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m3871a() {
        if (TextUtils.isEmpty(this.f3157a)) {
            return -1;
        }
        try {
            return this.f3156a.getInt(a.m3901a(this.f3157a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: c */
    private void m3880c(String str) {
        if (m3876a(str)) {
            this.f3156a.edit().putInt(a.m3901a(str), 235000).apply();
            this.f3156a.edit().putLong(a.m3903b(this.f3157a), System.currentTimeMillis() + m3882d()).apply();
        }
    }

    /* renamed from: d */
    private long m3882d() {
        return C1750ah.m3674a(this.f3155a).m3680a(EnumC1638gj.ShortHeartbeatEffectivePeriodMsLong.m2760a(), 7776000000L);
    }

    /* renamed from: a */
    private boolean m3876a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    /* renamed from: d */
    private void m3883d(String str) {
        String str2;
        String str3;
        if (m3881c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f3156a.getString(a.m3907f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f3156a.edit().putString(a.m3907f(), str3).apply();
        }
    }

    /* renamed from: a */
    private void m3874a(boolean z) {
        String m3906e;
        if (m3881c()) {
            int incrementAndGet = (z ? this.f3162b : this.f3164c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            AbstractC1417b.m1098b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                if (z) {
                    m3906e = a.m3905d();
                } else {
                    m3906e = a.m3906e();
                }
                int i = this.f3156a.getInt(m3906e, 0) + incrementAndGet;
                this.f3156a.edit().putInt(m3906e, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                AbstractC1417b.m1089a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f3162b.set(0);
                } else {
                    this.f3164c.set(0);
                }
            }
        }
    }

    /* renamed from: e */
    private void m3885e() {
        if (this.f3156a.getBoolean(a.m3900a(), false)) {
            return;
        }
        this.f3156a.edit().putBoolean(a.m3900a(), true).apply();
    }

    /* renamed from: f */
    private void m3887f() {
        String m3908g;
        int i = this.f3153a;
        if (i == 0) {
            m3908g = a.m3908g();
        } else {
            m3908g = i != 1 ? null : a.m3909h();
        }
        if (TextUtils.isEmpty(m3908g)) {
            return;
        }
        if (this.f3156a.getLong(a.m3910i(), -1L) == -1) {
            this.f3154a = System.currentTimeMillis();
            this.f3156a.edit().putLong(a.m3910i(), this.f3154a).apply();
        }
        this.f3156a.edit().putInt(m3908g, this.f3156a.getInt(m3908g, 0) + 1).apply();
    }

    /* renamed from: g */
    private void m3889g() {
        int i;
        String[] split;
        String[] split2;
        if (m3881c()) {
            String string = this.f3156a.getString(a.m3907f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c2];
                        String str2 = split2[c];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", LynxSwiperEvent.EVENT_CHANGE);
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put("interval", str3);
                        hashMap.put(FrescoMonitorConst.TIMESTAMP, str4);
                        m3873a("category_hb_change", null, hashMap);
                        AbstractC1417b.m1089a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f3156a.edit().remove(a.m3907f()).apply();
            }
            if (this.f3156a.getBoolean(a.m3900a(), false)) {
                long j = this.f3156a.getLong(a.m3902b(), 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j > 1296000000) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", "support");
                    hashMap2.put("model", Build.MODEL);
                    hashMap2.put(FrescoMonitorConst.TIMESTAMP, String.valueOf(System.currentTimeMillis() / 1000));
                    m3873a("category_hb_change", null, hashMap2);
                    AbstractC1417b.m1089a("[HB] report support wifi digest events.");
                    this.f3156a.edit().putLong(a.m3902b(), currentTimeMillis).apply();
                }
            }
            if (m3886e()) {
                int i3 = this.f3156a.getInt(a.m3905d(), 0);
                int i4 = this.f3156a.getInt(a.m3906e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j2 = this.f3156a.getLong(a.m3904c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j2);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        m3873a("category_hb_count", jSONObject2, hashMap3);
                        AbstractC1417b.m1089a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f3156a.edit().putInt(a.m3905d(), 0).putInt(a.m3906e(), 0).putLong(a.m3904c(), System.currentTimeMillis()).apply();
            }
            if (m3888f()) {
                String valueOf4 = String.valueOf(this.f3154a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f3156a.getInt(a.m3908g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        m3873a("category_lc_ptc", jSONObject4, hashMap4);
                        AbstractC1417b.m1089a("[HB] report ping timeout count events of mobile network.");
                        this.f3156a.edit().putInt(a.m3908g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f3156a.edit().putInt(a.m3908g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f3156a.getInt(a.m3909h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        m3873a("category_lc_ptc", jSONObject6, hashMap5);
                        AbstractC1417b.m1089a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f3156a.edit().putInt(a.m3909h(), 0).apply();
                }
                this.f3154a = System.currentTimeMillis();
                this.f3156a.edit().putLong(a.m3910i(), this.f3154a).apply();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3873a(String str, String str2, Map<String, String> map) {
        String str3;
        C1631gc m2707a;
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d(str);
        c1637gi.m2742c("hb_name");
        c1637gi.m2727a("hb_channel");
        c1637gi.m2726a(1L);
        c1637gi.m2738b(str2);
        c1637gi.m2729a(false);
        c1637gi.m2737b(System.currentTimeMillis());
        c1637gi.m2754g(this.f3155a.getPackageName());
        c1637gi.m2749e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        C1787p m3955a = C1788q.m3955a(this.f3155a);
        if (m3955a != null && !TextUtils.isEmpty(m3955a.f3196a)) {
            String[] split = m3955a.f3196a.split("@");
            if (split.length > 0) {
                str3 = split[0];
                map.put("uuid", str3);
                map.put("model", Build.MODEL);
                Context context = this.f3155a;
                map.put("avc", String.valueOf(C1628g.m2677a(context, context.getPackageName())));
                map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
                map.put("cvc", String.valueOf(48));
                c1637gi.m2728a(map);
                m2707a = C1631gc.m2707a(this.f3155a);
                if (m2707a == null) {
                    m2707a.m2711a(c1637gi, this.f3155a.getPackageName());
                    return;
                }
                return;
            }
        }
        str3 = null;
        map.put("uuid", str3);
        map.put("model", Build.MODEL);
        Context context2 = this.f3155a;
        map.put("avc", String.valueOf(C1628g.m2677a(context2, context2.getPackageName())));
        map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        map.put("cvc", String.valueOf(48));
        c1637gi.m2728a(map);
        m2707a = C1631gc.m2707a(this.f3155a);
        if (m2707a == null) {
        }
    }

    /* renamed from: c */
    private boolean m3881c() {
        return m3884d() && C1750ah.m3674a(this.f3155a).m3686a(EnumC1638gj.IntelligentHeartbeatDataCollectSwitchBoolean.m2760a(), true) && EnumC1697m.China.name().equals(C1769b.m3796a(this.f3155a).m3799a());
    }

    /* renamed from: d */
    private boolean m3884d() {
        return this.f3165c && (this.f3163b || this.f3166d || ((m3879c() > System.currentTimeMillis() ? 1 : (m3879c() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    /* renamed from: e */
    private boolean m3886e() {
        long j = this.f3156a.getLong(a.m3904c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    /* renamed from: f */
    private boolean m3888f() {
        if (this.f3154a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f3154a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    /* renamed from: g */
    private boolean m3890g() {
        return C1750ah.m3674a(this.f3155a).m3686a(EnumC1638gj.IntelligentHeartbeatForUnsupportWifiDigestBoolean.m2760a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {
        /* renamed from: a */
        public static String m3900a() {
            return "support_wifi_digest";
        }

        /* renamed from: b */
        public static String m3902b() {
            return "record_support_wifi_digest_reported_time";
        }

        /* renamed from: c */
        public static String m3904c() {
            return "record_hb_count_start";
        }

        /* renamed from: d */
        public static String m3905d() {
            return "record_short_hb_count";
        }

        /* renamed from: e */
        public static String m3906e() {
            return "record_long_hb_count";
        }

        /* renamed from: f */
        public static String m3907f() {
            return "record_hb_change";
        }

        /* renamed from: g */
        public static String m3908g() {
            return "record_mobile_ptc";
        }

        /* renamed from: h */
        public static String m3909h() {
            return "record_wifi_ptc";
        }

        /* renamed from: i */
        public static String m3910i() {
            return "record_ptc_start";
        }

        /* renamed from: j */
        public static String m3911j() {
            return "keep_short_hb_effective_time";
        }

        /* renamed from: a */
        public static String m3901a(String str) {
            return String.format("HB_%s", str);
        }

        /* renamed from: b */
        public static String m3903b(String str) {
            return String.format("HB_dead_time_%s", str);
        }
    }
}
