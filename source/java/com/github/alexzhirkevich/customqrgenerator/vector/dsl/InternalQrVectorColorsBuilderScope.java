package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColors;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrVectorColorsBuilderScope.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorColorsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorColorsBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "ball", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "dark", "getDark", "setDark", "frame", "getFrame", "setFrame", "light", "getLight", "setLight", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrVectorColorsBuilderScope implements QrVectorColorsBuilderScope {
    private final QrVectorOptions.Builder builder;

    public InternalQrVectorColorsBuilderScope(QrVectorOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getDark() {
        return this.builder.getColors().getDark();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope
    public void setDark(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setColors(QrVectorColors.copy$default(builder.getColors(), qrVectorColor, null, null, null, 14, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getLight() {
        return this.builder.getColors().getLight();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope
    public void setLight(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setColors(QrVectorColors.copy$default(builder.getColors(), null, qrVectorColor, null, null, 13, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getBall() {
        return this.builder.getColors().getBall();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope
    public void setBall(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setColors(QrVectorColors.copy$default(builder.getColors(), null, null, qrVectorColor, null, 11, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getFrame() {
        return this.builder.getColors().getFrame();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorColorsBuilderScope
    public void setFrame(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setColors(QrVectorColors.copy$default(builder.getColors(), null, null, null, qrVectorColor, 7, null));
    }
}
