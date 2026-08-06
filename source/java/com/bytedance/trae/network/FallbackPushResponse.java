package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: HubNetFallbackApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/network/FallbackPushResponse;", "", "acceptedLastUpSeqId", "", "<init>", "(J)V", "getAcceptedLastUpSeqId", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FallbackPushResponse {

    @SerializedName("accepted_last_up_seq_id")
    private final long acceptedLastUpSeqId;

    public static /* synthetic */ FallbackPushResponse copy$default(FallbackPushResponse fallbackPushResponse, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fallbackPushResponse.acceptedLastUpSeqId;
        }
        return fallbackPushResponse.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAcceptedLastUpSeqId() {
        return this.acceptedLastUpSeqId;
    }

    public final FallbackPushResponse copy(long acceptedLastUpSeqId) {
        return new FallbackPushResponse(acceptedLastUpSeqId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FallbackPushResponse) && this.acceptedLastUpSeqId == ((FallbackPushResponse) other).acceptedLastUpSeqId;
    }

    public int hashCode() {
        return Long.hashCode(this.acceptedLastUpSeqId);
    }

    public String toString() {
        return "FallbackPushResponse(acceptedLastUpSeqId=" + this.acceptedLastUpSeqId + ')';
    }

    public FallbackPushResponse(long j) {
        this.acceptedLastUpSeqId = j;
    }

    public final long getAcceptedLastUpSeqId() {
        return this.acceptedLastUpSeqId;
    }
}
