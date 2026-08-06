package com.lynx.tasm.animation.layout;

import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r21.getHeight() == r25) goto L16;
     */
    @Override // com.lynx.tasm.animation.layout.AbstractLayoutAnimation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Animation createAnimationImpl(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect, float f) {
        lynxUI.getView();
        boolean z = false;
        boolean z2 = (lynxUI.getOriginLeft() == i && lynxUI.getOriginTop() == i2) ? false : true;
        if (lynxUI.getWidth() != i3) {
        }
        z = true;
        if (!z2 && !z) {
            return null;
        }
        if (z2 && !z) {
            return new TranslateAnimation(lynxUI.getOriginLeft() - i, 0.0f, lynxUI.getOriginTop() - i2, 0.0f);
        }
        return new PositionAndSizeAnimation(lynxUI, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
    }
}
