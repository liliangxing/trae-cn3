package coil3.compose;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.compose.ui.layout.ContentScale;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.CrossfadePainter;
import coil3.request.ErrorResult;
import coil3.request.GlobalLifecycle;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.SuccessResult;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;

/* compiled from: AsyncImagePainter.android.kt */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\u000e\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0000\u001a\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\"\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"validateRequestProperties", "", "request", "Lcoil3/request/ImageRequest;", "applyGlobalLifecycle", "Lcoil3/request/ImageRequest$Builder;", "maybeNewCrossfadePainter", "Lcoil3/compose/internal/CrossfadePainter;", "previous", "Lcoil3/compose/AsyncImagePainter$State;", "current", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "fakeTransitionTarget", "coil3/compose/AsyncImagePainter_androidKt$fakeTransitionTarget$1", "Lcoil3/compose/AsyncImagePainter_androidKt$fakeTransitionTarget$1;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainter_androidKt {
    private static final AsyncImagePainter_androidKt$fakeTransitionTarget$1 fakeTransitionTarget = new TransitionTarget() { // from class: coil3.compose.AsyncImagePainter_androidKt$fakeTransitionTarget$1
        @Override // coil3.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }

        @Override // coil3.transition.TransitionTarget
        public /* bridge */ /* synthetic */ View getView() {
            return (View) m3191getView();
        }

        /* renamed from: getView, reason: collision with other method in class */
        public Void m3191getView() {
            throw new UnsupportedOperationException();
        }
    };

    public static final void validateRequestProperties(ImageRequest imageRequest) {
        if (!(imageRequest.getTarget() == null)) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
        if (!(ImageRequestsKt.getLifecycle(imageRequest) == null)) {
            throw new IllegalArgumentException("request.lifecycle must be null.".toString());
        }
    }

    public static final void applyGlobalLifecycle(ImageRequest.Builder builder) {
        ImageRequestsKt.lifecycle(builder, GlobalLifecycle.INSTANCE);
    }

    public static final CrossfadePainter maybeNewCrossfadePainter(AsyncImagePainter.State state, AsyncImagePainter.State state2, ContentScale contentScale) {
        ErrorResult result;
        if (!(state2 instanceof AsyncImagePainter.State.Success)) {
            if (state2 instanceof AsyncImagePainter.State.Error) {
                result = ((AsyncImagePainter.State.Error) state2).getResult();
            }
            return null;
        }
        result = ((AsyncImagePainter.State.Success) state2).getResult();
        Transition create = ImageRequestsKt.getTransitionFactory(result.getRequest()).create(fakeTransitionTarget, result);
        if (create instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) create;
            return new CrossfadePainter(state instanceof AsyncImagePainter.State.Loading ? state.getPainter() : null, state2.getPainter(), contentScale, crossfadeTransition.getDurationMillis(), ((result instanceof SuccessResult) && ((SuccessResult) result).getIsPlaceholderCached()) ? false : true, crossfadeTransition.getPreferExactIntrinsicSize());
        }
        return null;
    }
}
