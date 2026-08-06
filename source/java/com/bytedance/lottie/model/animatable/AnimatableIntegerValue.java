package com.bytedance.lottie.model.animatable;

import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    @Override // com.bytedance.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableIntegerValue() {
        super(100);
    }

    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new IntegerKeyframeAnimation(this.keyframes);
    }
}
