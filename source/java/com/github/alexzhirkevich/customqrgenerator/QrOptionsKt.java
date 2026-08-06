package com.github.alexzhirkevich.customqrgenerator;

import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope;
import com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScopeKt;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrOptions.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"createQrOptions", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "padding", "", "build", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOptionsBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrOptionsKt {
    public static /* synthetic */ QrOptions createQrOptions$default(int i, int i2, float f, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if ((i3 & 4) != 0) {
            f = 0.125f;
        }
        Intrinsics.checkNotNullParameter(function1, "build");
        QrOptions.Builder padding = new QrOptions.Builder(i, i2).padding(f);
        function1.invoke(QrOptionsBuilderScopeKt.QrOptionsBuilderScope(padding));
        return padding.build();
    }

    @Deprecated(message = "Use QrVectorDrawable with createQrVectorOptions instead")
    public static final QrOptions createQrOptions(int i, int i2, float f, Function1<? super QrOptionsBuilderScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "build");
        QrOptions.Builder padding = new QrOptions.Builder(i, i2).padding(f);
        function1.invoke(QrOptionsBuilderScopeKt.QrOptionsBuilderScope(padding));
        return padding.build();
    }
}
