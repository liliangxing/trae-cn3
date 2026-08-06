package coil3.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import coil3.Image;
import coil3.request.ImageRequest;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aE\u0010\u0007\u001a\u00020\u000225\b\u0004\u0010\b\u001a/\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH\u0087\b¢\u0006\u0002\u0010\u0011\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"LocalAsyncImagePreviewHandler", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil3/compose/AsyncImagePreviewHandler;", "getLocalAsyncImagePreviewHandler$annotations", "()V", "getLocalAsyncImagePreviewHandler", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "AsyncImagePreviewHandler", "image", "Lkotlin/Function2;", "Lcoil3/request/ImageRequest;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "request", "Lkotlin/coroutines/Continuation;", "Lcoil3/Image;", "", "(Lkotlin/jvm/functions/Function2;)Lcoil3/compose/AsyncImagePreviewHandler;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalAsyncImagePreviewHandlerKt {
    private static final ProvidableCompositionLocal<AsyncImagePreviewHandler> LocalAsyncImagePreviewHandler = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: coil3.compose.LocalAsyncImagePreviewHandlerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            AsyncImagePreviewHandler asyncImagePreviewHandler;
            asyncImagePreviewHandler = AsyncImagePreviewHandler.Default;
            return asyncImagePreviewHandler;
        }
    });

    public static /* synthetic */ void getLocalAsyncImagePreviewHandler$annotations() {
    }

    public static final ProvidableCompositionLocal<AsyncImagePreviewHandler> getLocalAsyncImagePreviewHandler() {
        return LocalAsyncImagePreviewHandler;
    }

    public static final AsyncImagePreviewHandler AsyncImagePreviewHandler(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        return new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1(function2);
    }
}
