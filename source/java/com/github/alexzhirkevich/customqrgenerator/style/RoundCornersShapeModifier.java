package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShape;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DefaultShapes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/RoundCornersShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "corner", "", "useNeighbors", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "(FZZZZZ)V", "invoke", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "Companion", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RoundCornersShapeModifier implements QrShapeModifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean bottomLeft;
    private final boolean bottomRight;
    private final float corner;
    private final boolean topLeft;
    private final boolean topRight;
    private final boolean useNeighbors;

    public RoundCornersShapeModifier(float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.corner = f;
        this.useNeighbors = z;
        this.topLeft = z2;
        this.topRight = z3;
        this.bottomLeft = z4;
        this.bottomRight = z5;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Companion companion = INSTANCE;
        float f = this.corner;
        boolean z = this.useNeighbors;
        return companion.isRoundDark(i, j, elementSize, neighbors, f, z, this.topLeft && !(z && (neighbors.getTop() || neighbors.getLeft())), this.topRight && !(this.useNeighbors && (neighbors.getTop() || neighbors.getRight())), this.bottomLeft && !(this.useNeighbors && (neighbors.getBottom() || neighbors.getLeft())), this.bottomRight && !(this.useNeighbors && (neighbors.getBottom() || neighbors.getRight())));
    }

    /* compiled from: DefaultShapes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/RoundCornersShapeModifier$Companion;", "", "()V", "isRoundDark", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "corner", "", "useNeighbors", "topLeft", "topRight", "bottomLeft", "bottomRight", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRoundDark(int i, int j, int elementSize, Neighbors neighbors, float corner, boolean useNeighbors, boolean topLeft, boolean topRight, boolean bottomLeft, boolean bottomRight) {
            Pair pair;
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            if (useNeighbors) {
                if (!neighbors.getHasAny()) {
                    if (corner <= 0.5f && 0.5f <= corner) {
                        return new QrPixelShape.Circle(1.0f).invoke(i, j, elementSize, neighbors);
                    }
                }
                if (neighbors.getHasAllNearest()) {
                    return QrPixelShape.Default.INSTANCE.invoke(i, j, elementSize, neighbors);
                }
            }
            float coerceIn = 0.5f - RangesKt.coerceIn(corner, 0.0f, 0.5f);
            float f = elementSize;
            float f2 = coerceIn * f;
            float f3 = f / 2.0f;
            float f4 = f3 - f2;
            float f5 = f3 + f2;
            if (topLeft && i < f4 && j < f4) {
                pair = TuplesKt.to(Float.valueOf(f4), Float.valueOf(f4));
            } else if (topRight && i < f4 && j > f5) {
                pair = TuplesKt.to(Float.valueOf(f4), Float.valueOf(f5));
            } else if (bottomLeft && i > f5 && j < f4) {
                pair = TuplesKt.to(Float.valueOf(f5), Float.valueOf(f4));
            } else if (bottomRight && i > f5 && j > f5) {
                pair = TuplesKt.to(Float.valueOf(f5), Float.valueOf(f5));
            } else {
                return QrPixelShape.Default.INSTANCE.invoke(i, j, elementSize, neighbors);
            }
            double d = 2;
            return ((float) Math.sqrt((double) (((float) Math.pow((double) (((Number) pair.component1()).floatValue() - ((float) i)), d)) + ((float) Math.pow((double) (((Number) pair.component2()).floatValue() - ((float) j)), d))))) < f4;
        }
    }
}
