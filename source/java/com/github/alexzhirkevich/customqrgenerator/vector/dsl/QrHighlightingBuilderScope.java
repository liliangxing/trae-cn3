package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.HighlightingType;
import com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting;
import kotlin.Metadata;

/* compiled from: QrHighlightingBuilderScope.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0018\u0010\u000f\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u0082\u0001\u0001\u0012¨\u0006\u0013"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrHighlightingBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/IAnchorsHighlighting;", "alpha", "", "getAlpha", "()F", "cornerEyes", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "getCornerEyes", "()Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "setCornerEyes", "(Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;)V", "timingLines", "getTimingLines", "setTimingLines", "versionEyes", "getVersionEyes", "setVersionEyes", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrHighlightingBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrHighlightingBuilderScope extends IAnchorsHighlighting {
    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    float getAlpha();

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    HighlightingType getCornerEyes();

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    HighlightingType getTimingLines();

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    HighlightingType getVersionEyes();

    void setCornerEyes(HighlightingType highlightingType);

    void setTimingLines(HighlightingType highlightingType);

    void setVersionEyes(HighlightingType highlightingType);
}
