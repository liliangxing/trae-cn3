package com.bytedance.kmp.network.wschannel;

import kotlin.Metadata;

/* compiled from: IWsEventListener.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/ConnectionState;", "", "state", "", "(I)V", "CONNECTED", "getCONNECTED", "()I", "CONNECTING", "getCONNECTING", "CONNECTION_UNKNOWN", "getCONNECTION_UNKNOWN", "CONNECT_CLOSED", "getCONNECT_CLOSED", "CONNECT_FAILED", "getCONNECT_FAILED", "DISCONNECTING", "getDISCONNECTING", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionState {
    private final int CONNECTION_UNKNOWN = 1;
    private final int CONNECTING = 2;
    private final int CONNECT_FAILED = 4;
    private final int CONNECT_CLOSED = 8;
    private final int CONNECTED = 16;
    private final int DISCONNECTING = 32;

    public ConnectionState(int i) {
    }

    public final int getCONNECTION_UNKNOWN() {
        return this.CONNECTION_UNKNOWN;
    }

    public final int getCONNECTING() {
        return this.CONNECTING;
    }

    public final int getCONNECT_FAILED() {
        return this.CONNECT_FAILED;
    }

    public final int getCONNECT_CLOSED() {
        return this.CONNECT_CLOSED;
    }

    public final int getCONNECTED() {
        return this.CONNECTED;
    }

    public final int getDISCONNECTING() {
        return this.DISCONNECTING;
    }
}
