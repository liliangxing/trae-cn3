package com.lynx.tasm.image.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public interface AnimationListener {
    void onAnimationCurrentLoop(Drawable drawable);

    void onAnimationFinalLoop(Drawable drawable);

    void onAnimationStart(Drawable drawable);
}
