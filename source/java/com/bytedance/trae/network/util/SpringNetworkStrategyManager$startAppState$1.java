package com.bytedance.trae.network.util;

import com.bytedance.trae.network.util.SpringNetworkStrategyManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpringNetwokStrategyManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.util.SpringNetworkStrategyManager$startAppState$1", f = "SpringNetwokStrategyManager.kt", i = {}, l = {75, 80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SpringNetworkStrategyManager$startAppState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpringNetworkStrategyManager.SpringNetworkStrategy $strategy;
    final /* synthetic */ long $timeoutDelay;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpringNetworkStrategyManager$startAppState$1(long j, SpringNetworkStrategyManager.SpringNetworkStrategy springNetworkStrategy, Continuation<? super SpringNetworkStrategyManager$startAppState$1> continuation) {
        super(2, continuation);
        this.$timeoutDelay = j;
        this.$strategy = springNetworkStrategy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpringNetworkStrategyManager$startAppState$1(this.$timeoutDelay, this.$strategy, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SpringNetworkStrategyManager springNetworkStrategyManager;
        SpringNetworkStrategyManager.SpringNetworkStrategy springNetworkStrategy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$timeoutDelay, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                springNetworkStrategyManager = SpringNetworkStrategyManager.INSTANCE;
                SpringNetworkStrategyManager.SpringNetworkStrategy springNetworkStrategy2 = this.$strategy;
                synchronized (springNetworkStrategyManager) {
                    springNetworkStrategy = SpringNetworkStrategyManager.currentStrategy;
                    if (springNetworkStrategy == springNetworkStrategy2) {
                        SpringNetworkStrategyManager springNetworkStrategyManager2 = SpringNetworkStrategyManager.INSTANCE;
                        SpringNetworkStrategyManager.currentStrategy = null;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getIO(), new C08921(null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        springNetworkStrategyManager = SpringNetworkStrategyManager.INSTANCE;
        SpringNetworkStrategyManager.SpringNetworkStrategy springNetworkStrategy22 = this.$strategy;
        synchronized (springNetworkStrategyManager) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpringNetwokStrategyManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.network.util.SpringNetworkStrategyManager$startAppState$1$1", f = "SpringNetwokStrategyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.network.util.SpringNetworkStrategyManager$startAppState$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08921(Continuation<? super C08921> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08921(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SpringNetworkStrategyManager.INSTANCE.safeResetToDefaultState();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
