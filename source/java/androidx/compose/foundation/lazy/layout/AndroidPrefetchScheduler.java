package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.precompose.PausableSubPreComposeController;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchScheduler.android.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002&'B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "Landroid/view/View$OnAttachStateChangeListener;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "pausableSubPreComposeController", "Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/precompose/PausableSubPreComposeController;)V", "prefetchRequests", "Ljava/util/PriorityQueue;", "Landroidx/compose/foundation/lazy/layout/PriorityTask;", "prefetchScheduled", "", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "scope", "Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "isActive", "frameStartTimeNanos", "", "run", "", "runRequest", "doFrame", "frameTimeNanos", "startExecution", "scheduleLowPriorityPrefetch", "prefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "scheduleHighPriorityPrefetch", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "PrefetchRequestScopeImpl", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidPrefetchScheduler implements PrefetchScheduler, PriorityPrefetchScheduler, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    private static long frameIntervalNs;
    private long frameStartTimeNanos;
    private boolean isActive;
    private final PausableSubPreComposeController pausableSubPreComposeController;
    private boolean prefetchScheduled;
    private final View view;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final PriorityQueue<PriorityTask> prefetchRequests = new PriorityQueue<>(11, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int prefetchRequests$lambda$0;
            prefetchRequests$lambda$0 = AndroidPrefetchScheduler.prefetchRequests$lambda$0((PriorityTask) obj, (PriorityTask) obj2);
            return prefetchRequests$lambda$0;
        }
    });
    private final Choreographer choreographer = Choreographer.getInstance();
    private final PrefetchRequestScopeImpl scope = new PrefetchRequestScopeImpl();

    public AndroidPrefetchScheduler(View view, PausableSubPreComposeController pausableSubPreComposeController) {
        this.view = view;
        this.pausableSubPreComposeController = pausableSubPreComposeController;
        INSTANCE.calculateFrameIntervalIfNeeded(view);
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            onViewAttachedToWindow(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int prefetchRequests$lambda$0(PriorityTask priorityTask, PriorityTask priorityTask2) {
        return Intrinsics.compare(priorityTask2.getPriority(), priorityTask.getPriority());
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (!this.isActive || this.view.getWindowVisibility() != 0) {
            PausableSubPreComposeController pausableSubPreComposeController = this.pausableSubPreComposeController;
            if (!(pausableSubPreComposeController != null && pausableSubPreComposeController.getInPausablePreCompose())) {
                z = false;
                if (!this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !z) {
                    this.prefetchScheduled = false;
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime());
                PrefetchRequestScopeImpl prefetchRequestScopeImpl = this.scope;
                PausableSubPreComposeController pausableSubPreComposeController2 = this.pausableSubPreComposeController;
                prefetchRequestScopeImpl.setFrameIdle(!(pausableSubPreComposeController2 != null && pausableSubPreComposeController2.getInPausablePreCompose()) && System.nanoTime() > (((long) 2) * frameIntervalNs) + nanos);
                this.scope.setNextFrameTimeNs(Math.max(this.frameStartTimeNanos, nanos) + frameIntervalNs);
                boolean z2 = false;
                while ((!this.prefetchRequests.isEmpty()) && !z2) {
                    if (!this.scope.getIsFrameIdle()) {
                        z2 = runRequest();
                    } else {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            z2 = runRequest();
                        } finally {
                            Trace.endSection();
                        }
                    }
                }
                if (z2) {
                    this.choreographer.postFrameCallback(this);
                } else {
                    this.prefetchScheduled = false;
                }
                AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", 0L);
                return;
            }
        }
        z = true;
        if (!this.prefetchRequests.isEmpty()) {
        }
        this.prefetchScheduled = false;
    }

    private final boolean runRequest() {
        long availableTimeNanos = this.scope.availableTimeNanos();
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", availableTimeNanos);
        boolean z = true;
        if (availableTimeNanos > 0) {
            PriorityTask peek = this.prefetchRequests.peek();
            Intrinsics.checkNotNull(peek);
            if (!peek.getRequest().execute(this.scope)) {
                this.prefetchRequests.poll();
                z = false;
            }
            this.scope.setFrameIdle(false);
        }
        return z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (!this.isActive) {
            PausableSubPreComposeController pausableSubPreComposeController = this.pausableSubPreComposeController;
            boolean z = false;
            if (pausableSubPreComposeController != null && pausableSubPreComposeController.getInPausablePreCompose()) {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        this.frameStartTimeNanos = frameTimeNanos;
        if (this.view.isAttachedToWindow()) {
            this.view.post(this);
        } else {
            this.view.getHandler().post(this);
        }
    }

    private final void startExecution() {
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        if (this.view.isAttachedToWindow()) {
            this.view.post(this);
        } else {
            this.view.getHandler().post(this);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.PriorityPrefetchScheduler
    public void scheduleLowPriorityPrefetch(PrefetchRequest prefetchRequest) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.INSTANCE.getLow(), prefetchRequest));
        startExecution();
    }

    @Override // androidx.compose.foundation.lazy.layout.PriorityPrefetchScheduler
    public void scheduleHighPriorityPrefetch(PrefetchRequest prefetchRequest) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.INSTANCE.getHigh(), prefetchRequest));
        startExecution();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        this.isActive = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    /* compiled from: PrefetchScheduler.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "<init>", "()V", "isFrameIdle", "", "()Z", "setFrameIdle", "(Z)V", "nextFrameTimeNs", "", "getNextFrameTimeNs", "()J", "setNextFrameTimeNs", "(J)V", "availableTimeNanos", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        public static final int $stable = 8;
        private boolean isFrameIdle;
        private long nextFrameTimeNs;

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

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long availableTimeNanos() {
            return this.isFrameIdle ? SnapshotId_jvmKt.SnapshotIdMax : Math.max(0L, this.nextFrameTimeNs - System.nanoTime());
        }
    }

    /* compiled from: PrefetchScheduler.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$Companion;", "", "<init>", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        
            if (r5 >= 30.0f) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void calculateFrameIntervalIfNeeded(View view) {
            float f;
            if (AndroidPrefetchScheduler.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                if (!view.isInEditMode() && display != null) {
                    f = display.getRefreshRate();
                }
                f = 60.0f;
                AndroidPrefetchScheduler.frameIntervalNs = 1000000000 / f;
            }
        }
    }
}
