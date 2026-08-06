package com.bytedance.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.LottieProperty;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.bytedance.lottie.model.KeyPath;
import com.bytedance.lottie.model.content.Repeater;
import com.bytedance.lottie.model.layer.BaseLayer;
import com.bytedance.lottie.utils.MiscUtils;
import com.bytedance.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final TransformKeyframeAnimation transform;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        this.name = repeater.getName();
        BaseKeyframeAnimation<Float, Float> createAnimation = repeater.getCopies().createAnimation();
        this.copies = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = repeater.getOffset().createAnimation();
        this.offset = createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        createAnimation2.addUpdateListener(this);
        TransformKeyframeAnimation createAnimation3 = repeater.getTransform().createAnimation();
        this.transform = createAnimation3;
        createAnimation3.addAnimationsToLayer(baseLayer);
        createAnimation3.addListener(this);
    }

    @Override // com.bytedance.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.contentGroup != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", arrayList, null);
    }

    @Override // com.bytedance.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        this.contentGroup.setContents(list, list2);
    }

    @Override // com.bytedance.lottie.animation.content.PathContent
    public Path getPath() {
        Path path = this.contentGroup.getPath();
        this.path.reset();
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.transform.getMatrixForRepeater(i + floatValue2));
            this.path.addPath(path, this.matrix);
        }
        return this.path;
    }

    @Override // com.bytedance.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        float floatValue3 = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float floatValue4 = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            float f = i2;
            this.matrix.preConcat(this.transform.getMatrixForRepeater(f + floatValue2));
            this.contentGroup.draw(canvas, this.matrix, (int) (i * MiscUtils.lerp(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.bytedance.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        this.contentGroup.getBounds(rectF, matrix);
    }

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.bytedance.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.bytedance.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.transform.applyValueCallback(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.REPEATER_COPIES) {
            this.copies.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.REPEATER_OFFSET) {
            this.offset.setValueCallback(lottieValueCallback);
        }
    }
}
