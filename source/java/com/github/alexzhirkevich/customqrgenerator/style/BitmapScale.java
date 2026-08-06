package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BitmapScale.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0002\t\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "", "scale", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "CenterCrop", "FitXY", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface BitmapScale {
    Bitmap scale(Drawable drawable, int width, int height);

    /* compiled from: BitmapScale.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale$FitXY;", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "()V", "scale", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class FitXY implements BitmapScale {
        public static final FitXY INSTANCE = new FitXY();

        private FitXY() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.BitmapScale
        public Bitmap scale(Drawable drawable, int width, int height) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            return DrawableKt.toBitmap(drawable, width, height, Bitmap.Config.ARGB_8888);
        }
    }

    /* compiled from: BitmapScale.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale$CenterCrop;", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "()V", "scale", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CenterCrop implements BitmapScale {
        public static final CenterCrop INSTANCE = new CenterCrop();

        private CenterCrop() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.BitmapScale
        public Bitmap scale(Drawable drawable, int width, int height) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth != -1 && intrinsicHeight != -1) {
                double d = width;
                double d2 = height;
                double d3 = intrinsicWidth;
                double d4 = intrinsicHeight;
                if (!(d / d2 == d3 / d4)) {
                    if (intrinsicWidth != width || intrinsicHeight != height) {
                        double max = Math.max(d / d3, d2 / d4);
                        intrinsicHeight = ((int) (d4 * max)) + 1;
                        intrinsicWidth = ((int) (d3 * max)) + 1;
                    }
                    Bitmap bitmap = DrawableKt.toBitmap(drawable, intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                    Bitmap newBmp = Bitmap.createBitmap(bitmap, (intrinsicWidth - width) / 2, (intrinsicHeight - height) / 2, width, height);
                    if (newBmp != bitmap) {
                        bitmap.recycle();
                    }
                    Intrinsics.checkNotNullExpressionValue(newBmp, "newBmp");
                    return newBmp;
                }
            }
            return DrawableKt.toBitmap(drawable, width, height, Bitmap.Config.ARGB_8888);
        }
    }
}
