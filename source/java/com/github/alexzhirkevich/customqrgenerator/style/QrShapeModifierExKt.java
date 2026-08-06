package com.github.alexzhirkevich.customqrgenerator.style;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrShapeModifierEx.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001aE\u0010\u0005\u001a\u00020\u0001*\u00020\u000126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\u0007H\u0080\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0080\u0002¨\u0006\u000e"}, d2 = {"and", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", PreloadConfig.KEY_OTHER, "not", "or", "rem", "remRuntime", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "elemSize", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "neighbors", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrShapeModifierExKt {
    public static final QrShapeModifier not(final QrShapeModifier qrShapeModifier) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        return new QrShapeModifier() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierExKt$$ExternalSyntheticLambda3
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i, int i2, int i3, Neighbors neighbors) {
                boolean m9345not$lambda0;
                m9345not$lambda0 = QrShapeModifierExKt.m9345not$lambda0(QrShapeModifier.this, i, i2, i3, neighbors);
                return m9345not$lambda0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: not$lambda-0, reason: not valid java name */
    public static final boolean m9345not$lambda0(QrShapeModifier this_not, int i, int i2, int i3, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(this_not, "$this_not");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return !this_not.invoke(i, i2, i3, neighbors);
    }

    public static final QrShapeModifier or(final QrShapeModifier qrShapeModifier, final QrShapeModifier other) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new QrShapeModifier() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierExKt$$ExternalSyntheticLambda2
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i, int i2, int i3, Neighbors neighbors) {
                boolean m9346or$lambda1;
                m9346or$lambda1 = QrShapeModifierExKt.m9346or$lambda1(QrShapeModifier.this, other, i, i2, i3, neighbors);
                return m9346or$lambda1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: or$lambda-1, reason: not valid java name */
    public static final boolean m9346or$lambda1(QrShapeModifier this_or, QrShapeModifier other, int i, int i2, int i3, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(this_or, "$this_or");
        Intrinsics.checkNotNullParameter(other, "$other");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return this_or.invoke(i, i2, i3, neighbors) || other.invoke(i, i2, i3, neighbors);
    }

    public static final QrShapeModifier and(final QrShapeModifier qrShapeModifier, final QrShapeModifier other) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new QrShapeModifier() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierExKt$$ExternalSyntheticLambda4
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i, int i2, int i3, Neighbors neighbors) {
                boolean m9344and$lambda2;
                m9344and$lambda2 = QrShapeModifierExKt.m9344and$lambda2(QrShapeModifier.this, other, i, i2, i3, neighbors);
                return m9344and$lambda2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: and$lambda-2, reason: not valid java name */
    public static final boolean m9344and$lambda2(QrShapeModifier this_and, QrShapeModifier other, int i, int i2, int i3, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(this_and, "$this_and");
        Intrinsics.checkNotNullParameter(other, "$other");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return this_and.invoke(i, i2, i3, neighbors) && other.invoke(i, i2, i3, neighbors);
    }

    public static final QrShapeModifier rem(final QrShapeModifier qrShapeModifier, final int i) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        return new QrShapeModifier() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierExKt$$ExternalSyntheticLambda1
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i2, int i3, int i4, Neighbors neighbors) {
                boolean m9347rem$lambda3;
                m9347rem$lambda3 = QrShapeModifierExKt.m9347rem$lambda3(QrShapeModifier.this, i, i2, i3, i4, neighbors);
                return m9347rem$lambda3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rem$lambda-3, reason: not valid java name */
    public static final boolean m9347rem$lambda3(QrShapeModifier this_rem, int i, int i2, int i3, int i4, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(this_rem, "$this_rem");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        return this_rem.invoke(i2 % i, i3 % i, i, neighbors);
    }

    public static final QrShapeModifier rem(final QrShapeModifier qrShapeModifier, final Function2<? super Integer, ? super Neighbors, Integer> remRuntime) {
        Intrinsics.checkNotNullParameter(qrShapeModifier, "<this>");
        Intrinsics.checkNotNullParameter(remRuntime, "remRuntime");
        return new QrShapeModifier() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierExKt$$ExternalSyntheticLambda0
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
            public final boolean invoke(int i, int i2, int i3, Neighbors neighbors) {
                boolean m9348rem$lambda4;
                m9348rem$lambda4 = QrShapeModifierExKt.m9348rem$lambda4(Function2.this, qrShapeModifier, i, i2, i3, neighbors);
                return m9348rem$lambda4;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rem$lambda-4, reason: not valid java name */
    public static final boolean m9348rem$lambda4(Function2 remRuntime, QrShapeModifier this_rem, int i, int i2, int i3, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(remRuntime, "$remRuntime");
        Intrinsics.checkNotNullParameter(this_rem, "$this_rem");
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        int intValue = ((Number) remRuntime.invoke(Integer.valueOf(i3), neighbors)).intValue();
        return this_rem.invoke(i % intValue, i2 % intValue, intValue, neighbors);
    }
}
