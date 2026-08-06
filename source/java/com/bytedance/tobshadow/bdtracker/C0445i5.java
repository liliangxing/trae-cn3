package com.bytedance.tobshadow.bdtracker;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.tobshadow.bdtracker.i5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0445i5 {

    /* renamed from: a */
    public static boolean f679a;

    /* renamed from: b */
    public static Class f680b;

    /* renamed from: c */
    public static Method f681c;

    /* renamed from: d */
    public static boolean f682d = m476a("com.tencent.smtt.sdk.WebView");

    /* renamed from: e */
    public static boolean f683e = m476a("android.support.v7.widget.RecyclerView");

    /* renamed from: f */
    public static boolean f684f = m476a("android.support.v4.view.ViewPager");

    /* renamed from: g */
    public static boolean f685g = m476a("android.support.v4.widget.SwipeRefreshLayout");

    /* renamed from: h */
    public static boolean f686h;

    /* renamed from: i */
    public static boolean f687i;

    /* renamed from: j */
    public static boolean f688j;

    static {
        m476a("android.support.v4.app.Fragment");
        m476a("android.support.v4.app.FragmentActivity");
        m476a("android.support.v7.app.AlertDialog");
        m476a("android.support.v7.view.menu.ListMenuItemView");
        f686h = m476a("androidx.recyclerview.widget.RecyclerView");
        f687i = m476a("androidx.viewpager.widget.ViewPager");
        f688j = m476a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        m476a("androidx.fragment.app.Fragment");
        m476a("androidx.fragment.app.FragmentActivity");
        m476a("androidx.appcompat.app.AlertDialog");
        m476a("androidx.appcompat.view.menu.ListMenuItemView");
    }

    /* renamed from: a */
    public static Class<?> m473a(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                f681c = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException unused) {
            }
            if (f681c == null) {
                try {
                    f681c = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (f681c != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m474a(View view) {
        return (view instanceof WebView) || m477b(view);
    }

    /* renamed from: a */
    public static boolean m475a(Object obj) {
        return f686h && (obj instanceof RecyclerView);
    }

    /* renamed from: a */
    public static boolean m476a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m477b(View view) {
        return f682d && (view instanceof com.tencent.smtt.sdk.WebView);
    }

    /* renamed from: b */
    public static boolean m478b(Object obj) {
        return f683e && C0411e.m360a(obj, "android.support.v7.widget.RecyclerView");
    }

    /* renamed from: c */
    public static boolean m479c(Object obj) {
        return f684f && C0411e.m360a(obj, "android.support.v4.view.ViewPager");
    }
}
