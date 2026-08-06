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
import kotlinx.coroutines.flow.internal.AbortFlowException;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Limit.kt */
@Metadata(m4d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ Ref.ObjectRef $result$inlined;

    /* compiled from: Limit.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2", m42f = "Reduce.kt", m43i = {0, 0}, m44l = {139}, m45m = "emit", m46n = {"this", "it"}, m47s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(Function2 function2, Ref.ObjectRef objectRef) {
        this.$predicate$inlined = function2;
        this.$result$inlined = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        C00551 c00551;
        Object obj;
        int i;
        boolean z;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<T> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
        if (continuation instanceof C00551) {
            c00551 = (C00551) continuation;
            if ((c00551.label & Integer.MIN_VALUE) != 0) {
                c00551.label -= Integer.MIN_VALUE;
                obj = c00551.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00551.label;
                z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = this.$predicate$inlined;
                    c00551.L$0 = this;
                    c00551.L$1 = t;
                    c00551.label = 1;
                    InlineMarker.mark(6);
                    obj = function2.invoke(t, c00551);
                    InlineMarker.mark(7);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t = (T) c00551.L$1;
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c00551.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2.$result$inlined.element = t;
                    z = false;
                }
                if (z) {
                    throw new AbortFlowException(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
                }
                return Unit.INSTANCE;
            }
        }
        c00551 = new C00551(continuation);
        obj = c00551.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00551.label;
        z = true;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        if (z) {
        }
    }
}
