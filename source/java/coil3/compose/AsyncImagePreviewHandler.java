package coil3.compose;

import androidx.webkit.Profile;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImagePreviewHandler;", "", "handle", "Lcoil3/compose/AsyncImagePainter$State;", "imageLoader", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "(Lcoil3/ImageLoader;Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface AsyncImagePreviewHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final AsyncImagePreviewHandler Default = AsyncImagePreviewHandler$Companion$Default$1.INSTANCE;

    Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation);

    /* compiled from: LocalAsyncImagePreviewHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcoil3/compose/AsyncImagePreviewHandler$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Lcoil3/compose/AsyncImagePreviewHandler;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
