package com.github.alexzhirkevich.customqrgenerator.vector.style;

import kotlin.Metadata;

/* compiled from: QrVectorShapes.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorShapes;", "", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "centralSymmetry", "", "getCentralSymmetry", "()Z", "darkPixel", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "frame", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "lightPixel", "getLightPixel", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IQrVectorShapes {
    QrVectorBallShape getBall();

    boolean getCentralSymmetry();

    QrVectorPixelShape getDarkPixel();

    QrVectorFrameShape getFrame();

    QrVectorPixelShape getLightPixel();
}
