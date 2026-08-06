package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.C1420a;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.AbstractC1695k;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1479am;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1543cw;
import com.xiaomi.push.C1553df;
import com.xiaomi.push.C1554dg;
import com.xiaomi.push.C1563dp;
import com.xiaomi.push.C1564dq;
import com.xiaomi.push.C1565dr;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1653gy;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1660he;
import com.xiaomi.push.C1664hi;
import com.xiaomi.push.C1666hk;
import com.xiaomi.push.C1668hm;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1696l;
import com.xiaomi.push.C1699o;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.EnumC1577ec;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.EnumC1647gs;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C1462u.m1373a(context).m1417a();
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C1702q.m3465a(context2);
        if (!NetworkStatusReceiver.m3977a()) {
            registerNetworkReceiver(sContext);
        }
        C1446e.m1264a(sContext).m1269a(pushConfiguration);
        C1470ad.m1444a(context2).m1449a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            C1696l.m3446a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            AbstractC1417b.m1089a("dynamic register network status receiver failed:" + th);
        }
        C1486at.m1534a(sContext);
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            AbstractC1417b.m1086a(context.getApplicationContext());
            AbstractC1417b.m1105e("sdk_version = 5_9_6-C");
            C1479am.m1501a(context).m1503a();
            C1543cw.m1989a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.m1211a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.m1210a(iCallbackResult);
            }
            if (C1702q.m3467a(sContext)) {
                C1454m.m1322a(sContext);
            }
            boolean z = C1443b.m1222a(sContext).m1224a() != Constants.m1164a();
            if (!z && !shouldSendRegRequest(sContext)) {
                C1462u.m1373a(sContext).m1396a();
                AbstractC1417b.m1089a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (!z && C1443b.m1222a(sContext).m1234a(str, str2) && !C1443b.m1222a(sContext).m1248f()) {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, C1443b.m1222a(sContext).m1241c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C1443b.m1222a(sContext).m1241c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_REGISTER.f1521a, arrayList, 0L, null, null, null));
                }
                C1462u.m1373a(sContext).m1396a();
                if (C1443b.m1222a(sContext).m1233a()) {
                    C1659hd c1659hd = new C1659hd();
                    c1659hd.m3060b(C1443b.m1222a(sContext).m1226a());
                    c1659hd.m3064c(EnumC1643go.ClientInfoUpdate.f2208a);
                    c1659hd.m3047a(C1752aj.m3692a());
                    c1659hd.f2473a = new HashMap();
                    Map<String, String> map = c1659hd.f2473a;
                    Context context2 = sContext;
                    map.put("app_version", C1628g.m2683a(context2, context2.getPackageName()));
                    Map<String, String> map2 = c1659hd.f2473a;
                    Context context3 = sContext;
                    map2.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C1628g.m2677a(context3, context3.getPackageName())));
                    c1659hd.f2473a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    c1659hd.f2473a.put("push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                    String m1245e = C1443b.m1222a(sContext).m1245e();
                    if (!TextUtils.isEmpty(m1245e)) {
                        c1659hd.f2473a.put("deviceid", m1245e);
                    }
                    C1462u.m1373a(sContext).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null);
                    C1462u.m1373a(sContext).m1400a(sContext);
                }
                if (!AbstractC1695k.m3443a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    AbstractC1695k.m3441a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    C1659hd c1659hd2 = new C1659hd();
                    c1659hd2.m3060b(C1443b.m1222a(sContext).m1226a());
                    c1659hd2.m3064c(EnumC1643go.PullOfflineMessage.f2208a);
                    c1659hd2.m3047a(C1752aj.m3692a());
                    c1659hd2.m3050a(false);
                    C1462u.m1373a(sContext).m1408a((C1462u) c1659hd2, EnumC1633ge.Notification, false, (C1646gr) null, false);
                    addPullNotificationTime(sContext);
                }
            } else {
                String m1624a = C1494ba.m1624a(6);
                C1443b.m1222a(sContext).m1227a();
                C1443b.m1222a(sContext).m1228a(Constants.m1164a());
                C1443b.m1222a(sContext).m1231a(str, str2, m1624a);
                MiTinyDataClient.C1436a.m1179a().m1188b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                C1660he c1660he = new C1660he();
                c1660he.m3088a(C1752aj.m3694b());
                c1660he.m3095b(str);
                c1660he.m3107e(str2);
                c1660he.m3104d(sContext.getPackageName());
                c1660he.m3110f(m1624a);
                Context context4 = sContext;
                c1660he.m3100c(C1628g.m2683a(context4, context4.getPackageName()));
                Context context5 = sContext;
                c1660he.m3094b(C1628g.m2677a(context5, context5.getPackageName()));
                c1660he.m3116h(BuildConfig.VERSION_NAME);
                c1660he.m3086a(BuildConfig.VERSION_CODE);
                c1660he.m3087a(EnumC1647gs.Init);
                if (!TextUtils.isEmpty(str3)) {
                    c1660he.m3113g(str3);
                }
                if (!C1694j.m3437d()) {
                    String m3397d = C1682i.m3397d(sContext);
                    if (!TextUtils.isEmpty(m3397d)) {
                        c1660he.m3119i(C1494ba.m1625a(m3397d) + Constants.ACCEPT_TIME_SEPARATOR_SP + C1682i.m3399f(sContext));
                    }
                }
                int m3377a = C1682i.m3377a();
                if (m3377a >= 0) {
                    c1660he.m3099c(m3377a);
                }
                C1462u.m1373a(sContext).m1403a(c1660he, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            C1464w.m1427a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                AbstractC1417b.m1082a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            AbstractC1417b.m1093a(th);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        C1470ad.m1444a(sContext).m1453a(new C1456o(sContext), C1750ah.m3674a(sContext).m3678a(EnumC1638gj.OcVersionCheckFrequency.m2760a(), com.ss.android.socialbase.appdownloader.constants.Constants.MAX_RETRY_AFTER), 5);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (C1750ah.m3674a(sContext).m3686a(EnumC1638gj.DataCollectionSwitch.m2760a(), getDefaultSwitch())) {
            C1553df.m2027a().m2029a(new C1450i(context));
            C1470ad.m1444a(sContext).m1450a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    C1554dg.m2030a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static boolean getDefaultSwitch() {
        return C1694j.m3433b();
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (C1694j.m3437d()) {
                    return;
                }
                if (C1682i.m3394c(MiPushClient.sContext) != null || C1479am.m1501a(MiPushClient.sContext).mo1483a()) {
                    C1659hd c1659hd = new C1659hd();
                    c1659hd.m3060b(C1443b.m1222a(MiPushClient.sContext).m1226a());
                    c1659hd.m3064c(EnumC1643go.ClientInfoUpdate.f2208a);
                    c1659hd.m3047a(C1752aj.m3692a());
                    c1659hd.m3049a(new HashMap());
                    String m3394c = C1682i.m3394c(MiPushClient.sContext);
                    String str = TextUtils.isEmpty(m3394c) ? "" : "" + C1494ba.m1625a(m3394c);
                    String m3398e = C1682i.m3398e(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(m3398e)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + m3398e;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        c1659hd.m3053a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    C1479am.m1501a(MiPushClient.sContext).m1504a(c1659hd.m3053a());
                    int m3377a = C1682i.m3377a();
                    if (m3377a >= 0) {
                        c1659hd.m3053a().put("space_id", Integer.toString(m3377a));
                    }
                    C1462u.m1373a(MiPushClient.sContext).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null);
                }
            }
        }).start();
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    AbstractC1417b.m1093a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.m1203a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, EnumC1647gs enumC1647gs) {
        AbstractC1417b.m1105e("re-register reason: " + enumC1647gs);
        String m1624a = C1494ba.m1624a(6);
        String m1226a = C1443b.m1222a(context).m1226a();
        String m1236b = C1443b.m1222a(context).m1236b();
        C1443b.m1222a(context).m1227a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        C1443b.m1222a(context).m1228a(Constants.m1164a());
        C1443b.m1222a(context).m1231a(m1226a, m1236b, m1624a);
        C1660he c1660he = new C1660he();
        c1660he.m3088a(C1752aj.m3694b());
        c1660he.m3095b(m1226a);
        c1660he.m3107e(m1236b);
        c1660he.m3110f(m1624a);
        c1660he.m3104d(context.getPackageName());
        c1660he.m3100c(C1628g.m2683a(context, context.getPackageName()));
        c1660he.m3094b(C1628g.m2677a(context, context.getPackageName()));
        c1660he.m3116h(BuildConfig.VERSION_NAME);
        c1660he.m3086a(BuildConfig.VERSION_CODE);
        c1660he.m3087a(enumC1647gs);
        int m3377a = C1682i.m3377a();
        if (m3377a >= 0) {
            c1660he.m3099c(m3377a);
        }
        C1462u.m1373a(context).m1403a(c1660he, false);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C1646gr c1646gr = new C1646gr();
        c1646gr.m2840a(miPushMessage.getMessageId());
        c1646gr.m2851b(miPushMessage.getTopic());
        c1646gr.m2863d(miPushMessage.getDescription());
        c1646gr.m2859c(miPushMessage.getTitle());
        c1646gr.m2858c(miPushMessage.getNotifyId());
        c1646gr.m2839a(miPushMessage.getNotifyType());
        c1646gr.m2850b(miPushMessage.getPassThrough());
        c1646gr.m2841a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), c1646gr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, C1646gr c1646gr, String str2) {
        C1659hd c1659hd = new C1659hd();
        if (TextUtils.isEmpty(str2)) {
            if (C1443b.m1222a(context).m1240b()) {
                c1659hd.m3060b(C1443b.m1222a(context).m1226a());
            } else {
                AbstractC1417b.m1103d("do not report clicked message");
                return;
            }
        } else {
            c1659hd.m3060b(str2);
        }
        c1659hd.m3064c("bar:click");
        c1659hd.m3047a(str);
        c1659hd.m3050a(false);
        C1462u.m1373a(context).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, c1646gr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, C1646gr c1646gr, String str2, String str3) {
        C1659hd c1659hd = new C1659hd();
        if (TextUtils.isEmpty(str3)) {
            AbstractC1417b.m1103d("do not report clicked message");
            return;
        }
        c1659hd.m3060b(str3);
        c1659hd.m3064c("bar:click");
        c1659hd.m3047a(str);
        c1659hd.m3050a(false);
        C1462u.m1373a(context).m1410a(c1659hd, EnumC1633ge.Notification, false, true, c1646gr, true, str2, str3);
    }

    public static void setLocalNotificationType(Context context, int i) {
        C1462u.m1373a(context).m1420b(i & (-1));
    }

    public static void clearLocalNotificationType(Context context) {
        C1462u.m1373a(context).m1425f();
    }

    public static void unregisterPush(Context context) {
        C1447f.m1297c(context);
        C1750ah.m3674a(context).m3682a();
        if (C1443b.m1222a(context).m1240b()) {
            C1666hk c1666hk = new C1666hk();
            c1666hk.m3239a(C1752aj.m3692a());
            c1666hk.m3244b(C1443b.m1222a(context).m1226a());
            c1666hk.m3247c(C1443b.m1222a(context).m1241c());
            c1666hk.m3251e(C1443b.m1222a(context).m1236b());
            c1666hk.m3249d(context.getPackageName());
            C1462u.m1373a(context).m1404a(c1666hk);
            PushMessageHandler.m1200a();
            PushMessageHandler.m1213b();
            C1443b.m1222a(context).m1237b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void disablePush(Context context) {
        C1462u.m1373a(context).m1415a(true);
    }

    public static void enablePush(Context context) {
        C1462u.m1373a(context).m1415a(false);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_FCM_TOKEN, EnumC1445d.ASSEMBLE_PUSH_FCM, "");
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, EnumC1577ec.COMMAND_SET_ALIAS.f1521a, str, str2);
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, EnumC1577ec.COMMAND_UNSET_ALIAS.f1521a, str, str2);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, EnumC1577ec.COMMAND_SET_ACCOUNT.f1521a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, EnumC1577ec.COMMAND_UNSET_ACCOUNT.f1521a, str, str2);
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(C1443b.m1222a(context).m1226a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > DownloadConstants.DAY) {
            C1664hi c1664hi = new C1664hi();
            String m3692a = C1752aj.m3692a();
            c1664hi.m3207a(m3692a);
            c1664hi.m3211b(C1443b.m1222a(context).m1226a());
            c1664hi.m3213c(str);
            c1664hi.m3215d(context.getPackageName());
            c1664hi.m3217e(str2);
            AbstractC1417b.m1105e("cmd:" + EnumC1577ec.COMMAND_SUBSCRIBE_TOPIC + ", " + m3692a);
            C1462u.m1373a(context).m1405a((C1462u) c1664hi, EnumC1633ge.Subscription, (C1646gr) null);
            return;
        }
        if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m1208a(context, str2, 0L, null, str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_SUBSCRIBE_TOPIC.f1521a, arrayList, 0L, null, null, null));
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (C1443b.m1222a(context).m1240b()) {
            if (topicSubscribedTime(context, str) < 0) {
                AbstractC1417b.m1089a("Don't cancel subscribe for " + C1494ba.m1626a(str, 3) + " is unsubscribed");
                return;
            }
            C1668hm c1668hm = new C1668hm();
            String m3692a = C1752aj.m3692a();
            c1668hm.m3277a(m3692a);
            c1668hm.m3281b(C1443b.m1222a(context).m1226a());
            c1668hm.m3283c(str);
            c1668hm.m3285d(context.getPackageName());
            c1668hm.m3287e(str2);
            AbstractC1417b.m1105e("cmd:" + EnumC1577ec.COMMAND_UNSUBSCRIBE_TOPIC + ", " + m3692a);
            C1462u.m1373a(context).m1405a((C1462u) c1668hm, EnumC1633ge.UnSubscription, (C1646gr) null);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    public static void clearNotification(Context context, int i) {
        C1462u.m1373a(context).m1397a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        C1462u.m1373a(context).m1414a(str, str2);
    }

    public static void removeWindow(Context context) {
        C1462u.m1373a(context).m1424e();
    }

    public static void clearNotification(Context context) {
        C1462u.m1373a(context).m1397a(-1);
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (C1443b.m1222a(context).m1240b()) {
            EnumC1643go enumC1643go = z ? EnumC1643go.APP_SLEEP : EnumC1643go.APP_WAKEUP;
            C1659hd c1659hd = new C1659hd();
            c1659hd.m3060b(C1443b.m1222a(context).m1226a());
            c1659hd.m3064c(enumC1643go.f2208a);
            c1659hd.m3068d(context.getPackageName());
            c1659hd.m3047a(C1752aj.m3692a());
            c1659hd.m3050a(false);
            C1462u.m1373a(context).m1408a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null, false);
        }
    }

    public static String getRegId(Context context) {
        if (C1443b.m1222a(context).m1242c()) {
            return C1443b.m1222a(context).m1241c();
        }
        return null;
    }

    public static String getAppRegion(Context context) {
        if (C1443b.m1222a(context).m1242c()) {
            return C1443b.m1222a(context).m1247f();
        }
        return null;
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (EnumC1577ec.COMMAND_SET_ALIAS.f1521a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < DownloadConstants.DAY) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m1209a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_SET_ALIAS.f1521a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (EnumC1577ec.COMMAND_UNSET_ALIAS.f1521a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            AbstractC1417b.m1089a("Don't cancel alias for " + C1494ba.m1626a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        if (EnumC1577ec.COMMAND_SET_ACCOUNT.f1521a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < DownloadConstants.HOUR) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m1209a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_SET_ACCOUNT.f1521a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (EnumC1577ec.COMMAND_UNSET_ACCOUNT.f1521a.equalsIgnoreCase(str) && accountSetTime(context, str2) < 0) {
            AbstractC1417b.m1089a("Don't cancel account for " + C1494ba.m1626a(arrayList.toString(), 3) + " is unseted");
        } else {
            setCommand(context, str, (ArrayList<String>) arrayList, str3);
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(C1443b.m1222a(context).m1226a())) {
            return;
        }
        C1653gy c1653gy = new C1653gy();
        String m3692a = C1752aj.m3692a();
        c1653gy.m2964a(m3692a);
        c1653gy.m2971b(C1443b.m1222a(context).m1226a());
        c1653gy.m2974c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            c1653gy.m2967a(it.next());
        }
        c1653gy.m2979e(str2);
        c1653gy.m2977d(context.getPackageName());
        AbstractC1417b.m1105e("cmd:" + str + ", " + m3692a);
        C1462u.m1373a(context).m1405a((C1462u) c1653gy, EnumC1633ge.Command, (C1646gr) null);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m1209a(context, str, EnumC1577ec.COMMAND_SET_ACCEPT_TIME.f1521a, 0L, null, arrayList2);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_SET_ACCEPT_TIME.f1521a, arrayList2, 0L, null, null, null));
                return;
            }
        }
        setCommand(context, EnumC1577ec.COMMAND_SET_ACCEPT_TIME.f1521a, (ArrayList<String>) arrayList, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return C1446e.m1264a(context).m1273b(EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return C1446e.m1264a(context).m1273b(EnumC1445d.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return C1446e.m1264a(context).m1273b(EnumC1445d.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenVIVOPush(Context context) {
        return C1446e.m1264a(context).m1273b(EnumC1445d.ASSEMBLE_PUSH_FTOS);
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    @Deprecated
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class MiPushClientCallback {
        private String category;

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllAlias(context).iterator();
            while (it.hasNext()) {
                removeAlias(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllUserAccount(context).iterator();
            while (it.hasNext()) {
                removeAccount(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllTopic(context).iterator();
            while (it.hasNext()) {
                removeTopic(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            C1699o.m3458a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            C1699o.m3458a(edit);
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        C1699o.m3458a(edit);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        C1699o.m3458a(edit);
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    private static void initEventPerfLogic(final Context context) {
        C1565dr.m2273a(new C1565dr.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.C1565dr.a
            public void uploader(Context context2, C1637gi c1637gi) {
                MiTinyDataClient.upload(context2, c1637gi);
            }
        });
        Config m2261a = C1565dr.m2261a(context);
        C1420a.m1108a(context).m1129a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, m2261a, new C1563dp(context), new C1564dq(context));
        C1442a.m1220a(context);
        C1452k.m1320a(context, m2261a);
        C1750ah.m3674a(context).m3683a(new C1750ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.C1750ah.a
            protected void onCallback() {
                C1565dr.m2269a(context);
            }
        });
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.UPLOAD_HUAWEI_TOKEN))) {
            C1462u.m1373a(sContext).m1413a((String) null, EnumC1463v.UPLOAD_HUAWEI_TOKEN, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.UPLOAD_COS_TOKEN))) {
            C1462u.m1373a(sContext).m1413a((String) null, EnumC1463v.UPLOAD_COS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_COS, "init");
        }
        if ("syncing".equals(C1457p.m1333a(sContext).m1335a(EnumC1463v.UPLOAD_FTOS_TOKEN))) {
            C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_FTOS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        /* JADX INFO: Access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }

        public String getToken() {
            return this.token;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public long getResultCode() {
            return this.resultCode;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class CodeResult {
        private long resultCode = -1;

        protected void setResultCode(long j) {
            this.resultCode = j;
        }

        public long getResultCode() {
            return this.resultCode;
        }
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }
}
