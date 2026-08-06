package com.github.alexzhirkevich.customqrgenerator.vector;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.QrData;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevelKt;
import com.github.alexzhirkevich.customqrgenerator.style.EmptyDrawable;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogo;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeDrawable.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a*\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00110\u00100\u000f\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u000fH\u0002¨\u0006\u0012"}, d2 = {"QrCodeDrawable", "Landroid/graphics/drawable/Drawable;", "data", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "options", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;", "charset", "Ljava/nio/charset/Charset;", "fit", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "pairCombinations", "", "Lkotlin/Pair;", "T", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeDrawableKt {
    public static /* synthetic */ Drawable QrCodeDrawable$default(QrData qrData, QrVectorOptions qrVectorOptions, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            qrVectorOptions = new QrVectorOptions.Builder().build();
        }
        if ((i & 4) != 0) {
            charset = null;
        }
        return QrCodeDrawable(qrData, qrVectorOptions, charset);
    }

    public static final Drawable QrCodeDrawable(QrData qrData, QrVectorOptions qrVectorOptions, Charset charset) {
        Intrinsics.checkNotNullParameter(qrData, "data");
        Intrinsics.checkNotNullParameter(qrVectorOptions, "options");
        return new QrCodeDrawableImpl(qrData, qrVectorOptions, charset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QrErrorCorrectionLevel fit(QrErrorCorrectionLevel qrErrorCorrectionLevel, QrVectorLogo qrVectorLogo, QrShape qrShape) {
        boolean z = true;
        float size = qrVectorLogo.getSize() * (1 + qrVectorLogo.getPadding().getValue()) * qrShape.getShapeSizeIncrease();
        if ((size <= Float.MIN_VALUE || Intrinsics.areEqual(qrVectorLogo.getDrawable(), EmptyDrawable.INSTANCE)) && Intrinsics.areEqual(qrVectorLogo.getPadding(), QrVectorLogoPadding.Empty.INSTANCE)) {
            z = false;
        }
        return QrErrorCorrectionLevelKt.fit(qrErrorCorrectionLevel, z, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<Pair<T, T>> pairCombinations(List<? extends T> list) {
        List createListBuilder = CollectionsKt.createListBuilder(list.size() * list.size());
        List<? extends T> list2 = list;
        for (T t : list2) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                createListBuilder.add(TuplesKt.to(t, it.next()));
            }
        }
        return CollectionsKt.toList(CollectionsKt.toSet(CollectionsKt.build(createListBuilder)));
    }
}
