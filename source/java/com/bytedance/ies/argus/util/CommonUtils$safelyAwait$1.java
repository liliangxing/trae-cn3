package com.bytedance.ies.argus.util;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: CommonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwait$1", f = "CommonUtils.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class CommonUtils$safelyAwait$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Deferred<?> $this_safelyAwait;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonUtils$safelyAwait$1(Deferred<?> deferred, Continuation<? super CommonUtils$safelyAwait$1> continuation) {
        super(2, continuation);
        this.$this_safelyAwait = deferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonUtils$safelyAwait$1(this.$this_safelyAwait, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(WsConstants.EXIT_DELAY_TIME, new C11661(this.$this_safelyAwait, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != null) {
                z = false;
            }
        } catch (Exception unused) {
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwait$1$1", f = "CommonUtils.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.ies.argus.util.CommonUtils$safelyAwait$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class C11661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Deferred<?> $this_safelyAwait;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11661(Deferred<?> deferred, Continuation<? super C11661> continuation) {
            super(2, continuation);
            this.$this_safelyAwait = deferred;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11661(this.$this_safelyAwait, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$this_safelyAwait.await((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }
}
