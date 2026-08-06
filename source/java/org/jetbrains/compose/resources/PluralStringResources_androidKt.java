package org.jetbrains.compose.resources;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluralStringResources.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a2\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"pluralStringResource", "", "resource", "Lorg/jetbrains/compose/resources/PluralStringResource;", "quantity", "", "(Lorg/jetbrains/compose/resources/PluralStringResource;ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getPluralString", "(Lorg/jetbrains/compose/resources/PluralStringResource;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatArgs", "", "", "(Lorg/jetbrains/compose/resources/PluralStringResource;I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(Lorg/jetbrains/compose/resources/PluralStringResource;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class PluralStringResources_androidKt {
    public static final String pluralStringResource(PluralStringResource pluralStringResource, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(pluralStringResource, "resource");
        composer.startReplaceableGroup(-53061668);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53061668, i2, -1, "org.jetbrains.compose.resources.pluralStringResource (PluralStringResources.android.kt:30)");
        }
        String pluralStringResource2 = androidx.compose.ui.res.StringResources_androidKt.pluralStringResource(pluralStringResource.getId(), i, composer, i2 & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pluralStringResource2;
    }

    public static final Object getPluralString(PluralStringResource pluralStringResource, int i, Continuation<? super String> continuation) {
        String quantityString = ResourceContextInitKt.getResourceContext().getResources().getQuantityString(pluralStringResource.getId(), i);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    public static final String pluralStringResource(PluralStringResource pluralStringResource, int i, Object[] objArr, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(pluralStringResource, "resource");
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        composer.startReplaceableGroup(-1726150737);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1726150737, i2, -1, "org.jetbrains.compose.resources.pluralStringResource (PluralStringResources.android.kt:65)");
        }
        String pluralStringResource2 = androidx.compose.ui.res.StringResources_androidKt.pluralStringResource(pluralStringResource.getId(), i, Arrays.copyOf(objArr, objArr.length), composer, i2 & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pluralStringResource2;
    }

    public static final Object getPluralString(PluralStringResource pluralStringResource, int i, Object[] objArr, Continuation<? super String> continuation) {
        String quantityString = ResourceContextInitKt.getResourceContext().getResources().getQuantityString(pluralStringResource.getId(), i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }
}
