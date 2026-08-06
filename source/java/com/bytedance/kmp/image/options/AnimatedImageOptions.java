package com.bytedance.kmp.image.options;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedImageOptions.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/kmp/image/options/AnimatedImageOptions;", "", "()V", "animationListener", "Lcom/bytedance/kmp/image/options/ImageAnimationListener;", "getAnimationListener", "()Lcom/bytedance/kmp/image/options/ImageAnimationListener;", "setAnimationListener", "(Lcom/bytedance/kmp/image/options/ImageAnimationListener;)V", "onControllerReady", "Lkotlin/Function1;", "Lcom/bytedance/kmp/image/options/ImageAnimationController;", "", "getOnControllerReady$kmpimage_release", "()Lkotlin/jvm/functions/Function1;", "setOnControllerReady$kmpimage_release", "(Lkotlin/jvm/functions/Function1;)V", "block", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedImageOptions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ImageAnimationListener animationListener;
    private Function1<? super ImageAnimationController, Unit> onControllerReady;

    public /* synthetic */ AnimatedImageOptions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AnimatedImageOptions() {
        this.onControllerReady = new Function1<ImageAnimationController, Unit>() { // from class: com.bytedance.kmp.image.options.AnimatedImageOptions$onControllerReady$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageAnimationController it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImageAnimationController imageAnimationController) {
                invoke2(imageAnimationController);
                return Unit.INSTANCE;
            }
        };
    }

    public final ImageAnimationListener getAnimationListener() {
        return this.animationListener;
    }

    public final void setAnimationListener(ImageAnimationListener imageAnimationListener) {
        this.animationListener = imageAnimationListener;
    }

    public final Function1<ImageAnimationController, Unit> getOnControllerReady$kmpimage_release() {
        return this.onControllerReady;
    }

    public final void setOnControllerReady$kmpimage_release(Function1<? super ImageAnimationController, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onControllerReady = function1;
    }

    public final AnimatedImageOptions setListener(ImageAnimationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animationListener = listener;
        return this;
    }

    public final AnimatedImageOptions onControllerReady(Function1<? super ImageAnimationController, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onControllerReady = block;
        return this;
    }

    /* compiled from: AnimatedImageOptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/image/options/AnimatedImageOptions$Companion;", "", "()V", "newInstance", "Lcom/bytedance/kmp/image/options/AnimatedImageOptions;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimatedImageOptions newInstance() {
            return new AnimatedImageOptions(null);
        }
    }
}
