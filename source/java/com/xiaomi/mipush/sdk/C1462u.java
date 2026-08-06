package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.account.model.internal.BDAccountPlatformEntity;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.ttm.player.UnifiedCodec.codec.CodecError;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1492az;
import com.xiaomi.push.C1538cr;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1660he;
import com.xiaomi.push.C1666hk;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1634gf;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.InterfaceC1671hp;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.C1758ap;
import com.xiaomi.push.service.C1778g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.mipush.sdk.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1462u {

    /* renamed from: a */
    private static C1462u f885a;

    /* renamed from: a */
    private static final ArrayList<a> f886a = new ArrayList<>();

    /* renamed from: b */
    private static boolean f887b;

    /* renamed from: a */
    private long f888a;

    /* renamed from: a */
    private Context f889a;

    /* renamed from: a */
    private Handler f891a;

    /* renamed from: a */
    private Messenger f892a;

    /* renamed from: a */
    private boolean f896a;

    /* renamed from: a */
    private List<Message> f895a = new ArrayList();

    /* renamed from: c */
    private boolean f898c = false;

    /* renamed from: b */
    private String f897b = null;

    /* renamed from: a */
    private Intent f890a = null;

    /* renamed from: a */
    private Integer f893a = null;

    /* renamed from: a */
    private String f894a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.u$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a<T extends InterfaceC1671hp<T, ?>> {

        /* renamed from: a */
        EnumC1633ge f904a;

        /* renamed from: a */
        T f905a;

        /* renamed from: a */
        boolean f906a;

        a() {
        }
    }

    /* renamed from: a */
    public static synchronized C1462u m1373a(Context context) {
        C1462u c1462u;
        synchronized (C1462u.class) {
            if (f885a == null) {
                f885a = new C1462u(context);
            }
            c1462u = f885a;
        }
        return c1462u;
    }

    private C1462u(Context context) {
        this.f896a = false;
        this.f891a = null;
        this.f889a = context.getApplicationContext();
        this.f896a = m1386c();
        f887b = m1389d();
        this.f891a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (C1457p.class) {
                    if (C1457p.m1333a(C1462u.this.f889a).m1338a(str)) {
                        if (C1457p.m1333a(C1462u.this.f889a).m1334a(str) >= 10) {
                            C1457p.m1333a(C1462u.this.f889a).m1340c(str);
                        } else {
                            String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                            if (EnumC1463v.DISABLE_PUSH.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.DISABLE_PUSH))) {
                                C1462u.this.m1379a(str, EnumC1463v.DISABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (EnumC1463v.ENABLE_PUSH.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.ENABLE_PUSH))) {
                                C1462u.this.m1379a(str, EnumC1463v.ENABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (EnumC1463v.UPLOAD_HUAWEI_TOKEN.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.UPLOAD_HUAWEI_TOKEN))) {
                                HashMap<String, String> m1281a = C1447f.m1281a(C1462u.this.f889a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
                                m1281a.put("third_sync_reason", string);
                                C1462u.this.m1379a(str, EnumC1463v.UPLOAD_HUAWEI_TOKEN, false, m1281a);
                            } else if (EnumC1463v.UPLOAD_FCM_TOKEN.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.UPLOAD_FCM_TOKEN))) {
                                C1462u.this.m1379a(str, EnumC1463v.UPLOAD_FCM_TOKEN, false, C1447f.m1281a(C1462u.this.f889a, EnumC1445d.ASSEMBLE_PUSH_FCM));
                            } else if (EnumC1463v.UPLOAD_COS_TOKEN.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.UPLOAD_COS_TOKEN))) {
                                HashMap<String, String> m1281a2 = C1447f.m1281a(C1462u.this.f889a, EnumC1445d.ASSEMBLE_PUSH_COS);
                                m1281a2.put("third_sync_reason", string);
                                C1462u.this.m1379a(str, EnumC1463v.UPLOAD_COS_TOKEN, false, m1281a2);
                            } else if (EnumC1463v.UPLOAD_FTOS_TOKEN.ordinal() == i && "syncing".equals(C1457p.m1333a(C1462u.this.f889a).m1335a(EnumC1463v.UPLOAD_FTOS_TOKEN))) {
                                HashMap<String, String> m1281a3 = C1447f.m1281a(C1462u.this.f889a, EnumC1445d.ASSEMBLE_PUSH_FTOS);
                                m1281a3.put("third_sync_reason", string);
                                C1462u.this.m1379a(str, EnumC1463v.UPLOAD_FTOS_TOKEN, false, m1281a3);
                            }
                            C1457p.m1333a(C1462u.this.f889a).m1339b(str);
                        }
                    }
                }
            }
        };
        if (C1694j.m3427a(context)) {
            C1778g.m3846a(new C1778g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent m1381b = m1381b();
        if (m1381b != null) {
            m1382b(m1381b);
        }
    }

    /* renamed from: c */
    private synchronized void m1384c(int i) {
        this.f889a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    /* renamed from: a */
    private synchronized int m1367a() {
        return this.f889a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: g */
    private void m1392g() {
        this.f888a = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public long m1395a() {
        return this.f888a;
    }

    /* renamed from: a */
    public final void m1403a(C1660he c1660he, boolean z) {
        C1566ds.m2275a(this.f889a.getApplicationContext()).m2281a(this.f889a.getPackageName(), "E100003", c1660he.m3089a(), CodecError.RELEASE_OUTPUT_CODEC_EXCEPTION, null);
        this.f890a = null;
        C1443b.m1222a(this.f889a).f821a = c1660he.m3089a();
        Intent m1369a = m1369a();
        byte[] m3313a = C1670ho.m3313a(C1459r.m1341a(this.f889a, c1660he, EnumC1633ge.Registration));
        if (m3313a == null) {
            AbstractC1417b.m1089a("register fail, because msgBytes is null.");
            return;
        }
        m1369a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m1369a.putExtra("mipush_app_id", C1443b.m1222a(this.f889a).m1226a());
        m1369a.putExtra("mipush_payload", m3313a);
        m1369a.putExtra("mipush_session", this.f894a);
        m1369a.putExtra("mipush_env_chanage", z);
        m1369a.putExtra("mipush_env_type", C1443b.m1222a(this.f889a).m1224a());
        if (C1486at.m1545a(this.f889a) && m1421b()) {
            m1392g();
            m1385c(m1369a);
        } else {
            this.f890a = m1369a;
        }
    }

    /* renamed from: a */
    public void m1396a() {
        m1382b(m1369a());
    }

    /* renamed from: a */
    public final void m1404a(C1666hk c1666hk) {
        byte[] m3313a = C1670ho.m3313a(C1459r.m1341a(this.f889a, c1666hk, EnumC1633ge.UnRegistration));
        if (m3313a == null) {
            AbstractC1417b.m1089a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m1369a.putExtra("mipush_app_id", C1443b.m1222a(this.f889a).m1226a());
        m1369a.putExtra("mipush_payload", m3313a);
        m1385c(m1369a);
    }

    /* renamed from: b */
    public final void m1419b() {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        m1385c(m1369a);
    }

    /* renamed from: a */
    public final void m1415a(boolean z) {
        m1416a(z, (String) null);
    }

    /* renamed from: a */
    public final void m1416a(boolean z, String str) {
        if (z) {
            C1457p.m1333a(this.f889a).m1336a(EnumC1463v.DISABLE_PUSH, "syncing");
            C1457p.m1333a(this.f889a).m1336a(EnumC1463v.ENABLE_PUSH, "");
            m1379a(str, EnumC1463v.DISABLE_PUSH, true, (HashMap<String, String>) null);
        } else {
            C1457p.m1333a(this.f889a).m1336a(EnumC1463v.ENABLE_PUSH, "syncing");
            C1457p.m1333a(this.f889a).m1336a(EnumC1463v.DISABLE_PUSH, "");
            m1379a(str, EnumC1463v.ENABLE_PUSH, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a */
    public void m1400a(Context context) {
        if (C1694j.m3426a()) {
            return;
        }
        EnumC1458q m1304a = C1449h.m1304a(context);
        if (EnumC1458q.HUAWEI.equals(m1304a)) {
            m1413a((String) null, EnumC1463v.UPLOAD_HUAWEI_TOKEN, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (EnumC1458q.OPPO.equals(m1304a)) {
            m1413a((String) null, EnumC1463v.UPLOAD_COS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_COS, "update");
        }
        if (EnumC1458q.VIVO.equals(m1304a)) {
            m1413a((String) null, EnumC1463v.UPLOAD_FTOS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    /* renamed from: a */
    public final void m1413a(String str, EnumC1463v enumC1463v, EnumC1445d enumC1445d, String str2) {
        C1457p.m1333a(this.f889a).m1336a(enumC1463v, "syncing");
        HashMap<String, String> m1281a = C1447f.m1281a(this.f889a, enumC1445d);
        m1281a.put("third_sync_reason", str2);
        m1379a(str, enumC1463v, false, m1281a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1399a(int i, String str) {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.thirdparty");
        m1369a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m1369a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        m1382b(m1369a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1379a(String str, EnumC1463v enumC1463v, boolean z, HashMap<String, String> hashMap) {
        C1659hd c1659hd;
        if (C1443b.m1222a(this.f889a).m1240b() && C1486at.m1545a(this.f889a)) {
            C1659hd c1659hd2 = new C1659hd();
            c1659hd2.m3050a(true);
            Intent m1369a = m1369a();
            if (TextUtils.isEmpty(str)) {
                str = C1752aj.m3692a();
                c1659hd2.m3047a(str);
                c1659hd = z ? new C1659hd(str, true) : null;
                synchronized (C1457p.class) {
                    C1457p.m1333a(this.f889a).m1337a(str);
                }
            } else {
                c1659hd2.m3047a(str);
                c1659hd = z ? new C1659hd(str, true) : null;
            }
            switch (AnonymousClass5.f903a[enumC1463v.ordinal()]) {
                case 1:
                    c1659hd2.m3064c(EnumC1643go.DisablePushMessage.f2208a);
                    c1659hd.m3064c(EnumC1643go.DisablePushMessage.f2208a);
                    if (hashMap != null) {
                        c1659hd2.m3049a(hashMap);
                        c1659hd.m3049a(hashMap);
                    }
                    m1369a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    c1659hd2.m3064c(EnumC1643go.EnablePushMessage.f2208a);
                    c1659hd.m3064c(EnumC1643go.EnablePushMessage.f2208a);
                    if (hashMap != null) {
                        c1659hd2.m3049a(hashMap);
                        c1659hd.m3049a(hashMap);
                    }
                    m1369a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    c1659hd2.m3064c(EnumC1643go.ThirdPartyRegUpdate.f2208a);
                    if (hashMap != null) {
                        c1659hd2.m3049a(hashMap);
                        break;
                    }
                    break;
            }
            AbstractC1417b.m1105e("type:" + enumC1463v + ", " + str);
            c1659hd2.m3060b(C1443b.m1222a(this.f889a).m1226a());
            c1659hd2.m3068d(this.f889a.getPackageName());
            m1407a((C1462u) c1659hd2, EnumC1633ge.Notification, false, (C1646gr) null);
            if (z) {
                c1659hd.m3060b(C1443b.m1222a(this.f889a).m1226a());
                c1659hd.m3068d(this.f889a.getPackageName());
                byte[] m3313a = C1670ho.m3313a(C1459r.m1342a(this.f889a, c1659hd, EnumC1633ge.Notification, false, this.f889a.getPackageName(), C1443b.m1222a(this.f889a).m1226a()));
                if (m3313a != null) {
                    C1538cr.m1928a(this.f889a.getPackageName(), this.f889a, c1659hd, EnumC1633ge.Notification, m3313a.length);
                    m1369a.putExtra("mipush_payload", m3313a);
                    m1369a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m1369a.putExtra("mipush_app_id", C1443b.m1222a(this.f889a).m1226a());
                    m1369a.putExtra("mipush_app_token", C1443b.m1222a(this.f889a).m1236b());
                    m1385c(m1369a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = enumC1463v.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f891a.sendMessageDelayed(obtain, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a */
        static final /* synthetic */ int[] f903a;

        static {
            int[] iArr = new int[EnumC1463v.values().length];
            f903a = iArr;
            try {
                iArr[EnumC1463v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f903a[EnumC1463v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f903a[EnumC1463v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f903a[EnumC1463v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f903a[EnumC1463v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f903a[EnumC1463v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1405a(T t, EnumC1633ge enumC1633ge, C1646gr c1646gr) {
        m1407a((C1462u) t, enumC1633ge, !enumC1633ge.equals(EnumC1633ge.Registration), c1646gr);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1408a(T t, EnumC1633ge enumC1633ge, boolean z, C1646gr c1646gr, boolean z2) {
        m1409a(t, enumC1633ge, z, true, c1646gr, z2);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1407a(T t, EnumC1633ge enumC1633ge, boolean z, C1646gr c1646gr) {
        m1409a(t, enumC1633ge, z, true, c1646gr, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1409a(T t, EnumC1633ge enumC1633ge, boolean z, boolean z2, C1646gr c1646gr, boolean z3) {
        m1410a(t, enumC1633ge, z, z2, c1646gr, z3, this.f889a.getPackageName(), C1443b.m1222a(this.f889a).m1226a());
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1410a(T t, EnumC1633ge enumC1633ge, boolean z, boolean z2, C1646gr c1646gr, boolean z3, String str, String str2) {
        m1411a(t, enumC1633ge, z, z2, c1646gr, z3, str, str2, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1411a(T t, EnumC1633ge enumC1633ge, boolean z, boolean z2, C1646gr c1646gr, boolean z3, String str, String str2, boolean z4) {
        m1412a(t, enumC1633ge, z, z2, c1646gr, z3, str, str2, z4, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1671hp<T, ?>> void m1412a(T t, EnumC1633ge enumC1633ge, boolean z, boolean z2, C1646gr c1646gr, boolean z3, String str, String str2, boolean z4, boolean z5) {
        C1656ha m1346b;
        if (z5 && !C1443b.m1222a(this.f889a).m1242c()) {
            if (z2) {
                m1406a((C1462u) t, enumC1633ge, z);
                return;
            } else {
                AbstractC1417b.m1089a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            m1346b = C1459r.m1342a(this.f889a, t, enumC1633ge, z, str, str2);
        } else {
            m1346b = C1459r.m1346b(this.f889a, t, enumC1633ge, z, str, str2);
        }
        if (c1646gr != null) {
            m1346b.m3012a(c1646gr);
        }
        byte[] m3313a = C1670ho.m3313a(m1346b);
        if (m3313a == null) {
            AbstractC1417b.m1089a("send message fail, because msgBytes is null.");
            return;
        }
        C1538cr.m1928a(this.f889a.getPackageName(), this.f889a, t, enumC1633ge, m3313a.length);
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m1369a.putExtra("mipush_payload", m3313a);
        m1369a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        m1385c(m1369a);
    }

    /* renamed from: a */
    public final void m1402a(C1637gi c1637gi) {
        Intent m1369a = m1369a();
        byte[] m3313a = C1670ho.m3313a(c1637gi);
        if (m3313a == null) {
            AbstractC1417b.m1089a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m1369a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m1369a.putExtra("mipush_payload", m3313a);
        m1382b(m1369a);
    }

    /* renamed from: c */
    private boolean m1386c() {
        try {
            PackageInfo packageInfo = this.f889a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private Intent m1369a() {
        if (m1417a() && !"com.xiaomi.xmsf".equals(this.f889a.getPackageName())) {
            return m1387d();
        }
        return m1390e();
    }

    /* renamed from: b */
    private Intent m1381b() {
        if (!"com.xiaomi.xmsf".equals(this.f889a.getPackageName())) {
            return m1383c();
        }
        AbstractC1417b.m1101c("pushChannel xmsf create own channel");
        return m1390e();
    }

    /* renamed from: c */
    private Intent m1383c() {
        if (m1417a()) {
            AbstractC1417b.m1101c("pushChannel app start miui china channel");
            return m1387d();
        }
        AbstractC1417b.m1101c("pushChannel app start  own channel");
        return m1390e();
    }

    /* renamed from: d */
    private Intent m1387d() {
        Intent intent = new Intent();
        String packageName = this.f889a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m1376a());
        intent.putExtra("mipush_app_package", packageName);
        m1393h();
        return intent;
    }

    /* renamed from: e */
    private Intent m1390e() {
        Intent intent = new Intent();
        String packageName = this.f889a.getPackageName();
        m1394i();
        intent.setComponent(new ComponentName(this.f889a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: a */
    private String m1376a() {
        String str = this.f897b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f889a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f897b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f897b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* renamed from: h */
    private void m1393h() {
        try {
            PackageManager packageManager = this.f889a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f889a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m1394i() {
        try {
            PackageManager packageManager = this.f889a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f889a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m1417a() {
        return this.f896a && 1 == C1443b.m1222a(this.f889a).m1224a();
    }

    /* renamed from: c */
    public void m1422c() {
        if (this.f890a != null) {
            m1392g();
            m1385c(this.f890a);
            this.f890a = null;
        }
    }

    /* renamed from: a */
    public <T extends InterfaceC1671hp<T, ?>> void m1406a(T t, EnumC1633ge enumC1633ge, boolean z) {
        a aVar = new a();
        aVar.f905a = t;
        aVar.f904a = enumC1633ge;
        aVar.f906a = z;
        ArrayList<a> arrayList = f886a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    /* renamed from: d */
    public void m1423d() {
        ArrayList<a> arrayList = f886a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                m1409a(next.f905a, next.f904a, next.f906a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f886a.clear();
        }
    }

    /* renamed from: a */
    public void m1397a(int i) {
        m1398a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1398a(int i, int i2) {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m1369a.putExtra(AbstractC1756an.f3028F, this.f889a.getPackageName());
        m1369a.putExtra(AbstractC1756an.f3029G, i);
        m1369a.putExtra(AbstractC1756an.f3030H, i2);
        m1385c(m1369a);
    }

    /* renamed from: d */
    private boolean m1389d() {
        if (m1417a()) {
            try {
                return this.f889a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m1414a(String str, String str2) {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m1369a.putExtra(AbstractC1756an.f3028F, this.f889a.getPackageName());
        m1369a.putExtra(AbstractC1756an.f3034L, str);
        m1369a.putExtra(AbstractC1756an.f3035M, str2);
        m1385c(m1369a);
    }

    /* renamed from: e */
    public void m1424e() {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) C1488av.m1570a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f889a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            AbstractC1417b.m1089a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m1369a.putExtra(AbstractC1756an.f3028F, packageName);
        m1385c(m1369a);
    }

    /* renamed from: b */
    public void m1420b(int i) {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m1369a.putExtra(AbstractC1756an.f3028F, this.f889a.getPackageName());
        m1369a.putExtra(AbstractC1756an.f3031I, i);
        m1369a.putExtra(AbstractC1756an.f3033K, C1492az.m1597b(this.f889a.getPackageName() + i));
        m1385c(m1369a);
    }

    /* renamed from: f */
    public void m1425f() {
        Intent m1369a = m1369a();
        m1369a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m1369a.putExtra(AbstractC1756an.f3028F, this.f889a.getPackageName());
        m1369a.putExtra(AbstractC1756an.f3033K, C1492az.m1597b(this.f889a.getPackageName()));
        m1385c(m1369a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1401a(Intent intent) {
        intent.fillIn(m1369a(), 24);
        m1385c(intent);
    }

    /* renamed from: b */
    public boolean m1421b() {
        if (!m1417a() || !m1391e()) {
            return true;
        }
        if (this.f893a == null) {
            Integer valueOf = Integer.valueOf(C1758ap.m3736a(this.f889a).m3737a());
            this.f893a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f889a.getContentResolver().registerContentObserver(C1758ap.m3736a(this.f889a).m3738a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        C1462u c1462u = C1462u.this;
                        c1462u.f893a = Integer.valueOf(C1758ap.m3736a(c1462u.f889a).m3737a());
                        if (C1462u.this.f893a.intValue() != 0) {
                            C1462u.this.f889a.getContentResolver().unregisterContentObserver(this);
                            if (C1486at.m1545a(C1462u.this.f889a)) {
                                C1462u.this.m1422c();
                            }
                        }
                    }
                });
            }
        }
        return this.f893a.intValue() != 0;
    }

    /* renamed from: e */
    private boolean m1391e() {
        String packageName = this.f889a.getPackageName();
        return packageName.contains(RomUtils.MIUI) || packageName.contains(BDAccountPlatformEntity.PLAT_NAME_XIAOMI) || (this.f889a.getApplicationInfo().flags & 1) != 0;
    }

    /* renamed from: b */
    private void m1382b(Intent intent) {
        try {
            if (!C1694j.m3426a() && Build.VERSION.SDK_INT >= 26) {
                m1388d(intent);
            } else {
                this.f889a.startService(intent);
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
    }

    /* renamed from: c */
    private void m1385c(Intent intent) {
        int m3678a = C1750ah.m3674a(this.f889a).m3678a(EnumC1638gj.ServiceBootMode.m2760a(), EnumC1634gf.START.m2715a());
        int m1367a = m1367a();
        boolean z = m3678a == EnumC1634gf.BIND.m2715a() && f887b;
        int m2715a = (z ? EnumC1634gf.BIND : EnumC1634gf.START).m2715a();
        if (m2715a != m1367a) {
            m1418a(m2715a);
        }
        if (z) {
            m1388d(intent);
        } else {
            m1382b(intent);
        }
    }

    /* renamed from: d */
    private synchronized void m1388d(Intent intent) {
        if (this.f898c) {
            Message m1370a = m1370a(intent);
            if (this.f895a.size() >= 50) {
                this.f895a.remove(0);
            }
            this.f895a.add(m1370a);
            return;
        }
        if (this.f892a == null) {
            this.f889a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (C1462u.this) {
                        C1462u.this.f892a = new Messenger(iBinder);
                        C1462u.this.f898c = false;
                        Iterator it = C1462u.this.f895a.iterator();
                        while (it.hasNext()) {
                            try {
                                C1462u.this.f892a.send((Message) it.next());
                            } catch (RemoteException e) {
                                AbstractC1417b.m1093a(e);
                            }
                        }
                        C1462u.this.f895a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    C1462u.this.f892a = null;
                    C1462u.this.f898c = false;
                }
            }, 1);
            this.f898c = true;
            this.f895a.clear();
            this.f895a.add(m1370a(intent));
        } else {
            try {
                this.f892a.send(m1370a(intent));
            } catch (RemoteException unused) {
                this.f892a = null;
                this.f898c = false;
            }
        }
    }

    /* renamed from: a */
    private Message m1370a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a */
    public boolean m1418a(int i) {
        if (!C1443b.m1222a(this.f889a).m1240b()) {
            return false;
        }
        m1384c(i);
        C1659hd c1659hd = new C1659hd();
        c1659hd.m3047a(C1752aj.m3692a());
        c1659hd.m3060b(C1443b.m1222a(this.f889a).m1226a());
        c1659hd.m3068d(this.f889a.getPackageName());
        c1659hd.m3064c(EnumC1643go.ClientABTest.f2208a);
        c1659hd.f2473a = new HashMap();
        c1659hd.f2473a.put("boot_mode", i + "");
        m1373a(this.f889a).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null);
        return true;
    }
}
