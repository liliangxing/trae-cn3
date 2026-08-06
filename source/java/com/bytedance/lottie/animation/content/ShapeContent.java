package com.bytedance.lottie.animation.content;

import android.graphics.Path;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.model.content.ShapeData;
import com.bytedance.lottie.model.content.ShapePath;
import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.lottie.model.layer.BaseLayer;
import com.bytedance.lottie.utils.Utils;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Path> shapeAnimation;
    private TrimPathContent trimPath;

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.name = shapePath.getName();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> createAnimation = shapePath.getShapePath().createAnimation();
        this.shapeAnimation = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    @Override // com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.bytedance.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.Simultaneously) {
                    this.trimPath = trimPathContent;
                    trimPathContent.addListener(this);
                }
            }
        }
    }

    @Override // com.bytedance.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.shapeAnimation.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.bytedance.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }
}
