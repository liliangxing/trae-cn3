package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.push.ez */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1600ez {

    /* renamed from: a */
    private static final AtomicInteger f1696a = new AtomicInteger(0);

    /* renamed from: a */
    public static boolean f1697a;

    /* renamed from: a */
    protected C1602fa f1700a;

    /* renamed from: a */
    protected XMPushService f1702a;

    /* renamed from: a */
    protected int f1698a = 0;

    /* renamed from: a */
    protected long f1699a = -1;

    /* renamed from: b */
    protected volatile long f1708b = 0;

    /* renamed from: c */
    protected volatile long f1712c = 0;

    /* renamed from: a */
    private LinkedList<Pair<Integer, Long>> f1705a = new LinkedList<>();

    /* renamed from: a */
    private final Collection<InterfaceC1604fc> f1704a = new CopyOnWriteArrayList();

    /* renamed from: a */
    protected final Map<InterfaceC1606fe, a> f1706a = new ConcurrentHashMap();

    /* renamed from: b */
    protected final Map<InterfaceC1606fe, a> f1710b = new ConcurrentHashMap();

    /* renamed from: a */
    protected InterfaceC1610fi f1701a = null;

    /* renamed from: a */
    protected String f1703a = "";

    /* renamed from: b */
    protected String f1709b = "";

    /* renamed from: c */
    private int f1711c = 2;

    /* renamed from: b */
    protected final int f1707b = f1696a.getAndIncrement();

    /* renamed from: e */
    private long f1714e = 0;

    /* renamed from: d */
    protected long f1713d = 0;

    /* renamed from: a */
    private String m2500a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a */
    public abstract void mo2487a(AbstractC1615fn abstractC1615fn);

    /* renamed from: a */
    public abstract void mo2488a(C1755am.b bVar);

    /* renamed from: a */
    public abstract void mo2489a(String str, String str2);

    /* renamed from: a */
    public abstract void mo2491a(C1591eq[] c1591eqArr);

    /* renamed from: a */
    public boolean mo2492a() {
        return false;
    }

    /* renamed from: b */
    public abstract void mo2516b(int i, Exception exc);

    /* renamed from: b */
    public abstract void mo2494b(C1591eq c1591eq);

    /* renamed from: b */
    public abstract void mo2520b(boolean z);

    static {
        f1697a = false;
        try {
            f1697a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        C1607ff.m2544a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1600ez(XMPushService xMPushService, C1602fa c1602fa) {
        this.f1700a = c1602fa;
        this.f1702a = xMPushService;
        m2515b();
    }

    /* renamed from: a */
    public C1602fa m2504a() {
        return this.f1700a;
    }

    /* renamed from: a */
    public String mo2505a() {
        return this.f1700a.m2539c();
    }

    /* renamed from: b */
    public String m2514b() {
        return this.f1700a.m2537b();
    }

    /* renamed from: a */
    public long m2503a() {
        return this.f1712c;
    }

    /* renamed from: a */
    public void m2508a(InterfaceC1604fc interfaceC1604fc) {
        if (interfaceC1604fc == null || this.f1704a.contains(interfaceC1604fc)) {
            return;
        }
        this.f1704a.add(interfaceC1604fc);
    }

    /* renamed from: b */
    public void m2517b(InterfaceC1604fc interfaceC1604fc) {
        this.f1704a.remove(interfaceC1604fc);
    }

    /* renamed from: a */
    public void m2510a(InterfaceC1606fe interfaceC1606fe, InterfaceC1611fj interfaceC1611fj) {
        if (interfaceC1606fe == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f1706a.put(interfaceC1606fe, new a(interfaceC1606fe, interfaceC1611fj));
    }

    /* renamed from: a */
    public void m2509a(InterfaceC1606fe interfaceC1606fe) {
        this.f1706a.remove(interfaceC1606fe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Map<InterfaceC1606fe, a> m2506a() {
        return this.f1706a;
    }

    /* renamed from: b */
    public void m2519b(InterfaceC1606fe interfaceC1606fe, InterfaceC1611fj interfaceC1611fj) {
        if (interfaceC1606fe == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f1710b.put(interfaceC1606fe, new a(interfaceC1606fe, interfaceC1611fj));
    }

    /* renamed from: b */
    public void m2518b(InterfaceC1606fe interfaceC1606fe) {
        this.f1710b.remove(interfaceC1606fe);
    }

    /* renamed from: b */
    protected void m2515b() {
        String str;
        if (this.f1700a.m2535a() && this.f1701a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f1701a = new C1599ey(this);
                return;
            }
            try {
                this.f1701a = (InterfaceC1610fi) cls.getConstructor(AbstractC1600ez.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    /* renamed from: com.xiaomi.push.ez$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private InterfaceC1606fe f1715a;

        /* renamed from: a */
        private InterfaceC1611fj f1716a;

        public a(InterfaceC1606fe interfaceC1606fe, InterfaceC1611fj interfaceC1611fj) {
            this.f1715a = interfaceC1606fe;
            this.f1716a = interfaceC1611fj;
        }

        /* renamed from: a */
        public void m2526a(AbstractC1615fn abstractC1615fn) {
            InterfaceC1611fj interfaceC1611fj = this.f1716a;
            if (interfaceC1611fj == null || interfaceC1611fj.mo1864a(abstractC1615fn)) {
                this.f1715a.mo1863a(abstractC1615fn);
            }
        }

        /* renamed from: a */
        public void m2525a(C1591eq c1591eq) {
            this.f1715a.mo1862a(c1591eq);
        }
    }

    /* renamed from: b */
    public boolean m2521b() {
        return this.f1711c == 0;
    }

    /* renamed from: c */
    public boolean m2523c() {
        return this.f1711c == 1;
    }

    /* renamed from: a */
    public int m2502a() {
        return this.f1698a;
    }

    /* renamed from: a */
    public void m2507a(int i, int i2, Exception exc) {
        int i3 = this.f1711c;
        if (i != i3) {
            AbstractC1417b.m1089a(String.format("update the connection status. %1$s -> %2$s : %3$s ", m2500a(i3), m2500a(i), AbstractC1756an.m3733a(i2)));
        }
        if (C1486at.m1545a((Context) this.f1702a)) {
            m2501a(i);
        }
        if (i == 1) {
            this.f1702a.m3545a(10);
            if (this.f1711c != 0) {
                AbstractC1417b.m1089a("try set connected while not connecting.");
            }
            this.f1711c = i;
            Iterator<InterfaceC1604fc> it = this.f1704a.iterator();
            while (it.hasNext()) {
                it.next().mo1922b(this);
            }
            return;
        }
        if (i == 0) {
            if (this.f1711c != 2) {
                AbstractC1417b.m1089a("try set connecting while not disconnected.");
            }
            this.f1711c = i;
            Iterator<InterfaceC1604fc> it2 = this.f1704a.iterator();
            while (it2.hasNext()) {
                it2.next().mo1919a(this);
            }
            return;
        }
        if (i == 2) {
            this.f1702a.m3545a(10);
            int i4 = this.f1711c;
            if (i4 == 0) {
                Iterator<InterfaceC1604fc> it3 = this.f1704a.iterator();
                while (it3.hasNext()) {
                    it3.next().mo1921a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                Iterator<InterfaceC1604fc> it4 = this.f1704a.iterator();
                while (it4.hasNext()) {
                    it4.next().mo1920a(this, i2, exc);
                }
            }
            this.f1711c = i;
        }
    }

    /* renamed from: b */
    public int m2513b() {
        return this.f1711c;
    }

    /* renamed from: a */
    public synchronized void m2511a(String str) {
        if (this.f1711c == 0) {
            AbstractC1417b.m1089a("setChallenge hash = " + C1492az.m1595a(str).substring(0, 8));
            this.f1703a = str;
            m2507a(1, 0, null);
        } else {
            AbstractC1417b.m1089a("ignore setChallenge because connection was disconnected");
        }
    }

    /* renamed from: c */
    public synchronized void m2522c() {
        this.f1714e = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public synchronized boolean m2512a(long j) {
        return this.f1714e >= j;
    }

    /* renamed from: a */
    private void m2501a(int i) {
        synchronized (this.f1705a) {
            if (i == 1) {
                this.f1705a.clear();
            } else {
                this.f1705a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f1705a.size() > 6) {
                    this.f1705a.remove(0);
                }
            }
        }
    }

    /* renamed from: d */
    public void m2524d() {
        synchronized (this.f1705a) {
            this.f1705a.clear();
        }
    }
}
