package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrHighlightingShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShape;
import kotlin.Metadata;

/* compiled from: QrElementsShapesBuilderScope.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\r\u0082\u0001\u0001\u001d¨\u0006\u001e"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRElementsShapes;", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;)V", "darkPixel", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "setDarkPixel", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;)V", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "setFrame", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;)V", "highlighting", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "getHighlighting", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "setHighlighting", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;)V", "lightPixel", "getLightPixel", "setLightPixel", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrElementsShapesBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrElementsShapesBuilderScope extends IQRElementsShapes {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    QrBallShape getBall();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    QrPixelShape getDarkPixel();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    QrFrameShape getFrame();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    QrHighlightingShape getHighlighting();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    QrPixelShape getLightPixel();

    void setBall(QrBallShape qrBallShape);

    void setDarkPixel(QrPixelShape qrPixelShape);

    void setFrame(QrFrameShape qrFrameShape);

    void setHighlighting(QrHighlightingShape qrHighlightingShape);

    void setLightPixel(QrPixelShape qrPixelShape);
}
