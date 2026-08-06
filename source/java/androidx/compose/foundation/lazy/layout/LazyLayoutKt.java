package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.flag.LocalPausableCompositionInPrefetchEnabledKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyLayout.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MaxItemsToRetainForReuse", "", "LocalLazyLayoutPrefetchObserver", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchObserver;", "getLocalLazyLayoutPrefetchObserver", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutKt {
    private static final ProvidableCompositionLocal<LazyLayoutPrefetchObserver> LocalLazyLayoutPrefetchObserver = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            LazyLayoutPrefetchObserver LocalLazyLayoutPrefetchObserver$lambda$2;
            LocalLazyLayoutPrefetchObserver$lambda$2 = LazyLayoutKt.LocalLazyLayoutPrefetchObserver$lambda$2();
            return LocalLazyLayoutPrefetchObserver$lambda$2;
        }
    });
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyLayout$lambda$0(Function0 function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, Function2 function2, int i, int i2, Composer composer, int i3) {
        LazyLayout(function0, modifier, lazyLayoutPrefetchState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyLayout$lambda$1(Function0 function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy, int i, int i2, Composer composer, int i3) {
        LazyLayout((Function0<? extends LazyLayoutItemProvider>) function0, modifier, lazyLayoutPrefetchState, lazyLayoutMeasurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyLayoutPrefetchObserver LocalLazyLayoutPrefetchObserver$lambda$2() {
        return null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use overload with LazyLayoutMeasurePolicy")
    public static final /* synthetic */ void LazyLayout(final Function0 function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, final Function2 function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2002163445);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayout)N(itemProvider,modifier,prefetchState,measurePolicy)74@3686L89:LazyLayout.kt#wow0x6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(lazyLayoutPrefetchState) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                lazyLayoutPrefetchState = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:74)");
            }
            LazyLayout((Function0<? extends LazyLayoutItemProvider>) function0, modifier, lazyLayoutPrefetchState, new C0350x547bc329(function2), startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LazyLayout$lambda$0;
                    LazyLayout$lambda$0 = LazyLayoutKt.LazyLayout$lambda$0(function0, modifier2, lazyLayoutPrefetchState2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return LazyLayout$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyLayout(final Function0<? extends LazyLayoutItemProvider> function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, final LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2;
        final Modifier modifier3;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1055276397);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayout)N(itemProvider,modifier,prefetchState,measurePolicy)118@6195L34,120@6322L7,123@6440L2465,123@6408L2497:LazyLayout.kt#wow0x6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                i3 |= startRestartGroup.changed(lazyLayoutPrefetchState2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= (i & Fields.TransformOrigin) == 0 ? startRestartGroup.changed(lazyLayoutMeasurePolicy) : startRestartGroup.changedInstance(lazyLayoutMeasurePolicy) ? Fields.CameraDistance : Fields.RotationZ;
                }
                if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    LazyLayoutPrefetchState lazyLayoutPrefetchState4 = i4 != 0 ? null : lazyLayoutPrefetchState2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1055276397, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:117)");
                    }
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, i3 & 14);
                    ProvidableCompositionLocal<Boolean> localPausableCompositionInPrefetchEnabled = LocalPausableCompositionInPrefetchEnabledKt.getLocalPausableCompositionInPrefetchEnabled();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localPausableCompositionInPrefetchEnabled);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Boolean bool = (Boolean) consume;
                    LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.rememberComposableLambda(-933153643, true, new LazyLayoutKt$LazyLayout$2(lazyLayoutPrefetchState4, bool != null ? bool.booleanValue() : ComposeFoundationFlags.isPausableCompositionInPrefetchEnabled, modifier4, lazyLayoutMeasurePolicy, rememberUpdatedState), startRestartGroup, 54), startRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LazyLayout$lambda$1;
                            LazyLayout$lambda$1 = LazyLayoutKt.LazyLayout$lambda$1(function0, modifier3, lazyLayoutPrefetchState3, lazyLayoutMeasurePolicy, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return LazyLayout$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
            if ((i2 & 8) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        if ((i2 & 8) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<LazyLayoutPrefetchObserver> getLocalLazyLayoutPrefetchObserver() {
        return LocalLazyLayoutPrefetchObserver;
    }
}
