package com.lynx.tasm.p001ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxCoverStartScaleType implements ScalingUtils.ScaleType {
    public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
        float width = rect.width() / i;
        float height = rect.height() / i2;
        float max = Math.max(width, height);
        float f3 = rect.left;
        float f4 = rect.top;
        if (width > height) {
            matrix.postTranslate(f3, 0.0f);
        } else {
            matrix.postTranslate(0.0f, f4);
        }
        matrix.setScale(max, max);
        return matrix;
    }
}
