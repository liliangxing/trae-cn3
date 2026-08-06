package com.bytedance.mira.plugin.hook.flipped.compat;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class FlippedV1Impl implements IFlipped {
    private static final String TAG = "FlippedV1Impl";

    @Override // com.bytedance.mira.plugin.hook.flipped.compat.IFlipped
    public void invokeHiddenApiRestrictions() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(invoke, new String[]{"L"});
            Log.e(TAG, "V1 invokeHiddenApiRestrictions success.");
        } catch (Exception e) {
            Log.e(TAG, "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
