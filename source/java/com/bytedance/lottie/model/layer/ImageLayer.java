package com.bytedance.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.LottieProperty;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.LottieValueCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.paint = new Paint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        try {
            Bitmap bitmap = getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                float dpScale = Utils.dpScale();
                this.paint.setAlpha(i);
                BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
                if (baseKeyframeAnimation != null) {
                    this.paint.setColorFilter(baseKeyframeAnimation.getValue());
                }
                canvas.save();
                canvas.concat(matrix);
                this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                this.dst.set(0, 0, (int) (bitmap.getWidth() * dpScale), (int) (bitmap.getHeight() * dpScale));
                canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
                canvas.restore();
            }
        } catch (Exception e) {
            Log.e("byted-lottie", "ImageLayer draw with exception: " + e.toString());
        }
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer, com.bytedance.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        if (getBitmap() != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, r6.getWidth()), Math.min(rectF.bottom, r6.getHeight()));
            this.boundsMatrix.mapRect(rectF);
        }
    }

    private Bitmap getBitmap() {
        return this.lottieDrawable.getImageAsset(this.layerModel.getRefId());
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer, com.bytedance.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
            } else {
                this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }
}
