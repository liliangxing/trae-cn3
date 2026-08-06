package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/anniex/container/util/ResUtil;", "", "()V", "DIP_UPPER", "", "dp2Px", "", CustomImageSizeResolverDef.UNIT_DP, "getContext", "Landroid/app/Application;", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "activity", "Landroid/app/Activity;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "resId", "context", "Landroid/content/Context;", "getLargeFontScale", "getRealDisplayMetrics", "getRealScreenHeight", "getRealScreenWidth", "getResources", "Landroid/content/res/Resources;", "getScreenHeight", "getScreenWidth", "getSystemViewZoom", "px2Dp", "px", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class ResUtil {
    public static final float DIP_UPPER = 0.5f;
    public static final ResUtil INSTANCE = new ResUtil();

    private ResUtil() {
    }

    private final Application getContext() {
        return BulletEnv.INSTANCE.getInstance().getApplication();
    }

    private final DisplayMetrics getDisplayMetrics() {
        Context applicationContext;
        Resources resources;
        Application context = getContext();
        DisplayMetrics displayMetrics = (context == null || (applicationContext = context.getApplicationContext()) == null || (resources = applicationContext.getResources()) == null) ? null : resources.getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = Resources.getSystem().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics2, "getSystem().displayMetrics");
        return displayMetrics2;
    }

    public final DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics displayMetrics = activity != null ? activity.getResources().getDisplayMetrics() : null;
        return displayMetrics == null ? getDisplayMetrics() : displayMetrics;
    }

    public final int dp2Px(float dp) {
        return (int) ((dp * getDisplayMetrics().density) + 0.5f);
    }

    public final float px2Dp(int px) {
        return px / getDisplayMetrics().density;
    }

    public final int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public final int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    public final int getRealScreenHeight(Activity activity) {
        return getRealDisplayMetrics(activity).heightPixels;
    }

    public final int getRealScreenWidth(Activity activity) {
        return getRealDisplayMetrics(activity).widthPixels;
    }

    public final DisplayMetrics getRealDisplayMetrics(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return displayMetrics;
        }
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService;
        }
        if (windowManager == null) {
            return displayMetrics;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public final Resources getResources() {
        Application context = getContext();
        Resources resources = context != null ? context.getResources() : null;
        if (resources != null) {
            return resources;
        }
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "getSystem()");
        return system;
    }

    public final float getLargeFontScale(Context context) {
        if (context == null) {
            return 1.0f;
        }
        float f = context.getResources().getConfiguration().fontScale;
        if (f > 1.3d) {
            return 1.3f;
        }
        return f;
    }

    public final Drawable getDrawable(int resId, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDrawable(resId);
    }

    public final float getSystemViewZoom(Context context) {
        int i = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (DisplayMetrics.DENSITY_DEVICE_STABLE == 160) {
            i = 0;
            try {
                Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.sf.lcd_density");
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
                i = ((Integer) invoke).intValue();
            } catch (Exception unused) {
            }
        }
        if (i == 0 || context == null) {
            return 1.0f;
        }
        return context.getResources().getConfiguration().densityDpi / i;
    }
}
