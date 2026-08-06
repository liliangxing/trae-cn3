package cn.com.chinatelecom.account.api.p009d;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e;
import cn.com.chinatelecom.account.api.p008c.C0684d;
import cn.com.chinatelecom.account.api.p010e.C0695b;
import cn.com.chinatelecom.account.api.p010e.C0697d;
import cn.com.chinatelecom.account.api.p010e.C0698e;
import cn.com.chinatelecom.account.api.p010e.C0699f;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import cn.com.chinatelecom.account.api.p010e.C0703j;
import java.net.InetAddress;

/* renamed from: cn.com.chinatelecom.account.api.d.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0688c {

    /* renamed from: a */
    private static final String f211a = "c";

    /* renamed from: b */
    private static String f212b = null;

    /* renamed from: c */
    private static long f213c = 0;

    /* renamed from: d */
    private static long f214d = 1800000;

    /* renamed from: a */
    public static synchronized String m243a() {
        synchronized (C0688c.class) {
            if (System.currentTimeMillis() >= f213c || !C0697d.m300a(f212b)) {
                return null;
            }
            return f212b;
        }
    }

    /* renamed from: a */
    public static void m246a(final Context context) {
        if (f212b == null && C0700g.m338a() == null) {
            new C0684d().m233a(new AbstractRunnableC0685e() { // from class: cn.com.chinatelecom.account.api.d.c.1
                @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
                /* renamed from: a */
                public void mo204a() {
                    C0698e m316a;
                    String m189a;
                    try {
                        String m296a = C0697d.m296a();
                        C0699f.m328a(m296a).m317a(C0697d.m297a(context)).m323c("dns").m321b(C0700g.m347f(context));
                        String m189a2 = C0678d.m189a(C0695b.f255f);
                        String m248b = C0688c.m248b(m189a2, m296a, 0);
                        if (TextUtils.isEmpty(m248b)) {
                            m248b = C0688c.m248b(m189a2, m296a, 1);
                        }
                        synchronized (C0688c.class) {
                            if (TextUtils.isEmpty(m248b)) {
                                m316a = C0699f.m328a(m296a).m316a(80011);
                                m189a = C0678d.m189a(C0703j.f314q);
                            } else {
                                String unused = C0688c.f212b = m248b;
                                long unused2 = C0688c.f213c = System.currentTimeMillis() + C0688c.f214d;
                                m316a = C0699f.m328a(m296a).m316a(0);
                                m189a = "success";
                            }
                            m316a.m325e(m189a);
                        }
                        C0699f.m333b(m296a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m248b(String str, String str2, int i) {
        try {
            C0699f.m328a(str2).m319b(i);
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            C0699f.m328a(str2).m327g((i == 0 ? new StringBuilder("first exception: ") : new StringBuilder("retry exception: ")).append(e.getMessage()).toString());
            return null;
        }
    }
}
