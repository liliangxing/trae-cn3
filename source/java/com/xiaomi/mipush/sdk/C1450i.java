package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.InterfaceC1552de;

/* renamed from: com.xiaomi.mipush.sdk.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1450i implements InterfaceC1552de {

    /* renamed from: a */
    private Context f857a;

    public C1450i(Context context) {
        this.f857a = context;
    }

    @Override // com.xiaomi.push.InterfaceC1552de
    /* renamed from: a */
    public String mo1310a() {
        return C1443b.m1222a(this.f857a).m1243d();
    }

    @Override // com.xiaomi.push.InterfaceC1552de
    /* renamed from: a */
    public void mo1311a(C1659hd c1659hd, EnumC1633ge enumC1633ge, C1646gr c1646gr) {
        C1462u.m1373a(this.f857a).m1405a((C1462u) c1659hd, enumC1633ge, c1646gr);
    }
}
