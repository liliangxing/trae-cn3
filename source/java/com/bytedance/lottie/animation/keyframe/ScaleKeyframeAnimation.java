package com.bytedance.lottie.animation.keyframe;

import com.bytedance.lottie.utils.MiscUtils;
import com.bytedance.lottie.value.Keyframe;
import com.bytedance.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<ScaleXY>) keyframe, f);
    }

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f) {
        ScaleXY scaleXY;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY2 = keyframe.startValue;
        ScaleXY scaleXY3 = keyframe.endValue;
        return (this.valueCallback == null || (scaleXY = (ScaleXY) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY2, scaleXY3, f, getLinearCurrentKeyframeProgress(), getProgress())) == null) ? ScaleXY.Pool.obtain(MiscUtils.lerp(scaleXY2.getScaleX(), scaleXY3.getScaleX(), f), MiscUtils.lerp(scaleXY2.getScaleY(), scaleXY3.getScaleY(), f)) : scaleXY;
    }
}
