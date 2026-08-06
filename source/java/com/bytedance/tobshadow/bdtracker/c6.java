package com.bytedance.tobshadow.bdtracker;

import android.view.View;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class c6 {
    public static Field b;
    public static Class c;
    public static Class d;
    public static final List<String> a = Collections.singletonList("WindowHelper");
    public static boolean e = false;

    public static void a() {
        if (e) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            b = cls.getDeclaredField("mViews");
            Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
            b.setAccessible(true);
            if (b.getType() != ArrayList.class) {
                b.getType();
            }
            declaredField.setAccessible(true);
            declaredField.get(null);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get window manager views failed", th, new Object[0]);
        }
        try {
            try {
                c = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
            } catch (Throwable th2) {
                LoggerImpl.global().error(a, "Get DecorView failed", th2, new Object[0]);
            }
        } catch (ClassNotFoundException unused) {
            c = Class.forName("com.android.internal.policy.DecorView");
        }
        try {
            d = Class.forName("android.widget.PopupWindow$PopupDecorView");
        } catch (Throwable th3) {
            LoggerImpl.global().error(a, "Get popup view failed", th3, new Object[0]);
        }
        e = true;
    }

    public static boolean a(View view) {
        if (!e) {
            a();
        }
        Class<?> cls = view.getClass();
        return cls == c || cls == d;
    }
}
