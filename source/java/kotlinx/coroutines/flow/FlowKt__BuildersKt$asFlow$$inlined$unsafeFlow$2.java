package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m4d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> implements Flow<T> {
    final /* synthetic */ Function1 $this_asFlow$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", m42f = "Builders.kt", m43i = {}, m44l = {112, 112}, m45m = "collect", m46n = {}, m47s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00301 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00301(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C00301 c00301;
        Object obj;
        Object coroutine_suspended;
        int i;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
                obj = c00301.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00301.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.$this_asFlow$inlined;
                    c00301.L$0 = flowCollector;
                    c00301.label = 1;
                    InlineMarker.mark(6);
                    obj = function1.invoke(c00301);
                    InlineMarker.mark(7);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    flowCollector = (FlowCollector) c00301.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                c00301.L$0 = null;
                c00301.label = 2;
                if (flowCollector.emit(obj, c00301) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c00301 = new C00301(continuation);
        obj = c00301.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00301.label;
        if (i != 0) {
        }
        c00301.L$0 = null;
        c00301.label = 2;
        if (flowCollector.emit(obj, c00301) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }
}
