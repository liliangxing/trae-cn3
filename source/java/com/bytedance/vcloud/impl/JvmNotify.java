package com.bytedance.vcloud.impl;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.vcloud.uniplayer.EngineNotifyListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotifyBridge.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/vcloud/impl/JvmNotify;", "Ljava/lang/AutoCloseable;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/vcloud/uniplayer/EngineNotifyListener;", "(Lcom/bytedance/vcloud/uniplayer/EngineNotifyListener;)V", "mListener", "Ljava/lang/ref/WeakReference;", "mainHandler", "Landroid/os/Handler;", "close", "", "nativeNotify", "eId", "", "what", "arg1", "", "arg2", "msg", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class JvmNotify implements AutoCloseable {
    private final WeakReference<EngineNotifyListener> mListener;
    private final Handler mainHandler;

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public JvmNotify(EngineNotifyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mListener = new WeakReference<>(listener);
    }

    private final void nativeNotify(final int eId, final int what, final long arg1, final long arg2, final String msg) {
        final EngineNotifyListener engineNotifyListener = this.mListener.get();
        if (engineNotifyListener == null) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.vcloud.impl.JvmNotify$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EngineNotifyListener.this.notify(eId, what, arg1, arg2, msg);
            }
        });
    }
}
