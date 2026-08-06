package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.p005a.C0668c;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.e.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0699f {

    /* renamed from: a */
    private static final String f285a = "f";

    /* renamed from: b */
    private static int f286b;

    /* renamed from: c */
    private static Map<String, C0698e> f287c = new HashMap();

    /* renamed from: d */
    private static List<C0698e> f288d = new ArrayList();

    /* renamed from: e */
    private static C0698e f289e = null;

    /* renamed from: a */
    public static synchronized C0698e m328a(String str) {
        C0698e c0698e;
        synchronized (C0699f.class) {
            try {
                c0698e = f287c.containsKey(str) ? f287c.get(str) : null;
                if (c0698e == null) {
                    c0698e = new C0698e(str);
                    f287c.put(str, c0698e);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0698e(str);
            }
        }
        return c0698e;
    }

    /* renamed from: a */
    public static void m330a(Context context, String str) {
        C0668c.m171a(context, str);
    }

    /* renamed from: a */
    public static synchronized void m331a(String str, JSONObject jSONObject, String str2) {
        synchronized (C0699f.class) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (f287c.containsKey(str)) {
                f287c.get(str).m327g(str2);
                return;
            }
            if (f288d.size() > 0) {
                for (C0698e c0698e : f288d) {
                    if (c0698e.m318a() != null && c0698e.m318a().equals(str) && jSONObject != null) {
                        jSONObject.remove(Constants.KEY_DATA);
                        c0698e.m327g(jSONObject.toString());
                        c0698e.m327g(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m332b(Context context) {
        if (context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (C0699f.class) {
                C0698e c0698e = f289e;
                if (c0698e != null) {
                    arrayList.add(c0698e.toString());
                    f289e = null;
                }
                Iterator<C0698e> it = f288d.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toString());
                }
                f286b = 0;
                f288d.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            C0668c.m172a(context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static synchronized void m333b(String str) {
        synchronized (C0699f.class) {
            try {
                if (f287c.containsKey(str)) {
                    C0698e c0698e = f287c.get(str);
                    f289e = c0698e;
                    c0698e.m322b();
                    f287c.remove(str);
                }
            } finally {
            }
        }
    }

    /* renamed from: b */
    public static void m334b(String str, JSONObject jSONObject, String str2) {
        try {
            int optInt = jSONObject.optInt(StrategyConstants.RESULT);
            String optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            if (optInt == 0) {
                m328a(str).m316a(optInt).m325e(optString);
            } else {
                m328a(str).m316a(optInt).m325e(optString).m324d(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m335c(String str) {
        try {
            synchronized (C0699f.class) {
                if (f287c.containsKey(str)) {
                    C0698e c0698e = f287c.get(str);
                    c0698e.m322b();
                    f288d.add(c0698e);
                    f287c.remove(str);
                }
                if (f286b != 1 && !f288d.isEmpty()) {
                    f286b = 1;
                    new Timer().schedule(new TimerTask() { // from class: cn.com.chinatelecom.account.api.e.f.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            C0699f.m332b(CtAuth.mContext);
                        }
                    }, 8000L);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
