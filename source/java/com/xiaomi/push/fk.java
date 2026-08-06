package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public class fk implements fo {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private List<fk> f510a;

    /* renamed from: a, reason: collision with other field name */
    private String[] f511a;
    private String b;

    /* renamed from: b, reason: collision with other field name */
    private String[] f512b;
    private String c;

    public fk(String str, String str2, String[] strArr, String[] strArr2) {
        this.f510a = null;
        this.a = str;
        this.b = str2;
        this.f511a = strArr;
        this.f512b = strArr2;
    }

    public fk(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fk> list) {
        this.a = str;
        this.b = str2;
        this.f511a = strArr;
        this.f512b = strArr2;
        this.c = str3;
        this.f510a = list;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m9906a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        if (!TextUtils.isEmpty(this.c)) {
            return fw.b(this.c);
        }
        return this.c;
    }

    public String toString() {
        return d();
    }

    @Override // com.xiaomi.push.fo
    public String d() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" xmlns=\"").append(this.b).append("\"");
        }
        String[] strArr = this.f511a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f511a.length; i++) {
                if (!TextUtils.isEmpty(this.f512b[i])) {
                    sb.append(" ").append(this.f511a[i]).append("=\"").append(fw.a(this.f512b[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">").append(this.c).append("</").append(this.a).append(">");
        } else {
            List<fk> list = this.f510a;
            if (list != null && list.size() > 0) {
                sb.append(">");
                Iterator<fk> it = this.f510a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</").append(this.a).append(">");
            } else {
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f511a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f511a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f512b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fk> list = this.f510a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f510a));
        }
        return bundle;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Parcelable m9905a() {
        return a();
    }

    public static Parcelable[] a(fk[] fkVarArr) {
        if (fkVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fkVarArr.length];
        for (int i = 0; i < fkVarArr.length; i++) {
            parcelableArr[i] = fkVarArr[i].m9905a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<fk> list) {
        return a((fk[]) list.toArray(new fk[list.size()]));
    }

    public static fk a(Bundle bundle) {
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
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fk(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f511a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f511a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f512b[i];
            }
            i++;
        }
    }

    public void a(fk fkVar) {
        if (this.f510a == null) {
            this.f510a = new ArrayList();
        }
        if (this.f510a.contains(fkVar)) {
            return;
        }
        this.f510a.add(fkVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9907a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = fw.a(str);
        } else {
            this.c = str;
        }
    }
}
