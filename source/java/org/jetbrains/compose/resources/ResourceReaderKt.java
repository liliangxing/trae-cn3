package org.jetbrains.compose.resources;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceReader.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"readResourceBytes", "", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUri", "DefaultResourceReader", "Lorg/jetbrains/compose/resources/ResourceReader;", "getDefaultResourceReader", "()Lorg/jetbrains/compose/resources/ResourceReader;", "LocalResourceReader", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalResourceReader", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class ResourceReaderKt {
    private static final ResourceReader DefaultResourceReader = ResourceReader_androidKt.getPlatformResourceReader();
    private static final ProvidableCompositionLocal<ResourceReader> LocalResourceReader = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: org.jetbrains.compose.resources.ResourceReaderKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            ResourceReader resourceReader;
            resourceReader = ResourceReaderKt.DefaultResourceReader;
            return resourceReader;
        }
    });

    @InternalResourceApi
    public static final Object readResourceBytes(String str, Continuation<? super byte[]> continuation) {
        return DefaultResourceReader.read(str, continuation);
    }

    @InternalResourceApi
    public static final String getResourceUri(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return DefaultResourceReader.getUri(str);
    }

    public static final ResourceReader getDefaultResourceReader() {
        return DefaultResourceReader;
    }

    public static final ProvidableCompositionLocal<ResourceReader> getLocalResourceReader() {
        return LocalResourceReader;
    }
}
