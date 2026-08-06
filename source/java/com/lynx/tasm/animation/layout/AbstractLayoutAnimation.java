package com.lynx.tasm.animation.layout;

import android.graphics.Rect;
import android.view.animation.Animation;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.InterpolatorFactory;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractLayoutAnimation {
    protected AnimationInfo mInfo = new AnimationInfo();

    abstract Animation createAnimationImpl(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        AnimationInfo animationInfo = this.mInfo;
        return animationInfo != null && animationInfo.getDuration() > 0;
    }

    protected void reset() {
        this.mInfo.setDuration(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Animation createAnimation(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect, float f) {
        if (!isValid()) {
            return null;
        }
        Animation createAnimationImpl = createAnimationImpl(lynxUI, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect, f);
        if (createAnimationImpl != null) {
            createAnimationImpl.setDuration(this.mInfo.getDuration());
            createAnimationImpl.setStartOffset(this.mInfo.getDelay());
            createAnimationImpl.setInterpolator(InterpolatorFactory.getInterpolator(this.mInfo));
        }
        return createAnimationImpl;
    }

    public void setInterpolator(ReadableArray readableArray) {
        this.mInfo.setTimingFunction(readableArray, 0);
    }

    public void setInterpolator(int i, float f, float f2, float f3, float f4, int i2) {
        this.mInfo.setTimingFunction(i, f, f2, f3, f4, i2);
    }

    public void setAnimatedProperty(int i) {
        this.mInfo.setProperty(i);
    }

    public void setDelay(long j) {
        this.mInfo.setDelay(j);
    }

    public void setDuration(long j) {
        this.mInfo.setDuration(j);
    }
}
