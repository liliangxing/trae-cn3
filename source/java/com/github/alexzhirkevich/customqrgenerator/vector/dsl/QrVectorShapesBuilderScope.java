package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape;
import kotlin.Metadata;

/* compiled from: QrVectorShapesBuilderScope.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r\u0082\u0001\u0001\u0017¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorShapes;", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;)V", "darkPixel", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "setDarkPixel", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;)V", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "setFrame", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;)V", "lightPixel", "getLightPixel", "setLightPixel", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorShapesBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorShapesBuilderScope extends IQrVectorShapes {
    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    QrVectorBallShape getBall();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    QrVectorPixelShape getDarkPixel();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    QrVectorFrameShape getFrame();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    QrVectorPixelShape getLightPixel();

    void setBall(QrVectorBallShape qrVectorBallShape);

    void setDarkPixel(QrVectorPixelShape qrVectorPixelShape);

    void setFrame(QrVectorFrameShape qrVectorFrameShape);

    void setLightPixel(QrVectorPixelShape qrVectorPixelShape);
}
