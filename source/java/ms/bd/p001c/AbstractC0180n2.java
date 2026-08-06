package ms.bd.p001c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ms.bd.c.n2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0180n2 {

    /* renamed from: a */
    public static volatile long f264a;

    /* renamed from: b */
    public static volatile long f265b;

    /* renamed from: c */
    public static volatile long f266c;

    /* renamed from: d */
    public static volatile boolean f267d;

    /* renamed from: e */
    public static final ConcurrentHashMap f268e = new ConcurrentHashMap();

    /* renamed from: f */
    public static final C0158j2 f269f = new C0158j2();

    /* renamed from: a */
    public static void m155a(final Context context, final AbstractC0116c2 abstractC0116c2, final String str) {
        new Thread(new Runnable() { // from class: ms.bd.c.n2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC0180n2.m157b(context, abstractC0116c2, str);
            }
        }).start();
    }

    /* renamed from: b */
    public static void m157b(Context context, AbstractC0116c2 abstractC0116c2, String str) {
        String str2;
        if (!C0225w2.f450d) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format(Locale.US, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "5a1d10", new byte[]{107, 115, 80, 31, 13, 104, 115, 68, 47, 55, 41, 103, 78, 25, 0, 34}), Integer.valueOf(Process.myPid()))));
                str2 = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str2 = null;
            }
            if (str2 == null ? false : str2.equals(context.getPackageName())) {
                C0225w2.f449c = new C0225w2();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(C0225w2.f447a);
                intentFilter.addAction(C0225w2.f448b);
                LocalBroadcastManager.getInstance(context).registerReceiver(C0225w2.f449c, intentFilter);
                C0225w2.f450d = true;
            }
        }
        if (C0216u3.f411f == null) {
            synchronized (C0216u3.class) {
                if (C0216u3.f411f == null) {
                    C0216u3.f411f = new C0216u3(context);
                }
            }
        }
        C0216u3.f411f.m195a();
        C0221v3.m202a(context).m203a();
        int i = AbstractC0177n.f246a;
        new Thread(new RunnableC0172m()).start();
        while (abstractC0116c2.mFetchedDidIntf != null) {
            String str3 = abstractC0116c2.mDeviceID;
            if (str3 != null && !str3.isEmpty()) {
                return;
            }
            String fetchedDid = abstractC0116c2.mFetchedDidIntf.fetchedDid();
            if (fetchedDid != null && !fetchedDid.isEmpty()) {
                Object m166a = AbstractC0190p2.m166a(67108866, 0, 0L, str, null);
                if (m166a != null) {
                    String str4 = abstractC0116c2.mDeviceID;
                    if (str4 == null || str4.isEmpty()) {
                        abstractC0116c2.setFetchedDid(fetchedDid);
                        AbstractC0190p2.m166a(33554446, 0, ((Long) m166a).longValue(), fetchedDid, 0);
                        return;
                    }
                    return;
                }
            } else {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused3) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized C0164k2 m153a(String str) {
        synchronized (AbstractC0180n2.class) {
            if (str == null) {
                throw new NullPointerException("appID must be set");
            }
            if (!f267d) {
                return null;
            }
            Object m166a = AbstractC0190p2.m166a(67108866, 0, 0L, null, null);
            if (m166a == null) {
                return null;
            }
            AbstractC0116c2 abstractC0116c2 = (AbstractC0116c2) f268e.get(str);
            if (abstractC0116c2 == null) {
                return null;
            }
            return new C0164k2(abstractC0116c2, C0122d2.f158b.f159a, ((Long) m166a).longValue());
        }
    }

    /* renamed from: a */
    public static synchronized boolean m156a(Context context, AbstractC0116c2 abstractC0116c2) {
        synchronized (AbstractC0180n2.class) {
            if (context == null) {
                throw new NullPointerException("context could not be null");
            }
            if (abstractC0116c2 == null) {
                throw new NullPointerException("config could not be null");
            }
            String str = abstractC0116c2.mAppID;
            String str2 = (str == null || str.length() <= 0) ? abstractC0116c2.mSDKID : abstractC0116c2.mAppID;
            if (str2 == null || str2.length() <= 0) {
                throw new NullPointerException("appID must be set");
            }
            String str3 = abstractC0116c2.mAdvanceInfo.get("kSt");
            if (str3 != null) {
                str3.equals("1");
            }
            m154a(context, "metasec_ml");
            ConcurrentHashMap concurrentHashMap = f268e;
            if (concurrentHashMap.containsKey(str2)) {
                return false;
            }
            if (!abstractC0116c2.mDefaultReportHost.isEmpty()) {
                AbstractC0190p2.m166a(33554449, 0, 0L, abstractC0116c2.mDefaultReportHost, null);
            }
            String nativeValue = abstractC0116c2.toNativeValue();
            long nanoTime = System.nanoTime() / 1000;
            boolean booleanValue = ((Boolean) AbstractC0190p2.m166a(67108865, 0, 0L, nativeValue, null)).booleanValue();
            f265b = (System.nanoTime() / 1000) - nanoTime;
            if (!booleanValue) {
                return false;
            }
            concurrentHashMap.put(str2, abstractC0116c2);
            m155a(context, abstractC0116c2, str2);
            return true;
        }
    }

    /* renamed from: a */
    public static synchronized void m154a(Context context, String str) {
        synchronized (AbstractC0180n2.class) {
            if (!f267d) {
                long nanoTime = System.nanoTime() / 1000;
                Context applicationContext = context.getApplicationContext();
                C0122d2.f158b.f159a = applicationContext != null ? applicationContext.getApplicationContext() : null;
                f269f.f199a.set(1);
                AbstractC0141g3.m123a(applicationContext, str);
                f266c = System.currentTimeMillis() - nanoTime;
                AbstractC0190p2.m166a(16777219, 0, 0L, null, applicationContext);
                f264a = (System.nanoTime() / 1000) - nanoTime;
                f267d = true;
            }
        }
    }
}
