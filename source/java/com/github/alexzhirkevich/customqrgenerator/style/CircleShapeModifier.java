package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DefaultShapes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/CircleShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "size", "", "(F)V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CircleShapeModifier implements QrShapeModifier {
    private final float size;

    public CircleShapeModifier() {
        this(0.0f, 1, null);
    }

    public CircleShapeModifier(float f) {
        this.size = f;
    }

    public /* synthetic */ CircleShapeModifier(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        float f = elementSize / 2.0f;
        double d = 2;
        return ((float) Math.sqrt((double) (((float) Math.pow((double) (f - ((float) i)), d)) + ((float) Math.pow((double) (f - ((float) j)), d))))) < f * RangesKt.coerceIn(this.size, 0.0f, 1.0f);
    }
}
