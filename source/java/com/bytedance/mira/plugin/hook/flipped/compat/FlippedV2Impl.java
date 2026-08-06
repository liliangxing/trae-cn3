package com.bytedance.mira.plugin.hook.flipped.compat;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class FlippedV2Impl implements IFlipped {
    private static final String TAG = "FlippedV2Impl";

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        System.loadLibrary("flipped");
    }

    @Override // com.bytedance.mira.plugin.hook.flipped.compat.IFlipped
    public void invokeHiddenApiRestrictions() {
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, new String[]{"L"});
            Log.e(TAG, "V2 invokeHiddenApiRestrictions success.");
        } catch (Exception e) {
            Log.e(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
