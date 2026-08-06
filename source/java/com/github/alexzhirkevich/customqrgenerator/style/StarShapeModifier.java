package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultShapes.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/StarShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class StarShapeModifier implements QrShapeModifier, QrPixelShape {
    public static final StarShapeModifier INSTANCE = new StarShapeModifier();

    private StarShapeModifier() {
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        float f = elementSize / 2.0f;
        int min = Math.min(i, elementSize - i);
        int min2 = Math.min(j, elementSize - j);
        return Math.sqrt(((double) (min * min)) + ((double) (min2 * min2))) > ((double) f);
    }
}
