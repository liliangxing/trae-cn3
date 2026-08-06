package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class n {
    private static volatile n a;

    /* renamed from: a, reason: collision with other field name */
    private Context f900a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f901a = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f902a = new HashMap();

    private n(Context context) {
        this.f900a = context;
    }

    public static n a(Context context) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n(context);
                }
            }
        }
        return a;
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f902a == null) {
            this.f902a = new HashMap();
        }
        Map<String, String> map = this.f902a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f902a.put(str, map);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m10113a(final String str, final String str2, final String str3) {
        b(str, str2, str3);
        this.f901a.post(new Runnable() { // from class: com.xiaomi.push.n.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = n.this.f900a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }

    private synchronized String a(String str, String str2) {
        if (this.f902a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f902a.get(str);
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

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.f900a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
