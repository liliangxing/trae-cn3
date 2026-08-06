package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.background.LayerManager;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.utils.FloatUtils;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LayerDrawable<T extends LayerManager> extends Drawable {
    protected final Spacing mBorderWidth;
    protected final LynxContext mContext;
    protected float mCurFontSize;
    protected T mLayerManager;
    private int mLayoutDirection;
    protected final float[] mPaddingWidth;
    protected final Rect mPaddingBox = new Rect();
    protected final Rect mContentBox = new Rect();

    protected abstract T createLayerManager();

    public boolean onResolvedLayoutDirectionChanged(int i) {
        return false;
    }

    public LayerDrawable(LynxContext lynxContext, float f) {
        this.mLayerManager = null;
        this.mContext = lynxContext;
        this.mCurFontSize = f;
        this.mLayerManager = createLayerManager();
        float[] fArr = new float[4];
        this.mPaddingWidth = fArr;
        Arrays.fill(fArr, 0.0f);
        if (lynxContext.getCssAlignWithLegacyW3c()) {
            this.mBorderWidth = new Spacing(3.0f);
        } else {
            this.mBorderWidth = new Spacing();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mLayerManager.configureBounds(rect);
        updateContentBox();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBitmapConfig(Bitmap.Config config) {
        T t = this.mLayerManager;
        if (t == null) {
            return;
        }
        t.setBitmapConfig(config);
    }

    public void setLayerImage(ReadableArray readableArray, LynxBaseUI lynxBaseUI) {
        this.mLayerManager.setLayerImage(readableArray, lynxBaseUI);
    }

    public void setLayerPosition(ReadableArray readableArray) {
        this.mLayerManager.setLayerPosition(readableArray);
    }

    public void setLayerSize(ReadableArray readableArray) {
        this.mLayerManager.setLayerSize(readableArray);
    }

    public void setLayerOrigin(ReadableArray readableArray) {
        this.mLayerManager.setLayerOrigin(readableArray);
    }

    public void setLayerRepeat(ReadableArray readableArray) {
        this.mLayerManager.setLayerRepeat(readableArray);
    }

    public void setLayerClip(ReadableArray readableArray) {
        this.mLayerManager.setLayerClip(readableArray);
    }

    public boolean setBorderWidth(int i, float f) {
        return this.mBorderWidth.set(i, f);
    }

    public boolean setPaddingWidth(float f, float f2, float f3, float f4) {
        boolean z = false;
        if (!FloatUtils.floatsEqual(this.mPaddingWidth[0], f)) {
            this.mPaddingWidth[0] = f;
            z = true;
        }
        if (!FloatUtils.floatsEqual(this.mPaddingWidth[1], f2)) {
            this.mPaddingWidth[1] = f2;
            z = true;
        }
        if (!FloatUtils.floatsEqual(this.mPaddingWidth[2], f3)) {
            this.mPaddingWidth[2] = f3;
            z = true;
        }
        if (FloatUtils.floatsEqual(this.mPaddingWidth[3], f4)) {
            return z;
        }
        this.mPaddingWidth[3] = f4;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateContentBox() {
        Rect bounds = getBounds();
        this.mPaddingBox.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        this.mPaddingBox.left = (int) (r1.left + directionAwareBorderInsets.left);
        this.mPaddingBox.top = (int) (r1.top + directionAwareBorderInsets.top);
        this.mPaddingBox.right = (int) (r1.right - directionAwareBorderInsets.right);
        this.mPaddingBox.bottom = (int) (r1.bottom - directionAwareBorderInsets.bottom);
        this.mContentBox.set(this.mPaddingBox.left, this.mPaddingBox.top, this.mPaddingBox.right, this.mPaddingBox.bottom);
        this.mContentBox.top = (int) (r0.top + this.mPaddingWidth[0]);
        this.mContentBox.right = (int) (r0.right - this.mPaddingWidth[1]);
        this.mContentBox.bottom = (int) (r0.bottom - this.mPaddingWidth[2]);
        this.mContentBox.left = (int) (r0.left + this.mPaddingWidth[3]);
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean setResolvedLayoutDirection(int i) {
        if (this.mLayoutDirection == i) {
            return false;
        }
        this.mLayoutDirection = i;
        return onResolvedLayoutDirectionChanged(i);
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f;
        }
        float raw = spacing.getRaw(i);
        return MeasureUtils.isUndefined(raw) ? f : raw;
    }

    public RectF getDirectionAwareBorderInsets() {
        float f = this.mBorderWidth.get(1);
        float f2 = this.mBorderWidth.get(3);
        float f3 = this.mBorderWidth.get(0);
        float f4 = this.mBorderWidth.get(2);
        Rect bounds = getBounds();
        float f5 = f3 + f4;
        if (f5 > bounds.width() && bounds.width() >= 1) {
            float width = bounds.width() / f5;
            f3 *= width;
            f4 *= width;
        }
        float f6 = f + f2;
        if (f6 > bounds.height() && bounds.height() >= 1) {
            float height = bounds.height() / f6;
            f *= height;
            f2 *= height;
        }
        return new RectF(f3, f, f4, f2);
    }

    public void onAttach() {
        this.mLayerManager.onAttach();
    }

    public void onDetach() {
        this.mLayerManager.onDetach();
    }

    public void setEnableBitmapGradient(boolean z) {
        this.mLayerManager.setEnableBitmapGradient(z);
        invalidateSelf();
    }
}
