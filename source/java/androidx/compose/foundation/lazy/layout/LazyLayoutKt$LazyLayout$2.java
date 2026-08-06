package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.SubcomposeLayoutKt;
import androidx.compose.p002ui.layout.SubcomposeLayoutState;
import androidx.compose.p002ui.layout.SubcomposeMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.precompose.Disposable;
import androidx.compose.ui.precompose.PausableSubPreComposeController;
import androidx.compose.ui.precompose.PausableSubPreComposeControllerKt;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayout.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutKt$LazyLayout$2 implements Function3<SaveableStateHolder, Composer, Integer, Unit> {
    final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;
    final /* synthetic */ boolean $isPausableCompositionInPrefetchEnabled;
    final /* synthetic */ LazyLayoutMeasurePolicy $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyLayoutKt$LazyLayout$2(LazyLayoutPrefetchState lazyLayoutPrefetchState, boolean z, Modifier modifier, LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy, State<? extends Function0<? extends LazyLayoutItemProvider>> state) {
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$isPausableCompositionInPrefetchEnabled = z;
        this.$modifier = modifier;
        this.$measurePolicy = lazyLayoutMeasurePolicy;
        this.$currentItemProvider = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SaveableStateHolder saveableStateHolder, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(saveableStateHolder)124@6498L114,127@6649L101,146@7573L266,143@7446L404,154@7914L7,155@7953L946,155@7930L969:LazyLayout.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-933153643, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:124)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 887515911, "CC(remember):LazyLayout.kt#9igjgp");
        final State<Function0<LazyLayoutItemProvider>> state = this.$currentItemProvider;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyLayoutItemContentFactory(saveableStateHolder, new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$$ExternalSyntheticLambda0
                public final Object invoke() {
                    LazyLayoutItemProvider invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = LazyLayoutKt$LazyLayout$2.invoke$lambda$1$lambda$0(State.this);
                    return invoke$lambda$1$lambda$0;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 887520730, "CC(remember):LazyLayout.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
            composer.updateRememberedValue(rememberedValue2);
        }
        final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (this.$prefetchState != null) {
            composer.startReplaceGroup(1743491779);
            ComposerKt.sourceInformation(composer, "132@6982L444,132@6897L529");
            PrefetchScheduler prefetchScheduler = this.$prefetchState.getPrefetchScheduler();
            if (prefetchScheduler == null) {
                composer.startReplaceGroup(887527095);
                ComposerKt.sourceInformation(composer, "131@6850L34");
                prefetchScheduler = PrefetchScheduler_androidKt.rememberDefaultPrefetchScheduler(composer, 0);
            } else {
                composer.startReplaceGroup(887526010);
            }
            composer.endReplaceGroup();
            final PrefetchScheduler prefetchScheduler2 = prefetchScheduler;
            Object[] objArr = {this.$prefetchState, lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler2};
            ComposerKt.sourceInformationMarkerStart(composer, 887531729, "CC(remember):LazyLayout.kt#9igjgp");
            boolean changed = composer.changed(this.$prefetchState) | composer.changedInstance(lazyLayoutItemContentFactory) | composer.changedInstance(subcomposeLayoutState) | composer.changedInstance(prefetchScheduler2) | composer.changed(this.$isPausableCompositionInPrefetchEnabled);
            final LazyLayoutPrefetchState lazyLayoutPrefetchState = this.$prefetchState;
            final boolean z = this.$isPausableCompositionInPrefetchEnabled;
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult invoke$lambda$5$lambda$4;
                        invoke$lambda$5$lambda$4 = LazyLayoutKt$LazyLayout$2.invoke$lambda$5$lambda$4(LazyLayoutPrefetchState.this, lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler2, z, (DisposableEffectScope) obj2);
                        return invoke$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(obj);
                rememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(objArr, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1744116429);
            composer.endReplaceGroup();
        }
        Modifier traversablePrefetchState = LazyLayoutPrefetchStateKt.traversablePrefetchState(this.$modifier, this.$prefetchState);
        ComposerKt.sourceInformationMarkerStart(composer, 887550463, "CC(remember):LazyLayout.kt#9igjgp");
        boolean changed2 = composer.changed(lazyLayoutItemContentFactory) | composer.changed(this.$measurePolicy);
        final LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = this.$measurePolicy;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2, Object obj3) {
                    MeasureResult invoke$lambda$8$lambda$7;
                    invoke$lambda$8$lambda$7 = LazyLayoutKt$LazyLayout$2.invoke$lambda$8$lambda$7(LazyLayoutItemContentFactory.this, lazyLayoutMeasurePolicy, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                    return invoke$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, traversablePrefetchState, (Function2) rememberedValue4, composer, SubcomposeLayoutState.$stable, 0);
        ProvidableCompositionLocal localPausableSubPreComposeController = PausableSubPreComposeControllerKt.getLocalPausableSubPreComposeController();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localPausableSubPreComposeController);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final PausableSubPreComposeController pausableSubPreComposeController = (PausableSubPreComposeController) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 887563303, "CC(remember):LazyLayout.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(pausableSubPreComposeController) | composer.changed(this.$isPausableCompositionInPrefetchEnabled) | composer.changedInstance(lazyLayoutItemContentFactory) | composer.changed(this.$prefetchState);
        final boolean z2 = this.$isPausableCompositionInPrefetchEnabled;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = this.$prefetchState;
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2) {
                    DisposableEffectResult invoke$lambda$14$lambda$13;
                    invoke$lambda$14$lambda$13 = LazyLayoutKt$LazyLayout$2.invoke$lambda$14$lambda$13(pausableSubPreComposeController, z2, lazyLayoutItemContentFactory, lazyLayoutPrefetchState2, (DisposableEffectScope) obj2);
                    return invoke$lambda$14$lambda$13;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyLayoutItemProvider invoke$lambda$1$lambda$0(State state) {
        return (LazyLayoutItemProvider) ((Function0) state.getValue()).invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$5$lambda$4(final LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler, boolean z, DisposableEffectScope disposableEffectScope) {
        lazyLayoutPrefetchState.setPrefetchHandleProvider$foundation_release(new PrefetchHandleProvider(lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler, z));
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$invoke$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                PrefetchHandleProvider prefetchHandleProvider = LazyLayoutPrefetchState.this.getPrefetchHandleProvider();
                if (prefetchHandleProvider != null) {
                    prefetchHandleProvider.onDisposed();
                }
                LazyLayoutPrefetchState.this.setPrefetchHandleProvider$foundation_release(null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult invoke$lambda$8$lambda$7(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy, SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return lazyLayoutMeasurePolicy.mo1198measure0kLqBqw(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), constraints.unbox-impl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$14$lambda$13(final PausableSubPreComposeController pausableSubPreComposeController, boolean z, final LazyLayoutItemContentFactory lazyLayoutItemContentFactory, final LazyLayoutPrefetchState lazyLayoutPrefetchState, DisposableEffectScope disposableEffectScope) {
        if (!(pausableSubPreComposeController == null || z)) {
            throw new IllegalArgumentException("PausableCompositionInPrefetch must be enabled when using PausablePreComposeView".toString());
        }
        final Disposable registerSubPreComposeTask = pausableSubPreComposeController != null ? pausableSubPreComposeController.registerSubPreComposeTask(new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$$ExternalSyntheticLambda4
            public final Object invoke() {
                List invoke$lambda$14$lambda$13$lambda$11;
                invoke$lambda$14$lambda$13$lambda$11 = LazyLayoutKt$LazyLayout$2.invoke$lambda$14$lambda$13$lambda$11(LazyLayoutItemContentFactory.this, pausableSubPreComposeController, lazyLayoutPrefetchState);
                return invoke$lambda$14$lambda$13$lambda$11;
            }
        }) : null;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$invoke$lambda$14$lambda$13$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Disposable disposable = registerSubPreComposeTask;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invoke$lambda$14$lambda$13$lambda$11(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, PausableSubPreComposeController pausableSubPreComposeController, final LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        int min;
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.getItemProvider().invoke();
        if (pausableSubPreComposeController.getPrecomposeCount() == -1) {
            min = lazyLayoutItemProvider.getItemCount();
        } else {
            min = Math.min(lazyLayoutItemProvider.getItemCount(), pausableSubPreComposeController.getPrecomposeCount());
        }
        Iterable until = RangesKt.until(0, min);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        IntIterator it = until.iterator();
        while (it.hasNext()) {
            final int nextInt = it.nextInt();
            arrayList.add(new PausableSubPreComposeController.PausableSubPreComposeTask() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$3$1$disposable$1$1$1
                public Object await(Continuation<? super Unit> continuation) {
                    LazyLayoutPrefetchState.PrefetchHandle schedulePrecomposition;
                    LazyLayoutPrefetchState lazyLayoutPrefetchState2 = LazyLayoutPrefetchState.this;
                    if (lazyLayoutPrefetchState2 == null || (schedulePrecomposition = lazyLayoutPrefetchState2.schedulePrecomposition(nextInt)) == null) {
                        return Unit.INSTANCE;
                    }
                    Object await = schedulePrecomposition.await(continuation);
                    return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
                }
            });
        }
        return arrayList;
    }
}
