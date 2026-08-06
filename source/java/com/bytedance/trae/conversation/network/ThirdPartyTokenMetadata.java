package com.bytedance.trae.conversation.network;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;", "", "requestId", "", StrategyConstants.ACTION, "error", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;)V", "getRequestId", "()Ljava/lang/String;", "getAction", "getError", "()Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThirdPartyTokenMetadata {

    @SerializedName("Action")
    private final String action;

    @SerializedName("Error")
    private final ThirdPartyTokenMetaError error;

    @SerializedName("RequestId")
    private final String requestId;

    public ThirdPartyTokenMetadata() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ThirdPartyTokenMetadata copy$default(ThirdPartyTokenMetadata thirdPartyTokenMetadata, String str, String str2, ThirdPartyTokenMetaError thirdPartyTokenMetaError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdPartyTokenMetadata.requestId;
        }
        if ((i & 2) != 0) {
            str2 = thirdPartyTokenMetadata.action;
        }
        if ((i & 4) != 0) {
            thirdPartyTokenMetaError = thirdPartyTokenMetadata.error;
        }
        return thirdPartyTokenMetadata.copy(str, str2, thirdPartyTokenMetaError);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final ThirdPartyTokenMetaError getError() {
        return this.error;
    }

    public final ThirdPartyTokenMetadata copy(String requestId, String action, ThirdPartyTokenMetaError error) {
        return new ThirdPartyTokenMetadata(requestId, action, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartyTokenMetadata)) {
            return false;
        }
        ThirdPartyTokenMetadata thirdPartyTokenMetadata = (ThirdPartyTokenMetadata) other;
        return Intrinsics.areEqual(this.requestId, thirdPartyTokenMetadata.requestId) && Intrinsics.areEqual(this.action, thirdPartyTokenMetadata.action) && Intrinsics.areEqual(this.error, thirdPartyTokenMetadata.error);
    }

    public int hashCode() {
        String str = this.requestId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ThirdPartyTokenMetaError thirdPartyTokenMetaError = this.error;
        return hashCode2 + (thirdPartyTokenMetaError != null ? thirdPartyTokenMetaError.hashCode() : 0);
    }

    public String toString() {
        return "ThirdPartyTokenMetadata(requestId=" + this.requestId + ", action=" + this.action + ", error=" + this.error + ')';
    }

    public ThirdPartyTokenMetadata(String str, String str2, ThirdPartyTokenMetaError thirdPartyTokenMetaError) {
        this.requestId = str;
        this.action = str2;
        this.error = thirdPartyTokenMetaError;
    }

    public /* synthetic */ ThirdPartyTokenMetadata(String str, String str2, ThirdPartyTokenMetaError thirdPartyTokenMetaError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : thirdPartyTokenMetaError);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getAction() {
        return this.action;
    }

    public final ThirdPartyTokenMetaError getError() {
        return this.error;
    }
}
