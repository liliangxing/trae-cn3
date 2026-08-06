package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes5.dex */
public class ProxyDecorView {
    private static final String TAG = "ProxyDecorView";

    public ProxyDecorView(Context context, int i, Object obj, WindowManager.LayoutParams layoutParams) throws Throwable {
        int i2 = 0;
        AHook.callOrigin(OriginMethodKey.KEY_DecorView_INIT, this, context, Integer.valueOf(i), obj, layoutParams);
        String str = "ProxyDecorView() called with: context = [" + context + "], featureId = [" + i + "], window = [" + obj + "], params = [" + layoutParams + "], this = [" + this + "]";
        while (context instanceof ContextWrapper) {
            str = str + ", ContextWrapper" + i2 + " = " + context;
            context = ((ContextWrapper) context).getBaseContext();
            i2++;
        }
        AHook.getCallback().e(TAG, (str + ", decorView.getContext = " + asDecorView(this).getContext()) + ", window.getContext = " + ((Window) obj).getContext(), new Throwable());
        Looper.getMainLooper().getThread();
        Thread.currentThread();
    }

    private static ViewGroup asDecorView(Object obj) {
        return (ViewGroup) obj;
    }
}
