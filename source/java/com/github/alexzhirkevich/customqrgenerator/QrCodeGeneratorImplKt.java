package com.github.alexzhirkevich.customqrgenerator;

import com.github.alexzhirkevich.customqrgenerator.style.EmptyDrawable;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogo;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeGeneratorImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"fit", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeGeneratorImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final QrErrorCorrectionLevel fit(QrErrorCorrectionLevel qrErrorCorrectionLevel, QrLogo qrLogo) {
        boolean z = true;
        float size = qrLogo.getSize() * (1 + qrLogo.getPadding().getValue());
        if ((size <= Float.MIN_VALUE || Intrinsics.areEqual(qrLogo.getDrawable(), EmptyDrawable.INSTANCE)) && Intrinsics.areEqual(qrLogo.getPadding(), QrLogoPadding.Empty.INSTANCE)) {
            z = false;
        }
        return QrErrorCorrectionLevelKt.fit(qrErrorCorrectionLevel, z, size);
    }
}
