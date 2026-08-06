package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m4d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m42f = "Emitters.kt", m43i = {0, 0, 1, 2}, m44l = {113, 120, 127}, m45m = "collect", m46n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, m47s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C00411 c00411;
        Object coroutine_suspended;
        int i;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        Object invokeSafely$FlowKt__EmittersKt;
        SafeCollector safeCollector;
        Throwable th;
        SafeCollector safeCollector2;
        Object invoke;
        try {
            if (continuation instanceof C00411) {
                c00411 = (C00411) continuation;
                if ((c00411.label & Integer.MIN_VALUE) != 0) {
                    c00411.label -= Integer.MIN_VALUE;
                    Object obj = c00411.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c00411.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            Flow flow = this.$this_onCompletion$inlined;
                            c00411.L$0 = this;
                            c00411.L$1 = flowCollector;
                            c00411.label = 1;
                            if (flow.collect(flowCollector, c00411) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        } catch (Throwable th2) {
                            th = th2;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            ThrowingCollector throwingCollector = new ThrowingCollector(th);
                            Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            c00411.L$0 = th;
                            c00411.L$1 = null;
                            c00411.label = 2;
                            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, c00411);
                            if (invokeSafely$FlowKt__EmittersKt != coroutine_suspended) {
                            }
                        }
                    } else {
                        if (i != 1) {
                            if (i == 2) {
                                Throwable th3 = (Throwable) c00411.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th3;
                            }
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            safeCollector2 = (SafeCollector) c00411.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                safeCollector2.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th4) {
                                th = th4;
                                safeCollector2.releaseIntercepted();
                                throw th;
                            }
                        }
                        flowCollector = (FlowCollector) c00411.L$1;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c00411.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th5) {
                            th = th5;
                            ThrowingCollector throwingCollector2 = new ThrowingCollector(th);
                            Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            c00411.L$0 = th;
                            c00411.L$1 = null;
                            c00411.label = 2;
                            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector2, function32, th, c00411);
                            if (invokeSafely$FlowKt__EmittersKt != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    }
                    safeCollector = new SafeCollector(flowCollector, c00411.getContext());
                    Function3 function33 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                    c00411.L$0 = safeCollector;
                    c00411.L$1 = null;
                    c00411.label = 3;
                    InlineMarker.mark(6);
                    invoke = function33.invoke(safeCollector, null, c00411);
                    InlineMarker.mark(7);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return Unit.INSTANCE;
                }
            }
            Function3 function332 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            c00411.L$0 = safeCollector;
            c00411.L$1 = null;
            c00411.label = 3;
            InlineMarker.mark(6);
            invoke = function332.invoke(safeCollector, null, c00411);
            InlineMarker.mark(7);
            if (invoke != coroutine_suspended) {
            }
        } catch (Throwable th6) {
            th = th6;
            safeCollector2 = safeCollector;
            safeCollector2.releaseIntercepted();
            throw th;
        }
        c00411 = new C00411(continuation);
        Object obj2 = c00411.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00411.label;
        if (i != 0) {
        }
        safeCollector = new SafeCollector(flowCollector, c00411.getContext());
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}
