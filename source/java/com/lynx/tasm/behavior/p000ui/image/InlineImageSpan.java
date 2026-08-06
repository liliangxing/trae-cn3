package com.lynx.tasm.behavior.p000ui.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class InlineImageSpan extends AbsInlineImageSpan {
    LynxImageManager mLynxImageManager;

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onAttachedToWindow() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onDetachedFromWindow() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onFinishTemporaryDetach() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onStartTemporaryDetach() {
    }

    public InlineImageSpan(int i, int i2, int[] iArr, LynxImageManager lynxImageManager) {
        super(i, i2, iArr);
        this.mLynxImageManager = lynxImageManager;
        lynxImageManager.onLayoutUpdated(getWidth(), getHeight(), 0, 0, 0, 0);
        this.mLynxImageManager.setDisableDefaultResize(true);
    }

    public InlineImageSpan(int i, int i2, int[] iArr) {
        super(i, i2, iArr);
    }

    public void setImageManager(LynxImageManager lynxImageManager) {
        this.mLynxImageManager = lynxImageManager;
        lynxImageManager.onLayoutUpdated(getWidth(), getHeight(), 0, 0, 0, 0);
        this.mLynxImageManager.setDisableDefaultResize(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void setCallback(Drawable.Callback callback) {
        super.setCallback(callback);
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        this.mLynxImageManager.updateNodeProps();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void handleRequestResult() {
        super.handleRequestResult();
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.tryHandleResult();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public Drawable getDrawable() {
        return this.mLynxImageManager.getSrcImageDrawable();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (getCallback() == null) {
            return;
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }
}
