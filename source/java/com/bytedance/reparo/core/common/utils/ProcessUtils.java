package com.bytedance.reparo.core.common.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class ProcessUtils {
    public static String getCurrentProcessName(Context context) {
        return com.bytedance.reparo.core.utils.ProcessUtils.getCurrentProcessName(context);
    }

    public static boolean isMainProcess(Context context) {
        return TextUtils.equals(context.getPackageName(), getCurrentProcessName(context));
    }
}
