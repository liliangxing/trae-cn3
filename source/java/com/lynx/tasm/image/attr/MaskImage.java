package com.lynx.tasm.image.attr;

import com.lynx.tasm.behavior.ui.background.BackgroundGradientLayer;

/* loaded from: classes7.dex */
public class MaskImage implements Cloneable {
    private final BackgroundGradientLayer mGradientLayer;

    public MaskImage(BackgroundGradientLayer backgroundGradientLayer) {
        this.mGradientLayer = backgroundGradientLayer;
    }

    public BackgroundGradientLayer getGradientLayer() {
        return this.mGradientLayer;
    }
}
