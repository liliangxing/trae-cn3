package com.bytedance.common.util;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes3.dex */
public class JellyBeanMR1V16Compat {
    private static BaseImpl mImpl;

    /* loaded from: classes3.dex */
    private static class BaseImpl {
        private BaseImpl() {
        }

        public void setBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* loaded from: classes3.dex */
    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V16Compat.BaseImpl
        public void setBackground(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    public static void setBackgroundForView(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        if (mImpl == null) {
            mImpl = new V16Impl();
        }
        mImpl.setBackground(view, drawable);
    }
}
