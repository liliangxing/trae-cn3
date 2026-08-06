package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1663hh;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.C1783l;
import com.xiaomi.push.service.C1793u;
import com.xiaomi.push.service.C1796x;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FCMPushHelper {
    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(C1447f.m1296c(EnumC1445d.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        C1447f.m1284a(context, EnumC1445d.ASSEMBLE_PUSH_FCM, str);
    }

    public static void clearToken(Context context) {
        C1447f.m1283a(context, EnumC1445d.ASSEMBLE_PUSH_FCM);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return C1447f.m1289a(context, EnumC1445d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver m1277a;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (m1277a = C1447f.m1277a(context)) == null) {
            return;
        }
        m1277a.onNotificationMessageArrived(context, C1447f.m1276a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver m1277a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (m1277a = C1447f.m1277a(context)) != null) {
            m1277a.onReceivePassThroughMessage(context, C1447f.m1276a(str));
        }
        String str2 = map.get("mipushContainer");
        if (!TextUtils.isEmpty(str2)) {
            try {
                byte[] decode = Base64.decode(str2, 2);
                m1166a(context, C1793u.m3987a(decode));
                m1167a(context, decode);
            } catch (Throwable th) {
                AbstractC1417b.m1091a("fcm notify notification error ", th);
            }
            return m1165a(context);
        }
        return new HashMap();
    }

    /* renamed from: a */
    private static void m1166a(Context context, C1656ha c1656ha) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((C1663hh) C1459r.m1344a(context, c1656ha), c1656ha.m3010a(), false);
            PushMessageReceiver m1277a = C1447f.m1277a(context);
            if (m1277a != null) {
                m1277a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            AbstractC1417b.m1091a("fcm broadcast notification come error ", th);
        }
    }

    /* renamed from: a */
    private static Map<String, String> m1165a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(EnumC1633ge.AckMessage.m2714a()));
        hashMap.put("deviceStatus", String.valueOf((int) C1670ho.m3310a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    public static void convertMessage(Intent intent) {
        C1447f.m1286a(intent);
    }

    /* renamed from: a */
    private static void m1167a(Context context, byte[] bArr) {
        boolean m1417a = C1462u.m1373a(context).m1417a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m1168a = m1168a(context);
        boolean z3 = false;
        if (m1417a && z2 && m1168a) {
            bArr = C1783l.m3869a(bArr, C1443b.m1222a(context).m1243d());
            if (bArr == null) {
                AbstractC1417b.m1089a("fcm message encrypt failed");
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    AbstractC1417b.m1089a("fcm message buf base64 encode failed");
                    z = false;
                } else {
                    Intent intent = new Intent(AbstractC1756an.f3054n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    AbstractC1417b.m1089a("fcm message reroute to xmsf");
                }
                z3 = z;
            }
        } else {
            AbstractC1417b.m1089a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m1417a), Boolean.valueOf(z2), Boolean.valueOf(m1168a)));
        }
        if (z3) {
            return;
        }
        AbstractC1417b.m1098b("fcm message post local");
        C1796x.m4055a(context, C1793u.m3987a(bArr), bArr);
    }

    /* renamed from: a */
    private static boolean m1168a(Context context) {
        return ((long) C1694j.m3429b(context)) >= 50002000 && m1169b(context);
    }

    /* renamed from: b */
    private static boolean m1169b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) C1694j.m3429b(context)) >= 50002000).apply();
    }
}
