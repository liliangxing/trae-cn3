package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import androidx.palette.graphics.Target;
import com.facebook.common.logging.FLog;

/* loaded from: classes6.dex */
public class ColorCalculator {
    private static final String TAG = "ColorCalculator";

    /* loaded from: classes6.dex */
    public enum PhotoBgColorStyle {
        DEFAULT,
        MUTED,
        VIBRANT,
        DARK_MUTED,
        DARK_VIBRANT,
        LIGHT_MUTED,
        LIGHT_VIBRANT
    }

    public static CalculateColorInfo getColorByAlgorithm(Bitmap bitmap, int i, int i2, PhotoBgColorStyle photoBgColorStyle) {
        if (bitmap != null && !bitmap.isRecycled() && i > 0) {
            try {
                int min = Math.min(i, bitmap.getHeight());
                Palette.Builder clearFilters = Palette.from(bitmap).clearTargets().clearFilters();
                clearFilters.setRegion(0, 0, bitmap.getWidth(), min);
                if (i2 > 0) {
                    clearFilters.resizeBitmapArea(i2 * i2);
                }
                int intValue = getColor(clearFilters, photoBgColorStyle).intValue();
                if (min == bitmap.getHeight()) {
                    return new CalculateColorInfo(intValue, intValue);
                }
                int height = bitmap.getHeight();
                clearFilters.setRegion(0, height - min, bitmap.getWidth(), height);
                return new CalculateColorInfo(intValue, getColor(clearFilters, photoBgColorStyle).intValue());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.imagepipeline.image.ColorCalculator$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle;

        static {
            int[] iArr = new int[PhotoBgColorStyle.values().length];
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle = iArr;
            try {
                iArr[PhotoBgColorStyle.MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.VIBRANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.DARK_MUTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.DARK_VIBRANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.LIGHT_MUTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.LIGHT_VIBRANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Integer getColor(Palette.Builder builder, PhotoBgColorStyle photoBgColorStyle) {
        Palette.Swatch swatch;
        Integer valueOf;
        if (photoBgColorStyle != null) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[photoBgColorStyle.ordinal()]) {
                case 1:
                    swatch = builder.addTarget(Target.MUTED).generate().getMutedSwatch();
                    break;
                case 2:
                    swatch = builder.addTarget(Target.VIBRANT).generate().getVibrantSwatch();
                    break;
                case 3:
                    swatch = builder.addTarget(Target.DARK_MUTED).generate().getDarkMutedSwatch();
                    break;
                case 4:
                    swatch = builder.addTarget(Target.DARK_VIBRANT).generate().getDarkVibrantSwatch();
                    break;
                case 5:
                    swatch = builder.addTarget(Target.LIGHT_MUTED).generate().getLightMutedSwatch();
                    break;
                case 6:
                    swatch = builder.addTarget(Target.LIGHT_VIBRANT).generate().getLightVibrantSwatch();
                    break;
            }
            valueOf = swatch != null ? Integer.valueOf(swatch.getRgb()) : null;
            if (valueOf == null) {
                return valueOf;
            }
            FLog.d(TAG, "使用dominantSwatch算色/非常规算法算色失败");
            return Integer.valueOf(builder.generate().getDominantSwatch().getRgb());
        }
        swatch = null;
        if (swatch != null) {
        }
        if (valueOf == null) {
        }
    }
}
