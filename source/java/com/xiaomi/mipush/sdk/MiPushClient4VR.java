package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.service.C1752aj;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        C1659hd c1659hd = new C1659hd();
        c1659hd.m3064c(EnumC1643go.VRUpload.f2208a);
        c1659hd.m3060b(C1443b.m1222a(context).m1226a());
        c1659hd.m3068d(context.getPackageName());
        c1659hd.m3055a("data", str);
        c1659hd.m3047a(C1752aj.m3692a());
        C1462u.m1373a(context).m1405a((C1462u) c1659hd, EnumC1633ge.Notification, (C1646gr) null);
    }
}
