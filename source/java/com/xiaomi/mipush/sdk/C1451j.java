package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1451j {

    /* renamed from: a */
    private static volatile C1451j f858a;

    /* renamed from: a */
    private final Context f859a;

    /* renamed from: a */
    private static C1451j m1312a(Context context) {
        if (f858a == null) {
            synchronized (C1451j.class) {
                if (f858a == null) {
                    f858a = new C1451j(context);
                }
            }
        }
        return f858a;
    }

    private C1451j(Context context) {
        this.f859a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m1314a(Context context, C1656ha c1656ha, boolean z) {
        m1312a(context).m1315a(c1656ha, 1, z);
    }

    /* renamed from: b */
    public static void m1316b(Context context, C1656ha c1656ha, boolean z) {
        m1312a(context).m1315a(c1656ha, 2, z);
    }

    /* renamed from: c */
    public static void m1317c(Context context, C1656ha c1656ha, boolean z) {
        m1312a(context).m1315a(c1656ha, 3, z);
    }

    /* renamed from: d */
    public static void m1318d(Context context, C1656ha c1656ha, boolean z) {
        m1312a(context).m1315a(c1656ha, 4, z);
    }

    /* renamed from: e */
    public static void m1319e(Context context, C1656ha c1656ha, boolean z) {
        C1443b m1222a = C1443b.m1222a(context);
        if (TextUtils.isEmpty(m1222a.m1241c()) || TextUtils.isEmpty(m1222a.m1243d())) {
            m1312a(context).m1315a(c1656ha, 6, z);
        } else if (m1222a.m1248f()) {
            m1312a(context).m1315a(c1656ha, 7, z);
        } else {
            m1312a(context).m1315a(c1656ha, 5, z);
        }
    }

    /* renamed from: a */
    public static void m1313a(Context context, C1656ha c1656ha) {
        m1312a(context).m1315a(c1656ha, 0, true);
    }

    /* renamed from: a */
    private void m1315a(C1656ha c1656ha, int i, boolean z) {
        if (C1694j.m3427a(this.f859a) || !C1694j.m3426a() || c1656ha == null || c1656ha.f2437a != EnumC1633ge.SendMessage || c1656ha.m3010a() == null || !z) {
            return;
        }
        AbstractC1417b.m1089a("click to start activity result:" + String.valueOf(i));
        C1659hd c1659hd = new C1659hd(c1656ha.m3010a().m2842a(), false);
        c1659hd.m3064c(EnumC1643go.SDK_START_ACTIVITY.f2208a);
        c1659hd.m3060b(c1656ha.m3017a());
        c1659hd.m3068d(c1656ha.f2444b);
        c1659hd.f2473a = new HashMap();
        c1659hd.f2473a.put(IAssociationStartMonitorEventService.KEY_RESULT, String.valueOf(i));
        C1462u.m1373a(this.f859a).m1412a(c1659hd, EnumC1633ge.Notification, false, false, null, true, c1656ha.f2444b, c1656ha.f2440a, true, false);
    }
}
