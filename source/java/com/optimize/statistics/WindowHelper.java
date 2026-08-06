package com.optimize.statistics;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class WindowHelper {
    private static final String PREFIX_CUSTOM_WINDOW = "/CustomWindow";
    private static final String PREFIX_DIALOG_WINDOW = "/DialogWindow";
    private static final String PREFIX_IGNORED_WINDOW = "/Ignored";
    private static final String PREFIX_MAIN_WINDOW = "/MainWindow";
    private static final String PREFIX_POPUP_WINDOW = "/PopupWindow";
    private static boolean mOptExceedLimitMonitor;
    private static boolean sArrayListWindowViews;
    private static boolean sIsInitialized;
    private static Method sItemViewGetDataMethod;
    private static Class<?> sListMenuItemViewClazz;
    private static Class sPhoneWindowClazz;
    static Class sPopupWindowClazz;
    private static boolean sViewArrayWindowViews;
    private static Object sWindowManger;
    private static Field viewsField;

    static String getMainWindowPrefix() {
        return PREFIX_MAIN_WINDOW;
    }

    private WindowHelper() {
    }

    public static void setOptExceedLimitMonitor(boolean z) {
        mOptExceedLimitMonitor = z;
    }

    public static void init() {
        if (sIsInitialized) {
            return;
        }
        if (!mOptExceedLimitMonitor) {
            try {
                Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
                viewsField = cls.getDeclaredField("mViews");
                Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
                viewsField.setAccessible(true);
                if (viewsField.getType() == ArrayList.class) {
                    sArrayListWindowViews = true;
                } else if (viewsField.getType() == View[].class) {
                    sViewArrayWindowViews = true;
                }
                declaredField.setAccessible(true);
                sWindowManger = declaredField.get(null);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            }
            try {
                sListMenuItemViewClazz = Class.forName("com.android.internal.view.menu.ListMenuItemView");
                sItemViewGetDataMethod = Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new Class[0]);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
            }
        }
        try {
            try {
                sPhoneWindowClazz = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
            } catch (ClassNotFoundException unused3) {
                sPhoneWindowClazz = Class.forName("com.android.internal.policy.DecorView");
                try {
                    sPopupWindowClazz = Class.forName("android.widget.PopupWindow$PopupDecorView");
                } catch (ClassNotFoundException unused4) {
                }
                sIsInitialized = true;
            }
        } catch (ClassNotFoundException unused5) {
            sPopupWindowClazz = Class.forName("android.widget.PopupWindow$PopupDecorView");
            sIsInitialized = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSubWindowPrefix(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            int i = ((WindowManager.LayoutParams) layoutParams).type;
            if (i == 1) {
                return PREFIX_MAIN_WINDOW;
            }
            if (i < 99 && view.getClass() == sPhoneWindowClazz) {
                return PREFIX_DIALOG_WINDOW;
            }
            if (i < 1999 && view.getClass() == sPopupWindowClazz) {
                return PREFIX_POPUP_WINDOW;
            }
            if (i < 2999) {
                return PREFIX_CUSTOM_WINDOW;
            }
        }
        Class<?> cls = view.getClass();
        return cls == sPhoneWindowClazz ? PREFIX_MAIN_WINDOW : cls == sPopupWindowClazz ? PREFIX_POPUP_WINDOW : PREFIX_CUSTOM_WINDOW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDecorView(View view) {
        if (!sIsInitialized) {
            init();
        }
        Class<?> cls = view.getClass();
        return cls == sPhoneWindowClazz || cls == sPopupWindowClazz;
    }
}
