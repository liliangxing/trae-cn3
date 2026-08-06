package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/model/TokenUsageByDisplayType;", "", "displayType", "", "estimateIncludedTokens", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getDisplayType", "()Ljava/lang/String;", "getEstimateIncludedTokens", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/trae/im/model/TokenUsageByDisplayType;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokenUsageByDisplayType {

    @SerializedName("display_type")
    private final String displayType;

    @SerializedName("estimate_included_tokens")
    private final Long estimateIncludedTokens;

    /* JADX WARN: Multi-variable type inference failed */
    public TokenUsageByDisplayType() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TokenUsageByDisplayType copy$default(TokenUsageByDisplayType tokenUsageByDisplayType, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenUsageByDisplayType.displayType;
        }
        if ((i & 2) != 0) {
            l = tokenUsageByDisplayType.estimateIncludedTokens;
        }
        return tokenUsageByDisplayType.copy(str, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDisplayType() {
        return this.displayType;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getEstimateIncludedTokens() {
        return this.estimateIncludedTokens;
    }

    public final TokenUsageByDisplayType copy(String displayType, Long estimateIncludedTokens) {
        return new TokenUsageByDisplayType(displayType, estimateIncludedTokens);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenUsageByDisplayType)) {
            return false;
        }
        TokenUsageByDisplayType tokenUsageByDisplayType = (TokenUsageByDisplayType) other;
        return Intrinsics.areEqual(this.displayType, tokenUsageByDisplayType.displayType) && Intrinsics.areEqual(this.estimateIncludedTokens, tokenUsageByDisplayType.estimateIncludedTokens);
    }

    public int hashCode() {
        String str = this.displayType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.estimateIncludedTokens;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "TokenUsageByDisplayType(displayType=" + this.displayType + ", estimateIncludedTokens=" + this.estimateIncludedTokens + ')';
    }

    public TokenUsageByDisplayType(String str, Long l) {
        this.displayType = str;
        this.estimateIncludedTokens = l;
    }

    public /* synthetic */ TokenUsageByDisplayType(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
    }

    public final String getDisplayType() {
        return this.displayType;
    }

    public final Long getEstimateIncludedTokens() {
        return this.estimateIncludedTokens;
    }
}
