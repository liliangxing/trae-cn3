package com.xiaomi.push;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.vivo.push.PushClientConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.Map;

/* renamed from: com.xiaomi.push.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1628g {

    /* renamed from: a */
    private static a f1880a;

    /* renamed from: com.xiaomi.push.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        Map<String, String> m2693a(Context context, String str);

        /* renamed from: a */
        boolean m2694a(Context context, String str);

        /* renamed from: b */
        boolean m2695b(Context context, String str);
    }

    private static String com_xiaomi_push_g_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    /* renamed from: com.xiaomi.push.g$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a */
        private final int f1885a;

        b(int i) {
            this.f1885a = i;
        }

        /* renamed from: a */
        public int m2696a() {
            return this.f1885a;
        }
    }

    /* renamed from: a */
    public static String m2683a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a */
    public static int m2677a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m2676a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("SupportForPushVersionCode");
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static b m2681a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b m2680a;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            if (str.equals(context.getPackageName())) {
                applicationInfo = context.getApplicationInfo();
            } else {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            }
            m2680a = m2680a(context, applicationInfo);
        } catch (Throwable th) {
            AbstractC1417b.m1089a("get app op error " + th);
        }
        if (m2680a != b.UNKNOWN) {
            return m2680a;
        }
        Integer num = (Integer) C1488av.m1565a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return b.UNKNOWN;
        }
        Integer num2 = (Integer) C1488av.m1568a(context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        int i = (Integer) C1488av.m1565a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (Integer) C1488av.m1565a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        AbstractC1417b.m1098b(String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i) ? b.ALLOWED : b.NOT_ALLOWED;
        }
        return b.UNKNOWN;
    }

    /* renamed from: a */
    private static b m2680a(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        Boolean bool;
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null) {
            return b.UNKNOWN;
        }
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                if (i >= 29) {
                    systemService = C1488av.m1568a(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                bool = systemService != null ? (Boolean) C1488av.m1577b(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid)) : null;
            }
            if (bool != null) {
                return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
            }
        } catch (Exception e) {
            AbstractC1417b.m1089a("are notifications enabled error " + e);
        }
        return b.UNKNOWN;
    }

    /* renamed from: a */
    public static void m2685a(Context context, ApplicationInfo applicationInfo, boolean z) {
        Object systemService;
        int i = Build.VERSION.SDK_INT;
        if (b.ALLOWED != m2680a(context, applicationInfo)) {
            try {
                if (i >= 29) {
                    systemService = C1488av.m1568a(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    C1488av.m1577b(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z));
                }
            } catch (Exception e) {
                AbstractC1417b.m1089a("set notifications enabled error " + e);
            }
        }
    }

    /* renamed from: a */
    public static boolean m2687a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!C1694j.m3426a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = f1880a;
        return aVar != null && aVar.m2694a(context, str);
    }

    /* renamed from: b */
    public static boolean m2690b(Context context, String str) {
        a aVar = f1880a;
        return aVar != null && aVar.m2695b(context, str);
    }

    /* renamed from: c */
    public static boolean m2691c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: a */
    public static boolean m2686a(Context context) {
        String m2682a = m2682a();
        if (TextUtils.isEmpty(m2682a) || context == null) {
            return false;
        }
        return m2682a.equals(context.getPackageName());
    }

    /* renamed from: a */
    public static String m2682a() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) C1488av.m1570a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        return !TextUtils.isEmpty(str) ? str : "";
    }

    /* renamed from: b */
    public static String m2689b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    /* renamed from: a */
    private static ApplicationInfo m2678a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC1417b.m1089a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: b */
    public static int m2688b(Context context, String str) {
        ApplicationInfo m2678a = m2678a(context, str);
        if (m2678a == null) {
            return 0;
        }
        int i = m2678a.icon;
        return i == 0 ? m2678a.logo : i;
    }

    /* renamed from: a */
    public static Drawable m2679a(Context context, String str) {
        ApplicationInfo m2678a = m2678a(context, str);
        Drawable drawable = null;
        if (m2678a != null) {
            try {
                drawable = m2678a.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = m2678a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                AbstractC1417b.m1089a("get app icon drawable failed, " + e);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    /* renamed from: d */
    public static boolean m2692d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(com_xiaomi_push_g_android_provider_Settings$Secure_getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2684a(Context context, String str) {
        a aVar = f1880a;
        if (aVar == null) {
            return null;
        }
        return aVar.m2693a(context, str);
    }
}
