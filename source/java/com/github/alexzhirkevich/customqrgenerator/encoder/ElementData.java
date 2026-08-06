package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrEncoder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/ElementData;", "", "x", "Lkotlin/Function1;", "", "y", "size", "modifier", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;)V", "getModifier", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "getSize", "()I", "getX", "()Lkotlin/jvm/functions/Function1;", "getY", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ElementData {
    private final QrShapeModifier modifier;
    private final int size;
    private final Function1<Integer, Integer> x;
    private final Function1<Integer, Integer> y;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementData(Function1<? super Integer, Integer> x, Function1<? super Integer, Integer> y, int i, QrShapeModifier modifier) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.x = x;
        this.y = y;
        this.size = i;
        this.modifier = modifier;
    }

    public final Function1<Integer, Integer> getX() {
        return this.x;
    }

    public final Function1<Integer, Integer> getY() {
        return this.y;
    }

    public final int getSize() {
        return this.size;
    }

    public final QrShapeModifier getModifier() {
        return this.modifier;
    }
}
