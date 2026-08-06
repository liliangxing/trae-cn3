package coil3.compose;

import androidx.exifinterface.media.ExifInterface;
import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Merge.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1", f = "AsyncImagePainter.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super AsyncImagePainter.Input>, Unit, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1(Continuation continuation, AsyncImagePainter asyncImagePainter) {
        super(3, continuation);
        this.this$0 = asyncImagePainter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector<? super AsyncImagePainter.Input>) obj, (Unit) obj2, (Continuation<? super Unit>) obj3);
    }

    public final Object invoke(FlowCollector<? super AsyncImagePainter.Input> flowCollector, Unit unit, Continuation<? super Unit> continuation) {
        AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1 asyncImagePainter$onRemembered$$inlined$flatMapLatest$1 = new AsyncImagePainter$onRemembered$$inlined$flatMapLatest$1(continuation, this.this$0);
        asyncImagePainter$onRemembered$$inlined$flatMapLatest$1.L$0 = flowCollector;
        asyncImagePainter$onRemembered$$inlined$flatMapLatest$1.L$1 = unit;
        return asyncImagePainter$onRemembered$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            flow = this.this$0.inputFlow;
            Flow flow2 = flow;
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow2, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
