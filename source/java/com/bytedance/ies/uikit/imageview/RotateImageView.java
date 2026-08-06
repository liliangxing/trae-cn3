package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class RotateImageView extends ImageView {
    private int mBitmapHeight;
    private int mBitmapWidth;
    private int mDegree;
    private Bitmap mOriginBitmap;
    private float mScale;
    private int mViewHeight;
    private int mViewWidth;

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDegree = 0;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mViewWidth = i3 - i;
        this.mViewHeight = i4 - i2;
        onRotateBitmap();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.mBitmapWidth = bitmap.getWidth();
            this.mBitmapHeight = bitmap.getHeight();
        }
        this.mOriginBitmap = bitmap;
    }

    public void rotateBitmap(int i) {
        this.mDegree = i;
        onRotateBitmap();
    }

    public Rect getRotateImageRect() {
        Rect rect = new Rect();
        float scale = getScale();
        this.mScale = scale;
        int i = this.mBitmapWidth;
        int i2 = (int) (i * scale);
        int i3 = this.mBitmapHeight;
        int i4 = (int) (i3 * scale);
        int i5 = this.mDegree;
        if (i5 == 90 || i5 == 270) {
            i2 = (int) (i3 * scale);
            i4 = (int) (i * scale);
        }
        rect.left = (this.mViewWidth - i2) / 2;
        rect.top = (this.mViewHeight - i4) / 2;
        rect.right = (this.mViewWidth + i2) / 2;
        rect.bottom = (this.mViewHeight + i4) / 2;
        return rect;
    }

    public Bitmap getCurrentRotateBitmap() {
        Matrix matrix = new Matrix();
        float scale = getScale();
        this.mScale = scale;
        matrix.postScale(scale, scale);
        float f = this.mBitmapWidth;
        float f2 = this.mScale;
        matrix.postTranslate((this.mViewWidth - ((int) (f * f2))) / 2.0f, (this.mViewHeight - ((int) (this.mBitmapHeight * f2))) / 2.0f);
        matrix.postRotate(this.mDegree, this.mViewWidth / 2, this.mViewHeight / 2);
        Bitmap bitmap = this.mOriginBitmap;
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.mOriginBitmap.getHeight(), matrix, true);
    }

    private void onRotateBitmap() {
        if (this.mViewWidth * this.mViewHeight * this.mBitmapHeight * this.mBitmapWidth == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        float scale = getScale();
        this.mScale = scale;
        matrix.postScale(scale, scale);
        float f = this.mBitmapWidth;
        float f2 = this.mScale;
        matrix.postTranslate((this.mViewWidth - ((int) (f * f2))) / 2.0f, (this.mViewHeight - ((int) (this.mBitmapHeight * f2))) / 2.0f);
        matrix.postRotate(this.mDegree, this.mViewWidth / 2, this.mViewHeight / 2);
        setImageMatrix(matrix);
    }

    public float getScale() {
        int i = this.mBitmapWidth;
        int i2 = this.mBitmapHeight;
        int i3 = this.mDegree;
        if (i3 == 90 || i3 == 270) {
            i2 = i;
            i = i2;
        }
        int i4 = this.mViewWidth;
        float f = i > i4 ? (i4 * 1.0f) / i : 1.0f;
        int i5 = this.mViewHeight;
        float f2 = i2 > i5 ? (i5 * 1.0f) / i2 : 1.0f;
        return f > f2 ? f2 : f;
    }
}
