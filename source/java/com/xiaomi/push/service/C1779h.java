package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1615fn;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1613fl;
import com.xiaomi.push.C1614fm;
import com.xiaomi.push.C1617fp;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.service.C1755am;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1779h {

    /* renamed from: a */
    private C1793u f3150a = new C1793u();

    /* renamed from: a */
    public void m3853a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (C1694j.m3435c()) {
                intent.addFlags(16777216);
            }
            AbstractC1417b.m1089a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public void m3856a(Context context, C1755am.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.f3005g)) {
            this.f3150a.m4007a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f2995a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f3005g);
        intent.putExtra(AbstractC1756an.f3059s, bVar.f2999b);
        intent.putExtra(AbstractC1756an.f3032J, bVar.f3007i);
        AbstractC1417b.m1089a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.f3005g, bVar.f2995a, Boolean.valueOf(z), Integer.valueOf(i)));
        m3850a(context, intent, bVar);
    }

    /* renamed from: a */
    public void m3854a(Context context, C1755am.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.f3005g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f2995a);
        intent.putExtra(AbstractC1756an.f3062v, bVar.f3005g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(AbstractC1756an.f3059s, bVar.f2999b);
        intent.putExtra(AbstractC1756an.f3032J, bVar.f3007i);
        if (bVar.f2989a != null && "9".equals(bVar.f3005g)) {
            try {
                bVar.f2989a.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                bVar.f2989a = null;
                AbstractC1417b.m1089a("peer may died: " + bVar.f2999b.substring(bVar.f2999b.lastIndexOf(64)));
                return;
            }
        }
        AbstractC1417b.m1089a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.f3005g, bVar.f2995a, Integer.valueOf(i)));
        m3850a(context, intent, bVar);
    }

    /* renamed from: a */
    public void m3858a(XMPushService xMPushService, String str, AbstractC1615fn abstractC1615fn) {
        String str2;
        C1755am.b m3852a = m3852a(abstractC1615fn);
        if (m3852a == null) {
            AbstractC1417b.m1103d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f3150a.m4009a(xMPushService, abstractC1615fn, m3852a);
            return;
        }
        String str3 = m3852a.f2995a;
        if (abstractC1615fn instanceof C1614fm) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (abstractC1615fn instanceof C1613fl) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(abstractC1615fn instanceof C1617fp)) {
                AbstractC1417b.m1103d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", abstractC1615fn.mo2573a());
        intent.putExtra(AbstractC1756an.f3032J, m3852a.f3007i);
        intent.putExtra(AbstractC1756an.f3024B, m3852a.f3006h);
        AbstractC1417b.m1089a(String.format("[Bcst] notify packet arrival. %s,%s,%s", m3852a.f3005g, m3852a.f2995a, abstractC1615fn.m2610j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(AbstractC1756an.f3063w, abstractC1615fn.f1788a);
            intent.putExtra(AbstractC1756an.f3064x, System.currentTimeMillis());
        }
        m3850a(xMPushService, intent, m3852a);
    }

    /* renamed from: a */
    public void m3857a(XMPushService xMPushService, String str, C1591eq c1591eq) {
        C1755am.b m3851a = m3851a(c1591eq);
        if (m3851a == null) {
            AbstractC1417b.m1103d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f3150a.m4008a(xMPushService, c1591eq, m3851a);
            return;
        }
        String str2 = m3851a.f2995a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", c1591eq.m2443a(m3851a.f3006h));
        intent.putExtra(AbstractC1756an.f3032J, m3851a.f3007i);
        intent.putExtra(AbstractC1756an.f3024B, m3851a.f3006h);
        if (AbstractC1776e.m3828a(c1591eq)) {
            intent.putExtra("ext_downward_pkt_id", c1591eq.m2455e());
        }
        if (m3851a.f2989a != null) {
            try {
                m3851a.f2989a.send(Message.obtain(null, 17, intent));
                AbstractC1417b.m1089a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                m3851a.f2989a = null;
                AbstractC1417b.m1089a("peer may died: " + m3851a.f2999b.substring(m3851a.f2999b.lastIndexOf(64)));
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        AbstractC1417b.m1089a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", m3851a.f3005g, m3851a.f2995a, c1591eq.m2455e()));
        if (AbstractC1776e.m3828a(c1591eq)) {
            C1762at.m3753a().m3756a(c1591eq.m2455e(), SystemClock.elapsedRealtime());
        }
        m3850a(xMPushService, intent, m3851a);
    }

    /* renamed from: a */
    C1755am.b m3852a(AbstractC1615fn abstractC1615fn) {
        Collection<C1755am.b> m3707a = C1755am.m3702a().m3707a(abstractC1615fn.m2611k());
        if (m3707a.isEmpty()) {
            return null;
        }
        Iterator<C1755am.b> it = m3707a.iterator();
        if (m3707a.size() == 1) {
            return it.next();
        }
        String m2615m = abstractC1615fn.m2615m();
        String m2613l = abstractC1615fn.m2613l();
        while (it.hasNext()) {
            C1755am.b next = it.next();
            if (TextUtils.equals(m2615m, next.f2999b) || TextUtils.equals(m2613l, next.f2999b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    C1755am.b m3851a(C1591eq c1591eq) {
        Collection<C1755am.b> m3707a = C1755am.m3702a().m3707a(Integer.toString(c1591eq.m2429a()));
        if (m3707a.isEmpty()) {
            return null;
        }
        Iterator<C1755am.b> it = m3707a.iterator();
        if (m3707a.size() == 1) {
            return it.next();
        }
        String m2457g = c1591eq.m2457g();
        while (it.hasNext()) {
            C1755am.b next = it.next();
            if (TextUtils.equals(m2457g, next.f2999b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m3855a(Context context, C1755am.b bVar, String str, String str2) {
        if (bVar == null) {
            AbstractC1417b.m1103d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.f3005g)) {
            AbstractC1417b.m1103d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f2995a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f3005g);
        intent.putExtra(AbstractC1756an.f3059s, bVar.f2999b);
        intent.putExtra(AbstractC1756an.f3032J, bVar.f3007i);
        AbstractC1417b.m1089a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.f3005g, bVar.f2995a, str2));
        m3850a(context, intent, bVar);
    }

    /* renamed from: a */
    private static void m3850a(Context context, Intent intent, C1755am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, m3849a(bVar));
        }
    }

    /* renamed from: a */
    public static String m3849a(C1755am.b bVar) {
        if (!"9".equals(bVar.f3005g)) {
            return bVar.f2995a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f2995a + ".permission.MIMC_RECEIVE";
    }
}
