package androidx.compose.p001ui.precompose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: PausableSubPreComposeController.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalPausableSubPreComposeController", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "getLocalPausableSubPreComposeController", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PausableSubPreComposeControllerKt {
    private static final ProvidableCompositionLocal<PausableSubPreComposeController> LocalPausableSubPreComposeController = CompositionLocalKt.staticCompositionLocalOf(new Function0<PausableSubPreComposeController>() { // from class: androidx.compose.ui.precompose.PausableSubPreComposeControllerKt$LocalPausableSubPreComposeController$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PausableSubPreComposeController m1832invoke() {
            return null;
        }
    });

    public static final ProvidableCompositionLocal<PausableSubPreComposeController> getLocalPausableSubPreComposeController() {
        return LocalPausableSubPreComposeController;
    }
}
