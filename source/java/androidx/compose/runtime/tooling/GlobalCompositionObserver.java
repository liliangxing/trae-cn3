package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.RecomposeScope;
import java.util.Collection;
import kotlin.Metadata;

/* compiled from: GlobalCompositionObserver.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J&\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/tooling/GlobalCompositionObserver;", "", "onBeginComposition", "", "composition", "Landroidx/compose/runtime/Composition;", "onScopeEnter", "scope", "Landroidx/compose/runtime/RecomposeScope;", "recomposeToGroupEnd", "", "onReadInScope", "value", "onScopeExit", "onEndComposition", "onScopeInvalidated", "onScopeDisposed", "onStartDefaults", "onEndDefaults", "onInvalidation", "kind", "Landroidx/compose/runtime/tooling/InvalidationKind;", "triggerStates", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GlobalCompositionObserver {
    void onBeginComposition(Composition composition);

    void onEndComposition(Composition composition);

    void onEndDefaults(RecomposeScope scope);

    default void onInvalidation(InvalidationKind kind, Object scope, Collection<? extends Object> triggerStates) {
    }

    void onReadInScope(RecomposeScope scope, Object value);

    void onScopeDisposed(RecomposeScope scope);

    void onScopeEnter(RecomposeScope scope, boolean recomposeToGroupEnd);

    void onScopeExit(RecomposeScope scope);

    void onScopeInvalidated(RecomposeScope scope, Object value);

    void onStartDefaults(RecomposeScope scope);
}
