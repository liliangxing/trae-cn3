package com.lynx.tasm.p001ui.image.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.image.NinePatchHelper;
import com.lynx.tasm.image.ScalingUtils;
import com.lynx.tasm.p001ui.image.ImageResizeMode;
import com.lynx.tasm.utils.PixelUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseRoundedCornerPostprocessor extends BasePostprocessor {
    private Bitmap.Config mBitmapConfig;
    private float[] mBorderRadii;
    private SimpleCacheKey mCacheKey;
    private String[] mCapInsets;
    private float mCapInsetsScale;
    private int mHeight;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ScalingUtils.ScaleType mScaleType;
    private int mWidth;

    public BaseRoundedCornerPostprocessor(String str, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType, String str2, String str3, Bitmap.Config config) {
        this(str, i, i2, i3, i4, i5, i6, fArr, scaleType, str2, str3, config, false);
    }

    public BaseRoundedCornerPostprocessor(String str, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType, String str2, String str3, Bitmap.Config config, boolean z) {
        this.mBitmapConfig = null;
        this.mScaleType = scaleType;
        this.mWidth = i;
        this.mHeight = i2;
        this.mPaddingLeft = i3;
        this.mPaddingTop = i4;
        this.mPaddingRight = i5;
        this.mPaddingBottom = i6;
        this.mBorderRadii = fArr;
        initCapInsets(str2);
        initCapInsetsScale(str3);
        this.mBitmapConfig = config;
        updateCacheKey(str, fArr, scaleType, z);
        adjustPaddings();
    }

    private static float getCapInsetsScale(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            return 1.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Throwable th) {
            LLog.w("BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());
            return 1.0f;
        }
    }

    private void initCapInsetsScale(String str) {
        this.mCapInsetsScale = getCapInsetsScale(str);
    }

    private static String[] getCapInsetsArr(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            return null;
        }
        String[] split = str.split(" ");
        if (split.length > 4) {
            return null;
        }
        boolean z = true;
        for (int i = 0; i < Math.min(split.length, 4); i++) {
            if (split[i].endsWith("px") || split[i].endsWith("%")) {
                if (split[i].endsWith("px")) {
                    if (split[i].length() > 2) {
                        String str2 = split[i];
                        z = str2.substring(0, str2.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
                    }
                } else {
                    if (split[i].endsWith("%")) {
                        if (split[i].length() > 1) {
                            String str3 = split[i];
                            z = str3.substring(0, str3.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
                        }
                    }
                }
            }
            z = false;
        }
        if (z) {
            return split;
        }
        return null;
    }

    private static float[] getFloatCapInsetsArr(String[] strArr, int i, int i2) {
        if (strArr == null || strArr.length > 4) {
            return null;
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].endsWith("px")) {
                String str = strArr[i3];
                fArr[i3] = Float.parseFloat(str.substring(0, str.length() - 2));
            } else if (strArr[i3].endsWith("%")) {
                if (i3 == 0 || i3 == 2) {
                    String str2 = strArr[i3];
                    fArr[i3] = Float.parseFloat(str2.substring(0, str2.length() - 2)) * i2;
                } else {
                    String str3 = strArr[i3];
                    fArr[i3] = Float.parseFloat(str3.substring(0, str3.length() - 2)) * i;
                }
            }
        }
        return fArr;
    }

    private void initCapInsets(String str) {
        this.mCapInsets = getCapInsetsArr(str);
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference closeableReference;
        Bitmap.Config config = this.mBitmapConfig;
        if (config == null) {
            config = bitmap.getConfig();
        }
        try {
            int i = this.mWidth;
            int i2 = this.mHeight;
            if (config == null) {
                config = FALLBACK_BITMAP_CONFIGURATION;
            }
            closeableReference = platformBitmapFactory.createBitmapInternal(i, i2, config);
            try {
                if (this.mCapInsets == null) {
                    LLog.i("Lynx Image Processor", "process image from Fresco without cap-insets");
                    transform((Bitmap) closeableReference.get(), bitmap);
                } else {
                    LLog.i("Lynx Image Processor", "process image from Fresco with cap-insets");
                    transformWithCapInsets((Bitmap) closeableReference.get(), bitmap);
                }
                return CloseableReference.cloneOrNull(closeableReference);
            } catch (Throwable th) {
                th = th;
                try {
                    LLog.e("BaseRoundedCornerPostprocessor", "process image error " + th.getMessage());
                    if (closeableReference != null) {
                        CloseableReference.closeSafely(closeableReference);
                    }
                    return null;
                } finally {
                    if (closeableReference != null) {
                        CloseableReference.closeSafely(closeableReference);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            closeableReference = null;
        }
    }

    public void updateCacheKey(String str, float[] fArr, ScalingUtils.ScaleType scaleType, boolean z) {
        StringBuilder sb = new StringBuilder("");
        if (!z) {
            sb.append(str);
        }
        sb.append(scaleType);
        if (fArr != null) {
            for (float f : fArr) {
                sb.append(f);
            }
        }
        sb.append(this.mPaddingBottom);
        sb.append(this.mPaddingTop);
        sb.append(this.mPaddingLeft);
        sb.append(this.mPaddingRight);
        sb.append(this.mScaleType);
        String[] strArr = this.mCapInsets;
        if (strArr != null) {
            sb.append(strArr);
            sb.append(this.mCapInsetsScale);
        }
        sb.append(this.mBitmapConfig);
        this.mCacheKey = new SimpleCacheKey(sb.toString());
    }

    private void adjustPaddings() {
        int i = this.mPaddingLeft;
        int i2 = this.mPaddingRight;
        int i3 = i + i2;
        int i4 = this.mWidth;
        if (i3 > i4 && i4 > 0) {
            float f = i4 / (i + i2);
            this.mPaddingLeft = (int) (i * f);
            this.mPaddingRight = (int) (i2 * f);
        }
        int i5 = this.mPaddingTop;
        int i6 = this.mPaddingBottom;
        int i7 = i5 + i6;
        int i8 = this.mHeight;
        if (i7 <= i8 || i8 <= 0) {
            return;
        }
        float f2 = i8 / (i5 + i6);
        this.mPaddingTop = (int) (i5 * f2);
        this.mPaddingBottom = (int) (i6 * f2);
    }

    private Canvas getInitCanvas(Bitmap bitmap, int i, int i2) {
        Canvas canvas = new Canvas(bitmap);
        canvas.clipRect(this.mPaddingLeft, this.mPaddingTop, i - this.mPaddingRight, i2 - this.mPaddingBottom);
        canvas.drawARGB(0, 0, 0, 0);
        return canvas;
    }

    public static Matrix getMatrix(int i, int i2, int i3, int i4, ScalingUtils.ScaleType scaleType) {
        return NinePatchHelper.getMatrix(i, i2, i3, i4, getScaleType(scaleType));
    }

    public static boolean customDraw(int i, int i2, int i3, int i4, ScalingUtils.ScaleType scaleType, String str, String str2, Canvas canvas, Bitmap bitmap) {
        return NinePatchHelper.drawNinePatch(i, i2, i3, i4, getScaleType(scaleType), str, str2, canvas, bitmap);
    }

    private static ScalingUtils.ScaleType getScaleType(ScalingUtils.ScaleType scaleType) {
        ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.FIT_XY;
        if (scaleType == ScalingUtils.ScaleType.FIT_XY) {
            return ScalingUtils.ScaleType.FIT_XY;
        }
        if (scaleType == ScalingUtils.ScaleType.FIT_CENTER) {
            return ScalingUtils.ScaleType.FIT_CENTER;
        }
        if (scaleType == ScalingUtils.ScaleType.CENTER_CROP) {
            return ScalingUtils.ScaleType.CENTER_CROP;
        }
        return scaleType == ScalingUtils.ScaleType.CENTER ? ScalingUtils.ScaleType.CENTER : scaleType2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void transform(Bitmap bitmap, Bitmap bitmap2) {
        int i;
        boolean z;
        boolean z2;
        float f;
        float f2;
        float f3;
        float f4;
        RectF rectF;
        Path path;
        float[] fArr;
        int i2 = this.mWidth;
        if (i2 == 0 || (i = this.mHeight) == 0) {
            return;
        }
        Canvas initCanvas = getInitCanvas(bitmap, i2, i);
        Matrix matrix = new Matrix();
        Paint paint = new Paint(1);
        int i3 = this.mPaddingLeft;
        float f5 = i3;
        int i4 = this.mPaddingTop;
        float f6 = i4;
        float f7 = (i2 - i3) - this.mPaddingRight;
        float f8 = (i - i4) - this.mPaddingBottom;
        float width = bitmap2.getWidth();
        float height = bitmap2.getHeight();
        Matrix transform = ImageResizeMode.getRealScaleType(this.mScaleType).getTransform(matrix, new Rect(this.mPaddingLeft, this.mPaddingTop, i2 - this.mPaddingRight, i - this.mPaddingBottom), (int) width, (int) height, 0.0f, 0.0f);
        if (this.mScaleType == ScalingUtils.ScaleType.FIT_CENTER) {
            float f9 = f7 / width;
            float f10 = f8 / height;
            if (f9 > f10) {
                float f11 = width * f10;
                f5 += (f7 - f11) / 2.0f;
                f7 = f11;
            } else {
                float f12 = height * f9;
                f6 += (f8 - f12) / 2.0f;
                f8 = f12;
            }
            f3 = f7;
            f = f5;
            f4 = f8;
            f2 = f6;
        } else if (this.mScaleType == ScalingUtils.ScaleType.CENTER) {
            f3 = width;
            f = Math.round((f7 - width) * 0.5f);
            f2 = Math.round((f8 - height) * 0.5f);
            f4 = height;
        } else {
            z = false;
            z2 = true;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            paint.setFilterBitmap(z2);
            rectF = new RectF(Math.min(this.mPaddingLeft, i2), Math.min(this.mPaddingTop, i), i2 - this.mPaddingRight, i - this.mPaddingBottom);
            if (rectF.right < rectF.left) {
                rectF.right = rectF.left;
            }
            if (rectF.bottom < rectF.top) {
                rectF.bottom = rectF.top;
            }
            path = new Path();
            fArr = this.mBorderRadii;
            if (fArr == null && fArr.length == 8) {
                path.addRoundRect(rectF, new float[]{Math.max(fArr[0] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[1] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[2] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[3] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[4] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[5] - this.mPaddingBottom, 0.0f), Math.max(this.mBorderRadii[6] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[7] - this.mPaddingBottom, 0.0f)}, Path.Direction.CW);
            } else {
                path.addRect(rectF, Path.Direction.CW);
            }
            initCanvas.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            initCanvas.drawBitmap(bitmap2, transform, paint);
            if (z) {
                return;
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            float f13 = i2;
            initCanvas.drawRect(0.0f, 0.0f, f13, ceil(f2), paint);
            float f14 = f4 + f2;
            initCanvas.drawRect(0.0f, (int) f14, f13, i, paint);
            float f15 = (int) f2;
            initCanvas.drawRect(0.0f, f15, ceil(f), ceil(f14), paint);
            initCanvas.drawRect((int) (f + f3), f15, f13, ceil(f14), paint);
            return;
        }
        z = true;
        z2 = true;
        paint.setFilterBitmap(z2);
        rectF = new RectF(Math.min(this.mPaddingLeft, i2), Math.min(this.mPaddingTop, i), i2 - this.mPaddingRight, i - this.mPaddingBottom);
        if (rectF.right < rectF.left) {
        }
        if (rectF.bottom < rectF.top) {
        }
        path = new Path();
        fArr = this.mBorderRadii;
        if (fArr == null) {
        }
        path.addRect(rectF, Path.Direction.CW);
        initCanvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        initCanvas.drawBitmap(bitmap2, transform, paint);
        if (z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0139, code lost:
    
        r10 = r10 * r31;
        r11 = r11 + ((r3 - r10) / 2.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0149, code lost:
    
        if (r31 > r32) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x012f, code lost:
    
        if (r31 > r32) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0131, code lost:
    
        r8 = r8 * r32;
        r9 = r9 + ((r2 - r8) / 2.0f);
        r2 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void transformWithCapInsets(Bitmap bitmap, Bitmap bitmap2) {
        int i;
        int i2 = this.mWidth;
        if (i2 == 0 || (i = this.mHeight) == 0) {
            return;
        }
        Canvas initCanvas = getInitCanvas(bitmap, i2, i);
        initCanvas.clipRect(this.mPaddingLeft, this.mPaddingTop, i2 - this.mPaddingRight, i - this.mPaddingBottom);
        initCanvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint(1);
        int i3 = this.mPaddingLeft;
        float f = i3;
        int i4 = this.mPaddingTop;
        float f2 = i4;
        float f3 = (i2 - i3) - this.mPaddingRight;
        float f4 = (i - i4) - this.mPaddingBottom;
        float width = bitmap2.getWidth();
        float height = bitmap2.getHeight();
        int i5 = (int) width;
        int i6 = (int) height;
        float[] floatCapInsetsArr = getFloatCapInsetsArr(this.mCapInsets, i5, i6);
        float f5 = floatCapInsetsArr[3];
        float f6 = this.mCapInsetsScale;
        Rect rect = new Rect(0, 0, (int) (f5 * f6), (int) (f6 * floatCapInsetsArr[0]));
        Rect rect2 = new Rect(rect.right, rect.top, (int) (width - (floatCapInsetsArr[1] * this.mCapInsetsScale)), rect.bottom);
        Rect rect3 = new Rect(rect2.right, rect.top, i5, rect.bottom);
        Rect rect4 = new Rect(rect.left, rect.bottom, rect.right, (int) (height - (floatCapInsetsArr[2] * this.mCapInsetsScale)));
        Rect rect5 = new Rect(rect4.right, rect4.top, rect2.right, rect4.bottom);
        Rect rect6 = new Rect(rect5.right, rect4.top, rect3.right, rect4.bottom);
        Rect rect7 = new Rect(rect4.left, rect4.bottom, rect4.right, i6);
        Rect rect8 = new Rect(rect7.right, rect7.top, rect5.right, rect7.bottom);
        Rect rect9 = new Rect(rect8.right, rect7.top, rect6.right, rect7.bottom);
        Rect rect10 = new Rect();
        Rect rect11 = new Rect();
        Rect rect12 = new Rect();
        Rect rect13 = new Rect();
        Rect rect14 = new Rect();
        Rect rect15 = new Rect();
        Rect rect16 = new Rect();
        Rect rect17 = new Rect();
        Rect rect18 = new Rect();
        float f7 = f3 / width;
        float f8 = f4 / height;
        if (this.mScaleType != ScalingUtils.ScaleType.FIT_CENTER) {
            if (this.mScaleType != ScalingUtils.ScaleType.CENTER_CROP) {
                if (this.mScaleType == ScalingUtils.ScaleType.CENTER) {
                    float dipToPx = PixelUtils.dipToPx(1.0f);
                    float f9 = width * dipToPx;
                    float f10 = height * dipToPx;
                    f = Math.round((f3 - f9) * 0.5f);
                    f2 = Math.round((f4 - f10) * 0.5f);
                    f3 = f9;
                    f4 = f10;
                }
            }
        }
        int i7 = (int) f;
        rect10.left = i7;
        int i8 = (int) f2;
        rect10.top = i8;
        rect10.right = (int) (PixelUtils.dipToPx(floatCapInsetsArr[3]) + f);
        rect10.bottom = (int) (PixelUtils.dipToPx(floatCapInsetsArr[0]) + f2);
        rect11.left = rect10.right;
        rect11.top = rect10.top;
        rect11.right = (int) ((f + f3) - PixelUtils.dipToPx(floatCapInsetsArr[1]));
        rect11.bottom = rect10.bottom;
        rect12.left = rect11.right;
        rect12.top = rect10.top;
        rect12.right = i7 + ((int) f3);
        rect12.bottom = rect10.bottom;
        rect13.left = rect10.left;
        rect13.top = rect10.bottom;
        rect13.right = rect10.right;
        rect13.bottom = (int) ((f2 + f4) - ((int) PixelUtils.dipToPx(floatCapInsetsArr[2])));
        rect14.left = rect13.right;
        rect14.top = rect13.top;
        rect14.right = rect11.right;
        rect14.bottom = rect13.bottom;
        rect15.left = rect14.right;
        rect15.top = rect12.bottom;
        rect15.right = rect12.right;
        rect15.bottom = rect13.bottom;
        rect16.left = rect10.left;
        rect16.top = rect13.bottom;
        rect16.right = rect13.right;
        rect16.bottom = i8 + ((int) f4);
        rect17.left = rect16.right;
        rect17.top = rect14.bottom;
        rect17.right = rect14.right;
        rect17.bottom = rect16.bottom;
        rect18.left = rect17.right;
        rect18.top = rect15.bottom;
        rect18.right = rect15.right;
        rect18.bottom = rect17.bottom;
        initCanvas.drawBitmap(bitmap2, rect, rect10, paint);
        initCanvas.drawBitmap(bitmap2, rect2, rect11, paint);
        initCanvas.drawBitmap(bitmap2, rect3, rect12, paint);
        initCanvas.drawBitmap(bitmap2, rect4, rect13, paint);
        initCanvas.drawBitmap(bitmap2, rect5, rect14, paint);
        initCanvas.drawBitmap(bitmap2, rect6, rect15, paint);
        initCanvas.drawBitmap(bitmap2, rect7, rect16, paint);
        initCanvas.drawBitmap(bitmap2, rect8, rect17, paint);
        initCanvas.drawBitmap(bitmap2, rect9, rect18, paint);
    }

    private float ceil(float f) {
        return (float) Math.ceil(f);
    }

    public CacheKey getPostprocessorCacheKey() {
        return this.mCacheKey;
    }
}
