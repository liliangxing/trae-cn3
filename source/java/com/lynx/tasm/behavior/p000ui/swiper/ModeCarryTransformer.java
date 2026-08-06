package com.lynx.tasm.behavior.p000ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;
import com.lynx.tasm.behavior.p000ui.swiper.ViewPager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ModeCarryTransformer implements ViewPager.PageTransformer {
    private float mNormTranslationFactor = 0.0f;
    private float mMinScaleX = 0.8f;
    private float mMaxScaleX = 1.0f;
    private float mMinScaleY = 0.8f;
    private float mMaxScaleY = 1.0f;

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.PageTransformer
    public void transformPage(ViewPager viewPager, View view, boolean z, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        if (viewPager == null || view == null || this.mMaxScaleX < this.mMinScaleX || this.mMaxScaleY < this.mMinScaleY || viewPager.getChildExpectSize() <= 0) {
            return;
        }
        float abs = Math.abs(i);
        int childExpectSize = viewPager.getChildExpectSize();
        float f6 = this.mMaxScaleX;
        float f7 = this.mMinScaleX;
        float f8 = childExpectSize;
        float f9 = this.mMaxScaleY;
        float f10 = f9 - (((f9 - this.mMinScaleY) * abs) / f8);
        float clamp = MathUtils.clamp(f6 - (((f6 - f7) * abs) / f8), f7, f6);
        float clamp2 = MathUtils.clamp(f10, this.mMinScaleY, this.mMaxScaleY);
        view.setScaleX(clamp);
        view.setScaleY(clamp2);
        float f11 = this.mNormTranslationFactor;
        if (f11 > 0.0f) {
            if (z) {
                f = f11 * f8;
                f2 = 2.0f - this.mMaxScaleY;
                f3 = this.mMinScaleY;
            } else {
                f = f11 * f8;
                f2 = 2.0f - this.mMaxScaleX;
                f3 = this.mMinScaleX;
            }
            float f12 = (f * (f2 - f3)) / 2.0f;
            float min = Math.min(abs, f8);
            float f13 = f8 / 2.0f;
            float abs2 = 1.0f - (Math.abs(min - f13) / f13);
            if (i > 0) {
                if (min >= f13) {
                    f4 = (-f12) + (abs2 * 0.5f * f12);
                } else {
                    f5 = abs2 * (-0.5f);
                    f4 = f5 * f12;
                }
            } else if (min <= f13) {
                f5 = abs2 * 0.5f;
                f4 = f5 * f12;
            } else {
                f4 = f12 - ((abs2 * 0.5f) * f12);
            }
            if (z) {
                view.setTranslationY(f4);
            } else {
                view.setTranslationX(f4);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.PageTransformer
    public void reset(View view) {
        if (view != null) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }
    }

    public void setNormTranslationFactor(float f) {
        this.mNormTranslationFactor = f;
    }

    public void setMinScaleX(float f) {
        this.mMinScaleX = f;
    }

    public void setMaxScaleX(float f) {
        this.mMaxScaleX = f;
    }

    public void setMinScaleY(float f) {
        this.mMinScaleY = f;
    }

    public void setMaxScaleY(float f) {
        this.mMaxScaleY = f;
    }
}
