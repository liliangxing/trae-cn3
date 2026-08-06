package com.github.alexzhirkevich.customqrgenerator.vector;

import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.dsl.InternalQrVectorOptionsBuilderScope;
import com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorOptions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"createQrVectorOptions", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;", "block", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorOptionsBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrVectorOptionsKt {
    public static final QrVectorOptions createQrVectorOptions(Function1<? super QrVectorOptionsBuilderScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        QrVectorOptions.Builder builder = new QrVectorOptions.Builder();
        function1.invoke(new InternalQrVectorOptionsBuilderScope(builder));
        return builder.build();
    }
}
