package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrEncoder.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toQrMatrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "Lcom/google/zxing/qrcode/encoder/ByteMatrix;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrEncoderKt {
    public static final QrCodeMatrix toQrMatrix(ByteMatrix byteMatrix) {
        QrCodeMatrix.PixelType pixelType;
        Intrinsics.checkNotNullParameter(byteMatrix, "<this>");
        if (byteMatrix.getWidth() != byteMatrix.getHeight()) {
            throw new IllegalStateException("Non-square qr byte matrix");
        }
        QrCodeMatrix qrCodeMatrix = new QrCodeMatrix(byteMatrix.getWidth());
        int width = byteMatrix.getWidth();
        for (int i = 0; i < width; i++) {
            int width2 = byteMatrix.getWidth();
            for (int i2 = 0; i2 < width2; i2++) {
                if (byteMatrix.get(i, i2) == 1) {
                    pixelType = QrCodeMatrix.PixelType.DarkPixel;
                } else {
                    pixelType = QrCodeMatrix.PixelType.LightPixel;
                }
                qrCodeMatrix.set(i, i2, pixelType);
            }
        }
        return qrCodeMatrix;
    }
}
