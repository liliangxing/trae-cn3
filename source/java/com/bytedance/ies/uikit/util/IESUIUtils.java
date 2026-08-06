package com.bytedance.ies.uikit.util;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.util.HoneyCombMR2V13Compat;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.common.utility.ICustomToast;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.uikit.toast.ICustomViewToast;
import com.bytedance.ies.uikit.toast.IDurationToast;
import com.bytedance.ies.uikit.toast.IViewInflatedListener;
import com.bytedance.platform.thread.Constants;
import com.bytedance.ugc.uikit.C1158R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IESUIUtils {
    public static void displayToast(Context context, String str) {
        if (context == null || StringUtils.isEmpty(str)) {
            return;
        }
        if (context instanceof ICustomToast) {
            ((ICustomToast) context).showCustomToast(str);
            return;
        }
        try {
            Toast makeText = Toast.makeText(context, str, 0);
            if (makeText != null) {
                makeText.show();
            }
        } catch (Exception e) {
            Logger.throwException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context context, int i, IViewInflatedListener iViewInflatedListener) {
        if (context == 0 || i <= 0 || !(context instanceof ICustomViewToast)) {
            return;
        }
        ((ICustomViewToast) context).showCustomViewToast(i, iViewInflatedListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context context, int i, IViewInflatedListener iViewInflatedListener, int i2) {
        if (context == 0 || i <= 0 || !(context instanceof ICustomViewToast)) {
            return;
        }
        ((ICustomViewToast) context).showCustomViewToast(i, iViewInflatedListener, i2);
    }

    public static void displayToast(Context context, int i) {
        if (context == null) {
            return;
        }
        displayToast(context, context.getString(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context context, String str, long j) {
        if (context == 0 || StringUtils.isEmpty(str)) {
            return;
        }
        if (context instanceof IDurationToast) {
            ((IDurationToast) context).showCustomToast(str, j);
            return;
        }
        try {
            Toast makeText = Toast.makeText(context, str, 0);
            if (makeText != null) {
                makeText.show();
            }
        } catch (Exception e) {
            Logger.throwException(e);
        }
    }

    public static void displayToast(Context context, int i, long j) {
        if (context == null) {
            return;
        }
        displayToast(context, context.getString(i), j);
    }

    public static void setViewBackground(View view, Drawable drawable) {
        JellyBeanV16Compat.setViewBackground(view, drawable);
    }

    public static float viewInScreenRate(Context context, View view, int i, Point point, int[] iArr) {
        if (view == null) {
            return 0.0f;
        }
        HoneyCombMR2V13Compat.getDisplaySize(context, point);
        int i2 = point.y;
        view.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int measuredHeight = layoutParams != null ? layoutParams.height : view.getMeasuredHeight();
        int i3 = iArr[1] - i;
        int i4 = i3 + measuredHeight;
        if (i4 <= i2) {
            i2 = i4;
        }
        if (i3 > 0) {
            i2 -= i3;
        }
        return i2 / measuredHeight;
    }

    public static boolean isRecycleViewCanScroll(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        if (recyclerView == null || adapter == null) {
            return false;
        }
        return adapter.getItemCount() > recyclerView.getChildCount() || isChildWidthCountLTParentWidth(recyclerView);
    }

    public static boolean isChildWidthCountLTParentWidth(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        int width = viewGroup.getWidth();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            i += viewGroup.getChildAt(i2).getWidth();
        }
        return i > width;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r1.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMaterialNotification(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray typedArray = null;
        try {
            int color = context.getResources().getColor(C1158R.color.notification_title);
            typedArray = context.obtainStyledAttributes(C1158R.style.NotificationTitle, new int[]{R.attr.textColor, R.attr.textSize});
            if (color == typedArray.getColor(0, 0)) {
                if (typedArray != null) {
                    try {
                        typedArray.recycle();
                    } catch (Throwable unused) {
                    }
                }
                return true;
            }
        } catch (Throwable unused2) {
        }
    }

    public static final String getDisplayCount(long j, String str) {
        if (j > Constants.TASK_WAIT_THRESHOLD) {
            String format = String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d));
            if ('0' == format.charAt(format.length() - 1)) {
                return format.substring(0, format.length() - 2) + str;
            }
            return format + str;
        }
        return String.valueOf(j);
    }

    public static final int getNavigationBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(3);
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (deviceHasKey && identifier <= 0) {
            return 0;
        }
        try {
            return context.getResources().getDimensionPixelSize(identifier);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
