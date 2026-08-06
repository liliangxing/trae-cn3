package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;

/* compiled from: QrHighlighting.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/IAnchorsHighlighting;", "", "alpha", "", "getAlpha", "()F", "cornerEyes", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "getCornerEyes", "()Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "timingLines", "getTimingLines", "versionEyes", "getVersionEyes", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IAnchorsHighlighting {
    float getAlpha();

    HighlightingType getCornerEyes();

    HighlightingType getTimingLines();

    HighlightingType getVersionEyes();
}
