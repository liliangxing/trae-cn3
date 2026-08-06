package com.bytedance.trae.conversation.devices.flow;

import androidx.lifecycle.Lifecycle;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: DeviceFlowConnectionSuccessLifecycle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2", f = "DeviceFlowConnectionSuccessLifecycle.kt", i = {0}, l = {33, 35, 35}, m = "invokeSuspend", n = {"lifecycleJob"}, s = {"L$0"})
/* renamed from: com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0723xa1add55f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Function0<Unit> $onCompletion;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723xa1add55f(Lifecycle lifecycle, long j, Function0<Unit> function0, Continuation<? super C0723xa1add55f> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.$delayMs = j;
        this.$onCompletion = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0723xa1add55f = new C0723xa1add55f(this.$lifecycle, this.$delayMs, this.$onCompletion, continuation);
        c0723xa1add55f.L$0 = obj;
        return c0723xa1add55f;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
            Job launch$default = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0724x8b2fb1a5(this.$lifecycle, this.$delayMs, CompletableDeferred$default, this.$onCompletion, null), 3, (Object) null);
            try {
                this.L$0 = launch$default;
                this.label = 1;
                if (CompletableDeferred$default.await((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
            } catch (Throwable th) {
                th = th;
                job = launch$default;
                this.L$0 = th;
                this.label = 3;
                if (JobKt.cancelAndJoin(job, (Continuation) this) != coroutine_suspended) {
                }
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th2 = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                throw th2;
            }
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                this.L$0 = th;
                this.label = 3;
                if (JobKt.cancelAndJoin(job, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (JobKt.cancelAndJoin(job, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
