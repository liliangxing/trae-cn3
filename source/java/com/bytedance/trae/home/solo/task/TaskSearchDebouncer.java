package com.bytedance.trae.home.solo.task;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: TaskSearchDebouncer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J]\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "debounceMs", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;J)V", "job", "Lkotlinx/coroutines/Job;", "submit", "", "query", "", "isSearchMode", "", "onReset", "Lkotlin/Function0;", "onPending", "onSearch", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "cancel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskSearchDebouncer {
    public static final long DEFAULT_DEBOUNCE_MS = 200;
    private final long debounceMs;
    private Job job;
    private final CoroutineScope scope;
    public static final int $stable = 8;

    public TaskSearchDebouncer(CoroutineScope coroutineScope, long j) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.debounceMs = j;
    }

    public /* synthetic */ TaskSearchDebouncer(CoroutineScope coroutineScope, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? 200L : j);
    }

    public static /* synthetic */ void submit$default(TaskSearchDebouncer taskSearchDebouncer, String str, boolean z, Function0 function0, Function0 function02, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function02 = new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskSearchDebouncer$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        taskSearchDebouncer.submit(str, z, function0, function02, function2);
    }

    public final void submit(String query, boolean isSearchMode, Function0<Unit> onReset, Function0<Unit> onPending, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> onSearch) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(onReset, "onReset");
        Intrinsics.checkNotNullParameter(onPending, "onPending");
        Intrinsics.checkNotNullParameter(onSearch, "onSearch");
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        String obj = StringsKt.trim(query).toString();
        if (isSearchMode) {
            if (!(obj.length() == 0)) {
                onPending.invoke();
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TaskSearchDebouncer$submit$2(this, onSearch, obj, null), 3, (Object) null);
                return;
            }
        }
        this.job = null;
        onReset.invoke();
    }

    public final void cancel() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }
}
