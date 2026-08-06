package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;", "", "qrcodeUrl", "", "transactionId", "expireAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQrcodeUrl", "()Ljava/lang/String;", "getTransactionId", "getExpireAt", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConnectorOAuthMetadata {

    @SerializedName("expire_at")
    private final String expireAt;

    @SerializedName("qrcode_url")
    private final String qrcodeUrl;

    @SerializedName(CommonCode.MapKey.TRANSACTION_ID)
    private final String transactionId;

    public ConnectorOAuthMetadata() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ConnectorOAuthMetadata copy$default(ConnectorOAuthMetadata connectorOAuthMetadata, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectorOAuthMetadata.qrcodeUrl;
        }
        if ((i & 2) != 0) {
            str2 = connectorOAuthMetadata.transactionId;
        }
        if ((i & 4) != 0) {
            str3 = connectorOAuthMetadata.expireAt;
        }
        return connectorOAuthMetadata.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQrcodeUrl() {
        return this.qrcodeUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpireAt() {
        return this.expireAt;
    }

    public final ConnectorOAuthMetadata copy(String qrcodeUrl, String transactionId, String expireAt) {
        return new ConnectorOAuthMetadata(qrcodeUrl, transactionId, expireAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectorOAuthMetadata)) {
            return false;
        }
        ConnectorOAuthMetadata connectorOAuthMetadata = (ConnectorOAuthMetadata) other;
        return Intrinsics.areEqual(this.qrcodeUrl, connectorOAuthMetadata.qrcodeUrl) && Intrinsics.areEqual(this.transactionId, connectorOAuthMetadata.transactionId) && Intrinsics.areEqual(this.expireAt, connectorOAuthMetadata.expireAt);
    }

    public int hashCode() {
        String str = this.qrcodeUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.transactionId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expireAt;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ConnectorOAuthMetadata(qrcodeUrl=" + this.qrcodeUrl + ", transactionId=" + this.transactionId + ", expireAt=" + this.expireAt + ')';
    }

    public ConnectorOAuthMetadata(String str, String str2, String str3) {
        this.qrcodeUrl = str;
        this.transactionId = str2;
        this.expireAt = str3;
    }

    public /* synthetic */ ConnectorOAuthMetadata(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getQrcodeUrl() {
        return this.qrcodeUrl;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getExpireAt() {
        return this.expireAt;
    }
}
