package com.lynx.tasm.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.image.ScalingUtils;
import com.lynx.tasm.utils.PixelUtils;
import io.noties.markwon.image.CustomImageSizeResolverDef;

/* loaded from: classes7.dex */
public class NinePatchHelper {
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
            if (split[i].endsWith("px") || split[i].endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
                if (split[i].endsWith("px")) {
                    if (split[i].length() > 2) {
                        String str2 = split[i];
                        z = str2.substring(0, str2.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
                    }
                } else {
                    if (split[i].endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
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
            } else if (strArr[i3].endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
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

    public static Matrix getMatrix(int i, int i2, int i3, int i4, ScalingUtils.ScaleType scaleType) {
        TraceEvent.beginSection(TraceEventDef.NINE_PATCH_HELPER_GET_MATRIX);
        Matrix matrix = new Matrix();
        float f = i;
        float f2 = i3;
        float f3 = (f * 1.0f) / f2;
        float f4 = i2;
        float f5 = i4;
        float f6 = (f4 * 1.0f) / f5;
        if (scaleType == ScalingUtils.ScaleType.FIT_XY) {
            matrix.preScale(f3, f6);
        } else if (scaleType == ScalingUtils.ScaleType.FIT_CENTER) {
            if (f3 > f6) {
                matrix.setScale(f6, f6);
                matrix.postTranslate((f - (f2 * f6)) / 2.0f, 0.0f);
            } else {
                matrix.setScale(f3, f3);
                matrix.postTranslate(0.0f, (f4 - (f5 * f3)) / 2.0f);
            }
        } else if (scaleType != ScalingUtils.ScaleType.CENTER_CROP) {
            float dipToPx = PixelUtils.dipToPx(1.0f);
            float round = Math.round((f - (f2 * dipToPx)) * 0.5f);
            float round2 = Math.round((f4 - (f5 * dipToPx)) * 0.5f);
            matrix.setScale(dipToPx, dipToPx);
            matrix.postTranslate(round, round2);
        } else if (f3 > f6) {
            matrix.setScale(f3, f3);
            matrix.postTranslate(0.0f, (f4 - (f5 * f3)) / 2.0f);
        } else {
            matrix.setScale(f6, f6);
            matrix.postTranslate((f - (f2 * f6)) / 2.0f, 0.0f);
        }
        TraceEvent.endSection(TraceEventDef.NINE_PATCH_HELPER_GET_MATRIX);
        return matrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x0058, TryCatch #0 {all -> 0x0058, blocks: (B:3:0x0006, B:5:0x0017, B:7:0x001b, B:9:0x0022, B:11:0x0028, B:13:0x002f, B:18:0x003c, B:23:0x0049), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #0 {all -> 0x0058, blocks: (B:3:0x0006, B:5:0x0017, B:7:0x001b, B:9:0x0022, B:11:0x0028, B:13:0x002f, B:18:0x003c, B:23:0x0049), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean drawNinePatch(int i, int i2, int i3, int i4, ScalingUtils.ScaleType scaleType, String str, String str2, Canvas canvas, Bitmap bitmap) {
        float[] floatCapInsetsArr;
        float capInsetsScale;
        boolean z;
        TraceEvent.beginSection(TraceEventDef.NINE_PATCH_HELPER_DRAW_NINE_PATH);
        boolean z2 = false;
        try {
            floatCapInsetsArr = getFloatCapInsetsArr(getCapInsetsArr(str), i3, i4);
            capInsetsScale = getCapInsetsScale(str2);
        } catch (Throwable th) {
            LLog.w("BaseRoundedCornerPostprocessor", "process customDraw warn " + th.getMessage());
        }
        if (floatCapInsetsArr != null && floatCapInsetsArr.length == 4 && (floatCapInsetsArr[0] != 0.0f || floatCapInsetsArr[1] != 0.0f || floatCapInsetsArr[2] != 0.0f || floatCapInsetsArr[3] != 0.0f)) {
            z = true;
            if (z) {
                canvas.drawBitmap(bitmap, getMatrix(i, i2, i3, i4, scaleType), null);
            } else {
                drawWithCapInsets(i, i2, i3, i4, scaleType, floatCapInsetsArr, capInsetsScale, canvas, bitmap);
            }
            z2 = true;
            TraceEvent.endSection(TraceEventDef.NINE_PATCH_HELPER_DRAW_NINE_PATH);
            return z2;
        }
        z = false;
        if (z) {
        }
        z2 = true;
        TraceEvent.endSection(TraceEventDef.NINE_PATCH_HELPER_DRAW_NINE_PATH);
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x010e, code lost:
    
        if (r2 > r3) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x00f0, code lost:
    
        if (r2 > r3) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00f2, code lost:
    
        r14 = r14 * r3;
        r0 = ((r6 - r14) / 2.0f) + 0.0f;
        r6 = r14;
        r1 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00fd, code lost:
    
        r7 = r7 * r2;
        r1 = ((r8 - r7) / 2.0f) + 0.0f;
        r0 = 0.0f;
        r8 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void drawWithCapInsets(int i, int i2, int i3, int i4, ScalingUtils.ScaleType scaleType, float[] fArr, float f, Canvas canvas, Bitmap bitmap) {
        float f2;
        float f3;
        TraceEvent.beginSection(TraceEventDef.NINE_PATCH_HELPER_DRAW_WITH_CAP_INSETS);
        Rect rect = new Rect(0, 0, (int) (fArr[3] * f), (int) (fArr[0] * f));
        float f4 = i3;
        Rect rect2 = new Rect(rect.right, rect.top, (int) (f4 - (fArr[1] * f)), rect.bottom);
        Rect rect3 = new Rect(rect2.right, rect.top, i3, rect.bottom);
        float f5 = i4;
        Rect rect4 = new Rect(rect.left, rect.bottom, rect.right, (int) (f5 - (fArr[2] * f)));
        Rect rect5 = new Rect(rect4.right, rect4.top, rect2.right, rect4.bottom);
        Rect rect6 = new Rect(rect5.right, rect4.top, rect3.right, rect4.bottom);
        Rect rect7 = new Rect(rect4.left, rect4.bottom, rect4.right, i4);
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
        float f6 = i2;
        float f7 = i;
        float f8 = i / i3;
        float f9 = i2 / i4;
        if (scaleType != ScalingUtils.ScaleType.FIT_CENTER) {
            if (scaleType != ScalingUtils.ScaleType.CENTER_CROP) {
                if (scaleType == ScalingUtils.ScaleType.CENTER) {
                    float dipToPx = PixelUtils.dipToPx(1.0f);
                    int i5 = (int) (f4 * dipToPx);
                    f2 = Math.round((i - i5) * 0.5f);
                    f3 = Math.round((i2 - r2) * 0.5f);
                    f7 = i5;
                    f6 = (int) (f5 * dipToPx);
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                }
            }
        }
        int i6 = (int) f2;
        rect10.left = i6;
        int i7 = (int) f3;
        rect10.top = i7;
        rect10.right = (int) (PixelUtils.dipToPx(fArr[3]) + f2);
        rect10.bottom = (int) (PixelUtils.dipToPx(fArr[0]) + f3);
        rect11.left = rect10.right;
        rect11.top = rect10.top;
        rect11.right = (int) ((f2 + f7) - PixelUtils.dipToPx(fArr[1]));
        rect11.bottom = rect10.bottom;
        rect12.left = rect11.right;
        rect12.top = rect10.top;
        rect12.right = i6 + ((int) f7);
        rect12.bottom = rect10.bottom;
        rect13.left = rect10.left;
        rect13.top = rect10.bottom;
        rect13.right = rect10.right;
        rect13.bottom = (int) ((f3 + f6) - PixelUtils.dipToPx(fArr[2]));
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
        rect16.bottom = i7 + ((int) f6);
        rect17.left = rect16.right;
        rect17.top = rect14.bottom;
        rect17.right = rect14.right;
        rect17.bottom = rect16.bottom;
        rect18.left = rect17.right;
        rect18.top = rect15.bottom;
        rect18.right = rect15.right;
        rect18.bottom = rect17.bottom;
        Paint paint = new Paint(1);
        canvas.drawBitmap(bitmap, rect, rect10, paint);
        canvas.drawBitmap(bitmap, rect2, rect11, paint);
        canvas.drawBitmap(bitmap, rect3, rect12, paint);
        canvas.drawBitmap(bitmap, rect4, rect13, paint);
        canvas.drawBitmap(bitmap, rect5, rect14, paint);
        canvas.drawBitmap(bitmap, rect6, rect15, paint);
        canvas.drawBitmap(bitmap, rect7, rect16, paint);
        canvas.drawBitmap(bitmap, rect8, rect17, paint);
        canvas.drawBitmap(bitmap, rect9, rect18, paint);
        TraceEvent.endSection(TraceEventDef.NINE_PATCH_HELPER_DRAW_WITH_CAP_INSETS);
    }
}
