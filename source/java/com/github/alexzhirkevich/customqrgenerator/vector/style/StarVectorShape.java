package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import androidx.core.graphics.MatrixKt;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultVectorShapes.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/StarVectorShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StarVectorShape implements QrVectorShapeModifier {
    public static final StarVectorShape INSTANCE = new StarVectorShape();

    private StarVectorShape() {
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
    public Path createPath(float size, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Path path = new Path();
        path.addRect(0.0f, 0.0f, size, size, Path.Direction.CW);
        Path path2 = new Path();
        for (int i = 0; i < 4; i++) {
            float f = size / 2;
            path2.addCircle(size, size, f, Path.Direction.CW);
            path2.transform(MatrixKt.rotationMatrix(90.0f, f, f));
        }
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }
}
