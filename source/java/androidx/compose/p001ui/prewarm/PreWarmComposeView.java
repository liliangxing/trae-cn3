package androidx.compose.p001ui.prewarm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.p001ui.platform.AbstractComposeView;
import androidx.compose.p001ui.platform.AndroidComposeView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ComposePreWarm.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010 \u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\u001e\u0010$\u001a\u00020\u000e2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(R!\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\b\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Landroidx/compose/ui/prewarm/PreWarmComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", StrategyConstants.CONTENT, "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "getAccessibilityClassName", "", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "preWarm", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/prewarm/ComposePreWarmType;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class PreWarmComposeView extends AbstractComposeView implements SavedStateRegistryOwner {
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Lifecycle lifecycle;
    private final LifecycleRegistry lifecycleRegistry;
    private final SavedStateRegistry savedStateRegistry;
    private final SavedStateRegistryController savedStateRegistryController;
    private final boolean shouldCreateCompositionOnAttachedToWindow;

    public PreWarmComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PreWarmComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PreWarmComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public PreWarmComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.content = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        LifecycleRegistry createUnsafe = LifecycleRegistry.INSTANCE.createUnsafe(this);
        this.lifecycleRegistry = createUnsafe;
        this.lifecycle = createUnsafe;
        SavedStateRegistryController create = SavedStateRegistryController.INSTANCE.create(this);
        this.savedStateRegistryController = create;
        this.savedStateRegistry = create.getSavedStateRegistry();
    }

    @Override // androidx.compose.p001ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @Override // androidx.compose.p001ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1506645763);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content):ComposePreWarm.kt#v082fj");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1506645763, i2, -1, "androidx.compose.ui.prewarm.PreWarmComposeView.Content (ComposePreWarm.kt:120)");
            }
            Function2 function2 = (Function2) this.content.getValue();
            if (function2 == null) {
                startRestartGroup.startReplaceGroup(-2075618596);
            } else {
                startRestartGroup.startReplaceGroup(-482597435);
                ComposerKt.sourceInformation(startRestartGroup, "121@4342L8");
                function2.invoke(startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.prewarm.PreWarmComposeView$Content$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    PreWarmComposeView.this.Content(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "";
    }

    public final void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        this.content.setValue(content);
    }

    public final void preWarm(ComposePreWarmType type) {
        PreWarmComposeView preWarmComposeView = this;
        ViewTreeLifecycleOwner.set(preWarmComposeView, this);
        ViewTreeSavedStateRegistryOwner.set(preWarmComposeView, this);
        this.savedStateRegistryController.performAttach();
        this.savedStateRegistryController.performRestore(null);
        setParentCompositionContext((CompositionContext) new Recomposer(Dispatchers.getMain()));
        onAttachedToWindow();
        PreWarmComposeView preWarmComposeView2 = this;
        Sequence filter = SequencesKt.filter(ViewGroupKt.getChildren(preWarmComposeView2), new Function1<Object, Boolean>() { // from class: androidx.compose.ui.prewarm.PreWarmComposeView$preWarm$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m1838invoke(Object obj) {
                return Boolean.valueOf(obj instanceof AndroidComposeView);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        while (it.hasNext()) {
            AndroidComposeView.triggerOnAttachedToWindow$default((AndroidComposeView) it.next(), false, 1, null);
        }
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (type != ComposePreWarmType.COMPOSE_ONLY) {
            Sequence filter2 = SequencesKt.filter(ViewGroupKt.getChildren(preWarmComposeView2), new Function1<Object, Boolean>() { // from class: androidx.compose.ui.prewarm.PreWarmComposeView$preWarm$$inlined$filterIsInstance$2
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m1839invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof AndroidComposeView);
                }
            });
            Intrinsics.checkNotNull(filter2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it2 = filter2.iterator();
            while (it2.hasNext()) {
                ((AndroidComposeView) it2.next()).triggerOnMeasure(View.MeasureSpec.makeMeasureSpec(100, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(100, BasicMeasure.EXACTLY));
            }
            Sequence filter3 = SequencesKt.filter(ViewGroupKt.getChildren(preWarmComposeView2), new Function1<Object, Boolean>() { // from class: androidx.compose.ui.prewarm.PreWarmComposeView$preWarm$$inlined$filterIsInstance$3
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m1840invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof AndroidComposeView);
                }
            });
            Intrinsics.checkNotNull(filter3, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it3 = filter3.iterator();
            while (it3.hasNext()) {
                ((AndroidComposeView) it3.next()).triggerOnLayout(true, 0, 0, 100, 100);
            }
        }
        if (type == ComposePreWarmType.ALL) {
            Sequence filter4 = SequencesKt.filter(ViewGroupKt.getChildren(preWarmComposeView2), new Function1<Object, Boolean>() { // from class: androidx.compose.ui.prewarm.PreWarmComposeView$preWarm$$inlined$filterIsInstance$4
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m1841invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof AndroidComposeView);
                }
            });
            Intrinsics.checkNotNull(filter4, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it4 = filter4.iterator();
            while (it4.hasNext()) {
                AndroidComposeView.triggerDraw$default((AndroidComposeView) it4.next(), new FakeCanvas(), false, 2, null);
            }
        }
    }
}
