package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;", "", "authorizeUrl", "", "authType", AnnieXConstants.FLOW, "metadata", "Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;)V", "getAuthorizeUrl", "()Ljava/lang/String;", "getAuthType", "getFlow", "getMetadata", "()Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class ConnectorOAuthStartResponse {

    @SerializedName("AuthType")
    private final String authType;

    @SerializedName("AuthorizeUrl")
    private final String authorizeUrl;

    @SerializedName("Flow")
    private final String flow;

    @SerializedName("Metadata")
    private final ConnectorOAuthMetadata metadata;

    public ConnectorOAuthStartResponse() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ConnectorOAuthStartResponse copy$default(ConnectorOAuthStartResponse connectorOAuthStartResponse, String str, String str2, String str3, ConnectorOAuthMetadata connectorOAuthMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectorOAuthStartResponse.authorizeUrl;
        }
        if ((i & 2) != 0) {
            str2 = connectorOAuthStartResponse.authType;
        }
        if ((i & 4) != 0) {
            str3 = connectorOAuthStartResponse.flow;
        }
        if ((i & 8) != 0) {
            connectorOAuthMetadata = connectorOAuthStartResponse.metadata;
        }
        return connectorOAuthStartResponse.copy(str, str2, str3, connectorOAuthMetadata);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthorizeUrl() {
        return this.authorizeUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthType() {
        return this.authType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFlow() {
        return this.flow;
    }

    /* renamed from: component4, reason: from getter */
    public final ConnectorOAuthMetadata getMetadata() {
        return this.metadata;
    }

    public final ConnectorOAuthStartResponse copy(String authorizeUrl, String authType, String flow, ConnectorOAuthMetadata metadata) {
        return new ConnectorOAuthStartResponse(authorizeUrl, authType, flow, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectorOAuthStartResponse)) {
            return false;
        }
        ConnectorOAuthStartResponse connectorOAuthStartResponse = (ConnectorOAuthStartResponse) other;
        return Intrinsics.areEqual(this.authorizeUrl, connectorOAuthStartResponse.authorizeUrl) && Intrinsics.areEqual(this.authType, connectorOAuthStartResponse.authType) && Intrinsics.areEqual(this.flow, connectorOAuthStartResponse.flow) && Intrinsics.areEqual(this.metadata, connectorOAuthStartResponse.metadata);
    }

    public int hashCode() {
        String str = this.authorizeUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.flow;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ConnectorOAuthMetadata connectorOAuthMetadata = this.metadata;
        return hashCode3 + (connectorOAuthMetadata != null ? connectorOAuthMetadata.hashCode() : 0);
    }

    public String toString() {
        return "ConnectorOAuthStartResponse(authorizeUrl=" + this.authorizeUrl + ", authType=" + this.authType + ", flow=" + this.flow + ", metadata=" + this.metadata + ')';
    }

    public ConnectorOAuthStartResponse(String str, String str2, String str3, ConnectorOAuthMetadata connectorOAuthMetadata) {
        this.authorizeUrl = str;
        this.authType = str2;
        this.flow = str3;
        this.metadata = connectorOAuthMetadata;
    }

    public /* synthetic */ ConnectorOAuthStartResponse(String str, String str2, String str3, ConnectorOAuthMetadata connectorOAuthMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : connectorOAuthMetadata);
    }

    public final String getAuthorizeUrl() {
        return this.authorizeUrl;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final ConnectorOAuthMetadata getMetadata() {
        return this.metadata;
    }
}
