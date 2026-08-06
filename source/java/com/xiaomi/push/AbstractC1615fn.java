package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.fn */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1615fn {

    /* renamed from: a */
    public static final DateFormat f1784a;

    /* renamed from: b */
    private static long f1785b;

    /* renamed from: c */
    private static String f1787c;

    /* renamed from: a */
    public long f1788a;

    /* renamed from: a */
    private C1619fr f1789a;

    /* renamed from: a */
    private List<C1612fk> f1790a;

    /* renamed from: a */
    private final Map<String, Object> f1791a;

    /* renamed from: d */
    private String f1792d;

    /* renamed from: e */
    private String f1793e;

    /* renamed from: f */
    private String f1794f;

    /* renamed from: g */
    private String f1795g;

    /* renamed from: h */
    private String f1796h;

    /* renamed from: i */
    private String f1797i;

    /* renamed from: a */
    protected static final String f1783a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b */
    private static String f1786b = null;

    /* renamed from: a */
    public abstract String mo2575a();

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f1784a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f1787c = C1624fw.m2646a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f1785b = 0L;
    }

    /* renamed from: i */
    public static synchronized String m2600i() {
        String sb;
        synchronized (AbstractC1615fn.class) {
            StringBuilder append = new StringBuilder().append(f1787c);
            long j = f1785b;
            f1785b = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public AbstractC1615fn() {
        this.f1792d = f1786b;
        this.f1793e = null;
        this.f1794f = null;
        this.f1795g = null;
        this.f1796h = null;
        this.f1797i = null;
        this.f1790a = new CopyOnWriteArrayList();
        this.f1791a = new HashMap();
        this.f1789a = null;
    }

    public AbstractC1615fn(Bundle bundle) {
        this.f1792d = f1786b;
        this.f1793e = null;
        this.f1794f = null;
        this.f1795g = null;
        this.f1796h = null;
        this.f1797i = null;
        this.f1790a = new CopyOnWriteArrayList();
        this.f1791a = new HashMap();
        this.f1789a = null;
        this.f1794f = bundle.getString("ext_to");
        this.f1795g = bundle.getString("ext_from");
        this.f1796h = bundle.getString("ext_chid");
        this.f1793e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f1790a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C1612fk m2561a = C1612fk.m2561a((Bundle) parcelable);
                if (m2561a != null) {
                    this.f1790a.add(m2561a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f1789a = new C1619fr(bundle2);
        }
    }

    /* renamed from: j */
    public String m2610j() {
        if ("ID_NOT_AVAILABLE".equals(this.f1793e)) {
            return null;
        }
        if (this.f1793e == null) {
            this.f1793e = m2600i();
        }
        return this.f1793e;
    }

    /* renamed from: k */
    public void m2612k(String str) {
        this.f1793e = str;
    }

    /* renamed from: k */
    public String m2611k() {
        return this.f1796h;
    }

    /* renamed from: l */
    public void m2614l(String str) {
        this.f1796h = str;
    }

    /* renamed from: l */
    public String m2613l() {
        return this.f1794f;
    }

    /* renamed from: m */
    public void m2616m(String str) {
        this.f1794f = str;
    }

    /* renamed from: m */
    public String m2615m() {
        return this.f1795g;
    }

    /* renamed from: n */
    public void m2618n(String str) {
        this.f1795g = str;
    }

    /* renamed from: n */
    public String m2617n() {
        return this.f1797i;
    }

    /* renamed from: o */
    public void m2620o(String str) {
        this.f1797i = str;
    }

    /* renamed from: a */
    public C1619fr m2604a() {
        return this.f1789a;
    }

    /* renamed from: a */
    public void m2608a(C1619fr c1619fr) {
        this.f1789a = c1619fr;
    }

    /* renamed from: a */
    public synchronized Collection<C1612fk> m2606a() {
        if (this.f1790a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f1790a));
    }

    /* renamed from: a */
    public C1612fk m2602a(String str) {
        return m2603a(str, null);
    }

    /* renamed from: a */
    public C1612fk m2603a(String str, String str2) {
        for (C1612fk c1612fk : this.f1790a) {
            if (str2 == null || str2.equals(c1612fk.m2570b())) {
                if (str.equals(c1612fk.m2566a())) {
                    return c1612fk;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m2607a(C1612fk c1612fk) {
        this.f1790a.add(c1612fk);
    }

    /* renamed from: a */
    public synchronized Object m2605a(String str) {
        Map<String, Object> map = this.f1791a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: b */
    public synchronized Collection<String> m2609b() {
        if (this.f1791a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f1791a.keySet()));
    }

    /* renamed from: a */
    public Bundle mo2573a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f1792d)) {
            bundle.putString("ext_ns", this.f1792d);
        }
        if (!TextUtils.isEmpty(this.f1795g)) {
            bundle.putString("ext_from", this.f1795g);
        }
        if (!TextUtils.isEmpty(this.f1794f)) {
            bundle.putString("ext_to", this.f1794f);
        }
        if (!TextUtils.isEmpty(this.f1793e)) {
            bundle.putString("ext_pkt_id", this.f1793e);
        }
        if (!TextUtils.isEmpty(this.f1796h)) {
            bundle.putString("ext_chid", this.f1796h);
        }
        C1619fr c1619fr = this.f1789a;
        if (c1619fr != null) {
            bundle.putBundle("ext_ERROR", c1619fr.m2627a());
        }
        List<C1612fk> list = this.f1790a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<C1612fk> it = this.f1790a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle m2564a = it.next().m2564a();
                if (m2564a != null) {
                    bundleArr[i] = m2564a;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String m2619o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e;
        sb = new StringBuilder();
        Iterator<C1612fk> it = m2606a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo2572d());
        }
        Map<String, Object> map = this.f1791a;
        if (map != null && !map.isEmpty()) {
            sb.append(C1490ax.m1591b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str : m2609b()) {
                Object m2605a = m2605a(str);
                sb.append("<property>");
                sb.append("<name>").append(C1624fw.m2647a(str)).append("</name>");
                sb.append("<value type=\"");
                if (m2605a instanceof Integer) {
                    sb.append("integer\">").append(m2605a).append("</value>");
                } else if (m2605a instanceof Long) {
                    sb.append("long\">").append(m2605a).append("</value>");
                } else if (m2605a instanceof Float) {
                    sb.append("float\">").append(m2605a).append("</value>");
                } else if (m2605a instanceof Double) {
                    sb.append("double\">").append(m2605a).append("</value>");
                } else if (m2605a instanceof Boolean) {
                    sb.append("boolean\">").append(m2605a).append("</value>");
                } else if (m2605a instanceof String) {
                    sb.append("string\">");
                    sb.append(C1624fw.m2647a((String) m2605a));
                    sb.append("</value>");
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = null;
                    }
                    try {
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                try {
                                    objectOutputStream.writeObject(m2605a);
                                    sb.append("java-object\">");
                                    sb.append(C1624fw.m2649a(byteArrayOutputStream.toByteArray())).append("</value>");
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    objectOutputStream2 = objectOutputStream;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                            throw th;
                                        } catch (Exception unused3) {
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    sb.append("</property>");
                                }
                                byteArrayOutputStream.close();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            objectOutputStream = null;
                            e = e;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        byteArrayOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    /* renamed from: p */
    public String m2621p() {
        return this.f1792d;
    }

    /* renamed from: q */
    public static String m2601q() {
        return f1783a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC1615fn abstractC1615fn = (AbstractC1615fn) obj;
        C1619fr c1619fr = this.f1789a;
        if (c1619fr == null ? abstractC1615fn.f1789a != null : !c1619fr.equals(abstractC1615fn.f1789a)) {
            return false;
        }
        String str = this.f1795g;
        if (str == null ? abstractC1615fn.f1795g != null : !str.equals(abstractC1615fn.f1795g)) {
            return false;
        }
        if (!this.f1790a.equals(abstractC1615fn.f1790a)) {
            return false;
        }
        String str2 = this.f1793e;
        if (str2 == null ? abstractC1615fn.f1793e != null : !str2.equals(abstractC1615fn.f1793e)) {
            return false;
        }
        String str3 = this.f1796h;
        if (str3 == null ? abstractC1615fn.f1796h != null : !str3.equals(abstractC1615fn.f1796h)) {
            return false;
        }
        Map<String, Object> map = this.f1791a;
        if (map == null ? abstractC1615fn.f1791a != null : !map.equals(abstractC1615fn.f1791a)) {
            return false;
        }
        String str4 = this.f1794f;
        if (str4 == null ? abstractC1615fn.f1794f != null : !str4.equals(abstractC1615fn.f1794f)) {
            return false;
        }
        String str5 = this.f1792d;
        String str6 = abstractC1615fn.f1792d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f1792d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1793e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f1794f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1795g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f1796h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f1790a.hashCode()) * 31) + this.f1791a.hashCode()) * 31;
        C1619fr c1619fr = this.f1789a;
        return hashCode5 + (c1619fr != null ? c1619fr.hashCode() : 0);
    }
}
