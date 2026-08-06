package com.bytedance.common.util;

import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes3.dex */
public class JellyBeanV16Compat {
    private static BaseImpl mImpl = new V16Impl();

    /* loaded from: classes3.dex */
    private static class BaseImpl {
        public long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private BaseImpl() {
        }

        public void setViewBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* loaded from: classes3.dex */
    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super();
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public void setViewBackground(View view, Drawable drawable) {
            try {
                view.setBackground(drawable);
            } catch (Throwable unused) {
                view.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static void setViewBackground(View view, Drawable drawable) {
        mImpl.setViewBackground(view, drawable);
    }

    public static long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
        return mImpl.getTotalMem(memoryInfo);
    }
}
