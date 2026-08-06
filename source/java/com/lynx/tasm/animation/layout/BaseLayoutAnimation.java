package com.lynx.tasm.animation.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: classes6.dex */
public abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    abstract boolean isReverse();

    @Override // com.lynx.tasm.animation.layout.AbstractLayoutAnimation
    Animation createAnimationImpl(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect, float f) {
        View view = lynxUI.getView();
        int property = this.mInfo.getProperty();
        if (property == 2) {
            return new ScaleAnimation(isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
        }
        if (property == 4) {
            return new ScaleAnimation(1.0f, 1.0f, isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
        }
        if (property == 8) {
            float f2 = isReverse() ? 1.0f : 0.0f;
            float f3 = isReverse() ? 0.0f : 1.0f;
            return new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        }
        return new OpacityAnimation(view, isReverse() ? f : 0.0f, isReverse() ? 0.0f : f);
    }
}
