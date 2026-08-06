package com.bytedance.kmp.image.painter;

import com.bytedance.kmp.image.options.ImageAnimationController;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeFrescoControllerListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/image/painter/AndroidDrawableImageAnimationController;", "Lcom/bytedance/kmp/image/options/ImageAnimationController;", "animatedDrawable2", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "(Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;)V", "getAnimatedDrawable2", "()Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "isRunning", "", "jumpToFrame", "", "frameIndex", "", "pause", "setRepeatCount", "count", TraeAuthManager.STAGE_START, "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidDrawableImageAnimationController implements ImageAnimationController {
    public static final int $stable = 8;
    private final AnimatedDrawable2 animatedDrawable2;

    public AndroidDrawableImageAnimationController(AnimatedDrawable2 animatedDrawable2) {
        Intrinsics.checkNotNullParameter(animatedDrawable2, "animatedDrawable2");
        this.animatedDrawable2 = animatedDrawable2;
    }

    public final AnimatedDrawable2 getAnimatedDrawable2() {
        return this.animatedDrawable2;
    }

    @Override // com.bytedance.kmp.image.options.ImageAnimationController
    public void start() {
        this.animatedDrawable2.start();
    }

    @Override // com.bytedance.kmp.image.options.ImageAnimationController
    public void pause() {
        this.animatedDrawable2.pause();
    }

    @Override // com.bytedance.kmp.image.options.ImageAnimationController
    public boolean isRunning() {
        return this.animatedDrawable2.isRunning();
    }

    @Override // com.bytedance.kmp.image.options.ImageAnimationController
    public void setRepeatCount(int count) {
        if (count == -1) {
            this.animatedDrawable2.setLoopCount(0);
        } else {
            this.animatedDrawable2.setLoopCount(count);
        }
    }

    @Override // com.bytedance.kmp.image.options.ImageAnimationController
    public void jumpToFrame(int frameIndex) {
        this.animatedDrawable2.jumpToFrame(frameIndex);
    }
}
