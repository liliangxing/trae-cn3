package com.bytedance.bdturing.livedetect.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.R;

/* loaded from: classes3.dex */
public class AutoFixTextureView extends TextureView {
    private static final String TAG = "AutoFixTextureView";
    private int mHeight;
    private int mRatioHeight;
    private int mRatioWidth;
    private int mWidth;
    private float mWidthHeightRatio;

    public AutoFixTextureView(Context context) {
        this(context, null);
    }

    public AutoFixTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFixTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.turing_autofix_textureview);
        this.mWidthHeightRatio = obtainStyledAttributes.getFloat(R.styleable.turing_autofix_textureview_wh_ratio, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void setAspectRatio(int i, int i2) {
        this.mRatioWidth = i;
        this.mRatioHeight = i2;
        configureTransform(new Size(i, i2));
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
    }

    private void configureTransform(Size size) {
        if (((Activity) getContext()) == null || size == null || size.getWidth() == 0 || size.getHeight() == 0 || Math.round(((size.getWidth() * 1.0f) / size.getHeight()) * 100.0f) / 100.0f == Math.round(((this.mWidth * 1.0f) / this.mHeight) * 100.0f) / 100.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
        RectF rectF2 = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        float min = (Math.min(this.mWidth, this.mHeight) * 1.0f) / Math.min(size.getWidth(), size.getHeight());
        float height = ((size.getHeight() * min) / 2.0f) - (this.mHeight / 2);
        float width = ((size.getWidth() * min) / 2.0f) - (this.mWidth / 2);
        LogUtil.d(TAG, "=====>configureTransform:offsetY=" + height + ":offSetX=" + width);
        matrix.postScale(min, min, centerX, centerY);
        matrix.postTranslate(width, height);
        setTransform(matrix);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.mRatioHeight;
        if (i4 == 0 || (i3 = this.mRatioWidth) == 0) {
            float f = this.mWidthHeightRatio;
            if (f > 0.0f) {
                if (size > 0) {
                    size2 = (int) (size / f);
                } else if (size2 > 0) {
                    size = (int) (size2 * f);
                }
            }
            setMeasuredDimension(size, size2);
            return;
        }
        if (size < (size2 * i3) / i4) {
            setMeasuredDimension(size, (i4 * size) / i3);
        } else {
            setMeasuredDimension((i3 * size2) / i4, size2);
        }
    }
}
