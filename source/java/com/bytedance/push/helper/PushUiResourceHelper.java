package com.bytedance.push.helper;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.DpUtils;

/* loaded from: classes4.dex */
public class PushUiResourceHelper {
    public static Drawable getTargetAppDrawable(Context context, String str, String str2) {
        Logger.d("PushUiResourceHelper", "[getTargetAppDrawable]resName:" + str + " defPkg:" + str2);
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "drawable", str2);
            Drawable drawable = resources.getDrawable(identifier);
            Logger.d("PushUiResourceHelper", "[getOtherAppDimension]resName:" + str + " id:" + identifier + " drawable:" + drawable);
            return drawable;
        } catch (Throwable th) {
            Logger.e("PushUiResourceHelper", "[getTargetAppDrawable]resName:" + str + " exception:" + th.getLocalizedMessage());
            return null;
        }
    }

    public static int getTargetAppDimension(Context context, String str, String str2) {
        Logger.d("PushUiResourceHelper", "[getOtherAppDimension]resName:" + str + " defPkg:" + str2);
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "dimen", str2);
            float dimension = resources.getDimension(identifier);
            Logger.d("PushUiResourceHelper", "[getOtherAppDimension]resName:" + str + " id:" + identifier + " dimension:" + dimension);
            return (int) (dimension + 0.5f);
        } catch (Throwable th) {
            Logger.e("PushUiResourceHelper", "[getOtherAppDimension]resName:" + str + " exception:" + th.getLocalizedMessage());
            return -1;
        }
    }

    public static void setTextViewStyle(Button button, Context context, Resources resources, TypedArray typedArray, int[] iArr) {
        setTextViewStyle(button, context, resources, typedArray, iArr, -1);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0011. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0014. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setTextViewStyle(Button button, Context context, Resources resources, TypedArray typedArray, int[] iArr, int i) {
        for (int i2 = 0; i2 < typedArray.length(); i2++) {
            int i3 = iArr[i2];
            switch (i3) {
                case R.attr.textSize:
                    int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
                    if (dimensionPixelSize != -1) {
                        button.setTextSize(0, dimensionPixelSize);
                        break;
                    } else {
                        break;
                    }
                case R.attr.textColor:
                    String string = typedArray.getString(i2);
                    if (!TextUtils.isEmpty(string)) {
                        if (string.endsWith(".xml") && Build.VERSION.SDK_INT >= 29) {
                            Drawable drawable = typedArray.getDrawable(i2);
                            if (drawable instanceof ColorStateListDrawable) {
                                button.setTextColor(((ColorStateListDrawable) drawable).getColorStateList().getDefaultColor());
                                break;
                            } else {
                                break;
                            }
                        } else if (string.startsWith("?")) {
                            int parseInt = Integer.parseInt(string.substring(1));
                            if (resources.getResourceName(parseInt).contains(":attr/")) {
                                button.setTextColor(context.obtainStyledAttributes(i, new int[]{parseInt}).getColor(0, 3));
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        int color = typedArray.getColor(i2, 0);
                        if (color > 0) {
                            button.setTextColor(color);
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                case R.attr.gravity:
                    button.setGravity(typedArray.getInt(i2, 0));
                    break;
                case R.attr.clickable:
                    button.setClickable(typedArray.getBoolean(i2, false));
                    break;
                case R.attr.fontFamily:
                    String string2 = typedArray.getString(i2);
                    if (TextUtils.isEmpty(string2)) {
                        break;
                    } else {
                        button.setTypeface(Typeface.create(string2, 0));
                        break;
                    }
                case R.attr.layout_marginHorizontal:
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    }
                    Integer readIntValueFromStyle = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                    if (readIntValueFromStyle != null) {
                        layoutParams.leftMargin = readIntValueFromStyle.intValue();
                        layoutParams.rightMargin = readIntValueFromStyle.intValue();
                        button.setLayoutParams(layoutParams);
                        break;
                    } else {
                        break;
                    }
                default:
                    switch (i3) {
                        case R.attr.background:
                            Drawable drawable2 = typedArray.getDrawable(i2);
                            button.setBackground(drawable2);
                            if (drawable2 == null) {
                                button.setPadding(0, 0, 0, 0);
                                break;
                            } else {
                                break;
                            }
                        case R.attr.padding:
                            Integer readIntValueFromStyle2 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                            if (readIntValueFromStyle2 != null) {
                                button.setPadding(readIntValueFromStyle2.intValue(), readIntValueFromStyle2.intValue(), readIntValueFromStyle2.intValue(), readIntValueFromStyle2.intValue());
                                break;
                            } else {
                                break;
                            }
                        case R.attr.paddingLeft:
                            Integer readIntValueFromStyle3 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                            if (readIntValueFromStyle3 != null) {
                                button.setPadding(readIntValueFromStyle3.intValue(), button.getPaddingTop(), button.getPaddingRight(), button.getPaddingBottom());
                                break;
                            } else {
                                break;
                            }
                        case R.attr.paddingTop:
                            Integer readIntValueFromStyle4 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                            if (readIntValueFromStyle4 != null) {
                                button.setPadding(button.getPaddingLeft(), readIntValueFromStyle4.intValue(), button.getPaddingRight(), button.getPaddingBottom());
                                break;
                            } else {
                                break;
                            }
                        case R.attr.paddingRight:
                            Integer readIntValueFromStyle5 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                            if (readIntValueFromStyle5 != null) {
                                button.setPadding(button.getPaddingLeft(), button.getPaddingTop(), readIntValueFromStyle5.intValue(), button.getPaddingBottom());
                                break;
                            } else {
                                break;
                            }
                        case R.attr.paddingBottom:
                            Integer readIntValueFromStyle6 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                            if (readIntValueFromStyle6 != null) {
                                button.setPadding(button.getPaddingLeft(), button.getPaddingTop(), button.getPaddingRight(), readIntValueFromStyle6.intValue());
                                break;
                            } else {
                                break;
                            }
                        case R.attr.focusable:
                            button.setFocusable(typedArray.getBoolean(i2, false));
                            break;
                        default:
                            switch (i3) {
                                case R.attr.layout_width:
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                    }
                                    Integer readIntValueFromStyle7 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                    if (readIntValueFromStyle7 != null) {
                                        layoutParams2.width = readIntValueFromStyle7.intValue();
                                        button.setLayoutParams(layoutParams2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case R.attr.layout_height:
                                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                    if (layoutParams3 == null) {
                                        layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                                    }
                                    Integer readIntValueFromStyle8 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                    if (readIntValueFromStyle8 != null) {
                                        layoutParams3.height = readIntValueFromStyle8.intValue();
                                        button.setLayoutParams(layoutParams3);
                                        break;
                                    } else {
                                        break;
                                    }
                                default:
                                    switch (i3) {
                                        case R.attr.layout_marginLeft:
                                            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                            if (layoutParams4 == null) {
                                                layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                                            }
                                            Integer readIntValueFromStyle9 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                            if (readIntValueFromStyle9 != null) {
                                                layoutParams4.leftMargin = readIntValueFromStyle9.intValue();
                                                button.setLayoutParams(layoutParams4);
                                                break;
                                            } else {
                                                break;
                                            }
                                        case R.attr.layout_marginTop:
                                            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                            if (layoutParams5 == null) {
                                                layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                                            }
                                            Integer readIntValueFromStyle10 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                            if (readIntValueFromStyle10 != null) {
                                                layoutParams5.topMargin = readIntValueFromStyle10.intValue();
                                                button.setLayoutParams(layoutParams5);
                                                break;
                                            } else {
                                                break;
                                            }
                                        case R.attr.layout_marginRight:
                                            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                            if (layoutParams6 == null) {
                                                layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                                            }
                                            Integer readIntValueFromStyle11 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                            if (readIntValueFromStyle11 != null) {
                                                layoutParams6.rightMargin = readIntValueFromStyle11.intValue();
                                                button.setLayoutParams(layoutParams6);
                                                break;
                                            } else {
                                                break;
                                            }
                                        case R.attr.layout_marginBottom:
                                            LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                            if (layoutParams7 == null) {
                                                layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                                            }
                                            Integer readIntValueFromStyle12 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                            if (readIntValueFromStyle12 != null) {
                                                layoutParams7.bottomMargin = readIntValueFromStyle12.intValue();
                                                button.setLayoutParams(layoutParams7);
                                                break;
                                            } else {
                                                break;
                                            }
                                        default:
                                            switch (i3) {
                                                case R.attr.minWidth:
                                                    Integer readIntValueFromStyle13 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                                    if (readIntValueFromStyle13 != null) {
                                                        button.setMinWidth(readIntValueFromStyle13.intValue());
                                                        button.setMinimumWidth(readIntValueFromStyle13.intValue());
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case R.attr.minHeight:
                                                    Integer readIntValueFromStyle14 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                                    if (readIntValueFromStyle14 != null) {
                                                        button.setMinHeight(readIntValueFromStyle14.intValue());
                                                        button.setMinimumHeight(readIntValueFromStyle14.intValue());
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                default:
                                                    switch (i3) {
                                                        case R.attr.layout_marginStart:
                                                            LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                                            if (layoutParams8 == null) {
                                                                layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                                                            }
                                                            Integer readIntValueFromStyle15 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                                            if (readIntValueFromStyle15 != null) {
                                                                layoutParams8.setMarginStart(readIntValueFromStyle15.intValue());
                                                                button.setLayoutParams(layoutParams8);
                                                                break;
                                                            } else {
                                                                break;
                                                            }
                                                        case R.attr.layout_marginEnd:
                                                            LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) button.getLayoutParams();
                                                            if (layoutParams9 == null) {
                                                                layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                                                            }
                                                            Integer readIntValueFromStyle16 = readIntValueFromStyle(context, typedArray.getString(i2), resources);
                                                            if (readIntValueFromStyle16 != null) {
                                                                layoutParams9.setMarginEnd(readIntValueFromStyle16.intValue());
                                                                button.setLayoutParams(layoutParams9);
                                                                break;
                                                            } else {
                                                                break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
    }

    private static Integer readIntValueFromStyle(Context context, String str, Resources resources) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("@")) {
            return Integer.valueOf((int) resources.getDimension(Integer.parseInt(str.substring(1))));
        }
        if (str.startsWith("0x")) {
            return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
        }
        if (str.endsWith("dip")) {
            return Integer.valueOf(DpUtils.dp2px(context, Float.parseFloat(str.substring(0, str.length() - 3))));
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    private static Float readFloatValueFromStyle(Context context, String str, Resources resources) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("@")) {
            return Float.valueOf(resources.getDimension(Integer.parseInt(str.substring(1))));
        }
        return Float.valueOf(Float.parseFloat(str));
    }

    public static Bitmap convertViewToBitmap(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            view.measure(makeMeasureSpec, makeMeasureSpec);
            width = view.getMeasuredWidth();
            height = view.getMeasuredHeight();
        }
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (view.getRight() <= 0 || view.getBottom() <= 0) {
            view.layout(0, 0, width, height);
            view.draw(canvas);
        } else {
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            view.draw(canvas);
        }
        return createBitmap;
    }
}
