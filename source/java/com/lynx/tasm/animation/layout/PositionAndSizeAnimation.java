package com.lynx.tasm.animation.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PositionAndSizeAnimation extends Animation implements LayoutHandlingAnimation {
    private final int mBorderBottomWidth;
    private final int mBorderLeftWidth;
    private final int mBorderRightWidth;
    private final int mBorderTopWidth;
    private final Rect mBound;
    private int mDeltaHeight;
    private int mDeltaWidth;
    private float mDeltaX;
    private float mDeltaY;
    private final int mMarginBottom;
    private final int mMarginLeft;
    private final int mMarginRight;
    private final int mMarginTop;
    private final int mPaddingBottom;
    private final int mPaddingLeft;
    private final int mPaddingRight;
    private final int mPaddingTop;
    private int mStartHeight;
    private int mStartWidth;
    private float mStartX;
    private float mStartY;
    private final LynxUI mUI;
    private final View mView;

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }

    public PositionAndSizeAnimation(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        this.mUI = lynxUI;
        this.mView = lynxUI.getView();
        this.mPaddingLeft = i5;
        this.mPaddingTop = i6;
        this.mPaddingRight = i7;
        this.mPaddingBottom = i8;
        this.mMarginLeft = i9;
        this.mMarginTop = i10;
        this.mMarginRight = i11;
        this.mMarginBottom = i12;
        this.mBorderLeftWidth = i13;
        this.mBorderTopWidth = i14;
        this.mBorderRightWidth = i15;
        this.mBorderBottomWidth = i16;
        this.mBound = rect;
        calculateAnimation(i, i2, i3, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        this.mUI.updateLayout(Math.round(this.mStartX + (this.mDeltaX * f)), Math.round(this.mStartY + (this.mDeltaY * f)), Math.round(this.mStartWidth + (this.mDeltaWidth * f)), Math.round(this.mStartHeight + (this.mDeltaHeight * f)), this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mMarginLeft, this.mMarginTop, this.mMarginRight, this.mMarginBottom, this.mBorderLeftWidth, this.mBorderTopWidth, this.mBorderRightWidth, this.mBorderBottomWidth, this.mBound);
    }

    @Override // com.lynx.tasm.animation.layout.LayoutHandlingAnimation
    public void onLayoutUpdate(int i, int i2, int i3, int i4) {
        calculateAnimation(i, i2, i3, i4);
    }

    private void calculateAnimation(int i, int i2, int i3, int i4) {
        this.mStartX = this.mUI.getOriginLeft() - this.mUI.getTranslationX();
        this.mStartY = this.mUI.getOriginTop() - this.mUI.getTranslationY();
        this.mStartWidth = this.mUI.getWidth();
        int height = this.mUI.getHeight();
        this.mStartHeight = height;
        this.mDeltaX = i - this.mStartX;
        this.mDeltaY = i2 - this.mStartY;
        this.mDeltaWidth = i3 - this.mStartWidth;
        this.mDeltaHeight = i4 - height;
    }
}
