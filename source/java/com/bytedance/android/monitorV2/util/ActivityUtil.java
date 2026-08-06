package com.bytedance.android.monitorV2.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/* loaded from: classes3.dex */
public class ActivityUtil {
    public static Activity getActivityByContext(View view) {
        return getActivityByContext(view.getContext());
    }

    public static Activity getActivityByContext(Context context) {
        while (context instanceof ContextWrapper) {
            try {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } catch (Exception e) {
                ExceptionUtil.handleException(e);
                return null;
            }
        }
        return null;
    }
}
