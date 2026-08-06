package com.github.alexzhirkevich.customqrgenerator.style;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultShapes.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/DefaultShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "()V", "invoke", "", RXScreenCaptureService.KEY_INDEX, "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultShapeModifier implements QrShapeModifier {
    public static final DefaultShapeModifier INSTANCE = new DefaultShapeModifier();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return true;
    }

    private DefaultShapeModifier() {
    }
}
