package com.bytedance.ies.bullet.deprecate.fake;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerBid.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/deprecate/fake/ContainerBidParam;", "", "bid", "", "(Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ContainerBidParam {
    private final String bid;

    public static /* synthetic */ ContainerBidParam copy$default(ContainerBidParam containerBidParam, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = containerBidParam.bid;
        }
        return containerBidParam.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    public final ContainerBidParam copy(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        return new ContainerBidParam(bid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContainerBidParam) && Intrinsics.areEqual(this.bid, ((ContainerBidParam) other).bid);
    }

    public int hashCode() {
        return this.bid.hashCode();
    }

    public String toString() {
        return "ContainerBidParam(bid=" + this.bid + ')';
    }

    public ContainerBidParam(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.bid = bid;
    }

    public final String getBid() {
        return this.bid;
    }
}
