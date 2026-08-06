package com.xiaomi.push;

import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1522cb {

    /* renamed from: a */
    private long f1141a;

    /* renamed from: a */
    public String f1142a;

    /* renamed from: b */
    public String f1145b;

    /* renamed from: c */
    public String f1146c;

    /* renamed from: d */
    public String f1147d;

    /* renamed from: e */
    public String f1148e;

    /* renamed from: f */
    public String f1149f;

    /* renamed from: g */
    public String f1150g;

    /* renamed from: h */
    protected String f1151h;

    /* renamed from: i */
    private String f1152i;

    /* renamed from: a */
    private ArrayList<C1529ci> f1143a = new ArrayList<>();

    /* renamed from: a */
    private double f1140a = 0.1d;

    /* renamed from: j */
    private String f1153j = "s.mi1.cc";

    /* renamed from: b */
    private long f1144b = DownloadConstants.DAY;

    public C1522cb(String str) {
        this.f1142a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f1141a = System.currentTimeMillis();
        this.f1143a.add(new C1529ci(str, -1));
        this.f1142a = C1526cf.m1813a();
        this.f1145b = str;
    }

    /* renamed from: a */
    public boolean m1793a() {
        return TextUtils.equals(this.f1142a, C1526cf.m1813a());
    }

    /* renamed from: a */
    public boolean m1794a(C1522cb c1522cb) {
        return TextUtils.equals(this.f1142a, c1522cb.f1142a);
    }

    /* renamed from: b */
    public boolean mo1798b() {
        return System.currentTimeMillis() - this.f1141a < this.f1144b;
    }

    /* renamed from: a */
    public void m1785a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.f1144b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m1799c() {
        long j = this.f1144b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f1141a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.f1144b && this.f1142a.startsWith("WIFI-"));
    }

    /* renamed from: a */
    public ArrayList<String> m1781a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f1145b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = mo1782a(true).iterator();
            while (it.hasNext()) {
                C1524cd m1807a = C1524cd.m1807a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), m1807a.m1810a(), m1807a.m1809a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    /* renamed from: a */
    public void m1789a(String str, long j, long j2) {
        try {
            m1796b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: b */
    public void m1796b(String str, long j, long j2) {
        m1788a(str, 0, j, j2, null);
    }

    /* renamed from: a */
    public void m1790a(String str, long j, long j2, Exception exc) {
        try {
            m1797b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: b */
    public void m1797b(String str, long j, long j2, Exception exc) {
        m1788a(str, -1, j, j2, exc);
    }

    /* renamed from: a */
    public void m1788a(String str, int i, long j, long j2, Exception exc) {
        mo1791a(str, new C1521ca(i, j, j2, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.m1858a(r5);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void mo1791a(String str, C1521ca c1521ca) {
        Iterator<C1529ci> it = this.f1143a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1529ci next = it.next();
            if (TextUtils.equals(str, next.f1180a)) {
                break;
            }
        }
    }

    /* renamed from: a */
    public synchronized ArrayList<String> m1780a() {
        return mo1782a(false);
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo1782a(boolean z) {
        ArrayList<String> arrayList;
        int size = this.f1143a.size();
        C1529ci[] c1529ciArr = new C1529ci[size];
        this.f1143a.toArray(c1529ciArr);
        Arrays.sort(c1529ciArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            C1529ci c1529ci = c1529ciArr[i];
            if (z) {
                arrayList.add(c1529ci.f1180a);
            } else {
                int indexOf = c1529ci.f1180a.indexOf(Constants.COLON_SEPARATOR);
                if (indexOf != -1) {
                    arrayList.add(c1529ci.f1180a.substring(0, indexOf));
                } else {
                    arrayList.add(c1529ci.f1180a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m1787a(String str) {
        m1786a(new C1529ci(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m1786a(C1529ci c1529ci) {
        m1777c(c1529ci.f1180a);
        this.f1143a.add(c1529ci);
    }

    /* renamed from: a */
    public synchronized void m1792a(String[] strArr) {
        int i;
        int size = this.f1143a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f1143a.get(size).f1180a, strArr[i])) {
                        this.f1143a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<C1529ci> it = this.f1143a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C1529ci next = it.next();
            if (next.f1178a > i2) {
                i2 = next.f1178a;
            }
        }
        while (i < strArr.length) {
            m1786a(new C1529ci(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1142a);
        sb.append(UpdateDialogNewBase.TYPE);
        sb.append(m1779a());
        Iterator<C1529ci> it = this.f1143a.iterator();
        while (it.hasNext()) {
            C1529ci next = it.next();
            sb.append(UpdateDialogNewBase.TYPE);
            sb.append(next.toString());
        }
        sb.append(UpdateDialogNewBase.TYPE);
        return sb.toString();
    }

    /* renamed from: a */
    public synchronized String m1779a() {
        if (!TextUtils.isEmpty(this.f1152i)) {
            return this.f1152i;
        }
        if (TextUtils.isEmpty(this.f1148e)) {
            return "hardcode_isp";
        }
        String m1630a = C1494ba.m1630a(new String[]{this.f1148e, this.f1146c, this.f1147d, this.f1150g, this.f1149f}, RomUtils.SEPARATOR);
        this.f1152i = m1630a;
        return m1630a;
    }

    /* renamed from: b */
    public void m1795b(String str) {
        this.f1153j = str;
    }

    /* renamed from: a */
    public void m1784a(double d) {
        this.f1140a = d;
    }

    /* renamed from: a */
    public synchronized JSONObject m1783a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f1142a);
        jSONObject.put("ttl", this.f1144b);
        jSONObject.put("pct", this.f1140a);
        jSONObject.put("ts", this.f1141a);
        jSONObject.put("city", this.f1147d);
        jSONObject.put("prv", this.f1146c);
        jSONObject.put("cty", this.f1150g);
        jSONObject.put("isp", this.f1148e);
        jSONObject.put("ip", this.f1149f);
        jSONObject.put("host", this.f1145b);
        jSONObject.put("xf", this.f1151h);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1529ci> it = this.f1143a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m1857a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C1522cb m1778a(JSONObject jSONObject) {
        this.f1142a = jSONObject.optString("net");
        this.f1144b = jSONObject.getLong("ttl");
        this.f1140a = jSONObject.getDouble("pct");
        this.f1141a = jSONObject.getLong("ts");
        this.f1147d = jSONObject.optString("city");
        this.f1146c = jSONObject.optString("prv");
        this.f1150g = jSONObject.optString("cty");
        this.f1148e = jSONObject.optString("isp");
        this.f1149f = jSONObject.optString("ip");
        this.f1145b = jSONObject.optString("host");
        this.f1151h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            m1786a(new C1529ci().m1856a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: c */
    private synchronized void m1777c(String str) {
        Iterator<C1529ci> it = this.f1143a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f1180a, str)) {
                it.remove();
            }
        }
    }
}
