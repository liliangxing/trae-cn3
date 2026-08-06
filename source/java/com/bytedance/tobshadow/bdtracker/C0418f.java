package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.OaidFactory;
import com.bytedance.dr.impl.e;
import com.bytedance.tobshadow.applog.IOaidObserver;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0475n0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0418f {

    /* renamed from: h */
    public static final String f564h = "f#";

    /* renamed from: i */
    public static final String f565i = "f#";

    /* renamed from: j */
    public static final List<IOaidObserver> f566j = new ArrayList();

    /* renamed from: k */
    public static InterfaceC0488p f567k;

    /* renamed from: l */
    public static String f568l;

    /* renamed from: m */
    public static Map<String, String> f569m;

    /* renamed from: b */
    public final OaidApi f571b;

    /* renamed from: c */
    public final boolean f572c;

    /* renamed from: d */
    public final C0432h f573d;

    /* renamed from: e */
    public final Context f574e;

    /* renamed from: g */
    public Long f576g;

    /* renamed from: a */
    public final ReentrantLock f570a = new ReentrantLock();

    /* renamed from: f */
    public final AtomicBoolean f575f = new AtomicBoolean(false);

    /* renamed from: com.bytedance.tobshadow.bdtracker.f$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggerImpl.global().debug(1, "Oaid#init switch thread", new Object[0]);
            C0418f.this.m397b();
        }
    }

    public C0418f(Context context) {
        this.f574e = context.getApplicationContext();
        OaidApi createOaidImpl = OaidFactory.createOaidImpl(context);
        this.f571b = createOaidImpl;
        if (createOaidImpl != null) {
            this.f572c = createOaidImpl.support(context);
        } else {
            this.f572c = false;
        }
        this.f573d = new C0432h(context);
    }

    /* renamed from: a */
    public static void m389a(IOaidObserver.Oaid oaid, Object[] objArr) {
        if (oaid == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((IOaidObserver) obj).onOaidLoaded(oaid);
        }
    }

    /* renamed from: a */
    public static void m390a(IOaidObserver iOaidObserver) {
        InterfaceC0488p interfaceC0488p;
        List<IOaidObserver> list = f566j;
        synchronized (list) {
            list.add(iOaidObserver);
        }
        String str = f568l;
        if (str != null) {
            m389a(new IOaidObserver.Oaid(str), new Object[]{iOaidObserver});
        }
        Map<String, String> map = f569m;
        if (map == null || (interfaceC0488p = f567k) == null) {
            return;
        }
        ((C0475n0.b) interfaceC0488p).m561a(map);
    }

    /* renamed from: a */
    public static <K, V> void m392a(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    /* renamed from: a */
    public static void m393a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#JSON put failed", th, new Object[0]);
        }
    }

    /* renamed from: b */
    public static void m394b(IOaidObserver iOaidObserver) {
        List<IOaidObserver> list = f566j;
        synchronized (list) {
            list.remove(iOaidObserver);
        }
    }

    /* renamed from: c */
    public static Object[] m395c() {
        Object[] array;
        List<IOaidObserver> list = f566j;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    /* renamed from: a */
    public void m396a() {
        LoggerImpl.global().debug(1, "Oaid#init", new Object[0]);
        if (this.f575f.compareAndSet(false, true)) {
            a aVar = new a();
            String str = f565i + "-query";
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new C0411e.a(aVar, str), str).start();
        }
    }

    /* renamed from: b */
    public final void m397b() {
        String str;
        Boolean bool;
        int i;
        e.b oaid;
        LoggerImpl.global().debug(1, "Oaid#initOaid", new Object[0]);
        try {
            this.f570a.lock();
            LoggerImpl.global().debug(1, "Oaid#initOaid exec", new Object[0]);
            C0425g m452a = this.f573d.m452a();
            LoggerImpl.global().debug(1, "Oaid#initOaid fetch={}", m452a);
            if (m452a != null) {
                f568l = m452a.f603a;
                f569m = m452a.m441a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Context context = this.f574e;
            OaidApi oaidApi = this.f571b;
            C0425g c0425g = null;
            String str2 = null;
            if (oaidApi == null || (oaid = oaidApi.getOaid(context)) == null) {
                str = null;
                bool = null;
            } else {
                str = ((OaidApi.a) oaid).a;
                bool = Boolean.valueOf(((OaidApi.a) oaid).b);
                if (oaid instanceof e.b) {
                    this.f576g = Long.valueOf(oaid.c);
                }
            }
            Pair pair = new Pair(str, bool);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (pair.first != null) {
                if (m452a != null) {
                    str2 = m452a.f604b;
                    i = m452a.f608f.intValue() + 1;
                } else {
                    i = -1;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                if (i <= 0) {
                    i = 1;
                }
                C0425g c0425g2 = new C0425g((String) pair.first, str2, (Boolean) pair.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), this.f576g);
                this.f573d.m453a(c0425g2);
                c0425g = c0425g2;
            }
            if (c0425g != null) {
                f568l = c0425g.f603a;
                f569m = c0425g.m441a();
            }
            LoggerImpl.global().debug(1, "Oaid#initOaid oaidModel={}", c0425g);
        } finally {
            this.f570a.unlock();
            m389a(new IOaidObserver.Oaid(f568l), m395c());
            InterfaceC0488p interfaceC0488p = f567k;
            if (interfaceC0488p != null) {
                ((C0475n0.b) interfaceC0488p).m561a(f569m);
            }
        }
    }
}
