package com.bytedance.tobshadow.bdtracker;

import android.view.View;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.tobshadow.bdtracker.c6 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0403c6 {

    /* renamed from: b */
    public static Field f487b;

    /* renamed from: c */
    public static Class f488c;

    /* renamed from: d */
    public static Class f489d;

    /* renamed from: a */
    public static final List<String> f486a = Collections.singletonList("WindowHelper");

    /* renamed from: e */
    public static boolean f490e = false;

    /* renamed from: a */
    public static void m300a() {
        if (f490e) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            f487b = cls.getDeclaredField("mViews");
            Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
            f487b.setAccessible(true);
            if (f487b.getType() != ArrayList.class) {
                f487b.getType();
            }
            declaredField.setAccessible(true);
            declaredField.get(null);
        } catch (Throwable th) {
            LoggerImpl.global().error(f486a, "Get window manager views failed", th, new Object[0]);
        }
        try {
            try {
                f488c = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
            } catch (Throwable th2) {
                LoggerImpl.global().error(f486a, "Get DecorView failed", th2, new Object[0]);
            }
        } catch (ClassNotFoundException unused) {
            f488c = Class.forName("com.android.internal.policy.DecorView");
        }
        try {
            f489d = Class.forName("android.widget.PopupWindow$PopupDecorView");
        } catch (Throwable th3) {
            LoggerImpl.global().error(f486a, "Get popup view failed", th3, new Object[0]);
        }
        f490e = true;
    }

    /* renamed from: a */
    public static boolean m301a(View view) {
        if (!f490e) {
            m300a();
        }
        Class<?> cls = view.getClass();
        return cls == f488c || cls == f489d;
    }
}
