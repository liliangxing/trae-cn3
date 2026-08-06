package com.lynx.tasm.behavior.p000ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;
import com.lynx.tasm.behavior.p000ui.swiper.ViewPager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ModeCoverFlowTransformer implements ViewPager.PageTransformer {
    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.PageTransformer
    public void transformPage(ViewPager viewPager, View view, boolean z, int i) {
        if (viewPager == null || view == null) {
            return;
        }
        int childExpectSize = viewPager.getChildExpectSize();
        float clamp = MathUtils.clamp((childExpectSize != 0 ? i / childExpectSize : 0.0f) * 9.0f, -9.0f, 9.0f);
        view.setCameraDistance(1280.0f);
        if (z) {
            view.setRotationX(clamp);
        } else {
            view.setRotationY(-clamp);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.PageTransformer
    public void reset(View view) {
        if (view != null) {
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
        }
    }
}
