package com.bytedance.trae.conversation.widget.blur;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlurCircleAnimHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;", "", "view", "Lcom/bytedance/trae/conversation/widget/blur/BlurView;", "<init>", "(Lcom/bytedance/trae/conversation/widget/blur/BlurView;)V", "getView", "()Lcom/bytedance/trae/conversation/widget/blur/BlurView;", "currentState", "", "playingAnimator", "Landroid/animation/Animator;", "startAnim", "", "getAmplitude", "Lkotlin/Function0;", "", "startAnimOnce", "waveView", "amplitude", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "calcTargetCircleScale", "stopAnim", "isAnimating", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BlurCircleAnimHelper {
    private static final int STARTED = 0;
    private static final int STOPPED = 1;
    private static final String TAG = "BlurCircleAnim";
    private int currentState;
    private Animator playingAnimator;
    private final BlurView view;

    private final float calcTargetCircleScale(float amplitude) {
        return (float) (1.0f + (amplitude * 0.1d));
    }

    public BlurCircleAnimHelper(BlurView blurView) {
        Intrinsics.checkNotNullParameter(blurView, "view");
        this.view = blurView;
        this.currentState = 1;
    }

    public final BlurView getView() {
        return this.view;
    }

    public final void startAnim(final Function0<Float> getAmplitude) {
        Intrinsics.checkNotNullParameter(getAmplitude, "getAmplitude");
        if (this.currentState == 0) {
            return;
        }
        this.currentState = 0;
        startAnimOnce(this.view, ((Number) getAmplitude.invoke()).floatValue(), new Animator.AnimatorListener() { // from class: com.bytedance.trae.conversation.widget.blur.BlurCircleAnimHelper$startAnim$animatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                int i;
                Intrinsics.checkNotNullParameter(animation, "animation");
                BlurCircleAnimHelper.this.playingAnimator = null;
                i = BlurCircleAnimHelper.this.currentState;
                if (i == 1) {
                    return;
                }
                BlurCircleAnimHelper blurCircleAnimHelper = BlurCircleAnimHelper.this;
                blurCircleAnimHelper.startAnimOnce(blurCircleAnimHelper.getView(), ((Number) getAmplitude.invoke()).floatValue(), this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BlurCircleAnimHelper.this.playingAnimator = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Animator startAnimOnce(BlurView waveView, float amplitude, Animator.AnimatorListener animatorListener) {
        float calcTargetCircleScale = calcTargetCircleScale(amplitude);
        Animator animator = this.playingAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(waveView, "circleScale", waveView.getCircleScale(), calcTargetCircleScale, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addListener(animatorListener);
        ofFloat.start();
        ObjectAnimator objectAnimator = ofFloat;
        this.playingAnimator = objectAnimator;
        Intrinsics.checkNotNullExpressionValue(ofFloat, "apply(...)");
        return objectAnimator;
    }

    public final void stopAnim() {
        this.currentState = 1;
        Animator animator = this.playingAnimator;
        if (animator != null) {
            animator.removeAllListeners();
            animator.cancel();
        }
        this.playingAnimator = null;
    }

    public final boolean isAnimating() {
        return this.currentState == 0;
    }
}
