package com.bytedance.trae.network.interceptor.config;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeoutConfig.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/network/interceptor/config/TimeoutConfig;", "", "connectTimeoutMs", "", "readTimeoutMs", "writeTimeoutMs", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getConnectTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReadTimeoutMs", "getWriteTimeoutMs", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/network/interceptor/config/TimeoutConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TimeoutConfig {

    @SerializedName("connect_timeout_ms")
    private final Long connectTimeoutMs;

    @SerializedName("read_timeout_ms")
    private final Long readTimeoutMs;

    @SerializedName("write_timeout_ms")
    private final Long writeTimeoutMs;

    public TimeoutConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TimeoutConfig copy$default(TimeoutConfig timeoutConfig, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = timeoutConfig.connectTimeoutMs;
        }
        if ((i & 2) != 0) {
            l2 = timeoutConfig.readTimeoutMs;
        }
        if ((i & 4) != 0) {
            l3 = timeoutConfig.writeTimeoutMs;
        }
        return timeoutConfig.copy(l, l2, l3);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getWriteTimeoutMs() {
        return this.writeTimeoutMs;
    }

    public final TimeoutConfig copy(Long connectTimeoutMs, Long readTimeoutMs, Long writeTimeoutMs) {
        return new TimeoutConfig(connectTimeoutMs, readTimeoutMs, writeTimeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeoutConfig)) {
            return false;
        }
        TimeoutConfig timeoutConfig = (TimeoutConfig) other;
        return Intrinsics.areEqual(this.connectTimeoutMs, timeoutConfig.connectTimeoutMs) && Intrinsics.areEqual(this.readTimeoutMs, timeoutConfig.readTimeoutMs) && Intrinsics.areEqual(this.writeTimeoutMs, timeoutConfig.writeTimeoutMs);
    }

    public int hashCode() {
        Long l = this.connectTimeoutMs;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.readTimeoutMs;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.writeTimeoutMs;
        return hashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "TimeoutConfig(connectTimeoutMs=" + this.connectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", writeTimeoutMs=" + this.writeTimeoutMs + ')';
    }

    public TimeoutConfig(Long l, Long l2, Long l3) {
        this.connectTimeoutMs = l;
        this.readTimeoutMs = l2;
        this.writeTimeoutMs = l3;
    }

    public /* synthetic */ TimeoutConfig(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
    }

    public final Long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final Long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final Long getWriteTimeoutMs() {
        return this.writeTimeoutMs;
    }
}
