package com.github.alexzhirkevich.customqrgenerator.vector.style;

import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorShapes.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorShapes;", "darkPixel", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "lightPixel", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "centralSymmetry", "", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;Z)V", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "getCentralSymmetry", "()Z", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "getLightPixel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrVectorShapes implements IQrVectorShapes {
    private final QrVectorBallShape ball;
    private final boolean centralSymmetry;
    private final QrVectorPixelShape darkPixel;
    private final QrVectorFrameShape frame;
    private final QrVectorPixelShape lightPixel;

    public QrVectorShapes() {
        this(null, null, null, null, false, 31, null);
    }

    public static /* synthetic */ QrVectorShapes copy$default(QrVectorShapes qrVectorShapes, QrVectorPixelShape qrVectorPixelShape, QrVectorPixelShape qrVectorPixelShape2, QrVectorBallShape qrVectorBallShape, QrVectorFrameShape qrVectorFrameShape, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qrVectorPixelShape = qrVectorShapes.getDarkPixel();
        }
        if ((i & 2) != 0) {
            qrVectorPixelShape2 = qrVectorShapes.getLightPixel();
        }
        QrVectorPixelShape qrVectorPixelShape3 = qrVectorPixelShape2;
        if ((i & 4) != 0) {
            qrVectorBallShape = qrVectorShapes.getBall();
        }
        QrVectorBallShape qrVectorBallShape2 = qrVectorBallShape;
        if ((i & 8) != 0) {
            qrVectorFrameShape = qrVectorShapes.getFrame();
        }
        QrVectorFrameShape qrVectorFrameShape2 = qrVectorFrameShape;
        if ((i & 16) != 0) {
            z = qrVectorShapes.getCentralSymmetry();
        }
        return qrVectorShapes.copy(qrVectorPixelShape, qrVectorPixelShape3, qrVectorBallShape2, qrVectorFrameShape2, z);
    }

    public final QrVectorPixelShape component1() {
        return getDarkPixel();
    }

    public final QrVectorPixelShape component2() {
        return getLightPixel();
    }

    public final QrVectorBallShape component3() {
        return getBall();
    }

    public final QrVectorFrameShape component4() {
        return getFrame();
    }

    public final boolean component5() {
        return getCentralSymmetry();
    }

    public final QrVectorShapes copy(QrVectorPixelShape darkPixel, QrVectorPixelShape lightPixel, QrVectorBallShape ball, QrVectorFrameShape frame, boolean centralSymmetry) {
        Intrinsics.checkNotNullParameter(darkPixel, "darkPixel");
        Intrinsics.checkNotNullParameter(lightPixel, "lightPixel");
        Intrinsics.checkNotNullParameter(ball, "ball");
        Intrinsics.checkNotNullParameter(frame, "frame");
        return new QrVectorShapes(darkPixel, lightPixel, ball, frame, centralSymmetry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrVectorShapes)) {
            return false;
        }
        QrVectorShapes qrVectorShapes = (QrVectorShapes) other;
        return Intrinsics.areEqual(getDarkPixel(), qrVectorShapes.getDarkPixel()) && Intrinsics.areEqual(getLightPixel(), qrVectorShapes.getLightPixel()) && Intrinsics.areEqual(getBall(), qrVectorShapes.getBall()) && Intrinsics.areEqual(getFrame(), qrVectorShapes.getFrame()) && getCentralSymmetry() == qrVectorShapes.getCentralSymmetry();
    }

    public int hashCode() {
        int hashCode = ((((((getDarkPixel().hashCode() * 31) + getLightPixel().hashCode()) * 31) + getBall().hashCode()) * 31) + getFrame().hashCode()) * 31;
        boolean centralSymmetry = getCentralSymmetry();
        int i = centralSymmetry;
        if (centralSymmetry) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "QrVectorShapes(darkPixel=" + getDarkPixel() + ", lightPixel=" + getLightPixel() + ", ball=" + getBall() + ", frame=" + getFrame() + ", centralSymmetry=" + getCentralSymmetry() + ')';
    }

    public QrVectorShapes(QrVectorPixelShape qrVectorPixelShape, QrVectorPixelShape qrVectorPixelShape2, QrVectorBallShape qrVectorBallShape, QrVectorFrameShape qrVectorFrameShape, boolean z) {
        Intrinsics.checkNotNullParameter(qrVectorPixelShape, "darkPixel");
        Intrinsics.checkNotNullParameter(qrVectorPixelShape2, "lightPixel");
        Intrinsics.checkNotNullParameter(qrVectorBallShape, "ball");
        Intrinsics.checkNotNullParameter(qrVectorFrameShape, "frame");
        this.darkPixel = qrVectorPixelShape;
        this.lightPixel = qrVectorPixelShape2;
        this.ball = qrVectorBallShape;
        this.frame = qrVectorFrameShape;
        this.centralSymmetry = z;
    }

    public /* synthetic */ QrVectorShapes(QrVectorPixelShape.Default r4, QrVectorPixelShape.Default r5, QrVectorBallShape.Default r6, QrVectorFrameShape.Default r7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? QrVectorPixelShape.Default.INSTANCE : r4, (i & 2) != 0 ? QrVectorPixelShape.Default.INSTANCE : r5, (i & 4) != 0 ? QrVectorBallShape.Default.INSTANCE : r6, (i & 8) != 0 ? QrVectorFrameShape.Default.INSTANCE : r7, (i & 16) != 0 ? true : z);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorPixelShape getDarkPixel() {
        return this.darkPixel;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorPixelShape getLightPixel() {
        return this.lightPixel;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorBallShape getBall() {
        return this.ball;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorFrameShape getFrame() {
        return this.frame;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public boolean getCentralSymmetry() {
        return this.centralSymmetry;
    }
}
