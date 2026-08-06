package com.bytedance.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.content.ContentGroup;
import com.bytedance.lottie.model.KeyPath;
import com.bytedance.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes()));
        this.contentGroup = contentGroup;
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
        this.contentGroup.draw(canvas, matrix, i);
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer, com.bytedance.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        this.contentGroup.getBounds(rectF, this.boundsMatrix);
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i, list, keyPath2);
    }
}
