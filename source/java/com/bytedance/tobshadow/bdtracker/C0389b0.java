package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0453k;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.b0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0389b0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public static final C0517t0 f452a = new C0517t0(null, "@APPLOG_APP_USE");

    /* renamed from: b */
    public static boolean f453b = false;

    /* renamed from: c */
    public static int f454c;

    /* renamed from: d */
    public static C0549x4 f455d;

    /* renamed from: e */
    public static C0549x4 f456e;

    /* renamed from: f */
    public static long f457f;

    /* renamed from: g */
    public static String f458g;

    /* renamed from: h */
    public static final Map<Integer, List<C0549x4>> f459h;

    /* renamed from: i */
    public static final Map<Integer, b> f460i;

    /* renamed from: j */
    public static C0549x4 f461j;

    /* renamed from: k */
    public static final HashSet<Integer> f462k;

    /* renamed from: l */
    public static volatile C0389b0 f463l;

    /* renamed from: com.bytedance.tobshadow.bdtracker.b0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements C0453k.e {

        /* renamed from: a */
        public final /* synthetic */ C0549x4 f464a;

        public a(C0549x4 c0549x4) {
            this.f464a = c0549x4;
        }

        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            if (C0453k.f711b.mo248a(c0467m)) {
                return !this.f464a.f1239D;
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.b0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b {

        /* renamed from: a */
        public C0549x4 f465a;

        /* renamed from: b */
        public WeakReference<Object> f466b;
    }

    static {
        Arrays.asList("android.arch.lifecycle.ReportFragment", "androidx.lifecycle.ReportFragment");
        Collections.singletonList("com.bumptech.glide.manager.SupportRequestManagerFragment");
        f454c = 0;
        f459h = new HashMap();
        f460i = new ConcurrentHashMap();
        f462k = new HashSet<>(8);
        f463l = null;
    }

    /* renamed from: a */
    public static synchronized C0389b0 m278a(Application application) {
        C0389b0 c0389b0;
        synchronized (C0389b0.class) {
            if (f463l == null) {
                f463l = new C0389b0();
                application.registerActivityLifecycleCallbacks(f463l);
            }
            c0389b0 = f463l;
        }
        return c0389b0;
    }

    /* renamed from: a */
    public static C0549x4 m279a() {
        C0549x4 c0549x4 = f455d;
        C0549x4 c0549x42 = f456e;
        if (c0549x42 != null) {
            return c0549x42;
        }
        if (c0549x4 != null) {
            return c0549x4;
        }
        return null;
    }

    /* renamed from: a */
    public static C0549x4 m280a(Class<?> cls, boolean z, String str, String str2, String str3, String str4, long j, JSONObject jSONObject) {
        C0549x4 c0549x4 = new C0549x4();
        c0549x4.f1240E = cls;
        if (TextUtils.isEmpty(str2)) {
            c0549x4.f1243u = str;
        } else {
            c0549x4.f1243u = str + ":" + str2;
        }
        c0549x4.m573a(j);
        c0549x4.f1248z = j;
        c0549x4.f1241s = -1L;
        C0549x4 c0549x42 = f461j;
        c0549x4.f1242t = c0549x42 != null ? c0549x42.f1243u : "";
        if (str3 == null) {
            str3 = "";
        }
        c0549x4.f1244v = str3;
        C0549x4 c0549x43 = f461j;
        c0549x4.f1245w = c0549x43 != null ? c0549x43.f1244v : "";
        if (str4 == null) {
            str4 = "";
        }
        c0549x4.f1246x = str4;
        C0549x4 c0549x44 = f461j;
        c0549x4.f1247y = c0549x44 != null ? c0549x44.f1246x : "";
        c0549x4.f884o = jSONObject;
        c0549x4.f1239D = z;
        m282a(c0549x4, true);
        f461j = c0549x4;
        LoggerImpl.global().debug("[Navigator] resumePage page.name：{}", c0549x4.f1243u);
        return c0549x4;
    }

    /* renamed from: a */
    public static C0549x4 m281a(boolean z, C0549x4 c0549x4, long j) {
        C0549x4 c0549x42 = (C0549x4) c0549x4.m1094clone();
        c0549x42.m573a(j);
        long j2 = j - c0549x4.f872c;
        if (j2 <= 0) {
            j2 = 1000;
        }
        c0549x42.f1241s = j2;
        c0549x42.f1239D = z;
        m282a(c0549x42, false);
        LoggerImpl.global().debug("[Navigator] pausePage page.name：{}, duration：{}", c0549x42.f1243u, Long.valueOf(c0549x42.f1241s));
        return c0549x42;
    }

    /* renamed from: a */
    public static void m282a(C0549x4 c0549x4, boolean z) {
        C0453k.m495a(c0549x4, new a(c0549x4));
        if (z) {
            C0453k.m494a(new C0397c0(c0549x4), new C0405d0(c0549x4));
        } else {
            C0453k.m494a(new C0412e0(c0549x4), new C0419f0(c0549x4));
        }
    }

    /* renamed from: b */
    public static boolean m283b() {
        Iterator<C0467m> it = C0467m.f759L.iterator();
        while (it.hasNext()) {
            InitConfig initConfig = it.next().getInitConfig();
            if (initConfig != null && initConfig.isPageLeaveRefreshPropertiesEnable()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m284a(Activity activity, int i) {
        C0549x4 m280a = m280a(activity.getClass(), false, activity.getClass().getName(), "", C0515s5.m663c(activity), C0515s5.m662b(activity), System.currentTimeMillis(), C0515s5.m664d(activity));
        f455d = m280a;
        m280a.f1236A = !f462k.remove(Integer.valueOf(i)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f462k.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f462k.remove(Integer.valueOf(activity.hashCode()));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9 A[SYNTHETIC] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityPaused(Activity activity) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        f452a.m667a(currentTimeMillis);
        f453b = false;
        IAppLogLogger global = LoggerImpl.global();
        Object[] objArr = new Object[1];
        objArr[0] = activity != null ? activity.getClass().getName() : "";
        global.debug("[Navigator] onActivityPaused:{}", objArr);
        for (b bVar : f460i.values()) {
            if (bVar != null) {
                Object obj = bVar.f466b.get();
                LoggerImpl.global().debug("[Navigator] onFragPause:frag：{}", obj);
                if (obj != null) {
                    Map<Integer, b> map = f460i;
                    if (!map.isEmpty() && map.containsKey(Integer.valueOf(obj.hashCode()))) {
                        b bVar2 = map.get(Integer.valueOf(obj.hashCode()));
                        if (bVar2.f466b.get() == null) {
                            map.remove(Integer.valueOf(obj.hashCode()));
                            LoggerImpl.global().debug("[Navigator] inFragmentCache frag already recycle：{}", obj);
                        }
                        if (bVar2.f466b.get() == obj) {
                            z = true;
                            if (z) {
                                LoggerImpl.global().debug("[Navigator] onFragPause not in cache：{}", obj);
                            } else {
                                Map<Integer, b> map2 = f460i;
                                C0549x4 c0549x4 = map2.get(Integer.valueOf(obj.hashCode())).f465a;
                                map2.remove(Integer.valueOf(obj.hashCode()));
                                LoggerImpl.global().debug("[Navigator] onFragPause:page：{}", c0549x4);
                                if (c0549x4 != null) {
                                    if (m283b()) {
                                        c0549x4.f884o = C0515s5.m661a(obj, c0549x4.f884o);
                                    }
                                    m281a(true, c0549x4, System.currentTimeMillis());
                                }
                                f456e = null;
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
        }
        f460i.clear();
        if (f455d != null) {
            if (activity != null && m283b()) {
                C0549x4 c0549x42 = f455d;
                c0549x42.f884o = C0515s5.m661a(activity, c0549x42.f884o);
            }
            C0549x4 c0549x43 = f455d;
            f458g = c0549x43.f1243u;
            f457f = currentTimeMillis;
            m281a(false, c0549x43, currentTimeMillis);
            f455d = null;
            if (activity != null) {
                activity.isChild();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        f452a.m669c(currentTimeMillis);
        f453b = true;
        String m663c = C0515s5.m663c(activity);
        LoggerImpl.global().debug("[Navigator] onActivityResumed:{} {}", m663c, activity.getClass().getName());
        C0549x4 m280a = m280a(activity.getClass(), false, activity.getClass().getName(), "", m663c, C0515s5.m662b(activity), currentTimeMillis, C0515s5.m664d(activity));
        f455d = m280a;
        m280a.f1236A = !f462k.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        activity.isChild();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f454c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f458g != null) {
            int i = f454c - 1;
            f454c = i;
            if (i <= 0) {
                f458g = null;
                f457f = 0L;
                C0453k.m493a(new C0460l());
            }
        }
    }
}
