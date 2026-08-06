package com.bytedance.ss.reflector;

import android.os.Build;
import com.bytedance.ss.reflector.internal.DoubleReflector;
import com.bytedance.ss.reflector.internal.Reflector;

/* loaded from: classes5.dex */
public class ReflectorFactory {
    public static IReflector getReflector() {
        if (Build.VERSION.SDK_INT >= 28 || (Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            return DoubleReflector.getInstance();
        }
        return Reflector.getInstance();
    }
}
