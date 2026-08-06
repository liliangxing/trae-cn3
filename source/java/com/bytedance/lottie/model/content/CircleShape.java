package com.bytedance.lottie.model.content;

import android.graphics.PointF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.content.Content;
import com.bytedance.lottie.animation.content.EllipseContent;
import com.bytedance.lottie.model.animatable.AnimatablePointValue;
import com.bytedance.lottie.model.animatable.AnimatableValue;
import com.bytedance.lottie.model.layer.BaseLayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CircleShape implements ContentModel {
    private final boolean isReversed;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z) {
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.isReversed = z;
    }

    @Override // com.bytedance.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String getName() {
        return this.name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public boolean isReversed() {
        return this.isReversed;
    }
}
