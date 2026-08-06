package com.larus.business.markdown.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: CustomPostprocessor.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/fresco/CustomPostprocessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "size", "Landroid/graphics/Rect;", "cornerRadius", "", "(Landroid/graphics/Rect;I)V", "createRoundedBmp", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "oriBmp", "bitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "radius", "createScaledBmp", "getName", "", "process", "sourceBitmap", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomPostprocessor extends BasePostprocessor {
    private final int cornerRadius;
    private final Rect size;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "md_processor";
    }

    public CustomPostprocessor(Rect rect, int i) {
        this.size = rect;
        this.cornerRadius = i;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
        CloseableReference<Bitmap> createScaledBmp;
        int i;
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        Rect rect = this.size;
        if (rect == null) {
            createScaledBmp = super.process(sourceBitmap, bitmapFactory);
        } else {
            createScaledBmp = createScaledBmp(bitmapFactory, sourceBitmap, rect);
        }
        CloseableReference<Bitmap> closeableReference = createScaledBmp;
        try {
            CloseableReference<Bitmap> closeableReference2 = closeableReference;
            Bitmap bitmap = closeableReference2.get();
            try {
                if (this.size != null && bitmap.getWidth() != this.size.width()) {
                    i = (this.cornerRadius * bitmap.getWidth()) / this.size.width();
                    Bitmap bitmap2 = closeableReference2.get();
                    Intrinsics.checkNotNullExpressionValue(bitmap2, "scaledRef.get()");
                    closeableReference = createRoundedBmp(bitmap2, bitmapFactory, i);
                    CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(closeableReference);
                    CloseableKt.closeFinally(closeableReference, (Throwable) null);
                    CloseableKt.closeFinally(closeableReference, (Throwable) null);
                    return cloneOrNull;
                }
                CloseableReference<Bitmap> cloneOrNull2 = CloseableReference.cloneOrNull(closeableReference);
                CloseableKt.closeFinally(closeableReference, (Throwable) null);
                CloseableKt.closeFinally(closeableReference, (Throwable) null);
                return cloneOrNull2;
            } finally {
            }
            i = this.cornerRadius;
            Bitmap bitmap22 = closeableReference2.get();
            Intrinsics.checkNotNullExpressionValue(bitmap22, "scaledRef.get()");
            closeableReference = createRoundedBmp(bitmap22, bitmapFactory, i);
        } finally {
        }
    }

    private final CloseableReference<Bitmap> createRoundedBmp(Bitmap oriBmp, PlatformBitmapFactory bitmapFactory, int radius) {
        CloseableReference<Bitmap> createBitmap = bitmapFactory.createBitmap(oriBmp.getWidth(), oriBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap.get());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, oriBmp.getWidth(), oriBmp.getHeight());
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        float f = radius;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(oriBmp, rect, rect, paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "roundedRef");
        return createBitmap;
    }

    private final CloseableReference<Bitmap> createScaledBmp(PlatformBitmapFactory bitmapFactory, Bitmap oriBmp, Rect size) {
        int i;
        int i2;
        int i3;
        int i4;
        if (oriBmp.getWidth() == size.width() && oriBmp.getHeight() == size.height()) {
            CloseableReference<Bitmap> createBitmap = bitmapFactory.createBitmap(oriBmp);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmapFactory.createBitmap(oriBmp)");
            return createBitmap;
        }
        int width = oriBmp.getWidth();
        int height = oriBmp.getHeight();
        int width2 = size.width();
        int height2 = size.height();
        float f = width2 / width;
        float f2 = height2 / height;
        if (f == f2) {
            CloseableReference<Bitmap> createBitmap2 = bitmapFactory.createBitmap(oriBmp);
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "bitmapFactory.createBitmap(oriBmp)");
            return createBitmap2;
        }
        Matrix matrix = new Matrix();
        if (f > f2) {
            int roundToInt = MathKt.roundToInt((height2 / width2) * width);
            int roundToInt2 = MathKt.roundToInt((height - roundToInt) / 2.0f);
            matrix.postScale(f, f);
            i2 = roundToInt;
            i3 = roundToInt2;
            i = 0;
            i4 = width;
        } else {
            int roundToInt3 = MathKt.roundToInt((width2 / height2) * height);
            int roundToInt4 = MathKt.roundToInt((width - roundToInt3) / 2.0f);
            matrix.postScale(f2, f2);
            i = roundToInt4;
            i2 = height;
            i3 = 0;
            i4 = roundToInt3;
        }
        CloseableReference<Bitmap> createBitmap3 = bitmapFactory.createBitmap(oriBmp, i, i3, i4, i2, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap3, "bitmapFactory.createBitm…th, height, matrix, true)");
        return createBitmap3;
    }
}
