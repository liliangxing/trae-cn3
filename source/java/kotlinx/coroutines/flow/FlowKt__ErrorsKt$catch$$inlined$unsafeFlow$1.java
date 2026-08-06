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
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m4d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_catch$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", m42f = "Errors.kt", m43i = {0, 0}, m44l = {112, 113}, m45m = "collect", m46n = {"this", "$this$catch_u24lambda_u240"}, m47s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00461(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C00461 c00461;
        int i;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
        Throwable th;
        if (continuation instanceof C00461) {
            c00461 = (C00461) continuation;
            if ((c00461.label & Integer.MIN_VALUE) != 0) {
                c00461.label -= Integer.MIN_VALUE;
                Object obj = c00461.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00461.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = this.$this_catch$inlined;
                    c00461.L$0 = this;
                    c00461.L$1 = flowCollector;
                    c00461.label = 1;
                    obj = FlowKt.catchImpl(flow, flowCollector, c00461);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    flowCollector = (FlowCollector) c00461.L$1;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) c00461.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                th = (Throwable) obj;
                if (th != null) {
                    Function3 function3 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.$action$inlined;
                    c00461.L$0 = null;
                    c00461.L$1 = null;
                    c00461.label = 2;
                    InlineMarker.mark(6);
                    Object invoke = function3.invoke(flowCollector, th, c00461);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c00461 = new C00461(continuation);
        Object obj2 = c00461.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00461.label;
        if (i != 0) {
        }
        th = (Throwable) obj2;
        if (th != null) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_catch$inlined = flow;
        this.$action$inlined = function3;
    }
}
