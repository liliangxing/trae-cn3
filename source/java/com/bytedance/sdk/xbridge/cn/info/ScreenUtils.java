package com.bytedance.sdk.xbridge.cn.info;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import kotlin.Metadata;

/* compiled from: ScreenUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/ScreenUtils;", "", "()V", "screenHeight", "", "screenWidth", "getScreenHeight", "context", "Landroid/content/Context;", "getScreenWidth", "getStatusBarHeight", "initScreenSize", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenUtils {
    public static final ScreenUtils INSTANCE = new ScreenUtils();
    private static int screenHeight = -1;
    private static int screenWidth = -1;

    private ScreenUtils() {
    }

    private final void initScreenSize(Context context) {
        try {
            Object systemService = context.getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                if (defaultDisplay == null) {
                    return;
                }
                defaultDisplay.getRealSize(point);
                screenHeight = point.y;
                screenWidth = point.x;
                return;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            screenHeight = displayMetrics.heightPixels;
            screenWidth = displayMetrics.widthPixels;
        } catch (Exception unused) {
        }
    }

    public final int getScreenHeight(Context context) {
        int i = screenHeight;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return 0;
        }
        initScreenSize(context);
        int i2 = screenHeight;
        if (i2 > 0) {
            return i2;
        }
        return 0;
    }

    public final int getScreenWidth(Context context) {
        int i = screenWidth;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return 0;
        }
        initScreenSize(context);
        int i2 = screenWidth;
        if (i2 > 0) {
            return i2;
        }
        return 0;
    }

    public final int getStatusBarHeight() {
        int identifier;
        Application application = BulletEnv.INSTANCE.getInstance().getApplication();
        if (application == null || (identifier = application.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return application.getResources().getDimensionPixelSize(identifier);
    }
}
