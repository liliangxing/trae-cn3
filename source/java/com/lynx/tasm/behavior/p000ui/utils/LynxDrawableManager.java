package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.LayerDrawable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxDrawableManager<T extends LayerDrawable<?>> {
    protected final LynxContext mContext;
    private Drawable.Callback mDrawableCallback = null;
    protected float mFontSize;
    protected T mLayerDrawable;

    protected abstract T createLayerDrawable();

    public LynxDrawableManager(LynxContext lynxContext) {
        this.mContext = lynxContext;
    }

    public void setDrawableCallback(Drawable.Callback callback) {
        this.mDrawableCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getOrCreateViewLayer() {
        if (this.mLayerDrawable == null) {
            T createLayerDrawable = createLayerDrawable();
            this.mLayerDrawable = createLayerDrawable;
            createLayerDrawable.setCallback(this.mDrawableCallback);
        }
        return this.mLayerDrawable;
    }

    public T getDrawable() {
        return this.mLayerDrawable;
    }

    public void setBitmapConfig(Bitmap.Config config) {
        getOrCreateViewLayer().setBitmapConfig(config);
    }

    public void setLayerImage(ReadableArray readableArray, LynxBaseUI lynxBaseUI) {
        getOrCreateViewLayer().setLayerImage(readableArray, lynxBaseUI);
    }

    public void setLayerPosition(ReadableArray readableArray) {
        getOrCreateViewLayer().setLayerPosition(readableArray);
    }

    public void setLayerSize(ReadableArray readableArray) {
        getOrCreateViewLayer().setLayerSize(readableArray);
    }

    public void setLayerOrigin(ReadableArray readableArray) {
        getOrCreateViewLayer().setLayerOrigin(readableArray);
    }

    public void setLayerRepeat(ReadableArray readableArray) {
        getOrCreateViewLayer().setLayerRepeat(readableArray);
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateViewLayer().setBorderWidth(i, f);
    }

    public void setLayerClip(ReadableArray readableArray) {
        getOrCreateViewLayer().setLayerClip(readableArray);
    }

    public void updatePaddingWidths(float f, float f2, float f3, float f4) {
        T t = this.mLayerDrawable;
        if (t != null) {
            t.setPaddingWidth(f, f2, f3, f4);
        }
    }

    public void onAttach() {
        T t = this.mLayerDrawable;
        if (t == null) {
            return;
        }
        t.onAttach();
    }

    public void onDetach() {
        T t = this.mLayerDrawable;
        if (t == null) {
            return;
        }
        t.onDetach();
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public void setEnableBitmapGradient(boolean z) {
        getOrCreateViewLayer().setEnableBitmapGradient(z);
    }
}
