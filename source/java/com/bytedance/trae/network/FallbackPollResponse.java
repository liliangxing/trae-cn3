package com.bytedance.trae.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HubNetFallbackApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/network/FallbackPollResponse;", "", "msgs", "", "Lcom/bytedance/trae/network/WsMessage;", "<init>", "(Ljava/util/List;)V", "getMsgs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class FallbackPollResponse {

    @SerializedName("msgs")
    private final List<WsMessage> msgs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FallbackPollResponse() {
        this(r0, 1, r0);
        List list = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FallbackPollResponse copy$default(FallbackPollResponse fallbackPollResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fallbackPollResponse.msgs;
        }
        return fallbackPollResponse.copy(list);
    }

    public final List<WsMessage> component1() {
        return this.msgs;
    }

    public final FallbackPollResponse copy(List<WsMessage> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        return new FallbackPollResponse(msgs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FallbackPollResponse) && Intrinsics.areEqual(this.msgs, ((FallbackPollResponse) other).msgs);
    }

    public int hashCode() {
        return this.msgs.hashCode();
    }

    public String toString() {
        return "FallbackPollResponse(msgs=" + this.msgs + ')';
    }

    public FallbackPollResponse(List<WsMessage> list) {
        Intrinsics.checkNotNullParameter(list, "msgs");
        this.msgs = list;
    }

    public /* synthetic */ FallbackPollResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<WsMessage> getMsgs() {
        return this.msgs;
    }
}
