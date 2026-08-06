package com.apm.lite.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static int d = 1;
    private static boolean e = false;
    private static long f = -1;
    private static volatile b z;
    private int B;
    private Application g;
    private Context h;
    private String n;
    private long o;
    private String p;
    private long q;
    private String r;
    private long s;
    private String t;
    private long u;
    private String v;
    private long w;
    private List<String> i = new ArrayList();
    private List<Long> j = new ArrayList();
    private List<String> k = new ArrayList();
    private List<Long> l = new ArrayList();
    private LinkedList<a> m = new LinkedList<>();
    private boolean x = false;
    private long y = -1;
    private int A = 50;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        String a;
        String b;
        long c;

        a(String str, String str2, long j) {
            this.b = str2;
            this.c = j;
            this.a = str;
        }

        public String toString() {
            return com.apm.lite.k.b.a().format(new Date(this.c)) + " : " + this.a + ' ' + this.b;
        }
    }

    private b(Application application) {
        this.h = application;
        this.g = application;
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    private a a(String str, String str2, long j) {
        a aVar;
        if (this.m.size() >= this.A) {
            aVar = this.m.poll();
            if (aVar != null) {
                this.m.add(aVar);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, str2, j);
        this.m.add(aVar2);
        return aVar2;
    }

    private JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a() {
        e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, String str2) {
        try {
            a a2 = a(str, str2, j);
            a2.b = str2;
            a2.a = str;
            a2.c = j;
        } catch (Throwable unused) {
        }
    }

    public static int b() {
        int i = d;
        return i == 1 ? e ? 2 : 1 : i;
    }

    public static long c() {
        return f;
    }

    public static b d() {
        if (z == null) {
            synchronized (b.class) {
                if (z == null) {
                    z = new b(com.apm.lite.e.h());
                }
            }
        }
        return z;
    }

    static /* synthetic */ int g(b bVar) {
        int i = bVar.B;
        bVar.B = i + 1;
        return i;
    }

    static /* synthetic */ int l(b bVar) {
        int i = bVar.B;
        bVar.B = i - 1;
        return i;
    }

    private void m() {
        if (this.g != null) {
            this.g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.lite.runtime.a.b.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    b.this.n = activity.getClass().getName();
                    b.this.o = System.currentTimeMillis();
                    boolean unused = b.b = bundle != null;
                    boolean unused2 = b.c = true;
                    b.this.i.add(b.this.n);
                    b.this.j.add(Long.valueOf(b.this.o));
                    b bVar = b.this;
                    bVar.a(bVar.n, b.this.o, "onCreate");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    String name = activity.getClass().getName();
                    int indexOf = b.this.i.indexOf(name);
                    if (indexOf > -1 && indexOf < b.this.i.size()) {
                        b.this.i.remove(indexOf);
                        b.this.j.remove(indexOf);
                    }
                    b.this.k.add(name);
                    long currentTimeMillis = System.currentTimeMillis();
                    b.this.l.add(Long.valueOf(currentTimeMillis));
                    b.this.a(name, currentTimeMillis, DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DESTROY);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    b.this.t = activity.getClass().getName();
                    b.this.u = System.currentTimeMillis();
                    b.l(b.this);
                    if (b.this.B != 0) {
                        if (b.this.B < 0) {
                            b.this.B = 0;
                        }
                        b bVar = b.this;
                        bVar.a(bVar.t, b.this.u, WebViewContainer.EVENT_onPause);
                    }
                    b.this.x = false;
                    boolean unused = b.c = false;
                    b.this.y = SystemClock.uptimeMillis();
                    b bVar2 = b.this;
                    bVar2.a(bVar2.t, b.this.u, WebViewContainer.EVENT_onPause);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    int i;
                    b.this.r = activity.getClass().getName();
                    b.this.s = System.currentTimeMillis();
                    b.g(b.this);
                    if (!b.this.x) {
                        b.this.x = true;
                        if (b.a) {
                            boolean unused = b.a = false;
                            int unused2 = b.d = 1;
                            long unused3 = b.f = b.this.s;
                        }
                        if (b.this.r.equals(b.this.t)) {
                            if (!b.c || b.b) {
                                i = b.c ? 4 : 3;
                            }
                            int unused4 = b.d = i;
                            long unused5 = b.f = b.this.s;
                        }
                    }
                    b bVar = b.this;
                    bVar.a(bVar.r, b.this.s, "onResume");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    b.this.p = activity.getClass().getName();
                    b.this.q = System.currentTimeMillis();
                    b bVar = b.this;
                    bVar.a(bVar.p, b.this.q, "onStart");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    b.this.v = activity.getClass().getName();
                    b.this.w = System.currentTimeMillis();
                    b bVar = b.this;
                    bVar.a(bVar.v, b.this.w, "onStop");
                }
            });
        }
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.i;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.i.size(); i++) {
                try {
                    jSONArray.put(a(this.i.get(i), this.j.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.k;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.k.size(); i++) {
                try {
                    jSONArray.put(a(this.k.get(i), this.l.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public long e() {
        return SystemClock.uptimeMillis() - this.y;
    }

    public boolean f() {
        return this.x;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.n, this.o));
            jSONObject.put("last_start_activity", a(this.p, this.q));
            jSONObject.put(ActivityLifecycle.LAST_RESUME_ACTIVITY, a(this.r, this.s));
            jSONObject.put("last_pause_activity", a(this.t, this.u));
            jSONObject.put("last_stop_activity", a(this.v, this.w));
            jSONObject.put("alive_activities", n());
            jSONObject.put("finish_activities", o());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String h() {
        return String.valueOf(this.r);
    }

    public JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }
}
