package com.bytedance.lottie.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/* loaded from: classes4.dex */
public class ContextUtil {
    public static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Activity getActivity(View view) {
        if (view == null) {
            return null;
        }
        return getActivity(view.getContext());
    }
}
