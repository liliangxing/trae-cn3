package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.C1443b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1649gu;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1660he;
import com.xiaomi.push.C1661hf;
import com.xiaomi.push.C1666hk;
import com.xiaomi.push.C1667hl;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1577ec;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.EnumC1647gs;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.C1763au;
import com.xiaomi.push.service.C1796x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, C1443b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (C1443b.m1222a(context).m1235a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            C1443b.a m1225a = C1443b.m1222a(context).m1225a(str);
            if (m1225a != null) {
                arrayList.add(m1225a.f829c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_REGISTER.f1521a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                C1659hd c1659hd = new C1659hd();
                c1659hd.m3060b(str2);
                c1659hd.m3064c(EnumC1643go.PullOfflineMessage.f2208a);
                c1659hd.m3047a(C1752aj.m3692a());
                c1659hd.m3050a(false);
                C1462u.m1373a(context).m1410a(c1659hd, EnumC1633ge.Notification, false, true, null, false, str, str2);
                AbstractC1417b.m1098b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            AbstractC1417b.m1089a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String m1624a = C1494ba.m1624a(6);
        C1443b.a aVar = new C1443b.a(context);
        aVar.m1261c(str2, str3, m1624a);
        dataMap.put(str, aVar);
        C1660he c1660he = new C1660he();
        c1660he.m3088a(C1752aj.m3692a());
        c1660he.m3095b(str2);
        c1660he.m3107e(str3);
        c1660he.m3104d(str);
        c1660he.m3110f(m1624a);
        c1660he.m3100c(C1628g.m2683a(context, context.getPackageName()));
        c1660he.m3094b(C1628g.m2677a(context, context.getPackageName()));
        c1660he.m3116h(BuildConfig.VERSION_NAME);
        c1660he.m3086a(BuildConfig.VERSION_CODE);
        c1660he.m3087a(EnumC1647gs.Init);
        if (!C1694j.m3437d()) {
            String m3397d = C1682i.m3397d(context);
            if (!TextUtils.isEmpty(m3397d)) {
                c1660he.m3119i(C1494ba.m1625a(m3397d));
            }
        }
        int m3377a = C1682i.m3377a();
        if (m3377a >= 0) {
            c1660he.m3099c(m3377a);
        }
        C1659hd c1659hd2 = new C1659hd();
        c1659hd2.m3064c(EnumC1643go.HybridRegister.f2208a);
        c1659hd2.m3060b(C1443b.m1222a(context).m1226a());
        c1659hd2.m3068d(context.getPackageName());
        c1659hd2.m3051a(C1670ho.m3313a(c1660he));
        c1659hd2.m3047a(C1752aj.m3692a());
        C1462u.m1373a(context).m1405a((C1462u) c1659hd2, EnumC1633ge.Notification, (C1646gr) null);
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        C1443b.a m1225a = C1443b.m1222a(context).m1225a(str);
        if (m1225a == null) {
            return;
        }
        C1666hk c1666hk = new C1666hk();
        c1666hk.m3239a(C1752aj.m3692a());
        c1666hk.m3249d(str);
        c1666hk.m3244b(m1225a.f825a);
        c1666hk.m3247c(m1225a.f829c);
        c1666hk.m3251e(m1225a.f827b);
        C1659hd c1659hd = new C1659hd();
        c1659hd.m3064c(EnumC1643go.HybridUnregister.f2208a);
        c1659hd.m3060b(C1443b.m1222a(context).m1226a());
        c1659hd.m3068d(context.getPackageName());
        c1659hd.m3051a(C1670ho.m3313a(c1666hk));
        c1659hd.m3047a(C1752aj.m3692a());
        C1462u.m1373a(context).m1405a((C1462u) c1659hd, EnumC1633ge.Notification, (C1646gr) null);
        C1443b.m1222a(context).m1238b(str);
    }

    public static boolean isRegistered(Context context, String str) {
        return C1443b.m1222a(context).m1225a(str) != null;
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            AbstractC1417b.m1089a("do not ack message, message is null");
            return;
        }
        try {
            C1649gu c1649gu = new C1649gu();
            c1649gu.m2899b(C1443b.m1222a(context).m1226a());
            c1649gu.m2893a(miPushMessage.getMessageId());
            c1649gu.m2892a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            c1649gu.m2894a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                c1649gu.m2902c(miPushMessage.getTopic());
            }
            C1462u.m1373a(context).m1407a((C1462u) c1649gu, EnumC1633ge.AckMessage, false, C1763au.m3762a(PushMessageHelper.generateMessage(miPushMessage)));
            AbstractC1417b.m1098b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        C1461t.m1354a(context, str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        C1796x.m4066a(context, linkedList);
    }

    public static void onReceiveRegisterResult(Context context, C1661hf c1661hf) {
        ArrayList arrayList;
        C1443b.a aVar;
        String m3149c = c1661hf.m3149c();
        if (c1661hf.m3139a() == 0 && (aVar = dataMap.get(m3149c)) != null) {
            aVar.m1254a(c1661hf.f2578e, c1661hf.f2579f);
            C1443b.m1222a(context).m1230a(m3149c, aVar);
        }
        if (TextUtils.isEmpty(c1661hf.f2578e)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(c1661hf.f2578e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_REGISTER.f1521a, arrayList, c1661hf.f2566a, c1661hf.f2577d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(m3149c, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, C1667hl c1667hl) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_UNREGISTER.f1521a, null, c1667hl.f2701a, c1667hl.f2709d, null, null);
        String m3261a = c1667hl.m3261a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(m3261a, generateCommandMessage);
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static boolean shouldPullNotification(Context context, String str) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong(new StringBuilder("last_pull_notification_").append(str).toString(), -1L)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = !TextUtils.isEmpty(str) ? Integer.valueOf(str).intValue() : 0;
        if (!z) {
            intValue = (intValue & (-4)) + C1628g.b.NOT_ALLOWED.m2696a();
        }
        return (short) intValue;
    }
}
