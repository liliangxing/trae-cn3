package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HubNetFallbackApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/network/FallbackPushRequest;", "", "frontierId", "", "deviceId", "msgs", "", "Lcom/bytedance/trae/network/WsMessage;", "<init>", "(JJLjava/util/List;)V", "getFrontierId", "()J", "getDeviceId", "getMsgs", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FallbackPushRequest {

    @SerializedName("device_id")
    private final long deviceId;

    @SerializedName("frontier_id")
    private final long frontierId;

    @SerializedName("msgs")
    private final List<WsMessage> msgs;

    public static /* synthetic */ FallbackPushRequest copy$default(FallbackPushRequest fallbackPushRequest, long j, long j2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fallbackPushRequest.frontierId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = fallbackPushRequest.deviceId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            list = fallbackPushRequest.msgs;
        }
        return fallbackPushRequest.copy(j3, j4, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFrontierId() {
        return this.frontierId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDeviceId() {
        return this.deviceId;
    }

    public final List<WsMessage> component3() {
        return this.msgs;
    }

    public final FallbackPushRequest copy(long frontierId, long deviceId, List<WsMessage> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        return new FallbackPushRequest(frontierId, deviceId, msgs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FallbackPushRequest)) {
            return false;
        }
        FallbackPushRequest fallbackPushRequest = (FallbackPushRequest) other;
        return this.frontierId == fallbackPushRequest.frontierId && this.deviceId == fallbackPushRequest.deviceId && Intrinsics.areEqual(this.msgs, fallbackPushRequest.msgs);
    }

    public int hashCode() {
        return (((Long.hashCode(this.frontierId) * 31) + Long.hashCode(this.deviceId)) * 31) + this.msgs.hashCode();
    }

    public String toString() {
        return "FallbackPushRequest(frontierId=" + this.frontierId + ", deviceId=" + this.deviceId + ", msgs=" + this.msgs + ')';
    }

    public FallbackPushRequest(long j, long j2, List<WsMessage> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        this.frontierId = j;
        this.deviceId = j2;
        this.msgs = msgs;
    }

    public final long getFrontierId() {
        return this.frontierId;
    }

    public final long getDeviceId() {
        return this.deviceId;
    }

    public final List<WsMessage> getMsgs() {
        return this.msgs;
    }
}
