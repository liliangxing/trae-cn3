package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrRenderResult.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006("}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;", "", "bitMatrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "paddingX", "", "paddingY", "pixelSize", "shapeIncrease", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/Rectangle;", "ball", "error", "(Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;IIIILcom/github/alexzhirkevich/customqrgenerator/encoder/Rectangle;Lcom/github/alexzhirkevich/customqrgenerator/encoder/Rectangle;I)V", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/encoder/Rectangle;", "getBitMatrix", "()Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "getError", "()I", "getFrame", "getPaddingX", "getPaddingY", "getPixelSize", "getShapeIncrease", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class QrRenderResult {
    private final Rectangle ball;
    private final QrCodeMatrix bitMatrix;
    private final int error;
    private final Rectangle frame;
    private final int paddingX;
    private final int paddingY;
    private final int pixelSize;
    private final int shapeIncrease;

    /* renamed from: component1, reason: from getter */
    public final QrCodeMatrix getBitMatrix() {
        return this.bitMatrix;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPaddingX() {
        return this.paddingX;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPaddingY() {
        return this.paddingY;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPixelSize() {
        return this.pixelSize;
    }

    /* renamed from: component5, reason: from getter */
    public final int getShapeIncrease() {
        return this.shapeIncrease;
    }

    /* renamed from: component6, reason: from getter */
    public final Rectangle getFrame() {
        return this.frame;
    }

    /* renamed from: component7, reason: from getter */
    public final Rectangle getBall() {
        return this.ball;
    }

    /* renamed from: component8, reason: from getter */
    public final int getError() {
        return this.error;
    }

    public final QrRenderResult copy(QrCodeMatrix bitMatrix, int paddingX, int paddingY, int pixelSize, int shapeIncrease, Rectangle frame, Rectangle ball, int error) {
        Intrinsics.checkNotNullParameter(bitMatrix, "bitMatrix");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(ball, "ball");
        return new QrRenderResult(bitMatrix, paddingX, paddingY, pixelSize, shapeIncrease, frame, ball, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrRenderResult)) {
            return false;
        }
        QrRenderResult qrRenderResult = (QrRenderResult) other;
        return Intrinsics.areEqual(this.bitMatrix, qrRenderResult.bitMatrix) && this.paddingX == qrRenderResult.paddingX && this.paddingY == qrRenderResult.paddingY && this.pixelSize == qrRenderResult.pixelSize && this.shapeIncrease == qrRenderResult.shapeIncrease && Intrinsics.areEqual(this.frame, qrRenderResult.frame) && Intrinsics.areEqual(this.ball, qrRenderResult.ball) && this.error == qrRenderResult.error;
    }

    public int hashCode() {
        return (((((((((((((this.bitMatrix.hashCode() * 31) + Integer.hashCode(this.paddingX)) * 31) + Integer.hashCode(this.paddingY)) * 31) + Integer.hashCode(this.pixelSize)) * 31) + Integer.hashCode(this.shapeIncrease)) * 31) + this.frame.hashCode()) * 31) + this.ball.hashCode()) * 31) + Integer.hashCode(this.error);
    }

    public String toString() {
        return "QrRenderResult(bitMatrix=" + this.bitMatrix + ", paddingX=" + this.paddingX + ", paddingY=" + this.paddingY + ", pixelSize=" + this.pixelSize + ", shapeIncrease=" + this.shapeIncrease + ", frame=" + this.frame + ", ball=" + this.ball + ", error=" + this.error + ')';
    }

    public QrRenderResult(QrCodeMatrix bitMatrix, int i, int i2, int i3, int i4, Rectangle frame, Rectangle ball, int i5) {
        Intrinsics.checkNotNullParameter(bitMatrix, "bitMatrix");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(ball, "ball");
        this.bitMatrix = bitMatrix;
        this.paddingX = i;
        this.paddingY = i2;
        this.pixelSize = i3;
        this.shapeIncrease = i4;
        this.frame = frame;
        this.ball = ball;
        this.error = i5;
    }

    public final QrCodeMatrix getBitMatrix() {
        return this.bitMatrix;
    }

    public final int getPaddingX() {
        return this.paddingX;
    }

    public final int getPaddingY() {
        return this.paddingY;
    }

    public final int getPixelSize() {
        return this.pixelSize;
    }

    public final int getShapeIncrease() {
        return this.shapeIncrease;
    }

    public final Rectangle getFrame() {
        return this.frame;
    }

    public final Rectangle getBall() {
        return this.ball;
    }

    public final int getError() {
        return this.error;
    }
}
