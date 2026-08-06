package coil3.compose.animate;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: AnimationController.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/animate/AnimationController;", "Lcoil3/compose/animate/RepeatableAnimation;", "start", "", "stop", "isRunning", "", "setAnimateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/compose/animate/AnimatedImageListener;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AnimationController extends RepeatableAnimation {
    boolean isRunning();

    void setAnimateListener(AnimatedImageListener listener);

    void start();

    void stop();
}
