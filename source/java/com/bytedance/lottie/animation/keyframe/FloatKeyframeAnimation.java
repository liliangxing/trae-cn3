package com.bytedance.lottie.animation.keyframe;

import com.bytedance.lottie.utils.MiscUtils;
import com.bytedance.lottie.value.Keyframe;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    private static final Float ZERO = Float.valueOf(0.0f);
    private static final Float ONE = Float.valueOf(1.0f);
    private static final Float F30 = Float.valueOf(30.0f);
    private static final Float F35 = Float.valueOf(35.0f);
    private static final Float F60 = Float.valueOf(60.0f);
    private static final Float F90 = Float.valueOf(90.0f);
    private static final Float F100 = Float.valueOf(100.0f);
    private static final Float F180 = Float.valueOf(180.0f);
    private static final Float F197 = Float.valueOf(197.0f);

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<Float>) keyframe, f);
    }

    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    Float getValue(Keyframe<Float> keyframe, float f) {
        Float f2;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            if (keyframe.getComposition() != null) {
                throw new IllegalStateException("Missing values for keyframe. and " + keyframe.toString() + ".Composition is" + keyframe.getComposition().toString());
            }
            throw new IllegalStateException("Missing values for keyframe. and " + keyframe.toString());
        }
        if (this.valueCallback != null && (f2 = (Float) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
            return f2;
        }
        float lerp = MiscUtils.lerp(keyframe.startValue.floatValue(), keyframe.endValue.floatValue(), f);
        if (lerp == 0.0f) {
            return ZERO;
        }
        if (lerp == 1.0f) {
            return ONE;
        }
        if (lerp == 30.0f) {
            return F30;
        }
        if (lerp == 35.0f) {
            return F35;
        }
        if (lerp == 60.0f) {
            return F60;
        }
        if (lerp == 90.0f) {
            return F90;
        }
        if (lerp == 100.0f) {
            return F100;
        }
        if (lerp == 180.0f) {
            return F180;
        }
        if (lerp == 197.0f) {
            return F197;
        }
        return Float.valueOf(lerp);
    }
}
