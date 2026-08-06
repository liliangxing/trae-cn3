package com.bytedance.lottie.model.animatable;

import android.graphics.PointF;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.PathKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.PointKeyframeAnimation;
import com.bytedance.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue() {
        this.keyframes = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.keyframes = list;
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (this.keyframes.get(0).isStatic()) {
            return new PointKeyframeAnimation(this.keyframes);
        }
        return new PathKeyframeAnimation(this.keyframes);
    }

    public List<Keyframe<PointF>> getKeyframes() {
        return this.keyframes;
    }
}
