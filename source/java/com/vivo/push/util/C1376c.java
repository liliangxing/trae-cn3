package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: BaseSharePreference.java */
/* renamed from: com.vivo.push.util.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1376c {

    /* renamed from: a */
    protected Context f682a;

    /* renamed from: b */
    private String f683b;

    /* renamed from: c */
    private volatile SharedPreferences f684c;

    /* renamed from: d */
    private HashMap<String, String> f685d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Long> f686e = new HashMap<>();

    /* renamed from: f */
    private HashMap<String, Integer> f687f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, Boolean> f688g = new HashMap<>();

    /* renamed from: a */
    public final void m982a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f683b = str;
        this.f684c = context.getSharedPreferences(str, 0);
        this.f682a = context;
    }

    /* renamed from: a */
    public final SharedPreferences m981a() {
        m980c();
        return this.f684c;
    }

    /* renamed from: a */
    public final void m986a(String str, String str2) {
        this.f685d.put(str, str2);
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            edit.putString(str, str2);
            m979a(edit);
        }
    }

    /* renamed from: a */
    public final void m984a(String str, int i) {
        this.f687f.put(str, Integer.valueOf(i));
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            edit.putInt(str, i);
            m979a(edit);
        }
    }

    /* renamed from: a */
    public final void m985a(String str, long j) {
        this.f686e.put(str, Long.valueOf(j));
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            edit.putLong(str, j);
            m979a(edit);
        }
    }

    /* renamed from: a */
    public final void m983a(String str) {
        this.f688g.put(str, Boolean.TRUE);
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            edit.putBoolean(str, true);
            m979a(edit);
        }
    }

    /* renamed from: b */
    public final String m989b(String str, String str2) {
        String str3 = this.f685d.get(str);
        if (str3 != null) {
            return str3;
        }
        m980c();
        if (this.f684c != null) {
            str3 = this.f684c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f685d.put(str, str3);
            }
        }
        return str3;
    }

    /* renamed from: b */
    public final boolean m991b(String str) {
        Boolean bool = this.f688g.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        m980c();
        Boolean bool2 = Boolean.FALSE;
        if (this.f684c != null && (bool2 = Boolean.valueOf(this.f684c.getBoolean(str, false))) != null && !bool2.equals(Boolean.FALSE)) {
            this.f688g.put(str, bool2);
        }
        return bool2.booleanValue();
    }

    /* renamed from: b */
    public final int m987b(String str, int i) {
        Integer num = this.f687f.get(str);
        if (num != null) {
            return num.intValue();
        }
        m980c();
        if (this.f684c != null) {
            num = Integer.valueOf(this.f684c.getInt(str, i));
            if (!num.equals(Integer.valueOf(i))) {
                this.f687f.put(str, num);
            }
        }
        return num.intValue();
    }

    /* renamed from: b */
    public final long m988b(String str, long j) {
        Long l = this.f686e.get(str);
        if (l != null) {
            return l.longValue();
        }
        m980c();
        if (this.f684c != null) {
            l = Long.valueOf(this.f684c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f686e.put(str, l);
            }
        }
        return l.longValue();
    }

    /* renamed from: c */
    public final void m992c(String str) {
        this.f686e.remove(str);
        this.f687f.remove(str);
        this.f688g.remove(str);
        this.f685d.remove(str);
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            if (this.f684c.contains(str)) {
                edit.remove(str);
                m979a(edit);
            }
        }
    }

    /* renamed from: a */
    public static void m979a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    /* renamed from: b */
    public final void m990b() {
        this.f686e.clear();
        this.f687f.clear();
        this.f688g.clear();
        this.f685d.clear();
        m980c();
        if (this.f684c != null) {
            SharedPreferences.Editor edit = this.f684c.edit();
            edit.clear();
            m979a(edit);
        }
    }

    /* renamed from: c */
    private synchronized void m980c() {
        if (this.f684c == null) {
            Context context = this.f682a;
            if (context == null) {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
            this.f684c = context.getSharedPreferences(this.f683b, 0);
        }
    }
}
