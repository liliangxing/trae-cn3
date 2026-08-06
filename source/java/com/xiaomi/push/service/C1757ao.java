package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.AbstractC1600ez;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1522cb;
import com.xiaomi.push.C1526cf;
import com.xiaomi.push.C1561dn;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.C1588en;
import com.xiaomi.push.C1589eo;
import com.xiaomi.push.C1624fw;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.EnumC1582eh;
import com.xiaomi.push.InterfaceC1525ce;
import com.xiaomi.push.service.C1766ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.ao */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1757ao extends C1766ax.a implements C1526cf.a {

    /* renamed from: a */
    private long f3067a;

    /* renamed from: a */
    private XMPushService f3068a;

    @Override // com.xiaomi.push.service.C1766ax.a
    /* renamed from: a */
    public void mo3735a(C1561dn.a aVar) {
    }

    /* renamed from: a */
    public static void m3734a(XMPushService xMPushService) {
        C1757ao c1757ao = new C1757ao(xMPushService);
        C1766ax.m3768a().m3780a(c1757ao);
        synchronized (C1526cf.class) {
            C1526cf.m1817a(c1757ao);
            C1526cf.m1816a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    C1757ao(XMPushService xMPushService) {
        this.f3068a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.ao$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a implements C1526cf.b {
        a() {
        }

        @Override // com.xiaomi.push.C1526cf.b
        /* renamed from: a */
        public String mo1844a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter(RegistrationHeaderHelper.KEY_OS, C1624fw.m2647a(Build.MODEL + Constants.COLON_SEPARATOR + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C1702q.m3461a()));
            String builder = buildUpon.toString();
            AbstractC1417b.m1101c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String m1536a = C1486at.m1536a(C1702q.m3462a(), url);
                C1589eo.m2419a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return m1536a;
            } catch (IOException e) {
                C1589eo.m2419a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e);
                throw e;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.ao$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class b extends C1526cf {
        protected b(Context context, InterfaceC1525ce interfaceC1525ce, C1526cf.b bVar, String str) {
            super(context, interfaceC1525ce, bVar, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.push.C1526cf
        /* renamed from: a */
        public String mo1824a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (C1588en.m2403a().m2410a()) {
                    str2 = C1766ax.m3769a();
                }
                return super.mo1824a(arrayList, str, str2, z);
            } catch (IOException e) {
                C1589eo.m2416a(0, EnumC1582eh.GSLB_ERR.m2346a(), 1, null, C1486at.m1547b(f1158a) ? 1 : 0);
                throw e;
            }
        }
    }

    @Override // com.xiaomi.push.service.C1766ax.a
    /* renamed from: a */
    public void mo2412a(C1562do.b bVar) {
        C1522cb m1830b;
        boolean z;
        if (bVar.m2124b() && bVar.m2122a() && System.currentTimeMillis() - this.f3067a > DownloadConstants.HOUR) {
            AbstractC1417b.m1089a("fetch bucket :" + bVar.m2122a());
            this.f3067a = System.currentTimeMillis();
            C1526cf m1812a = C1526cf.m1812a();
            m1812a.m1826a();
            m1812a.m1832b();
            AbstractC1600ez m3542a = this.f3068a.m3542a();
            if (m3542a == null || (m1830b = m1812a.m1830b(m3542a.m2504a().m2539c())) == null) {
                return;
            }
            ArrayList<String> m1780a = m1830b.m1780a();
            Iterator<String> it = m1780a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(m3542a.mo2505a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m1780a.isEmpty()) {
                return;
            }
            AbstractC1417b.m1089a("bucket changed, force reconnect");
            this.f3068a.m3546a(0, (Exception) null);
            this.f3068a.m3554a(false);
        }
    }

    @Override // com.xiaomi.push.C1526cf.a
    /* renamed from: a */
    public C1526cf mo1843a(Context context, InterfaceC1525ce interfaceC1525ce, C1526cf.b bVar, String str) {
        return new b(context, interfaceC1525ce, bVar, str);
    }
}
