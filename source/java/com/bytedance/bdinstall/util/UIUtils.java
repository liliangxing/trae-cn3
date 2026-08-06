package com.bytedance.bdinstall.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

@Deprecated
/* loaded from: classes3.dex */
public class UIUtils {
    private static final char ELLIPSIS_CHAR = 8230;
    private static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    public static final boolean API_ET_20 = true;
    private static String sScreenResolution = "";
    private static int DPI = -1;
    public static EllipsisMeasureResult sTempEllipsisResult = new EllipsisMeasureResult();

    /* loaded from: classes3.dex */
    public static class EllipsisMeasureResult {
        public String ellipsisStr;
        public int length;
    }

    public static int floatToIntBig(float f) {
        return (int) (f + 0.999f);
    }

    @Deprecated
    public static int setColorAlpha(int i, int i2) {
        if (i2 > 255) {
            i2 = 255;
        } else if (i2 < 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 * 16777216);
    }

    @Deprecated
    private static boolean visibilityValid(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    @Deprecated
    public static float sp2px(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    @Deprecated
    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Deprecated
    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public static void expandClickRegion(final View view, final int i, final int i2, final int i3, final int i4) {
        view.post(new Runnable() { // from class: com.bytedance.bdinstall.util.UIUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top += i2;
                rect.bottom += i4;
                rect.left += i;
                rect.right += i3;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                if (View.class.isInstance(view.getParent())) {
                    ((View) view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View view, int i) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View view, Resources resources, int i) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundColor(resources.getColor(i));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setViewBackgroundWithPadding(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Deprecated
    public static String getDisplayCount(int i) {
        if (i > 10000) {
            String format = String.format("%.1f", Double.valueOf((i * 1.0d) / 10000.0d));
            if ('0' == format.charAt(format.length() - 1)) {
                return format.substring(0, format.length() - 2) + "万";
            }
            return format + "万";
        }
        return String.valueOf(i);
    }

    private static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    private static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static String getScreenResolution(Context context) {
        if (TextUtils.isEmpty(sScreenResolution) && context != null) {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            if (screenWidth > 0 && screenHeight > 0) {
                sScreenResolution = screenWidth + "*" + screenHeight;
            }
        }
        return sScreenResolution;
    }

    public static int getDpi(Context context) {
        if (DPI == -1 && context != null) {
            DPI = context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return DPI;
    }

    @Deprecated
    public static int getDiggBuryWidth(Context context) {
        return ((context.getResources().getDisplayMetrics().widthPixels * 1375) / 10000) + ((int) dip2Px(context, 20.0f));
    }

    @Deprecated
    public static final int getStatusBarHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Deprecated
    public static final void setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !visibilityValid(i)) {
            return;
        }
        view.setVisibility(i);
    }

    @Deprecated
    public static final boolean isViewVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    @Deprecated
    public static void getLocationInUpView(View view, View view2, int[] iArr, boolean z) {
        if (view == null || view2 == null || iArr == null || iArr.length < 2) {
            return;
        }
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0] - i;
        int i4 = iArr[1] - i2;
        if (z) {
            i3 += view2.getWidth() / 2;
            i4 += view2.getHeight() / 2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    @Deprecated
    public static void updateLayout(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.width == i && layoutParams.height == i2) {
            return;
        }
        if (i != -3) {
            layoutParams.width = i;
        }
        if (i2 != -3) {
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static void updateLayoutMargin(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        updateMargin(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void updateMargin(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    @Deprecated
    public static void setTopMargin(View view, float f) {
        if (view == null) {
            return;
        }
        updateLayoutMargin(view, -3, (int) TypedValue.applyDimension(1, f, view.getContext().getResources().getDisplayMetrics()), -3, -3);
    }

    @Deprecated
    public static void setLayoutParams(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i != Integer.MIN_VALUE) {
            layoutParams.width = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.height = i2;
        }
    }

    @Deprecated
    public static void setTxtAndAdjustVisible(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            setViewVisibility(textView, 8);
        } else {
            setViewVisibility(textView, 0);
            textView.setText(charSequence);
        }
    }

    @Deprecated
    public static void setText(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    @Deprecated
    public static void detachFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public static void setViewMinHeight(View view, int i) {
        if (view == null || view.getMinimumHeight() == i) {
            return;
        }
        view.setMinimumHeight(i);
    }

    @Deprecated
    public static void setTextViewMaxLines(TextView textView, int i) {
        if (textView == null || i <= 0 || textView.getMaxLines() == i) {
            return;
        }
        textView.setSingleLine(i == 1);
        textView.setMaxLines(i);
    }

    @Deprecated
    public static int[] getLocationInAncestor(View view, View view2) {
        boolean z;
        if (view == null || view2 == null) {
            return null;
        }
        int[] iArr = new int[2];
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = fArr[0] + view.getLeft();
        fArr[1] = fArr[1] + view.getTop();
        ViewParent parent = view.getParent();
        while (true) {
            if (!(parent instanceof View)) {
                z = false;
                break;
            }
            View view3 = (View) parent;
            if (parent == view2) {
                z = true;
                break;
            }
            fArr[0] = fArr[0] - view3.getScrollX();
            fArr[1] = fArr[1] - view3.getScrollY();
            fArr[0] = fArr[0] + view3.getLeft();
            fArr[1] = fArr[1] + view3.getTop();
            parent = view3.getParent();
        }
        if (!z) {
            return null;
        }
        iArr[0] = (int) (fArr[0] + 0.5f);
        iArr[1] = (int) (fArr[1] + 0.5f);
        return iArr;
    }

    @Deprecated
    public static void ellipseSingleLineStr(String str, int i, Paint paint, int i2, EllipsisMeasureResult ellipsisMeasureResult) {
        if (i <= i2 || TextUtils.isEmpty(str)) {
            ellipsisMeasureResult.ellipsisStr = "";
            ellipsisMeasureResult.length = 0;
            return;
        }
        int floatToIntBig = floatToIntBig(paint.measureText(str));
        if (floatToIntBig <= i) {
            ellipsisMeasureResult.ellipsisStr = str;
            ellipsisMeasureResult.length = floatToIntBig;
            return;
        }
        StringBuilder sb = new StringBuilder();
        int breakText = paint.breakText(str, 0, str.length(), true, i - i2, null);
        if (breakText < 1) {
            ellipsisMeasureResult.ellipsisStr = "";
            ellipsisMeasureResult.length = 0;
        } else {
            sb.append(str.substring(0, breakText));
            sb.append((char) 8230);
            ellipsisMeasureResult.ellipsisStr = sb.toString();
            ellipsisMeasureResult.length = i;
        }
    }

    @Deprecated
    public static void requestOrienation(Activity activity, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.setRequestedOrientation(!z ? 1 : 0);
        if (z) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    @Deprecated
    public static int getIndexInParent(View view) {
        if (view != null && view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return ((ViewGroup) parent).indexOfChild(view);
            }
        }
        return -1;
    }

    @Deprecated
    public static boolean clearAnimation(View view) {
        if (view == null || view.getAnimation() == null) {
            return false;
        }
        view.clearAnimation();
        return true;
    }

    @Deprecated
    public static void setClickListener(boolean z, View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setOnClickListener(onClickListener);
            view.setClickable(true);
        } else {
            view.setOnClickListener(null);
            view.setClickable(false);
        }
    }
}
