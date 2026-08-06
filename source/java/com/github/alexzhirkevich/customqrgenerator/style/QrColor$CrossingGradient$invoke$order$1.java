package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: QrColor.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class QrColor$CrossingGradient$invoke$order$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final QrColor$CrossingGradient$invoke$order$1 INSTANCE = new QrColor$CrossingGradient$invoke$order$1();

    QrColor$CrossingGradient$invoke$order$1() {
        super(2, ComparisonsKt.class, "minOf", "minOf(II)I", 1);
    }

    public final Integer invoke(int i, int i2) {
        return Integer.valueOf(Math.min(i, i2));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2) {
        return invoke(num.intValue(), num2.intValue());
    }
}
