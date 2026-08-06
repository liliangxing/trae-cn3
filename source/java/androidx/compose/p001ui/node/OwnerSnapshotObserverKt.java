package androidx.compose.p001ui.node;

import androidx.compose.runtime.snapshots.ScopeInvalidationContext;
import androidx.compose.runtime.tooling.GlobalCompositionObserver;
import androidx.compose.runtime.tooling.GlobalCompositionObserverKt;
import androidx.compose.runtime.tooling.InvalidationKind;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: OwnerSnapshotObserver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"dispatchInvalidation", "", "kind", "Landroidx/compose/runtime/tooling/InvalidationKind;", "scope", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class OwnerSnapshotObserverKt {
    public static final void dispatchInvalidation(InvalidationKind invalidationKind, Object obj) {
        GlobalCompositionObserver globalCompositionObserver;
        if (GlobalCompositionObserverKt.isInvalidationObservingEnabled() && (globalCompositionObserver = GlobalCompositionObserverKt.getGlobalCompositionObserver()) != null) {
            List currentTriggerStates = ScopeInvalidationContext.getCurrentTriggerStates();
            if (currentTriggerStates == null) {
                currentTriggerStates = CollectionsKt.emptyList();
            }
            globalCompositionObserver.onInvalidation(invalidationKind, obj, currentTriggerStates);
        }
    }
}
