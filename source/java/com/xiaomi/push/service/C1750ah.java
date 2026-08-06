package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1490ax;
import com.xiaomi.push.C1804y;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1639gk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ah */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1750ah {

    /* renamed from: a */
    private static volatile C1750ah f2973a;

    /* renamed from: a */
    protected SharedPreferences f2974a;

    /* renamed from: a */
    private HashSet<a> f2975a = new HashSet<>();

    /* renamed from: b */
    protected SharedPreferences f2976b;

    /* renamed from: a */
    public synchronized void m3683a(a aVar) {
        if (!this.f2975a.contains(aVar)) {
            this.f2975a.add(aVar);
        }
    }

    /* renamed from: a */
    public synchronized void m3682a() {
        this.f2975a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3687b() {
        AbstractC1417b.m1101c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f2975a);
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

    /* renamed from: a */
    public static C1750ah m3674a(Context context) {
        if (f2973a == null) {
            synchronized (C1750ah.class) {
                if (f2973a == null) {
                    f2973a = new C1750ah(context);
                }
            }
        }
        return f2973a;
    }

    private C1750ah(Context context) {
        this.f2974a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f2976b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    /* renamed from: a */
    public void m3685a(List<Pair<EnumC1639gk, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (C1804y.m4119a(list) || C1804y.m4119a(list2)) {
            AbstractC1417b.m1089a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f2974a.edit();
        edit.clear();
        for (Pair<EnumC1639gk, Integer> pair : list) {
            if (pair.first != null && pair.second != null) {
                edit.putInt(m3676a((EnumC1639gk) pair.first), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            if (pair2.first != null && pair2.second != null) {
                m3677a(edit, pair2, m3675a(((Integer) pair2.first).intValue()));
            }
        }
        edit.apply();
    }

    /* renamed from: a */
    public void m3684a(List<Pair<Integer, Object>> list) {
        if (C1804y.m4119a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f2976b.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                String m3675a = m3675a(((Integer) pair.first).intValue());
                if (pair.second == null) {
                    edit.remove(m3675a);
                } else {
                    m3677a(edit, pair, m3675a);
                }
            }
        }
        edit.apply();
    }

    /* renamed from: a */
    private void m3677a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
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
            if (str.equals(m3675a(EnumC1638gj.AppIsInstalledList.m2760a()))) {
                editor.putString(str, C1490ax.m1585a(str2));
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

    /* renamed from: a */
    public int m3678a(int i, int i2) {
        try {
            String m3675a = m3675a(i);
            if (this.f2976b.contains(m3675a)) {
                return this.f2976b.getInt(m3675a, 0);
            }
            return this.f2974a.contains(m3675a) ? this.f2974a.getInt(m3675a, 0) : i2;
        } catch (Exception e) {
            AbstractC1417b.m1089a(i + " oc int error " + e);
            return i2;
        }
    }

    /* renamed from: a */
    public long m3680a(int i, long j) {
        try {
            String m3675a = m3675a(i);
            if (this.f2976b.contains(m3675a)) {
                return this.f2976b.getLong(m3675a, 0L);
            }
            return this.f2974a.contains(m3675a) ? this.f2974a.getLong(m3675a, 0L) : j;
        } catch (Exception e) {
            AbstractC1417b.m1089a(i + " oc long error " + e);
            return j;
        }
    }

    /* renamed from: a */
    public String m3681a(int i, String str) {
        try {
            String m3675a = m3675a(i);
            if (this.f2976b.contains(m3675a)) {
                return this.f2976b.getString(m3675a, null);
            }
            return this.f2974a.contains(m3675a) ? this.f2974a.getString(m3675a, null) : str;
        } catch (Exception e) {
            AbstractC1417b.m1089a(i + " oc string error " + e);
            return str;
        }
    }

    /* renamed from: a */
    public boolean m3686a(int i, boolean z) {
        try {
            String m3675a = m3675a(i);
            if (this.f2976b.contains(m3675a)) {
                return this.f2976b.getBoolean(m3675a, false);
            }
            return this.f2974a.contains(m3675a) ? this.f2974a.getBoolean(m3675a, false) : z;
        } catch (Exception e) {
            AbstractC1417b.m1089a(i + " oc boolean error " + e);
            return z;
        }
    }

    /* renamed from: a */
    public int m3679a(EnumC1639gk enumC1639gk, int i) {
        try {
            return this.f2974a.getInt(m3676a(enumC1639gk), i);
        } catch (Exception e) {
            AbstractC1417b.m1089a(enumC1639gk + " version error " + e);
            return i;
        }
    }

    /* renamed from: a */
    private String m3675a(int i) {
        return "oc_" + i;
    }

    /* renamed from: a */
    private String m3676a(EnumC1639gk enumC1639gk) {
        return "oc_version_" + enumC1639gk.m2762a();
    }

    /* renamed from: com.xiaomi.push.service.ah$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
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
