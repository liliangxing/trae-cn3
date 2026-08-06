package com.bytedance.kmp.network.nqe;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NQEListenerManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "", "httpRttMs", "", "transportRttMs", "downstreamKbps", "(III)V", "getDownstreamKbps", "()I", "getHttpRttMs", "getTransportRttMs", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RttAndThroughput {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RttAndThroughput INVALID = new RttAndThroughput(0, 0, 0, 7, null);
    private final int downstreamKbps;
    private final int httpRttMs;
    private final int transportRttMs;

    public RttAndThroughput() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ RttAndThroughput copy$default(RttAndThroughput rttAndThroughput, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rttAndThroughput.httpRttMs;
        }
        if ((i4 & 2) != 0) {
            i2 = rttAndThroughput.transportRttMs;
        }
        if ((i4 & 4) != 0) {
            i3 = rttAndThroughput.downstreamKbps;
        }
        return rttAndThroughput.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHttpRttMs() {
        return this.httpRttMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTransportRttMs() {
        return this.transportRttMs;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDownstreamKbps() {
        return this.downstreamKbps;
    }

    public final RttAndThroughput copy(int httpRttMs, int transportRttMs, int downstreamKbps) {
        return new RttAndThroughput(httpRttMs, transportRttMs, downstreamKbps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RttAndThroughput)) {
            return false;
        }
        RttAndThroughput rttAndThroughput = (RttAndThroughput) other;
        return this.httpRttMs == rttAndThroughput.httpRttMs && this.transportRttMs == rttAndThroughput.transportRttMs && this.downstreamKbps == rttAndThroughput.downstreamKbps;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.httpRttMs) * 31) + Integer.hashCode(this.transportRttMs)) * 31) + Integer.hashCode(this.downstreamKbps);
    }

    public String toString() {
        return "RttAndThroughput(httpRttMs=" + this.httpRttMs + ", transportRttMs=" + this.transportRttMs + ", downstreamKbps=" + this.downstreamKbps + ')';
    }

    public RttAndThroughput(int i, int i2, int i3) {
        this.httpRttMs = i;
        this.transportRttMs = i2;
        this.downstreamKbps = i3;
    }

    public /* synthetic */ RttAndThroughput(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? -1 : i2, (i4 & 4) != 0 ? -1 : i3);
    }

    public final int getHttpRttMs() {
        return this.httpRttMs;
    }

    public final int getTransportRttMs() {
        return this.transportRttMs;
    }

    public final int getDownstreamKbps() {
        return this.downstreamKbps;
    }

    /* compiled from: NQEListenerManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/nqe/RttAndThroughput$Companion;", "", "()V", "INVALID", "Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "getINVALID", "()Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RttAndThroughput getINVALID() {
            return RttAndThroughput.INVALID;
        }
    }
}
