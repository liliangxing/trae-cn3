package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.push.fk */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1612fk implements InterfaceC1616fo {

    /* renamed from: a */
    private String f1756a;

    /* renamed from: a */
    private List<C1612fk> f1757a;

    /* renamed from: a */
    private String[] f1758a;

    /* renamed from: b */
    private String f1759b;

    /* renamed from: b */
    private String[] f1760b;

    /* renamed from: c */
    private String f1761c;

    public C1612fk(String str, String str2, String[] strArr, String[] strArr2) {
        this.f1757a = null;
        this.f1756a = str;
        this.f1759b = str2;
        this.f1758a = strArr;
        this.f1760b = strArr2;
    }

    public C1612fk(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C1612fk> list) {
        this.f1756a = str;
        this.f1759b = str2;
        this.f1758a = strArr;
        this.f1760b = strArr2;
        this.f1761c = str3;
        this.f1757a = list;
    }

    /* renamed from: a */
    public String m2566a() {
        return this.f1756a;
    }

    /* renamed from: b */
    public String m2570b() {
        return this.f1759b;
    }

    /* renamed from: c */
    public String m2571c() {
        if (!TextUtils.isEmpty(this.f1761c)) {
            return C1624fw.m2650b(this.f1761c);
        }
        return this.f1761c;
    }

    public String toString() {
        return mo2572d();
    }

    @Override // com.xiaomi.push.InterfaceC1616fo
    /* renamed from: d */
    public String mo2572d() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f1756a);
        if (!TextUtils.isEmpty(this.f1759b)) {
            sb.append(" xmlns=\"").append(this.f1759b).append("\"");
        }
        String[] strArr = this.f1758a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f1758a.length; i++) {
                if (!TextUtils.isEmpty(this.f1760b[i])) {
                    sb.append(" ").append(this.f1758a[i]).append("=\"").append(C1624fw.m2647a(this.f1760b[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f1761c)) {
            sb.append(">").append(this.f1761c).append("</").append(this.f1756a).append(">");
        } else {
            List<C1612fk> list = this.f1757a;
            if (list != null && list.size() > 0) {
                sb.append(">");
                Iterator<C1612fk> it = this.f1757a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().mo2572d());
                }
                sb.append("</").append(this.f1756a).append(">");
            } else {
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public Bundle m2564a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f1756a);
        bundle.putString("ext_ns", this.f1759b);
        bundle.putString("ext_text", this.f1761c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f1758a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f1758a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f1760b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<C1612fk> list = this.f1757a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", m2562a(this.f1757a));
        }
        return bundle;
    }

    /* renamed from: a */
    public Parcelable m2565a() {
        return m2564a();
    }

    /* renamed from: a */
    public static Parcelable[] m2563a(C1612fk[] c1612fkArr) {
        if (c1612fkArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[c1612fkArr.length];
        for (int i = 0; i < c1612fkArr.length; i++) {
            parcelableArr[i] = c1612fkArr[i].m2565a();
        }
        return parcelableArr;
    }

    /* renamed from: a */
    public static Parcelable[] m2562a(List<C1612fk> list) {
        return m2563a((C1612fk[]) list.toArray(new C1612fk[list.size()]));
    }

    /* renamed from: a */
    public static C1612fk m2561a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(m2561a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new C1612fk(string, string2, strArr, strArr2, string3, arrayList);
    }

    /* renamed from: a */
    public String m2567a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f1758a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f1758a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f1760b[i];
            }
            i++;
        }
    }

    /* renamed from: a */
    public void m2568a(C1612fk c1612fk) {
        if (this.f1757a == null) {
            this.f1757a = new ArrayList();
        }
        if (this.f1757a.contains(c1612fk)) {
            return;
        }
        this.f1757a.add(c1612fk);
    }

    /* renamed from: a */
    public void m2569a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1761c = C1624fw.m2647a(str);
        } else {
            this.f1761c = str;
        }
    }
}
