package com.apm.lite.runtime.p024a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0779b;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0812b {

    /* renamed from: a */
    private static boolean f648a = true;

    /* renamed from: b */
    private static boolean f649b = false;

    /* renamed from: c */
    private static boolean f650c = false;

    /* renamed from: d */
    private static int f651d = 1;

    /* renamed from: e */
    private static boolean f652e = false;

    /* renamed from: f */
    private static long f653f = -1;

    /* renamed from: z */
    private static volatile C0812b f654z;

    /* renamed from: B */
    private int f656B;

    /* renamed from: g */
    private Application f657g;

    /* renamed from: h */
    private Context f658h;

    /* renamed from: n */
    private String f664n;

    /* renamed from: o */
    private long f665o;

    /* renamed from: p */
    private String f666p;

    /* renamed from: q */
    private long f667q;

    /* renamed from: r */
    private String f668r;

    /* renamed from: s */
    private long f669s;

    /* renamed from: t */
    private String f670t;

    /* renamed from: u */
    private long f671u;

    /* renamed from: v */
    private String f672v;

    /* renamed from: w */
    private long f673w;

    /* renamed from: i */
    private List<String> f659i = new ArrayList();

    /* renamed from: j */
    private List<Long> f660j = new ArrayList();

    /* renamed from: k */
    private List<String> f661k = new ArrayList();

    /* renamed from: l */
    private List<Long> f662l = new ArrayList();

    /* renamed from: m */
    private LinkedList<a> f663m = new LinkedList<>();

    /* renamed from: x */
    private boolean f674x = false;

    /* renamed from: y */
    private long f675y = -1;

    /* renamed from: A */
    private int f655A = 50;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.apm.lite.runtime.a.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        String f677a;

        /* renamed from: b */
        String f678b;

        /* renamed from: c */
        long f679c;

        a(String str, String str2, long j) {
            this.f678b = str2;
            this.f679c = j;
            this.f677a = str;
        }

        public String toString() {
            return C0779b.m753a().format(new Date(this.f679c)) + " : " + this.f677a + ' ' + this.f678b;
        }
    }

    private C0812b(Application application) {
        this.f658h = application;
        this.f657g = application;
        try {
            m1075m();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private a m1037a(String str, String str2, long j) {
        a aVar;
        if (this.f663m.size() >= this.f655A) {
            aVar = this.f663m.poll();
            if (aVar != null) {
                this.f663m.add(aVar);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, str2, j);
        this.f663m.add(aVar2);
        return aVar2;
    }

    /* renamed from: a */
    private JSONObject m1040a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StrategyConstants.NAME, str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m1041a() {
        f652e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1043a(String str, long j, String str2) {
        try {
            a m1037a = m1037a(str, str2, j);
            m1037a.f678b = str2;
            m1037a.f677a = str;
            m1037a.f679c = j;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static int m1046b() {
        int i = f651d;
        return i == 1 ? f652e ? 2 : 1 : i;
    }

    /* renamed from: c */
    public static long m1051c() {
        return f653f;
    }

    /* renamed from: d */
    public static C0812b m1057d() {
        if (f654z == null) {
            synchronized (C0812b.class) {
                if (f654z == null) {
                    f654z = new C0812b(C0749e.m566h());
                }
            }
        }
        return f654z;
    }

    /* renamed from: g */
    static /* synthetic */ int m1065g(C0812b c0812b) {
        int i = c0812b.f656B;
        c0812b.f656B = i + 1;
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ int m1072l(C0812b c0812b) {
        int i = c0812b.f656B;
        c0812b.f656B = i - 1;
        return i;
    }

    /* renamed from: m */
    private void m1075m() {
        if (this.f657g != null) {
            this.f657g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.lite.runtime.a.b.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    C0812b.this.f664n = activity.getClass().getName();
                    C0812b.this.f665o = System.currentTimeMillis();
                    boolean unused = C0812b.f649b = bundle != null;
                    boolean unused2 = C0812b.f650c = true;
                    C0812b.this.f659i.add(C0812b.this.f664n);
                    C0812b.this.f660j.add(Long.valueOf(C0812b.this.f665o));
                    C0812b c0812b = C0812b.this;
                    c0812b.m1043a(c0812b.f664n, C0812b.this.f665o, "onCreate");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    String name = activity.getClass().getName();
                    int indexOf = C0812b.this.f659i.indexOf(name);
                    if (indexOf > -1 && indexOf < C0812b.this.f659i.size()) {
                        C0812b.this.f659i.remove(indexOf);
                        C0812b.this.f660j.remove(indexOf);
                    }
                    C0812b.this.f661k.add(name);
                    long currentTimeMillis = System.currentTimeMillis();
                    C0812b.this.f662l.add(Long.valueOf(currentTimeMillis));
                    C0812b.this.m1043a(name, currentTimeMillis, "onDestroy");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    C0812b.this.f670t = activity.getClass().getName();
                    C0812b.this.f671u = System.currentTimeMillis();
                    C0812b.m1072l(C0812b.this);
                    if (C0812b.this.f656B != 0) {
                        if (C0812b.this.f656B < 0) {
                            C0812b.this.f656B = 0;
                        }
                        C0812b c0812b = C0812b.this;
                        c0812b.m1043a(c0812b.f670t, C0812b.this.f671u, "onPause");
                    }
                    C0812b.this.f674x = false;
                    boolean unused = C0812b.f650c = false;
                    C0812b.this.f675y = SystemClock.uptimeMillis();
                    C0812b c0812b2 = C0812b.this;
                    c0812b2.m1043a(c0812b2.f670t, C0812b.this.f671u, "onPause");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    int i;
                    C0812b.this.f668r = activity.getClass().getName();
                    C0812b.this.f669s = System.currentTimeMillis();
                    C0812b.m1065g(C0812b.this);
                    if (!C0812b.this.f674x) {
                        C0812b.this.f674x = true;
                        if (C0812b.f648a) {
                            boolean unused = C0812b.f648a = false;
                            int unused2 = C0812b.f651d = 1;
                            long unused3 = C0812b.f653f = C0812b.this.f669s;
                        }
                        if (C0812b.this.f668r.equals(C0812b.this.f670t)) {
                            if (!C0812b.f650c || C0812b.f649b) {
                                i = C0812b.f650c ? 4 : 3;
                            }
                            int unused4 = C0812b.f651d = i;
                            long unused5 = C0812b.f653f = C0812b.this.f669s;
                        }
                    }
                    C0812b c0812b = C0812b.this;
                    c0812b.m1043a(c0812b.f668r, C0812b.this.f669s, "onResume");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    C0812b.this.f666p = activity.getClass().getName();
                    C0812b.this.f667q = System.currentTimeMillis();
                    C0812b c0812b = C0812b.this;
                    c0812b.m1043a(c0812b.f666p, C0812b.this.f667q, "onStart");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    C0812b.this.f672v = activity.getClass().getName();
                    C0812b.this.f673w = System.currentTimeMillis();
                    C0812b c0812b = C0812b.this;
                    c0812b.m1043a(c0812b.f672v, C0812b.this.f673w, "onStop");
                }
            });
        }
    }

    /* renamed from: n */
    private JSONArray m1077n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f659i;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f659i.size(); i++) {
                try {
                    jSONArray.put(m1040a(this.f659i.get(i), this.f660j.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: o */
    private JSONArray m1079o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f661k;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f661k.size(); i++) {
                try {
                    jSONArray.put(m1040a(this.f661k.get(i), this.f662l.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: e */
    public long m1083e() {
        return SystemClock.uptimeMillis() - this.f675y;
    }

    /* renamed from: f */
    public boolean m1084f() {
        return this.f674x;
    }

    /* renamed from: g */
    public JSONObject m1085g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", m1040a(this.f664n, this.f665o));
            jSONObject.put("last_start_activity", m1040a(this.f666p, this.f667q));
            jSONObject.put("last_resume_activity", m1040a(this.f668r, this.f669s));
            jSONObject.put("last_pause_activity", m1040a(this.f670t, this.f671u));
            jSONObject.put("last_stop_activity", m1040a(this.f672v, this.f673w));
            jSONObject.put("alive_activities", m1077n());
            jSONObject.put("finish_activities", m1079o());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: h */
    public String m1086h() {
        return String.valueOf(this.f668r);
    }

    /* renamed from: i */
    public JSONArray m1087i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.f663m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }
}
