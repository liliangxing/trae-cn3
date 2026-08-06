package com.github.alexzhirkevich.customqrgenerator.style;

import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCanvasColor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"toQrColor", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasColor;", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCanvasColorKt {
    public static final QrColor toQrColor(QrCanvasColor qrCanvasColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(qrCanvasColor, "<this>");
        return new QrCanvasColorToQrColor(qrCanvasColor, i, i2);
    }
}
