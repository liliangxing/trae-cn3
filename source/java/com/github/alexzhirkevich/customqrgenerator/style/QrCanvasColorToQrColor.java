package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCanvasColor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J)\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasColorToQrColor;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "qrCanvasColor", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasColor;", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasColor;II)V", "pixels", "", "getPixels", "()[I", "pixels$delegate", "Lkotlin/Lazy;", "invoke", "i", "j", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class QrCanvasColorToQrColor implements QrColor {
    private final int height;

    /* renamed from: pixels$delegate, reason: from kotlin metadata */
    private final Lazy pixels;
    private final int width;

    public QrCanvasColorToQrColor(final QrCanvasColor qrCanvasColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(qrCanvasColor, "qrCanvasColor");
        this.width = i;
        this.height = i2;
        this.pixels = LazyKt.lazy(new Function0<int[]>() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrCanvasColorToQrColor$pixels$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final int[] invoke() {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                i3 = QrCanvasColorToQrColor.this.width;
                i4 = QrCanvasColorToQrColor.this.height;
                Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, SimplayerImageStrategy.RESULT_BITMAP);
                qrCanvasColor.draw(new Canvas(createBitmap));
                i5 = QrCanvasColorToQrColor.this.width;
                i6 = QrCanvasColorToQrColor.this.height;
                int[] iArr = new int[i5 * i6];
                i7 = QrCanvasColorToQrColor.this.width;
                i8 = QrCanvasColorToQrColor.this.width;
                i9 = QrCanvasColorToQrColor.this.height;
                createBitmap.getPixels(iArr, 0, i7, 0, 0, i8, i9);
                createBitmap.recycle();
                return iArr;
            }
        });
    }

    private final int[] getPixels() {
        return (int[]) this.pixels.getValue();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
    public int invoke(int i, int j, int width, int height) {
        return getPixels()[((int) (i * (this.width / width))) + (this.width * ((int) (j * (this.height / height))))];
    }
}
