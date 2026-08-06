package com.bytedance.lottie.model.animatable;

import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    @Override // com.bytedance.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super((List) list);
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new FloatKeyframeAnimation(this.keyframes);
    }
}
