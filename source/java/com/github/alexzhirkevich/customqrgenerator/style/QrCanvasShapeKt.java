package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCanvasShape.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"toShapeModifier", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;", "elementSize", "", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCanvasShapeKt {
    public static final QrShapeModifier toShapeModifier(QrCanvasShape qrCanvasShape, int i) {
        Intrinsics.checkNotNullParameter(qrCanvasShape, "<this>");
        return new QrCanvasToShapeModifier(i, qrCanvasShape);
    }
}
