package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m4d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m5d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
    @DebugMetadata(m41c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", m42f = "Builders.kt", m43i = {0, 0}, m44l = {113}, m45m = "collect", m46n = {"this", "$this$flowOf_u24lambda_u248"}, m47s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class C00381 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00381(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0061 -> B:10:0x0064). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C00381 c00381;
        int i;
        int i2;
        FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        int length;
        if (continuation instanceof C00381) {
            c00381 = (C00381) continuation;
            if ((c00381.label & Integer.MIN_VALUE) != 0) {
                c00381.label -= Integer.MIN_VALUE;
                Object obj = c00381.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00381.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 0;
                    flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    length = this.$elements$inlined.length;
                    if (i2 < length) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    length = c00381.I$1;
                    i2 = c00381.I$0;
                    FlowCollector flowCollector3 = (FlowCollector) c00381.L$1;
                    flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = (FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) c00381.L$0;
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector4 = flowCollector3;
                    i2++;
                    flowCollector2 = flowCollector4;
                    if (i2 < length) {
                        Object obj2 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.$elements$inlined[i2];
                        c00381.L$0 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
                        c00381.L$1 = flowCollector2;
                        c00381.I$0 = i2;
                        c00381.I$1 = length;
                        c00381.label = 1;
                        Object emit = flowCollector2.emit(obj2, c00381);
                        flowCollector4 = flowCollector2;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2++;
                        flowCollector2 = flowCollector4;
                        if (i2 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        c00381 = new C00381(continuation);
        Object obj3 = c00381.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c00381.label;
        if (i != 0) {
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }
}
