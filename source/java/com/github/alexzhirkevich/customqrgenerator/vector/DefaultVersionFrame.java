package com.github.alexzhirkevich.customqrgenerator.vector;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeDrawable.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/DefaultVersionFrame;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class DefaultVersionFrame implements QrVectorFrameShape {
    public static final DefaultVersionFrame INSTANCE = new DefaultVersionFrame();

    private DefaultVersionFrame() {
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
    public Path createPath(float size, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Path path = new Path();
        float f = size / 5.0f;
        path.addRect(0.0f, 0.0f, size, f, Path.Direction.CW);
        path.addRect(0.0f, 0.0f, f, size, Path.Direction.CW);
        float f2 = size - f;
        path.addRect(f2, 0.0f, size, size, Path.Direction.CW);
        path.addRect(0.0f, f2, size, size, Path.Direction.CW);
        return path;
    }
}
