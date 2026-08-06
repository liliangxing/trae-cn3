package androidx.compose.p001ui.precompose;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.compose.p001ui.platform.AbstractComposeView;
import androidx.compose.p001ui.platform.AndroidComposeView;
import androidx.compose.p001ui.platform.AndroidViewConfiguration;
import androidx.compose.p001ui.platform.IComposeViewWithSetContent;
import androidx.compose.p001ui.platform.OnAttachStateProvider;
import androidx.compose.p001ui.platform.ViewConfiguration;
import androidx.compose.p001ui.platform.WindowRecomposerPolicy;
import androidx.compose.p001ui.platform.WindowRecomposer_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PreComposeView.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010'\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\u000e2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0017¢\u0006\u0002\u0010*J \u0010+\u001a\u00020\u000e2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u000eH\u0014J\b\u00100\u001a\u00020\u000eH\u0014J\b\u00101\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u000204H\u0016J\u000e\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\u001aJ\u0006\u00108\u001a\u00020\u001aJ\u0006\u00109\u001a\u00020\u001aJ\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u0017H\u0002J>\u0010M\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020H2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\u000eH\u0014J\b\u0010P\u001a\u00020\u000eH\u0004J\b\u0010Q\u001a\u00020\u000eH\u0004J\b\u0010R\u001a\u00020SH\u0002J \u0010T\u001a\u00020\u000e2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0002¢\u0006\u0002\u0010,J\u0006\u0010U\u001a\u00020\u000eJ\u0010\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020XH\u0002R!\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\b\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u00020\u001aX\u0094\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001a\u0010D\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010G\u001a\u00020HX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006Z"}, d2 = {"Landroidx/compose/ui/precompose/PreComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/IComposeViewWithSetContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", StrategyConstants.CONTENT, "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "lifecycleOwnerDelegate", "Landroidx/compose/ui/precompose/LifecycleOwnerDelegate;", "savedStateRegistryOwnerDelegate", "Landroidx/compose/ui/precompose/SavedStateRegistryOwnerDelegate;", "viewModelStoreOwnerDelegate", "Landroidx/compose/ui/precompose/ViewModelStoreOwnerDelegate;", "status", "Landroidx/compose/ui/precompose/PreComposeStatus;", "statusState", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "setShouldCreateCompositionOnAttachedToWindow", "(Z)V", "onAttachStateProvider", "Landroidx/compose/ui/platform/OnAttachStateProvider;", "contentChildAttachStateListener", "Landroid/view/View$OnAttachStateChangeListener;", "attachedContentChild", "Landroid/view/View;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "ProvideValues", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "getAccessibilityClassName", "", "onAttachedToWindow", "onDetachedFromWindow", "installContentChildAttachStateListenerIfNeeded", "uninstallContentChildAttachStateListener", "getHandler", "Landroid/os/Handler;", "replaceContext", "newContext", "isPreComposed", "isDisposed", "isUsed", "updateStatus", "newStatus", "widthMeasureSpec", "getWidthMeasureSpec", "()I", "setWidthMeasureSpec", "(I)V", "heightMeasureSpec", "getHeightMeasureSpec", "setHeightMeasureSpec", "enableHardwareAccelerated", "getEnableHardwareAccelerated", "setEnableHardwareAccelerated", "phase", "Landroidx/compose/ui/precompose/PreComposePhase;", "getPhase", "()Landroidx/compose/ui/precompose/PreComposePhase;", "setPhase", "(Landroidx/compose/ui/precompose/PreComposePhase;)V", "precompose", "(IIZLandroidx/compose/ui/precompose/PreComposePhase;Lkotlin/jvm/functions/Function2;)V", "triggerPhases", "triggerLayout", "triggerDraw", "getAndroidComposeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "setupEnvironment", "dispose", "log", NotificationCompat.CATEGORY_MESSAGE, "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class PreComposeView extends AbstractComposeView implements IComposeViewWithSetContent {
    public static final String TAG = "PreComposeView";
    private View attachedContentChild;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private View.OnAttachStateChangeListener contentChildAttachStateListener;
    private boolean enableHardwareAccelerated;
    private int heightMeasureSpec;
    private final LifecycleOwnerDelegate lifecycleOwnerDelegate;
    private final OnAttachStateProvider onAttachStateProvider;
    private PreComposePhase phase;
    private final SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private PreComposeStatus status;
    private final MutableState<PreComposeStatus> statusState;
    private final ViewModelStoreOwnerDelegate viewModelStoreOwnerDelegate;
    private int widthMeasureSpec;
    public static final int $stable = 8;

    public PreComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PreComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    protected static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    public /* synthetic */ PreComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public PreComposeView(Context context, AttributeSet attributeSet, int i) {
        super(new PreComposeContext(context), attributeSet, i);
        this.content = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        LifecycleOwnerDelegate lifecycleOwnerDelegate = new LifecycleOwnerDelegate();
        this.lifecycleOwnerDelegate = lifecycleOwnerDelegate;
        this.savedStateRegistryOwnerDelegate = new SavedStateRegistryOwnerDelegate(lifecycleOwnerDelegate);
        this.viewModelStoreOwnerDelegate = new ViewModelStoreOwnerDelegate();
        PreComposeStatus preComposeStatus = PreComposeStatus.INIT;
        this.status = preComposeStatus;
        this.statusState = SnapshotStateKt.mutableStateOf$default(preComposeStatus, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onAttachStateProvider = new OnAttachStateProvider();
        this.phase = PreComposePhase.DRAW;
    }

    @Override // androidx.compose.p001ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    protected void setShouldCreateCompositionOnAttachedToWindow(boolean z) {
        this.shouldCreateCompositionOnAttachedToWindow = z;
    }

    @Override // androidx.compose.p001ui.platform.AbstractComposeView
    public void Content(Composer composer, int i) {
        composer.startReplaceGroup(1487086865);
        ComposerKt.sourceInformation(composer, "C(Content)92@3293L179,92@3279L193:PreComposeView.kt#hnx0ug");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1487086865, i, -1, "androidx.compose.ui.precompose.PreComposeView.Content (PreComposeView.kt:91)");
        }
        ProvideValues((Function2) ComposableLambdaKt.rememberComposableLambda(-1425823975, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.precompose.PreComposeView$Content$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                MutableState mutableState;
                ComposerKt.sourceInformation(composer2, "C95@3407L55,93@3307L155:PreComposeView.kt#hnx0ug");
                if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1425823975, i2, -1, "androidx.compose.ui.precompose.PreComposeView.Content.<anonymous> (PreComposeView.kt:93)");
                }
                ProvidableCompositionLocal<State<PreComposeStatus>> localPreComposeStatus = PreComposeViewKt.getLocalPreComposeStatus();
                mutableState = PreComposeView.this.statusState;
                ProvidedValue provides = localPreComposeStatus.provides(mutableState);
                final PreComposeView preComposeView = PreComposeView.this;
                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1351054375, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.precompose.PreComposeView$Content$1.1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        MutableState mutableState2;
                        ComposerKt.sourceInformation(composer3, "C:PreComposeView.kt#hnx0ug");
                        if (composer3.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1351054375, i3, -1, "androidx.compose.ui.precompose.PreComposeView.Content.<anonymous>.<anonymous> (PreComposeView.kt:96)");
                            }
                            mutableState2 = PreComposeView.this.content;
                            Function2 function2 = (Function2) mutableState2.getValue();
                            if (function2 == null) {
                                composer3.startReplaceGroup(-1122321824);
                            } else {
                                composer3.startReplaceGroup(-1283129919);
                                ComposerKt.sourceInformation(composer3, "96@3440L8");
                                function2.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ((i << 3) & 112) | 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    public void ProvideValues(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceGroup(273650764);
        ComposerKt.sourceInformation(composer, "C(ProvideValues)103@3566L9:PreComposeView.kt#hnx0ug");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(273650764, i, -1, "androidx.compose.ui.precompose.PreComposeView.ProvideValues (PreComposeView.kt:102)");
        }
        function2.invoke(composer, Integer.valueOf(i & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        setShouldCreateCompositionOnAttachedToWindow(true);
        this.content.setValue(content);
        if (isAttachedToWindow()) {
            createComposition();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p001ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ViewModelStoreOwner viewModelStoreOwner;
        LifecycleOwner lifecycleOwner;
        super.onAttachedToWindow();
        updateStatus(PreComposeStatus.USED);
        log("onAttachedToWindow, bind real LifecycleOwner");
        Object parent = getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null && (lifecycleOwner = ViewTreeLifecycleOwner.get(view)) != null) {
            this.lifecycleOwnerDelegate.bindRealLifecycleOwner(lifecycleOwner);
        }
        Object parent2 = getParent();
        View view2 = parent2 instanceof View ? (View) parent2 : null;
        if (view2 != null && (viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(view2)) != null) {
            this.viewModelStoreOwnerDelegate.bindRealViewModelStore(viewModelStoreOwner.get_viewModelStore());
        }
        installContentChildAttachStateListenerIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uninstallContentChildAttachStateListener();
    }

    private final void installContentChildAttachStateListenerIfNeeded() {
        View contentChild = WindowRecomposer_androidKt.getContentChild(this);
        View view = this.attachedContentChild;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.contentChildAttachStateListener;
        if (view != contentChild || onAttachStateChangeListener == null) {
            uninstallContentChildAttachStateListener();
            View.OnAttachStateChangeListener onAttachStateChangeListener2 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.precompose.PreComposeView$installContentChildAttachStateListenerIfNeeded$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    OnAttachStateProvider onAttachStateProvider;
                    onAttachStateProvider = PreComposeView.this.onAttachStateProvider;
                    onAttachStateProvider.onViewAttachedToWindow(v);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    OnAttachStateProvider onAttachStateProvider;
                    View view2;
                    onAttachStateProvider = PreComposeView.this.onAttachStateProvider;
                    onAttachStateProvider.onViewDetachedFromWindow(v);
                    v.removeOnAttachStateChangeListener(this);
                    view2 = PreComposeView.this.attachedContentChild;
                    if (view2 == v) {
                        PreComposeView.this.attachedContentChild = null;
                        PreComposeView.this.contentChildAttachStateListener = null;
                    }
                }
            };
            contentChild.addOnAttachStateChangeListener(onAttachStateChangeListener2);
            this.attachedContentChild = contentChild;
            this.contentChildAttachStateListener = onAttachStateChangeListener2;
        }
    }

    private final void uninstallContentChildAttachStateListener() {
        View view = this.attachedContentChild;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.contentChildAttachStateListener;
        if (view != null && onAttachStateChangeListener != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.attachedContentChild = null;
        this.contentChildAttachStateListener = null;
    }

    @Override // android.view.View
    public Handler getHandler() {
        Handler handler = super.getHandler();
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void replaceContext(Context newContext) {
        log("replace context");
        Context context = getContext();
        PreComposeContext preComposeContext = context instanceof PreComposeContext ? (PreComposeContext) context : null;
        if (preComposeContext != null) {
            preComposeContext.replaceContext(newContext);
        }
        ViewConfiguration viewConfiguration = getAndroidComposeView().getViewConfiguration();
        Intrinsics.checkNotNull(viewConfiguration, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidViewConfiguration");
        ((AndroidViewConfiguration) viewConfiguration).replaceViewConfiguration(android.view.ViewConfiguration.get(getContext()));
    }

    public final boolean isPreComposed() {
        return this.status == PreComposeStatus.PRECOMPOSED;
    }

    public final boolean isDisposed() {
        return this.status == PreComposeStatus.DISPOSED;
    }

    public final boolean isUsed() {
        return this.status == PreComposeStatus.USED;
    }

    private final void updateStatus(PreComposeStatus newStatus) {
        this.status = newStatus;
        getAndroidComposeView().updatePrecomposeStatus(newStatus);
        this.statusState.setValue(newStatus);
    }

    protected final int getWidthMeasureSpec() {
        return this.widthMeasureSpec;
    }

    protected final void setWidthMeasureSpec(int i) {
        this.widthMeasureSpec = i;
    }

    protected final int getHeightMeasureSpec() {
        return this.heightMeasureSpec;
    }

    protected final void setHeightMeasureSpec(int i) {
        this.heightMeasureSpec = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getEnableHardwareAccelerated() {
        return this.enableHardwareAccelerated;
    }

    protected final void setEnableHardwareAccelerated(boolean z) {
        this.enableHardwareAccelerated = z;
    }

    protected final PreComposePhase getPhase() {
        return this.phase;
    }

    protected final void setPhase(PreComposePhase preComposePhase) {
        this.phase = preComposePhase;
    }

    public final void precompose(int widthMeasureSpec, int heightMeasureSpec, boolean enableHardwareAccelerated, PreComposePhase phase, Function2<? super Composer, ? super Integer, Unit> content) {
        PreComposeStatus preComposeStatus = PreComposeStatus.INIT;
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
        this.enableHardwareAccelerated = enableHardwareAccelerated;
        this.phase = phase;
        log("start prcompose");
        setupEnvironment(content);
        createComposition();
        updateStatus(PreComposeStatus.PRECOMPOSED);
        AndroidComposeView androidComposeView = getAndroidComposeView();
        androidComposeView.setEnableHardwareAcceleratedByPreCompose(enableHardwareAccelerated);
        androidComposeView.triggerOnAttachedToWindow(false);
        this.lifecycleOwnerDelegate.getLifecycle().handleLifecycleEvent(Lifecycle.Event.ON_START);
        triggerPhases();
    }

    protected void triggerPhases() {
        triggerLayout();
        triggerDraw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void triggerLayout() {
        if (this.phase.compareTo(PreComposePhase.COMPOSE) > 0) {
            AndroidComposeView androidComposeView = getAndroidComposeView();
            androidComposeView.triggerOnMeasure(this.widthMeasureSpec, this.heightMeasureSpec);
            androidComposeView.triggerOnLayout(true, 0, 0, androidComposeView.getMeasuredWidth(), androidComposeView.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void triggerDraw() {
        if (this.phase == PreComposePhase.DRAW) {
            final AndroidComposeView androidComposeView = getAndroidComposeView();
            androidComposeView.setPrecomposeInvalidateCallback(new Function0<Unit>() { // from class: androidx.compose.ui.precompose.PreComposeView$triggerDraw$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1834invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1834invoke() {
                    AndroidComposeView.this.triggerDraw(new FakeCanvas(this.getEnableHardwareAccelerated()), true);
                }
            });
            AndroidComposeView.triggerDraw$default(androidComposeView, new FakeCanvas(this.enableHardwareAccelerated), false, 2, null);
        }
    }

    private final AndroidComposeView getAndroidComposeView() {
        Sequence filter = SequencesKt.filter(ViewGroupKt.getChildren(this), new Function1<Object, Boolean>() { // from class: androidx.compose.ui.precompose.PreComposeView$getAndroidComposeView$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m1833invoke(Object obj) {
                return Boolean.valueOf(obj instanceof AndroidComposeView);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        AndroidComposeView androidComposeView = (AndroidComposeView) SequencesKt.firstOrNull(filter);
        if (androidComposeView != null) {
            return androidComposeView;
        }
        throw new IllegalStateException("No AndroidComposeView found".toString());
    }

    private final void setupEnvironment(Function2<? super Composer, ? super Integer, Unit> content) {
        PreComposeView preComposeView = this;
        ViewTreeLifecycleOwner.set(preComposeView, this.lifecycleOwnerDelegate);
        ViewTreeSavedStateRegistryOwner.set(preComposeView, this.savedStateRegistryOwnerDelegate);
        SavedStateRegistryController savedStateRegistryController = this.savedStateRegistryOwnerDelegate.getSavedStateRegistryController();
        savedStateRegistryController.performAttach();
        savedStateRegistryController.performRestore(null);
        ViewTreeViewModelStoreOwner.set(preComposeView, this.viewModelStoreOwnerDelegate);
        setParentCompositionContext((CompositionContext) WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(preComposeView, this.onAttachStateProvider));
        this.content.setValue(content);
    }

    public final void dispose() {
        PreComposeStatus preComposeStatus = PreComposeStatus.PRECOMPOSED;
        log("dispose");
        updateStatus(PreComposeStatus.DISPOSED);
        this.lifecycleOwnerDelegate.getLifecycle().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    private final void log(String msg) {
        Log.d(TAG, msg);
    }
}
