package org.jetbrains.compose.resources;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringResources.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a*\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"stringResource", "", "resource", "Lorg/jetbrains/compose/resources/StringResource;", "(Lorg/jetbrains/compose/resources/StringResource;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getString", "(Lorg/jetbrains/compose/resources/StringResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatArgs", "", "", "(Lorg/jetbrains/compose/resources/StringResource;[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(Lorg/jetbrains/compose/resources/StringResource;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class StringResources_androidKt {
    public static final String stringResource(StringResource stringResource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(stringResource, "resource");
        composer.startReplaceableGroup(1662071163);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1662071163, i, -1, "org.jetbrains.compose.resources.stringResource (StringResources.android.kt:18)");
        }
        String stringResource2 = androidx.compose.ui.res.StringResources_androidKt.stringResource(stringResource.getId(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stringResource2;
    }

    public static final Object getString(StringResource stringResource, Continuation<? super String> continuation) {
        String string = ResourceContextInitKt.getResourceContext().getString(stringResource.getId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String stringResource(StringResource stringResource, Object[] objArr, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(stringResource, "resource");
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        composer.startReplaceableGroup(152231246);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(152231246, i, -1, "org.jetbrains.compose.resources.stringResource (StringResources.android.kt:46)");
        }
        String stringResource2 = androidx.compose.ui.res.StringResources_androidKt.stringResource(stringResource.getId(), Arrays.copyOf(objArr, objArr.length), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stringResource2;
    }

    public static final Object getString(StringResource stringResource, Object[] objArr, Continuation<? super String> continuation) {
        String string = ResourceContextInitKt.getResourceContext().getString(stringResource.getId(), Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
