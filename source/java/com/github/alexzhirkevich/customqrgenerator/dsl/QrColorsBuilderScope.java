package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.style.IQRColors;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import kotlin.Metadata;

/* compiled from: QrColorsBuilderScope.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0001\u0001\u001a¨\u0006\u001b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrColorsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRColors;", "ball", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "dark", "getDark", "setDark", "frame", "getFrame", "setFrame", "highlighting", "getHighlighting", "setHighlighting", "light", "getLight", "setLight", "symmetry", "", "getSymmetry", "()Z", "setSymmetry", "(Z)V", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalColorsBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrColorsBuilderScope extends IQRColors {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    QrColor getBall();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    QrColor getDark();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    QrColor getFrame();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    QrColor getHighlighting();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    QrColor getLight();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    boolean getSymmetry();

    void setBall(QrColor qrColor);

    void setDark(QrColor qrColor);

    void setFrame(QrColor qrColor);

    void setHighlighting(QrColor qrColor);

    void setLight(QrColor qrColor);

    void setSymmetry(boolean z);
}
