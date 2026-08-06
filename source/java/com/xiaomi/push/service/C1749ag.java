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
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1628g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ag */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1749ag {

    /* renamed from: a */
    public static final a<String, String, String> f2959a;

    /* renamed from: a */
    static Boolean f2960a;

    /* renamed from: b */
    public static final a<String, String, String> f2963b;

    /* renamed from: c */
    public static final a<String, String, String> f2964c;

    /* renamed from: d */
    public static final a<String, String, String> f2965d;

    /* renamed from: e */
    public static final a<String, String, String> f2966e;

    /* renamed from: f */
    public static final a<String, String, String> f2967f;

    /* renamed from: g */
    public static final a<String, String, String> f2968g;

    /* renamed from: h */
    public static final a<String, String, String> f2969h;

    /* renamed from: a */
    private static final String[] f2962a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: a */
    private static String f2961a = null;

    static {
        String str = "getNotificationSettings";
        f2959a = new a<>(str, str, str);
        String str2 = "canSound";
        f2963b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        f2964c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        f2965d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        f2966e = new a<>("setShowOnKeyguard", str5, str5);
        f2967f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        f2968g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        f2969h = new a<>("setShowOngoing", str7, str7);
    }

    /* renamed from: a */
    public static boolean m3665a() {
        if (f2960a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle m3835a = C1777f.m3835a("com.xiaomi.xmsf", (String) null);
                if (m3835a == null || m3835a.isEmpty()) {
                    f2960a = false;
                } else {
                    f2960a = true;
                }
            } else {
                f2960a = false;
            }
        }
        return f2960a.booleanValue();
    }

    /* renamed from: a */
    public static String m3657a(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: b */
    public static String m3671b(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: a */
    public static Notification.Action[] m3670a(Notification notification) {
        Parcelable[] parcelableArray;
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    /* renamed from: a */
    public static <T> T m3655a(Notification notification, String str) {
        if (notification.extras == null) {
            return null;
        }
        try {
            return (T) notification.extras.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3664a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3661a(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object m1567a = C1488av.m1567a(notification, "extraNotification");
            if (m1567a != null) {
                C1488av.m1568a(m1567a, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3662a(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object m1567a = C1488av.m1567a(notification, "extraNotification");
            if (m1567a != null) {
                C1488av.m1568a(m1567a, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m3672b(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object m1567a = C1488av.m1567a(notification, "extraNotification");
            if (m1567a != null) {
                C1488av.m1568a(m1567a, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3659a(Notification notification, int i) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object m1567a = C1488av.m1567a(notification, "extraNotification");
            if (m1567a != null) {
                C1488av.m1568a(m1567a, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3660a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* renamed from: c */
    public static String m3673c(Notification notification) {
        Object m1567a;
        try {
            r0 = notification.extras != null ? notification.extras.getString("target_package") : null;
            return (!TextUtils.isEmpty(r0) || (m1567a = C1488av.m1567a(notification, "extraNotification")) == null) ? r0 : (String) C1488av.m1568a(m1567a, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return r0;
        }
    }

    /* renamed from: a */
    public static String m3658a(Object obj) {
        return (String) m3656a(obj, "msg_busi_type", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T m3656a(Object obj, String str, T t) {
        T t2;
        T t3 = null;
        try {
        } catch (Exception e) {
            AbstractC1417b.m1089a("get value error " + e);
        }
        if (obj instanceof Notification) {
            t2 = m3655a((Notification) obj, str);
        } else if (obj instanceof Map) {
            t2 = ((Map) obj).get(str);
        } else if (obj instanceof Bundle) {
            t2 = ((Bundle) obj).get(str);
        } else {
            AbstractC1417b.m1089a("not support get value from classType:" + obj);
            return t3 != null ? t : t3;
        }
        t3 = t2;
        if (t3 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m3651a(Context context, String str) {
        return C1628g.m2688b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3663a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f2962a));
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
                } catch (Exception e) {
                    AbstractC1417b.m1089a("can't match url intent. " + e);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    /* renamed from: a */
    public static int m3650a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e) {
            AbstractC1417b.m1089a("get user aggregate failed, " + e);
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m3667a(ContentResolver contentResolver) {
        int m3650a = m3650a(contentResolver);
        return m3650a == 1 || m3650a == 2;
    }

    /* renamed from: a */
    public static boolean m3669a(Map<String, String> map) {
        return Boolean.parseBoolean((String) m3656a(map, "not_suppress", "true"));
    }

    /* renamed from: a */
    public static boolean m3666a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        AbstractC1417b.m1098b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a */
    public static int m3652a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle m3654a = m3654a(context, aVar.f2971b, str, str2, (Bundle) null);
            if (m3654a == null || !m3654a.containsKey(aVar.f2972c)) {
                return -1;
            }
            return m3654a.getBoolean(aVar.f2972c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static Bundle m3653a(Context context, String str, String str2) {
        try {
            return m3654a(context, f2959a.f2971b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m3668a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.f2972c, z);
                m3654a(context, aVar.f2970a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static Bundle m3654a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }

    /* renamed from: com.xiaomi.push.service.ag$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a<F, S, T> {

        /* renamed from: a */
        F f2970a;

        /* renamed from: b */
        S f2971b;

        /* renamed from: c */
        T f2972c;

        private a(F f, S s, T t) {
            this.f2970a = f;
            this.f2971b = s;
            this.f2972c = t;
        }
    }
}
