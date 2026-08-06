package com.bytedance.lottie.animation.keyframe;

import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyframeAnimation(List<? extends Keyframe<T>> list) {
        super(list);
    }
}
