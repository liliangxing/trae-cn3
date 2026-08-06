package coil3.compose.animate;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: AnimatedImagePainter.android.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"coil3/compose/animate/AnimatedImagePainter$animation2CompatCallback$2$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/compose/animate/AnimatedImageListener;", "getListener", "()Lcoil3/compose/animate/AnimatedImageListener;", "setListener", "(Lcoil3/compose/animate/AnimatedImageListener;)V", "onAnimationStart", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationEnd", "onAnimateImageFirstDraw", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnimatedImagePainter$animation2CompatCallback$2$1 extends Animatable2Compat.AnimationCallback {
    private AnimatedImageListener listener;

    public final AnimatedImageListener getListener() {
        return this.listener;
    }

    public final void setListener(AnimatedImageListener animatedImageListener) {
        this.listener = animatedImageListener;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        super.onAnimationStart(drawable);
        AnimatedImageListener animatedImageListener = this.listener;
        if (animatedImageListener != null) {
            animatedImageListener.onAnimateStart();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        AnimatedImageListener animatedImageListener = this.listener;
        if (animatedImageListener != null) {
            animatedImageListener.onAnimateEnd();
        }
    }

    public final void onAnimateImageFirstDraw() {
        AnimatedImageListener animatedImageListener = this.listener;
        if (animatedImageListener != null) {
            animatedImageListener.onAnimateImageFirstDraw();
        }
    }
}
