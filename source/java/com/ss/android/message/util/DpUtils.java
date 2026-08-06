package com.ss.android.message.util;

import android.content.Context;
import com.bytedance.push.utils.Logger;

/* loaded from: classes7.dex */
public class DpUtils {
    private static float mScale;

    public static int dp2px(Context context, float f) {
        if (mScale == 0.0f) {
            mScale = context.getResources().getDisplayMetrics().density;
        }
        Logger.d("DpUtils", "dp2px: mScale is " + mScale);
        return (int) ((f * mScale) + 0.5f);
    }

    public static int px2dp(Context context, int i) {
        return (int) ((i / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
