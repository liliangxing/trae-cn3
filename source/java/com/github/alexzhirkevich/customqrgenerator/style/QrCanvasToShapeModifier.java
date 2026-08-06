package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCanvasShape.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasToShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "size", "", "canvasShapeModifier", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;", "(ILcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;)V", "drawPaint", "Landroid/graphics/Paint;", "erasePaint", "pixels", "", "getPixels", "()[I", "pixels$delegate", "Lkotlin/Lazy;", "invoke", "", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class QrCanvasToShapeModifier implements QrShapeModifier {
    private final QrCanvasShape canvasShapeModifier;
    private final Paint drawPaint;
    private final Paint erasePaint;

    /* renamed from: pixels$delegate, reason: from kotlin metadata */
    private final Lazy pixels;
    private final int size;

    public QrCanvasToShapeModifier(int i, QrCanvasShape qrCanvasShape) {
        Intrinsics.checkNotNullParameter(qrCanvasShape, "canvasShapeModifier");
        this.size = i;
        this.canvasShapeModifier = qrCanvasShape;
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setAntiAlias(true);
        this.drawPaint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        this.erasePaint = paint2;
        this.pixels = LazyKt.lazy(new Function0<int[]>() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrCanvasToShapeModifier$pixels$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final int[] invoke() {
                int i2;
                int i3;
                int i4;
                int i5;
                Paint paint3;
                QrCanvasShape qrCanvasShape2;
                Paint paint4;
                Paint paint5;
                int i6;
                int i7;
                int i8;
                i2 = QrCanvasToShapeModifier.this.size;
                i3 = QrCanvasToShapeModifier.this.size;
                int[] iArr = new int[i2 * i3];
                i4 = QrCanvasToShapeModifier.this.size;
                i5 = QrCanvasToShapeModifier.this.size;
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                paint3 = QrCanvasToShapeModifier.this.erasePaint;
                createBitmap.eraseColor(paint3.getColor());
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(size, size,…asePaint.color)\n        }");
                QrCanvasToShapeModifier qrCanvasToShapeModifier = QrCanvasToShapeModifier.this;
                Canvas canvas = new Canvas(createBitmap);
                qrCanvasShape2 = qrCanvasToShapeModifier.canvasShapeModifier;
                paint4 = qrCanvasToShapeModifier.drawPaint;
                paint5 = qrCanvasToShapeModifier.erasePaint;
                qrCanvasShape2.draw(canvas, paint4, paint5);
                i6 = QrCanvasToShapeModifier.this.size;
                i7 = QrCanvasToShapeModifier.this.size;
                i8 = QrCanvasToShapeModifier.this.size;
                createBitmap.getPixels(iArr, 0, i6, 0, 0, i7, i8);
                createBitmap.recycle();
                return iArr;
            }
        });
    }

    private final int[] getPixels() {
        return (int[]) this.pixels.getValue();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        float f = this.size / elementSize;
        return getPixels()[((int) (((float) i) * f)) + (this.size * ((int) (((float) j) * f)))] == this.drawPaint.getColor();
    }
}
