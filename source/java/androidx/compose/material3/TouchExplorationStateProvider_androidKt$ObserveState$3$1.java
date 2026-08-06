package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: TouchExplorationStateProvider.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class TouchExplorationStateProvider_androidKt$ObserveState$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;
    final /* synthetic */ Function0<Unit> $onDispose;
    final /* synthetic */ Lifecycle $this_ObserveState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchExplorationStateProvider_androidKt$ObserveState$3$1(Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$this_ObserveState = lifecycle;
        this.$handleEvent = function1;
        this.$onDispose = function0;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        final Function1<Lifecycle.Event, Unit> function1 = this.$handleEvent;
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                function1.invoke(event);
            }
        };
        this.$this_ObserveState.addObserver(lifecycleObserver);
        final Function0<Unit> function0 = this.$onDispose;
        final Lifecycle lifecycle = this.$this_ObserveState;
        return new DisposableEffectResult() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                function0.invoke();
                lifecycle.removeObserver(lifecycleObserver);
            }
        };
    }
}
