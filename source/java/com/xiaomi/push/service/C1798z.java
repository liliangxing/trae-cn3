package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1524cd;
import com.xiaomi.push.C1561dn;
import com.xiaomi.push.C1588en;
import com.xiaomi.push.C1589eo;
import com.xiaomi.push.C1801v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.service.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1798z {

    /* renamed from: a */
    private static final Pattern f3262a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a */
    private static long f3260a = 0;

    /* renamed from: a */
    private static ThreadPoolExecutor f3261a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static void m4095a() {
        C1561dn.a m3777a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f3261a.getActiveCount() <= 0 || currentTimeMillis - f3260a >= 1800000) && C1588en.m2403a().m2410a() && (m3777a = C1766ax.m3768a().m3777a()) != null && m3777a.m2076e() > 0) {
            f3260a = currentTimeMillis;
            m4096a(m3777a.m2065a(), true);
        }
    }

    /* renamed from: a */
    public static void m4096a(final List<String> list, final boolean z) {
        f3261a.execute(new Runnable() { // from class: com.xiaomi.push.service.z.1
            @Override // java.lang.Runnable
            public void run() {
                boolean m4099b = C1798z.m4099b("www.baidu.com:80");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m4099b = m4099b || C1798z.m4099b((String) it.next());
                    if (m4099b && !z) {
                        break;
                    }
                }
                C1589eo.m2414a(m4099b ? 1 : 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m4099b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractC1417b.m1089a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(C1524cd.m1808a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            AbstractC1417b.m1089a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            AbstractC1417b.m1103d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private static String m4094a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(UpdateDialogNewBase.TYPE);
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        C1801v.m4105a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                C1801v.m4105a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                C1801v.m4105a(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* renamed from: b */
    public static void m4098b() {
        String m4094a = m4094a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(m4094a)) {
            AbstractC1417b.m1089a("dump tcp for uid = " + Process.myUid());
            AbstractC1417b.m1089a(m4094a);
        }
        String m4094a2 = m4094a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(m4094a2)) {
            return;
        }
        AbstractC1417b.m1089a("dump tcp6 for uid = " + Process.myUid());
        AbstractC1417b.m1089a(m4094a2);
    }
}
