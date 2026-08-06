package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class ah {
    private static volatile ah a;

    /* renamed from: a, reason: collision with other field name */
    protected SharedPreferences f977a;

    /* renamed from: a, reason: collision with other field name */
    private HashSet<a> f978a = new HashSet<>();
    protected SharedPreferences b;

    public synchronized void a(a aVar) {
        if (!this.f978a.contains(aVar)) {
            this.f978a.add(aVar);
        }
    }

    public synchronized void a() {
        this.f978a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f978a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public static ah a(Context context) {
        if (a == null) {
            synchronized (ah.class) {
                if (a == null) {
                    a = new ah(context);
                }
            }
        }
        return a;
    }

    private ah(Context context) {
        this.f977a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public void a(List<Pair<gk, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.y.a(list) || com.xiaomi.push.y.a(list2)) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f977a.edit();
        edit.clear();
        for (Pair<gk, Integer> pair : list) {
            if (pair.first != null && pair.second != null) {
                edit.putInt(a((gk) pair.first), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            if (pair2.first != null && pair2.second != null) {
                a(edit, pair2, a(((Integer) pair2.first).intValue()));
            }
        }
        edit.apply();
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.y.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                String a2 = a(((Integer) pair.first).intValue());
                if (pair.second == null) {
                    edit.remove(a2);
                } else {
                    a(edit, pair, a2);
                }
            }
        }
        edit.apply();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
            return;
        }
        if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
            return;
        }
        if (pair.second instanceof String) {
            String str2 = (String) pair.second;
            if (str.equals(a(gj.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.ax.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    public int a(int i, int i2) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getInt(a2, 0);
            }
            return this.f977a.contains(a2) ? this.f977a.getInt(a2, 0) : i2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(i + " oc int error " + e);
            return i2;
        }
    }

    public long a(int i, long j) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getLong(a2, 0L);
            }
            return this.f977a.contains(a2) ? this.f977a.getLong(a2, 0L) : j;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(i + " oc long error " + e);
            return j;
        }
    }

    public String a(int i, String str) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getString(a2, null);
            }
            return this.f977a.contains(a2) ? this.f977a.getString(a2, null) : str;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(i + " oc string error " + e);
            return str;
        }
    }

    public boolean a(int i, boolean z) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getBoolean(a2, false);
            }
            return this.f977a.contains(a2) ? this.f977a.getBoolean(a2, false) : z;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(i + " oc boolean error " + e);
            return z;
        }
    }

    public int a(gk gkVar, int i) {
        try {
            return this.f977a.getInt(a(gkVar), i);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(gkVar + " version error " + e);
            return i;
        }
    }

    private String a(int i) {
        return "oc_" + i;
    }

    private String a(gk gkVar) {
        return "oc_version_" + gkVar.a();
    }

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        protected abstract void onCallback();

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }

        public int hashCode() {
            return this.mId;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }
    }
}
