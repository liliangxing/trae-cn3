package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.lynx.tasm.behavior.PropsConstants;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.update.UpdateDialogNewBase;
import com.ttnet.org.chromium.base.TTProcessUtils;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C1769b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cf */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1526cf {

    /* renamed from: a */
    protected static Context f1158a;

    /* renamed from: a */
    private static a f1159a;

    /* renamed from: a */
    private static C1526cf f1160a;

    /* renamed from: c */
    private static String f1163c;

    /* renamed from: d */
    private static String f1164d;

    /* renamed from: a */
    private long f1165a;

    /* renamed from: a */
    private InterfaceC1525ce f1166a;

    /* renamed from: a */
    protected b f1167a;

    /* renamed from: a */
    private String f1168a;

    /* renamed from: a */
    protected final Map<String, C1523cc> f1169a;

    /* renamed from: b */
    private final long f1170b;

    /* renamed from: b */
    private String f1171b;

    /* renamed from: c */
    private long f1172c;

    /* renamed from: b */
    protected static final Map<String, C1522cb> f1162b = new HashMap();

    /* renamed from: a */
    protected static boolean f1161a = false;

    /* renamed from: com.xiaomi.push.cf$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        C1526cf mo1843a(Context context, InterfaceC1525ce interfaceC1525ce, b bVar, String str);
    }

    /* renamed from: com.xiaomi.push.cf$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface b {
        /* renamed from: a */
        String mo1844a(String str);
    }

    /* renamed from: f */
    private String m1820f() {
        return "host_fallbacks";
    }

    /* renamed from: b */
    protected String m1831b() {
        return "resolver.msg.xiaomi.net";
    }

    /* renamed from: a */
    public static synchronized C1526cf m1812a() {
        C1526cf c1526cf;
        synchronized (C1526cf.class) {
            c1526cf = f1160a;
            if (c1526cf == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return c1526cf;
    }

    /* renamed from: a */
    public static synchronized void m1817a(a aVar) {
        synchronized (C1526cf.class) {
            f1159a = aVar;
            f1160a = null;
        }
    }

    /* renamed from: a */
    public static synchronized void m1816a(Context context, InterfaceC1525ce interfaceC1525ce, b bVar, String str, String str2, String str3) {
        synchronized (C1526cf.class) {
            Context applicationContext = context.getApplicationContext();
            f1158a = applicationContext;
            if (applicationContext == null) {
                f1158a = context;
            }
            if (f1160a == null) {
                a aVar = f1159a;
                if (aVar == null) {
                    f1160a = new C1526cf(context, interfaceC1525ce, bVar, str, str2, str3);
                } else {
                    f1160a = aVar.mo1843a(context, interfaceC1525ce, bVar, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1526cf(Context context, InterfaceC1525ce interfaceC1525ce, b bVar, String str) {
        this(context, interfaceC1525ce, bVar, str, null, null);
    }

    protected C1526cf(Context context, InterfaceC1525ce interfaceC1525ce, b bVar, String str, String str2, String str3) {
        this.f1169a = new HashMap();
        this.f1168a = "0";
        this.f1165a = 0L;
        this.f1170b = 15L;
        this.f1172c = 0L;
        this.f1171b = "isp_prov_city_country_ip";
        this.f1167a = bVar;
        if (interfaceC1525ce == null) {
            this.f1166a = new InterfaceC1525ce() { // from class: com.xiaomi.push.cf.1
                @Override // com.xiaomi.push.InterfaceC1525ce
                /* renamed from: a */
                public boolean mo1811a(String str4) {
                    return true;
                }
            };
        } else {
            this.f1166a = interfaceC1525ce;
        }
        this.f1168a = str;
        f1163c = str2 == null ? context.getPackageName() : str2;
        f1164d = str3 == null ? m1821g() : str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m1813a() {
        if (f1158a == null) {
            return "unknown";
        }
        try {
            C1487au m1530a = C1486at.m1530a();
            return m1530a == null ? "unknown" : m1530a.m1557a() == 1 ? "WIFI-UNKNOWN" : m1530a.m1560a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m1530a.m1563b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* renamed from: a */
    public C1522cb m1822a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return m1823a(new URL(str).getHost(), true);
    }

    /* renamed from: b */
    public C1522cb m1830b(String str) {
        return m1823a(str, true);
    }

    /* renamed from: a */
    public C1522cb m1823a(String str, boolean z) {
        C1522cb m1840e;
        AbstractC1417b.m1100b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (!this.f1166a.mo1811a(str)) {
            return null;
        }
        C1522cb m1834c = m1834c(str);
        return (m1834c == null || !m1834c.mo1798b()) ? (z && C1486at.m1545a(f1158a) && (m1840e = m1840e(str)) != null) ? m1840e : new C1522cb(str, m1834c) { // from class: com.xiaomi.push.cf.2

            /* renamed from: a */
            C1522cb f1174a;

            /* renamed from: b */
            final /* synthetic */ C1522cb f1176b;

            @Override // com.xiaomi.push.C1522cb
            /* renamed from: b */
            public boolean mo1798b() {
                return false;
            }

            {
                this.f1176b = m1834c;
                this.f1174a = m1834c;
                this.f1145b = this.f1145b;
                if (m1834c != null) {
                    this.f1149f = m1834c.f1149f;
                }
            }

            @Override // com.xiaomi.push.C1522cb
            /* renamed from: a */
            public synchronized ArrayList<String> mo1782a(boolean z2) {
                ArrayList<String> arrayList;
                arrayList = new ArrayList<>();
                C1522cb c1522cb = this.f1174a;
                if (c1522cb != null) {
                    arrayList.addAll(c1522cb.mo1782a(true));
                }
                synchronized (C1526cf.f1162b) {
                    C1522cb c1522cb2 = C1526cf.f1162b.get(this.f1145b);
                    if (c1522cb2 != null) {
                        Iterator<String> it = c1522cb2.mo1782a(true).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                        arrayList.remove(this.f1145b);
                        arrayList.add(this.f1145b);
                    }
                }
                return arrayList;
            }

            @Override // com.xiaomi.push.C1522cb
            /* renamed from: a */
            public synchronized void mo1791a(String str2, C1521ca c1521ca) {
                C1522cb c1522cb = this.f1174a;
                if (c1522cb != null) {
                    c1522cb.mo1791a(str2, c1521ca);
                }
            }
        } : m1834c;
    }

    /* renamed from: c */
    protected C1522cb m1834c(String str) {
        C1523cc c1523cc;
        C1522cb m1800a;
        synchronized (this.f1169a) {
            m1829a();
            c1523cc = this.f1169a.get(str);
        }
        if (c1523cc == null || (m1800a = c1523cc.m1800a()) == null) {
            return null;
        }
        return m1800a;
    }

    /* renamed from: d */
    public C1522cb m1837d(String str) {
        C1522cb c1522cb;
        Map<String, C1522cb> map = f1162b;
        synchronized (map) {
            c1522cb = map.get(str);
        }
        return c1522cb;
    }

    /* renamed from: e */
    protected C1522cb m1840e(String str) {
        if (System.currentTimeMillis() - this.f1172c <= this.f1165a * 60 * 1000) {
            return null;
        }
        this.f1172c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        C1522cb c1522cb = m1815a(arrayList).get(0);
        if (c1522cb != null) {
            this.f1165a = 0L;
            return c1522cb;
        }
        long j = this.f1165a;
        if (j >= 15) {
            return null;
        }
        this.f1165a = j + 1;
        return null;
    }

    /* renamed from: a */
    private ArrayList<C1522cb> m1815a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m1842e();
        synchronized (this.f1169a) {
            m1829a();
            for (String str : this.f1169a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, C1522cb> map = f1162b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                C1522cb c1522cb = (C1522cb) obj;
                if (!c1522cb.mo1798b()) {
                    f1162b.remove(c1522cb.f1145b);
                }
            }
        }
        if (!arrayList.contains(m1831b())) {
            arrayList.add(m1831b());
        }
        ArrayList<C1522cb> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = C1486at.m1549d(f1158a) ? "wifi" : "wap";
            String mo1824a = mo1824a(arrayList, str2, this.f1168a, true);
            if (!TextUtils.isEmpty(mo1824a)) {
                JSONObject jSONObject3 = new JSONObject(mo1824a);
                AbstractC1417b.m1098b(mo1824a);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    AbstractC1417b.m1101c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            AbstractC1417b.m1089a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            C1522cb c1522cb2 = new C1522cb(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    c1522cb2.m1786a(new C1529ci(string6, optJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, c1522cb2);
                            c1522cb2.f1150g = string5;
                            c1522cb2.f1146c = string;
                            c1522cb2.f1148e = string3;
                            c1522cb2.f1149f = string4;
                            c1522cb2.f1147d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                c1522cb2.m1784a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                c1522cb2.m1795b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                c1522cb2.m1785a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m1827a(c1522cb2.m1779a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                AbstractC1417b.m1089a("no bucket found for " + next);
                            } else {
                                C1522cb c1522cb3 = new C1522cb(next);
                                c1522cb3.m1785a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        c1522cb3.m1786a(new C1529ci(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, C1522cb> map2 = f1162b;
                                synchronized (map2) {
                                    if (this.f1166a.mo1811a(next)) {
                                        map2.put(next, c1522cb3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            AbstractC1417b.m1089a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            C1522cb c1522cb4 = arrayList2.get(i5);
            if (c1522cb4 != null) {
                m1828a(arrayList.get(i5), c1522cb4);
            }
        }
        m1836c();
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1824a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<InterfaceC1485as> arrayList3 = new ArrayList();
        arrayList3.add(new C1483aq(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str));
        if (str.equals("wap")) {
            arrayList3.add(new C1483aq("conpt", m1814a(C1486at.m1535a(f1158a))));
        }
        if (z) {
            arrayList3.add(new C1483aq("reserved", PushClient.DEFAULT_REQUEST_ID));
        }
        arrayList3.add(new C1483aq("uuid", str2));
        arrayList3.add(new C1483aq(PropsConstants.LIST, C1494ba.m1627a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new C1483aq("countrycode", C1769b.m3796a(f1158a).m3801b()));
        arrayList3.add(new C1483aq("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String m1831b = m1831b();
        C1522cb m1834c = m1834c(m1831b);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", m1831b);
        if (m1834c == null) {
            arrayList2.add(format);
            Map<String, C1522cb> map = f1162b;
            synchronized (map) {
                C1522cb c1522cb = map.get(m1831b);
                if (c1522cb != null) {
                    Iterator<String> it = c1522cb.mo1782a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = m1834c.m1781a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (InterfaceC1485as interfaceC1485as : arrayList3) {
                buildUpon.appendQueryParameter(interfaceC1485as.mo1523a(), interfaceC1485as.mo1524b());
            }
            try {
                b bVar = this.f1167a;
                if (bVar == null) {
                    return C1486at.m1536a(f1158a, new URL(buildUpon.toString()));
                }
                return bVar.mo1844a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        AbstractC1417b.m1089a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a */
    public void m1826a() {
        synchronized (this.f1169a) {
            this.f1169a.clear();
        }
    }

    /* renamed from: c */
    public String m1835c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f1169a) {
            for (Map.Entry<String, C1523cc> entry : this.f1169a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append(UpdateDialogNewBase.TYPE);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m1828a(String str, C1522cb c1522cb) {
        if (TextUtils.isEmpty(str) || c1522cb == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + c1522cb);
        }
        if (this.f1166a.mo1811a(str)) {
            synchronized (this.f1169a) {
                m1829a();
                if (this.f1169a.containsKey(str)) {
                    this.f1169a.get(str).m1805a(c1522cb);
                } else {
                    C1523cc c1523cc = new C1523cc(str);
                    c1523cc.m1805a(c1522cb);
                    this.f1169a.put(str, c1523cc);
                }
            }
        }
    }

    /* renamed from: b */
    public void m1832b() {
        ArrayList<String> arrayList;
        synchronized (this.f1169a) {
            m1829a();
            arrayList = new ArrayList<>(this.f1169a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C1523cc c1523cc = this.f1169a.get(arrayList.get(size));
                if (c1523cc != null && c1523cc.m1800a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<C1522cb> m1815a = m1815a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (m1815a.get(i) != null) {
                m1828a(arrayList.get(i), m1815a.get(i));
            }
        }
    }

    /* renamed from: d */
    protected String m1838d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(f1158a.getFilesDir(), m1820f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (!file.isFile()) {
            C1801v.m4105a((Closeable) null);
            C1801v.m4105a((Closeable) null);
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                String str = new String(C1655h.m3006a(m1819a(), C1801v.m4110a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                AbstractC1417b.m1098b("load host fallbacks = ".concat(str));
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    AbstractC1417b.m1089a("load host exception " + th.getMessage());
                    return null;
                } finally {
                    C1801v.m4105a((Closeable) bufferedInputStream);
                    C1801v.m4105a((Closeable) fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    /* renamed from: a */
    protected boolean m1829a() {
        synchronized (this.f1169a) {
            if (f1161a) {
                return true;
            }
            f1161a = true;
            this.f1169a.clear();
            try {
                String m1838d = m1838d();
                if (!TextUtils.isEmpty(m1838d)) {
                    m1833b(m1838d);
                    AbstractC1417b.m1098b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                AbstractC1417b.m1089a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    /* renamed from: a */
    public static void m1818a(String str, String str2) {
        Map<String, C1522cb> map = f1162b;
        C1522cb c1522cb = map.get(str);
        synchronized (map) {
            if (c1522cb == null) {
                C1522cb c1522cb2 = new C1522cb(str);
                c1522cb2.m1785a(604800000L);
                c1522cb2.m1787a(str2);
                map.put(str, c1522cb2);
            } else {
                c1522cb.m1787a(str2);
            }
        }
    }

    /* renamed from: c */
    public void m1836c() {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        synchronized (this.f1169a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                String jSONObject = m1825a().toString();
                AbstractC1417b.m1098b("persist host fallbacks = " + jSONObject);
                if (TextUtils.isEmpty(jSONObject)) {
                    fileOutputStream = null;
                } else {
                    fileOutputStream = f1158a.openFileOutput(m1820f(), 0);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            try {
                                bufferedOutputStream.write(C1655h.m3007b(m1819a(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                                bufferedOutputStream.flush();
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (Exception e2) {
                                e = e2;
                                AbstractC1417b.m1089a("persist bucket failure: " + e.getMessage());
                                C1801v.m4105a(bufferedOutputStream);
                                C1801v.m4105a(fileOutputStream);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C1801v.m4105a(bufferedOutputStream2);
                            C1801v.m4105a(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        bufferedOutputStream = null;
                        e = e3;
                    } catch (Throwable th2) {
                        th = th2;
                        C1801v.m4105a(bufferedOutputStream2);
                        C1801v.m4105a(fileOutputStream);
                        throw th;
                    }
                }
                C1801v.m4105a(bufferedOutputStream2);
            } catch (Exception e4) {
                bufferedOutputStream = null;
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            C1801v.m4105a(fileOutputStream);
        }
    }

    /* renamed from: d */
    public void m1839d() {
        String m1841e = m1841e();
        try {
            File file = new File(f1158a.getFilesDir(), m1841e);
            if (file.exists()) {
                AbstractC1417b.m1089a("Delete old host fallbacks file " + m1841e + (file.delete() ? " successful." : " failed."));
            } else {
                AbstractC1417b.m1098b("Old host fallbacks file " + m1841e + " does not exist.");
            }
        } catch (Exception e) {
            AbstractC1417b.m1089a("Delete old host fallbacks file " + m1841e + " error: " + e.getMessage());
        }
    }

    /* renamed from: e */
    protected String m1841e() {
        if ("com.xiaomi.xmsf".equals(f1163c)) {
            return f1163c;
        }
        return f1163c + TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX;
    }

    /* renamed from: a */
    private byte[] m1819a() {
        return C1492az.m1596a(f1158a.getPackageName() + "_key_salt");
    }

    /* renamed from: g */
    private String m1821g() {
        try {
            PackageInfo packageInfo = f1158a.getPackageManager().getPackageInfo(f1158a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: e */
    public void m1842e() {
        String next;
        synchronized (this.f1169a) {
            Iterator<C1523cc> it = this.f1169a.values().iterator();
            while (it.hasNext()) {
                it.next().m1806a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f1169a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f1169a.get(next).m1803a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f1169a.remove(next);
            }
        }
    }

    /* renamed from: a */
    static String m1814a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public void m1827a(String str) {
        this.f1171b = str;
    }

    /* renamed from: a */
    protected JSONObject m1825a() {
        JSONObject jSONObject;
        synchronized (this.f1169a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<C1523cc> it = this.f1169a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m1804a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<C1522cb> it2 = f1162b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m1783a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: b */
    protected void m1833b(String str) {
        synchronized (this.f1169a) {
            this.f1169a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C1523cc m1801a = new C1523cc().m1801a(optJSONArray.getJSONObject(i));
                    this.f1169a.put(m1801a.m1802a(), m1801a);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString = jSONObject2.optString("host");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            C1522cb m1778a = new C1522cb(optString).m1778a(jSONObject2);
                            f1162b.put(m1778a.f1145b, m1778a);
                            AbstractC1417b.m1089a("load local reserved host for " + m1778a.f1145b);
                        } catch (JSONException unused) {
                            AbstractC1417b.m1089a("parse reserved host fail.");
                        }
                    }
                }
            }
        }
    }
}
