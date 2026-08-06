package com.bytedance.ies.bullet.base.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes4.dex */
public class AllScreenConfig {
    public static boolean isHaveBangs(Context context) {
        return isOppoConcaveScreen(context) || isVivoConcaveScreen() || isHuaweiConcaveScreen(context) || getInt("ro.miui.notch", context) == 1 || isAllScreenForAndroidP(context) || isCutOut(context);
    }

    public static boolean isNavigationBarShow(WindowManager windowManager) {
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    private static boolean isVivoConcaveScreen() {
        if (!TextUtils.equals("vivo", Build.BRAND.toLowerCase())) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getDeclaredMethod("isFeatureSupport", Integer.TYPE).invoke(cls, 32)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isOppoConcaveScreen(Context context) {
        if (TextUtils.equals("oppo", Build.BRAND.toLowerCase())) {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return false;
    }

    public static boolean isHuaweiConcaveScreen(Context context) {
        String lowerCase = Build.BRAND.toLowerCase();
        if (!TextUtils.equals("huawei", lowerCase) && !TextUtils.equals("honor", lowerCase)) {
            return false;
        }
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (ClassNotFoundException unused) {
                Log.e("test", "hasNotchInScreen ClassNotFoundException");
                return false;
            } catch (NoSuchMethodException unused2) {
                Log.e("test", "hasNotchInScreen NoSuchMethodException");
                return false;
            } catch (Exception unused3) {
                Log.e("test", "hasNotchInScreen Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static int getInt(String str, Context context) {
        if (!"Xiaomi".equals(Build.MANUFACTURER)) {
            return 0;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static boolean isAllScreenForAndroidP(Context context) {
        if ((context instanceof Activity) && Build.VERSION.SDK_INT >= 28) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            try {
                Object invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
                Object invoke2 = invoke.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]);
                List list = (List) invoke2.getClass().getMethod("getBoundingRects", new Class[0]).invoke(invoke2, new Object[0]);
                if (list != null) {
                    return list.size() > 0;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean isCutOut(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L2a
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 27
            if (r1 >= r2) goto La
            goto L2a
        La:
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Exception -> L2a
            java.lang.String r1 = "config_mainBuiltInDisplayCutout"
            java.lang.String r2 = "string"
            java.lang.String r3 = "android"
            int r1 = r4.getIdentifier(r1, r2, r3)     // Catch: java.lang.Exception -> L2a
            if (r1 <= 0) goto L20
            java.lang.String r4 = r4.getString(r1)     // Catch: java.lang.Exception -> L2a
            goto L21
        L20:
            r4 = 0
        L21:
            if (r4 == 0) goto L2a
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L2a
            if (r4 != 0) goto L2a
            r0 = 1
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.ies.bullet.base.utils.AllScreenConfig.isCutOut(android.content.Context):boolean");
    }
}
