package com.bytedance.lottie.model.animatable;

import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    @Override // com.bytedance.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new ColorKeyframeAnimation(this.keyframes);
    }
}
