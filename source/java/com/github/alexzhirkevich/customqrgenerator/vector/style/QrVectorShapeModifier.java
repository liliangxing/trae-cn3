package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;

/* compiled from: QrVectorShapeModifier.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrVectorShapeModifier {
    Path createPath(float size, Neighbors neighbors);
}
