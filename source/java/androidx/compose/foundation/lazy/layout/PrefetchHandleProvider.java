package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider;
import androidx.compose.p002ui.layout.SubcomposeLayoutState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* compiled from: LazyLayoutPrefetchState.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJH\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\t2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c\u0018\u00010!¢\u0006\u0002\b#¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u001c*\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\tJ%\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "isPausableCompositionInPrefetchEnabled", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Z)V", "isStateActive", "shouldPauseBetweenPrecompositionAndPremeasure", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations", "()V", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "()Z", "setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "(Z)V", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "isHighPriority", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "onDisposed", "", "schedulePremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "Lkotlin/ExtensionFunctionType;", "schedulePremeasure-m8Kt_7k", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "executeWithPriority", "request", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "createNestedPrefetchRequest", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PrefetchHandleProvider {
    public static final int $stable = 8;
    private final PrefetchScheduler executor;
    private final boolean isPausableCompositionInPrefetchEnabled;
    private boolean isStateActive = true;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private boolean shouldPauseBetweenPrecompositionAndPremeasure;
    private final SubcomposeLayoutState subcomposeLayoutState;

    /* renamed from: getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations */
    public static /* synthetic */ void m17x911c326f() {
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler, boolean z) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeLayoutState = subcomposeLayoutState;
        this.executor = prefetchScheduler;
        this.isPausableCompositionInPrefetchEnabled = z;
    }

    /* renamed from: getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release, reason: from getter */
    public final boolean getShouldPauseBetweenPrecompositionAndPremeasure() {
        return this.shouldPauseBetweenPrecompositionAndPremeasure;
    }

    /* renamed from: setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release */
    public final void m19xd50b717b(boolean z) {
        this.shouldPauseBetweenPrecompositionAndPremeasure = z;
    }

    public final LazyLayoutPrefetchState.PrefetchHandle schedulePrecomposition(int index, boolean isHighPriority, PrefetchMetrics prefetchMetrics) {
        PrefetchScheduler prefetchScheduler = this.executor;
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(index, prefetchMetrics, prefetchScheduler instanceof PriorityPrefetchScheduler ? (PriorityPrefetchScheduler) prefetchScheduler : null, null);
        executeWithPriority(this.executor, handleAndRequestImpl, isHighPriority);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", index);
        return handleAndRequestImpl;
    }

    public final void onDisposed() {
        this.isStateActive = false;
    }

    /* renamed from: schedulePremeasure-m8Kt_7k, reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m1335schedulePremeasurem8Kt_7k(int index, long constraints, PrefetchMetrics prefetchMetrics, boolean isHighPriority, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> onItemPremeasured) {
        PrefetchScheduler prefetchScheduler = this.executor;
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, index, constraints, prefetchMetrics, prefetchScheduler instanceof PriorityPrefetchScheduler ? (PriorityPrefetchScheduler) prefetchScheduler : null, onItemPremeasured, null);
        executeWithPriority(this.executor, handleAndRequestImpl, isHighPriority);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", index);
        return handleAndRequestImpl;
    }

    public final void executeWithPriority(PrefetchScheduler prefetchScheduler, PrefetchRequest prefetchRequest, boolean z) {
        if (!(prefetchScheduler instanceof PriorityPrefetchScheduler)) {
            prefetchScheduler.schedulePrefetch(prefetchRequest);
        } else if (z) {
            ((PriorityPrefetchScheduler) prefetchScheduler).scheduleHighPriorityPrefetch(prefetchRequest);
        } else {
            ((PriorityPrefetchScheduler) prefetchScheduler).scheduleLowPriorityPrefetch(prefetchRequest);
        }
    }

    /* renamed from: createNestedPrefetchRequest-VKLhPVY, reason: not valid java name */
    public final PrefetchRequest m1334createNestedPrefetchRequestVKLhPVY(int index, long constraints, PrefetchMetrics prefetchMetrics) {
        PrefetchScheduler prefetchScheduler = this.executor;
        return new HandleAndRequestImpl(this, index, constraints, prefetchMetrics, prefetchScheduler instanceof PriorityPrefetchScheduler ? (PriorityPrefetchScheduler) prefetchScheduler : null, null, null);
    }

    public final PrefetchRequest createNestedPrefetchRequest(int index, PrefetchMetrics prefetchMetrics) {
        PrefetchScheduler prefetchScheduler = this.executor;
        return new HandleAndRequestImpl(index, prefetchMetrics, prefetchScheduler instanceof PriorityPrefetchScheduler ? (PriorityPrefetchScheduler) prefetchScheduler : null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB<\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u000fBF\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u0012J\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0017\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u00108\u001a\u000206H\u0002J\b\u0010>\u001a\u00020\fH\u0002J\f\u0010?\u001a\u00020\u001b*\u00020@H\u0016J\b\u0010A\u001a\u00020\fH\u0002J\f\u0010B\u001a\u00020\u001b*\u00020@H\u0002J&\u0010D\u001a\u00020\f*\u00020@2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001f2\u0006\u0010G\u001a\u00020HH\u0002J\u001a\u0010I\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010J\u001a\u00020\fH\u0002J\u0017\u0010K\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0004\bL\u0010MJ\u0012\u0010N\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#H\u0002J\b\u0010O\u001a\u00020PH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010C\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "index", "", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "priorityPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "onItemPremeasured", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;ILandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "premeasureConstraints", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "pausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "isMeasured", "", "isCanceled", "isApplied", "keyUsedForComposition", "", "hasResolvedNestedPrefetches", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "isUrgent", "isComposed", "()Z", "continuation", "Lkotlin/coroutines/Continuation;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "markAsUrgent", "placeablesCount", "getPlaceablesCount", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "shouldExecute", "available", "", "average", "availableTimeNanos", "elapsedTimeNanos", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "resetAvailableTimeTo", "updateElapsedAndAvailableTime", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "cleanUp", "executeRequest", "pauseRequested", "performPausableComposition", "key", "contentType", "averages", "Landroidx/compose/foundation/lazy/layout/Averages;", "performFullComposition", "performApply", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "NestedPrefetchController", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest, LazyLayoutPrefetchState.PrefetchResultScope {
        private long availableTimeNanos;
        private Continuation<? super Unit> continuation;
        private long elapsedTimeNanos;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isApplied;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private Object keyUsedForComposition;
        private NestedPrefetchController nestedPrefetchController;
        private final Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> onItemPremeasured;
        private boolean pauseRequested;
        private SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;
        private Constraints premeasureConstraints;
        private final PriorityPrefetchScheduler priorityPrefetchScheduler;
        private long startTime;

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i, long j, PrefetchMetrics prefetchMetrics, PriorityPrefetchScheduler priorityPrefetchScheduler, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(prefetchHandleProvider, i, j, prefetchMetrics, priorityPrefetchScheduler, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public HandleAndRequestImpl(int i, PrefetchMetrics prefetchMetrics, PriorityPrefetchScheduler priorityPrefetchScheduler, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> function1) {
            this.index = i;
            this.prefetchMetrics = prefetchMetrics;
            this.priorityPrefetchScheduler = priorityPrefetchScheduler;
            this.onItemPremeasured = function1;
            this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getIndex() {
            return this.index;
        }

        private HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i, long j, PrefetchMetrics prefetchMetrics, PriorityPrefetchScheduler priorityPrefetchScheduler, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> function1) {
            this(i, prefetchMetrics, priorityPrefetchScheduler, function1);
            this.premeasureConstraints = Constraints.box-impl(j);
        }

        private final boolean isComposed() {
            if (this.isApplied) {
                return true;
            }
            SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
            return pausedPrecomposition != null && pausedPrecomposition.isComplete();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object await(Continuation<? super Unit> continuation) {
            PrefetchHandleProvider$HandleAndRequestImpl$await$1 prefetchHandleProvider$HandleAndRequestImpl$await$1;
            Object coroutine_suspended;
            int i;
            Object orThrow;
            if (continuation instanceof PrefetchHandleProvider$HandleAndRequestImpl$await$1) {
                prefetchHandleProvider$HandleAndRequestImpl$await$1 = (PrefetchHandleProvider$HandleAndRequestImpl$await$1) continuation;
                if ((prefetchHandleProvider$HandleAndRequestImpl$await$1.label & Integer.MIN_VALUE) != 0) {
                    prefetchHandleProvider$HandleAndRequestImpl$await$1.label -= Integer.MIN_VALUE;
                    Object obj = prefetchHandleProvider$HandleAndRequestImpl$await$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = prefetchHandleProvider$HandleAndRequestImpl$await$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        prefetchHandleProvider$HandleAndRequestImpl$await$1.label = 1;
                        if (super.await(prefetchHandleProvider$HandleAndRequestImpl$await$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    prefetchHandleProvider$HandleAndRequestImpl$await$1.label = 2;
                    Continuation<? super Unit> continuation2 = (Continuation) prefetchHandleProvider$HandleAndRequestImpl$await$1;
                    Continuation<? super Unit> safeContinuation = new SafeContinuation<>(IntrinsicsKt.intercepted(continuation2));
                    this.continuation = safeContinuation;
                    orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            prefetchHandleProvider$HandleAndRequestImpl$await$1 = new PrefetchHandleProvider$HandleAndRequestImpl$await$1(this, continuation);
            Object obj2 = prefetchHandleProvider$HandleAndRequestImpl$await$1.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = prefetchHandleProvider$HandleAndRequestImpl$await$1.label;
            if (i != 0) {
            }
            prefetchHandleProvider$HandleAndRequestImpl$await$1.label = 2;
            Continuation<? super Unit> continuation22 = (Continuation) prefetchHandleProvider$HandleAndRequestImpl$await$1;
            Continuation<? super Unit> safeContinuation2 = new SafeContinuation<>(IntrinsicsKt.intercepted(continuation22));
            this.continuation = safeContinuation2;
            orThrow = safeContinuation2.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (orThrow == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (!this.isCanceled) {
                this.isCanceled = true;
                cleanUp();
            }
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            this.continuation = null;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void markAsUrgent() {
            this.isUrgent = true;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getPlaceablesCount() {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                return precomposedSlotHandle.getPlaceablesCount();
            }
            return 0;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        /* renamed from: getSize-YEO4UFw */
        public long mo1316getSizeYEO4UFw(int placeableIndex) {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            return precomposedSlotHandle != null ? precomposedSlotHandle.mo6373getSizeYEO4UFw(placeableIndex) : IntSize.Companion.getZero-YbymL2g();
        }

        private final boolean shouldExecute(long available, long average) {
            if (this.isUrgent) {
                average = 0;
            }
            return available > average;
        }

        private final void resetAvailableTimeTo(long availableTimeNanos) {
            this.availableTimeNanos = availableTimeNanos;
            this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
            this.elapsedTimeNanos = 0L;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", availableTimeNanos);
        }

        private final void updateElapsedAndAvailableTime() {
            long j = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
            long j2 = Duration.getInWholeNanoseconds-impl(TimeSource.Monotonic.ValueTimeMark.minus-6eNON_k(j, this.startTime));
            this.elapsedTimeNanos = j2;
            long j3 = this.availableTimeNanos - j2;
            this.availableTimeNanos = j3;
            this.startTime = j;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", j3);
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean execute(PrefetchRequestScope prefetchRequestScope) {
            boolean executeRequest;
            if (!PrefetchHandleProvider.this.isStateActive) {
                return false;
            }
            if (!this.isUrgent) {
                executeRequest = executeRequest(prefetchRequestScope);
            } else {
                Trace.beginSection("compose:lazy:prefetch:execute:urgent");
                try {
                    executeRequest = executeRequest(prefetchRequestScope);
                } finally {
                    Trace.endSection();
                }
            }
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", -1L);
            return executeRequest;
        }

        private final void cleanUp() {
            SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
            if (pausedPrecomposition != null) {
                pausedPrecomposition.cancel();
            }
            this.pausedPrecomposition = null;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                precomposedSlotHandle.dispose();
            }
            this.precomposeHandle = null;
            this.nestedPrefetchController = null;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            this.continuation = null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean executeRequest(PrefetchRequestScope prefetchRequestScope) {
            boolean z;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke();
            if (!this.isCanceled) {
                int itemCount = lazyLayoutItemProvider.getItemCount();
                int index = getIndex();
                if (index >= 0 && index < itemCount) {
                    z = true;
                    if (z) {
                        cleanUp();
                        return false;
                    }
                    Object key = lazyLayoutItemProvider.getKey(getIndex());
                    Object obj = this.keyUsedForComposition;
                    if (obj != null && !Intrinsics.areEqual(key, obj)) {
                        cleanUp();
                        return false;
                    }
                    Object contentType = lazyLayoutItemProvider.getContentType(getIndex());
                    Averages average = this.prefetchMetrics.getAverage(contentType);
                    boolean isComposed = isComposed();
                    resetAvailableTimeTo(prefetchRequestScope.availableTimeNanos());
                    if (!isComposed()) {
                        if (PrefetchHandleProvider.this.isPausableCompositionInPrefetchEnabled) {
                            if (shouldExecute(this.availableTimeNanos, average.getResumeTimeNanos() + average.getPauseTimeNanos())) {
                                Trace.beginSection("compose:lazy:prefetch:compose");
                                try {
                                    performPausableComposition(prefetchRequestScope, key, contentType, average);
                                    Unit unit = Unit.INSTANCE;
                                } finally {
                                }
                            }
                        } else if (shouldExecute(this.availableTimeNanos, average.getCompositionTimeNanos())) {
                            Trace.beginSection("compose:lazy:prefetch:compose");
                            try {
                                performFullComposition(key, contentType);
                                Unit unit2 = Unit.INSTANCE;
                                Trace.endSection();
                                updateElapsedAndAvailableTime();
                                average.saveCompositionTimeNanos(this.elapsedTimeNanos);
                            } finally {
                            }
                        }
                        if (!isComposed()) {
                            return true;
                        }
                    }
                    if (this.pausedPrecomposition != null) {
                        if (!shouldExecute(this.availableTimeNanos, average.getApplyTimeNanos())) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:apply");
                        try {
                            performApply();
                            Unit unit3 = Unit.INSTANCE;
                            Trace.endSection();
                            updateElapsedAndAvailableTime();
                            average.saveApplyTimeNanos(this.elapsedTimeNanos);
                        } finally {
                        }
                    }
                    if (!this.hasResolvedNestedPrefetches) {
                        if (this.availableTimeNanos <= 0) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                        try {
                            this.nestedPrefetchController = resolveNestedPrefetchStates();
                            this.hasResolvedNestedPrefetches = true;
                            Unit unit4 = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    NestedPrefetchController nestedPrefetchController = this.nestedPrefetchController;
                    if (nestedPrefetchController != null ? nestedPrefetchController.executeNestedPrefetches(prefetchRequestScope, average.getNestedPrefetchCount(), this.isUrgent) : false) {
                        return true;
                    }
                    NestedPrefetchController nestedPrefetchController2 = this.nestedPrefetchController;
                    if (nestedPrefetchController2 != null && nestedPrefetchController2.getExecutedNestedPrefetch()) {
                        updateElapsedAndAvailableTime();
                        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
                        NestedPrefetchController nestedPrefetchController3 = this.nestedPrefetchController;
                        if (nestedPrefetchController3 != null) {
                            nestedPrefetchController3.setExecutedNestedPrefetch(false);
                        }
                    }
                    Constraints constraints = this.premeasureConstraints;
                    if (!this.isMeasured && constraints != null) {
                        if ((PrefetchHandleProvider.this.getShouldPauseBetweenPrecompositionAndPremeasure() && !isComposed) || !shouldExecute(this.availableTimeNanos, average.getMeasureTimeNanos())) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:measure");
                        try {
                            m1337performMeasureBRTryo0(constraints.unbox-impl());
                            Unit unit5 = Unit.INSTANCE;
                            Trace.endSection();
                            updateElapsedAndAvailableTime();
                            average.saveMeasureTimeNanos(this.elapsedTimeNanos);
                            Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> function1 = this.onItemPremeasured;
                            if (function1 != null) {
                                function1.invoke(this);
                            }
                        } finally {
                        }
                    }
                    NestedPrefetchController nestedPrefetchController4 = this.nestedPrefetchController;
                    if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled && this.isMeasured && this.hasResolvedNestedPrefetches && nestedPrefetchController4 != null) {
                        int collectIdealNestedPrefetchCount = nestedPrefetchController4.collectIdealNestedPrefetchCount();
                        average.saveNestedPrefetchCount(collectIdealNestedPrefetchCount);
                        if (nestedPrefetchController4.collectNestedPrefetchedItemsCount() < collectIdealNestedPrefetchCount) {
                            average.clearMeasureTime();
                        }
                    }
                    return false;
                }
            }
            z = false;
            if (z) {
            }
        }

        private final void performPausableComposition(PrefetchRequestScope prefetchRequestScope, Object obj, Object obj2, final Averages averages) {
            SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
            if (pausedPrecomposition == null) {
                PrefetchHandleProvider prefetchHandleProvider = PrefetchHandleProvider.this;
                pausedPrecomposition = prefetchHandleProvider.subcomposeLayoutState.createPausedPrecomposition(obj, prefetchHandleProvider.itemContentFactory.getContent(getIndex(), obj, obj2));
                this.pausedPrecomposition = pausedPrecomposition;
                this.keyUsedForComposition = obj;
            }
            this.pauseRequested = false;
            while (!pausedPrecomposition.isComplete() && !this.pauseRequested) {
                pausedPrecomposition.resume(new ShouldPauseCallback() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda0
                    @Override // androidx.compose.runtime.ShouldPauseCallback
                    public final boolean shouldPause() {
                        boolean performPausableComposition$lambda$11;
                        performPausableComposition$lambda$11 = PrefetchHandleProvider.HandleAndRequestImpl.performPausableComposition$lambda$11(PrefetchHandleProvider.HandleAndRequestImpl.this, averages);
                        return performPausableComposition$lambda$11;
                    }
                });
            }
            updateElapsedAndAvailableTime();
            if (this.pauseRequested) {
                averages.savePauseTimeNanos(this.elapsedTimeNanos);
            } else {
                averages.saveResumeTimeNanos(this.elapsedTimeNanos);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean performPausableComposition$lambda$11(HandleAndRequestImpl handleAndRequestImpl, Averages averages) {
            if (!handleAndRequestImpl.pauseRequested) {
                handleAndRequestImpl.updateElapsedAndAvailableTime();
                averages.saveResumeTimeNanos(handleAndRequestImpl.elapsedTimeNanos);
                handleAndRequestImpl.pauseRequested = !handleAndRequestImpl.shouldExecute(handleAndRequestImpl.availableTimeNanos, averages.getResumeTimeNanos() + averages.getPauseTimeNanos());
            }
            return handleAndRequestImpl.pauseRequested;
        }

        private final void performFullComposition(Object key, Object contentType) {
            if (!(this.precomposeHandle == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("Request was already composed!");
            }
            Function2<Composer, Integer, Unit> content = PrefetchHandleProvider.this.itemContentFactory.getContent(getIndex(), key, contentType);
            this.keyUsedForComposition = key;
            this.precomposeHandle = PrefetchHandleProvider.this.subcomposeLayoutState.precompose(key, content);
            this.isApplied = true;
        }

        private final void performApply() {
            SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
            if (pausedPrecomposition == null) {
                throw new IllegalArgumentException("Nothing to apply!".toString());
            }
            this.precomposeHandle = pausedPrecomposition.apply();
            this.pausedPrecomposition = null;
            this.isApplied = true;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            this.continuation = null;
        }

        /* renamed from: performMeasure-BRTryo0, reason: not valid java name */
        private final void m1337performMeasureBRTryo0(long constraints) {
            if (!(!this.isCanceled)) {
                InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
            }
            if (!(!this.isMeasured)) {
                InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
            }
            this.isMeasured = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                int placeablesCount = precomposedSlotHandle.getPlaceablesCount();
                for (int i = 0; i < placeablesCount; i++) {
                    precomposedSlotHandle.mo6374premeasure0kLqBqw(i, constraints);
                }
                return;
            }
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("performComposition() must be called before performMeasure()");
            throw new KotlinNothingValueException();
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                precomposedSlotHandle.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new Function1() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TraversableNode.Companion.TraverseDescendantsAction resolveNestedPrefetchStates$lambda$20;
                        resolveNestedPrefetchStates$lambda$20 = PrefetchHandleProvider.HandleAndRequestImpl.resolveNestedPrefetchStates$lambda$20(objectRef, (TraversableNode) obj);
                        return resolveNestedPrefetchStates$lambda$20;
                    }
                });
                List list = (List) objectRef.element;
                if (list != null) {
                    return new NestedPrefetchController(list);
                }
                return null;
            }
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Should precompose before resolving nested prefetch states");
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TraversableNode.Companion.TraverseDescendantsAction resolveNestedPrefetchStates$lambda$20(Ref.ObjectRef objectRef, TraversableNode traversableNode) {
            Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
            LazyLayoutPrefetchState prefetchState = ((TraversablePrefetchStateNode) traversableNode).getPrefetchState();
            List list = (List) objectRef.element;
            if (list != null) {
                list.add(prefetchState);
            } else {
                list = CollectionsKt.mutableListOf(new LazyLayoutPrefetchState[]{prefetchState});
            }
            objectRef.element = list;
            return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + getIndex() + ", constraints = " + this.premeasureConstraints + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: LazyLayoutPrefetchState.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0014\u001a\u00020\u000f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "", "states", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestsByState", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "", "requestIndex", "executedNestedPrefetch", "", "getExecutedNestedPrefetch", "()Z", "setExecutedNestedPrefetch", "(Z)V", "executeNestedPrefetches", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nestedPrefetchCount", "isUrgent", "collectIdealNestedPrefetchCount", "collectNestedPrefetchedItemsCount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public final class NestedPrefetchController {
            private boolean executedNestedPrefetch;
            private int requestIndex;
            private final List<PrefetchRequest>[] requestsByState;
            private int stateIndex;
            private final List<LazyLayoutPrefetchState> states;

            public NestedPrefetchController(List<LazyLayoutPrefetchState> list) {
                this.states = list;
                this.requestsByState = new List[list.size()];
                if (!list.isEmpty()) {
                    return;
                }
                InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
            }

            public final boolean getExecutedNestedPrefetch() {
                return this.executedNestedPrefetch;
            }

            public final void setExecutedNestedPrefetch(boolean z) {
                this.executedNestedPrefetch = z;
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope prefetchRequestScope, int i, boolean z) {
                if (this.stateIndex >= this.states.size()) {
                    return false;
                }
                if (!(!HandleAndRequestImpl.this.isCanceled)) {
                    InlineClassHelperKt.throwIllegalStateException("Should not execute nested prefetch on canceled request");
                }
                if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled) {
                    Trace.beginSection("compose:lazy:prefetch:update_nested_prefetch_count");
                    try {
                        List<LazyLayoutPrefetchState> list = this.states;
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            list.get(i2).setRealizedNestedPrefetchCount$foundation_release(i);
                        }
                        Unit unit = Unit.INSTANCE;
                        Trace.endSection();
                    } finally {
                    }
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.stateIndex < this.states.size()) {
                    try {
                        if (this.requestsByState[this.stateIndex] == null) {
                            if (prefetchRequestScope.availableTimeNanos() <= 0) {
                                return true;
                            }
                            List<PrefetchRequest>[] listArr = this.requestsByState;
                            int i3 = this.stateIndex;
                            listArr[i3] = this.states.get(i3).collectNestedPrefetchRequests$foundation_release();
                        }
                        List<PrefetchRequest> list2 = this.requestsByState[this.stateIndex];
                        Intrinsics.checkNotNull(list2);
                        while (this.requestIndex < list2.size()) {
                            PrefetchRequest prefetchRequest = list2.get(this.requestIndex);
                            if (z) {
                                HandleAndRequestImpl handleAndRequestImpl = prefetchRequest instanceof HandleAndRequestImpl ? (HandleAndRequestImpl) prefetchRequest : null;
                                if (handleAndRequestImpl != null) {
                                    handleAndRequestImpl.markAsUrgent();
                                }
                            }
                            this.executedNestedPrefetch = true;
                            if (prefetchRequest.execute(prefetchRequestScope)) {
                                return true;
                            }
                            this.requestIndex++;
                        }
                        this.requestIndex = 0;
                        this.stateIndex++;
                    } finally {
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                return false;
            }

            public final int collectIdealNestedPrefetchCount() {
                List<LazyLayoutPrefetchState> list = this.states;
                int size = list.size();
                int i = Integer.MAX_VALUE;
                for (int i2 = 0; i2 < size; i2++) {
                    i = Math.min(i, list.get(i2).getIdealNestedPrefetchCount());
                }
                if (i == Integer.MAX_VALUE) {
                    return 0;
                }
                return i;
            }

            public final int collectNestedPrefetchedItemsCount() {
                List<LazyLayoutPrefetchState> list = this.states;
                int size = list.size();
                int i = Integer.MAX_VALUE;
                for (int i2 = 0; i2 < size; i2++) {
                    i = Math.min(i, list.get(i2).getLastNumberOfNestedPrefetchItems());
                }
                if (i == Integer.MAX_VALUE) {
                    return 0;
                }
                return i;
            }
        }
    }
}
