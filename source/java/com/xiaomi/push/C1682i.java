package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.message.util.ToolUtils;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.push.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1682i {

    /* renamed from: a */
    private static String f2779a = null;

    /* renamed from: a */
    private static final Set<String> f2780a;

    /* renamed from: a */
    private static boolean f2781a = false;

    /* renamed from: b */
    private static String f2783b = null;

    /* renamed from: c */
    private static String f2784c = "";

    /* renamed from: d */
    private static String f2785d;

    /* renamed from: e */
    private static String f2786e;

    /* renamed from: f */
    private static final String f2787f = String.valueOf((char) 2);

    /* renamed from: a */
    private static final String[] f2782a = {"--", "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: a */
    private static double m3375a(double d) {
        int i = 1;
        while (true) {
            double d2 = i;
            if (d2 >= d) {
                return d2;
            }
            i <<= 1;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static String m3381a(Context context) {
        return null;
    }

    /* renamed from: b */
    public static String m3390b(Context context) {
        String androidId = ToolUtils.getAndroidId(context);
        f2783b = androidId;
        return androidId;
    }

    @Deprecated
    /* renamed from: c */
    public static String m3394c(Context context) {
        return null;
    }

    @Deprecated
    /* renamed from: d */
    public static String m3397d(Context context) {
        return null;
    }

    @Deprecated
    /* renamed from: e */
    public static String m3398e(Context context) {
        return null;
    }

    @Deprecated
    /* renamed from: f */
    public static String m3399f(Context context) {
        return "";
    }

    @Deprecated
    /* renamed from: j */
    private static String m3403j(Context context) {
        return "";
    }

    static {
        HashSet hashSet = new HashSet();
        f2780a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f2781a = true;
    }

    /* renamed from: a */
    private static String m3380a(int i) {
        if (i > 0) {
            String[] strArr = f2782a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f2782a[0];
    }

    /* renamed from: a */
    public static boolean m3387a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f2782a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x0017, B:11:0x001c, B:12:0x0021, B:16:0x0031, B:18:0x0037, B:21:0x003e, B:23:0x004c, B:24:0x009b, B:26:0x00ae, B:27:0x00b1, B:28:0x005f, B:30:0x006d, B:33:0x0078, B:36:0x0080, B:37:0x0086, B:39:0x00cc), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1 A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x0017, B:11:0x001c, B:12:0x0021, B:16:0x0031, B:18:0x0037, B:21:0x003e, B:23:0x004c, B:24:0x009b, B:26:0x00ae, B:27:0x00b1, B:28:0x005f, B:30:0x006d, B:33:0x0078, B:36:0x0080, B:37:0x0086, B:39:0x00cc), top: B:3:0x0005 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String m3382a(Context context, boolean z) {
        String str;
        synchronized (C1682i.class) {
            if (f2785d == null) {
                String m3390b = m3390b(context);
                String str2 = "";
                if (!C1694j.m3437d()) {
                    str2 = z ? m3394c(context) : m3403j(context);
                }
                String m3381a = m3381a(context);
                int i = 1;
                if (!(Build.VERSION.SDK_INT < 26) && m3392b(str2) && m3392b(m3381a)) {
                    String m1505b = C1479am.m1501a(context).m1505b();
                    if (!TextUtils.isEmpty(m1505b)) {
                        m3390b = m1505b + m3390b;
                        i = 2;
                    } else {
                        String mo1482a = C1479am.m1501a(context).mo1482a();
                        if (!TextUtils.isEmpty(mo1482a) && !mo1482a.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i = 4;
                            m3390b = mo1482a;
                        } else if (TextUtils.isEmpty(m3390b)) {
                            m3390b = m3404k(context);
                            i = 6;
                        } else {
                            i = 5;
                        }
                    }
                    AbstractC1417b.m1098b("devid rule select:" + i);
                    if (i != 3) {
                        f2785d = m3390b;
                    } else {
                        f2785d = m3380a(i) + C1494ba.m1634b(m3390b);
                    }
                }
                m3390b = str2 + m3390b + m3381a;
                AbstractC1417b.m1098b("devid rule select:" + i);
                if (i != 3) {
                }
            }
            str = f2785d;
        }
        return str;
    }

    /* renamed from: b */
    private static boolean m3392b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    /* renamed from: g */
    public static synchronized String m3400g(Context context) {
        synchronized (C1682i.class) {
            String str = f2786e;
            if (str != null) {
                return str;
            }
            String m1634b = C1494ba.m1634b(m3390b(context) + m3381a(context));
            f2786e = m1634b;
            return m1634b;
        }
    }

    /* renamed from: h */
    public static synchronized String m3401h(Context context) {
        String m1634b;
        synchronized (C1682i.class) {
            m1634b = C1494ba.m1634b(m3390b(context) + ((String) null));
        }
        return m1634b;
    }

    /* renamed from: i */
    public static String m3402i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    /* renamed from: a */
    public static int m3377a() {
        Object m1570a = C1488av.m1570a("android.os.UserHandle", "myUserId", new Object[0]);
        if (m1570a == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(m1570a)).intValue();
    }

    /* renamed from: a */
    public static String m3379a() {
        return m3376a(m3388b()) + "GB";
    }

    /* renamed from: b */
    public static int m3388b() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (IOException unused) {
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static float m3376a(int i) {
        float f = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d = f;
        return d > 0.5d ? (float) Math.ceil(d) : f;
    }

    /* renamed from: b */
    public static String m3389b() {
        return m3375a(((m3378a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* renamed from: a */
    private static long m3378a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: c */
    public static String m3393c() {
        return m3388b() + "KB";
    }

    /* renamed from: d */
    public static String m3396d() {
        return (m3378a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    /* renamed from: a */
    public static boolean m3385a(Context context) {
        Intent m3448a = C1696l.m3448a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (m3448a == null) {
            return false;
        }
        int intExtra = m3448a.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: b */
    public static boolean m3391b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: a */
    public static boolean m3384a() {
        return m3377a() <= 0;
    }

    /* renamed from: a */
    public static boolean m3386a(Context context, String str) {
        PackageInfo packageInfo = (PackageInfo) C1488av.m1568a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SHOULD_USE_PENALIZED));
        return packageInfo == null || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 8388608) != 8388608;
    }

    /* renamed from: c */
    private static boolean m3395c(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null && packageInfo.applicationInfo != null && packageInfo.applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.containsKey("supportGetAndroidID")) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                AbstractC1417b.m1099b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e) {
            AbstractC1417b.m1102c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && serviceInfo.metaData != null && serviceInfo.metaData.containsKey("supportGetAndroidID")) {
                AbstractC1417b.m1099b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e2) {
            AbstractC1417b.m1102c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e2.getMessage());
        }
        AbstractC1417b.m1099b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    /* renamed from: k */
    private static String m3404k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String m3405l = m3405l(context);
        m3383a(context, m3405l);
        return m3405l;
    }

    /* renamed from: a */
    private static void m3383a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            AbstractC1417b.m1089a("default_id exist,do not change it.");
        }
    }

    /* renamed from: l */
    private static String m3405l(Context context) {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.VERSION.INCREMENTAL;
        int m3377a = m3377a();
        String packageName = context.getPackageName();
        long currentTimeMillis = System.currentTimeMillis();
        String m1624a = C1494ba.m1624a(16);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(RomUtils.SEPARATOR).append(str2).append(RomUtils.SEPARATOR).append(i).append(RomUtils.SEPARATOR).append(str3).append(RomUtils.SEPARATOR).append(str4).append(RomUtils.SEPARATOR).append(m3377a).append(RomUtils.SEPARATOR).append(packageName).append(RomUtils.SEPARATOR).append(currentTimeMillis).append(RomUtils.SEPARATOR).append(m1624a);
        return C1490ax.m1585a(sb.toString());
    }
}
