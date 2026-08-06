package com.bytedance.trae.kmp.p007ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResources_androidKt;

/* compiled from: KmpStringResource.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"kmpStringResource", "", "resource", "Lorg/jetbrains/compose/resources/StringResource;", "formatArgs", "", "", "(Lorg/jetbrains/compose/resources/StringResource;[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "base_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpStringResource_androidKt {
    public static final String kmpStringResource(StringResource stringResource, Object[] objArr, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(stringResource, "resource");
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        composer.startReplaceGroup(1041757904);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1041757904, i, -1, "com.bytedance.trae.kmp.ui.kmpStringResource (KmpStringResource.android.kt:10)");
        }
        String stringResource2 = StringResources_androidKt.stringResource(stringResource, Arrays.copyOf(objArr, objArr.length), composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stringResource2;
    }
}
