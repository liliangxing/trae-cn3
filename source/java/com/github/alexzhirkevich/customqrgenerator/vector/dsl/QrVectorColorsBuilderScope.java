package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import kotlin.Metadata;

/* compiled from: QrVectorColorsBuilderScope.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorColorsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorColors;", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "dark", "getDark", "setDark", "frame", "getFrame", "setFrame", "light", "getLight", "setLight", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorColorsBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorColorsBuilderScope extends IQrVectorColors {
    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    QrVectorColor getBall();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    QrVectorColor getDark();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    QrVectorColor getFrame();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    QrVectorColor getLight();

    void setBall(QrVectorColor qrVectorColor);

    void setDark(QrVectorColor qrVectorColor);

    void setFrame(QrVectorColor qrVectorColor);

    void setLight(QrVectorColor qrVectorColor);
}
