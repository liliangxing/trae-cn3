package com.optimize.statistics;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ClassHelper {
    private static final String TAG = "ClassHelper";
    private static Class sCRVClass;
    private static Method sCRVGetChildAdapterPositionMethod;
    static boolean sHasCustomRecyclerView;
    private static final boolean sHasTransform = false;
    private static boolean sHasSupportRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
    private static boolean sHasSupportViewPager = hasClass("androidx.viewpager.widget.ViewPager");
    private static boolean sHasSupportSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    private static boolean sHasSupportFragment = hasClass("androidx.fragment.app.Fragment");
    private static boolean sHasSupportFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
    private static boolean sHasSupportAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
    private static boolean sHasSupportListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");
    private static boolean sHasAndroidXRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
    private static boolean sHasAndroidXViewPager = hasClass("androidx.viewpager.widget.ViewPager");
    private static boolean sHasAndroidXSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    private static boolean sHasAndroidXFragment = hasClass("androidx.fragment.app.Fragment");
    private static boolean sHasAndroidXFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
    private static boolean sHasAndroidXAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
    private static boolean sHasAndroidXListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");

    private static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int invokeCRVGetChildAdapterPositionMethod(View view, View view2) {
        try {
            if (view.getClass() == sCRVClass) {
                return ((Integer) sCRVGetChildAdapterPositionMethod.invoke(view, view2)).intValue();
            }
            return -1;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return -1;
        }
    }

    static void checkCustomRecyclerView(Class<?> cls, String str) {
        if (sHasAndroidXRecyclerView || sHasSupportRecyclerView || sHasCustomRecyclerView || str == null || !str.contains("RecyclerView")) {
            return;
        }
        try {
            if (findRecyclerInSuper(cls) == null || sCRVGetChildAdapterPositionMethod == null) {
                return;
            }
            sCRVClass = cls;
            sHasCustomRecyclerView = true;
        } catch (Exception unused) {
        }
    }

    private static Class<?> findRecyclerInSuper(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                sCRVGetChildAdapterPositionMethod = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException unused) {
            }
            if (sCRVGetChildAdapterPositionMethod == null) {
                try {
                    sCRVGetChildAdapterPositionMethod = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (sCRVGetChildAdapterPositionMethod != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfRecyclerView(Object obj) {
        return instanceOfAndroidXRecyclerView(obj) || instanceOfSupportRecyclerView(obj) || (sHasCustomRecyclerView && obj != null && sCRVClass.isAssignableFrom(obj.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfSupportRecyclerView(Object obj) {
        return sHasSupportRecyclerView && (obj instanceof RecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfAndroidXRecyclerView(Object obj) {
        return sHasAndroidXRecyclerView && (obj instanceof RecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfSupportViewPager(Object obj) {
        return sHasSupportViewPager && (obj instanceof ViewPager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfAndroidXViewPager(Object obj) {
        return sHasAndroidXViewPager && (obj instanceof ViewPager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceOfSupportSwipeRefreshLayout(Object obj) {
        return sHasSupportSwipeRefreshLayoutView && (obj instanceof SwipeRefreshLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean instanceofAndroidXSwipeRefreshLayout(Object obj) {
        return sHasAndroidXSwipeRefreshLayoutView && (obj instanceof SwipeRefreshLayout);
    }

    static boolean instanceOfSupportAlertDialog(Object obj) {
        return sHasSupportAlertDialog && (obj instanceof AlertDialog);
    }

    static boolean instanceOfAndroidXAlertDialog(Object obj) {
        return sHasAndroidXAlertDialog && (obj instanceof AlertDialog);
    }

    public static boolean instanceOfSupportFragmentActivity(Object obj) {
        return sHasSupportFragmentActivity && (obj instanceof FragmentActivity);
    }

    public static boolean instanceOfAndroidXFragmentActivity(Object obj) {
        return sHasAndroidXFragmentActivity && (obj instanceof FragmentActivity);
    }

    public static boolean instanceOfSupportFragment(Object obj) {
        return sHasSupportFragment && (obj instanceof Fragment);
    }

    public static boolean instanceOfAndroidXFragment(Object obj) {
        return sHasAndroidXFragment && (obj instanceof Fragment);
    }

    static boolean instanceOfSupportListMenuItemView(Object obj) {
        return sHasSupportListMenuItemView && (obj instanceof ListMenuItemView);
    }

    static boolean instanceOfAndroidXListMenuItemView(Object obj) {
        return sHasAndroidXListMenuItemView && (obj instanceof ListMenuItemView);
    }

    public static void dumpClassInfo() {
        Log.d(TAG, "For Support Class: \nsHasSupportRecyclerView=" + sHasSupportRecyclerView + ", sHasSupportFragmentActivity=" + sHasSupportFragmentActivity + "\nsHasSupportFragment=" + sHasSupportFragment + ", sHasSupportAlertDialog=" + sHasSupportAlertDialog + "\nsHasSupportSwipeRefreshLayoutView=" + sHasSupportSwipeRefreshLayoutView + ", sHasSupportViewPager=" + sHasSupportViewPager + "\nsHasSupportListMenuItemView=" + sHasSupportListMenuItemView + "\nFor AndroidX Class: \nsHasAndroidXRecyclerView=" + sHasAndroidXRecyclerView + ", sHasAndroidXFragmentActivity=" + sHasAndroidXFragmentActivity + "\nsHasAndroidXFragment=" + sHasAndroidXFragment + ", sHasAndroidXAlertDialog=" + sHasAndroidXAlertDialog + "\nsHasAndroidXSwipeRefreshLayoutView=" + sHasAndroidXSwipeRefreshLayoutView + ", sHasAndroidXViewPager=" + sHasAndroidXViewPager + "\nsHasAndroidXListMenuItemView=" + sHasAndroidXListMenuItemView + "\nAnd sHasTransform=false");
    }
}
