package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrHighlightingShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShape;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrElementsShapes.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorShapes instead")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRElementsShapes;", "darkPixel", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "lightPixel", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "highlighting", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;)V", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "getHighlighting", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "getLightPixel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrElementsShapes implements IQRElementsShapes {
    private final QrBallShape ball;
    private final QrPixelShape darkPixel;
    private final QrFrameShape frame;
    private final QrHighlightingShape highlighting;
    private final QrPixelShape lightPixel;

    public QrElementsShapes() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ QrElementsShapes copy$default(QrElementsShapes qrElementsShapes, QrPixelShape qrPixelShape, QrPixelShape qrPixelShape2, QrFrameShape qrFrameShape, QrBallShape qrBallShape, QrHighlightingShape qrHighlightingShape, int i, Object obj) {
        if ((i & 1) != 0) {
            qrPixelShape = qrElementsShapes.getDarkPixel();
        }
        if ((i & 2) != 0) {
            qrPixelShape2 = qrElementsShapes.getLightPixel();
        }
        QrPixelShape qrPixelShape3 = qrPixelShape2;
        if ((i & 4) != 0) {
            qrFrameShape = qrElementsShapes.getFrame();
        }
        QrFrameShape qrFrameShape2 = qrFrameShape;
        if ((i & 8) != 0) {
            qrBallShape = qrElementsShapes.getBall();
        }
        QrBallShape qrBallShape2 = qrBallShape;
        if ((i & 16) != 0) {
            qrHighlightingShape = qrElementsShapes.getHighlighting();
        }
        return qrElementsShapes.copy(qrPixelShape, qrPixelShape3, qrFrameShape2, qrBallShape2, qrHighlightingShape);
    }

    public final QrPixelShape component1() {
        return getDarkPixel();
    }

    public final QrPixelShape component2() {
        return getLightPixel();
    }

    public final QrFrameShape component3() {
        return getFrame();
    }

    public final QrBallShape component4() {
        return getBall();
    }

    public final QrHighlightingShape component5() {
        return getHighlighting();
    }

    public final QrElementsShapes copy(QrPixelShape darkPixel, QrPixelShape lightPixel, QrFrameShape frame, QrBallShape ball, QrHighlightingShape highlighting) {
        Intrinsics.checkNotNullParameter(darkPixel, "darkPixel");
        Intrinsics.checkNotNullParameter(lightPixel, "lightPixel");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(ball, "ball");
        Intrinsics.checkNotNullParameter(highlighting, "highlighting");
        return new QrElementsShapes(darkPixel, lightPixel, frame, ball, highlighting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrElementsShapes)) {
            return false;
        }
        QrElementsShapes qrElementsShapes = (QrElementsShapes) other;
        return Intrinsics.areEqual(getDarkPixel(), qrElementsShapes.getDarkPixel()) && Intrinsics.areEqual(getLightPixel(), qrElementsShapes.getLightPixel()) && Intrinsics.areEqual(getFrame(), qrElementsShapes.getFrame()) && Intrinsics.areEqual(getBall(), qrElementsShapes.getBall()) && Intrinsics.areEqual(getHighlighting(), qrElementsShapes.getHighlighting());
    }

    public int hashCode() {
        return (((((((getDarkPixel().hashCode() * 31) + getLightPixel().hashCode()) * 31) + getFrame().hashCode()) * 31) + getBall().hashCode()) * 31) + getHighlighting().hashCode();
    }

    public String toString() {
        return "QrElementsShapes(darkPixel=" + getDarkPixel() + ", lightPixel=" + getLightPixel() + ", frame=" + getFrame() + ", ball=" + getBall() + ", highlighting=" + getHighlighting() + ')';
    }

    public QrElementsShapes(QrPixelShape qrPixelShape, QrPixelShape qrPixelShape2, QrFrameShape qrFrameShape, QrBallShape qrBallShape, QrHighlightingShape qrHighlightingShape) {
        Intrinsics.checkNotNullParameter(qrPixelShape, "darkPixel");
        Intrinsics.checkNotNullParameter(qrPixelShape2, "lightPixel");
        Intrinsics.checkNotNullParameter(qrFrameShape, "frame");
        Intrinsics.checkNotNullParameter(qrBallShape, "ball");
        Intrinsics.checkNotNullParameter(qrHighlightingShape, "highlighting");
        this.darkPixel = qrPixelShape;
        this.lightPixel = qrPixelShape2;
        this.frame = qrFrameShape;
        this.ball = qrBallShape;
        this.highlighting = qrHighlightingShape;
    }

    public /* synthetic */ QrElementsShapes(QrPixelShape.Default r4, QrPixelShape.Default r5, QrFrameShape.Default r6, QrBallShape.Default r7, QrHighlightingShape.Default r8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? QrPixelShape.Default.INSTANCE : r4, (i & 2) != 0 ? QrPixelShape.Default.INSTANCE : r5, (i & 4) != 0 ? QrFrameShape.Default.INSTANCE : r6, (i & 8) != 0 ? QrBallShape.Default.INSTANCE : r7, (i & 16) != 0 ? QrHighlightingShape.Default.INSTANCE : r8);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrPixelShape getDarkPixel() {
        return this.darkPixel;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrPixelShape getLightPixel() {
        return this.lightPixel;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrFrameShape getFrame() {
        return this.frame;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrBallShape getBall() {
        return this.ball;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrHighlightingShape getHighlighting() {
        return this.highlighting;
    }
}
