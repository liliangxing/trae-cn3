package androidx.compose.p001ui.precompose;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.compose.p001ui.node.WeakReference;
import androidx.compose.p001ui.platform.WrappedComposition;
import androidx.compose.p001ui.util.AndroidTrace_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.flag.LocalPausableCompositionInPrefetchEnabledKt;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: PausablePreComposeView.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u00020EH\u0016J\b\u0010G\u001a\u00020-H\u0002J\u0010\u0010H\u001a\u00020E2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010I\u001a\u00020EH\u0002J\u000e\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020-J\u000e\u0010L\u001a\u00020E2\u0006\u0010K\u001a\u00020-J\u0018\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020-H\u0002J\u0006\u0010P\u001a\u00020EJ\u0010\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020-H\u0016J \u0010S\u001a\u00020E2\u0011\u0010T\u001a\r\u0012\u0004\u0012\u00020E0U¢\u0006\u0002\bVH\u0017¢\u0006\u0002\u0010WJ \u0010X\u001a\u00020E2\u0011\u0010T\u001a\r\u0012\u0004\u0012\u00020E0U¢\u0006\u0002\bVH\u0016¢\u0006\u0002\u0010YJ\u0010\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\\H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u001a\u00102\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u001bR\u001a\u0010<\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\u000e\u0010?\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n B*\u0004\u0018\u00010A0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Landroidx/compose/ui/precompose/PausablePreComposeView;", "Landroidx/compose/ui/precompose/PreComposeView;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "enablePreSubCompose", "", "subPrecomposeCount", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/util/AttributeSet;IZI)V", "getEnablePreSubCompose", "()Z", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "enablePausableComposition", "getEnablePausableComposition", "setEnablePausableComposition", "(Z)V", "pausableSubPreComposeController", "Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "getPausableSubPreComposeController", "()Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "setPausableSubPreComposeController", "(Landroidx/compose/ui/precompose/PausableSubPreComposeController;)V", "currentView", "Landroidx/compose/ui/node/WeakReference;", "handler", "Landroid/os/Handler;", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "getPausedComposition", "()Landroidx/compose/runtime/PausedComposition;", "setPausedComposition", "(Landroidx/compose/runtime/PausedComposition;)V", "availableTimeNanos", "", "elapsedTimeNanos", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "resumeTimeNanos", "getResumeTimeNanos", "()J", "setResumeTimeNanos", "(J)V", "pauseTimeNanos", "getPauseTimeNanos", "setPauseTimeNanos", "isFrameIdle", "setFrameIdle", "nextFrameTimeNs", "getNextFrameTimeNs", "setNextFrameTimeNs", "frameIntervalNs", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "frameStartTimeNanos", "triggerPhases", "", "run", "calculateFrameIntervalIfNeeded", "resetAvailableTimeTo", "updateElapsedAndAvailableTime", "saveResumeTimeNanos", "timeNanos", "savePauseTimeNanos", "calculateAverageTime", "new", "current", "completeImmediately", "doFrame", "frameTimeNanos", "ProvideValues", StrategyConstants.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "log", NotificationCompat.CATEGORY_MESSAGE, "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PausablePreComposeView extends PreComposeView implements Runnable, Choreographer.FrameCallback, CoroutineScope {
    public static final int $stable = 8;
    private long availableTimeNanos;
    private final Choreographer choreographer;
    private final CoroutineContext coroutineContext;
    private final WeakReference<View> currentView;
    private long elapsedTimeNanos;
    private boolean enablePausableComposition;
    private final boolean enablePreSubCompose;
    private long frameIntervalNs;
    private long frameStartTimeNanos;
    private final Handler handler;
    private boolean isFrameIdle;
    private long nextFrameTimeNs;
    private PausableSubPreComposeController pausableSubPreComposeController;
    private long pauseTimeNanos;
    public PausedComposition pausedComposition;
    private long resumeTimeNanos;
    private long startTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean completeImmediately$lambda$2() {
        return false;
    }

    public /* synthetic */ PausablePreComposeView(Context context, View view, AttributeSet attributeSet, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : view, (i3 & 4) == 0 ? attributeSet : null, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? z : false, (i3 & 32) != 0 ? -1 : i2);
    }

    public final boolean getEnablePreSubCompose() {
        return this.enablePreSubCompose;
    }

    public PausablePreComposeView(Context context, View view, AttributeSet attributeSet, int i, boolean z, int i2) {
        super(context, attributeSet, i);
        this.enablePreSubCompose = z;
        this.coroutineContext = JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate());
        this.enablePausableComposition = true;
        this.pausableSubPreComposeController = z ? new PausableSubPreComposeController(i2) : null;
        this.currentView = view != null ? new WeakReference<>(view) : null;
        this.handler = new Handler(Looper.getMainLooper());
        this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        this.choreographer = Choreographer.getInstance();
        this.frameIntervalNs = calculateFrameIntervalIfNeeded();
        log("frameIntervalNs = " + this.frameIntervalNs);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.p001ui.platform.AbstractComposeView
    protected boolean getEnablePausableComposition() {
        return this.enablePausableComposition;
    }

    protected void setEnablePausableComposition(boolean z) {
        this.enablePausableComposition = z;
    }

    public final PausableSubPreComposeController getPausableSubPreComposeController() {
        return this.pausableSubPreComposeController;
    }

    public final void setPausableSubPreComposeController(PausableSubPreComposeController pausableSubPreComposeController) {
        this.pausableSubPreComposeController = pausableSubPreComposeController;
    }

    public final PausedComposition getPausedComposition() {
        PausedComposition pausedComposition = this.pausedComposition;
        if (pausedComposition != null) {
            return pausedComposition;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pausedComposition");
        return null;
    }

    public final void setPausedComposition(PausedComposition pausedComposition) {
        this.pausedComposition = pausedComposition;
    }

    public final long getResumeTimeNanos() {
        return this.resumeTimeNanos;
    }

    public final void setResumeTimeNanos(long j) {
        this.resumeTimeNanos = j;
    }

    public final long getPauseTimeNanos() {
        return this.pauseTimeNanos;
    }

    public final void setPauseTimeNanos(long j) {
        this.pauseTimeNanos = j;
    }

    /* renamed from: isFrameIdle, reason: from getter */
    public final boolean getIsFrameIdle() {
        return this.isFrameIdle;
    }

    public final void setFrameIdle(boolean z) {
        this.isFrameIdle = z;
    }

    public final long getNextFrameTimeNs() {
        return this.nextFrameTimeNs;
    }

    public final void setNextFrameTimeNs(long j) {
        this.nextFrameTimeNs = j;
    }

    @Override // androidx.compose.p001ui.precompose.PreComposeView
    protected void triggerPhases() {
        PausedComposition pausedComposition;
        Composition composition = getComposition();
        WrappedComposition wrappedComposition = composition instanceof WrappedComposition ? (WrappedComposition) composition : null;
        if (wrappedComposition == null || (pausedComposition = wrappedComposition.getPausedComposition()) == null) {
            throw new IllegalStateException("No PausedComposition found".toString());
        }
        setPausedComposition(pausedComposition);
        this.handler.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        if (isDisposed() || getPausedComposition().isCancelled() || getPausedComposition().isApplied()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        WeakReference<View> weakReference = this.currentView;
        long nanos = timeUnit.toNanos((weakReference == null || (view = (View) weakReference.get()) == null) ? -1L : view.getDrawingTime());
        log("run viewDrawTimeNanos: " + nanos + ", frameStartTimeNanos: " + this.frameStartTimeNanos + ", isFrameIdle: " + this.isFrameIdle + ", nextFrameTimeNs: " + this.nextFrameTimeNs);
        boolean z = false;
        if (nanos > 0 && System.nanoTime() > (2 * this.frameIntervalNs) + nanos) {
            z = true;
        }
        this.isFrameIdle = z;
        this.nextFrameTimeNs = Math.max(this.frameStartTimeNanos, nanos) + this.frameIntervalNs;
        log("run viewDrawTimeNanos: " + nanos + ", frameStartTimeNanos: " + this.frameStartTimeNanos + ", isFrameIdle: " + this.isFrameIdle + ", nextFrameTimeNs: " + this.nextFrameTimeNs);
        log("run isCancelled: " + getPausedComposition().isCancelled() + ", isApplied: " + getPausedComposition().isApplied());
        resetAvailableTimeTo(availableTimeNanos());
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        while (!getPausedComposition().isComplete() && !booleanRef.element) {
            getPausedComposition().resume(new ShouldPauseCallback() { // from class: androidx.compose.ui.precompose.PausablePreComposeView$$ExternalSyntheticLambda0
                public final boolean shouldPause() {
                    boolean run$lambda$1;
                    run$lambda$1 = PausablePreComposeView.run$lambda$1(booleanRef, this);
                    return run$lambda$1;
                }
            });
        }
        updateElapsedAndAvailableTime();
        if (booleanRef.element) {
            savePauseTimeNanos(this.elapsedTimeNanos);
            this.choreographer.postFrameCallback(this);
        } else {
            saveResumeTimeNanos(this.elapsedTimeNanos);
            log("run apply");
            getPausedComposition().apply();
            BuildersKt.launch$default(this, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new PausablePreComposeView$run$2(this, null), 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean run$lambda$1(Ref.BooleanRef booleanRef, PausablePreComposeView pausablePreComposeView) {
        if (!booleanRef.element) {
            pausablePreComposeView.updateElapsedAndAvailableTime();
            pausablePreComposeView.saveResumeTimeNanos(pausablePreComposeView.elapsedTimeNanos);
            booleanRef.element = pausablePreComposeView.availableTimeNanos <= pausablePreComposeView.resumeTimeNanos + pausablePreComposeView.pauseTimeNanos;
            pausablePreComposeView.log("run pauseRequested: " + booleanRef.element + ", availableTimeNanos: " + pausablePreComposeView.availableTimeNanos + ", resumeTimeNanos: " + pausablePreComposeView.resumeTimeNanos + ", pauseTimeNanos: " + pausablePreComposeView.pauseTimeNanos);
        }
        return booleanRef.element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r0 >= 30.0f) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long calculateFrameIntervalIfNeeded() {
        float f;
        Display display;
        WeakReference<View> weakReference = this.currentView;
        Display display2 = null;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || (display = view.getDisplay()) == null) {
            Object systemService = getContext().getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                display2 = windowManager.getDefaultDisplay();
            }
        } else {
            display2 = display;
        }
        boolean z = false;
        if (view != null && view.isInEditMode()) {
            z = true;
        }
        if (!z && display2 != null) {
            f = display2.getRefreshRate();
        }
        f = 60.0f;
        return 1000000000 / f;
    }

    private final void resetAvailableTimeTo(long availableTimeNanos) {
        this.availableTimeNanos = availableTimeNanos;
        this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        this.elapsedTimeNanos = 0L;
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", availableTimeNanos);
    }

    private final long availableTimeNanos() {
        return this.isFrameIdle ? LocationRequestCompat.PASSIVE_INTERVAL : Math.max(0L, this.nextFrameTimeNs - System.nanoTime());
    }

    private final void updateElapsedAndAvailableTime() {
        long j = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        long j2 = Duration.getInWholeNanoseconds-impl(TimeSource.Monotonic.ValueTimeMark.minus-6eNON_k(j, this.startTime));
        this.elapsedTimeNanos = j2;
        this.availableTimeNanos -= j2;
        this.startTime = j;
    }

    public final void saveResumeTimeNanos(long timeNanos) {
        this.resumeTimeNanos = calculateAverageTime(timeNanos, this.resumeTimeNanos);
    }

    public final void savePauseTimeNanos(long timeNanos) {
        this.pauseTimeNanos = calculateAverageTime(timeNanos, this.pauseTimeNanos);
    }

    private final long calculateAverageTime(long r5, long current) {
        if (current == 0) {
            return r5;
        }
        long j = 4;
        return (r5 / j) + ((current / j) * 3);
    }

    public final void completeImmediately() {
        CoroutineScopeKt.cancel$default(this, (CancellationException) null, 1, (Object) null);
        if (getPausedComposition().isCancelled() || getPausedComposition().isApplied()) {
            return;
        }
        while (!getPausedComposition().isComplete()) {
            getPausedComposition().resume(new ShouldPauseCallback() { // from class: androidx.compose.ui.precompose.PausablePreComposeView$$ExternalSyntheticLambda1
                public final boolean shouldPause() {
                    boolean completeImmediately$lambda$2;
                    completeImmediately$lambda$2 = PausablePreComposeView.completeImmediately$lambda$2();
                    return completeImmediately$lambda$2;
                }
            });
        }
        getPausedComposition().apply();
        triggerLayout();
        triggerDraw();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (isDisposed()) {
            return;
        }
        this.frameStartTimeNanos = frameTimeNanos;
        this.handler.post(this);
    }

    @Override // androidx.compose.p001ui.precompose.PreComposeView
    public void ProvideValues(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1652925076);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideValues)219@8502L33,216@8272L263:PausablePreComposeView.kt#hnx0ug");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1652925076, i2, -1, "androidx.compose.ui.precompose.PausablePreComposeView.ProvideValues (PausablePreComposeView.kt:215)");
            }
            ProvidedValue[] providedValueArr = new ProvidedValue[2];
            providedValueArr[0] = PausableSubPreComposeControllerKt.getLocalPausableSubPreComposeController().provides(this.pausableSubPreComposeController);
            providedValueArr[1] = LocalPausableCompositionInPrefetchEnabledKt.getLocalPausableCompositionInPrefetchEnabled().provides(this.enablePreSubCompose ? true : null);
            CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1045835220, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.precompose.PausablePreComposeView$ProvideValues$1
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
                    ComposerKt.sourceInformation(composer2, "C220@8516L9:PausablePreComposeView.kt#hnx0ug");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1045835220, i3, -1, "androidx.compose.ui.precompose.PausablePreComposeView.ProvideValues.<anonymous> (PausablePreComposeView.kt:220)");
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.precompose.PausablePreComposeView$ProvideValues$2
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
                    PausablePreComposeView.this.ProvideValues(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.compose.p001ui.precompose.PreComposeView, androidx.compose.p001ui.platform.IComposeViewWithSetContent
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        setEnablePausableComposition(false);
        this.pausableSubPreComposeController = null;
        if (!getPausedComposition().isCancelled() && !getPausedComposition().isApplied()) {
            completeImmediately();
        }
        super.setContent(content);
    }

    private final void log(String msg) {
        System.out.println((Object) ("[PausablePreComposeView] " + msg));
    }
}
