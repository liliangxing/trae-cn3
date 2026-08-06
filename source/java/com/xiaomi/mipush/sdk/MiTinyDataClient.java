package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.C1768az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static void init(Context context, String str) {
        if (context == null) {
            AbstractC1417b.m1089a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        C1436a.m1179a().m1184a(context);
        if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            C1436a.m1179a().m1185a(str);
        }
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d(str);
        c1637gi.m2742c(str2);
        c1637gi.m2726a(j);
        c1637gi.m2738b(str3);
        return C1436a.m1179a().m1187a(c1637gi);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d(str);
        c1637gi.m2742c(str2);
        c1637gi.m2726a(j);
        c1637gi.m2738b(str3);
        c1637gi.m2729a(true);
        c1637gi.m2727a("push_sdk_channel");
        return upload(context, c1637gi);
    }

    public static boolean upload(Context context, C1637gi c1637gi) {
        AbstractC1417b.m1101c("MiTinyDataClient.upload " + c1637gi.m2747d());
        if (!C1436a.m1179a().m1186a()) {
            C1436a.m1179a().m1184a(context);
        }
        return C1436a.m1179a().m1187a(c1637gi);
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class C1436a {

        /* renamed from: a */
        private static volatile C1436a f794a;

        /* renamed from: a */
        private Context f795a;

        /* renamed from: a */
        private Boolean f797a;

        /* renamed from: a */
        private String f798a;

        /* renamed from: a */
        private a f796a = new a();

        /* renamed from: a */
        private final ArrayList<C1637gi> f799a = new ArrayList<>();

        /* renamed from: a */
        public static C1436a m1179a() {
            if (f794a == null) {
                synchronized (C1436a.class) {
                    if (f794a == null) {
                        f794a = new C1436a();
                    }
                }
            }
            return f794a;
        }

        /* renamed from: a */
        public void m1184a(Context context) {
            if (context == null) {
                AbstractC1417b.m1089a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f795a = context;
            this.f797a = Boolean.valueOf(m1181a(context));
            m1188b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        /* renamed from: a */
        public synchronized void m1185a(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC1417b.m1089a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f798a = str;
                m1188b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: b */
        public void m1188b(String str) {
            AbstractC1417b.m1101c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f799a) {
                arrayList.addAll(this.f799a);
                this.f799a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m1187a((C1637gi) it.next());
            }
        }

        /* renamed from: a */
        private boolean m1181a(Context context) {
            if (!C1462u.m1373a(context).m1417a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        public boolean m1186a() {
            return this.f795a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ad, code lost:
        
            com.xiaomi.channel.commonutils.logger.AbstractC1417b.m1101c("MiTinyDataClient Pending " + r13.m2739b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel");
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m1187a(C1637gi c1637gi) {
            if (c1637gi == null) {
                return false;
            }
            if (C1768az.m3794a(c1637gi, true)) {
                return false;
            }
            boolean z = TextUtils.isEmpty(c1637gi.m2730a()) && TextUtils.isEmpty(this.f798a);
            boolean z2 = !m1186a();
            Context context = this.f795a;
            boolean z3 = context == null || m1182b(context);
            if (!z2 && !z && !z3) {
                AbstractC1417b.m1101c("MiTinyDataClient Send item immediately." + c1637gi.m2747d());
                if (TextUtils.isEmpty(c1637gi.m2747d())) {
                    c1637gi.m2752f(C1752aj.m3692a());
                }
                if (TextUtils.isEmpty(c1637gi.m2730a())) {
                    c1637gi.m2727a(this.f798a);
                }
                if (TextUtils.isEmpty(c1637gi.m2743c())) {
                    c1637gi.m2749e(this.f795a.getPackageName());
                }
                if (c1637gi.m2725a() <= 0) {
                    c1637gi.m2737b(System.currentTimeMillis());
                }
                return m1183b(c1637gi);
            }
            if (z2) {
                AbstractC1417b.m1101c("MiTinyDataClient Pending " + c1637gi.m2739b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.init");
            } else if (z3) {
                AbstractC1417b.m1101c("MiTinyDataClient Pending " + c1637gi.m2739b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId");
            }
            m1180a(c1637gi);
            return true;
        }

        /* renamed from: b */
        private boolean m1182b(Context context) {
            return C1443b.m1222a(context).m1226a() == null && !m1181a(this.f795a);
        }

        /* renamed from: a */
        private void m1180a(C1637gi c1637gi) {
            synchronized (this.f799a) {
                if (!this.f799a.contains(c1637gi)) {
                    this.f799a.add(c1637gi);
                    if (this.f799a.size() > 100) {
                        this.f799a.remove(0);
                    }
                }
            }
        }

        /* renamed from: b */
        private boolean m1183b(C1637gi c1637gi) {
            if (C1768az.m3794a(c1637gi, false)) {
                return false;
            }
            if (this.f797a.booleanValue()) {
                AbstractC1417b.m1101c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + c1637gi.m2747d());
                C1462u.m1373a(this.f795a).m1402a(c1637gi);
                return true;
            }
            this.f796a.m1195a(c1637gi);
            return true;
        }

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class a {

            /* renamed from: a */
            private ScheduledFuture<?> f803a;

            /* renamed from: a */
            private ScheduledThreadPoolExecutor f804a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a */
            public final ArrayList<C1637gi> f802a = new ArrayList<>();

            /* renamed from: a */
            private final Runnable f801a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f802a.size() != 0) {
                        a.this.m1193b();
                    } else if (a.this.f803a != null) {
                        a.this.f803a.cancel(false);
                        a.this.f803a = null;
                    }
                }
            };

            public a() {
            }

            /* renamed from: a */
            public void m1195a(final C1637gi c1637gi) {
                this.f804a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f802a.add(c1637gi);
                        a.this.m1191a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m1191a() {
                if (this.f803a == null) {
                    this.f803a = this.f804a.scheduleAtFixedRate(this.f801a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public void m1193b() {
                C1637gi remove = this.f802a.remove(0);
                for (C1659hd c1659hd : C1768az.m3792a(Arrays.asList(remove), C1436a.this.f795a.getPackageName(), C1443b.m1222a(C1436a.this.f795a).m1226a(), 30720)) {
                    AbstractC1417b.m1101c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.m2747d());
                    C1462u.m1373a(C1436a.this.f795a).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, true, (C1646gr) null);
                }
            }
        }
    }
}
