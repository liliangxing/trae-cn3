package com.bytedance.sdk.account.common.utils;

import android.content.Context;

/* loaded from: classes5.dex */
public class Utils {
    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
