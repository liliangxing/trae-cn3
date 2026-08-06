package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import androidx.core.graphics.MatrixKt;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DefaultVectorShapes.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/RhombusVectorShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "scale", "", "(F)V", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RhombusVectorShape implements QrVectorShapeModifier {
    private final float scale;

    public RhombusVectorShape(float f) {
        this.scale = f;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
    public Path createPath(float size, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Path path = new Path();
        path.addRect(0.0f, 0.0f, size, size, Path.Direction.CW);
        float f = 1;
        float sqrt = f / ((float) Math.sqrt(2.0f));
        path.transform(MatrixKt.scaleMatrix(sqrt, sqrt));
        float f2 = ((f - sqrt) * size) / 2;
        path.transform(MatrixKt.translationMatrix(f2, f2));
        path.transform(MatrixKt.scaleMatrix(RangesKt.coerceIn(this.scale, 0.0f, 1.0f), RangesKt.coerceIn(this.scale, 0.0f, 1.0f)));
        float f3 = size / 2.0f;
        path.transform(MatrixKt.rotationMatrix(45.0f, f3, f3));
        return path;
    }
}
