package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p022f.C1095b;
import com.huawei.hms.framework.network.grs.p023g.C1105g;
import com.huawei.hms.framework.network.grs.p023g.C1106h;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1110c;
import com.huawei.hms.framework.network.grs.p026h.C1112a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.framework.network.grs.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1089c {

    /* renamed from: i */
    private static final String f1269i = "c";

    /* renamed from: j */
    private static final ExecutorService f1270j = ExecutorsUtils.newSingleThreadExecutor("GrsInit");

    /* renamed from: k */
    private static long f1271k = 0;

    /* renamed from: a */
    private GrsBaseInfo f1272a;

    /* renamed from: b */
    private Context f1273b;

    /* renamed from: c */
    private C1105g f1274c;

    /* renamed from: d */
    private C1091a f1275d;

    /* renamed from: e */
    private C1093c f1276e;

    /* renamed from: f */
    private C1093c f1277f;

    /* renamed from: g */
    private C1087a f1278g;

    /* renamed from: h */
    private FutureTask<Boolean> f1279h;

    /* renamed from: com.huawei.hms.framework.network.grs.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class a implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Context f1280a;

        /* renamed from: b */
        final /* synthetic */ GrsBaseInfo f1281b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.huawei.hms.framework.network.grs.c$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public class RunnableC1640a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1095b f1283a;

            /* renamed from: b */
            final /* synthetic */ C1093c f1284b;

            RunnableC1640a(C1095b c1095b, C1093c c1093c) {
                this.f1283a = c1095b;
                this.f1284b = c1093c;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1283a.m1275a(a.this.f1280a.getPackageName(), this.f1284b);
            }
        }

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f1280a = context;
            this.f1281b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            C1089c.this.f1274c = new C1105g();
            C1089c.this.f1276e = new C1093c(this.f1280a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_conf_");
            C1089c.this.f1277f = new C1093c(this.f1280a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_services_");
            C1089c c1089c = C1089c.this;
            c1089c.f1275d = new C1091a(c1089c.f1276e, C1089c.this.f1277f, C1089c.this.f1274c);
            C1089c c1089c2 = C1089c.this;
            c1089c2.f1278g = new C1087a(c1089c2.f1272a, C1089c.this.f1275d, C1089c.this.f1274c, C1089c.this.f1277f);
            if (C1095b.m1270a(this.f1280a.getPackageName()) == null) {
                C1093c c1093c = new C1093c(this.f1280a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_local_conf_");
                String m1244a = c1093c.m1244a(this.f1280a.getPackageName() + "#localConfig", "");
                if (TextUtils.isEmpty(m1244a) || !new C1095b().m1276a(this.f1280a, m1244a)) {
                    C1089c.f1270j.execute(new RunnableC1640a(new C1095b(this.f1280a, true), c1093c));
                }
            }
            String m1355c = new C1110c(this.f1281b, this.f1280a).m1355c();
            Logger.m1187v(C1089c.f1269i, "scan serviceSet is: " + m1355c);
            String m1244a2 = C1089c.this.f1277f.m1244a("services", "");
            String m1345a = C1106h.m1345a(m1244a2, m1355c);
            if (!TextUtils.isEmpty(m1345a)) {
                C1089c.this.f1277f.m1248b("services", m1345a);
                Logger.m1185i(C1089c.f1269i, "postList is:" + StringUtils.anonymizeMessage(m1345a));
                Logger.m1180d(C1089c.f1269i, "currentServices:" + StringUtils.anonymizeMessage(m1244a2));
                if (!m1345a.equals(m1244a2)) {
                    C1089c.this.f1274c.m1344a(C1089c.this.f1272a.getGrsParasKey(true, true, this.f1280a));
                    C1089c.this.f1274c.m1343a(new C1110c(this.f1281b, this.f1280a), null, null, C1089c.this.f1277f, C1089c.this.f1272a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - C1089c.f1271k;
            if (C1089c.f1271k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.m1185i(C1089c.f1269i, "Try to clear unUsed sp data.");
                long unused = C1089c.f1271k = SystemClock.elapsedRealtime();
                C1089c c1089c3 = C1089c.this;
                c1089c3.m1213a(c1089c3.f1276e.m1245a());
            }
            C1089c.this.f1275d.m1239b(this.f1281b, this.f1280a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1089c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f1279h = null;
        this.f1273b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        m1211a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f1272a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f1273b, grsBaseInfo2));
        this.f1279h = futureTask;
        f1270j.execute(futureTask);
        Logger.m1186i(f1269i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", C1112a.m1363a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1089c(GrsBaseInfo grsBaseInfo) {
        this.f1279h = null;
        m1211a(grsBaseInfo);
    }

    /* renamed from: a */
    private void m1211a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f1272a = grsBaseInfo.m2808clone();
        } catch (CloneNotSupportedException e) {
            Logger.m1190w(f1269i, "GrsClient catch CloneNotSupportedException", e);
            this.f1272a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1213a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.m1187v(f1269i, "sp's content is empty.");
            return;
        }
        Set<String> keySet = map.keySet();
        for (String str : keySet) {
            if (str.endsWith(this.f1273b.getPackageName() + CrashHianalyticsData.TIME)) {
                String m1244a = this.f1276e.m1244a(str, "");
                long j = 0;
                if (!TextUtils.isEmpty(m1244a) && m1244a.matches("\\d+")) {
                    try {
                        j = Long.parseLong(m1244a);
                    } catch (NumberFormatException e) {
                        Logger.m1190w(f1269i, "convert expire time from String to Long catch NumberFormatException.", e);
                    }
                }
                String substring = str.substring(0, str.length() - 4);
                String str2 = substring + "ETag";
                if (!m1216b(j) || !keySet.contains(substring) || !keySet.contains(str2)) {
                    Logger.m1185i(f1269i, "init interface auto clear some invalid sp's data: " + str);
                    this.f1276e.m1246a(substring);
                    this.f1276e.m1246a(str);
                    this.f1276e.m1246a(str2);
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m1216b(long j) {
        return System.currentTimeMillis() - j <= 604800000;
    }

    /* renamed from: f */
    private boolean m1223f() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f1279h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e) {
            e = e;
            str = f1269i;
            str2 = "init compute task interrupted.";
            Logger.m1190w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.m1185i(f1269i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            e = e2;
            str = f1269i;
            str2 = "init compute task failed.";
            Logger.m1190w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.m1189w(f1269i, "init compute task timed out");
            return false;
        } catch (Exception e3) {
            e = e3;
            str = f1269i;
            str2 = "init compute task occur unknown Exception";
            Logger.m1190w(str, str2, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m1224a(String str, String str2, int i) {
        if (this.f1272a == null || str == null || str2 == null) {
            Logger.m1189w(f1269i, "invalid para!");
            return null;
        }
        if (m1223f()) {
            return this.f1278g.m1199a(str, str2, this.f1273b, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> m1225a(String str, int i) {
        if (this.f1272a != null && str != null) {
            return m1223f() ? this.f1278g.m1200a(str, this.f1273b, i) : new HashMap();
        }
        Logger.m1189w(f1269i, "invalid para!");
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1226a() {
        if (m1223f()) {
            String grsParasKey = this.f1272a.getGrsParasKey(true, true, this.f1273b);
            this.f1276e.m1246a(grsParasKey);
            this.f1276e.m1246a(grsParasKey + CrashHianalyticsData.TIME);
            this.f1276e.m1246a(grsParasKey + "ETag");
            this.f1274c.m1344a(grsParasKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1227a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i) {
        if (iQueryUrlsCallBack == null) {
            Logger.m1189w(f1269i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f1272a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (m1223f()) {
            this.f1278g.m1201a(str, iQueryUrlsCallBack, this.f1273b, i);
        } else {
            Logger.m1185i(f1269i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1228a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i) {
        if (iQueryUrlCallBack == null) {
            Logger.m1189w(f1269i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f1272a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (m1223f()) {
            this.f1278g.m1202a(str, str2, iQueryUrlCallBack, this.f1273b, i);
        } else {
            Logger.m1185i(f1269i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m1229a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1089c.class == obj.getClass() && (obj instanceof C1089c)) {
            return this.f1272a.compare(((C1089c) obj).f1272a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m1230b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!m1223f() || (grsBaseInfo = this.f1272a) == null || (context = this.f1273b) == null) {
            return false;
        }
        this.f1275d.m1236a(grsBaseInfo, context);
        return true;
    }
}
