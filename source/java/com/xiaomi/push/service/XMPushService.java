package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.channel.commonutils.logger.C1416a;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.AbstractC1600ez;
import com.xiaomi.push.AbstractC1615fn;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1472af;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1487au;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1492az;
import com.xiaomi.push.C1504bk;
import com.xiaomi.push.C1526cf;
import com.xiaomi.push.C1533cm;
import com.xiaomi.push.C1539cs;
import com.xiaomi.push.C1543cw;
import com.xiaomi.push.C1548da;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.C1565dr;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1572dy;
import com.xiaomi.push.C1588en;
import com.xiaomi.push.C1589eo;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1598ex;
import com.xiaomi.push.C1602fa;
import com.xiaomi.push.C1607ff;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.C1613fl;
import com.xiaomi.push.C1614fm;
import com.xiaomi.push.C1617fp;
import com.xiaomi.push.C1626fy;
import com.xiaomi.push.C1627fz;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1631gc;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1660he;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1675ht;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1696l;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1802w;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1697m;
import com.xiaomi.push.InterfaceC1604fc;
import com.xiaomi.push.InterfaceC1606fe;
import com.xiaomi.push.InterfaceC1611fj;
import com.xiaomi.push.RunnableC1500bg;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1762at;
import com.xiaomi.push.service.C1785n;
import com.xiaomi.push.service.C1788q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class XMPushService extends Service implements InterfaceC1604fc {

    /* renamed from: b */
    private static boolean f2860b;

    /* renamed from: a */
    private ContentObserver f2863a;

    /* renamed from: a */
    private C1598ex f2865a;

    /* renamed from: a */
    private AbstractC1600ez f2866a;

    /* renamed from: a */
    private C1602fa f2867a;

    /* renamed from: a */
    private C1722a f2869a;

    /* renamed from: a */
    private C1727f f2870a;

    /* renamed from: a */
    private C1732k f2871a;

    /* renamed from: a */
    private C1739r f2872a;

    /* renamed from: a */
    private C1741t f2873a;

    /* renamed from: a */
    private C1761as f2875a;

    /* renamed from: a */
    private C1779h f2876a;

    /* renamed from: a */
    private Object f2879a;

    /* renamed from: a */
    private boolean f2882a = false;

    /* renamed from: a */
    private int f2861a = 0;

    /* renamed from: b */
    private int f2883b = 0;

    /* renamed from: a */
    private long f2862a = 0;

    /* renamed from: a */
    protected Class f2878a = XMJobService.class;

    /* renamed from: c */
    private int f2884c = -1;

    /* renamed from: a */
    private C1753ak f2874a = null;

    /* renamed from: a */
    private C1785n f2877a = null;

    /* renamed from: a */
    Messenger f2864a = null;

    /* renamed from: a */
    private Collection<InterfaceC1743aa> f2881a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a */
    private ArrayList<InterfaceC1735n> f2880a = new ArrayList<>();

    /* renamed from: a */
    private InterfaceC1606fe f2868a = new InterfaceC1606fe() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.InterfaceC1606fe
        /* renamed from: a */
        public void mo1863a(AbstractC1615fn abstractC1615fn) {
            XMPushService.this.m3548a(new C1734m(abstractC1615fn));
        }

        @Override // com.xiaomi.push.InterfaceC1606fe
        /* renamed from: a */
        public void mo1862a(C1591eq c1591eq) {
            if (AbstractC1776e.m3828a(c1591eq)) {
                C1762at.m3753a().m3757a(c1591eq.m2455e(), SystemClock.elapsedRealtime(), XMPushService.this.m3541a());
            }
            XMPushService.this.m3548a(new C1725d(c1591eq));
        }
    };

    /* renamed from: com.xiaomi.push.service.XMPushService$n */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface InterfaceC1735n {
        /* renamed from: a */
        void mo2675a();
    }

    /* renamed from: h */
    private void m3535h() {
    }

    /* renamed from: a */
    public int m3541a() {
        if (this.f2884c < 0) {
            this.f2884c = C1628g.m2677a((Context) this, "com.xiaomi.xmsf");
        }
        return this.f2884c;
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        AbstractC1417b.m1086a(getApplicationContext());
        C1702q.m3465a((Context) this);
        C1787p m3955a = C1788q.m3955a((Context) this);
        if (m3955a != null) {
            C1802w.m4114a(m3955a.f3195a);
        }
        if (C1694j.m3427a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f2869a = new C1722a();
            C1696l.m3449a(this, this.f2869a, new IntentFilter(AbstractC1756an.f3057q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f2860b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        AbstractC1417b.m1089a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f2864a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i = message.what;
                        if (i != 17) {
                            if (i == 18) {
                                Message obtain = Message.obtain((Handler) null, 0);
                                obtain.what = 18;
                                Bundle bundle = new Bundle();
                                bundle.putString("xmsf_region", C1769b.m3796a(XMPushService.this.getApplicationContext()).m3799a());
                                obtain.setData(bundle);
                                message.replyTo.send(obtain);
                            }
                        } else if (message.obj != null) {
                            XMPushService.this.onStart((Intent) message.obj, 1);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        C1757ao.m3734a(this);
        C1602fa c1602fa = new C1602fa(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.C1602fa
            /* renamed from: a */
            public byte[] mo2536a() {
                try {
                    C1562do.b bVar = new C1562do.b();
                    bVar.m2120a(C1766ax.m3768a().m3776a());
                    return bVar.mo2060a();
                } catch (Exception e) {
                    AbstractC1417b.m1089a("getOBBString err: " + e.toString());
                    return null;
                }
            }
        };
        this.f2867a = c1602fa;
        c1602fa.m2534a(true);
        this.f2865a = new C1598ex(this, this.f2867a);
        this.f2876a = m3543a();
        C1572dy.m2325a(this);
        this.f2865a.m2508a(this);
        this.f2874a = new C1753ak(this);
        this.f2875a = new C1761as(this);
        new C1780i().m3860a();
        C1588en.m2403a().m2409a(this);
        this.f2877a = new C1785n("Connection Controller Thread");
        C1755am m3702a = C1755am.m3702a();
        m3702a.m3716b();
        m3702a.m3712a(new C1755am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.C1755am.a
            /* renamed from: a */
            public void mo3565a() {
                XMPushService.this.m3529e();
                if (C1755am.m3702a().m3704a() <= 0) {
                    XMPushService.this.m3548a(new C1728g(12, null));
                }
            }
        });
        if (m3540k()) {
            m3535h();
        }
        C1631gc.m2707a(this).m2710a(new C1786o(this), "UPLOADER_PUSH_CHANNEL");
        m3550a(new C1627fz(this));
        m3550a(new C1773bd(this));
        if (C1694j.m3427a((Context) this)) {
            m3550a(new C1754al());
            if (C1682i.m3384a()) {
                m3550a(new InterfaceC1735n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.InterfaceC1735n
                    /* renamed from: a */
                    public void mo2675a() {
                        RunnableC1500bg.m1651a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        m3548a(new C1729h());
        this.f2881a.add(C1767ay.m3783a(this));
        if (m3536h()) {
            this.f2870a = new C1727f();
            C1696l.m3448a(this, this.f2870a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f2879a = C1486at.m1534a((Context) this);
        }
        if (C1694j.m3427a(getApplicationContext())) {
            this.f2873a = new C1741t();
            C1696l.m3449a(this, this.f2873a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            C1732k c1732k = new C1732k();
            this.f2871a = c1732k;
            C1696l.m3449a(this, c1732k, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f2863a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean m3534g = XMPushService.this.m3534g();
                        AbstractC1417b.m1089a("SuperPowerMode:" + m3534g);
                        XMPushService.this.m3529e();
                        if (m3534g) {
                            XMPushService.this.m3548a(new C1728g(24, null));
                        } else {
                            XMPushService.this.m3554a(true);
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f2863a);
                } catch (Throwable th) {
                    AbstractC1417b.m1103d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m3516a = m3516a();
            if (m3516a != null) {
                this.f2872a = new C1739r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                C1696l.m3448a(this, this.f2872a, intentFilter, (String) null, (Handler) null);
                this.f2861a = m3516a[0];
                this.f2883b = m3516a[1];
                AbstractC1417b.m1089a("falldown initialized: " + this.f2861a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f2883b);
            }
        }
        C1533cm.m1868a(this, this.f2865a);
        C1539cs.m1931a(this, this.f2865a);
        String str = "";
        if (m3955a != null) {
            try {
                if (!TextUtils.isEmpty(m3955a.f3196a) && (split = m3955a.f3196a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        C1543cw.m1989a(this);
        AbstractC1417b.m1105e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + C1628g.m2677a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    /* renamed from: a */
    private int[] m3516a() {
        String[] split;
        String m3681a = C1750ah.m3674a(getApplicationContext()).m3681a(EnumC1638gj.FallDownTimeRange.m2760a(), "");
        if (!TextUtils.isEmpty(m3681a) && (split = m3681a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                iArr[1] = intValue;
                int i = iArr[0];
                if (i >= 0 && i <= 23 && intValue >= 0 && intValue <= 23 && i != intValue) {
                    return iArr;
                }
            } catch (NumberFormatException e) {
                AbstractC1417b.m1103d("parse falldown time range failure: " + e);
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m3504a() {
        String m3424a = C1694j.m3424a("ro.miui.region");
        return TextUtils.isEmpty(m3424a) ? C1694j.m3424a("ro.product.locale.region") : m3424a;
    }

    /* renamed from: b */
    private String m3517b() {
        String str;
        C1472af.m1472a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            C1758ap m3736a = C1758ap.m3736a(this);
            String str2 = null;
            while (true) {
                if (TextUtils.isEmpty(str2) || m3736a.m3737a() == 0) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = m3504a();
                    }
                    try {
                        synchronized (obj) {
                            if (i < 30) {
                                obj.wait(1000L);
                            } else {
                                obj.wait(30000L);
                            }
                        }
                    } catch (InterruptedException unused) {
                    }
                    i++;
                } else {
                    str = m3504a();
                    break;
                }
            }
        } else {
            str = "CN";
        }
        AbstractC1417b.m1089a("wait coutrycode :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(1:3)(1:37)|4|(2:29|(3:31|(1:33)(1:35)|34)(10:36|10|(1:12)|13|(1:15)|16|17|(1:19)|21|(2:23|24)(1:26)))(1:8)|9|10|(0)|13|(0)|16|17|(0)|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e3, code lost:
    
        com.xiaomi.channel.commonutils.logger.AbstractC1417b.m1093a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc A[Catch: Exception -> 0x00e2, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e2, blocks: (B:17:0x00d6, B:19:0x00dc), top: B:16:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3522c() {
        String str;
        C1526cf.m1812a().m1839d();
        C1784m.m3872a(getApplicationContext()).m3892a();
        C1769b m3796a = C1769b.m3796a(getApplicationContext());
        String m3799a = m3796a.m3799a();
        AbstractC1417b.m1090a("XMPushService", "region of cache is " + m3799a);
        String str2 = "";
        if (TextUtils.isEmpty(m3799a)) {
            String m3517b = m3517b();
            str = m3517b;
            m3799a = C1694j.m3420a(m3517b).name();
        } else {
            str = "";
        }
        String str3 = "CN";
        if (!TextUtils.isEmpty(m3799a) && EnumC1697m.China.name().equals(m3799a)) {
            m3796a.m3800a(m3799a, true);
            m3796a.m3802b("CN", true);
        } else if (!TextUtils.isEmpty(m3799a)) {
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                str3 = "";
            } else {
                str2 = EnumC1697m.China.name();
            }
            m3796a.m3800a(str2, true);
            m3796a.m3802b(str3, true);
            m3799a = str2;
        } else {
            m3799a = EnumC1697m.China.name();
            AbstractC1417b.m1092a("XMPushService", "after check, appRegion is ", m3799a, ", countryCode=", str);
            if (EnumC1697m.China.name().equals(m3799a)) {
                C1602fa.m2531a("cn.app.chat.xiaomi.net");
            }
            m3509a(m3799a);
            if (m3536h()) {
                AbstractC1417b.m1090a("XMPushService", "-->postOnCreate(): try trigger connect now");
                final AbstractC1731j abstractC1731j = new AbstractC1731j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public String mo2389a() {
                        return "prepare the mi push account.";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public void mo2390a() {
                        C1795w.m4031a(XMPushService.this);
                        if (C1486at.m1545a((Context) XMPushService.this)) {
                            XMPushService.this.m3554a(true);
                        }
                    }
                };
                m3548a(abstractC1731j);
                C1788q.m3963a(new C1788q.a() { // from class: com.xiaomi.push.service.XMPushService.14
                    @Override // com.xiaomi.push.service.C1788q.a
                    /* renamed from: a */
                    public void mo3566a() {
                        XMPushService.this.m3548a(abstractC1731j);
                    }
                });
            }
            if (C1702q.m3466a()) {
                this.f2876a.m3853a(this);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            C1628g.m2685a((Context) this, getApplicationInfo(), true);
            return;
        }
        str = str3;
        AbstractC1417b.m1092a("XMPushService", "after check, appRegion is ", m3799a, ", countryCode=", str);
        if (EnumC1697m.China.name().equals(m3799a)) {
        }
        m3509a(m3799a);
        if (m3536h()) {
        }
        if (C1702q.m3466a()) {
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
        }
    }

    /* renamed from: a */
    private static void m3509a(String str) {
        if (EnumC1697m.China.name().equals(str)) {
            C1526cf.m1818a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            C1526cf.m1818a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            C1526cf.m1818a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            C1526cf.m1818a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            C1526cf.m1818a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            C1526cf.m1818a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            C1526cf.m1818a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* renamed from: a */
    private void m3506a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        C1784m.m3872a(getApplicationContext()).m3895a(string);
        C1533cm.m1869a(this, string);
    }

    /* renamed from: d */
    private void m3527d() {
        C1487au m1530a = C1486at.m1530a();
        C1784m.m3872a(getApplicationContext()).m3894a(m1530a);
        if (m1530a != null) {
            StringBuilder sb = new StringBuilder("[type: ");
            sb.append(m1530a.m1560a()).append("[").append(m1530a.m1563b()).append("], state: ").append(m1530a.m1559a()).append("/").append(m1530a.m1558a());
            AbstractC1417b.m1090a("XMPushService", "network changed," + sb.toString());
            NetworkInfo.State m1559a = m1530a.m1559a();
            if (m1559a == NetworkInfo.State.SUSPENDED || m1559a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            AbstractC1417b.m1090a("XMPushService", "network changed, no active network");
        }
        if (C1588en.m2402a() != null) {
            C1588en.m2402a().m2399a();
        }
        C1626fy.m2661a((Context) this);
        this.f2865a.m2524d();
        if (C1486at.m1545a((Context) this)) {
            if (m3563c() && m3532f()) {
                m3520b(false);
            }
            if (!m3563c() && !m3564d()) {
                this.f2877a.m3916a(1);
                m3548a(new C1726e());
            }
            C1548da.m2007a(this).m2015a();
        } else {
            m3548a(new C1728g(2, null));
        }
        m3529e();
    }

    /* renamed from: f */
    private boolean m3532f() {
        if (SystemClock.elapsedRealtime() - this.f2862a < 30000) {
            return false;
        }
        return C1486at.m1548c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3544a() {
        if (SystemClock.elapsedRealtime() - this.f2862a >= C1607ff.m2542a() && C1486at.m1548c(this)) {
            m3520b(true);
        }
    }

    /* renamed from: b */
    private void m3520b(boolean z) {
        this.f2862a = SystemClock.elapsedRealtime();
        if (!m3563c()) {
            m3554a(true);
        } else if (C1486at.m1545a((Context) this)) {
            m3524c(new C1736o(z));
        } else {
            m3524c(new C1728g(17, null));
            m3554a(true);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            AbstractC1417b.m1103d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(AbstractC1756an.f3062v);
                String stringExtra2 = intent.getStringExtra(AbstractC1756an.f3028F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && !"miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    AbstractC1417b.m1090a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
                AbstractC1417b.m1090a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, C1694j.m3422a(intent)));
            } catch (Throwable th) {
                AbstractC1417b.m1103d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f2877a.m3920a()) {
                    AbstractC1417b.m1103d("ERROR, the job controller is blocked.");
                    C1755am.m3702a().m3711a(this, 14);
                    stopSelf();
                } else {
                    m3548a(new C1730i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                m3548a(new C1730i(intent));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            AbstractC1417b.m1101c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    /* renamed from: b */
    private void m3518b(Intent intent) {
        long j;
        C1591eq c1591eq;
        String stringExtra = intent.getStringExtra(AbstractC1756an.f3028F);
        String stringExtra2 = intent.getStringExtra(AbstractC1756an.f3032J);
        Bundle m3495xfc42fb2d = m3495xfc42fb2d(intent, "ext_packet");
        C1755am m3702a = C1755am.m3702a();
        if (m3495xfc42fb2d != null) {
            C1614fm c1614fm = (C1614fm) m3500a(new C1614fm(m3495xfc42fb2d), stringExtra, stringExtra2);
            if (c1614fm == null) {
                return;
            } else {
                c1591eq = C1591eq.m2426a(c1614fm, m3702a.m3705a(c1614fm.m2611k(), c1614fm.m2615m()).f3006h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j = Long.parseLong(intent.getStringExtra(AbstractC1756an.f3059s));
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                String stringExtra3 = intent.getStringExtra(AbstractC1756an.f3060t);
                String stringExtra4 = intent.getStringExtra(AbstractC1756an.f3061u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                C1755am.b m3705a = m3702a.m3705a(stringExtra5, String.valueOf(j));
                if (m3705a != null) {
                    C1591eq c1591eq2 = new C1591eq();
                    try {
                        c1591eq2.m2434a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    c1591eq2.m2438a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    c1591eq2.m2436a(j, stringExtra3, stringExtra4);
                    c1591eq2.m2437a(intent.getStringExtra("ext_pkt_id"));
                    c1591eq2.m2440a(byteArrayExtra, m3705a.f3006h);
                    AbstractC1417b.m1089a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    c1591eq = c1591eq2;
                }
            }
            c1591eq = null;
        }
        if (c1591eq != null) {
            m3524c(new C1765aw(this, c1591eq));
        }
    }

    /* renamed from: c */
    private void m3523c(Intent intent) {
        String stringExtra = intent.getStringExtra(AbstractC1756an.f3028F);
        String stringExtra2 = intent.getStringExtra(AbstractC1756an.f3032J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        C1614fm[] c1614fmArr = new C1614fm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i = 0; i < parcelableArrayExtra.length; i++) {
            C1614fm c1614fm = new C1614fm((Bundle) parcelableArrayExtra[i]);
            c1614fmArr[i] = c1614fm;
            C1614fm c1614fm2 = (C1614fm) m3500a(c1614fm, stringExtra, stringExtra2);
            c1614fmArr[i] = c1614fm2;
            if (c1614fm2 == null) {
                return;
            }
        }
        C1755am m3702a = C1755am.m3702a();
        C1591eq[] c1591eqArr = new C1591eq[length];
        for (int i2 = 0; i2 < length; i2++) {
            C1614fm c1614fm3 = c1614fmArr[i2];
            c1591eqArr[i2] = C1591eq.m2426a(c1614fm3, m3702a.m3705a(c1614fm3.m2611k(), c1614fm3.m2615m()).f3006h);
        }
        m3524c(new C1774c(this, c1591eqArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3528d(Intent intent) {
        int i;
        String m1597b;
        SharedPreferences sharedPreferences;
        C1755am m3702a = C1755am.m3702a();
        boolean z = true;
        int i2 = 0;
        if (AbstractC1756an.f3044d.equalsIgnoreCase(intent.getAction()) || AbstractC1756an.f3050j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(AbstractC1756an.f3062v);
            if (TextUtils.isEmpty(intent.getStringExtra(AbstractC1756an.f3024B))) {
                AbstractC1417b.m1089a("security is empty. ignore.");
                return;
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                boolean m3515a = m3515a(stringExtra, intent);
                C1755am.b m3502a = m3502a(stringExtra, intent);
                if (!C1486at.m1547b(this)) {
                    this.f2876a.m3856a(this, m3502a, false, 2, null);
                    return;
                }
                if (m3563c()) {
                    if (m3502a.f2993a == C1755am.c.unbind) {
                        m3524c(new C1723b(m3502a));
                        return;
                    }
                    if (m3515a) {
                        m3524c(new C1737p(m3502a));
                        return;
                    } else if (m3502a.f2993a == C1755am.c.binding) {
                        AbstractC1417b.m1089a(String.format("the client is binding. %1$s %2$s.", m3502a.f3005g, C1755am.b.m3719a(m3502a.f2999b)));
                        return;
                    } else {
                        if (m3502a.f2993a == C1755am.c.binded) {
                            this.f2876a.m3856a(this, m3502a, true, 0, null);
                            return;
                        }
                        return;
                    }
                }
                m3554a(true);
                return;
            }
            AbstractC1417b.m1103d("channel id is empty, do nothing!");
            return;
        }
        if (AbstractC1756an.f3049i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(AbstractC1756an.f3028F);
            String stringExtra3 = intent.getStringExtra(AbstractC1756an.f3062v);
            String stringExtra4 = intent.getStringExtra(AbstractC1756an.f3059s);
            AbstractC1417b.m1089a("Service called close channel chid = " + stringExtra3 + " res = " + C1755am.b.m3719a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                Iterator<String> it = m3702a.m3708a(stringExtra2).iterator();
                while (it.hasNext()) {
                    m3510a(it.next(), 2);
                }
                return;
            } else if (TextUtils.isEmpty(stringExtra4)) {
                m3510a(stringExtra3, 2);
                return;
            } else {
                m3552a(stringExtra3, stringExtra4, 2, null, null);
                return;
            }
        }
        if (AbstractC1756an.f3045e.equalsIgnoreCase(intent.getAction())) {
            m3518b(intent);
            return;
        }
        if (AbstractC1756an.f3047g.equalsIgnoreCase(intent.getAction())) {
            m3523c(intent);
            return;
        }
        if (AbstractC1756an.f3046f.equalsIgnoreCase(intent.getAction())) {
            AbstractC1615fn m3500a = m3500a(new C1613fl(m3495xfc42fb2d(intent, "ext_packet")), intent.getStringExtra(AbstractC1756an.f3028F), intent.getStringExtra(AbstractC1756an.f3032J));
            if (m3500a != null) {
                m3524c(new C1765aw(this, C1591eq.m2426a(m3500a, m3702a.m3705a(m3500a.m2611k(), m3500a.m2615m()).f3006h)));
                return;
            }
            return;
        }
        if (AbstractC1756an.f3048h.equalsIgnoreCase(intent.getAction())) {
            AbstractC1615fn m3500a2 = m3500a(new C1617fp(m3495xfc42fb2d(intent, "ext_packet")), intent.getStringExtra(AbstractC1756an.f3028F), intent.getStringExtra(AbstractC1756an.f3032J));
            if (m3500a2 != null) {
                m3524c(new C1765aw(this, C1591eq.m2426a(m3500a2, m3702a.m3705a(m3500a2.m2611k(), m3500a2.m2615m()).f3006h)));
                return;
            }
            return;
        }
        if (AbstractC1756an.f3051k.equals(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(AbstractC1756an.f3062v);
            String stringExtra6 = intent.getStringExtra(AbstractC1756an.f3059s);
            if (stringExtra5 != null) {
                AbstractC1417b.m1089a("request reset connection from chid = " + stringExtra5);
                C1755am.b m3705a = C1755am.m3702a().m3705a(stringExtra5, stringExtra6);
                if (m3705a != null && m3705a.f3006h.equals(intent.getStringExtra(AbstractC1756an.f3024B)) && m3705a.f2993a == C1755am.c.binded) {
                    AbstractC1600ez m3542a = m3542a();
                    if (m3542a == null || !m3542a.m2512a(SystemClock.elapsedRealtime() - NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT)) {
                        m3524c(new C1738q());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        String str = null;
        r9 = null;
        C1755am.b m3705a2 = null;
        str = null;
        if (AbstractC1756an.f3052l.equals(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(AbstractC1756an.f3028F);
            List<String> m3708a = m3702a.m3708a(stringExtra7);
            if (m3708a.isEmpty()) {
                AbstractC1417b.m1089a("open channel should be called first before update info, pkg=" + stringExtra7);
                return;
            }
            String stringExtra8 = intent.getStringExtra(AbstractC1756an.f3062v);
            String stringExtra9 = intent.getStringExtra(AbstractC1756an.f3059s);
            if (TextUtils.isEmpty(stringExtra8)) {
                stringExtra8 = m3708a.get(0);
            }
            if (TextUtils.isEmpty(stringExtra9)) {
                Collection<C1755am.b> m3707a = m3702a.m3707a(stringExtra8);
                if (m3707a != null && !m3707a.isEmpty()) {
                    m3705a2 = m3707a.iterator().next();
                }
            } else {
                m3705a2 = m3702a.m3705a(stringExtra8, stringExtra9);
            }
            if (m3705a2 != null) {
                if (intent.hasExtra(AbstractC1756an.f3026D)) {
                    m3705a2.f3003e = intent.getStringExtra(AbstractC1756an.f3026D);
                }
                if (intent.hasExtra(AbstractC1756an.f3027E)) {
                    m3705a2.f3004f = intent.getStringExtra(AbstractC1756an.f3027E);
                    return;
                }
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if (m3538i()) {
                    return;
                }
                AbstractC1417b.m1089a("exit falldown mode, activate alarm.");
                m3529e();
                if (m3563c() || m3564d()) {
                    return;
                }
                m3554a(true);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m3538i() && C1572dy.m2328a()) {
                AbstractC1417b.m1089a("enter falldown mode, stop alarm.");
                C1572dy.m2324a();
                return;
            }
            return;
        }
        if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (C1758ap.m3736a(getApplicationContext()).m3739a() && C1758ap.m3736a(getApplicationContext()).m3737a() == 0) {
                AbstractC1417b.m1089a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            final byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            final String stringExtra10 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            final int intExtra = intent.getIntExtra("mipush_env_type", 1);
            C1789r.m3965a(this).m3972d(stringExtra10);
            if (booleanExtra && !"com.xiaomi.xmsf".equals(getPackageName())) {
                m3524c(new AbstractC1731j(14) { // from class: com.xiaomi.push.service.XMPushService.2
                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public String mo2389a() {
                        return "clear account cache.";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public void mo2390a() {
                        C1788q.m3960a((Context) XMPushService.this);
                        C1755am.m3702a().m3714a("5");
                        C1802w.m4114a(intExtra);
                        XMPushService.this.f2867a.m2540c(C1602fa.m2530a());
                        AbstractC1417b.m1089a("clear account and start registration. " + stringExtra10);
                        XMPushService.this.m3555a(byteArrayExtra, stringExtra10);
                    }
                });
                return;
            } else {
                m3555a(byteArrayExtra, stringExtra10);
                return;
            }
        }
        if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if (C1782k.m3865a(byteArrayExtra2, stringExtra11)) {
                AbstractC1417b.m1089a("duplicate msg from: " + String.valueOf(stringExtra11));
                return;
            }
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                C1789r.m3965a(this).m3966a(stringExtra11);
                if (C1694j.m3427a(getApplicationContext())) {
                    C1794v.m4014a(stringExtra11);
                }
            }
            m3553a(stringExtra11, byteArrayExtra2, booleanExtra2);
            return;
        }
        if (AbstractC1759aq.f3072a.equals(intent.getAction())) {
            String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra12 == null || TextUtils.isEmpty(stringExtra12.trim())) {
                return;
            }
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra12, 0);
                if (packageInfo == null || packageInfo.applicationInfo == null || !C1682i.m3386a((Context) this, packageInfo.packageName)) {
                    z = false;
                } else {
                    AbstractC1417b.m1089a("dual space's app uninstalled " + stringExtra12);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if ("com.xiaomi.channel".equals(stringExtra12) && !C1755am.m3702a().m3707a(PushClient.DEFAULT_REQUEST_ID).isEmpty() && z) {
                m3510a(PushClient.DEFAULT_REQUEST_ID, 0);
                AbstractC1417b.m1089a("close the miliao channel as the app is uninstalled.");
                return;
            }
            SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
            String string = sharedPreferences2.getString(stringExtra12, null);
            if (TextUtils.isEmpty(string) || !z) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            edit.remove(stringExtra12);
            edit.commit();
            if (C1796x.m4084b((Context) this, stringExtra12)) {
                C1796x.m4088c(this, stringExtra12);
            }
            C1796x.m4061a((Context) this, stringExtra12);
            C1745ac.m3584a(getApplicationContext(), stringExtra12);
            if (!m3563c() || string == null) {
                return;
            }
            try {
                C1795w.m4032a(this, C1795w.m4026a(stringExtra12, string));
                AbstractC1417b.m1089a("uninstall " + stringExtra12 + " msg sent");
                return;
            } catch (C1609fh e) {
                AbstractC1417b.m1103d("Fail to send Message: " + e.getMessage());
                m3546a(10, e);
                return;
            }
        }
        if (AbstractC1759aq.f3073b.equals(intent.getAction())) {
            String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
            if (TextUtils.isEmpty(stringExtra13)) {
                return;
            }
            try {
                sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                if (sharedPreferences != null) {
                    try {
                        str = sharedPreferences.getString(stringExtra13, null);
                    } catch (Throwable th) {
                        th = th;
                        AbstractC1417b.m1089a("Fail to get sp or appId : " + th);
                        if (!TextUtils.isEmpty(str)) {
                        }
                        C1745ac.m3584a((Context) this, stringExtra13);
                        if (C1694j.m3427a(getApplicationContext())) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                sharedPreferences = null;
            }
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.remove(stringExtra13);
                edit2.commit();
                if (C1796x.m4084b((Context) this, stringExtra13)) {
                    C1796x.m4088c(this, stringExtra13);
                }
                C1796x.m4061a((Context) this, stringExtra13);
                m3553a(stringExtra13, C1670ho.m3313a(C1795w.m4036b(stringExtra13, str)), true);
            }
            C1745ac.m3584a((Context) this, stringExtra13);
            if (C1694j.m3427a(getApplicationContext())) {
                return;
            }
            C1794v.m4014a(stringExtra13);
            return;
        }
        if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra14 = intent.getStringExtra(AbstractC1756an.f3028F);
            int intExtra2 = intent.getIntExtra(AbstractC1756an.f3029G, -2);
            if (TextUtils.isEmpty(stringExtra14)) {
                return;
            }
            if (intExtra2 >= -1) {
                C1796x.m4063a(this, stringExtra14, intExtra2, intent.getIntExtra(AbstractC1756an.f3030H, -1));
                return;
            } else {
                C1796x.m4065a(this, stringExtra14, intent.getStringExtra(AbstractC1756an.f3034L), intent.getStringExtra(AbstractC1756an.f3035M));
                return;
            }
        }
        if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
            String stringExtra15 = intent.getStringExtra(AbstractC1756an.f3028F);
            if (TextUtils.isEmpty(stringExtra15)) {
                return;
            }
            C1796x.m4081b((Context) this, stringExtra15);
            return;
        }
        if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra16 = intent.getStringExtra(AbstractC1756an.f3028F);
            String stringExtra17 = intent.getStringExtra(AbstractC1756an.f3033K);
            if (intent.hasExtra(AbstractC1756an.f3031I)) {
                int intExtra3 = intent.getIntExtra(AbstractC1756an.f3031I, 0);
                m1597b = C1492az.m1597b(stringExtra16 + intExtra3);
                z = false;
                i2 = intExtra3;
            } else {
                m1597b = C1492az.m1597b(stringExtra16);
            }
            if (TextUtils.isEmpty(stringExtra16) || !TextUtils.equals(stringExtra17, m1597b)) {
                AbstractC1417b.m1103d("invalid notification for " + stringExtra16);
                return;
            } else if (z) {
                C1796x.m4088c(this, stringExtra16);
                return;
            } else {
                C1796x.m4082b(this, stringExtra16, i2);
                return;
            }
        }
        if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra18 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra18)) {
                C1789r.m3965a(this).m3968b(stringExtra18);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            m3546a(19, (Exception) null);
            m3529e();
            stopSelf();
            return;
        }
        if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra19 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra20 = intent.getStringExtra("mipush_app_id");
            String stringExtra21 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                C1789r.m3965a(this).m3970c(stringExtra19);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                C1789r.m3965a(this).m3973e(stringExtra19);
                C1789r.m3965a(this).m3974f(stringExtra19);
            }
            if (byteArrayExtra3 == null) {
                C1792t.m3979a(this, stringExtra19, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            C1792t.m3983b(stringExtra19, byteArrayExtra3);
            m3548a(new C1791s(this, stringExtra19, stringExtra20, stringExtra21, byteArrayExtra3));
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                if (this.f2870a == null) {
                    this.f2870a = new C1727f();
                    C1696l.m3448a(this, this.f2870a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
                }
                if (this.f2879a == null) {
                    this.f2879a = C1486at.m1534a((Context) this);
                    return;
                }
                return;
            }
            return;
        }
        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
            String stringExtra22 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
            C1637gi c1637gi = new C1637gi();
            try {
                C1670ho.m3312a(c1637gi, byteArrayExtra4);
                C1631gc.m2707a(this).m2711a(c1637gi, stringExtra22);
                return;
            } catch (C1675ht e2) {
                AbstractC1417b.m1093a(e2);
                return;
            }
        }
        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            AbstractC1417b.m1089a("[Alarm] Service called on timer");
            if (m3538i()) {
                if (C1572dy.m2328a()) {
                    AbstractC1417b.m1089a("enter falldown mode, stop alarm");
                    C1572dy.m2324a();
                }
            } else {
                C1572dy.m2327a(false);
                if (m3532f()) {
                    m3520b(false);
                }
            }
            C1722a c1722a = this.f2869a;
            if (c1722a != null) {
                c1722a.m3567a();
                return;
            }
            return;
        }
        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            AbstractC1417b.m1089a("Service called on check alive.");
            if (m3532f()) {
                m3520b(false);
                return;
            }
            return;
        }
        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
            AbstractC1417b.m1089a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
            C1572dy.m2326a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            m3527d();
            return;
        }
        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
            m3506a(intent);
            return;
        }
        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
            if (intent.getExtras() == null || (i = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i > 604800) {
                return;
            }
            C1784m.m3872a(getApplicationContext()).m3893a(i);
            return;
        }
        if ("action_cr_config".equals(intent.getAction())) {
            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(C1504bk.m1664a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                return;
            }
            C1565dr.m2270a(getApplicationContext(), build);
            return;
        }
        if (AbstractC1756an.f3054n.equals(intent.getAction())) {
            C1783l.m3867a(getApplicationContext(), intent);
        } else if (AbstractC1756an.f3055o.equals(intent.getAction())) {
            String stringExtra23 = intent.getStringExtra("ext_downward_pkt_id");
            if (TextUtils.isEmpty(stringExtra23)) {
                return;
            }
            C1762at.m3753a().m3758b(stringExtra23, intent.getLongExtra("ext_app_receive_time", 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3553a(final String str, final byte[] bArr, boolean z) {
        Collection<C1755am.b> m3707a = C1755am.m3702a().m3707a("5");
        if (m3707a.isEmpty()) {
            if (z) {
                C1792t.m3983b(str, bArr);
            }
        } else if (m3707a.iterator().next().f2993a == C1755am.c.binded) {
            m3548a(new AbstractC1731j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                /* renamed from: a */
                public String mo2389a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                /* renamed from: a */
                public void mo2390a() {
                    try {
                        C1795w.m4035a(XMPushService.this, str, bArr);
                    } catch (C1609fh e) {
                        AbstractC1417b.m1093a(e);
                        XMPushService.this.m3546a(10, e);
                    }
                }
            });
        } else if (z) {
            C1792t.m3983b(str, bArr);
        }
    }

    /* renamed from: a */
    public void m3555a(byte[] bArr, String str) {
        if (bArr == null) {
            C1792t.m3979a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            AbstractC1417b.m1089a("register request without payload");
            return;
        }
        C1656ha c1656ha = new C1656ha();
        try {
            C1670ho.m3312a(c1656ha, bArr);
            if (c1656ha.f2437a == EnumC1633ge.Registration) {
                C1660he c1660he = new C1660he();
                try {
                    C1670ho.m3312a(c1660he, c1656ha.m3022a());
                    m3548a(new C1791s(this, c1656ha.m3025b(), c1660he.m3096b(), c1660he.m3101c(), bArr));
                    C1566ds.m2275a(getApplicationContext()).m2281a(c1656ha.m3025b(), "E100003", c1660he.m3089a(), 6002, null);
                } catch (C1675ht e) {
                    AbstractC1417b.m1103d("app register error. " + e);
                    C1792t.m3979a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C1792t.m3979a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                AbstractC1417b.m1089a("register request with invalid payload");
            }
        } catch (C1675ht e2) {
            AbstractC1417b.m1103d("app register fail. " + e2);
            C1792t.m3979a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* renamed from: a */
    private AbstractC1615fn m3500a(AbstractC1615fn abstractC1615fn, String str, String str2) {
        C1755am m3702a = C1755am.m3702a();
        List<String> m3708a = m3702a.m3708a(str);
        if (m3708a.isEmpty()) {
            AbstractC1417b.m1089a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        abstractC1615fn.m2620o(str);
        String m2611k = abstractC1615fn.m2611k();
        if (TextUtils.isEmpty(m2611k)) {
            m2611k = m3708a.get(0);
            abstractC1615fn.m2614l(m2611k);
        }
        C1755am.b m3705a = m3702a.m3705a(m2611k, abstractC1615fn.m2615m());
        if (!m3563c()) {
            AbstractC1417b.m1089a("drop a packet as the channel is not connected, chid=" + m2611k);
            return null;
        }
        if (m3705a == null || m3705a.f2993a != C1755am.c.binded) {
            AbstractC1417b.m1089a("drop a packet as the channel is not opened, chid=" + m2611k);
            return null;
        }
        if (TextUtils.equals(str2, m3705a.f3007i)) {
            return abstractC1615fn;
        }
        AbstractC1417b.m1089a("invalid session. " + str2);
        return null;
    }

    /* renamed from: a */
    private boolean m3515a(String str, Intent intent) {
        C1755am.b m3705a = C1755am.m3702a().m3705a(str, intent.getStringExtra(AbstractC1756an.f3059s));
        boolean z = false;
        if (m3705a == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AbstractC1756an.f3032J);
        String stringExtra2 = intent.getStringExtra(AbstractC1756an.f3024B);
        if (!TextUtils.isEmpty(m3705a.f3007i) && !TextUtils.equals(stringExtra, m3705a.f3007i)) {
            AbstractC1417b.m1089a("session changed. old session=" + m3705a.f3007i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(m3705a.f3006h)) {
            return z;
        }
        AbstractC1417b.m1089a("security changed. chid = " + str + " sechash = " + C1492az.m1595a(stringExtra2));
        return true;
    }

    /* renamed from: a */
    private C1755am.b m3502a(String str, Intent intent) {
        C1755am.b m3705a = C1755am.m3702a().m3705a(str, intent.getStringExtra(AbstractC1756an.f3059s));
        if (m3705a == null) {
            m3705a = new C1755am.b(this);
        }
        m3705a.f3005g = intent.getStringExtra(AbstractC1756an.f3062v);
        m3705a.f2999b = intent.getStringExtra(AbstractC1756an.f3059s);
        m3705a.f3001c = intent.getStringExtra(AbstractC1756an.f3066z);
        m3705a.f2995a = intent.getStringExtra(AbstractC1756an.f3028F);
        m3705a.f3003e = intent.getStringExtra(AbstractC1756an.f3026D);
        m3705a.f3004f = intent.getStringExtra(AbstractC1756an.f3027E);
        m3705a.f2997a = intent.getBooleanExtra(AbstractC1756an.f3025C, false);
        m3705a.f3006h = intent.getStringExtra(AbstractC1756an.f3024B);
        m3705a.f3007i = intent.getStringExtra(AbstractC1756an.f3032J);
        m3705a.f3002d = intent.getStringExtra(AbstractC1756an.f3023A);
        m3705a.f2994a = this.f2876a;
        m3705a.m3728a((Messenger) intent.getParcelableExtra(AbstractC1756an.f3036N));
        m3705a.f2987a = getApplicationContext();
        C1755am.m3702a().m3713a(m3705a);
        return m3705a;
    }

    /* renamed from: a */
    public void m3552a(String str, String str2, int i, String str3, String str4) {
        C1755am.b m3705a = C1755am.m3702a().m3705a(str, str2);
        if (m3705a != null) {
            m3548a(new C1740s(m3705a, i, str4, str3));
        }
        C1755am.m3702a().m3715a(str, str2);
    }

    /* renamed from: a */
    private void m3510a(String str, int i) {
        Collection<C1755am.b> m3707a = C1755am.m3702a().m3707a(str);
        if (m3707a != null) {
            for (C1755am.b bVar : m3707a) {
                if (bVar != null) {
                    m3548a(new C1740s(bVar, i, null, null));
                }
            }
        }
        C1755am.m3702a().m3714a(str);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return C1694j.m3427a((Context) this) ? 1 : 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2864a.getBinder();
    }

    /* renamed from: c */
    private void m3524c(AbstractC1731j abstractC1731j) {
        this.f2877a.m3918a(abstractC1731j);
    }

    /* renamed from: a */
    public void m3548a(AbstractC1731j abstractC1731j) {
        m3549a(abstractC1731j, 0L);
    }

    /* renamed from: a */
    public void m3549a(AbstractC1731j abstractC1731j, long j) {
        try {
            this.f2877a.m3919a(abstractC1731j, j);
        } catch (IllegalStateException e) {
            AbstractC1417b.m1089a("can't execute job err = " + e.getMessage());
        }
    }

    /* renamed from: a */
    private void m3505a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                m3496xdf6f3e08(this, broadcastReceiver);
            } catch (IllegalArgumentException e) {
                AbstractC1417b.m1093a(e);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        C1727f c1727f = this.f2870a;
        if (c1727f != null) {
            m3505a(c1727f);
            this.f2870a = null;
        }
        Object obj = this.f2879a;
        if (obj != null) {
            C1486at.m1544a(this, obj);
            this.f2879a = null;
        }
        C1741t c1741t = this.f2873a;
        if (c1741t != null) {
            m3505a(c1741t);
            this.f2873a = null;
        }
        C1732k c1732k = this.f2871a;
        if (c1732k != null) {
            m3505a(c1732k);
            this.f2871a = null;
        }
        C1739r c1739r = this.f2872a;
        if (c1739r != null) {
            m3505a(c1739r);
            this.f2872a = null;
        }
        C1722a c1722a = this.f2869a;
        if (c1722a != null) {
            m3505a(c1722a);
            this.f2869a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f2863a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f2863a);
            } catch (Throwable th) {
                AbstractC1417b.m1103d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f2881a.clear();
        this.f2877a.m3922b();
        m3548a(new AbstractC1731j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                if (XMPushService.this.f2866a != null) {
                    XMPushService.this.f2866a.mo2516b(15, (Exception) null);
                    XMPushService.this.f2866a = null;
                }
            }
        });
        m3548a(new C1733l());
        C1755am.m3702a().m3716b();
        C1755am.m3702a().m3711a(this, 15);
        C1755am.m3702a().m3709a();
        this.f2865a.m2517b(this);
        C1766ax.m3768a().m3778a();
        C1572dy.m2324a();
        m3537i();
        C1533cm.m1873b(this, this.f2865a);
        C1539cs.m1935b(this, this.f2865a);
        super.onDestroy();
        AbstractC1417b.m1089a("Service destroyed");
    }

    /* renamed from: a */
    public void m3547a(C1591eq c1591eq) {
        AbstractC1600ez abstractC1600ez = this.f2866a;
        if (abstractC1600ez != null) {
            abstractC1600ez.mo2494b(c1591eq);
            return;
        }
        throw new C1609fh("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m3556a(C1591eq[] c1591eqArr) {
        AbstractC1600ez abstractC1600ez = this.f2866a;
        if (abstractC1600ez != null) {
            abstractC1600ez.mo2491a(c1591eqArr);
            return;
        }
        throw new C1609fh("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m3554a(boolean z) {
        this.f2875a.m3752a(z);
    }

    /* renamed from: a */
    public void m3551a(C1755am.b bVar) {
        if (bVar != null) {
            long m3725a = bVar.m3725a();
            AbstractC1417b.m1089a("schedule rebind job in " + (m3725a / 1000));
            m3549a(new C1723b(bVar), m3725a);
        }
    }

    /* renamed from: a */
    public void m3546a(int i, Exception exc) {
        StringBuilder append = new StringBuilder("disconnect ").append(hashCode()).append(", ");
        AbstractC1600ez abstractC1600ez = this.f2866a;
        AbstractC1417b.m1089a(append.append(abstractC1600ez == null ? null : Integer.valueOf(abstractC1600ez.hashCode())).toString());
        AbstractC1600ez abstractC1600ez2 = this.f2866a;
        if (abstractC1600ez2 != null) {
            abstractC1600ez2.mo2516b(i, exc);
            this.f2866a = null;
        }
        m3545a(7);
        m3545a(4);
        C1755am.m3702a().m3711a(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m3534g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    /* renamed from: a */
    public boolean m3557a() {
        boolean m1545a = C1486at.m1545a((Context) this);
        boolean z = C1755am.m3702a().m3704a() > 0;
        boolean z2 = !m3562b();
        boolean m3536h = m3536h();
        boolean z3 = !m3534g();
        boolean z4 = m1545a && z && z2 && m3536h && z3;
        if (!z4) {
            AbstractC1417b.m1105e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(m1545a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m3536h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: h */
    private boolean m3536h() {
        boolean z;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            AbstractC1417b.m1089a("current sdk expect region is cn");
            z = EnumC1697m.China.name().equals(C1769b.m3796a(getApplicationContext()).m3799a());
        } else {
            z = !C1789r.m3965a(this).m3969b(packageName);
        }
        if (!z) {
            AbstractC1417b.m1092a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(z), ", package=", packageName, ", region=", C1769b.m3796a(getApplicationContext()).m3799a());
        }
        return z;
    }

    /* renamed from: b */
    public boolean m3562b() {
        try {
            Class<?> m3463a = C1702q.m3463a(this, "miui.os.Build");
            Field field = m3463a.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = m3463a.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = m3463a.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3529e() {
        if (m3557a()) {
            if (C1572dy.m2328a()) {
                return;
            }
            C1572dy.m2327a(true);
            return;
        }
        C1572dy.m2324a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3531f() {
        AbstractC1600ez abstractC1600ez = this.f2866a;
        if (abstractC1600ez != null && abstractC1600ez.m2521b()) {
            AbstractC1417b.m1103d("try to connect while connecting.");
            return;
        }
        AbstractC1600ez abstractC1600ez2 = this.f2866a;
        if (abstractC1600ez2 != null && abstractC1600ez2.m2523c()) {
            AbstractC1417b.m1103d("try to connect while is connected.");
            return;
        }
        this.f2867a.m2538b(C1486at.m1535a((Context) this));
        m3533g();
        if (this.f2866a == null) {
            C1755am.m3702a().m3710a(this);
            m3526c(false);
        }
    }

    /* renamed from: c */
    private void m3526c(boolean z) {
        try {
            if (C1702q.m3466a()) {
                if (z) {
                    if (C1694j.m3427a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (InterfaceC1743aa interfaceC1743aa : (InterfaceC1743aa[]) this.f2881a.toArray(new InterfaceC1743aa[0])) {
                        interfaceC1743aa.mo3573a();
                    }
                    return;
                }
                if (C1694j.m3427a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
    }

    /* renamed from: g */
    private void m3533g() {
        try {
            this.f2865a.m2510a(this.f2868a, new InterfaceC1611fj() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.InterfaceC1611fj
                /* renamed from: a */
                public boolean mo1864a(AbstractC1615fn abstractC1615fn) {
                    return true;
                }
            });
            this.f2865a.m2557e();
            this.f2866a = this.f2865a;
        } catch (C1609fh e) {
            AbstractC1417b.m1091a("fail to create Slim connection", e);
            this.f2865a.mo2516b(3, e);
        }
    }

    /* renamed from: a */
    public C1779h m3543a() {
        return new C1779h();
    }

    /* renamed from: b */
    public C1779h m3559b() {
        return this.f2876a;
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1729h extends AbstractC1731j {
        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "Init Job";
        }

        C1729h() {
            super(TypedValue.DENSITY_NONE);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.m3522c();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1733l extends AbstractC1731j {
        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "ask the job queue to quit";
        }

        public C1733l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.f2877a.m3915a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class AbstractC1731j extends C1785n.b {
        /* renamed from: a */
        public abstract String mo2389a();

        /* renamed from: a */
        public abstract void mo2390a();

        public AbstractC1731j(int i) {
            super(i);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3173a != 4 && this.f3173a != 8) {
                AbstractC1417b.m1090a(C1416a.f740a, mo2389a());
            }
            mo2390a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$m */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1734m extends AbstractC1731j {

        /* renamed from: a */
        private AbstractC1615fn f2922a;

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "receive a message.";
        }

        public C1734m(AbstractC1615fn abstractC1615fn) {
            super(8);
            this.f2922a = abstractC1615fn;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.f2874a.m3699a(this.f2922a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1730i extends AbstractC1731j {

        /* renamed from: a */
        private Intent f2918a;

        public C1730i(Intent intent) {
            super(15);
            this.f2918a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.m3528d(this.f2918a);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "Handle intent action = " + this.f2918a.getAction();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1725d extends AbstractC1731j {

        /* renamed from: a */
        private C1591eq f2910a;

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "receive a message.";
        }

        public C1725d(C1591eq c1591eq) {
            super(8);
            this.f2910a = c1591eq;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.f2874a.m3698a(this.f2910a);
            if (AbstractC1776e.m3828a(this.f2910a)) {
                XMPushService.this.m3549a(new C1762at.a(), NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1723b extends AbstractC1731j {

        /* renamed from: a */
        C1755am.b f2908a;

        public C1723b(C1755am.b bVar) {
            super(9);
            this.f2908a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            try {
                if (!XMPushService.this.m3563c()) {
                    AbstractC1417b.m1103d("trying bind while the connection is not created, quit!");
                } else {
                    C1755am.b m3705a = C1755am.m3702a().m3705a(this.f2908a.f3005g, this.f2908a.f2999b);
                    if (m3705a == null) {
                        AbstractC1417b.m1089a("ignore bind because the channel " + this.f2908a.f3005g + " is removed ");
                    } else if (m3705a.f2993a == C1755am.c.unbind) {
                        m3705a.m3730a(C1755am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f2866a.mo2488a(m3705a);
                        C1589eo.m2418a(XMPushService.this, m3705a);
                    } else {
                        AbstractC1417b.m1089a("trying duplicate bind, ingore! " + m3705a.f2993a);
                    }
                }
            } catch (Exception e) {
                AbstractC1417b.m1103d("Meet error when trying to bind. " + e);
                XMPushService.this.m3546a(10, e);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "bind the client. " + this.f2908a.f3005g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class C1724c extends AbstractC1731j {

        /* renamed from: a */
        private final C1755am.b f2909a;

        public C1724c(C1755am.b bVar) {
            super(12);
            this.f2909a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            this.f2909a.m3730a(C1755am.c.unbind, 1, 21, (String) null, (String) null);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "bind time out. chid=" + this.f2909a.f3005g;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1724c) {
                return TextUtils.equals(((C1724c) obj).f2909a.f3005g, this.f2909a.f3005g);
            }
            return false;
        }

        public int hashCode() {
            return this.f2909a.f3005g.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$p */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1737p extends AbstractC1731j {

        /* renamed from: a */
        C1755am.b f2927a;

        public C1737p(C1755am.b bVar) {
            super(4);
            this.f2927a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            try {
                this.f2927a.m3730a(C1755am.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f2866a.mo2489a(this.f2927a.f3005g, this.f2927a.f2999b);
                XMPushService.this.m3549a(new C1723b(this.f2927a), 300L);
            } catch (C1609fh e) {
                AbstractC1417b.m1093a(e);
                XMPushService.this.m3546a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "rebind the client. " + this.f2927a.f3005g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$s */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1740s extends AbstractC1731j {

        /* renamed from: a */
        C1755am.b f2931a;

        /* renamed from: a */
        String f2932a;

        /* renamed from: b */
        int f2933b;

        /* renamed from: b */
        String f2934b;

        public C1740s(C1755am.b bVar, int i, String str, String str2) {
            super(9);
            this.f2931a = bVar;
            this.f2933b = i;
            this.f2932a = str;
            this.f2934b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            if (this.f2931a.f2993a != C1755am.c.unbind && XMPushService.this.f2866a != null) {
                try {
                    XMPushService.this.f2866a.mo2489a(this.f2931a.f3005g, this.f2931a.f2999b);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    XMPushService.this.m3546a(10, e);
                }
            }
            this.f2931a.m3730a(C1755am.c.unbind, this.f2933b, 0, this.f2934b, this.f2932a);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "unbind the channel. " + this.f2931a.f3005g;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1726e extends AbstractC1731j {
        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "do reconnect..";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1726e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            if (XMPushService.this.m3557a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m3511a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m3531f();
                    return;
                }
            }
            AbstractC1417b.m1089a("should not connect. quit the job.");
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1728g extends AbstractC1731j {

        /* renamed from: a */
        public Exception f2915a;

        /* renamed from: b */
        public int f2916b;

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "disconnect the connection.";
        }

        C1728g(int i, Exception exc) {
            super(2);
            this.f2916b = i;
            this.f2915a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.m3546a(this.f2916b, this.f2915a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$q */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1738q extends AbstractC1731j {
        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "reset the connection.";
        }

        C1738q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            XMPushService.this.m3546a(11, (Exception) null);
            if (XMPushService.this.m3557a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m3511a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m3531f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$o */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1736o extends AbstractC1731j {

        /* renamed from: a */
        boolean f2925a;

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public String mo2389a() {
            return "send ping..";
        }

        public C1736o(boolean z) {
            super(4);
            this.f2925a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
        /* renamed from: a */
        public void mo2390a() {
            if (XMPushService.this.m3563c()) {
                try {
                    if (!this.f2925a) {
                        C1589eo.m2413a();
                    }
                    XMPushService.this.f2866a.mo2520b(this.f2925a);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    XMPushService.this.m3546a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3511a(Context context) {
        try {
            C1472af.m1472a();
            for (int i = 100; i > 0; i--) {
                if (C1486at.m1547b(context)) {
                    AbstractC1417b.m1089a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: c */
    public boolean m3563c() {
        AbstractC1600ez abstractC1600ez = this.f2866a;
        return abstractC1600ez != null && abstractC1600ez.m2523c();
    }

    /* renamed from: d */
    public boolean m3564d() {
        AbstractC1600ez abstractC1600ez = this.f2866a;
        return abstractC1600ez != null && abstractC1600ez.m2521b();
    }

    /* renamed from: a */
    public AbstractC1600ez m3542a() {
        return this.f2866a;
    }

    /* renamed from: a */
    public void m3545a(int i) {
        this.f2877a.m3916a(i);
    }

    /* renamed from: a */
    public boolean m3558a(int i) {
        return this.f2877a.m3921a(i);
    }

    /* renamed from: b */
    public void m3561b(AbstractC1731j abstractC1731j) {
        this.f2877a.m3917a(abstractC1731j.f3173a, abstractC1731j);
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1919a(AbstractC1600ez abstractC1600ez) {
        AbstractC1417b.m1101c("begin to connect...");
        C1588en.m2402a().mo1919a(abstractC1600ez);
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1920a(AbstractC1600ez abstractC1600ez, int i, Exception exc) {
        C1588en.m2402a().mo1920a(abstractC1600ez, i, exc);
        if (m3538i()) {
            return;
        }
        m3554a(false);
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: b */
    public void mo1922b(AbstractC1600ez abstractC1600ez) {
        C1588en.m2402a().mo1922b(abstractC1600ez);
        m3526c(true);
        this.f2875a.m3751a();
        if (!C1572dy.m2328a() && !m3538i()) {
            AbstractC1417b.m1089a("reconnection successful, reactivate alarm.");
            C1572dy.m2327a(true);
        }
        Iterator<C1755am.b> it = C1755am.m3702a().m3706a().iterator();
        while (it.hasNext()) {
            m3548a(new C1723b(it.next()));
        }
        if (this.f2882a || !C1694j.m3427a(getApplicationContext())) {
            return;
        }
        C1470ad.m1444a(getApplicationContext()).m1449a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f2882a = true;
                try {
                    AbstractC1417b.m1089a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        C1488av.m1577b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1921a(AbstractC1600ez abstractC1600ez, Exception exc) {
        C1588en.m2402a().mo1921a(abstractC1600ez, exc);
        m3526c(false);
        if (m3538i()) {
            return;
        }
        m3554a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1727f extends BroadcastReceiver {
        C1727f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1486at.m1543a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$t */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1741t extends BroadcastReceiver {
        C1741t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f2882a) {
                XMPushService.this.f2882a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1732k extends BroadcastReceiver {
        C1732k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC1417b.m1089a("[HB] hold short heartbeat, " + C1694j.m3422a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$r */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class C1739r extends BroadcastReceiver {
        C1739r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: i */
    private boolean m3538i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && m3539j() && !C1682i.m3391b((Context) this) && !C1682i.m3385a(getApplicationContext());
    }

    /* renamed from: j */
    private boolean m3539j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i = this.f2861a;
        int i2 = this.f2883b;
        if (i > i2) {
            if (intValue >= i || intValue < i2) {
                return true;
            }
        } else if (i < i2 && intValue >= i && intValue < i2) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private boolean m3540k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return C1750ah.m3674a(this).m3686a(EnumC1638gj.ForegroundServiceSwitch.m2760a(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3560b() {
        C1784m.m3872a(getApplicationContext()).m3899d();
        Iterator it = new ArrayList(this.f2880a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1735n) it.next()).mo2675a();
        }
    }

    /* renamed from: a */
    public void m3550a(InterfaceC1735n interfaceC1735n) {
        synchronized (this.f2880a) {
            this.f2880a.add(interfaceC1735n);
        }
    }

    /* renamed from: i */
    private void m3537i() {
        synchronized (this.f2880a) {
            this.f2880a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C1722a extends BroadcastReceiver {

        /* renamed from: a */
        private final Object f2906a;

        private C1722a() {
            this.f2906a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            AbstractC1417b.m1101c("[Alarm] heartbeat alarm has been triggered.");
            if (AbstractC1756an.f3057q.equals(intent.getAction())) {
                if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                    AbstractC1417b.m1101c("[Alarm] Ping XMChannelService on timer");
                    try {
                        Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                        intent2.putExtra("time_stamp", System.currentTimeMillis());
                        intent2.setAction("com.xiaomi.push.timer");
                        ServiceClient.getInstance(context).startServiceSafely(intent2);
                        m3568a(3000L);
                        AbstractC1417b.m1089a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            AbstractC1417b.m1089a("[Alarm] cancel the old ping timer");
            C1572dy.m2324a();
        }

        /* renamed from: a */
        private void m3568a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC1417b.m1103d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f2906a) {
                try {
                    this.f2906a.wait(j);
                } catch (InterruptedException e) {
                    AbstractC1417b.m1089a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3567a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC1417b.m1103d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f2906a) {
                try {
                    this.f2906a.notifyAll();
                } catch (Exception e) {
                    AbstractC1417b.m1089a("[Alarm] notify lock. " + e);
                }
            }
        }
    }

    /* renamed from: e */
    public static boolean m3530e() {
        return f2860b;
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    /* renamed from: INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra */
    public static Bundle m3495xfc42fb2d(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m3496xdf6f3e08(XMPushService xMPushService, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        xMPushService.unregisterReceiver(broadcastReceiver);
    }
}
