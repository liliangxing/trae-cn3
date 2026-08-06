package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class Hold extends Visibility {
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
