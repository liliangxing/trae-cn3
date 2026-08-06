package com.bytedance.lottie.model.content;

import android.graphics.Path;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.content.Content;
import com.bytedance.lottie.animation.content.FillContent;
import com.bytedance.lottie.model.animatable.AnimatableColorValue;
import com.bytedance.lottie.model.animatable.AnimatableIntegerValue;
import com.bytedance.lottie.model.layer.BaseLayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeFill implements ContentModel {
    private final AnimatableColorValue color;
    private final boolean fillEnabled;
    private final Path.FillType fillType;
    private final String name;
    private final AnimatableIntegerValue opacity;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue) {
        this.name = str;
        this.fillEnabled = z;
        this.fillType = fillType;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    @Override // com.bytedance.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.fillEnabled + '}';
    }
}
