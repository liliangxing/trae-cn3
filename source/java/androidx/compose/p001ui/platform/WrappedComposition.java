package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.p001ui.platform.AndroidComposeView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionServiceKey;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Wrapper.android.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u001b\u001a\u00020\u00162\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u0017H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J#\u0010(\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0+H\u0016¢\u0006\u0002\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010¨\u0006-"}, d2 = {"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/compose/runtime/CompositionServices;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "original", "pausableComposition", "", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;Z)V", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "getPausableComposition", "()Z", "disposed", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "setContent", StrategyConstants.CONTENT, "(Lkotlin/jvm/functions/Function2;)V", "getPausedComposition", "dispose", "hasInvalidations", "getHasInvalidations", "isDisposed", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "getCompositionService", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WrappedComposition implements Composition, LifecycleEventObserver, CompositionServices {
    public static final int $stable = 8;
    private Lifecycle addedToLifecycle;
    private boolean disposed;
    private Function2<? super Composer, ? super Integer, Unit> lastContent;
    private final Composition original;
    private final AndroidComposeView owner;
    private final boolean pausableComposition;
    private PausedComposition pausedComposition;

    public WrappedComposition(AndroidComposeView androidComposeView, Composition composition, boolean z) {
        this.owner = androidComposeView;
        this.original = composition;
        this.pausableComposition = z;
        this.lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m1716getLambda$1759434350$ui_release();
    }

    public /* synthetic */ WrappedComposition(AndroidComposeView androidComposeView, Composition composition, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidComposeView, composition, (i & 4) != 0 ? false : z);
    }

    public final Composition getOriginal() {
        return this.original;
    }

    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    public final boolean getPausableComposition() {
        return this.pausableComposition;
    }

    public void setContent(final Function2<? super Composer, ? super Integer, Unit> content) {
        this.owner.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.ViewTreeOwners, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AndroidComposeView.ViewTreeOwners) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                boolean z;
                Lifecycle lifecycle;
                z = WrappedComposition.this.disposed;
                if (z) {
                    return;
                }
                Lifecycle lifecycle2 = viewTreeOwners.getLifecycleOwner().getLifecycle();
                WrappedComposition.this.lastContent = content;
                lifecycle = WrappedComposition.this.addedToLifecycle;
                if (lifecycle == null) {
                    WrappedComposition.this.addedToLifecycle = lifecycle2;
                    lifecycle2.addObserver(WrappedComposition.this);
                    return;
                }
                if (lifecycle2.getState().isAtLeast(Lifecycle.State.CREATED)) {
                    final WrappedComposition wrappedComposition = WrappedComposition.this;
                    final Function2<Composer, Integer, Unit> function2 = content;
                    Function2 composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-549120724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C146@6473L47,146@6451L69,147@6567L48,147@6545L70,149@6714L103,149@6641L176:Wrapper.android.kt#itgzvw");
                            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-549120724, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            Object tag = WrappedComposition.this.getOwner().getTag(R.id.inspection_slot_table_set);
                            Set set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = WrappedComposition.this.getOwner().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.getCompositionData());
                                composer.collectParameterInformation();
                            }
                            AndroidComposeView owner = WrappedComposition.this.getOwner();
                            ComposerKt.sourceInformationMarkerStart(composer, 575987163, "CC(remember):Wrapper.android.kt#9igjgp");
                            boolean changedInstance = composer.changedInstance(WrappedComposition.this);
                            WrappedComposition wrappedComposition2 = WrappedComposition.this;
                            WrappedComposition$setContent$1$lambda$1$1$1 rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new WrappedComposition$setContent$1$lambda$1$1$1(wrappedComposition2, null);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            EffectsKt.LaunchedEffect(owner, (Function2) rememberedValue, composer, 0);
                            AndroidComposeView owner2 = WrappedComposition.this.getOwner();
                            ComposerKt.sourceInformationMarkerStart(composer, 575990172, "CC(remember):Wrapper.android.kt#9igjgp");
                            boolean changedInstance2 = composer.changedInstance(WrappedComposition.this);
                            WrappedComposition wrappedComposition3 = WrappedComposition.this;
                            WrappedComposition$setContent$1$lambda$1$2$1 rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new WrappedComposition$setContent$1$lambda$1$2$1(wrappedComposition3, null);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            EffectsKt.LaunchedEffect(owner2, (Function2) rememberedValue2, composer, 0);
                            ProvidedValue provides = InspectionTablesKt.getLocalInspectionTables().provides(set);
                            final WrappedComposition wrappedComposition4 = WrappedComposition.this;
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(585295980, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1$lambda$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i2) {
                                    ComposerKt.sourceInformation(composer2, "C150@6744L47:Wrapper.android.kt#itgzvw");
                                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(585295980, i2, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:150)");
                                    }
                                    AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(WrappedComposition.this.getOwner(), function22, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer, 54), composer, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    if (WrappedComposition.this.getPausableComposition() && (WrappedComposition.this.getOriginal() instanceof PausableComposition)) {
                        WrappedComposition wrappedComposition2 = WrappedComposition.this;
                        wrappedComposition2.pausedComposition = wrappedComposition2.getOriginal().setPausableContent(composableLambdaInstance);
                    } else {
                        WrappedComposition.this.getOriginal().setContent(composableLambdaInstance);
                    }
                }
            }
        });
    }

    public final PausedComposition getPausedComposition() {
        return this.pausedComposition;
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        CompositionServices compositionServices = this.original;
        CompositionServices compositionServices2 = compositionServices instanceof CompositionServices ? compositionServices : null;
        if (compositionServices2 != null) {
            return (T) compositionServices2.getCompositionService(key);
        }
        return null;
    }
}
