package com.lynx.tasm.rendernode.compat;

import android.os.Build;

/* loaded from: classes7.dex */
public class RenderNodeFactory {
    static volatile RenderNodeFactory mInstance;

    public static RenderNodeFactory getInstance() {
        try {
            if (mInstance == null) {
                synchronized (RenderNodeFactory.class) {
                    if (mInstance == null) {
                        mInstance = new RenderNodeFactory();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mInstance;
    }

    public RenderNodeCompat createRenderNodeCompat() {
        RenderNodeCompat renderNodeV23Impl;
        if (Build.VERSION.SDK_INT >= 29) {
            renderNodeV23Impl = new RenderNodeImpl();
        } else {
            renderNodeV23Impl = new RenderNodeV23Impl();
        }
        renderNodeV23Impl.init();
        return renderNodeV23Impl;
    }
}
