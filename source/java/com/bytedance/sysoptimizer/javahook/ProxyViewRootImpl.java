package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;

/* loaded from: classes5.dex */
public class ProxyViewRootImpl {
    private static final String TAG = "ProxyViewRootImpl";

    public ProxyViewRootImpl(Context context, Display display) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT, this, context, display);
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + context + "], display = [" + display + "]", new Throwable());
    }

    public ProxyViewRootImpl(Context context, Display display, Object obj, Object obj2) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_1, this, context, display, obj, obj2);
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + context + "], display = [" + display + "], session = [" + obj + "], windowLayout = [" + obj2 + "]", new Throwable());
    }

    public ProxyViewRootImpl(Context context, Display display, Object obj) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_2, this, context, display, obj);
        AHook.getCallback().e(TAG, "ProxyViewRootImpl() called with: context = [" + context + "], display = [" + display + "], session = [" + obj + "]", new Throwable());
    }

    public ProxyViewRootImpl(Context context, Display display, Object obj, boolean z) throws Throwable {
        int i = 0;
        AHook.callOrigin(OriginMethodKey.KEY_VIEWROOTIMPL_INIT_3, this, context, display, obj, Boolean.valueOf(z));
        String str = "ProxyViewRootImpl() called with: context = [" + context + "], display = [" + display + "], session = [" + obj + "], b = [" + z + "]";
        while (context instanceof ContextWrapper) {
            str = str + ", ContextWrapper" + i + " = " + context;
            context = ((ContextWrapper) context).getBaseContext();
            i++;
        }
        AHook.getCallback().e(TAG, str, new Throwable());
    }
}
