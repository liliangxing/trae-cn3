package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrBallShape.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"asBallShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrBallShapeKt {
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    public static final QrBallShape asBallShape(final QrShapeModifier qrShapeModifier) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        return qrShapeModifier instanceof QrBallShape ? (QrBallShape) qrShapeModifier : new QrBallShape() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrBallShapeKt$$ExternalSyntheticLambda0
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i, int i2, int i3, Neighbors neighbors) {
                boolean m2742asBallShape$lambda0;
                m2742asBallShape$lambda0 = QrBallShapeKt.m2742asBallShape$lambda0(QrShapeModifier.this, i, i2, i3, neighbors);
                return m2742asBallShape$lambda0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asBallShape$lambda-0, reason: not valid java name */
    public static final boolean m2742asBallShape$lambda0(QrShapeModifier qrShapeModifier, int i, int i2, int i3, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "$this_asBallShape");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return qrShapeModifier.invoke(i, i2, i3, neighbors);
    }
}
