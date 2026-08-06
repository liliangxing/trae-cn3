package com.bytedance.lottie.model.animatable;

import com.bytedance.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb.toString();
    }
}
