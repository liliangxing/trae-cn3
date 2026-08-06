package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.base.ArgusInitializer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArgusInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.base.ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1", f = "ArgusInitializer.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $asyncTimeout;
    final /* synthetic */ Ref.ObjectRef<String> $setupMsg;
    final /* synthetic */ long $timeWaiting;
    int label;
    final /* synthetic */ ArgusInitializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1(long j, ArgusInitializer argusInitializer, Ref.ObjectRef<String> objectRef, Ref.BooleanRef booleanRef, Continuation<? super ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1> continuation) {
        super(2, continuation);
        this.$timeWaiting = j;
        this.this$0 = argusInitializer;
        this.$setupMsg = objectRef;
        this.$asyncTimeout = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1(this.$timeWaiting, this.this$0, this.$setupMsg, this.$asyncTimeout, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TimeoutKt.withTimeout(this.$timeWaiting, new C11611(this.this$0, this.$setupMsg, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
            this.this$0.syncExecuteSetupTask();
            this.$setupMsg.element = "use sync setup task, await async timeout";
            this.$asyncTimeout.element = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArgusInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ies.argus.base.ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1$1", f = "ArgusInitializer.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.ies.argus.base.ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class C11611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $setupMsg;
        Object L$0;
        int label;
        final /* synthetic */ ArgusInitializer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11611(ArgusInitializer argusInitializer, Ref.ObjectRef<String> objectRef, Continuation<? super C11611> continuation) {
            super(2, continuation);
            this.this$0 = argusInitializer;
            this.$setupMsg = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11611(this.this$0, this.$setupMsg, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            List list;
            C11611 c11611;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                list = this.this$0.deferredSetupTask;
                if (list == null) {
                    c11611 = this;
                    c11611.$setupMsg.element = "await async setup task";
                    return Unit.INSTANCE;
                }
                it = list.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            c11611 = this;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ArgusInitializer.TaskPriority taskPriority = (ArgusInitializer.TaskPriority) pair.component1();
                Deferred deferred = (Deferred) pair.component2();
                if (taskPriority == ArgusInitializer.TaskPriority.HIGH) {
                    c11611.L$0 = it;
                    c11611.label = 1;
                    if (deferred.join(c11611) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            c11611.$setupMsg.element = "await async setup task";
            return Unit.INSTANCE;
        }
    }
}
