package org.jetbrains.compose.resources;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringArrayResources.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"stringArrayResource", "", "", "resource", "Lorg/jetbrains/compose/resources/StringArrayResource;", "(Lorg/jetbrains/compose/resources/StringArrayResource;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "getStringArray", "(Lorg/jetbrains/compose/resources/StringArrayResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class StringArrayResources_androidKt {
    public static final List<String> stringArrayResource(StringArrayResource stringArrayResource, Composer composer, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(stringArrayResource, "resource");
        composer.startReplaceableGroup(-239851985);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-239851985, i, -1, "org.jetbrains.compose.resources.stringArrayResource (StringArrayResources.android.kt:26)");
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(ArraysKt.toList(androidx.compose.ui.res.StringResources_androidKt.stringArrayResource(stringArrayResource.getId(), composer, 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        List<String> list = (List) obj;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return list;
    }

    public static final Object getStringArray(StringArrayResource stringArrayResource, Continuation<? super List<String>> continuation) {
        Object obj;
        Resources resources = ResourceContextInitKt.getResourceContext().getResources();
        try {
            Result.Companion companion = Result.Companion;
            String[] stringArray = resources.getStringArray(stringArrayResource.getId());
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            obj = Result.constructor-impl(ArraysKt.toList(stringArray));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        List list = (List) obj;
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
