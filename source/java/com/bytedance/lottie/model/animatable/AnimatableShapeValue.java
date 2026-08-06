package com.bytedance.lottie.model.animatable;

import android.graphics.Path;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.bytedance.lottie.model.content.ShapeData;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    @Override // com.bytedance.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    @Override // com.bytedance.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
        return new ShapeKeyframeAnimation(this.keyframes);
    }
}
