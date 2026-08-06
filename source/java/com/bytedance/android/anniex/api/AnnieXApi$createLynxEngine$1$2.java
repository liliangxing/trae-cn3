package com.bytedance.android.anniex.api;

import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;

/* compiled from: AnnieXApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.api.AnnieXApi$createLynxEngine$1$2", f = "AnnieXApi.kt", i = {0}, l = {260}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXApi$createLynxEngine$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXLynxEngine $annieXLynxEngine;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXApi$createLynxEngine$1$2(AnnieXLynxEngine annieXLynxEngine, Continuation<? super AnnieXApi$createLynxEngine$1$2> continuation) {
        super(2, continuation);
        this.$annieXLynxEngine = annieXLynxEngine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> annieXApi$createLynxEngine$1$2 = new AnnieXApi$createLynxEngine$1$2(this.$annieXLynxEngine, continuation);
        annieXApi$createLynxEngine$1$2.L$0 = obj;
        return annieXApi$createLynxEngine$1$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception e;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (DelayKt.delay(this.$annieXLynxEngine.getExpirationTime(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                } catch (Exception e2) {
                    coroutineScope = coroutineScope2;
                    e = e2;
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "Error in coroutine: " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                    JobKt.cancelChildren$default(coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                    CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    coroutine_suspended = coroutineScope2;
                    th = th;
                    JobKt.cancelChildren$default(coroutine_suspended.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                    CoroutineScopeKt.cancel$default((CoroutineScope) coroutine_suspended, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "Error in coroutine: " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                    JobKt.cancelChildren$default(coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                    CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
            }
            AnnieXLynxEngineManager.INSTANCE.hasExpired();
            JobKt.cancelChildren$default(coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
