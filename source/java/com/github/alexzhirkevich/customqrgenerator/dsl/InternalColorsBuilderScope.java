package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrColors;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrColorsBuilderScope.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalColorsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrColorsBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "ball", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "dark", "getDark", "setDark", "frame", "getFrame", "setFrame", "highlighting", "getHighlighting", "setHighlighting", "light", "getLight", "setLight", "", "symmetry", "getSymmetry", "()Z", "setSymmetry", "(Z)V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalColorsBuilderScope implements QrColorsBuilderScope {
    private final QrOptions.Builder builder;

    public InternalColorsBuilderScope(QrOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getLight() {
        return this.builder.getColors().getLight();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setLight(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), qrColor, null, null, null, null, false, 62, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getDark() {
        return this.builder.getColors().getDark();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setDark(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), null, qrColor, null, null, null, false, 61, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getFrame() {
        return this.builder.getColors().getFrame();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setFrame(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), null, null, qrColor, null, null, false, 59, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getBall() {
        return this.builder.getColors().getBall();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setBall(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), null, null, null, qrColor, null, false, 55, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getHighlighting() {
        return this.builder.getColors().getHighlighting();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setHighlighting(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), null, null, null, null, qrColor, false, 47, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public boolean getSymmetry() {
        return this.builder.getColors().getSymmetry();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrColorsBuilderScope
    public void setSymmetry(boolean z) {
        QrOptions.Builder builder = this.builder;
        builder.colors(QrColors.copy$default(builder.getColors(), null, null, null, null, null, z, 31, null));
    }
}
