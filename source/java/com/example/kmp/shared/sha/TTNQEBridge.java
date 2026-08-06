package com.example.kmp.shared.sha;

import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: TTNQEBridge.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/example/kmp/shared/sha/TTNQEBridge;", "", "<init>", "()V", "register", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/example/kmp/shared/sha/NQEListenerBridge;", WebViewContainer.EVENT_destroy, "getRTTAndThroughput", "Lcom/example/kmp/shared/sha/RTTAndThroughputBridge;", "getPacketLostStats", "Lcom/example/kmp/shared/sha/PacketLostStatsBridge;", "getEffectiveConnectionType", "", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class TTNQEBridge {
    public abstract void destroy();

    public abstract int getEffectiveConnectionType();

    public abstract PacketLostStatsBridge getPacketLostStats();

    public abstract RTTAndThroughputBridge getRTTAndThroughput();

    public abstract void register(NQEListenerBridge listener);
}
