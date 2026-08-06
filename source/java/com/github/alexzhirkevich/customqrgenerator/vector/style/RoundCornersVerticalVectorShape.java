package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DefaultVectorShapes.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/RoundCornersVerticalVectorShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "(F)V", "getRadius", "()F", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RoundCornersVerticalVectorShape implements QrVectorShapeModifier {
    private final float radius;

    public RoundCornersVerticalVectorShape(float f) {
        this.radius = f;
    }

    public final float getRadius() {
        return this.radius;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
    public Path createPath(float size, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Path path = new Path();
        float coerceIn = size * (1 - RangesKt.coerceIn(this.radius, 0.0f, 1.0f));
        if (neighbors.getTop()) {
            path.addRect(coerceIn, 0.0f, size - coerceIn, size / 2.0f, Path.Direction.CW);
        } else {
            float f = size / 2;
            path.addCircle(f, f, (size / 2.0f) - coerceIn, Path.Direction.CW);
        }
        if (neighbors.getBottom()) {
            path.addRect(coerceIn, size / 2.0f, size - coerceIn, size, Path.Direction.CW);
        } else {
            float f2 = size / 2;
            path.addCircle(f2, f2, (size / 2.0f) - coerceIn, Path.Direction.CW);
        }
        return path;
    }
}
