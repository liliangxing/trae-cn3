package com.lynx.tasm.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.Window;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: classes7.dex */
public class ContextUtils {
    public static LynxContext toLynxContext(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof LynxContext) {
                return (LynxContext) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Window getWindow(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
