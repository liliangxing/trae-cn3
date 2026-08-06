package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1698n {

    /* renamed from: a */
    private static volatile C1698n f2818a;

    /* renamed from: a */
    private Context f2819a;

    /* renamed from: a */
    private Handler f2820a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private Map<String, Map<String, String>> f2821a = new HashMap();

    private C1698n(Context context) {
        this.f2819a = context;
    }

    /* renamed from: a */
    public static C1698n m3453a(Context context) {
        if (f2818a == null) {
            synchronized (C1698n.class) {
                if (f2818a == null) {
                    f2818a = new C1698n(context);
                }
            }
        }
        return f2818a;
    }

    /* renamed from: b */
    private synchronized void m3455b(String str, String str2, String str3) {
        if (this.f2821a == null) {
            this.f2821a = new HashMap();
        }
        Map<String, String> map = this.f2821a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f2821a.put(str, map);
    }

    /* renamed from: a */
    public synchronized void m3457a(final String str, final String str2, final String str3) {
        m3455b(str, str2, str3);
        this.f2820a.post(new Runnable() { // from class: com.xiaomi.push.n.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = C1698n.this.f2819a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }

    /* renamed from: a */
    private synchronized String m3454a(String str, String str2) {
        if (this.f2821a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f2821a.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    /* renamed from: a */
    public synchronized String m3456a(String str, String str2, String str3) {
        String m3454a = m3454a(str, str2);
        if (!TextUtils.isEmpty(m3454a)) {
            return m3454a;
        }
        return this.f2819a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
