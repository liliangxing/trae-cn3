package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1638gj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: com.xiaomi.push.service.af */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1748af {

    /* renamed from: a */
    private static Context f2953a;

    /* renamed from: a */
    private static Object f2954a;

    /* renamed from: a */
    private static WeakHashMap<Integer, C1748af> f2955a = new WeakHashMap<>();

    /* renamed from: a */
    private static boolean f2956a;

    /* renamed from: a */
    private String f2957a;

    /* renamed from: b */
    private String f2958b;

    private C1748af(String str) {
        this.f2957a = str;
    }

    /* renamed from: a */
    public Context m3638a() {
        return f2953a;
    }

    /* renamed from: a */
    public String m3639a() {
        return this.f2957a;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f2957a + "}";
    }

    /* renamed from: a */
    public static C1748af m3625a(Context context, String str) {
        m3630a(context);
        int hashCode = str.hashCode();
        C1748af c1748af = f2955a.get(Integer.valueOf(hashCode));
        if (c1748af != null) {
            return c1748af;
        }
        C1748af c1748af2 = new C1748af(str);
        f2955a.put(Integer.valueOf(hashCode), c1748af2);
        return c1748af2;
    }

    /* renamed from: a */
    public static boolean m3633a(Context context) {
        m3630a(context);
        return m3632a();
    }

    /* renamed from: a */
    public static String m3628a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m3629a = m3629a("mipush|%s|%s", str2, "");
        return str.startsWith(m3629a) ? m3629a("mipush_%s_%s", str2, str.replace(m3629a, "")) : str;
    }

    /* renamed from: a */
    private static void m3630a(Context context) {
        if (f2953a == null) {
            f2953a = context.getApplicationContext();
            NotificationManager m3624a = m3624a();
            Boolean bool = (Boolean) C1488av.m1568a((Object) m3624a, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m3631a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f2956a = booleanValue;
            if (booleanValue) {
                f2954a = C1488av.m1568a((Object) m3624a, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private static NotificationManager m3624a() {
        return (NotificationManager) f2953a.getSystemService("notification");
    }

    /* renamed from: a */
    private static boolean m3632a() {
        if (C1694j.m3426a() && C1750ah.m3674a(f2953a).m3686a(EnumC1638gj.NotificationBelongToAppSwitch.m2760a(), true)) {
            return f2956a;
        }
        return false;
    }

    /* renamed from: a */
    private static int m3623a(String str) {
        try {
            return f2953a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static Object m3627a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    /* renamed from: a */
    private static <T> T m3626a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m3629a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* renamed from: b */
    public static String m3636b(String str, String str2) {
        return m3629a(m3632a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* renamed from: b */
    private String m3635b(String str) {
        return m3636b(this.f2957a, str);
    }

    /* renamed from: b */
    String m3647b() {
        if (TextUtils.isEmpty(this.f2958b)) {
            this.f2958b = m3635b(DownloadSettingKeys.BugFix.DEFAULT);
        }
        return this.f2958b;
    }

    /* renamed from: a */
    public boolean m3646a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(m3635b(""));
    }

    /* renamed from: a */
    public String m3640a(String str) {
        if (TextUtils.isEmpty(str)) {
            return m3647b();
        }
        return C1694j.m3427a(m3638a()) ? m3635b(str) : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public String m3649c(String str, String str2) {
        return m3632a() ? str : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3644a(NotificationChannel notificationChannel) {
        String str = this.f2957a;
        try {
            if (m3632a()) {
                int m3623a = m3623a(str);
                if (m3623a != -1) {
                    C1488av.m1577b(f2954a, "createNotificationChannelsForPackage", str, Integer.valueOf(m3623a), m3627a(Arrays.asList(notificationChannel)));
                }
            } else {
                m3624a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e) {
            m3631a("createNotificationChannel error" + e);
        }
    }

    /* renamed from: a */
    public NotificationChannel m3637a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m3632a()) {
                List<NotificationChannel> m3641a = m3641a();
                if (m3641a != null) {
                    for (NotificationChannel notificationChannel2 : m3641a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = m3624a().getNotificationChannel(str);
            }
        } catch (Exception e) {
            m3631a("getNotificationChannel error" + e);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* renamed from: a */
    public List<NotificationChannel> m3641a() {
        String str;
        String str2 = this.f2957a;
        List<NotificationChannel> list = null;
        try {
            if (m3632a()) {
                int m3623a = m3623a(str2);
                if (m3623a != -1) {
                    Object obj = f2954a;
                    Object[] objArr = {str2, Integer.valueOf(m3623a), false};
                    str = "mipush|%s|%s";
                    list = (List) m3626a(C1488av.m1568a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = m3624a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!C1694j.m3426a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String m3629a = m3629a(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(m3629a)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m3631a("getNotificationChannels error " + e);
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3645a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f2957a;
        try {
            if (z) {
                int m3623a = m3623a(str);
                if (m3623a != -1) {
                    C1488av.m1577b(f2954a, "updateNotificationChannelForPackage", str, Integer.valueOf(m3623a), notificationChannel);
                }
            } else {
                m3644a(notificationChannel);
            }
        } catch (Exception e) {
            m3631a("updateNotificationChannel error " + e);
        }
    }

    /* renamed from: a */
    public void m3643a(int i, Notification notification) {
        String str = this.f2957a;
        NotificationManager m3624a = m3624a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m3632a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    m3624a.notifyAsPackage(str, null, i, notification);
                } else {
                    m3624a.notify(i, notification);
                }
            } else {
                m3624a.notify(i, notification);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m3642a(int i) {
        String str = this.f2957a;
        try {
            if (m3632a()) {
                int m3377a = C1682i.m3377a();
                String packageName = m3638a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    C1488av.m1577b(f2954a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(m3377a));
                } else {
                    C1488av.m1577b(f2954a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(m3377a));
                }
                m3631a("cancel succ:" + i);
                return;
            }
            m3624a().cancel(i);
        } catch (Exception e) {
            m3631a("cancel error" + e);
        }
    }

    /* renamed from: b */
    public List<StatusBarNotification> m3648b() {
        String str = this.f2957a;
        NotificationManager m3624a = m3624a();
        List<StatusBarNotification> list = null;
        try {
            if (m3632a()) {
                int m3377a = C1682i.m3377a();
                if (m3377a != -1) {
                    list = (List) m3626a(C1488av.m1568a(f2954a, "getAppActiveNotifications", str, Integer.valueOf(m3377a)));
                }
            } else {
                StatusBarNotification[] activeNotifications = m3624a.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (str.equals(C1749ag.m3673c(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        list = arrayList;
                    } catch (Throwable th) {
                        th = th;
                        list = arrayList;
                        m3631a("getActiveNotifications error " + th);
                        return list;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return list;
    }

    /* renamed from: a */
    private StatusBarNotification[] m3634a() {
        if (!C1694j.m3427a(m3638a())) {
            return null;
        }
        try {
            Object m1568a = C1488av.m1568a(f2954a, "getActiveNotifications", m3638a().getPackageName());
            if (m1568a instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) m1568a;
            }
            return null;
        } catch (Throwable th) {
            m3631a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: a */
    static void m3631a(String str) {
        AbstractC1417b.m1089a("NMHelper:" + str);
    }
}
