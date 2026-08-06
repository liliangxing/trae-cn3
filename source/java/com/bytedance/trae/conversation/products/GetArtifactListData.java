package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetArtifactListApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/products/GetArtifactListData;", "", "artifacts", "", "Lcom/bytedance/trae/conversation/products/HubArtifactItem;", "total", "", "<init>", "(Ljava/util/List;I)V", "getArtifacts", "()Ljava/util/List;", "getTotal", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetArtifactListData {

    @SerializedName("artifacts")
    private final List<HubArtifactItem> artifacts;

    @SerializedName("total")
    private final int total;

    /* JADX WARN: Multi-variable type inference failed */
    public GetArtifactListData() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetArtifactListData copy$default(GetArtifactListData getArtifactListData, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getArtifactListData.artifacts;
        }
        if ((i2 & 2) != 0) {
            i = getArtifactListData.total;
        }
        return getArtifactListData.copy(list, i);
    }

    public final List<HubArtifactItem> component1() {
        return this.artifacts;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final GetArtifactListData copy(List<HubArtifactItem> artifacts, int total) {
        return new GetArtifactListData(artifacts, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetArtifactListData)) {
            return false;
        }
        GetArtifactListData getArtifactListData = (GetArtifactListData) other;
        return Intrinsics.areEqual(this.artifacts, getArtifactListData.artifacts) && this.total == getArtifactListData.total;
    }

    public int hashCode() {
        List<HubArtifactItem> list = this.artifacts;
        return ((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "GetArtifactListData(artifacts=" + this.artifacts + ", total=" + this.total + ')';
    }

    public GetArtifactListData(List<HubArtifactItem> list, int i) {
        this.artifacts = list;
        this.total = i;
    }

    public /* synthetic */ GetArtifactListData(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? 0 : i);
    }

    public final List<HubArtifactItem> getArtifacts() {
        return this.artifacts;
    }

    public final int getTotal() {
        return this.total;
    }
}
