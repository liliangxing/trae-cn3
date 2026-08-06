package com.lynx.tasm.behavior.ui.background;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* loaded from: classes7.dex */
public abstract class BackgroundGradientLayer extends BackgroundLayerDrawable {
    protected static float positionNotSet = -2.0f;
    protected Shader mShader;
    protected int mWidth = 0;
    protected int mHeight = 0;
    protected final Paint mPaint = new Paint(1);
    protected int[] mColors = null;
    protected float[] mPositions = null;

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public boolean isReady() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public void onAttach() {
    }

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public void onDetach() {
    }

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public void onSizeChanged(int i, int i2) {
    }

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public int getImageWidth() {
        return this.mWidth;
    }

    @Override // com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable
    public int getImageHeight() {
        return this.mHeight;
    }

    public Shader getShader() {
        return this.mShader;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mShader == null) {
            LLog.e("gradient", "BackgroundGradientLayer.draw() must be called after setBounds()");
        }
        this.mPaint.setShader(this.mShader);
        if (getPathEffect() != null) {
            canvas.drawPath(getPathEffect(), this.mPaint);
        } else {
            canvas.drawRect(getBounds(), this.mPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setColorAndStop(ReadableArray readableArray, ReadableArray readableArray2) {
        if (readableArray2.size() != 0 && readableArray.size() != readableArray2.size()) {
            LLog.e("Gradient", "native parser error, color and stop must have same size");
            return;
        }
        this.mColors = new int[readableArray.size()];
        if (readableArray2.size() == readableArray.size()) {
            this.mPositions = new float[readableArray2.size()];
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mColors;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = (int) readableArray.getLong(i);
            float[] fArr = this.mPositions;
            if (fArr != null) {
                fArr[i] = ((float) readableArray2.getDouble(i)) / 100.0f;
            }
            i++;
        }
    }
}
