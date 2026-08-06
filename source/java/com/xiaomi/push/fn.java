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

/* loaded from: classes7.dex */
public abstract class fn {

    /* renamed from: a, reason: collision with other field name */
    public static final DateFormat f516a;
    private static long b;
    private static String c;

    /* renamed from: a, reason: collision with other field name */
    public long f518a;

    /* renamed from: a, reason: collision with other field name */
    private fr f519a;

    /* renamed from: a, reason: collision with other field name */
    private List<fk> f520a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f521a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b, reason: collision with other field name */
    private static String f517b = null;

    /* renamed from: a */
    public abstract String mo9909a();

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f516a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = fw.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        b = 0L;
    }

    public static synchronized String i() {
        String sb;
        synchronized (fn.class) {
            StringBuilder append = new StringBuilder().append(c);
            long j = b;
            b = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public fn() {
        this.d = f517b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f520a = new CopyOnWriteArrayList();
        this.f521a = new HashMap();
        this.f519a = null;
    }

    public fn(Bundle bundle) {
        this.d = f517b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f520a = new CopyOnWriteArrayList();
        this.f521a = new HashMap();
        this.f519a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f520a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fk a2 = fk.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f520a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f519a = new fr(bundle2);
        }
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public void k(String str) {
        this.e = str;
    }

    public String k() {
        return this.h;
    }

    public void l(String str) {
        this.h = str;
    }

    public String l() {
        return this.f;
    }

    public void m(String str) {
        this.f = str;
    }

    public String m() {
        return this.g;
    }

    public void n(String str) {
        this.g = str;
    }

    public String n() {
        return this.i;
    }

    public void o(String str) {
        this.i = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public fr m9910a() {
        return this.f519a;
    }

    public void a(fr frVar) {
        this.f519a = frVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fk> m9912a() {
        if (this.f520a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f520a));
    }

    public fk a(String str) {
        return a(str, null);
    }

    public fk a(String str, String str2) {
        for (fk fkVar : this.f520a) {
            if (str2 == null || str2.equals(fkVar.b())) {
                if (str.equals(fkVar.m9906a())) {
                    return fkVar;
                }
            }
        }
        return null;
    }

    public void a(fk fkVar) {
        this.f520a.add(fkVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Object m9911a(String str) {
        Map<String, Object> map = this.f521a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<String> b() {
        if (this.f521a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f521a.keySet()));
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        fr frVar = this.f519a;
        if (frVar != null) {
            bundle.putBundle("ext_ERROR", frVar.a());
        }
        List<fk> list = this.f520a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<fk> it = this.f520a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle a2 = it.next().a();
                if (a2 != null) {
                    bundleArr[i] = a2;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e;
        sb = new StringBuilder();
        Iterator<fk> it = m9912a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        Map<String, Object> map = this.f521a;
        if (map != null && !map.isEmpty()) {
            sb.append(ax.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str : b()) {
                Object m9911a = m9911a(str);
                sb.append("<property>");
                sb.append("<name>").append(fw.a(str)).append("</name>");
                sb.append("<value type=\"");
                if (m9911a instanceof Integer) {
                    sb.append("integer\">").append(m9911a).append("</value>");
                } else if (m9911a instanceof Long) {
                    sb.append("long\">").append(m9911a).append("</value>");
                } else if (m9911a instanceof Float) {
                    sb.append("float\">").append(m9911a).append("</value>");
                } else if (m9911a instanceof Double) {
                    sb.append("double\">").append(m9911a).append("</value>");
                } else if (m9911a instanceof Boolean) {
                    sb.append("boolean\">").append(m9911a).append("</value>");
                } else if (m9911a instanceof String) {
                    sb.append("string\">");
                    sb.append(fw.a((String) m9911a));
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
                                    objectOutputStream.writeObject(m9911a);
                                    sb.append("java-object\">");
                                    sb.append(fw.a(byteArrayOutputStream.toByteArray())).append("</value>");
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

    public String p() {
        return this.d;
    }

    public static String q() {
        return a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fn fnVar = (fn) obj;
        fr frVar = this.f519a;
        if (frVar == null ? fnVar.f519a != null : !frVar.equals(fnVar.f519a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? fnVar.g != null : !str.equals(fnVar.g)) {
            return false;
        }
        if (!this.f520a.equals(fnVar.f520a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? fnVar.e != null : !str2.equals(fnVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? fnVar.h != null : !str3.equals(fnVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f521a;
        if (map == null ? fnVar.f521a != null : !map.equals(fnVar.f521a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? fnVar.f != null : !str4.equals(fnVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = fnVar.d;
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
        String str = this.d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f520a.hashCode()) * 31) + this.f521a.hashCode()) * 31;
        fr frVar = this.f519a;
        return hashCode5 + (frVar != null ? frVar.hashCode() : 0);
    }
}
