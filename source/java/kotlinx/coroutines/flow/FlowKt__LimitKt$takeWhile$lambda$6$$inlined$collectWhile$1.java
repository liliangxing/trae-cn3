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
import kotlinx.coroutines.flow.internal.AbortFlowException;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Limit.kt */
@Metadata(m4d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

    /* compiled from: Limit.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", m42f = "Limit.kt", m43i = {0, 0, 1}, m44l = {139, 140}, m45m = "emit", m46n = {"this", "value", "this"}, m47s = {"L$0", "L$1", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00501(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.$predicate$inlined = function2;
        this.$this_unsafeFlow$inlined = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        C00501 c00501;
        int i;
        boolean z;
        Object obj;
        T t2;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
        if (continuation instanceof C00501) {
            c00501 = (C00501) continuation;
            if ((c00501.label & Integer.MIN_VALUE) != 0) {
                c00501.label -= Integer.MIN_VALUE;
                Object obj2 = c00501.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00501.label;
                z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Function2 function2 = this.$predicate$inlined;
                    c00501.L$0 = this;
                    c00501.L$1 = t;
                    c00501.label = 1;
                    InlineMarker.mark(6);
                    Object invoke = function2.invoke(t, c00501);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = invoke;
                    t2 = t;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) c00501.L$0;
                        ResultKt.throwOnFailure(obj2);
                        if (!z) {
                            throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
                        }
                        return Unit.INSTANCE;
                    }
                    Object obj3 = c00501.L$1;
                    FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) c00501.L$0;
                    ResultKt.throwOnFailure(obj2);
                    t2 = obj3;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12;
                    obj = obj2;
                }
                if (((Boolean) obj).booleanValue()) {
                    z = false;
                } else {
                    FlowCollector flowCollector = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.$this_unsafeFlow$inlined;
                    c00501.L$0 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
                    c00501.L$1 = null;
                    c00501.label = 2;
                    if (flowCollector.emit(t2, c00501) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (!z) {
                }
            }
        }
        c00501 = new C00501(continuation);
        Object obj22 = c00501.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00501.label;
        z = true;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        if (!z) {
        }
    }
}
