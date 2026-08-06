package com.huawei.hms.hatool;

import com.facebook.common.util.ByteConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.d1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1135d1 implements InterfaceRunnableC1142g {

    /* renamed from: a */
    private String f1429a;

    /* renamed from: b */
    private String f1430b;

    /* renamed from: c */
    private String f1431c;

    /* renamed from: d */
    private List<C1129b1> f1432d;

    public C1135d1(List<C1129b1> list, String str, String str2, String str3) {
        this.f1429a = str;
        this.f1430b = str2;
        this.f1431c = str3;
        this.f1432d = list;
    }

    /* renamed from: a */
    private void m1471a() {
        C1133d.m1466a(AbstractC1173q0.m1707i(), "backup_event", AbstractC1165n1.m1649a(this.f1429a, this.f1431c, this.f1430b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<C1129b1> list = this.f1432d;
        if (list == null || list.size() == 0) {
            C1182v.m1783d("hmsSdk", "failed events is empty");
            return;
        }
        if (C1131c0.m1454a(AbstractC1173q0.m1707i(), "cached_v2_1", AbstractC1173q0.m1709k() * ByteConstants.f354MB)) {
            C1182v.m1785e("hmsSdk", "The cacheFile is full,Can not writing data, delete it! reqID:" + this.f1430b);
            C1133d.m1466a(AbstractC1173q0.m1707i(), "cached_v2_1", new String[0]);
            return;
        }
        String m1648a = AbstractC1165n1.m1648a(this.f1429a, this.f1431c);
        List<C1129b1> list2 = C1132c1.m1461b(AbstractC1173q0.m1707i(), "cached_v2_1", m1648a).get(m1648a);
        if (list2 != null && list2.size() != 0) {
            this.f1432d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<C1129b1> it = this.f1432d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m1446d());
            } catch (JSONException unused) {
                C1182v.m1785e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > AbstractC1173q0.m1705h() * ByteConstants.f354MB) {
            C1182v.m1785e("hmsSdk", "this failed data is too long,can not writing it");
            this.f1432d = null;
        } else {
            C1182v.m1783d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f1430b);
            C1133d.m1469b(AbstractC1173q0.m1707i(), "cached_v2_1", m1648a, jSONArray2);
            m1471a();
        }
    }
}
