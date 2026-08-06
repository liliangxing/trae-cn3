package com.lynx.tasm.behavior.p000ui.background;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundLinearGradientLayer extends BackgroundGradientLayer {
    private static final int ANGLE = 9;
    private static final int BOTTOM = 2;
    private static final int BOTTOM_LEFT = 8;
    private static final int BOTTOM_RIGHT = 7;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;
    private static final int TOP = 1;
    private static final int TOP_LEFT = 6;
    private static final int TOP_RIGHT = 5;
    private double mAngle;
    private int mDirectionType;
    private boolean mEnableBitmapGradient = false;

    public BackgroundLinearGradientLayer(ReadableArray readableArray) {
        if (readableArray == null) {
            LLog.e("LinearGradient", "native parse error array is null");
        } else {
            if (readableArray.size() < 3) {
                LLog.e("LinearGradient", "native parse error, array.size must be 4  ");
                return;
            }
            this.mAngle = readableArray.getDouble(0);
            setColorAndStop(readableArray.getArray(1), readableArray.getArray(2));
            this.mDirectionType = readableArray.size() == 4 ? readableArray.getInt(3) : 9;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        PointF pointF;
        this.mWidth = Math.max(rect.width(), 1);
        this.mHeight = Math.max(rect.height(), 1);
        int i = rect.left;
        int i2 = rect.top;
        if (this.mColors == null || this.mColors.length < 2) {
            this.mShader = null;
        } else if (this.mPositions != null && this.mPositions.length != this.mColors.length) {
            this.mShader = null;
        } else {
            PointF pointF2 = new PointF();
            PointF pointF3 = new PointF();
            try {
                float f = ((this.mWidth * 2.0f) * this.mHeight) / ((this.mWidth * this.mWidth) + (this.mHeight * this.mHeight));
                int i3 = this.mDirectionType;
                if (i3 == 1) {
                    float f2 = i;
                    pointF2.x = f2;
                    pointF2.y = this.mHeight + i2;
                    pointF3.x = f2;
                    pointF3.y = i2;
                } else if (i3 == 2) {
                    float f3 = i;
                    pointF2.x = f3;
                    pointF2.y = i2;
                    pointF3.x = f3;
                    pointF3.y = i2 + this.mHeight;
                } else if (i3 == 3) {
                    pointF2.x = this.mWidth + i;
                    float f4 = i2;
                    pointF2.y = f4;
                    pointF3.x = i;
                    pointF3.y = f4;
                } else if (i3 == 4) {
                    pointF2.x = i;
                    float f5 = i2;
                    pointF2.y = f5;
                    pointF3.x = i + this.mWidth;
                    pointF3.y = f5;
                } else if (i3 == 5) {
                    pointF2.x = (this.mWidth + i) - (this.mHeight * f);
                    float f6 = i2;
                    pointF2.y = (this.mWidth * f) + f6;
                    pointF3.x = i + this.mWidth;
                    pointF3.y = f6;
                } else if (i3 == 6) {
                    float f7 = i;
                    pointF2.x = (this.mHeight * f) + f7;
                    float f8 = i2;
                    pointF2.y = (this.mWidth * f) + f8;
                    pointF3.x = f7;
                    pointF3.y = f8;
                } else if (i3 == 7) {
                    float f9 = i;
                    pointF2.x = f9;
                    float f10 = i2;
                    pointF2.y = f10;
                    pointF3.x = f9 + (this.mHeight * f);
                    pointF3.y = f10 + (this.mWidth * f);
                } else if (i3 == 8) {
                    pointF2.x = this.mWidth + i;
                    float f11 = i2;
                    pointF2.y = f11;
                    pointF3.x = (i + this.mWidth) - (this.mHeight * f);
                    pointF3.y = f11 + (this.mWidth * f);
                } else {
                    PointF pointF4 = new PointF(this.mWidth / 2.0f, this.mHeight / 2.0f);
                    double radians = Math.toRadians(this.mAngle);
                    float sin = (float) Math.sin(radians);
                    float cos = (float) Math.cos(radians);
                    float tan = (float) Math.tan(radians);
                    if (sin >= 0.0f && cos >= 0.0f) {
                        pointF = new PointF(this.mWidth, 0.0f);
                    } else if (sin >= 0.0f && cos < 0.0f) {
                        pointF = new PointF(this.mWidth, this.mHeight);
                    } else if (sin < 0.0f && cos < 0.0f) {
                        pointF = new PointF(0.0f, this.mHeight);
                    } else {
                        pointF = new PointF(0.0f, 0.0f);
                    }
                    float f12 = i;
                    float f13 = i2;
                    pointF2.offset(f12, f13);
                    pointF3.offset(f12, f13);
                    pointF4.offset(f12, f13);
                    pointF.offset(f12, f13);
                    float f14 = ((pointF4.y - pointF.y) - (pointF4.x * tan)) + (pointF.x * tan);
                    pointF3.x = pointF4.x + ((sin * f14) / ((sin * tan) + cos));
                    pointF3.y = pointF4.y - (f14 / ((tan * tan) + 1.0f));
                    pointF2.x = (pointF4.x * 2.0f) - pointF3.x;
                    pointF2.y = (pointF4.y * 2.0f) - pointF3.y;
                }
                if (Build.VERSION.SDK_INT < 28 && this.mEnableBitmapGradient) {
                    TraceEvent.beginSection("createBitmapShader");
                    createBitmapShader(pointF2, pointF3, this.mColors, this.mPositions, (float) this.mAngle);
                    TraceEvent.endSection("createBitmapShader");
                } else {
                    this.mShader = new LinearGradient(pointF2.x, pointF2.y, pointF3.x, pointF3.y, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
                }
            } catch (Exception e) {
                this.mShader = null;
                this.mPaint.setColor(this.mColors[0]);
                e.printStackTrace();
                LLog.w("BackgroundLinearGradientLayer", "exception:\n" + e);
            }
        }
        super.setBounds(rect);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void setEnableBitmapGradient(boolean z) {
        this.mEnableBitmapGradient = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FloatColor {

        /* renamed from: a */
        float f4a;

        /* renamed from: b */
        float f5b;

        /* renamed from: g */
        float f6g;

        /* renamed from: r */
        float f7r;

        private FloatColor() {
            this.f7r = 0.0f;
            this.f6g = 0.0f;
            this.f5b = 0.0f;
            this.f4a = 0.0f;
        }

        void set(int i) {
            this.f4a = ((i >> 24) & 255) / 255.0f;
            this.f7r = ((i >> 16) & 255) / 255.0f;
            this.f6g = ((i >> 8) & 255) / 255.0f;
            this.f5b = (i & 255) / 255.0f;
        }

        void set(FloatColor floatColor) {
            this.f4a = floatColor.f4a;
            this.f7r = floatColor.f7r;
            this.f6g = floatColor.f6g;
            this.f5b = floatColor.f5b;
        }
    }

    private static void mix(FloatColor floatColor, FloatColor floatColor2, float f, int i, int[] iArr) {
        float f2 = 1.0f - f;
        int i2 = (int) (((floatColor.f7r * f2) + (floatColor2.f7r * f)) * 255.0f);
        int i3 = (int) (((floatColor.f6g * f2) + (floatColor2.f6g * f)) * 255.0f);
        iArr[i] = (((int) (((floatColor.f4a * f2) + (floatColor2.f4a * f)) * 255.0f)) << 24) | (i2 << 16) | (i3 << 8) | ((int) (((floatColor.f5b * f2) + (floatColor2.f5b * f)) * 255.0f));
    }

    private static void fillPixels(int[] iArr, float[] fArr, int i, int[] iArr2) {
        FloatColor floatColor = new FloatColor();
        floatColor.set(iArr[0]);
        FloatColor floatColor2 = new FloatColor();
        int i2 = 1;
        floatColor2.set(iArr[1]);
        float f = fArr[0];
        float f2 = fArr[1] - f;
        for (int i3 = 0; i3 < i; i3++) {
            float f3 = i3 / (i - 1.0f);
            if (f3 > fArr[i2]) {
                floatColor.set(floatColor2);
                f = fArr[i2];
                i2++;
                floatColor2.set(iArr[i2]);
                f2 = fArr[i2] - f;
            }
            mix(floatColor, floatColor2, (f3 - f) / f2, i3, iArr2);
        }
    }

    private void createBitmapShader(PointF pointF, PointF pointF2, int[] iArr, float[] fArr, float f) {
        float[] fArr2;
        int length = (int) PointF.length(pointF2.x - pointF.x, pointF2.y - pointF.y);
        if (length <= 0) {
            this.mShader = null;
            return;
        }
        int[] iArr2 = new int[length];
        if (fArr == null) {
            fArr2 = new float[iArr.length];
            if (iArr.length == 2) {
                fArr2[0] = 0.0f;
                fArr2[1] = 1.0f;
            } else if (iArr.length > 2) {
                for (int i = 0; i < iArr.length; i++) {
                    fArr2[i] = i / (iArr.length - 1);
                }
            }
        } else {
            fArr2 = fArr;
        }
        int i2 = fArr2[0] != 0.0f ? 1 : 0;
        int i3 = fArr2[fArr2.length - 1] != 1.0f ? 1 : 0;
        int length2 = fArr2.length + i2 + i3;
        if (length2 != fArr2.length) {
            int[] iArr3 = new int[length2];
            float[] fArr3 = new float[length2];
            if (i2 != 0) {
                iArr3[0] = iArr[0];
                fArr3[0] = 0.0f;
            }
            System.arraycopy(iArr, 0, iArr3, i2, iArr.length);
            System.arraycopy(fArr2, 0, fArr3, i2, fArr2.length);
            if (i3 != 0) {
                int i4 = length2 - 1;
                iArr3[i4] = iArr[iArr.length - 1];
                fArr3[i4] = 1.0f;
            }
            fillPixels(iArr3, fArr3, length, iArr2);
        } else {
            fillPixels(iArr, fArr2, length, iArr2);
        }
        this.mShader = new BitmapShader(Bitmap.createBitmap(iArr2, length, 1, Bitmap.Config.ARGB_8888), Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
        Matrix matrix = new Matrix();
        matrix.postRotate(f + 270.0f);
        matrix.postTranslate(pointF.x, pointF.y);
        this.mShader.setLocalMatrix(matrix);
    }
}
