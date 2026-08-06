package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Bundle;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes5.dex */
public class BadParcelableLancet {
    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public Bundle getBundleExtra(String str) {
        Bundle bundle = (Bundle) Origin.call();
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundle != null && context != null) {
            bundle.setClassLoader(context.getClassLoader());
        }
        return bundle;
    }
}
