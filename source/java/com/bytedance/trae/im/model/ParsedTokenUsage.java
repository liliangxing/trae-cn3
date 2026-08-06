package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u009e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016¨\u00065"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "", "input", "", BridgeDataConverterHolder.TYPE_OUTPUT, "lastTurnTotalTokens", "", "maxTokens", "completionTokens", "promptTokens", "reasoningTokens", "totalTokens", "cacheCreationInputTokens", "cacheReadInputTokens", "promptTokensTotal", "completionTokensTotal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getInput", "()Ljava/lang/String;", "getOutput", "getLastTurnTotalTokens", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxTokens", "getCompletionTokens", "getPromptTokens", "getReasoningTokens", "getTotalTokens", "getCacheCreationInputTokens", "getCacheReadInputTokens", "getPromptTokensTotal", "getCompletionTokensTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedTokenUsage {

    @SerializedName("cache_creation_input_tokens")
    private final Long cacheCreationInputTokens;

    @SerializedName("cache_read_input_tokens")
    private final Long cacheReadInputTokens;

    @SerializedName("completion_tokens")
    private final Long completionTokens;

    @SerializedName("completion_tokens_total")
    private final Long completionTokensTotal;

    @SerializedName("input")
    private final String input;

    @SerializedName("last_turn_total_tokens")
    private final Long lastTurnTotalTokens;

    @SerializedName("max_tokens")
    private final Long maxTokens;

    @SerializedName(BridgeDataConverterHolder.TYPE_OUTPUT)
    private final String output;

    @SerializedName("prompt_tokens")
    private final Long promptTokens;

    @SerializedName("prompt_tokens_total")
    private final Long promptTokensTotal;

    @SerializedName("reasoning_tokens")
    private final Long reasoningTokens;

    @SerializedName("total_tokens")
    private final Long totalTokens;

    public ParsedTokenUsage() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getCacheReadInputTokens() {
        return this.cacheReadInputTokens;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getPromptTokensTotal() {
        return this.promptTokensTotal;
    }

    /* renamed from: component12, reason: from getter */
    public final Long getCompletionTokensTotal() {
        return this.completionTokensTotal;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOutput() {
        return this.output;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getLastTurnTotalTokens() {
        return this.lastTurnTotalTokens;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getMaxTokens() {
        return this.maxTokens;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getCompletionTokens() {
        return this.completionTokens;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getPromptTokens() {
        return this.promptTokens;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getReasoningTokens() {
        return this.reasoningTokens;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getTotalTokens() {
        return this.totalTokens;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getCacheCreationInputTokens() {
        return this.cacheCreationInputTokens;
    }

    public final ParsedTokenUsage copy(String input, String output, Long lastTurnTotalTokens, Long maxTokens, Long completionTokens, Long promptTokens, Long reasoningTokens, Long totalTokens, Long cacheCreationInputTokens, Long cacheReadInputTokens, Long promptTokensTotal, Long completionTokensTotal) {
        return new ParsedTokenUsage(input, output, lastTurnTotalTokens, maxTokens, completionTokens, promptTokens, reasoningTokens, totalTokens, cacheCreationInputTokens, cacheReadInputTokens, promptTokensTotal, completionTokensTotal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedTokenUsage)) {
            return false;
        }
        ParsedTokenUsage parsedTokenUsage = (ParsedTokenUsage) other;
        return Intrinsics.areEqual(this.input, parsedTokenUsage.input) && Intrinsics.areEqual(this.output, parsedTokenUsage.output) && Intrinsics.areEqual(this.lastTurnTotalTokens, parsedTokenUsage.lastTurnTotalTokens) && Intrinsics.areEqual(this.maxTokens, parsedTokenUsage.maxTokens) && Intrinsics.areEqual(this.completionTokens, parsedTokenUsage.completionTokens) && Intrinsics.areEqual(this.promptTokens, parsedTokenUsage.promptTokens) && Intrinsics.areEqual(this.reasoningTokens, parsedTokenUsage.reasoningTokens) && Intrinsics.areEqual(this.totalTokens, parsedTokenUsage.totalTokens) && Intrinsics.areEqual(this.cacheCreationInputTokens, parsedTokenUsage.cacheCreationInputTokens) && Intrinsics.areEqual(this.cacheReadInputTokens, parsedTokenUsage.cacheReadInputTokens) && Intrinsics.areEqual(this.promptTokensTotal, parsedTokenUsage.promptTokensTotal) && Intrinsics.areEqual(this.completionTokensTotal, parsedTokenUsage.completionTokensTotal);
    }

    public int hashCode() {
        String str = this.input;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.output;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.lastTurnTotalTokens;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.maxTokens;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.completionTokens;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.promptTokens;
        int hashCode6 = (hashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.reasoningTokens;
        int hashCode7 = (hashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.totalTokens;
        int hashCode8 = (hashCode7 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.cacheCreationInputTokens;
        int hashCode9 = (hashCode8 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Long l8 = this.cacheReadInputTokens;
        int hashCode10 = (hashCode9 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.promptTokensTotal;
        int hashCode11 = (hashCode10 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.completionTokensTotal;
        return hashCode11 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParsedTokenUsage(input=");
        sb.append(this.input).append(", output=").append(this.output).append(", lastTurnTotalTokens=").append(this.lastTurnTotalTokens).append(", maxTokens=").append(this.maxTokens).append(", completionTokens=").append(this.completionTokens).append(", promptTokens=").append(this.promptTokens).append(", reasoningTokens=").append(this.reasoningTokens).append(", totalTokens=").append(this.totalTokens).append(", cacheCreationInputTokens=").append(this.cacheCreationInputTokens).append(", cacheReadInputTokens=").append(this.cacheReadInputTokens).append(", promptTokensTotal=").append(this.promptTokensTotal).append(", completionTokensTotal=");
        sb.append(this.completionTokensTotal).append(')');
        return sb.toString();
    }

    public ParsedTokenUsage(String str, String str2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Long l10) {
        this.input = str;
        this.output = str2;
        this.lastTurnTotalTokens = l;
        this.maxTokens = l2;
        this.completionTokens = l3;
        this.promptTokens = l4;
        this.reasoningTokens = l5;
        this.totalTokens = l6;
        this.cacheCreationInputTokens = l7;
        this.cacheReadInputTokens = l8;
        this.promptTokensTotal = l9;
        this.completionTokensTotal = l10;
    }

    public /* synthetic */ ParsedTokenUsage(String str, String str2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Long l10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4, (i & 64) != 0 ? null : l5, (i & 128) != 0 ? null : l6, (i & 256) != 0 ? null : l7, (i & 512) != 0 ? null : l8, (i & 1024) != 0 ? null : l9, (i & 2048) == 0 ? l10 : null);
    }

    public final String getInput() {
        return this.input;
    }

    public final String getOutput() {
        return this.output;
    }

    public final Long getLastTurnTotalTokens() {
        return this.lastTurnTotalTokens;
    }

    public final Long getMaxTokens() {
        return this.maxTokens;
    }

    public final Long getCompletionTokens() {
        return this.completionTokens;
    }

    public final Long getPromptTokens() {
        return this.promptTokens;
    }

    public final Long getReasoningTokens() {
        return this.reasoningTokens;
    }

    public final Long getTotalTokens() {
        return this.totalTokens;
    }

    public final Long getCacheCreationInputTokens() {
        return this.cacheCreationInputTokens;
    }

    public final Long getCacheReadInputTokens() {
        return this.cacheReadInputTokens;
    }

    public final Long getPromptTokensTotal() {
        return this.promptTokensTotal;
    }

    public final Long getCompletionTokensTotal() {
        return this.completionTokensTotal;
    }
}
