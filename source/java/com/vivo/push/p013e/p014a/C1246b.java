package com.vivo.push.p013e.p014a;

import android.text.TextUtils;
import com.vivo.push.p013e.C1248b;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: SyncProfileInfoInputDS.java */
/* renamed from: com.vivo.push.e.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1246b implements InterfaceC1342b {

    /* renamed from: a */
    public static final InterfaceC1342b.a<C1246b> f419a = new C1247c();

    /* renamed from: b */
    private String f420b;

    /* renamed from: c */
    private List<C1248b> f421c;

    /* renamed from: d */
    private int f422d;

    public C1246b(String str, List<C1248b> list, int i) {
        new ArrayList();
        this.f420b = str;
        this.f422d = i;
        this.f421c = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1246b(C1341a c1341a) throws JSONException {
        this.f421c = new ArrayList();
        this.f420b = c1341a.m894c();
        this.f422d = c1341a.m886a();
        c1341a.m889a(C1248b.f423a, this.f421c);
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b
    /* renamed from: a */
    public final void mo673a(C1341a c1341a) {
        c1341a.m890a(this.f420b);
        c1341a.m887a(this.f422d);
        c1341a.m891a(this.f421c);
    }

    /* renamed from: a */
    public final List<String> m678a() {
        ArrayList arrayList = new ArrayList();
        Iterator<C1248b> it = this.f421c.iterator();
        while (it.hasNext()) {
            String m680b = it.next().m680b();
            if (!TextUtils.isEmpty(m680b)) {
                arrayList.add(m680b);
            }
        }
        return arrayList;
    }
}
