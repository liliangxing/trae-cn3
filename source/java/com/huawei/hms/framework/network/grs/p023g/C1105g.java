package com.huawei.hms.framework.network.grs.p023g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.InterfaceC1088b;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p023g.p024i.C1107a;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1109b;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1111d;
import com.huawei.hms.framework.network.grs.p026h.C1115d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.framework.network.grs.g.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1105g {

    /* renamed from: b */
    private static final ExecutorService f1350b = ExecutorsUtils.newCachedThreadPool("GrsReqPool");

    /* renamed from: c */
    private static final Map<String, C1109b> f1351c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private static final Object f1352d = new Object();

    /* renamed from: a */
    private C1091a f1353a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.framework.network.grs.g.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Callable<C1102d> {

        /* renamed from: a */
        final /* synthetic */ C1110c f1354a;

        /* renamed from: b */
        final /* synthetic */ String f1355b;

        /* renamed from: c */
        final /* synthetic */ C1093c f1356c;

        a(C1110c c1110c, String str, C1093c c1093c) {
            this.f1354a = c1110c;
            this.f1355b = str;
            this.f1356c = c1093c;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1102d call() {
            return new C1101c(this.f1354a, C1105g.this.f1353a).m1296a(C1105g.f1350b, this.f1355b, this.f1356c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.framework.network.grs.g.g$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1110c f1358a;

        /* renamed from: b */
        final /* synthetic */ String f1359b;

        /* renamed from: c */
        final /* synthetic */ C1093c f1360c;

        /* renamed from: d */
        final /* synthetic */ int f1361d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC1088b f1362e;

        b(C1110c c1110c, String str, C1093c c1093c, int i, InterfaceC1088b interfaceC1088b) {
            this.f1358a = c1110c;
            this.f1359b = str;
            this.f1360c = c1093c;
            this.f1361d = i;
            this.f1362e = interfaceC1088b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1105g c1105g = C1105g.this;
            c1105g.m1339a(c1105g.m1341a(this.f1358a, this.f1359b, this.f1360c, this.f1361d), this.f1362e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1339a(C1102d c1102d, InterfaceC1088b interfaceC1088b) {
        if (interfaceC1088b != null) {
            if (c1102d == null) {
                Logger.m1187v("RequestController", "GrsResponse is null");
                interfaceC1088b.mo1203a();
            } else {
                Logger.m1187v("RequestController", "GrsResponse is not null");
                interfaceC1088b.mo1204a(c1102d);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0065, code lost:
    
        if (r3.m1374a() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0069, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1102d m1341a(C1110c c1110c, String str, C1093c c1093c, int i) {
        Future<C1102d> submit;
        String str2;
        String str3;
        Logger.m1180d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = c1110c.m1354b().getGrsParasKey(true, true, c1110c.m1352a());
        Logger.m1187v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (f1352d) {
            if (!NetworkUtil.isNetworkAvailable(c1110c.m1352a())) {
                return null;
            }
            C1115d.a m1372a = C1115d.m1372a(grsParasKey);
            Map<String, C1109b> map = f1351c;
            C1109b c1109b = map.get(grsParasKey);
            try {
                if (c1109b != null && c1109b.m1349b()) {
                    submit = c1109b.m1348a();
                    if (i == -1) {
                        C1111d m1347a = C1107a.m1347a(c1110c.m1352a());
                        i = m1347a != null ? m1347a.m1362c() : 10;
                    }
                    Logger.m1186i("RequestController", "use grsQueryTimeout %d", Integer.valueOf(i));
                    return submit.get(i, TimeUnit.SECONDS);
                }
                return submit.get(i, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e = e;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.m1190w(str2, str3, e);
                return null;
            } catch (CancellationException e2) {
                e = e2;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.m1190w(str2, str3, e);
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.m1190w(str2, str3, e);
                return null;
            } catch (TimeoutException e4) {
                e = e4;
                str2 = "RequestController";
                str3 = "when check result, find TimeoutException, check others";
                Logger.m1190w(str2, str3, e);
                return null;
            } catch (Exception e5) {
                e = e5;
                str2 = "RequestController";
                str3 = "when check result, find Other Exception, check others";
                Logger.m1190w(str2, str3, e);
                return null;
            }
            Logger.m1180d("RequestController", "hitGrsRequestBean == null or request block is released.");
            submit = f1350b.submit(new a(c1110c, str, c1093c));
            map.put(grsParasKey, new C1109b(submit));
            if (i == -1) {
            }
            Logger.m1186i("RequestController", "use grsQueryTimeout %d", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public void m1342a(C1091a c1091a) {
        this.f1353a = c1091a;
    }

    /* renamed from: a */
    public void m1343a(C1110c c1110c, InterfaceC1088b interfaceC1088b, String str, C1093c c1093c, int i) {
        f1350b.execute(new b(c1110c, str, c1093c, i, interfaceC1088b));
    }

    /* renamed from: a */
    public void m1344a(String str) {
        synchronized (f1352d) {
            f1351c.remove(str);
        }
    }
}
