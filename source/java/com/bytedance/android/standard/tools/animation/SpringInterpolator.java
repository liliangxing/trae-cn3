package com.bytedance.android.standard.tools.animation;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public class SpringInterpolator implements Interpolator {
    private float mFactor;

    public SpringInterpolator() {
        this.mFactor = 1.0f;
    }

    public SpringInterpolator(float f) {
        this.mFactor = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (-10.0f) * f) * Math.sin(((f - (r2 / 4.0f)) * 6.283185307179586d) / this.mFactor)) + 1.0d);
    }
}
