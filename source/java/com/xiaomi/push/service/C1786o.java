package com.xiaomi.push.service;

import android.text.TextUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.InterfaceC1632gd;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1786o implements InterfaceC1632gd {

    /* renamed from: a */
    private final XMPushService f3190a;

    public C1786o(XMPushService xMPushService) {
        this.f3190a = xMPushService;
    }

    @Override // com.xiaomi.push.InterfaceC1632gd
    /* renamed from: a */
    public void mo2712a(final List<C1637gi> list, final String str, final String str2) {
        this.f3190a.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                String m3947a = C1786o.this.m3947a(str);
                ArrayList<C1659hd> m3792a = C1768az.m3792a(list, str, m3947a, 32768);
                if (m3792a != null) {
                    Iterator<C1659hd> it = m3792a.iterator();
                    while (it.hasNext()) {
                        C1659hd next = it.next();
                        next.m3055a("uploadWay", "longXMPushService");
                        C1656ha m4027a = C1795w.m4027a(str, m3947a, next, EnumC1633ge.Notification);
                        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                            if (m4027a.m3010a() == null) {
                                C1646gr c1646gr = new C1646gr();
                                c1646gr.m2840a(LynxConstants.LYNX_DEFAULT_COMPONENT_ID);
                                m4027a.m3012a(c1646gr);
                            }
                            m4027a.m3010a().m2854b("ext_traffic_source_pkg", str2);
                        }
                        C1786o.this.f3190a.m3553a(str, C1670ho.m3313a(m4027a), true);
                    }
                    return;
                }
                AbstractC1417b.m1103d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m3947a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f3190a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
