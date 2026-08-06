package com.bytedance.lottie.animation.keyframe;

import com.bytedance.lottie.value.Keyframe;
import com.bytedance.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private Keyframe<K> cachedKeyframe;
    private final List<? extends Keyframe<K>> keyframes;
    protected LottieValueCallback<A> valueCallback;
    final List<AnimationListener> listeners = new ArrayList();
    private boolean isDiscrete = false;
    private float progress = 0.0f;

    /* loaded from: classes4.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    abstract A getValue(Keyframe<K> keyframe, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.keyframes = list;
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public void setProgress(float f) {
        if (f < getStartDelayProgress()) {
            f = getStartDelayProgress();
        } else if (f > getEndProgress()) {
            f = getEndProgress();
        }
        if (f == this.progress) {
            return;
        }
        this.progress = f;
        notifyListeners();
    }

    public void notifyListeners() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    private Keyframe<K> getCurrentKeyframe() {
        Keyframe<K> keyframe = this.cachedKeyframe;
        if (keyframe != null && keyframe.containsProgress(this.progress)) {
            return this.cachedKeyframe;
        }
        Keyframe<K> keyframe2 = this.keyframes.get(r0.size() - 1);
        if (this.progress < keyframe2.getStartProgress()) {
            for (int size = this.keyframes.size() - 1; size >= 0; size--) {
                keyframe2 = this.keyframes.get(size);
                if (keyframe2.containsProgress(this.progress)) {
                    break;
                }
            }
        }
        this.cachedKeyframe = keyframe2;
        return keyframe2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    private float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    private float getStartDelayProgress() {
        if (this.keyframes.isEmpty()) {
            return 0.0f;
        }
        return this.keyframes.get(0).getStartProgress();
    }

    float getEndProgress() {
        if (this.keyframes.isEmpty()) {
            return 1.0f;
        }
        return this.keyframes.get(r0.size() - 1).getEndProgress();
    }

    public A getValue() {
        return getValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
