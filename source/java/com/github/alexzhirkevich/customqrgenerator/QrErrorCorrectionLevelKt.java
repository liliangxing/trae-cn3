package com.github.alexzhirkevich.customqrgenerator;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrErrorCorrectionLevel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"fit", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "hasLogo", "", "logoSize", "", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrErrorCorrectionLevelKt {
    public static final QrErrorCorrectionLevel fit(QrErrorCorrectionLevel qrErrorCorrectionLevel, boolean z, float f) {
        Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, "<this>");
        if (qrErrorCorrectionLevel != QrErrorCorrectionLevel.Auto) {
            return qrErrorCorrectionLevel;
        }
        if (!z) {
            return QrErrorCorrectionLevel.Low;
        }
        double d = f;
        if (d > 0.3d) {
            return QrErrorCorrectionLevel.High;
        }
        boolean z2 = false;
        if (0.2d <= d && d <= 0.3d) {
            z2 = true;
        }
        if (!z2 || qrErrorCorrectionLevel.getLvl().compareTo(ErrorCorrectionLevel.Q) >= 0) {
            return (f <= 0.05f || qrErrorCorrectionLevel.getLvl().compareTo(ErrorCorrectionLevel.M) >= 0) ? qrErrorCorrectionLevel : QrErrorCorrectionLevel.Medium;
        }
        return QrErrorCorrectionLevel.MediumHigh;
    }
}
