package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;", "", "responseMetadata", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;", "result", "", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;", "<init>", "(Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;Ljava/util/List;)V", "getResponseMetadata", "()Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;", "getResult", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThirdPartyTokenEnvelope {

    @SerializedName("ResponseMetadata")
    private final ThirdPartyTokenMetadata responseMetadata;

    @SerializedName("Result")
    private final List<ThirdPartyTokenResult> result;

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyTokenEnvelope() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThirdPartyTokenEnvelope copy$default(ThirdPartyTokenEnvelope thirdPartyTokenEnvelope, ThirdPartyTokenMetadata thirdPartyTokenMetadata, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            thirdPartyTokenMetadata = thirdPartyTokenEnvelope.responseMetadata;
        }
        if ((i & 2) != 0) {
            list = thirdPartyTokenEnvelope.result;
        }
        return thirdPartyTokenEnvelope.copy(thirdPartyTokenMetadata, list);
    }

    /* renamed from: component1, reason: from getter */
    public final ThirdPartyTokenMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public final List<ThirdPartyTokenResult> component2() {
        return this.result;
    }

    public final ThirdPartyTokenEnvelope copy(ThirdPartyTokenMetadata responseMetadata, List<ThirdPartyTokenResult> result) {
        return new ThirdPartyTokenEnvelope(responseMetadata, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartyTokenEnvelope)) {
            return false;
        }
        ThirdPartyTokenEnvelope thirdPartyTokenEnvelope = (ThirdPartyTokenEnvelope) other;
        return Intrinsics.areEqual(this.responseMetadata, thirdPartyTokenEnvelope.responseMetadata) && Intrinsics.areEqual(this.result, thirdPartyTokenEnvelope.result);
    }

    public int hashCode() {
        ThirdPartyTokenMetadata thirdPartyTokenMetadata = this.responseMetadata;
        int hashCode = (thirdPartyTokenMetadata == null ? 0 : thirdPartyTokenMetadata.hashCode()) * 31;
        List<ThirdPartyTokenResult> list = this.result;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ThirdPartyTokenEnvelope(responseMetadata=" + this.responseMetadata + ", result=" + this.result + ')';
    }

    public ThirdPartyTokenEnvelope(ThirdPartyTokenMetadata thirdPartyTokenMetadata, List<ThirdPartyTokenResult> list) {
        this.responseMetadata = thirdPartyTokenMetadata;
        this.result = list;
    }

    public /* synthetic */ ThirdPartyTokenEnvelope(ThirdPartyTokenMetadata thirdPartyTokenMetadata, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : thirdPartyTokenMetadata, (i & 2) != 0 ? null : list);
    }

    public final ThirdPartyTokenMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public final List<ThirdPartyTokenResult> getResult() {
        return this.result;
    }
}
