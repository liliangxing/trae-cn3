package com.bytedance.vcloud.uniplayer;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: UniAvExtraListener.kt */
@Deprecated(message = "Deprecated. Will be removed in a future release.")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAvExtraListener;", "", "()V", "playLoopListener", "Lcom/bytedance/vcloud/uniplayer/PlayLoopListener;", "getPlayLoopListener$uniplayer_release", "()Lcom/bytedance/vcloud/uniplayer/PlayLoopListener;", "setPlayLoopListener$uniplayer_release", "(Lcom/bytedance/vcloud/uniplayer/PlayLoopListener;)V", "setPlayLoopListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniAvExtraListener {
    private PlayLoopListener playLoopListener;

    /* renamed from: getPlayLoopListener$uniplayer_release, reason: from getter */
    public final PlayLoopListener getPlayLoopListener() {
        return this.playLoopListener;
    }

    public final void setPlayLoopListener$uniplayer_release(PlayLoopListener playLoopListener) {
        this.playLoopListener = playLoopListener;
    }

    @Deprecated(message = "Deprecated. Will be removed in a future release.")
    public final void setPlayLoopListener(PlayLoopListener listener) {
        this.playLoopListener = listener;
    }
}
