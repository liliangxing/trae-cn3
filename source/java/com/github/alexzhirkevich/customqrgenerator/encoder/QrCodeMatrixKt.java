package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeMatrix.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¨\u0006\u0007"}, d2 = {"neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "i", "", "j", "neighborsReversed", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeMatrixKt {
    private static final boolean neighbors$cmp(QrCodeMatrix qrCodeMatrix, int i, int i2, int i3, int i4) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(qrCodeMatrix.get(i3, i4) == qrCodeMatrix.get(i, i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static final Neighbors neighbors(QrCodeMatrix qrCodeMatrix, int i, int i2) {
        Intrinsics.checkNotNullParameter(qrCodeMatrix, "<this>");
        int i3 = i - 1;
        int i4 = i2 - 1;
        int i5 = i + 1;
        int i6 = i2 + 1;
        return new Neighbors(neighbors$cmp(qrCodeMatrix, i, i2, i3, i4), neighbors$cmp(qrCodeMatrix, i, i2, i5, i4), neighbors$cmp(qrCodeMatrix, i, i2, i3, i2), neighbors$cmp(qrCodeMatrix, i, i2, i, i4), neighbors$cmp(qrCodeMatrix, i, i2, i5, i2), neighbors$cmp(qrCodeMatrix, i, i2, i3, i6), neighbors$cmp(qrCodeMatrix, i, i2, i, i6), neighbors$cmp(qrCodeMatrix, i, i2, i5, i6));
    }

    /* renamed from: neighborsReversed$cmp-2, reason: not valid java name */
    private static final boolean m2740neighborsReversed$cmp2(QrCodeMatrix qrCodeMatrix, int i, int i2, int i3, int i4) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(qrCodeMatrix.get(i3, i4) == qrCodeMatrix.get(i, i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static final Neighbors neighborsReversed(QrCodeMatrix qrCodeMatrix, int i, int i2) {
        Intrinsics.checkNotNullParameter(qrCodeMatrix, "<this>");
        int i3 = i - 1;
        int i4 = i2 - 1;
        int i5 = i2 + 1;
        int i6 = i + 1;
        return new Neighbors(m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i3, i4), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i3, i5), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i, i4), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i3, i2), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i, i5), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i6, i4), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i6, i2), m2740neighborsReversed$cmp2(qrCodeMatrix, i, i2, i6, i5));
    }
}
