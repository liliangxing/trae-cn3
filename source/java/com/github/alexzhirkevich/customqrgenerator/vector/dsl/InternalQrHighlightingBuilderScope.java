package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.HighlightingType;
import com.github.alexzhirkevich.customqrgenerator.QrHighlighting;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrHighlightingBuilderScope.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrHighlightingBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrHighlightingBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "cornerEyes", "getCornerEyes", "()Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "setCornerEyes", "(Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;)V", "timingLines", "getTimingLines", "setTimingLines", "versionEyes", "getVersionEyes", "setVersionEyes", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrHighlightingBuilderScope implements QrHighlightingBuilderScope {
    private final QrVectorOptions.Builder builder;

    public InternalQrHighlightingBuilderScope(QrVectorOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope, com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getCornerEyes() {
        return this.builder.getHighlighting().getCornerEyes();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope
    public void setCornerEyes(HighlightingType highlightingType) {
        Intrinsics.checkNotNullParameter(highlightingType, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setAnchorsHighlighting(QrHighlighting.copy$default(builder.getHighlighting(), highlightingType, null, null, 0.0f, 14, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope, com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getVersionEyes() {
        return this.builder.getHighlighting().getVersionEyes();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope
    public void setVersionEyes(HighlightingType highlightingType) {
        Intrinsics.checkNotNullParameter(highlightingType, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setAnchorsHighlighting(QrHighlighting.copy$default(builder.getHighlighting(), null, highlightingType, null, 0.0f, 13, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope, com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getTimingLines() {
        return this.builder.getHighlighting().getTimingLines();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope
    public void setTimingLines(HighlightingType highlightingType) {
        Intrinsics.checkNotNullParameter(highlightingType, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setAnchorsHighlighting(QrHighlighting.copy$default(builder.getHighlighting(), null, null, highlightingType, 0.0f, 11, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrHighlightingBuilderScope, com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public float getAlpha() {
        return this.builder.getHighlighting().getAlpha();
    }

    public void setAlpha(float f) {
        QrVectorOptions.Builder builder = this.builder;
        builder.setAnchorsHighlighting(QrHighlighting.copy$default(builder.getHighlighting(), null, null, null, f, 7, null));
    }
}
