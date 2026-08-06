package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/ListConnectorConnectionsRequest;", "", "providers", "", "", "<init>", "(Ljava/util/List;)V", "getProviders", "()Ljava/util/List;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class ListConnectorConnectionsRequest {

    @SerializedName("Providers")
    private final List<String> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListConnectorConnectionsRequest copy$default(ListConnectorConnectionsRequest listConnectorConnectionsRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listConnectorConnectionsRequest.providers;
        }
        return listConnectorConnectionsRequest.copy(list);
    }

    public final List<String> component1() {
        return this.providers;
    }

    public final ListConnectorConnectionsRequest copy(List<String> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        return new ListConnectorConnectionsRequest(providers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListConnectorConnectionsRequest) && Intrinsics.areEqual(this.providers, ((ListConnectorConnectionsRequest) other).providers);
    }

    public int hashCode() {
        return this.providers.hashCode();
    }

    public String toString() {
        return "ListConnectorConnectionsRequest(providers=" + this.providers + ')';
    }

    public ListConnectorConnectionsRequest(List<String> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.providers = providers;
    }

    public final List<String> getProviders() {
        return this.providers;
    }
}
