package com.bytedance.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.LottieProperty;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.bytedance.lottie.model.content.ShapeStroke;
import com.bytedance.lottie.model.layer.BaseLayer;
import com.bytedance.lottie.value.LottieValueCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.layer = baseLayer;
        this.name = shapeStroke.getName();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.getColor().createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
    }

    @Override // com.bytedance.lottie.animation.content.BaseStrokeContent, com.bytedance.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.colorAnimation.getValue().intValue());
        if (this.colorFilterAnimation != null) {
            this.paint.setColorFilter(this.colorFilterAnimation.getValue());
        }
        super.draw(canvas, matrix, i);
    }

    @Override // com.bytedance.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.lottie.animation.content.BaseStrokeContent, com.bytedance.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorAnimation);
        }
    }
}
