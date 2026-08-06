package com.github.alexzhirkevich.customqrgenerator.vector.style;

import com.facebook.imageutils.JfifUtil;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorColor.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isTransparent", "", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)Z", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrVectorColorKt {
    public static final boolean isTransparent(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, "<this>");
        return (qrVectorColor instanceof QrVectorColor.Transparent) || (qrVectorColor instanceof QrVectorColor.Unspecified) || ((qrVectorColor instanceof QrVectorColor.Solid) && ((((QrVectorColor.Solid) qrVectorColor).getColor() >> 24) & JfifUtil.MARKER_FIRST_BYTE) == 0);
    }
}
