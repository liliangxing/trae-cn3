package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.ss.android.deviceregister.base.OaidModel;
import com.ss.ttm.player.C0968C;
import com.ss.ttm.player.UnifiedCodec.codec.CodecError;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.NotificationBuilderC1567dt;
import com.xiaomi.push.NotificationBuilderC1568du;
import com.xiaomi.push.NotificationBuilderC1569dv;
import com.xiaomi.push.service.C1747ae;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1796x {

    /* renamed from: a */
    public static long f3243a;

    /* renamed from: a */
    private static volatile AbstractC1744ab f3244a;

    /* renamed from: a */
    private static final LinkedList<Pair<Integer, C1656ha>> f3245a = new LinkedList<>();

    /* renamed from: a */
    private static ExecutorService f3246a = Executors.newCachedThreadPool();

    /* renamed from: com.xiaomi.push.service.x$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class b {

        /* renamed from: a */
        long f3253a = 0;

        /* renamed from: a */
        Notification f3254a;
    }

    /* renamed from: com.xiaomi.push.service.x$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class c {

        /* renamed from: a */
        public String f3256a;

        /* renamed from: a */
        public long f3255a = 0;

        /* renamed from: a */
        public boolean f3257a = false;
    }

    /* renamed from: a */
    public static boolean m4070a(Context context, String str) {
        return C1628g.m2690b(context, str);
    }

    /* renamed from: a */
    public static boolean m4071a(Context context, String str, boolean z) {
        return C1694j.m3426a() && !z && m4070a(context, str);
    }

    /* renamed from: a */
    public static c m4055a(Context context, C1656ha c1656ha, byte[] bArr) {
        int i;
        Map<String, String> map;
        int i2;
        c cVar = new c();
        C1628g.b m2681a = C1628g.m2681a(context, m4057a(c1656ha), true);
        C1646gr m3010a = c1656ha.m3010a();
        if (m3010a != null) {
            i = m3010a.m2857c();
            map = m3010a.m2843a();
        } else {
            i = 0;
            map = null;
        }
        final int m3476b = C1703r.m3476b(m4057a(c1656ha), i);
        if (C1694j.m3427a(context) && m2681a == C1628g.b.NOT_ALLOWED) {
            if (m3010a != null) {
                C1566ds.m2275a(context.getApplicationContext()).m2282a(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), "10:" + m4057a(c1656ha));
            }
            AbstractC1417b.m1089a("Do not notify because user block " + m4057a(c1656ha) + "‘s notification");
            return cVar;
        }
        if (C1694j.m3427a(context) && f3244a != null && f3244a.m3577a(context, m3476b, m4057a(c1656ha), map)) {
            if (m3010a != null) {
                C1566ds.m2275a(context.getApplicationContext()).m2282a(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), "14:" + m4057a(c1656ha));
            }
            AbstractC1417b.m1089a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews m4052a = m4052a(context, c1656ha, bArr);
        PendingIntent m4043a = m4043a(context, c1656ha, c1656ha.m3025b(), bArr, m3476b);
        if (m4043a == null) {
            if (m3010a != null) {
                C1566ds.m2275a(context.getApplicationContext()).m2282a(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), "11");
            }
            AbstractC1417b.m1089a("The click PendingIntent is null. ");
            return cVar;
        }
        b m4054a = m4054a(context, c1656ha, bArr, m4052a, m4043a, m3476b);
        cVar.f3255a = m4054a.f3253a;
        cVar.f3256a = m4057a(c1656ha);
        Notification notification = m4054a.f3254a;
        if (C1694j.m3426a()) {
            if (!TextUtils.isEmpty(m3010a.m2842a())) {
                notification.extras.putString("message_id", m3010a.m2842a());
            }
            notification.extras.putString("local_paid", c1656ha.m3017a());
            C1749ag.m3664a(map, notification.extras, "msg_busi_type");
            C1749ag.m3664a(map, notification.extras, "disable_notification_flags");
            String str = m3010a.m2853b() == null ? null : m3010a.m2853b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", m4059a(m3010a.f2281a, "n_stats_expose"));
            if (m4089c(c1656ha)) {
                i2 = 1000;
            } else {
                i2 = m4073a(c1656ha) ? 3000 : -1;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i2));
            notification.extras.putString("target_package", m4057a(c1656ha));
        }
        String str2 = m3010a.m2843a() == null ? null : m3010a.m2843a().get("message_count");
        if (C1694j.m3426a() && str2 != null) {
            try {
                C1749ag.m3659a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                if (m3010a != null) {
                    C1566ds.m2275a(context.getApplicationContext()).m2283b(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), "8");
                }
                AbstractC1417b.m1103d("fail to set message count. " + e);
            }
        }
        String m4057a = m4057a(c1656ha);
        C1749ag.m3661a(notification, m4057a);
        final C1748af m3625a = C1748af.m3625a(context, m4057a);
        if (C1694j.m3427a(context) && f3244a != null) {
            f3244a.m3575a(c1656ha, m3010a.m2843a(), m3476b, notification);
        }
        if (C1694j.m3427a(context) && f3244a != null && f3244a.m3578a(m3010a.m2843a(), m3476b, notification)) {
            AbstractC1417b.m1098b("consume this notificaiton by agent");
        } else {
            m3625a.m3643a(m3476b, notification);
            cVar.f3257a = true;
            AbstractC1417b.m1089a("notification: " + m3010a.m2842a() + " is notifyied");
        }
        if (C1694j.m3426a() && C1694j.m3427a(context)) {
            C1746ad.m3596a().m3611a(context, m3476b, notification);
            C1771bb.m3812a(context, m4057a, m3476b, m3010a.m2842a(), notification);
        }
        if (m4073a(c1656ha)) {
            C1566ds.m2275a(context.getApplicationContext()).m2281a(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), CodecError.DEQUEUE_OUTPUT_ALWAYS_TRY_AGAIN, null);
        }
        if (m4089c(c1656ha)) {
            C1566ds.m2275a(context.getApplicationContext()).m2281a(c1656ha.m3025b(), m4080b(c1656ha), m3010a.m2842a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String m2842a = m3010a != null ? m3010a.m2842a() : null;
            C1470ad m1444a = C1470ad.m1444a(context);
            int m4041a = m4041a(m3010a.m2843a());
            if (m4041a > 0 && !TextUtils.isEmpty(m2842a)) {
                final String str3 = "n_timeout_" + m2842a;
                m1444a.m1455a(str3);
                m1444a.m1456b(new C1470ad.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.C1470ad.a
                    /* renamed from: a */
                    public String mo1133a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        m3625a.m3642a(m3476b);
                    }
                }, m4041a);
            }
        }
        Pair<Integer, C1656ha> pair = new Pair<>(Integer.valueOf(m3476b), c1656ha);
        LinkedList<Pair<Integer, C1656ha>> linkedList = f3245a;
        synchronized (linkedList) {
            linkedList.add(pair);
            if (linkedList.size() > 100) {
                linkedList.remove();
            }
        }
        return cVar;
    }

    /* renamed from: a */
    private static PendingIntent m4043a(Context context, C1656ha c1656ha, String str, byte[] bArr, int i) {
        return m4044a(context, c1656ha, str, bArr, i, 0, m4069a(context, c1656ha, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PendingIntent m4044a(Context context, C1656ha c1656ha, String str, byte[] bArr, int i, int i2, boolean z) {
        int i3;
        Intent intent;
        String protocol;
        if (m4089c(c1656ha)) {
            i3 = 1000;
        } else {
            i3 = m4073a(c1656ha) ? 3000 : -1;
        }
        C1646gr m3010a = c1656ha.m3010a();
        String m2842a = m3010a != null ? m3010a.m2842a() : "";
        boolean m4073a = m4073a(c1656ha);
        if (m3010a != null && !TextUtils.isEmpty(m3010a.f2290e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(m3010a.f2290e));
            try {
                protocol = new URL(m3010a.f2290e).getProtocol();
            } catch (MalformedURLException unused) {
                AbstractC1417b.m1089a("meet URL exception : " + m3010a.f2290e);
                intent2.setPackage(str);
            }
            if (!ImageDelegate.HTTP_PREFIX.equals(protocol) && !"https".equals(protocol)) {
                intent2.setPackage(str);
                intent2.addFlags(C0968C.ENCODING_PCM_MU_LAW);
                intent2.putExtra("messageId", m2842a);
                intent2.putExtra("eventMessageType", i3);
                if (Build.VERSION.SDK_INT < 31) {
                    return PendingIntent.getActivity(context, 0, intent2, 167772160);
                }
                return PendingIntent.getActivity(context, 0, intent2, 134217728);
            }
            C1749ag.m3663a(context, str, intent2);
            intent2.addFlags(C0968C.ENCODING_PCM_MU_LAW);
            intent2.putExtra("messageId", m2842a);
            intent2.putExtra("eventMessageType", i3);
            if (Build.VERSION.SDK_INT < 31) {
            }
        } else {
            if (m4073a) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(m2842a));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(m2842a));
            }
            intent.putExtra("notification_click_button", i2);
            intent.putExtra("messageId", m2842a);
            intent.putExtra("eventMessageType", i3);
            if (!m4073a && z) {
                Intent intent3 = new Intent();
                intent3.setComponent(m4046a(str));
                intent3.addFlags(276824064);
                intent3.putExtra("mipush_serviceIntent", intent);
                intent3.addCategory(String.valueOf(i));
                intent3.addCategory(String.valueOf(m2842a));
                intent3.addCategory(String.valueOf(i2));
                m4060a(context, intent3, c1656ha, m3010a, m2842a, i2);
                if (Build.VERSION.SDK_INT >= 31) {
                    return PendingIntent.getActivity(context, 0, intent3, 167772160);
                }
                return PendingIntent.getActivity(context, 0, intent3, 134217728);
            }
            m4060a(context, intent, c1656ha, m3010a, m2842a, i2);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getService(context, 0, intent, 167772160);
            }
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
    }

    /* renamed from: a */
    private static void m4060a(Context context, Intent intent, C1656ha c1656ha, C1646gr c1646gr, String str, int i) {
        if (c1656ha == null || c1646gr == null || TextUtils.isEmpty(str)) {
            return;
        }
        String m4058a = m4058a(c1646gr.m2843a(), i);
        if (TextUtils.isEmpty(m4058a)) {
            return;
        }
        if (AbstractC1756an.f3041a.equals(m4058a) || AbstractC1756an.f3042b.equals(m4058a) || AbstractC1756an.f3043c.equals(m4058a)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", c1656ha.f2440a);
            if (!TextUtils.isEmpty(c1656ha.f2444b)) {
                intent.putExtra("target_package", c1656ha.f2444b);
            }
            intent.putExtra("job_key", m4059a(c1646gr.m2843a(), "jobkey"));
            intent.putExtra(i + "_target_component", m4040a(context, c1656ha.f2444b, c1646gr.m2843a(), i));
        }
    }

    /* renamed from: a */
    private static boolean m4069a(Context context, C1656ha c1656ha, String str) {
        if (c1656ha != null && c1656ha.m3010a() != null && c1656ha.m3010a().m2843a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(c1656ha.m3010a().m2843a().get("use_clicked_activity")) && C1781j.m3863a(context, m4046a(str));
        }
        AbstractC1417b.m1089a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a */
    public static ComponentName m4046a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0074, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] m4076a(Context context, C1646gr c1646gr) {
        String str;
        String m2860c = c1646gr.m2860c();
        String m2864d = c1646gr.m2864d();
        Map<String, String> m2843a = c1646gr.m2843a();
        if (m2843a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = m2843a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    m2860c = str2;
                }
                str = m2843a.get("description_short");
            } else if (intValue > 360) {
                String str3 = m2843a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m2860c = str3;
                }
                str = m2843a.get("description_long");
            }
        }
        return new String[]{m2860c, m2864d};
    }

    /* renamed from: a */
    private static String m4059a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static int m4040a(Context context, String str, Map<String, String> map, int i) {
        ComponentName m3862a;
        Intent m4079b = m4079b(context, str, map, i);
        if (m4079b == null || (m3862a = C1781j.m3862a(context, m4079b)) == null) {
            return 0;
        }
        return m3862a.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03e2  */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b m4054a(Context context, C1656ha c1656ha, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        NotificationBuilderC1568du notificationBuilderC1568du;
        int i2;
        Bitmap m4050a;
        boolean z;
        Bitmap m4050a2;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        long currentTimeMillis;
        boolean z5;
        b bVar;
        int i3;
        String str2;
        boolean z6;
        Notification notification;
        int i4;
        Bitmap m3613a;
        b bVar2 = new b();
        C1646gr m3010a = c1656ha.m3010a();
        String m4057a = m4057a(c1656ha);
        Map<String, String> m2843a = m3010a.m2843a();
        String[] m4076a = m4076a(context, m3010a);
        if (remoteViews != null) {
            notificationBuilderC1568du = new NotificationBuilderC1568du(context);
            notificationBuilderC1568du.setCustomContentView(remoteViews);
        } else if (m2843a != null && m2843a.containsKey("notification_style_type")) {
            notificationBuilderC1568du = m4053a(context, c1656ha, bArr, m4076a[1], i);
        } else {
            notificationBuilderC1568du = new NotificationBuilderC1568du(context);
        }
        NotificationBuilderC1568du notificationBuilderC1568du2 = notificationBuilderC1568du;
        m4068a(notificationBuilderC1568du2, context, c1656ha.m3025b(), c1656ha, bArr, i);
        notificationBuilderC1568du2.setContentTitle(m4076a[0]);
        notificationBuilderC1568du2.setContentText(m4076a[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        notificationBuilderC1568du2.setWhen(currentTimeMillis2);
        String m4059a = m4059a(m2843a, "notification_show_when");
        if (TextUtils.isEmpty(m4059a)) {
            notificationBuilderC1568du2.setShowWhen(true);
        } else {
            notificationBuilderC1568du2.setShowWhen(Boolean.parseBoolean(m4059a));
        }
        notificationBuilderC1568du2.setContentIntent(pendingIntent);
        m4064a(context, m4057a, notificationBuilderC1568du2, m2843a);
        if (m2843a == null) {
            m4050a = null;
            i2 = 1;
        } else {
            i2 = 1;
            m4050a = m4050a(context, m2843a.get("notification_small_icon_uri"), true);
        }
        if (m4050a != null) {
            Object[] objArr = new Object[i2];
            objArr[0] = m4050a;
            Object m1570a = C1488av.m1570a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
            if (m1570a != null) {
                Object[] objArr2 = new Object[i2];
                objArr2[0] = m1570a;
                C1488av.m1568a((Object) notificationBuilderC1568du2, "setSmallIcon", objArr2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.isGrayscaleIcon", i2);
                notificationBuilderC1568du2.addExtras(bundle);
            } else {
                AbstractC1417b.m1089a("failed te get small icon with url:" + m2843a.get("notification_small_icon_uri"));
            }
        } else {
            AbstractC1417b.m1089a("failed to get small icon url:" + m4059a(m2843a, "notification_small_icon_uri"));
        }
        notificationBuilderC1568du2.mo2286a(m4059a(m2843a, "notification_small_icon_color"));
        String m4059a2 = m4059a(m2843a, "__dynamic_icon_uri");
        boolean z7 = Boolean.parseBoolean(m4059a(m2843a, "__adiom")) || !C1694j.m3426a();
        if (!TextUtils.isEmpty(m4059a2) && z7) {
            if (m4059a2.startsWith(ImageDelegate.HTTP_PREFIX)) {
                C1747ae.b m3615a = C1747ae.m3615a(context, m4059a2, true);
                if (m3615a != null) {
                    m3613a = m3615a.f2952a;
                    bVar2.f3253a = m3615a.f2951a;
                } else {
                    m3613a = null;
                }
            } else {
                m3613a = C1747ae.m3613a(context, m4059a2);
            }
            if (m3613a != null) {
                notificationBuilderC1568du2.setLargeIcon(m3613a);
                z = true;
                m4050a2 = m2843a != null ? null : m4050a(context, m2843a.get("notification_large_icon_uri"), true);
                if (m4050a2 != null) {
                    notificationBuilderC1568du2.setLargeIcon(m4050a2);
                }
                if (m2843a == null) {
                    String str3 = m2843a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m2843a.get("notification_is_summary"));
                    boolean parseBoolean2 = Boolean.parseBoolean(m2843a.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str3) && (C1694j.m3426a() || !parseBoolean2)) {
                        str3 = m4057a(c1656ha);
                    }
                    String str4 = str3;
                    C1488av.m1568a((Object) notificationBuilderC1568du2, "setGroupSummary", Boolean.valueOf(parseBoolean));
                    String str5 = m2843a.get("notification_style_type");
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str5) || "3".equals(str5))) {
                        z3 = true;
                        z4 = true;
                        str = m4057a(c1656ha) + "_custom_" + currentTimeMillis2;
                        z2 = parseBoolean;
                    } else {
                        z3 = false;
                        z2 = parseBoolean;
                        z4 = true;
                        str = str4;
                    }
                } else {
                    z2 = false;
                    z3 = false;
                    str = null;
                    z4 = true;
                }
                notificationBuilderC1568du2.setAutoCancel(z4);
                currentTimeMillis = System.currentTimeMillis();
                if (m2843a != null && m2843a.containsKey("ticker")) {
                    notificationBuilderC1568du2.setTicker(m2843a.get("ticker"));
                }
                if (currentTimeMillis - f3243a <= 10000) {
                    f3243a = currentTimeMillis;
                    i3 = m3010a.f2277a;
                    if (m4084b(context, m4057a)) {
                        i3 = m4038a(context, m4057a);
                    }
                    notificationBuilderC1568du2.setDefaults(i3);
                    if (m2843a != null && (i3 & 1) != 0) {
                        String str6 = m2843a.get("sound_uri");
                        if (!TextUtils.isEmpty(str6)) {
                            bVar = bVar2;
                            z5 = z;
                            if (str6.startsWith("android.resource://" + m4057a)) {
                                notificationBuilderC1568du2.setDefaults(i3 ^ 1);
                                notificationBuilderC1568du2.setSound(Uri.parse(str6));
                            }
                        }
                    }
                    z5 = z;
                    bVar = bVar2;
                } else {
                    z5 = z;
                    bVar = bVar2;
                    i3 = -100;
                }
                if (m2843a == null && Build.VERSION.SDK_INT >= 26) {
                    C1748af m3625a = C1748af.m3625a(context, m4057a);
                    str2 = "com.xiaomi.xmsf";
                    if (m4041a(m2843a) > 0) {
                        z6 = z3;
                        i4 = i3;
                        C1488av.m1568a((Object) notificationBuilderC1568du2, "setTimeoutAfter", Long.valueOf(r15 * 1000));
                    } else {
                        z6 = z3;
                        i4 = i3;
                    }
                    C1745ac.m3586a(m3010a);
                    String str7 = m2843a.get("channel_id");
                    if (!TextUtils.isEmpty(str7) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String m4056a = m4056a(context, m4057a, m2843a);
                        int m4078b = m4078b(m2843a);
                        int i5 = m3010a.f2277a;
                        String str8 = m2843a.get("channel_description");
                        String str9 = m2843a.get("sound_uri");
                        String str10 = m2843a.get("channel_perm");
                        C1771bb.m3813a(context, m2843a, notificationBuilderC1568du2, currentTimeMillis2);
                        C1488av.m1568a((Object) notificationBuilderC1568du2, "setChannelId", C1745ac.m3582a(m3625a, str7, m4056a, str8, i5, m4078b, str9, str10));
                        if (i4 == -100 && C1749ag.m3669a(m2843a)) {
                            C1749ag.m3666a(notificationBuilderC1568du2, z2);
                        }
                        if ("pulldown".equals(C1749ag.m3658a((Object) m2843a)) && C1749ag.m3669a(m2843a) && Objects.equals(m2843a.get("pull_down_pop_type"), "0")) {
                            C1749ag.m3666a(notificationBuilderC1568du2, z2);
                        }
                        if ("tts".equals(C1749ag.m3658a((Object) m2843a)) && C1749ag.m3669a(m2843a)) {
                            C1749ag.m3666a(notificationBuilderC1568du2, z2);
                        }
                    }
                    String str11 = m2843a.get("background_color");
                    if (!TextUtils.isEmpty(str11)) {
                        try {
                            int parseInt = Integer.parseInt(str11);
                            notificationBuilderC1568du2.setOngoing(true);
                            notificationBuilderC1568du2.setColor(parseInt);
                            C1488av.m1568a((Object) notificationBuilderC1568du2, "setColorized", true);
                        } catch (Exception e) {
                            AbstractC1417b.m1093a(e);
                        }
                    }
                } else {
                    str2 = "com.xiaomi.xmsf";
                    z6 = z3;
                    if (m2843a != null && Build.VERSION.SDK_INT < 26) {
                        C1488av.m1568a((Object) notificationBuilderC1568du2, "setPriority", Integer.valueOf(m4087c(m2843a)));
                    }
                }
                if (str != null) {
                    if (!z6) {
                        str = C1746ad.m3596a().m3610a(context, notificationBuilderC1568du2, str);
                    }
                    C1488av.m1568a((Object) notificationBuilderC1568du2, "setGroup", str);
                }
                if (C1694j.m3435c() && str2.equals(context.getPackageName())) {
                    C1488av.m1570a("miui.util.NotificationHelper", "setTargetPkg", context, notificationBuilderC1568du2, m4057a(c1656ha));
                }
                notification = notificationBuilderC1568du2.getNotification();
                if (z5 && C1694j.m3426a()) {
                    m4042a(notification);
                }
                if (m2843a != null) {
                    if (notification.extras == null) {
                        notification.extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(m2843a.get("enable_keyguard"))) {
                        C1749ag.m3672b(notification, Boolean.parseBoolean(m2843a.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(m2843a.get("enable_float"))) {
                        C1749ag.m3662a(notification, Boolean.parseBoolean(m2843a.get("enable_float")));
                    }
                    if (!TextUtils.isEmpty(m2843a.get("float_small_win")) && "0".equals(m2843a.get("float_small_win")) && C1628g.m2692d(context, m4057a)) {
                        C1749ag.m3662a(notification, false);
                    }
                    int m3472a = C1703r.m3472a(m2843a.get("section_is_prr"), -1);
                    int m3472a2 = C1703r.m3472a(m2843a.get("section_prr_cl"), -1);
                    if (m3472a >= 0 && m3472a2 >= 0) {
                        C1749ag.m3660a(notification, m3472a, m3472a2);
                    }
                }
                b bVar3 = bVar;
                bVar3.f3254a = notification;
                return bVar3;
            }
        }
        z = false;
        if (m2843a != null) {
        }
        if (m4050a2 != null) {
        }
        if (m2843a == null) {
        }
        notificationBuilderC1568du2.setAutoCancel(z4);
        currentTimeMillis = System.currentTimeMillis();
        if (m2843a != null) {
            notificationBuilderC1568du2.setTicker(m2843a.get("ticker"));
        }
        if (currentTimeMillis - f3243a <= 10000) {
        }
        if (m2843a == null) {
        }
        str2 = "com.xiaomi.xmsf";
        z6 = z3;
        if (m2843a != null) {
            C1488av.m1568a((Object) notificationBuilderC1568du2, "setPriority", Integer.valueOf(m4087c(m2843a)));
        }
        if (str != null) {
        }
        if (C1694j.m3435c()) {
            C1488av.m1570a("miui.util.NotificationHelper", "setTargetPkg", context, notificationBuilderC1568du2, m4057a(c1656ha));
        }
        notification = notificationBuilderC1568du2.getNotification();
        if (z5) {
            m4042a(notification);
        }
        if (m2843a != null) {
        }
        b bVar32 = bVar;
        bVar32.f3254a = notification;
        return bVar32;
    }

    /* renamed from: b */
    private static boolean m4086b(Map<String, String> map) {
        if (map == null) {
            AbstractC1417b.m1089a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    /* renamed from: a */
    private static void m4068a(NotificationBuilderC1568du notificationBuilderC1568du, Context context, String str, C1656ha c1656ha, byte[] bArr, int i) {
        PendingIntent m4045a;
        PendingIntent m4045a2;
        PendingIntent m4045a3;
        PendingIntent m4045a4;
        Map<String, String> m2843a = c1656ha.m3010a().m2843a();
        if (TextUtils.equals("3", m2843a.get("notification_style_type")) || TextUtils.equals("4", m2843a.get("notification_style_type"))) {
            return;
        }
        if (m4086b(m2843a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = m2843a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (m4045a4 = m4045a(context, str, c1656ha, bArr, i, i2)) != null) {
                    notificationBuilderC1568du.addAction(0, str2, m4045a4);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m2843a.get("notification_style_button_left_name")) && (m4045a3 = m4045a(context, str, c1656ha, bArr, i, 1)) != null) {
            notificationBuilderC1568du.addAction(0, m2843a.get("notification_style_button_left_name"), m4045a3);
        }
        if (!TextUtils.isEmpty(m2843a.get("notification_style_button_mid_name")) && (m4045a2 = m4045a(context, str, c1656ha, bArr, i, 2)) != null) {
            notificationBuilderC1568du.addAction(0, m2843a.get("notification_style_button_mid_name"), m4045a2);
        }
        if (TextUtils.isEmpty(m2843a.get("notification_style_button_right_name")) || (m4045a = m4045a(context, str, c1656ha, bArr, i, 3)) == null) {
            return;
        }
        notificationBuilderC1568du.addAction(0, m2843a.get("notification_style_button_right_name"), m4045a);
    }

    /* renamed from: a */
    private static PendingIntent m4045a(Context context, String str, C1656ha c1656ha, byte[] bArr, int i, int i2) {
        Map<String, String> m2843a = c1656ha.m3010a().m2843a();
        if (m2843a == null) {
            return null;
        }
        boolean m4069a = m4069a(context, c1656ha, str);
        if (m4069a) {
            return m4044a(context, c1656ha, str, bArr, i, i2, m4069a);
        }
        Intent m4047a = m4047a(context, str, m2843a, i2);
        if (m4047a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, m4047a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, m4047a, 134217728);
    }

    /* renamed from: a */
    public static String m4058a(Map<String, String> map, int i) {
        String format;
        if (i == 0) {
            format = "notify_effect";
        } else {
            format = m4086b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    /* renamed from: a */
    public static Intent m4047a(Context context, String str, Map<String, String> map, int i) {
        if (m4086b(map)) {
            return m4048a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i == 1) {
            return m4048a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i == 2) {
            return m4048a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i == 3) {
            return m4048a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i != 4) {
            return null;
        }
        return m4048a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x010d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent m4048a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent intent;
        Intent intent2;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (AbstractC1756an.f3041a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e) {
                AbstractC1417b.m1103d("Cause: " + e.getMessage());
            }
        } else {
            if (AbstractC1756an.f3042b.equals(str6)) {
                if (map.containsKey(str3)) {
                    String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent2 = Intent.parseUri(str7, 1);
                        } catch (URISyntaxException e2) {
                            e = e2;
                            intent2 = null;
                        }
                        try {
                            intent2.setPackage(str);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            AbstractC1417b.m1103d("Cause: " + e.getMessage());
                            launchIntentForPackage = intent2;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey(str4)) {
                    String str8 = map.get(str4);
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, str8));
                }
                launchIntentForPackage = null;
            } else {
                if (AbstractC1756an.f3043c.equals(str6)) {
                    String str9 = map.get(str5);
                    if (!TextUtils.isEmpty(str9)) {
                        String trim = str9.trim();
                        if (!trim.startsWith(ResManager.HTTP_SCHEME) && !trim.startsWith("https://")) {
                            trim = ResManager.HTTP_SCHEME + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if (ImageDelegate.HTTP_PREFIX.equals(protocol) || "https".equals(protocol)) {
                                intent = new Intent("android.intent.action.VIEW");
                                try {
                                    intent.setData(Uri.parse(trim));
                                    C1749ag.m3663a(context, str, intent);
                                } catch (MalformedURLException e4) {
                                    e = e4;
                                    AbstractC1417b.m1103d("Cause: " + e.getMessage());
                                    launchIntentForPackage = intent;
                                    if (launchIntentForPackage != null) {
                                    }
                                    return null;
                                }
                            }
                        } catch (MalformedURLException e5) {
                            e = e5;
                            intent = null;
                        }
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(C0968C.ENCODING_PCM_MU_LAW);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !C1694j.m3427a(context) && AbstractC1756an.f3043c.equals(str6)) {
                    return launchIntentForPackage;
                }
                AbstractC1417b.m1089a("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (Exception e6) {
                AbstractC1417b.m1103d("Cause: " + e6.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    private static NotificationBuilderC1568du m4053a(Context context, C1656ha c1656ha, byte[] bArr, String str, int i) {
        PendingIntent m4045a;
        String m4057a = m4057a(c1656ha);
        Map<String, String> m2843a = c1656ha.m3010a().m2843a();
        String str2 = m2843a.get("notification_style_type");
        NotificationBuilderC1568du m3574a = (!C1694j.m3427a(context) || f3244a == null) ? null : f3244a.m3574a(context, i, m4057a, m2843a);
        if (m3574a != null) {
            m3574a.mo2297a(m2843a);
            return m3574a;
        }
        if ("2".equals(str2)) {
            NotificationBuilderC1568du notificationBuilderC1568du = new NotificationBuilderC1568du(context);
            Bitmap m4050a = TextUtils.isEmpty(m2843a.get("notification_bigPic_uri")) ? null : m4050a(context, m2843a.get("notification_bigPic_uri"), false);
            if (m4050a == null) {
                AbstractC1417b.m1089a("can not get big picture.");
                return notificationBuilderC1568du;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(notificationBuilderC1568du);
            bigPictureStyle.bigPicture(m4050a);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            notificationBuilderC1568du.setStyle(bigPictureStyle);
            return notificationBuilderC1568du;
        }
        if (PushClient.DEFAULT_REQUEST_ID.equals(str2)) {
            NotificationBuilderC1568du notificationBuilderC1568du2 = new NotificationBuilderC1568du(context);
            notificationBuilderC1568du2.setStyle(new Notification.BigTextStyle().bigText(str));
            return notificationBuilderC1568du2;
        }
        if ("4".equals(str2) && C1694j.m3426a()) {
            NotificationBuilderC1567dt notificationBuilderC1567dt = new NotificationBuilderC1567dt(context, m4057a);
            if (!TextUtils.isEmpty(m2843a.get("notification_banner_image_uri"))) {
                notificationBuilderC1567dt.setLargeIcon(m4050a(context, m2843a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m2843a.get("notification_banner_icon_uri"))) {
                notificationBuilderC1567dt.m2290b(m4050a(context, m2843a.get("notification_banner_icon_uri"), false));
            }
            notificationBuilderC1567dt.mo2297a(m2843a);
            return notificationBuilderC1567dt;
        }
        if ("3".equals(str2) && C1694j.m3426a()) {
            NotificationBuilderC1569dv notificationBuilderC1569dv = new NotificationBuilderC1569dv(context, i, m4057a);
            if (!TextUtils.isEmpty(m2843a.get("notification_colorful_button_text")) && (m4045a = m4045a(context, m4057a, c1656ha, bArr, i, 4)) != null) {
                notificationBuilderC1569dv.m2300a(m2843a.get("notification_colorful_button_text"), m4045a).mo2286a(m2843a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m2843a.get("notification_colorful_bg_color"))) {
                notificationBuilderC1569dv.m2301b(m2843a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m2843a.get("notification_colorful_bg_image_uri"))) {
                notificationBuilderC1569dv.setLargeIcon(m4050a(context, m2843a.get("notification_colorful_bg_image_uri"), false));
            }
            notificationBuilderC1569dv.mo2297a(m2843a);
            return notificationBuilderC1569dv;
        }
        return new NotificationBuilderC1568du(context);
    }

    /* renamed from: a */
    private static int m4041a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static RemoteViews m4052a(Context context, C1656ha c1656ha, byte[] bArr) {
        C1646gr m3010a = c1656ha.m3010a();
        String m4057a = m4057a(c1656ha);
        if (m3010a != null && m3010a.m2843a() != null) {
            Map<String, String> m2843a = m3010a.m2843a();
            String str = m2843a.get("layout_name");
            String str2 = m2843a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(m4057a);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", m4057a);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(m4057a, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has(PropsConstants.TEXT)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(PropsConstants.TEXT);
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", m4057a);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has(LynxMemoryInfo.TYPE_IMAGE)) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject(LynxMemoryInfo.TYPE_IMAGE);
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", m4057a);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", m4057a);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has(OaidModel.KEY_TIME)) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(OaidModel.KEY_TIME);
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", m4057a);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        AbstractC1417b.m1093a(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    AbstractC1417b.m1093a(e2);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Bitmap m4049a(Context context, int i) {
        return m4051a(context.getResources().getDrawable(i));
    }

    /* renamed from: b */
    private static int m4077b(Context context, String str) {
        int m4039a = m4039a(context, str, "mipush_notification");
        int m4039a2 = m4039a(context, str, "mipush_small_notification");
        if (m4039a <= 0) {
            m4039a = m4039a2 > 0 ? m4039a2 : context.getApplicationInfo().icon;
        }
        return m4039a == 0 ? context.getApplicationInfo().logo : m4039a;
    }

    /* renamed from: a */
    private static int m4039a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    /* renamed from: a */
    public static Bitmap m4051a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private static Notification m4042a(Notification notification) {
        Object m1567a = C1488av.m1567a(notification, "extraNotification");
        if (m1567a != null) {
            C1488av.m1568a(m1567a, "setCustomizedIcon", true);
        }
        return notification;
    }

    /* renamed from: a */
    public static String m4057a(C1656ha c1656ha) {
        C1646gr m3010a;
        if ("com.xiaomi.xmsf".equals(c1656ha.f2444b) && (m3010a = c1656ha.m3010a()) != null && m3010a.m2843a() != null) {
            String str = m3010a.m2843a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return c1656ha.f2444b;
    }

    /* renamed from: a */
    public static void m4061a(Context context, String str) {
        m4062a(context, str, -1);
    }

    /* renamed from: a */
    public static void m4062a(Context context, String str, int i) {
        m4063a(context, str, i, -1);
    }

    /* renamed from: a */
    public static void m4063a(Context context, String str, int i, int i2) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        C1748af m3625a = C1748af.m3625a(context, str);
        List<StatusBarNotification> m3648b = m3625a.m3648b();
        if (C1703r.m3475a(m3648b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            z = true;
            hashCode = 0;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it = m3648b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    m3625a.m3642a(id);
                } else if (hashCode == id) {
                    C1775d.m3826a(context, next, i2);
                    linkedList.add(next);
                    m3625a.m3642a(id);
                    break;
                }
            }
        }
        m4066a(context, (LinkedList<? extends Object>) linkedList);
    }

    /* renamed from: b */
    public static void m4081b(Context context, String str) {
        if (!C1694j.m3427a(context) || f3244a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f3244a.m3576a(str);
    }

    /* renamed from: a */
    public static void m4065a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        C1748af m3625a = C1748af.m3625a(context, str);
        List<StatusBarNotification> m3648b = m3625a.m3648b();
        if (C1703r.m3475a(m3648b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m3648b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String m3657a = C1749ag.m3657a(notification);
                String m3671b = C1749ag.m3671b(notification);
                if (!TextUtils.isEmpty(m3657a) && !TextUtils.isEmpty(m3671b) && m4074a(m3657a, str2) && m4074a(m3671b, str3)) {
                    linkedList.add(statusBarNotification);
                    m3625a.m3642a(id);
                }
            }
        }
        m4066a(context, (LinkedList<? extends Object>) linkedList);
    }

    /* renamed from: a */
    private static boolean m4074a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a */
    public static void m4066a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        C1768az.m3793a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    /* renamed from: a */
    static int m4038a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m4088c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m4084b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m4082b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: a */
    public static boolean m4075a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return PushClient.DEFAULT_REQUEST_ID.equals(map.get("notify_foreground"));
    }

    /* renamed from: a */
    private static boolean m4072a(C1646gr c1646gr) {
        if (c1646gr == null) {
            return false;
        }
        String m2842a = c1646gr.m2842a();
        return !TextUtils.isEmpty(m2842a) && m2842a.length() == 22 && "satuigmo".indexOf(m2842a.charAt(0)) >= 0;
    }

    /* renamed from: a */
    public static boolean m4073a(C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        return m4072a(m3010a) && m3010a.m2875l();
    }

    /* renamed from: b */
    public static boolean m4085b(C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        return m4072a(m3010a) && m3010a.f2283b == 1 && !m4073a(c1656ha);
    }

    /* renamed from: c */
    public static boolean m4089c(C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        return m4072a(m3010a) && m3010a.f2283b == 0 && !m4073a(c1656ha);
    }

    /* renamed from: d */
    public static boolean m4090d(C1656ha c1656ha) {
        return c1656ha.m3009a() == EnumC1633ge.Registration;
    }

    /* renamed from: e */
    public static boolean m4091e(C1656ha c1656ha) {
        return m4073a(c1656ha) || m4089c(c1656ha) || m4085b(c1656ha);
    }

    /* renamed from: b */
    public static String m4080b(C1656ha c1656ha) {
        return m4073a(c1656ha) ? "E100002" : m4089c(c1656ha) ? "E100000" : m4085b(c1656ha) ? "E100001" : m4090d(c1656ha) ? "E100003" : "";
    }

    /* renamed from: a */
    private static Bitmap m4050a(Context context, String str, boolean z) {
        Future submit = f3246a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (ExecutionException e) {
                    AbstractC1417b.m1093a(e);
                    submit.cancel(true);
                    return null;
                }
            } catch (InterruptedException e2) {
                AbstractC1417b.m1093a(e2);
                submit.cancel(true);
                return null;
            } catch (TimeoutException e3) {
                AbstractC1417b.m1093a(e3);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.x$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a implements Callable<Bitmap> {

        /* renamed from: a */
        private Context f3250a;

        /* renamed from: a */
        private String f3251a;

        /* renamed from: a */
        private boolean f3252a;

        public a(String str, Context context, boolean z) {
            this.f3250a = context;
            this.f3251a = str;
            this.f3252a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            if (!TextUtils.isEmpty(this.f3251a)) {
                if (this.f3251a.startsWith(ImageDelegate.HTTP_PREFIX)) {
                    C1747ae.b m3615a = C1747ae.m3615a(this.f3250a, this.f3251a, this.f3252a);
                    if (m3615a != null) {
                        return m3615a.f2952a;
                    }
                    AbstractC1417b.m1089a("Failed get online picture/icon resource");
                    return null;
                }
                Bitmap m3613a = C1747ae.m3613a(this.f3250a, this.f3251a);
                if (m3613a != null) {
                    return m3613a;
                }
                AbstractC1417b.m1089a("Failed get online picture/icon resource");
                return m3613a;
            }
            AbstractC1417b.m1089a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    /* renamed from: a */
    private static String m4056a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return C1628g.m2689b(context, str);
    }

    /* renamed from: b */
    private static int m4078b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            AbstractC1417b.m1101c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            AbstractC1417b.m1103d("parsing channel importance error: " + e);
            return 3;
        }
    }

    /* renamed from: c */
    private static int m4087c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            AbstractC1417b.m1101c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            AbstractC1417b.m1103d("parsing notification priority error: " + e);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0147  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent m4079b(Context context, String str, Map<String, String> map, int i) {
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        Intent intent2;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return m4047a(context, str, map, i);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        String str4 = map.get("intent_flag");
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(str4)) {
                i2 = Integer.parseInt(str4);
            }
        } catch (NumberFormatException e) {
            AbstractC1417b.m1103d("Cause by intent_flag: " + e.getMessage());
        }
        if (AbstractC1756an.f3041a.equals(str3)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                AbstractC1417b.m1103d("Cause: " + e2.getMessage());
            }
        } else {
            if (AbstractC1756an.f3042b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str5 = map.get("intent_uri");
                    if (str5 != null) {
                        try {
                            intent2 = Intent.parseUri(str5, 1);
                            try {
                                intent2.setPackage(str);
                            } catch (URISyntaxException e3) {
                                e = e3;
                                AbstractC1417b.m1103d("Cause: " + e.getMessage());
                                launchIntentForPackage = intent2;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        } catch (URISyntaxException e4) {
                            e = e4;
                            intent2 = null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey("class_name")) {
                    String str6 = map.get("class_name");
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, str6));
                }
                launchIntentForPackage = null;
            } else {
                if (AbstractC1756an.f3043c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    if (!trim.startsWith(ResManager.HTTP_SCHEME) && !trim.startsWith("https://")) {
                        trim = ResManager.HTTP_SCHEME + trim;
                    }
                    try {
                        String protocol = new URL(trim).getProtocol();
                        if (ImageDelegate.HTTP_PREFIX.equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(trim));
                                C1749ag.m3663a(context, str, intent);
                            } catch (MalformedURLException e5) {
                                e = e5;
                                AbstractC1417b.m1103d("Cause: " + e.getMessage());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        }
                    } catch (MalformedURLException e6) {
                        e = e6;
                        intent = null;
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            if (i2 >= 0) {
                launchIntentForPackage.setFlags(i2);
            }
            m4067a(launchIntentForPackage);
            launchIntentForPackage.addFlags(C0968C.ENCODING_PCM_MU_LAW);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !C1694j.m3427a(context) && AbstractC1756an.f3043c.equals(str3)) {
                    return launchIntentForPackage;
                }
                AbstractC1417b.m1089a("not resolve activity:" + launchIntentForPackage);
            } catch (Exception e7) {
                AbstractC1417b.m1103d("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m4067a(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setFlags(intent.getFlags() & (-2) & (-3) & (-65) & (-129));
    }

    /* renamed from: a */
    private static void m4064a(Context context, String str, NotificationBuilderC1568du notificationBuilderC1568du, Map<String, String> map) {
        int m4039a = m4039a(context, str, "mipush_small_notification");
        int m4039a2 = m4039a(context, str, "mipush_notification");
        if (C1694j.m3427a(context)) {
            if (m4039a > 0 && m4039a2 > 0) {
                notificationBuilderC1568du.setSmallIcon(m4039a);
                notificationBuilderC1568du.setLargeIcon(m4049a(context, m4039a2));
                return;
            } else {
                m4083b(context, str, notificationBuilderC1568du, map);
                return;
            }
        }
        if (m4039a > 0) {
            notificationBuilderC1568du.setSmallIcon(m4039a);
        } else {
            m4083b(context, str, notificationBuilderC1568du, map);
        }
        if (m4039a2 > 0) {
            notificationBuilderC1568du.setLargeIcon(m4049a(context, m4039a2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m4083b(Context context, String str, NotificationBuilderC1568du notificationBuilderC1568du, Map<String, String> map) {
        boolean z;
        int m4039a;
        if (!C1694j.m3427a(context)) {
            String m4059a = m4059a(map, "fcm_icon_uri");
            String m4059a2 = m4059a(map, "fcm_icon_color");
            if (!TextUtils.isEmpty(m4059a) && !TextUtils.isEmpty(m4059a2) && (m4039a = m4039a(context, str, m4059a)) > 0) {
                notificationBuilderC1568du.setSmallIcon(m4039a);
                notificationBuilderC1568du.mo2286a(m4059a2);
                z = true;
                if (z) {
                    notificationBuilderC1568du.setSmallIcon(Icon.createWithResource(str, C1749ag.m3651a(context, str)));
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }
}
