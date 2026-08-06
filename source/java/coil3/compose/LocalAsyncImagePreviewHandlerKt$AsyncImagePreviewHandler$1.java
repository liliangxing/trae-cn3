package coil3.compose;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1 implements AsyncImagePreviewHandler {
    final /* synthetic */ Function2<ImageRequest, Continuation<? super Image>, Object> $image;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        this.$image = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil3.compose.AsyncImagePreviewHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        C0715x373603fc c0715x373603fc;
        int i;
        if (continuation instanceof C0715x373603fc) {
            c0715x373603fc = (C0715x373603fc) continuation;
            if ((c0715x373603fc.label & Integer.MIN_VALUE) != 0) {
                c0715x373603fc.label -= Integer.MIN_VALUE;
                Object obj = c0715x373603fc.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0715x373603fc.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<ImageRequest, Continuation<? super Image>, Object> function2 = this.$image;
                    c0715x373603fc.L$0 = imageRequest;
                    c0715x373603fc.label = 1;
                    obj = function2.invoke(imageRequest, c0715x373603fc);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    imageRequest = (ImageRequest) c0715x373603fc.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Image image = (Image) obj;
                return new AsyncImagePainter.State.Loading(image == null ? ImagePainter_androidKt.m3194asPainterwIOrVNA(image, imageRequest.getContext(), DrawScope.Companion.getDefaultFilterQuality-f-v9h1I(), imageRequest.getFetcherCoroutineContext()) : null);
            }
        }
        c0715x373603fc = new C0715x373603fc(this, continuation);
        Object obj2 = c0715x373603fc.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0715x373603fc.label;
        if (i != 0) {
        }
        Image image2 = (Image) obj2;
        return new AsyncImagePainter.State.Loading(image2 == null ? ImagePainter_androidKt.m3194asPainterwIOrVNA(image2, imageRequest.getContext(), DrawScope.Companion.getDefaultFilterQuality-f-v9h1I(), imageRequest.getFetcherCoroutineContext()) : null);
    }

    public final Object handle$$forInline(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        InlineMarker.mark(4);
        new C0715x373603fc(this, continuation);
        InlineMarker.mark(5);
        Image image = (Image) this.$image.invoke(imageRequest, continuation);
        return new AsyncImagePainter.State.Loading(image != null ? ImagePainter_androidKt.m3194asPainterwIOrVNA(image, imageRequest.getContext(), DrawScope.Companion.getDefaultFilterQuality-f-v9h1I(), imageRequest.getFetcherCoroutineContext()) : null);
    }
}
