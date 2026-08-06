package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes7.dex */
public class ag {
    public static final a<String, String, String> a;

    /* renamed from: a, reason: collision with other field name */
    static Boolean f974a;
    public static final a<String, String, String> b;
    public static final a<String, String, String> c;
    public static final a<String, String, String> d;
    public static final a<String, String, String> e;
    public static final a<String, String, String> f;
    public static final a<String, String, String> g;
    public static final a<String, String, String> h;

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f976a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: a, reason: collision with other field name */
    private static String f975a = null;

    static {
        String str = "getNotificationSettings";
        a = new a<>(str, str, str);
        String str2 = "canSound";
        b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        e = new a<>("setShowOnKeyguard", str5, str5);
        f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        h = new a<>("setShowOngoing", str7, str7);
    }

    public static boolean a() {
        if (f974a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle m10193a = f.m10193a("com.xiaomi.xmsf", (String) null);
                if (m10193a == null || m10193a.isEmpty()) {
                    f974a = false;
                } else {
                    f974a = true;
                }
            } else {
                f974a = false;
            }
        }
        return f974a.booleanValue();
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Notification.Action[] m10168a(Notification notification) {
        Parcelable[] parcelableArray;
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static <T> T a(Notification notification, String str) {
        if (notification.extras == null) {
            return null;
        }
        try {
            return (T) notification.extras.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a, reason: collision with other method in class */
    public static void m10166a(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, int i) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    public static String c(Notification notification) {
        Object a2;
        try {
            r0 = notification.extras != null ? notification.extras.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            return (!TextUtils.isEmpty(r0) || (a2 = com.xiaomi.push.av.a(notification, "extraNotification")) == null) ? r0 : (String) com.xiaomi.push.av.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return r0;
        }
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(Object obj, String str, T t) {
        T t2;
        T t3 = null;
        try {
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("get value error " + e2);
        }
        if (obj instanceof Notification) {
            t2 = a((Notification) obj, str);
        } else if (obj instanceof Map) {
            t2 = ((Map) obj).get(str);
        } else if (obj instanceof Bundle) {
            t2 = ((Bundle) obj).get(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m9528a("not support get value from classType:" + obj);
            return t3 != null ? t : t3;
        }
        t3 = t2;
        if (t3 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, String str) {
        return com.xiaomi.push.g.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f976a));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m9528a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10167a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", RouterConstants.TRUE));
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle a2 = a(context, aVar.b, str, str2, (Bundle) null);
            if (a2 == null || !a2.containsKey(aVar.c)) {
                return -1;
            }
            return a2.getBoolean(aVar.c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Bundle a(Context context, String str, String str2) {
        try {
            return a(context, a.b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.c, z);
                a(context, aVar.a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString(WsConstants.KEY_CHANNEL_ID, str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }

    /* loaded from: classes7.dex */
    public static class a<F, S, T> {
        F a;
        S b;
        T c;

        private a(F f, S s, T t) {
            this.a = f;
            this.b = s;
            this.c = t;
        }
    }
}
