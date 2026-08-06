package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: OrientationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/container/util/OrientationUtils;", "", "()V", "isLandscape", "", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class OrientationUtils {
    public static final OrientationUtils INSTANCE = new OrientationUtils();

    private OrientationUtils() {
    }

    @JvmStatic
    public static final boolean isLandscape(Context context) {
        DisplayMetrics displayMetrics;
        Resources resources;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            WindowManager windowManager = activity.getWindowManager();
            if ((windowManager != null ? windowManager.getDefaultDisplay() : null) != null) {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                if (defaultDisplay.getWidth() >= defaultDisplay.getHeight()) {
                    return true;
                }
                return false;
            }
        }
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            displayMetrics = Resources.getSystem().getDisplayMetrics();
        }
        if (displayMetrics.widthPixels >= displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
