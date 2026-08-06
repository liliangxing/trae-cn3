package coil3.compose;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.CrossfadePainter;
import coil3.compose.internal.DeferredDispatchCoroutineScope;
import coil3.compose.internal.DeferredDispatchCoroutineScopeKt;
import coil3.compose.internal.ImageOptionsUtilsKt;
import coil3.compose.internal.UtilsKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Precision;
import coil3.size.SizeResolver;
import coil3.target.Target;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0003opqB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010_\u001a\u000207*\u00020`H\u0014J\u0010\u0010a\u001a\u00020N2\u0006\u0010\u0017\u001a\u00020\u0013H\u0014J\u0012\u0010b\u001a\u00020N2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010c\u001a\u000207H\u0016J\b\u0010d\u001a\u000207H\u0002J\b\u0010e\u001a\u000207H\u0016J\b\u0010f\u001a\u000207H\u0016J\u0006\u0010g\u001a\u000207J\u0018\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020NH\u0002J\u0010\u0010l\u001a\u0002072\u0006\u0010Z\u001a\u000201H\u0002J\f\u0010m\u001a\u000201*\u00020nH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001d8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0016\u001a\u0004\u0018\u00010%@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00106\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000207\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\u001a\u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u00020AX\u0080\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\b\u0012\u0004\u0012\u0002070\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010P\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010\u0006R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u0002010UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u0002010V¢\u0006\b\n\u0000\u001a\u0004\b[\u0010XR\u0014\u0010\\\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^¨\u0006r"}, d2 = {"Lcoil3/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "input", "Lcoil3/compose/AsyncImagePainter$Input;", "<init>", "(Lcoil3/compose/AsyncImagePainter$Input;)V", "drawSize", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "_alpha", "", "alphaState", "Landroidx/compose/runtime/MutableFloatState;", StrategyConstants.VALUE, "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "_colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilterState", "Landroidx/compose/runtime/MutableState;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Lkotlinx/coroutines/Job;", "rememberJob", "setRememberJob", "(Lkotlinx/coroutines/Job;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$coil_compose_core_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$coil_compose_core_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getTransform$coil_compose_core_release", "()Lkotlin/jvm/functions/Function1;", "setTransform$coil_compose_core_release", "(Lkotlin/jvm/functions/Function1;)V", "onState", "", "getOnState$coil_compose_core_release", "setOnState$coil_compose_core_release", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_core_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_core_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_core_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_core_release", "(I)V", "I", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "getPreviewHandler$coil_compose_core_release", "()Lcoil3/compose/AsyncImagePreviewHandler;", "setPreviewHandler$coil_compose_core_release", "(Lcoil3/compose/AsyncImagePreviewHandler;)V", "isRemembered", "", "restartSignal", "_input", "get_input$coil_compose_core_release", "()Lcoil3/compose/AsyncImagePainter$Input;", "set_input$coil_compose_core_release", "inputFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getInput", "()Lkotlinx/coroutines/flow/StateFlow;", "_state", StrategyConstants.STATE, "getState", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "applyColorFilter", "onRemembered", "launchJob", "onForgotten", "onAbandoned", "restart", "updateRequest", "Lcoil3/request/ImageRequest;", "request", "isPreview", "updateState", "toState", "Lcoil3/request/ImageResult;", "Input", "Companion", "State", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<State, State> DefaultTransform = new Function1() { // from class: coil3.compose.AsyncImagePainter$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            AsyncImagePainter.State DefaultTransform$lambda$5;
            DefaultTransform$lambda$5 = AsyncImagePainter.DefaultTransform$lambda$5((AsyncImagePainter.State) obj);
            return DefaultTransform$lambda$5;
        }
    };
    private ColorFilter _colorFilter;
    private Input _input;
    private final MutableStateFlow<State> _state;
    private MutableFloatState alphaState;
    private MutableState<ColorFilter> colorFilterState;
    private final StateFlow<Input> input;
    private final MutableStateFlow<Input> inputFlow;
    private boolean isRemembered;
    private Function1<? super State, Unit> onState;
    private AsyncImagePreviewHandler previewHandler;
    private Job rememberJob;
    private final MutableSharedFlow<Unit> restartSignal;
    public CoroutineScope scope;
    private final StateFlow<State> state;
    private final MutableSharedFlow<Size> drawSize = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    /* renamed from: painter$delegate, reason: from kotlin metadata */
    private final MutableState painter = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private float _alpha = 1.0f;
    private Function1<? super State, ? extends State> transform = DefaultTransform;
    private ContentScale contentScale = ContentScale.Companion.getFit();
    private int filterQuality = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();

    /* JADX INFO: Access modifiers changed from: private */
    public static final State DefaultTransform$lambda$5(State state) {
        return state;
    }

    public AsyncImagePainter(Input input) {
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        MutableSharedFlow$default.tryEmit(Unit.INSTANCE);
        this.restartSignal = MutableSharedFlow$default;
        this._input = input;
        MutableStateFlow<Input> MutableStateFlow = StateFlowKt.MutableStateFlow(input);
        this.inputFlow = MutableStateFlow;
        if (ImageOptionsUtilsKt.getUseOptimization(input.getRequest())) {
            this.alphaState = null;
            this.colorFilterState = null;
        } else {
            this.alphaState = PrimitiveSnapshotStateKt.mutableFloatStateOf(this._alpha);
            this.colorFilterState = SnapshotStateKt.mutableStateOf$default(this._colorFilter, (SnapshotMutationPolicy) null, 2, (Object) null);
        }
        this.input = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<State> MutableStateFlow2 = StateFlowKt.MutableStateFlow(State.Empty.INSTANCE);
        this._state = MutableStateFlow2;
        this.state = FlowKt.asStateFlow(MutableStateFlow2);
    }

    private final Painter getPainter() {
        return (Painter) this.painter.getValue();
    }

    private final void setPainter(Painter painter) {
        this.painter.setValue(painter);
    }

    private final float getAlpha() {
        MutableFloatState mutableFloatState;
        ImageRequest request;
        Input input = this._input;
        boolean z = false;
        if (input != null && (request = input.getRequest()) != null && ImageOptionsUtilsKt.getUseOptimization(request)) {
            z = true;
        }
        return (z || (mutableFloatState = this.alphaState) == null) ? this._alpha : mutableFloatState.getFloatValue();
    }

    private final void setAlpha(float f) {
        MutableFloatState mutableFloatState = this.alphaState;
        if (mutableFloatState != null) {
            mutableFloatState.setFloatValue(f);
        }
        this._alpha = f;
    }

    private final ColorFilter getColorFilter() {
        MutableState<ColorFilter> mutableState;
        ColorFilter colorFilter;
        ImageRequest request;
        Input input = this._input;
        boolean z = false;
        if (input != null && (request = input.getRequest()) != null && ImageOptionsUtilsKt.getUseOptimization(request)) {
            z = true;
        }
        return (z || (mutableState = this.colorFilterState) == null || (colorFilter = (ColorFilter) mutableState.getValue()) == null) ? this._colorFilter : colorFilter;
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        MutableState<ColorFilter> mutableState = this.colorFilterState;
        if (mutableState != null) {
            mutableState.setValue(colorFilter);
        }
        this._colorFilter = colorFilter;
    }

    private final void setRememberJob(Job job) {
        Job job2 = this.rememberJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.rememberJob = job;
    }

    public final CoroutineScope getScope$coil_compose_core_release() {
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scope");
        return null;
    }

    public final void setScope$coil_compose_core_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final Function1<State, State> getTransform$coil_compose_core_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_core_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_core_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_core_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    /* renamed from: getContentScale$coil_compose_core_release, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_core_release(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    /* renamed from: getFilterQuality-f-v9h1I$coil_compose_core_release, reason: not valid java name and from getter */
    public final int getFilterQuality() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$coil_compose_core_release, reason: not valid java name */
    public final void m3187setFilterQualityvDHp3xo$coil_compose_core_release(int i) {
        this.filterQuality = i;
    }

    /* renamed from: getPreviewHandler$coil_compose_core_release, reason: from getter */
    public final AsyncImagePreviewHandler getPreviewHandler() {
        return this.previewHandler;
    }

    public final void setPreviewHandler$coil_compose_core_release(AsyncImagePreviewHandler asyncImagePreviewHandler) {
        this.previewHandler = asyncImagePreviewHandler;
    }

    /* renamed from: get_input$coil_compose_core_release, reason: from getter */
    public final Input get_input() {
        return this._input;
    }

    public final void set_input$coil_compose_core_release(Input input) {
        if (Intrinsics.areEqual(this._input, input)) {
            return;
        }
        this._input = input;
        if (input != null) {
            if (ImageOptionsUtilsKt.getUseOptimization(input.getRequest())) {
                this.alphaState = null;
                this.colorFilterState = null;
            } else {
                if (this.alphaState == null) {
                    this.alphaState = PrimitiveSnapshotStateKt.mutableFloatStateOf(this._alpha);
                }
                if (this.colorFilterState == null) {
                    this.colorFilterState = SnapshotStateKt.mutableStateOf$default(this._colorFilter, (SnapshotMutationPolicy) null, 2, (Object) null);
                }
            }
            this.inputFlow.setValue(input);
            if (ImageOptionsUtilsKt.getUseOptimization(input.getRequest())) {
                restart();
                return;
            } else {
                this.restartSignal.tryEmit(Unit.INSTANCE);
                return;
            }
        }
        setRememberJob(null);
    }

    public final StateFlow<Input> getInput() {
        return this.input;
    }

    public final StateFlow<State> getState() {
        return this.state;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m3186getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        return painter != null ? painter.getIntrinsicSize-NH-jbRc() : Size.Companion.getUnspecified-NH-jbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        this.drawSize.tryEmit(Size.box-impl(drawScope.getSize-NH-jbRc()));
        Painter painter = getPainter();
        if (painter != null) {
            painter.draw-x_KDEd0(drawScope, drawScope.getSize-NH-jbRc(), getAlpha(), getColorFilter());
        }
    }

    protected boolean applyAlpha(float alpha) {
        setAlpha(alpha);
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    public void onRemembered() {
        Input input = this._input;
        if (input == null) {
            return;
        }
        if (ImageOptionsUtilsKt.getUseOptimization(input.getRequest())) {
            Painter painter = getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onRemembered();
            }
            launchJob();
            this.isRemembered = true;
            return;
        }
        RememberObserver painter2 = getPainter();
        RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? painter2 : null;
        if (rememberObserver2 != null) {
            rememberObserver2.onRemembered();
        }
        if (this.rememberJob == null) {
            Flow transformLatest = FlowKt.transformLatest(this.restartSignal, new AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1(null, this));
            AsyncImagePreviewHandler asyncImagePreviewHandler = this.previewHandler;
            if (asyncImagePreviewHandler != null) {
                setRememberJob(BuildersKt.launch$default(getScope$coil_compose_core_release(), Dispatchers.getUnconfined(), (CoroutineStart) null, new AsyncImagePainter$onRemembered$1(transformLatest, this, asyncImagePreviewHandler, null), 2, (Object) null));
            } else {
                setRememberJob(BuildersKt.launch$default(getScope$coil_compose_core_release(), UtilsKt.getSafeImmediateMainDispatcher(), (CoroutineStart) null, new AsyncImagePainter$onRemembered$2(transformLatest, this, null), 2, (Object) null));
            }
        }
        this.isRemembered = true;
    }

    private final void launchJob() {
        Input input = this._input;
        if (input == null) {
            return;
        }
        setRememberJob(DeferredDispatchCoroutineScopeKt.launchUndispatched(new DeferredDispatchCoroutineScope(getScope$coil_compose_core_release().getCoroutineContext()), new AsyncImagePainter$launchJob$1(this, input, null)));
    }

    public void onForgotten() {
        setRememberJob(null);
        Painter painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
        this.isRemembered = false;
    }

    public void onAbandoned() {
        setRememberJob(null);
        Painter painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
        this.isRemembered = false;
    }

    public final void restart() {
        Input input = this._input;
        if (input == null) {
            setRememberJob(null);
            return;
        }
        Intrinsics.checkNotNull(input);
        if (ImageOptionsUtilsKt.getUseOptimization(input.getRequest())) {
            if (this.isRemembered) {
                launchJob();
                return;
            }
            return;
        }
        this.restartSignal.tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest updateRequest(final ImageRequest request, boolean isPreview) {
        SizeResolver sizeResolver = request.getSizeResolver();
        if (sizeResolver instanceof DrawScopeSizeResolver) {
            ((DrawScopeSizeResolver) sizeResolver).connect((Flow) this.drawSize);
        }
        ImageRequest.Builder target = ImageRequest.newBuilder$default(request, null, 1, null).target(new Target() { // from class: coil3.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil3.target.Target
            public void onError(Image error) {
            }

            @Override // coil3.target.Target
            public void onSuccess(Image result) {
            }

            @Override // coil3.target.Target
            public void onStart(Image placeholder) {
                this.updateState(new AsyncImagePainter.State.Loading(placeholder != null ? ImagePainter_androidKt.m3194asPainterwIOrVNA(placeholder, ImageRequest.this.getContext(), this.getFilterQuality(), ImageRequest.this.getFetcherCoroutineContext()) : null));
            }
        });
        if (request.getDefined().getSizeResolver() == null) {
            target.size(SizeResolver.ORIGINAL);
        }
        if (request.getDefined().getScale() == null) {
            target.scale(UtilsKt.toScale(this.contentScale));
        }
        if (request.getDefined().getPrecision() == null) {
            target.precision(Precision.INEXACT);
        }
        if (isPreview) {
            target.coroutineContext((CoroutineContext) EmptyCoroutineContext.INSTANCE);
        }
        AsyncImagePainter_androidKt.applyGlobalLifecycle(target);
        return target.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State state) {
        State state2 = (State) this._state.getValue();
        State state3 = (State) this.transform.invoke(state);
        this._state.setValue(state3);
        CrossfadePainter maybeNewCrossfadePainter = AsyncImagePainter_androidKt.maybeNewCrossfadePainter(state2, state3, this.contentScale);
        setPainter(maybeNewCrossfadePainter != null ? maybeNewCrossfadePainter : state3.getPainter());
        if (state2.getPainter() != state3.getPainter()) {
            RememberObserver painter = state2.getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? painter : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Painter painter2 = state3.getPainter();
            RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        Function1<? super State, Unit> function1 = this.onState;
        if (function1 != null) {
            function1.invoke(state3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State toState(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(ImagePainter_androidKt.m3194asPainterwIOrVNA(successResult.getImage(), successResult.getRequest().getContext(), this.filterQuality, getScope$coil_compose_core_release().getCoroutineContext()), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        ErrorResult errorResult = (ErrorResult) imageResult;
        Image image = errorResult.getImage();
        return new State.Error(image != null ? ImagePainter_androidKt.m3194asPainterwIOrVNA(image, errorResult.getRequest().getContext(), this.filterQuality, getScope$coil_compose_core_release().getCoroutineContext()) : null, errorResult);
    }

    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Input;", "", "imageLoader", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/request/ImageRequest;Lcoil3/compose/EqualityDelegate;)V", "getImageLoader", "()Lcoil3/ImageLoader;", "getRequest", "()Lcoil3/request/ImageRequest;", "getModelEqualityDelegate", "()Lcoil3/compose/EqualityDelegate;", "equals", "", "other", "hashCode", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Input {
        public static final int $stable = 0;
        private final ImageLoader imageLoader;
        private final EqualityDelegate modelEqualityDelegate;
        private final ImageRequest request;

        public String toString() {
            return "Input(imageLoader=" + this.imageLoader + ", request=" + this.request + ", modelEqualityDelegate=" + this.modelEqualityDelegate + ')';
        }

        public Input(ImageLoader imageLoader, ImageRequest imageRequest, EqualityDelegate equalityDelegate) {
            this.imageLoader = imageLoader;
            this.request = imageRequest;
            this.modelEqualityDelegate = equalityDelegate;
        }

        public final ImageLoader getImageLoader() {
            return this.imageLoader;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final EqualityDelegate getModelEqualityDelegate() {
            return this.modelEqualityDelegate;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Input) {
                Input input = (Input) other;
                if (Intrinsics.areEqual(this.imageLoader, input.imageLoader) && Intrinsics.areEqual(this.modelEqualityDelegate, input.modelEqualityDelegate) && this.modelEqualityDelegate.equals(this.request, input.request)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.imageLoader.hashCode() * 31) + this.modelEqualityDelegate.hashCode()) * 31) + this.modelEqualityDelegate.hashCode(this.request);
        }
    }

    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Companion;", "", "<init>", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }

    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State;", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Loading", "Success", "Error", "Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State$Success;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface State {
        Painter getPainter();

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH×\u0003J\t\u0010\f\u001a\u00020\rH×\u0001J\t\u0010\u000e\u001a\u00020\u000fH×\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State;", "<init>", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public static final /* data */ class Empty implements State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return null;
            }

            public int hashCode() {
                return -1625786264;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public static final /* data */ class Loading implements State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = loading.painter;
                }
                return loading.copy(painter);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            public final Loading copy(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) other).painter);
            }

            public int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }

            public Loading(Painter painter) {
                this.painter = painter;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Success;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", StrategyConstants.RESULT, "Lcoil3/request/SuccessResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public static final /* data */ class Success implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = success.painter;
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter, successResult);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* renamed from: component2, reason: from getter */
            public final SuccessResult getResult() {
                return this.result;
            }

            public final Success copy(Painter painter, SuccessResult result) {
                return new Success(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }

            public Success(Painter painter, SuccessResult successResult) {
                this.painter = painter;
                this.result = successResult;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", StrategyConstants.RESULT, "Lcoil3/request/ErrorResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/ErrorResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public static final /* data */ class Error implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = error.painter;
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter, errorResult);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* renamed from: component2, reason: from getter */
            public final ErrorResult getResult() {
                return this.result;
            }

            public final Error copy(Painter painter, ErrorResult result) {
                return new Error(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            public int hashCode() {
                Painter painter = this.painter;
                return ((painter == null ? 0 : painter.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }

            public Error(Painter painter, ErrorResult errorResult) {
                this.painter = painter;
                this.result = errorResult;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }
        }
    }
}
