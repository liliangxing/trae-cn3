package com.lynx.tasm.animation.layout;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes6.dex */
class OpacityAnimation extends Animation {
    private final float mDeltaOpacity;
    private final float mStartOpacity;
    private final View mView;

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpacityAnimation(View view, float f, float f2) {
        this.mView = view;
        this.mStartOpacity = f;
        this.mDeltaOpacity = f2 - f;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        this.mView.setAlpha(this.mStartOpacity + (this.mDeltaOpacity * f));
    }
}
