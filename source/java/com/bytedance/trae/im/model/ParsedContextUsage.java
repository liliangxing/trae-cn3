package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003HÆ\u0003Jn\u0010%\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedContextUsage;", "", "contexts", "", "Lcom/bytedance/trae/im/model/ParsedContextMeta;", "updatedAt", "", "contextBatchId", "", "contextBatchSeq", "", "chunkIndex", "chunkTotal", "tokenUsageByDisplayType", "Lcom/bytedance/trae/im/model/TokenUsageByDisplayType;", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getContexts", "()Ljava/util/List;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContextBatchId", "()Ljava/lang/String;", "getContextBatchSeq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChunkIndex", "getChunkTotal", "getTokenUsageByDisplayType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/trae/im/model/ParsedContextUsage;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedContextUsage {

    @SerializedName("chunk_index")
    private final Integer chunkIndex;

    @SerializedName("chunk_total")
    private final Integer chunkTotal;

    @SerializedName("context_batch_id")
    private final String contextBatchId;

    @SerializedName("context_batch_seq")
    private final Integer contextBatchSeq;

    @SerializedName("contexts")
    private final List<ParsedContextMeta> contexts;

    @SerializedName("token_usage_by_display_type")
    private final List<TokenUsageByDisplayType> tokenUsageByDisplayType;

    @SerializedName("updated_at")
    private final Long updatedAt;

    public ParsedContextUsage() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ParsedContextUsage copy$default(ParsedContextUsage parsedContextUsage, List list, Long l, String str, Integer num, Integer num2, Integer num3, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = parsedContextUsage.contexts;
        }
        if ((i & 2) != 0) {
            l = parsedContextUsage.updatedAt;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str = parsedContextUsage.contextBatchId;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            num = parsedContextUsage.contextBatchSeq;
        }
        Integer num4 = num;
        if ((i & 16) != 0) {
            num2 = parsedContextUsage.chunkIndex;
        }
        Integer num5 = num2;
        if ((i & 32) != 0) {
            num3 = parsedContextUsage.chunkTotal;
        }
        Integer num6 = num3;
        if ((i & 64) != 0) {
            list2 = parsedContextUsage.tokenUsageByDisplayType;
        }
        return parsedContextUsage.copy(list, l2, str2, num4, num5, num6, list2);
    }

    public final List<ParsedContextMeta> component1() {
        return this.contexts;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContextBatchId() {
        return this.contextBatchId;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getContextBatchSeq() {
        return this.contextBatchSeq;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getChunkIndex() {
        return this.chunkIndex;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getChunkTotal() {
        return this.chunkTotal;
    }

    public final List<TokenUsageByDisplayType> component7() {
        return this.tokenUsageByDisplayType;
    }

    public final ParsedContextUsage copy(List<ParsedContextMeta> contexts, Long updatedAt, String contextBatchId, Integer contextBatchSeq, Integer chunkIndex, Integer chunkTotal, List<TokenUsageByDisplayType> tokenUsageByDisplayType) {
        return new ParsedContextUsage(contexts, updatedAt, contextBatchId, contextBatchSeq, chunkIndex, chunkTotal, tokenUsageByDisplayType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedContextUsage)) {
            return false;
        }
        ParsedContextUsage parsedContextUsage = (ParsedContextUsage) other;
        return Intrinsics.areEqual(this.contexts, parsedContextUsage.contexts) && Intrinsics.areEqual(this.updatedAt, parsedContextUsage.updatedAt) && Intrinsics.areEqual(this.contextBatchId, parsedContextUsage.contextBatchId) && Intrinsics.areEqual(this.contextBatchSeq, parsedContextUsage.contextBatchSeq) && Intrinsics.areEqual(this.chunkIndex, parsedContextUsage.chunkIndex) && Intrinsics.areEqual(this.chunkTotal, parsedContextUsage.chunkTotal) && Intrinsics.areEqual(this.tokenUsageByDisplayType, parsedContextUsage.tokenUsageByDisplayType);
    }

    public int hashCode() {
        List<ParsedContextMeta> list = this.contexts;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Long l = this.updatedAt;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.contextBatchId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.contextBatchSeq;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.chunkIndex;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.chunkTotal;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<TokenUsageByDisplayType> list2 = this.tokenUsageByDisplayType;
        return hashCode6 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "ParsedContextUsage(contexts=" + this.contexts + ", updatedAt=" + this.updatedAt + ", contextBatchId=" + this.contextBatchId + ", contextBatchSeq=" + this.contextBatchSeq + ", chunkIndex=" + this.chunkIndex + ", chunkTotal=" + this.chunkTotal + ", tokenUsageByDisplayType=" + this.tokenUsageByDisplayType + ')';
    }

    public ParsedContextUsage(List<ParsedContextMeta> list, Long l, String str, Integer num, Integer num2, Integer num3, List<TokenUsageByDisplayType> list2) {
        this.contexts = list;
        this.updatedAt = l;
        this.contextBatchId = str;
        this.contextBatchSeq = num;
        this.chunkIndex = num2;
        this.chunkTotal = num3;
        this.tokenUsageByDisplayType = list2;
    }

    public /* synthetic */ ParsedContextUsage(List list, Long l, String str, Integer num, Integer num2, Integer num3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : list2);
    }

    public final List<ParsedContextMeta> getContexts() {
        return this.contexts;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getContextBatchId() {
        return this.contextBatchId;
    }

    public final Integer getContextBatchSeq() {
        return this.contextBatchSeq;
    }

    public final Integer getChunkIndex() {
        return this.chunkIndex;
    }

    public final Integer getChunkTotal() {
        return this.chunkTotal;
    }

    public final List<TokenUsageByDisplayType> getTokenUsageByDisplayType() {
        return this.tokenUsageByDisplayType;
    }
}
