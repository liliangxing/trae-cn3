package com.bytedance.lottie.animation.keyframe;

import com.bytedance.lottie.model.DocumentData;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes4.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<DocumentData>) keyframe, f);
    }

    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        return keyframe.startValue;
    }
}
