package com.bytedance.mira.plugin.hook.flipped;

import android.os.Build;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedImpl;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedV1Impl;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedV2Impl;
import com.bytedance.mira.plugin.hook.flipped.compat.IFlipped;

/* loaded from: classes4.dex */
public class Flipped {
    public static void invokeHiddenApiRestrictions() {
        generate().invokeHiddenApiRestrictions();
    }

    private static IFlipped generate() {
        if (isAndroidRHigher()) {
            return new FlippedV2Impl();
        }
        if (isAndroidPHigher()) {
            return new FlippedV1Impl();
        }
        return new FlippedImpl();
    }

    private static boolean isAndroidRHigher() {
        return Build.VERSION.SDK_INT >= 30 || (Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    private static boolean isAndroidPHigher() {
        return Build.VERSION.SDK_INT >= 28 || (Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }
}
