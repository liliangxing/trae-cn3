package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes6.dex */
public abstract class ResourceLoaderUtil {
    private static Context a;
    private static String b;

    public static int getAnimId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", b);
    }

    public static int getColorId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "color", b);
    }

    public static int getDimenId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", b);
    }

    public static Drawable getDrawable(String str) {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", b);
    }

    public static int getIdId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", b);
    }

    public static String getString(String str) {
        Context context = a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", b);
    }

    public static int getStyleId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", b);
    }

    public static Context getmContext() {
        return a;
    }

    public static void setmContext(Context context) {
        a = context;
        if (context != null) {
            b = context.getPackageName();
        } else {
            b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = a;
        return context == null ? "" : context.getResources().getString(getStringId(str), objArr);
    }
}
