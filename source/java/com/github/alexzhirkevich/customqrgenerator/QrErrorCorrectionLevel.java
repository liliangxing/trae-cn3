package com.github.alexzhirkevich.customqrgenerator;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import kotlin.Metadata;

/* compiled from: QrErrorCorrectionLevel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "", "lvl", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "(Ljava/lang/String;ILcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;)V", "getLvl$custom_qr_generator_release", "()Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "Auto", "Low", "Medium", "MediumHigh", "High", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum QrErrorCorrectionLevel {
    Auto(ErrorCorrectionLevel.L),
    Low(ErrorCorrectionLevel.L),
    Medium(ErrorCorrectionLevel.M),
    MediumHigh(ErrorCorrectionLevel.Q),
    High(ErrorCorrectionLevel.H);

    private final ErrorCorrectionLevel lvl;

    QrErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.lvl = errorCorrectionLevel;
    }

    /* renamed from: getLvl$custom_qr_generator_release, reason: from getter */
    public final ErrorCorrectionLevel getLvl() {
        return this.lvl;
    }
}
