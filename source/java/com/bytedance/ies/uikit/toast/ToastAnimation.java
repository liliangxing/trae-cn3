package com.bytedance.ies.uikit.toast;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: classes4.dex */
public class ToastAnimation {
    public static final long DURATION = 300;

    public static AnimatorSet showAlpha(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(300L);
        return animatorSet;
    }

    public static AnimatorSet hideAlpha(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
        animatorSet.setDuration(300L);
        return animatorSet;
    }
}
