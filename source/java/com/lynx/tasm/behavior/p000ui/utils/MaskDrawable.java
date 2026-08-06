package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.background.MaskLayerManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MaskDrawable extends LayerDrawable<MaskLayerManager> {
    private int mAlpha;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public MaskDrawable(LynxContext lynxContext, float f) {
        super(lynxContext, f);
        this.mAlpha = 255;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LayerDrawable
    public MaskLayerManager createLayerManager() {
        return new MaskLayerManager(this.mContext, this, this.mCurFontSize);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawMask(canvas);
    }

    public void drawMask(Canvas canvas) {
        if (((MaskLayerManager) this.mLayerManager).hasImageLayers()) {
            RectF rectF = new RectF(getBounds());
            ((MaskLayerManager) this.mLayerManager).draw(canvas, rectF, new RectF(this.mPaddingBox), new RectF(this.mContentBox), rectF, null, null, this.mBorderWidth != null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }
}
