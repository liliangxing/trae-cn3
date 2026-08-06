package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m4d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", m42f = "Emitters.kt", m43i = {0, 0, 0, 1}, m44l = {113, 121}, m45m = "collect", m46n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, m47s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v7, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C00421 c00421;
        int i;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Ref.BooleanRef booleanRef;
        try {
            if (continuation instanceof C00421) {
                c00421 = (C00421) continuation;
                if ((c00421.label & Integer.MIN_VALUE) != 0) {
                    c00421.label -= Integer.MIN_VALUE;
                    Object obj = c00421.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c00421.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        booleanRef2.element = true;
                        Flow flow = this.$this_onEmpty$inlined;
                        FlowKt__EmittersKt$onEmpty$1$1 flowKt__EmittersKt$onEmpty$1$1 = new FlowKt__EmittersKt$onEmpty$1$1(booleanRef2, flowCollector);
                        c00421.L$0 = this;
                        c00421.L$1 = flowCollector;
                        c00421.L$2 = booleanRef2;
                        c00421.label = 1;
                        if (flow.collect(flowKt__EmittersKt$onEmpty$1$1, c00421) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = this;
                        flowCollector2 = flowCollector;
                        booleanRef = booleanRef2;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            SafeCollector safeCollector = (SafeCollector) c00421.L$0;
                            ResultKt.throwOnFailure(obj);
                            flowCollector = safeCollector;
                            return Unit.INSTANCE;
                        }
                        booleanRef = (Ref.BooleanRef) c00421.L$2;
                        flowCollector2 = (FlowCollector) c00421.L$1;
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) c00421.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (booleanRef.element) {
                        SafeCollector safeCollector2 = new SafeCollector(flowCollector2, c00421.getContext());
                        Function2 function2 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.$action$inlined;
                        c00421.L$0 = safeCollector2;
                        c00421.L$1 = null;
                        c00421.L$2 = null;
                        c00421.label = 2;
                        InlineMarker.mark(6);
                        Object invoke = function2.invoke(safeCollector2, c00421);
                        InlineMarker.mark(7);
                        flowCollector = safeCollector2;
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            if (booleanRef.element) {
            }
            return Unit.INSTANCE;
        } finally {
            flowCollector.releaseIntercepted();
        }
        c00421 = new C00421(continuation);
        Object obj2 = c00421.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00421.label;
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onEmpty$inlined = flow;
        this.$action$inlined = function2;
    }
}
