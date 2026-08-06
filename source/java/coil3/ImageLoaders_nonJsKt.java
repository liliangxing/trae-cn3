package coil3;

import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;

/* compiled from: imageLoaders.nonJs.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"executeBlocking", "Lcoil3/request/ImageResult;", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImageLoaders_nonJsKt {
    public static final ImageResult executeBlocking(ImageLoader imageLoader, ImageRequest imageRequest) {
        return (ImageResult) BuildersKt.runBlocking$default((CoroutineContext) null, new ImageLoaders_nonJsKt$executeBlocking$1(imageLoader, imageRequest, null), 1, (Object) null);
    }
}
