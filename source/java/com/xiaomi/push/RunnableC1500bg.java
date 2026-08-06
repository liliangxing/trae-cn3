package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.push.service.C1742a;
import com.xiaomi.push.service.C1748af;
import com.xiaomi.push.service.C1768az;
import com.xiaomi.push.service.C1770ba;
import com.xiaomi.push.service.C1777f;
import com.xiaomi.push.service.C1788q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

/* renamed from: com.xiaomi.push.bg */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RunnableC1500bg implements Runnable {
    private RunnableC1500bg() {
    }

    /* renamed from: a */
    public static void m1651a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m1658a()) {
            new Thread(new RunnableC1500bg()).start();
            aVar.m1657a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.bg$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public SharedPreferences f1068a;

        /* renamed from: a */
        private final String f1069a = "dc_job_result_time_26";

        public a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.f1068a = sharedPreferences;
            long j = sharedPreferences.getLong("dc_job_result_time_26", 0L);
            if (j <= 0 || j - System.currentTimeMillis() > 259200000) {
                this.f1068a.edit().putLong("dc_job_result_time_26", m1656a()).apply();
            }
        }

        private a() {
        }

        /* renamed from: a */
        private long m1656a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / DownloadConstants.DAY) + 1) * DownloadConstants.DAY) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a */
        public boolean m1658a() {
            return System.currentTimeMillis() - this.f1068a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        /* renamed from: a */
        public void m1657a() {
            long j = this.f1068a.getLong("dc_job_result_time_26", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (currentTimeMillis >= 0) {
                this.f1068a.edit().putLong("dc_job_result_time_26", j + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C1496bc c1496bc;
        String str;
        String str2;
        C1496bc c1496bc2;
        Iterator<Map.Entry<String, ?>> it;
        C1498be c1498be;
        C1499bf c1499bf;
        C1499bf c1499bf2;
        C1498be c1498be2;
        List<NotificationChannel> m3641a;
        String str3;
        C1498be c1498be3;
        String str4 = "mipush_";
        String str5 = "com.xiaomi.xmsf";
        final Context m3462a = C1702q.m3462a();
        if (m3462a != null) {
            C1496bc c1496bc3 = new C1496bc();
            C1495bb c1495bb = new C1495bb(50L, 1000L);
            try {
                Map<String, ?> all = C1702q.m3462a().getSharedPreferences("pref_registered_pkg_names", 0).getAll();
                if (all == null || all.isEmpty()) {
                    c1496bc = c1496bc3;
                } else {
                    c1496bc3.m1644a(all.keySet().contains("com.xiaomi.xmsf") ? r10.size() - 1 : r10.size());
                    C1499bf c1499bf3 = new C1499bf();
                    c1499bf3.put("c", c1496bc3.m1642a());
                    Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                    C1498be c1498be4 = new C1498be();
                    Iterator<Map.Entry<String, ?>> it2 = entrySet.iterator();
                    C1499bf c1499bf4 = c1499bf3;
                    C1498be c1498be5 = c1498be4;
                    while (it2.hasNext()) {
                        Map.Entry<String, ?> next = it2.next();
                        final String key = next.getKey();
                        String str6 = (String) next.getValue();
                        if (TextUtils.isEmpty(key) || str5.equals(key) || TextUtils.isEmpty(str6)) {
                            str = str4;
                            str2 = str5;
                            c1496bc2 = c1496bc3;
                            it = it2;
                            c1499bf = c1499bf4;
                            c1498be = c1498be5;
                        } else {
                            C1499bf c1499bf5 = new C1499bf();
                            c1499bf5.put("a", str6);
                            c1499bf5.put("s", (String) c1495bb.m1637a(new Callable<String>() { // from class: com.xiaomi.push.bg.1
                                @Override // java.util.concurrent.Callable
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public String call() {
                                    return String.valueOf(C1742a.m3570a(m3462a, key));
                                }
                            }));
                            if (Build.VERSION.SDK_INT < 26 || (m3641a = C1748af.m3625a(m3462a, key).m3641a()) == null || m3641a.isEmpty()) {
                                str = str4;
                                str2 = str5;
                                c1496bc2 = c1496bc3;
                                it = it2;
                                c1499bf2 = c1499bf4;
                                c1498be2 = c1498be5;
                            } else {
                                C1498be c1498be6 = new C1498be();
                                str2 = str5;
                                it = it2;
                                c1499bf2 = c1499bf4;
                                c1496bc3.m1646b(m3641a.size());
                                Iterator<NotificationChannel> it3 = m3641a.iterator();
                                while (it3.hasNext()) {
                                    final NotificationChannel next2 = it3.next();
                                    String id = next2.getId();
                                    C1499bf c1499bf6 = new C1499bf();
                                    Iterator<NotificationChannel> it4 = it3;
                                    C1496bc c1496bc4 = c1496bc3;
                                    if (id.startsWith(str4)) {
                                        c1498be3 = c1498be5;
                                        try {
                                            str3 = str4;
                                            String replace = id.replace(str4 + key + RomUtils.SEPARATOR, "");
                                            c1499bf6.put("t", 1);
                                            c1499bf6.put("c", replace);
                                        } catch (Exception e) {
                                            e = e;
                                            c1496bc = c1496bc4;
                                        }
                                    } else {
                                        str3 = str4;
                                        c1498be3 = c1498be5;
                                        if (id.startsWith("mipush|")) {
                                            String replace2 = id.replace("mipush|" + key + "|", "");
                                            c1499bf6.put("t", 2);
                                            c1499bf6.put("c", replace2);
                                        }
                                    }
                                    c1499bf6.put("s", (String) c1495bb.m1637a(new Callable() { // from class: com.xiaomi.push.bg.2
                                        @Override // java.util.concurrent.Callable
                                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                        public String call() {
                                            return String.valueOf(C1777f.m3830a(m3462a, key, next2));
                                        }
                                    }));
                                    c1498be6.put(c1499bf6);
                                    c1498be5 = c1498be3;
                                    it3 = it4;
                                    c1496bc3 = c1496bc4;
                                    str4 = str3;
                                }
                                str = str4;
                                c1496bc2 = c1496bc3;
                                c1499bf5.put("c", c1498be6);
                                c1498be2 = c1498be5;
                            }
                            c1498be2.put(c1499bf5);
                            C1499bf c1499bf7 = c1499bf2;
                            c1499bf7.put("d", c1498be2);
                            c1499bf = c1499bf7;
                            c1498be = c1498be2;
                        }
                        if (c1499bf.mo1650a() > 30720) {
                            c1496bc2.m1643a();
                            c1496bc = c1496bc2;
                            try {
                                c1496bc.m1648c(c1499bf.mo1650a());
                                m1652a(m3462a, c1499bf, c1496bc);
                                C1499bf c1499bf8 = new C1499bf();
                                c1499bf8.put("c", c1496bc.m1642a());
                                c1499bf = c1499bf8;
                                c1498be = new C1498be();
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } else {
                            c1496bc = c1496bc2;
                        }
                        c1496bc3 = c1496bc;
                        str5 = str2;
                        it2 = it;
                        str4 = str;
                        c1499bf4 = c1499bf;
                        c1498be5 = c1498be;
                    }
                    c1496bc = c1496bc3;
                    if (c1498be5.length() > 0) {
                        c1496bc.m1643a();
                        c1496bc.m1648c(c1499bf4.mo1650a());
                        m1652a(m3462a, c1499bf4, c1496bc);
                    }
                }
                e = null;
            } catch (Exception e3) {
                e = e3;
                c1496bc = c1496bc3;
            }
            m1653a(c1496bc, c1495bb, e);
        }
    }

    /* renamed from: a */
    private void m1653a(C1496bc c1496bc, C1495bb c1495bb, Exception exc) {
        HashMap hashMap = new HashMap();
        String m3957a = C1788q.m3957a(C1702q.m3462a());
        if (!TextUtils.isEmpty(m3957a)) {
            hashMap.put("uuid", m3957a);
        }
        hashMap.put("appCount", Long.valueOf(c1496bc.m1642a()));
        hashMap.put("channels", Long.valueOf(c1496bc.m1645b()));
        hashMap.put("packCount", Long.valueOf(c1496bc.m1647c()));
        hashMap.put("totalSize", Long.valueOf(c1496bc.m1649d()));
        hashMap.put("isBatch", Integer.valueOf(c1496bc.m1641a()));
        hashMap.put("maxCallTime", Long.valueOf(c1495bb.m1636a()));
        hashMap.put("minCallTime", Long.valueOf(c1495bb.m1638b()));
        hashMap.put("callAvg", Long.valueOf(c1495bb.m1639c()));
        hashMap.put("duration", Long.valueOf(c1495bb.m1640d()));
        if (exc != null) {
            hashMap.put("exception", exc.toString());
        }
        C1581eg.m2343a().mo2342a("app_switch_upload", hashMap);
    }

    /* renamed from: a */
    private void m1652a(Context context, C1499bf c1499bf, C1496bc c1496bc) {
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d("category_app_channel_info");
        c1637gi.m2742c("app_channel_info");
        c1637gi.m2738b(c1499bf.toString());
        c1637gi.m2729a(false);
        c1637gi.m2726a(1L);
        c1637gi.m2727a("xmsf_channel");
        c1637gi.m2737b(System.currentTimeMillis());
        c1637gi.m2754g("com.xiaomi.xmsf");
        c1637gi.m2749e("com.xiaomi.xmsf");
        c1637gi.m2752f(C1768az.m3791a());
        C1770ba.m3803a(context, c1637gi);
    }
}
