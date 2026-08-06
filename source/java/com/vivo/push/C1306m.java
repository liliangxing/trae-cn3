package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.p010b.C1204a;
import com.vivo.push.p010b.C1205b;
import com.vivo.push.p010b.C1206c;
import com.vivo.push.p010b.C1210g;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.p010b.C1229z;
import com.vivo.push.p017h.AbstractC1266ab;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1369ad;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1306m {

    /* renamed from: a */
    private static volatile C1306m f510a;

    /* renamed from: h */
    private Context f517h;

    /* renamed from: j */
    private String f519j;

    /* renamed from: m */
    private Boolean f522m;

    /* renamed from: n */
    private Long f523n;

    /* renamed from: o */
    private boolean f524o;

    /* renamed from: q */
    private int f526q;

    /* renamed from: b */
    private long f511b = -1;

    /* renamed from: c */
    private long f512c = -1;

    /* renamed from: d */
    private long f513d = -1;

    /* renamed from: e */
    private long f514e = -1;

    /* renamed from: f */
    private long f515f = -1;

    /* renamed from: g */
    private long f516g = -1;

    /* renamed from: i */
    private boolean f518i = true;

    /* renamed from: k */
    private SparseArray<a> f520k = new SparseArray<>();

    /* renamed from: l */
    private int f521l = 0;

    /* renamed from: p */
    private IPushClientFactory f525p = new C1305l();

    private C1306m() {
    }

    /* renamed from: a */
    public static synchronized C1306m m762a() {
        C1306m c1306m;
        synchronized (C1306m.class) {
            if (f510a == null) {
                f510a = new C1306m();
            }
            c1306m = f510a;
        }
        return c1306m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m784b() throws VivoPushException {
        Context context = this.f517h;
        if (context != null) {
            C1373ah.m963b(context);
        }
    }

    /* renamed from: a */
    public final synchronized void m774a(Context context) {
        if (this.f517h == null) {
            this.f517h = ContextDelegate.getContext(context);
            this.f524o = C1366aa.m931c(context, context.getPackageName());
            C1369ad.m941c().m944a(this.f517h);
            m776a(new C1210g());
            this.f519j = C1313a.m810a().m815e().mo869i();
        }
    }

    /* renamed from: c */
    public static List<String> m770c() {
        String mo867g = C1313a.m810a().m815e().mo867g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            C1313a.m810a().m815e().mo868h();
            arrayList.clear();
            C1393t.m1048d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(mo867g)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(mo867g).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* renamed from: d */
    public final boolean m789d() {
        if (this.f517h == null) {
            C1393t.m1048d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(m772l());
        this.f522m = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: a */
    public final void m782a(List<String> list) {
        if (list.contains(this.f519j)) {
            m790e();
        }
    }

    /* renamed from: e */
    public final void m790e() {
        this.f519j = null;
        C1313a.m810a().m815e().mo870j();
    }

    /* renamed from: f */
    public final boolean m791f() {
        return this.f524o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m783a(boolean z) {
        this.f518i = z;
    }

    /* renamed from: g */
    public final boolean m792g() {
        return this.f518i;
    }

    /* renamed from: h */
    public final Context m793h() {
        return this.f517h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m775a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (m767a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        C1313a.m810a().m818h().mo757b();
        if (!m766a(this.f511b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f511b = SystemClock.elapsedRealtime();
        String packageName = this.f517h.getPackageName();
        a aVar = null;
        if (this.f517h != null) {
            C1205b c1205b = new C1205b(true, packageName);
            c1205b.m591f();
            c1205b.m588c(str);
            c1205b.m589d(str2);
            c1205b.m586b(100);
            if (this.f524o) {
                if (m772l()) {
                    aVar = m761a(c1205b, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else {
                aVar = m761a(c1205b, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.m799a(new C1308n(this, aVar, str, str2));
        aVar.m797a();
    }

    /* renamed from: a */
    private a m761a(C1205b c1205b, IPushActionListener iPushActionListener) {
        a aVar = new a(c1205b, iPushActionListener);
        String m763a = m763a(aVar);
        c1205b.m587b(m763a);
        aVar.m800a(new RunnableC1309o(this, c1205b, m763a));
        return aVar;
    }

    /* renamed from: b */
    public final void m785b(IPushActionListener iPushActionListener, String str, String str2) {
        m764a(iPushActionListener, str, str2, 11);
    }

    /* renamed from: c */
    public final void m788c(IPushActionListener iPushActionListener, String str, String str2) {
        m764a(iPushActionListener, str, str2, 1);
    }

    /* renamed from: a */
    private void m764a(IPushActionListener iPushActionListener, String str, String str2, int i) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (m767a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!m766a(this.f512c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f512c = SystemClock.elapsedRealtime();
            a m760a = m760a(iPushActionListener, this.f517h.getPackageName(), str, str2, i);
            if (m760a == null) {
                return;
            }
            m760a.m799a(new C1310p(this));
            m760a.m797a();
        }
    }

    /* renamed from: a */
    private a m760a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        C1205b c1205b = new C1205b(false, str);
        c1205b.m588c(str2);
        c1205b.m589d(str3);
        if (i > 0) {
            c1205b.m584a(i);
        }
        c1205b.m591f();
        c1205b.m586b(100);
        if (this.f524o) {
            if (!m772l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(c1205b, iPushActionListener);
            String m763a = m763a(aVar);
            c1205b.m587b(m763a);
            aVar.m800a(new RunnableC1311q(this, c1205b, m763a));
            return aVar;
        }
        if (c1205b.m585a(this.f517h) == 2) {
            return m761a(c1205b, iPushActionListener);
        }
        return m761a(c1205b, iPushActionListener);
    }

    /* renamed from: a */
    public final void m779a(String str, int i, Object... objArr) {
        a m769b = m769b(str);
        if (m769b != null) {
            m769b.m798a(i, objArr);
        } else {
            C1393t.m1048d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m780a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (!C1313a.m810a().m817g().m647f()) {
            boolean z = false;
            if (TextUtils.isEmpty(this.f519j) || !this.f519j.equals(str)) {
                if (str.length() <= 70) {
                    if (this.f524o) {
                        if (m772l()) {
                            if (TextUtils.isEmpty(C1313a.m810a().m818h().mo757b())) {
                                if (iPushActionListener != null) {
                                    iPushActionListener.onStateChanged(30001);
                                }
                            }
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    }
                    if (z) {
                        return;
                    }
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30003);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
            z = true;
            if (z) {
            }
        }
        if (!m766a(this.f513d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C1204a c1204a = new C1204a(true, this.f517h.getPackageName(), arrayList);
        c1204a.m586b(100);
        c1204a.m588c(str2);
        c1204a.m589d(str3);
        this.f513d = SystemClock.elapsedRealtime();
        String m763a = m763a(new a(c1204a, iPushActionListener));
        c1204a.m587b(m763a);
        m776a(c1204a);
        m771c(m763a);
    }

    /* renamed from: a */
    public static boolean m766a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    /* renamed from: a */
    private static boolean m767a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m786b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f519j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!m766a(this.f514e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f524o) {
            if (!m772l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C1313a.m810a().m818h().mo757b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C1204a c1204a = new C1204a(false, this.f517h.getPackageName(), arrayList);
        c1204a.m586b(100);
        c1204a.m588c(str2);
        c1204a.m589d(str3);
        this.f514e = SystemClock.elapsedRealtime();
        String m763a = m763a(new a(c1204a, iPushActionListener));
        c1204a.m587b(m763a);
        m776a(c1204a);
        m771c(m763a);
    }

    /* renamed from: i */
    public final String m794i() {
        return this.f519j;
    }

    /* renamed from: a */
    public final void m777a(String str) {
        this.f519j = str;
        C1313a.m810a().m815e().mo865e(str);
    }

    /* renamed from: a */
    public final void m778a(String str, int i) {
        a m769b = m769b(str);
        if (m769b != null) {
            m769b.m798a(i, new Object[0]);
        } else {
            C1393t.m1048d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    /* renamed from: a */
    private synchronized String m763a(a aVar) {
        int i;
        this.f520k.put(this.f521l, aVar);
        i = this.f521l;
        this.f521l = i + 1;
        return Integer.toString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized a m769b(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f520k.get(parseInt);
                this.f520k.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m781a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!m766a(this.f515f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f515f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + m770c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f524o) {
            if (!m772l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C1313a.m810a().m818h().mo757b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        C1229z c1229z = new C1229z(true, this.f517h.getPackageName(), arrayList);
        c1229z.m586b(MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE);
        c1229z.m588c(str);
        c1229z.m589d(str2);
        String m763a = m763a(new a(c1229z, iPushActionListener));
        c1229z.m587b(m763a);
        m776a(c1229z);
        m771c(m763a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m787b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f517h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!m766a(this.f516g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f516g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f524o) {
            if (!m772l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C1313a.m810a().m818h().mo757b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        C1229z c1229z = new C1229z(false, this.f517h.getPackageName(), arrayList);
        c1229z.m586b(MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE);
        c1229z.m588c(str);
        c1229z.m589d(str2);
        String m763a = m763a(new a(c1229z, iPushActionListener));
        c1229z.m587b(m763a);
        m776a(c1229z);
        m771c(m763a);
    }

    /* renamed from: a */
    public final int m773a(Intent intent, PushMessageCallback pushMessageCallback) {
        AbstractC1400v createReceiverCommand = this.f525p.createReceiverCommand(intent);
        Context context = m762a().f517h;
        if (createReceiverCommand == null) {
            C1393t.m1034a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            C1393t.m1047c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        AbstractC1266ab createReceiveTask = this.f525p.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            C1393t.m1034a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            C1393t.m1047c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(createReceiverCommand instanceof C1217n)) {
            C1393t.m1038a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.m706a(pushMessageCallback);
        createReceiveTask.run();
        return createReceiveTask.m709c();
    }

    /* renamed from: a */
    public final void m776a(AbstractC1400v abstractC1400v) {
        Context context = m762a().f517h;
        if (abstractC1400v == null) {
            C1393t.m1034a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                C1393t.m1047c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        AbstractRunnableC1352s createTask = this.f525p.createTask(abstractC1400v);
        if (createTask == null) {
            C1393t.m1034a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(abstractC1400v)));
            if (context != null) {
                C1393t.m1047c(context, "[执行指令失败]指令" + abstractC1400v + "任务空！");
                return;
            }
            return;
        }
        C1393t.m1048d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(abstractC1400v)));
        C1357t.m915a(createTask, AbstractC1400v.m1061c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m771c(String str) {
        C1357t.m914a(new RunnableC1312r(this, str));
    }

    /* renamed from: j */
    public final int m795j() {
        return this.f526q;
    }

    /* renamed from: k */
    public final long m796k() {
        Context context = this.f517h;
        if (context == null) {
            return -1L;
        }
        if (this.f523n == null) {
            this.f523n = Long.valueOf(C1373ah.m951a(context));
        }
        return this.f523n.longValue();
    }

    /* renamed from: l */
    private boolean m772l() {
        if (this.f522m == null) {
            this.f522m = Boolean.valueOf(m796k() >= 1230 && C1373ah.m967d(this.f517h));
        }
        return this.f522m.booleanValue();
    }

    /* compiled from: PushClientManager.java */
    /* renamed from: com.vivo.push.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private IPushActionListener f527a;

        /* renamed from: b */
        private C1206c f528b;

        /* renamed from: c */
        private IPushActionListener f529c;

        /* renamed from: d */
        private Runnable f530d;

        /* renamed from: e */
        private Object[] f531e;

        public a(C1206c c1206c, IPushActionListener iPushActionListener) {
            this.f528b = c1206c;
            this.f527a = iPushActionListener;
        }

        /* renamed from: a */
        public final void m798a(int i, Object... objArr) {
            this.f531e = objArr;
            IPushActionListener iPushActionListener = this.f529c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.f527a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        /* renamed from: a */
        public final void m800a(Runnable runnable) {
            this.f530d = runnable;
        }

        /* renamed from: a */
        public final void m797a() {
            Runnable runnable = this.f530d;
            if (runnable == null) {
                C1393t.m1034a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        /* renamed from: a */
        public final void m799a(IPushActionListener iPushActionListener) {
            this.f529c = iPushActionListener;
        }

        /* renamed from: b */
        public final Object[] m801b() {
            return this.f531e;
        }
    }
}
