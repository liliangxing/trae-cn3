package com.bytedance.lottie;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LottieTaskRunnable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u00050\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lottie/LottieTaskRunnable;", "Ljava/lang/Runnable;", "delegate", "Lcom/bytedance/lottie/ImageAssetDelegateAsync;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/lottie/CompositionReadyListener;", "context", "Landroid/content/Context;", "(Lcom/bytedance/lottie/ImageAssetDelegateAsync;Lcom/bytedance/lottie/CompositionReadyListener;Landroid/content/Context;)V", "weakCtx", "Ljava/lang/ref/WeakReference;", "getWeakCtx", "()Ljava/lang/ref/WeakReference;", "weakDelegate", "kotlin.jvm.PlatformType", "getWeakDelegate", "weakListener", "getWeakListener", "bd-lottie_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public abstract class LottieTaskRunnable implements Runnable {
    private final WeakReference<Context> weakCtx;
    private final WeakReference<ImageAssetDelegateAsync> weakDelegate;
    private final WeakReference<CompositionReadyListener> weakListener;

    public LottieTaskRunnable(ImageAssetDelegateAsync delegate, CompositionReadyListener listener, Context context) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.weakDelegate = new WeakReference<>(delegate);
        this.weakListener = new WeakReference<>(listener);
        this.weakCtx = new WeakReference<>(context);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LottieTaskRunnable(ImageAssetDelegateAsync imageAssetDelegateAsync, CompositionReadyListener compositionReadyListener, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageAssetDelegateAsync, compositionReadyListener, context);
        if ((i & 4) != 0) {
            context = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WeakReference<ImageAssetDelegateAsync> getWeakDelegate() {
        return this.weakDelegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WeakReference<CompositionReadyListener> getWeakListener() {
        return this.weakListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WeakReference<Context> getWeakCtx() {
        return this.weakCtx;
    }
}
