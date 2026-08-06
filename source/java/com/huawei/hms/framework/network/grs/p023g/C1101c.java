package com.huawei.hms.framework.network.grs.p023g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C1119a;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p022f.C1095b;
import com.huawei.hms.framework.network.grs.p023g.p024i.C1107a;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1111d;
import com.huawei.hms.framework.network.grs.p026h.C1115d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* renamed from: com.huawei.hms.framework.network.grs.g.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1101c {

    /* renamed from: l */
    private static final String f1319l = "c";

    /* renamed from: a */
    private final GrsBaseInfo f1320a;

    /* renamed from: b */
    private final Context f1321b;

    /* renamed from: c */
    private final C1091a f1322c;

    /* renamed from: d */
    private C1102d f1323d;

    /* renamed from: i */
    private final C1110c f1328i;

    /* renamed from: e */
    private final Map<String, Future<C1102d>> f1324e = new ConcurrentHashMap(16);

    /* renamed from: f */
    private final List<C1102d> f1325f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final JSONArray f1326g = new JSONArray();

    /* renamed from: h */
    private final List<String> f1327h = new CopyOnWriteArrayList();

    /* renamed from: j */
    private String f1329j = "";

    /* renamed from: k */
    private long f1330k = 1;

    public C1101c(C1110c c1110c, C1091a c1091a) {
        this.f1328i = c1110c;
        this.f1320a = c1110c.m1354b();
        this.f1321b = c1110c.m1352a();
        this.f1322c = c1091a;
        m1293b();
        m1294c();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009b A[LOOP:0: B:2:0x0005->B:13:0x009b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C1102d m1290a(ExecutorService executorService, List<String> list, String str, C1093c c1093c) {
        boolean z;
        C1102d c1102d;
        C1102d c1102d2 = null;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            String str2 = list.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Future<C1102d> submit = executorService.submit(new C1099a(str2, i, this, this.f1321b, str, this.f1320a, c1093c).m1288g());
                this.f1324e.put(str2, submit);
                z = true;
                try {
                    c1102d = submit.get(this.f1330k, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e = e;
                } catch (CancellationException unused) {
                } catch (ExecutionException e2) {
                    e = e2;
                } catch (TimeoutException unused2) {
                }
                if (c1102d != null) {
                    try {
                    } catch (InterruptedException e3) {
                        e = e3;
                        c1102d2 = c1102d;
                        Logger.m1190w(f1319l, "the current thread was interrupted while waiting", e);
                        if (!z) {
                        }
                    } catch (CancellationException unused3) {
                        c1102d2 = c1102d;
                        Logger.m1185i(f1319l, "{requestServer} the computation was cancelled");
                        if (!z) {
                        }
                    } catch (ExecutionException e4) {
                        e = e4;
                        c1102d2 = c1102d;
                        Logger.m1190w(f1319l, "the computation threw an ExecutionException", e);
                        z = false;
                        if (!z) {
                        }
                    } catch (TimeoutException unused4) {
                        c1102d2 = c1102d;
                        Logger.m1189w(f1319l, "the wait timed out");
                        z = false;
                        if (!z) {
                        }
                    }
                    if (c1102d.m1333o() || c1102d.m1331m()) {
                        Logger.m1185i(f1319l, "grs request return body is not null and is OK.");
                        c1102d2 = c1102d;
                        if (!z) {
                            Logger.m1187v(f1319l, "needBreak is true so need break current circulation");
                            break;
                        }
                        i++;
                    }
                }
                c1102d2 = c1102d;
            }
            z = false;
            if (!z) {
            }
        }
        return m1292b(c1102d2);
    }

    /* renamed from: a */
    private void m1291a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.f1320a.getGrsReqParamJoint(false, false, m1295d(), this.f1321b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f1327h.add(sb.toString());
    }

    /* renamed from: b */
    private C1102d m1292b(C1102d c1102d) {
        String str;
        String str2;
        for (Map.Entry<String, Future<C1102d>> entry : this.f1324e.entrySet()) {
            if (c1102d != null && (c1102d.m1333o() || c1102d.m1331m())) {
                break;
            }
            try {
                c1102d = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                str = f1319l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.m1190w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.m1185i(f1319l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e2) {
                e = e2;
                str = f1319l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.m1190w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.m1189w(f1319l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return c1102d;
    }

    /* renamed from: b */
    private void m1293b() {
        C1111d m1347a = C1107a.m1347a(this.f1321b);
        if (m1347a == null) {
            Logger.m1189w(f1319l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        m1299a(m1347a);
        List<String> m1357a = m1347a.m1357a();
        if (m1357a == null || m1357a.size() <= 0) {
            Logger.m1187v(f1319l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (m1357a.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String m1361b = m1347a.m1361b();
        if (m1357a.size() > 0) {
            for (String str : m1357a) {
                if (str.startsWith("https://")) {
                    m1291a(m1361b, str);
                } else {
                    Logger.m1189w(f1319l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.m1188v(f1319l, "request to GRS server url is {%s}", this.f1327h);
    }

    /* renamed from: c */
    private void m1294c() {
        this.f1329j = this.f1322c.m1234a().m1244a(this.f1320a.getGrsParasKey(true, true, this.f1321b) + "ETag", "");
    }

    /* renamed from: d */
    private String m1295d() {
        C1095b m1270a = C1095b.m1270a(this.f1321b.getPackageName());
        C1119a m1272a = m1270a != null ? m1270a.m1272a() : null;
        if (m1272a == null) {
            return "";
        }
        String m1382a = m1272a.m1382a();
        Logger.m1188v(f1319l, "get appName from local assets is{%s}", m1382a);
        return m1382a;
    }

    /* renamed from: a */
    public C1102d m1296a(ExecutorService executorService, String str, C1093c c1093c) {
        if (this.f1327h.isEmpty()) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C1102d m1290a = m1290a(executorService, this.f1327h, str, c1093c);
        Logger.m1186i(f1319l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(m1290a == null ? 0 : m1290a.m1318b()));
        C1103e.m1335a(new ArrayList(this.f1325f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f1326g, this.f1321b);
        this.f1325f.clear();
        return m1290a;
    }

    /* renamed from: a */
    public String m1297a() {
        return this.f1329j;
    }

    /* renamed from: a */
    public synchronized void m1298a(C1102d c1102d) {
        this.f1325f.add(c1102d);
        C1102d c1102d2 = this.f1323d;
        if (c1102d2 != null && (c1102d2.m1333o() || this.f1323d.m1331m())) {
            Logger.m1187v(f1319l, "grsResponseResult is ok");
            return;
        }
        if (c1102d.m1332n()) {
            Logger.m1185i(f1319l, "GRS server open 503 limiting strategy.");
            C1115d.m1373a(this.f1320a.getGrsParasKey(true, true, this.f1321b), new C1115d.a(c1102d.m1329k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (c1102d.m1331m()) {
            Logger.m1185i(f1319l, "GRS server open 304 Not Modified.");
        }
        if (!c1102d.m1333o() && !c1102d.m1331m()) {
            Logger.m1187v(f1319l, "grsResponseResult has exception so need return");
            return;
        }
        this.f1323d = c1102d;
        this.f1322c.m1237a(this.f1320a, c1102d, this.f1321b, this.f1328i);
        for (Map.Entry<String, Future<C1102d>> entry : this.f1324e.entrySet()) {
            if (!entry.getKey().equals(c1102d.m1330l()) && !entry.getValue().isCancelled()) {
                Logger.m1185i(f1319l, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    /* renamed from: a */
    public void m1299a(C1111d c1111d) {
    }
}
