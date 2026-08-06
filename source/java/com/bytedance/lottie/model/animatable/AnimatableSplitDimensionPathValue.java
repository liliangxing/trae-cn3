package com.bytedance.lottie.model.animatable;

import android.graphics.PointF;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue animatableXDimension;
    private final AnimatableFloatValue animatableYDimension;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.animatableXDimension = animatableFloatValue;
        this.animatableYDimension = animatableFloatValue2;
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
    }
}
