package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.lynx.tasm.utils.LynxConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1651gw;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1639gk;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1751ai;

/* renamed from: com.xiaomi.mipush.sdk.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1456o extends C1470ad.a {

    /* renamed from: a */
    private Context f867a;

    /* renamed from: a */
    private boolean f868a = false;

    @Override // com.xiaomi.push.C1470ad.a
    /* renamed from: a */
    public String mo1133a() {
        return "2";
    }

    public C1456o(Context context) {
        this.f867a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1750ah m3674a = C1750ah.m3674a(this.f867a);
        C1651gw c1651gw = new C1651gw();
        if (this.f868a) {
            c1651gw.m2950a(0);
            c1651gw.m2955b(0);
        } else {
            c1651gw.m2950a(C1751ai.m3688a(m3674a, EnumC1639gk.MISC_CONFIG));
            c1651gw.m2955b(C1751ai.m3688a(m3674a, EnumC1639gk.PLUGIN_CONFIG));
        }
        C1659hd c1659hd = new C1659hd(LynxConstants.LYNX_DEFAULT_COMPONENT_ID, false);
        c1659hd.m3064c(EnumC1643go.DailyCheckClientConfig.f2208a);
        c1659hd.m3051a(C1670ho.m3313a(c1651gw));
        AbstractC1417b.m1100b("OcVersionCheckJob", "-->check version: checkMessage=", c1651gw);
        C1462u.m1373a(this.f867a).m1405a((C1462u) c1659hd, EnumC1633ge.Notification, (C1646gr) null);
    }
}
