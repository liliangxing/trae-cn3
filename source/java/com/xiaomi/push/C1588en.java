package com.xiaomi.push;

import android.content.Context;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1489aw;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.C1688if;
import com.xiaomi.push.service.C1766ax;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* renamed from: com.xiaomi.push.en */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1588en {

    /* renamed from: a */
    private int f1635a;

    /* renamed from: a */
    private long f1636a;

    /* renamed from: a */
    private C1587em f1638a;

    /* renamed from: a */
    private String f1639a;

    /* renamed from: a */
    private boolean f1640a = false;

    /* renamed from: a */
    private C1489aw f1637a = C1489aw.m1579a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.en$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        static final C1588en f1642a = new C1588en();
    }

    /* renamed from: a */
    public static C1588en m2403a() {
        return a.f1642a;
    }

    /* renamed from: a */
    public static C1587em m2402a() {
        C1587em c1587em;
        synchronized (a.f1642a) {
            c1587em = a.f1642a.f1638a;
        }
        return c1587em;
    }

    /* renamed from: a */
    public synchronized void m2409a(XMPushService xMPushService) {
        this.f1638a = new C1587em(xMPushService);
        this.f1639a = "";
        C1766ax.m3768a().m3780a(new C1766ax.a() { // from class: com.xiaomi.push.en.1
            @Override // com.xiaomi.push.service.C1766ax.a
            /* renamed from: a */
            public void mo2412a(C1562do.b bVar) {
                if (bVar.m2131e()) {
                    C1588en.m2403a().m2407a(bVar.m2130e());
                }
            }
        });
    }

    /* renamed from: a */
    public boolean m2410a() {
        return this.f1640a;
    }

    /* renamed from: a */
    public void m2407a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.f1635a == i2 && this.f1640a) {
                return;
            }
            this.f1640a = true;
            this.f1636a = System.currentTimeMillis();
            this.f1635a = i2;
            AbstractC1417b.m1101c("enable dot duration = " + i2 + " start = " + this.f1636a);
        }
    }

    /* renamed from: a */
    private void m2404a() {
        if (!this.f1640a || System.currentTimeMillis() - this.f1636a <= this.f1635a) {
            return;
        }
        this.f1640a = false;
        this.f1636a = 0L;
    }

    /* renamed from: b */
    boolean m2411b() {
        m2404a();
        return this.f1640a && this.f1637a.m1581a() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C1584ej m2406a() {
        C1584ej c1584ej;
        if (m2411b()) {
            c1584ej = m2401a(!C1486at.m1549d(this.f1638a.f1627a) ? MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS : MediaPlayer.MEDIA_PLAYER_OPTION_AI_BARRAGE_URL);
        } else {
            c1584ej = null;
        }
        return c1584ej;
    }

    /* renamed from: a */
    private C1584ej m2401a(int i) {
        ArrayList arrayList = new ArrayList();
        C1584ej c1584ej = new C1584ej(this.f1639a, arrayList);
        if (!C1486at.m1549d(this.f1638a.f1627a)) {
            c1584ej.m2378a(C1682i.m3402i(this.f1638a.f1627a));
        }
        C1690ih c1690ih = new C1690ih(i);
        AbstractC1681hz mo3373a = new C1688if.a().mo3373a(c1690ih);
        try {
            c1584ej.mo2358b(mo3373a);
        } catch (C1675ht unused) {
        }
        LinkedList<C1489aw.a> m1582a = this.f1637a.m1582a();
        while (m1582a.size() > 0) {
            try {
                C1583ei m2400a = m2400a(m1582a.getLast());
                if (m2400a != null) {
                    m2400a.mo2358b(mo3373a);
                }
                if (c1690ih.m3410a() > i) {
                    break;
                }
                if (m2400a != null) {
                    arrayList.add(m2400a);
                }
                m1582a.removeLast();
            } catch (C1675ht | NoSuchElementException unused2) {
            }
        }
        return c1584ej;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C1583ei m2405a() {
        C1583ei c1583ei;
        c1583ei = new C1583ei();
        c1583ei.m2350a(C1486at.m1535a((Context) this.f1638a.f1627a));
        c1583ei.f1596a = (byte) 0;
        c1583ei.f1600b = 1;
        c1583ei.m2365d((int) (System.currentTimeMillis() / 1000));
        return c1583ei;
    }

    /* renamed from: a */
    private C1583ei m2400a(C1489aw.a aVar) {
        if (aVar.f1026a == 0) {
            if (aVar.f1027a instanceof C1583ei) {
                return (C1583ei) aVar.f1027a;
            }
            return null;
        }
        C1583ei m2405a = m2405a();
        m2405a.m2349a(EnumC1582eh.CHANNEL_STATS_COUNTER.m2346a());
        m2405a.m2361c(aVar.f1026a);
        m2405a.m2362c(aVar.f1028a);
        return m2405a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m2408a(C1583ei c1583ei) {
        this.f1637a.m1583a(c1583ei);
    }
}
