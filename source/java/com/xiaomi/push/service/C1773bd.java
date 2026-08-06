package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.bd */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1773bd implements XMPushService.InterfaceC1735n {

    /* renamed from: a */
    private static Context f3133a;

    /* renamed from: a */
    private static final boolean f3135a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a */
    private static final Map<Integer, Map<String, List<String>>> f3134a = new HashMap();

    public C1773bd(Context context) {
        f3133a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.InterfaceC1735n
    /* renamed from: a */
    public void mo2675a() {
        Map<Integer, Map<String, List<String>>> map = f3134a;
        if (map.size() > 0) {
            synchronized (map) {
                m3824b();
            }
        }
    }

    /* renamed from: b */
    private static void m3824b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f3134a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map.get(str);
                        if (!C1703r.m3475a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    C1659hd m3822a = m3822a(null, C1752aj.m3692a(), EnumC1643go.NotificationRemoved.f2208a, null);
                    m3822a.m3055a("removed_reason", String.valueOf(num));
                    m3822a.m3055a("all_delete_msgId_appId", sb.toString());
                    AbstractC1417b.m1098b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    m3823a(f3133a, m3822a);
                }
                f3134a.remove(num);
            }
        }
    }

    /* renamed from: a */
    private static void m3823a(Context context, final C1659hd c1659hd) {
        if (f3135a) {
            AbstractC1417b.m1098b("UNDatas upload message notification:" + c1659hd);
        }
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] m3313a = C1670ho.m3313a(C1795w.m4027a(C1659hd.this.m3069d(), C1659hd.this.m3061b(), C1659hd.this, EnumC1633ge.Notification));
                if (C1773bd.f3133a instanceof XMPushService) {
                    ((XMPushService) C1773bd.f3133a).m3553a(C1659hd.this.m3069d(), m3313a, true);
                } else {
                    AbstractC1417b.m1089a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    /* renamed from: a */
    private static C1659hd m3822a(String str, String str2, String str3, String str4) {
        C1659hd c1659hd = new C1659hd();
        if (str3 != null) {
            c1659hd.m3064c(str3);
        }
        if (str != null) {
            c1659hd.m3060b(str);
        }
        if (str2 != null) {
            c1659hd.m3047a(str2);
        }
        if (str4 != null) {
            c1659hd.m3068d(str4);
        }
        c1659hd.m3050a(false);
        return c1659hd;
    }
}
