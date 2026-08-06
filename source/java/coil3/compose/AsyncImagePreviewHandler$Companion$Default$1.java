package coil3.compose;

import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AsyncImagePreviewHandler$Companion$Default$1 implements AsyncImagePreviewHandler {
    public static final AsyncImagePreviewHandler$Companion$Default$1 INSTANCE = new AsyncImagePreviewHandler$Companion$Default$1();

    AsyncImagePreviewHandler$Companion$Default$1() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil3.compose.AsyncImagePreviewHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        AsyncImagePreviewHandler$Companion$Default$1$handle$1 asyncImagePreviewHandler$Companion$Default$1$handle$1;
        int i;
        ImageResult imageResult;
        if (continuation instanceof AsyncImagePreviewHandler$Companion$Default$1$handle$1) {
            asyncImagePreviewHandler$Companion$Default$1$handle$1 = (AsyncImagePreviewHandler$Companion$Default$1$handle$1) continuation;
            if ((asyncImagePreviewHandler$Companion$Default$1$handle$1.label & Integer.MIN_VALUE) != 0) {
                asyncImagePreviewHandler$Companion$Default$1$handle$1.label -= Integer.MIN_VALUE;
                Object obj = asyncImagePreviewHandler$Companion$Default$1$handle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = asyncImagePreviewHandler$Companion$Default$1$handle$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    asyncImagePreviewHandler$Companion$Default$1$handle$1.L$0 = imageRequest;
                    asyncImagePreviewHandler$Companion$Default$1$handle$1.label = 1;
                    obj = imageLoader.execute(imageRequest, asyncImagePreviewHandler$Companion$Default$1$handle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    imageRequest = (ImageRequest) asyncImagePreviewHandler$Companion$Default$1$handle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                imageResult = (ImageResult) obj;
                if (!(imageResult instanceof SuccessResult)) {
                    SuccessResult successResult = (SuccessResult) imageResult;
                    return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m3195asPainterwIOrVNA$default(successResult.getImage(), imageRequest.getContext(), 0, imageRequest.getFetcherCoroutineContext(), 2, null), successResult);
                }
                if (!(imageResult instanceof ErrorResult)) {
                    throw new NoWhenBranchMatchedException();
                }
                ErrorResult errorResult = (ErrorResult) imageResult;
                Image image = errorResult.getImage();
                return new AsyncImagePainter.State.Error(image != null ? ImagePainter_androidKt.m3195asPainterwIOrVNA$default(image, imageRequest.getContext(), 0, imageRequest.getFetcherCoroutineContext(), 2, null) : null, errorResult);
            }
        }
        asyncImagePreviewHandler$Companion$Default$1$handle$1 = new AsyncImagePreviewHandler$Companion$Default$1$handle$1(this, continuation);
        Object obj2 = asyncImagePreviewHandler$Companion$Default$1$handle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncImagePreviewHandler$Companion$Default$1$handle$1.label;
        if (i != 0) {
        }
        imageResult = (ImageResult) obj2;
        if (!(imageResult instanceof SuccessResult)) {
        }
    }
}
