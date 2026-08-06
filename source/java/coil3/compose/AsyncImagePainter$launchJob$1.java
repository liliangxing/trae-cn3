package coil3.compose;

import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$launchJob$1", f = "AsyncImagePainter.kt", i = {}, l = {319, 322}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainter$launchJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsyncImagePainter.Input $input;
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$launchJob$1(AsyncImagePainter asyncImagePainter, AsyncImagePainter.Input input, Continuation<? super AsyncImagePainter$launchJob$1> continuation) {
        super(2, continuation);
        this.this$0 = asyncImagePainter;
        this.$input = input;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$launchJob$1(this.this$0, this.$input, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ImageRequest updateRequest;
        ImageRequest updateRequest2;
        AsyncImagePainter.State state;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AsyncImagePreviewHandler previewHandler = this.this$0.getPreviewHandler();
            if (previewHandler != null) {
                updateRequest2 = this.this$0.updateRequest(this.$input.getRequest(), true);
                this.label = 1;
                obj = previewHandler.handle(this.$input.getImageLoader(), updateRequest2, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                state = (AsyncImagePainter.State) obj;
            } else {
                updateRequest = this.this$0.updateRequest(this.$input.getRequest(), false);
                this.label = 2;
                obj = this.$input.getImageLoader().execute(updateRequest, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                state = this.this$0.toState((ImageResult) obj);
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            state = (AsyncImagePainter.State) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            state = this.this$0.toState((ImageResult) obj);
        }
        this.this$0.updateState(state);
        return Unit.INSTANCE;
    }
}
