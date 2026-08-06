package com.bytedance.trae.login.bytecloud;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1", f = "BytecloudAuthManager.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager$checkBytedanceNetwork$3$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $regionIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$checkBytedanceNetwork$3$result$1(int i, Continuation<? super BytecloudAuthManager$checkBytedanceNetwork$3$result$1> continuation) {
        super(2, continuation);
        this.$regionIndex = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudAuthManager$checkBytedanceNetwork$3$result$1(this.$regionIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BytecloudAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1", f = "BytecloudAuthManager.kt", i = {0}, l = {143, 143}, m = "invokeSuspend", n = {"ping"}, s = {"L$0"})
    /* renamed from: com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $regionIndex;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08271(int i, Continuation<? super C08271> continuation) {
            super(2, continuation);
            this.$regionIndex = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08271 = new C08271(this.$regionIndex, continuation);
            c08271.L$0 = obj;
            return c08271;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0079, code lost:
        
            if (((java.lang.Boolean) r13).booleanValue() == false) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Deferred deferred;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Deferred async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0828x76103e2(this.$regionIndex, null), 3, (Object) null);
                Deferred async$default2 = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1(this.$regionIndex, null), 3, (Object) null);
                this.L$0 = async$default2;
                this.label = 1;
                Object await = async$default.await((Continuation) this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = async$default2;
                obj = await;
            } else if (i == 1) {
                deferred = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                this.L$0 = null;
                this.label = 2;
                obj = deferred.await((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            z = false;
            return Boxing.boxBoolean(z);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C08271(this.$regionIndex, null), (Continuation) this);
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
