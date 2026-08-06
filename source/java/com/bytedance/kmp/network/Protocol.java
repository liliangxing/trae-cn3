package com.bytedance.kmp.network;

import com.bytedance.sdk.xbridge.cn.websocket.utils.TTNetWebSocketUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Protocol.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/network/Protocol;", "", MonitorConstants.PROTOCOL, "", "(Ljava/lang/String;ILjava/lang/String;)V", "UNKNOWN", "HTTP_0_9", "HTTP_1_0", "HTTP_1_1", "HTTP_2", "QUIC", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum Protocol {
    UNKNOWN("unknown"),
    HTTP_0_9("http/0.9"),
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    HTTP_2("http/2"),
    QUIC(TTNetWebSocketUtil.TRANSPORT_PROTOCOL_QUIC);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    /* compiled from: Protocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/Protocol$Companion;", "", "()V", "from", "Lcom/bytedance/kmp/network/Protocol;", MonitorConstants.PROTOCOL, "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Protocol from(String protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            for (Protocol protocol2 : Protocol.values()) {
                if (Intrinsics.areEqual(protocol2.protocol, protocol)) {
                    return protocol2;
                }
            }
            return null;
        }
    }
}
