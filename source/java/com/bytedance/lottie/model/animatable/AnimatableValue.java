package com.bytedance.lottie.model.animatable;

import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: classes4.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();
}
