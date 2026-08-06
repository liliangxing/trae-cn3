package coil3;

import coil3.intercept.Interceptor;
import coil3.intercept.RealInterceptorChain;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.List;
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
/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.RealImageLoader$execute$result$1", f = "RealImageLoader.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RealImageLoader$execute$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    final /* synthetic */ Image $cachedPlaceholder;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ Size $size;
    final /* synthetic */ SizeResolver $sizeResolver;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(ImageRequest imageRequest, RealImageLoader realImageLoader, Size size, SizeResolver sizeResolver, EventListener eventListener, Image image, Continuation<? super RealImageLoader$execute$result$1> continuation) {
        super(2, continuation);
        this.$request = imageRequest;
        this.this$0 = realImageLoader;
        this.$size = size;
        this.$sizeResolver = sizeResolver;
        this.$eventListener = eventListener;
        this.$cachedPlaceholder = image;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, this.$sizeResolver, this.$eventListener, this.$cachedPlaceholder, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageRequest imageRequest = this.$request;
            List<Interceptor> interceptors = this.this$0.getComponents().getInterceptors();
            ImageRequest imageRequest2 = this.$request;
            Size size = this.$size;
            SizeResolver sizeResolver = this.$sizeResolver;
            EventListener eventListener = this.$eventListener;
            boolean z = this.$cachedPlaceholder != null;
            this.label = 1;
            obj = new RealInterceptorChain(imageRequest, interceptors, 0, imageRequest2, size, sizeResolver, eventListener, z).proceed((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
