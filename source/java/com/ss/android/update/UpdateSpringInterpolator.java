package com.ss.android.update;

import android.view.animation.Interpolator;

/* loaded from: classes7.dex */
public class UpdateSpringInterpolator implements Interpolator {
    private float mFactor;

    public UpdateSpringInterpolator() {
        this.mFactor = 1.0f;
    }

    public UpdateSpringInterpolator(float f) {
        this.mFactor = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (-10.0f) * f) * Math.sin(((f - (r2 / 4.0f)) * 6.283185307179586d) / this.mFactor)) + 1.0d);
    }
}
