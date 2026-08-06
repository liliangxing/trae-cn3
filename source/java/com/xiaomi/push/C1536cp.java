package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.xiaomi.push.cp */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1536cp {

    /* renamed from: a */
    private static int f1216a;

    /* renamed from: a */
    private static int m1903a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a */
    private static SharedPreferences m1904a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* renamed from: a */
    public static void m1912a(final Context context, final String str, final boolean z, final long j, final int i, final long j2, final int i2, final String str2, final int i3) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1536cp.m1918c(context, str, z, j, i, j2, i2, str2, i3);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("DisconnectStatsSP onDisconnection exception: " + e.getMessage());
                }
            }
        });
    }

    /* renamed from: a */
    public static void m1910a(final Context context, final long j) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cp.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1536cp.m1917c(context, j);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("DisconnectStatsSP onReconnection exception: " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m1918c(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        synchronized (C1536cp.class) {
            SharedPreferences m1904a = m1904a(context);
            long j3 = m1904a.getLong("start_time_for_day", 0L);
            if (j3 == 0) {
                C1533cm.m1871a("recordDisconnection not initialized");
                return;
            }
            if (j - m1904a.getLong("last_discnt_time", 0L) < 60000) {
                C1533cm.m1871a("recordDisconnection anti-shake");
                return;
            }
            if (j - j3 < DownloadConstants.DAY) {
                int i4 = m1904a.getInt("discnt_count_in_day", 0);
                if (i4 > 100) {
                    C1533cm.m1871a("recordDisconnection count > 100 in 24H cycle,abandon.");
                    return;
                } else {
                    m1904a.edit().putInt("discnt_count_in_day", i4 + 1).apply();
                }
            } else {
                C1533cm.m1871a("recordDisconnection with the current time exceeds 24H cycle, go on.");
            }
            int i5 = m1904a.getInt("discnt_count", 0);
            if (i5 == m1904a.getInt("cnt_count", 0)) {
                m1911a(context, str, m1903a(z), j, i, j2, i2, str2, i3);
                m1904a.edit().putLong("last_discnt_time", j).putInt("discnt_count", i5 + 1).apply();
            }
            C1533cm.m1871a("recordDisconnection complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m1917c(Context context, long j) {
        synchronized (C1536cp.class) {
            SharedPreferences m1904a = m1904a(context);
            long j2 = m1904a.getLong("start_time_for_day", 0L);
            if (j2 == 0) {
                m1904a.edit().putLong("start_time_for_day", j).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
                return;
            }
            int i = m1904a.getInt("discnt_count", 0);
            int i2 = m1904a.getInt("cnt_count", 0);
            if (i > i2) {
                m1904a.edit().putInt("cnt_count", i2 + 1).putString("connected_time", m1906a(m1904a.getString("connected_time", null), j)).apply();
            }
            if (j - j2 >= DownloadConstants.DAY) {
                m1904a.edit().putLong("start_time_for_day", j).putInt("discnt_count_in_day", 0).apply();
                m1909a(context);
            } else if (i >= 10) {
                m1909a(context);
            }
        }
    }

    /* renamed from: a */
    private static void m1911a(Context context, String str, int i, long j, int i2, long j2, int i3, String str2, int i4) {
        C1533cm.m1871a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str2, Integer.valueOf(i4)));
        SharedPreferences m1904a = m1904a(context);
        String string = m1904a.getString("host", null);
        String string2 = m1904a.getString("network_state", null);
        String string3 = m1904a.getString(BaseConstants.DownloadManager.COLUMN_REASON, null);
        String string4 = m1904a.getString("ping_interval", null);
        String string5 = m1904a.getString("network_type", null);
        String string6 = m1904a.getString("wifi_digest", null);
        String string7 = m1904a.getString("connected_network_type", null);
        String string8 = m1904a.getString("disconnect_time", null);
        String string9 = m1904a.getString("xmsf_vc", null);
        String string10 = m1904a.getString("android_vc", null);
        String m1907a = m1907a(string, str);
        String m1905a = m1905a(string2, i);
        String m1905a2 = m1905a(string3, i2);
        String m1906a = m1906a(string4, j2);
        String m1905a3 = m1905a(string5, i3);
        String m1907a2 = m1907a(string6, str2);
        String m1905a4 = m1905a(string7, i4);
        String m1906a2 = m1906a(string8, j);
        m1904a.edit().putString("host", m1907a).putString("network_state", m1905a).putString(BaseConstants.DownloadManager.COLUMN_REASON, m1905a2).putString("ping_interval", m1906a).putString("network_type", m1905a3).putString("wifi_digest", m1907a2).putString("connected_network_type", m1905a4).putString("disconnect_time", m1906a2).putString("xmsf_vc", m1905a(string9, m1902a(context))).putString("android_vc", m1905a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* renamed from: a */
    private static String m1907a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = "null";
        }
        return (str == null || str.length() <= 0) ? str2 : str + ";" + str2;
    }

    /* renamed from: a */
    private static String m1905a(String str, int i) {
        return m1907a(str, String.valueOf(i));
    }

    /* renamed from: a */
    private static String m1906a(String str, long j) {
        return m1907a(str, String.valueOf(j));
    }

    /* renamed from: a */
    private static void m1909a(Context context) {
        C1533cm.m1871a("upload");
        new C1535co().m1901a(context, m1908a(context));
        m1914b(context);
    }

    /* renamed from: a */
    private static List<C1534cn> m1908a(Context context) {
        SharedPreferences m1904a = m1904a(context);
        String[] m1913a = m1913a(m1904a.getString("host", null));
        if (m1913a == null || m1913a.length <= 0) {
            AbstractC1417b.m1089a("DisconnectStatsSP Cached hosts data is empty,drop.");
            return null;
        }
        String[] m1913a2 = m1913a(m1904a.getString("network_state", null));
        String[] m1913a3 = m1913a(m1904a.getString(BaseConstants.DownloadManager.COLUMN_REASON, null));
        String[] m1913a4 = m1913a(m1904a.getString("ping_interval", null));
        String[] m1913a5 = m1913a(m1904a.getString("network_type", null));
        String[] m1913a6 = m1913a(m1904a.getString("wifi_digest", null));
        String[] m1913a7 = m1913a(m1904a.getString("connected_network_type", null));
        String[] m1913a8 = m1913a(m1904a.getString("disconnect_time", null));
        String[] m1913a9 = m1913a(m1904a.getString("connected_time", null));
        String[] m1913a10 = m1913a(m1904a.getString("xmsf_vc", null));
        String[] m1913a11 = m1913a(m1904a.getString("android_vc", null));
        if (m1913a2 != null && m1913a3 != null && m1913a4 != null && m1913a5 != null && m1913a6 != null && m1913a7 != null && m1913a8 != null && m1913a9 != null && m1913a10 != null && m1913a11 != null && m1913a.length == m1913a2.length && m1913a.length == m1913a3.length && m1913a.length == m1913a4.length && m1913a.length == m1913a5.length && m1913a.length == m1913a6.length && m1913a.length == m1913a7.length && m1913a.length == m1913a8.length && m1913a.length == m1913a9.length && m1913a.length == m1913a10.length && m1913a.length == m1913a11.length) {
            ArrayList arrayList = new ArrayList(m1913a.length);
            int i = 0;
            while (i < m1913a.length) {
                C1534cn c1534cn = new C1534cn();
                c1534cn.m1878a(1);
                c1534cn.m1880a(m1913a[i]);
                c1534cn.m1884b(C1703r.m3472a(m1913a2[i], -1));
                c1534cn.m1889c(C1703r.m3472a(m1913a3[i], -1));
                String[] strArr = m1913a2;
                String[] strArr2 = m1913a;
                ArrayList arrayList2 = arrayList;
                c1534cn.m1879a(C1703r.m3473a(m1913a4[i], -1L));
                c1534cn.m1893d(C1703r.m3472a(m1913a5[i], -1));
                c1534cn.m1886b(m1913a6[i]);
                c1534cn.m1896e(C1703r.m3472a(m1913a7[i], -1));
                long m3473a = C1703r.m3473a(m1913a8[i], -1L);
                long m3473a2 = C1703r.m3473a(m1913a9[i], -1L);
                c1534cn.m1885b(m3473a2 - m3473a);
                c1534cn.m1890c(m3473a);
                c1534cn.m1894d(m3473a2);
                c1534cn.m1898f(C1703r.m3472a(m1913a10[i], -1));
                c1534cn.m1900g(C1703r.m3472a(m1913a11[i], -1));
                arrayList2.add(c1534cn);
                i++;
                m1913a2 = strArr;
                arrayList = arrayList2;
                m1913a4 = m1913a4;
                m1913a3 = m1913a3;
                m1913a = strArr2;
                m1913a5 = m1913a5;
            }
            return arrayList;
        }
        AbstractC1417b.m1089a("DisconnectStatsSP Cached data incorrect,drop.");
        return null;
    }

    /* renamed from: a */
    private static String[] m1913a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    /* renamed from: b */
    private static void m1914b(Context context) {
        C1533cm.m1871a("resetAfterUpload");
        m1904a(context).edit().putString("host", null).putString("network_state", null).putString(BaseConstants.DownloadManager.COLUMN_REASON, null).putString("ping_interval", null).putString("network_type", null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    /* renamed from: a */
    private static int m1902a(Context context) {
        if (f1216a <= 0) {
            f1216a = C1694j.m3429b(context);
        }
        return f1216a;
    }
}
