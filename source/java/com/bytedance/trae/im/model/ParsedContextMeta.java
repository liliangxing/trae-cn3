package com.bytedance.trae.im.model;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 JÚ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u000bHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b*\u0010 ¨\u0006C"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedContextMeta;", "", "id", "", "contextType", "displayType", "source", "name", "status", "uri", "startLine", "", "endLine", "originalCharCount", "actualCharCount", "truncateReason", "truncateStage", "toolcallId", StrategyConstants.ACTION, "contentTotalChars", "contentIncludedChars", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getContextType", "getDisplayType", "getSource", "getName", "getStatus", "getUri", "getStartLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndLine", "getOriginalCharCount", "getActualCharCount", "getTruncateReason", "getTruncateStage", "getToolcallId", "getAction", "getContentTotalChars", "getContentIncludedChars", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/im/model/ParsedContextMeta;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedContextMeta {

    @SerializedName(StrategyConstants.ACTION)
    private final String action;

    @SerializedName("actual_char_count")
    private final Integer actualCharCount;

    @SerializedName("content_included_chars")
    private final Integer contentIncludedChars;

    @SerializedName("content_total_chars")
    private final Integer contentTotalChars;

    @SerializedName("context_type")
    private final String contextType;

    @SerializedName("display_type")
    private final String displayType;

    @SerializedName("end_line")
    private final Integer endLine;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("original_char_count")
    private final Integer originalCharCount;

    @SerializedName("source")
    private final String source;

    @SerializedName("start_line")
    private final Integer startLine;

    @SerializedName("status")
    private final String status;

    @SerializedName("toolcall_id")
    private final String toolcallId;

    @SerializedName("truncate_reason")
    private final String truncateReason;

    @SerializedName("truncate_stage")
    private final String truncateStage;

    @SerializedName("uri")
    private final String uri;

    public ParsedContextMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getOriginalCharCount() {
        return this.originalCharCount;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getActualCharCount() {
        return this.actualCharCount;
    }

    /* renamed from: component12, reason: from getter */
    public final String getTruncateReason() {
        return this.truncateReason;
    }

    /* renamed from: component13, reason: from getter */
    public final String getTruncateStage() {
        return this.truncateStage;
    }

    /* renamed from: component14, reason: from getter */
    public final String getToolcallId() {
        return this.toolcallId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getContentTotalChars() {
        return this.contentTotalChars;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getContentIncludedChars() {
        return this.contentIncludedChars;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContextType() {
        return this.contextType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayType() {
        return this.displayType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getStartLine() {
        return this.startLine;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getEndLine() {
        return this.endLine;
    }

    public final ParsedContextMeta copy(String id, String contextType, String displayType, String source, String name, String status, String uri, Integer startLine, Integer endLine, Integer originalCharCount, Integer actualCharCount, String truncateReason, String truncateStage, String toolcallId, String action, Integer contentTotalChars, Integer contentIncludedChars) {
        return new ParsedContextMeta(id, contextType, displayType, source, name, status, uri, startLine, endLine, originalCharCount, actualCharCount, truncateReason, truncateStage, toolcallId, action, contentTotalChars, contentIncludedChars);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedContextMeta)) {
            return false;
        }
        ParsedContextMeta parsedContextMeta = (ParsedContextMeta) other;
        return Intrinsics.areEqual(this.id, parsedContextMeta.id) && Intrinsics.areEqual(this.contextType, parsedContextMeta.contextType) && Intrinsics.areEqual(this.displayType, parsedContextMeta.displayType) && Intrinsics.areEqual(this.source, parsedContextMeta.source) && Intrinsics.areEqual(this.name, parsedContextMeta.name) && Intrinsics.areEqual(this.status, parsedContextMeta.status) && Intrinsics.areEqual(this.uri, parsedContextMeta.uri) && Intrinsics.areEqual(this.startLine, parsedContextMeta.startLine) && Intrinsics.areEqual(this.endLine, parsedContextMeta.endLine) && Intrinsics.areEqual(this.originalCharCount, parsedContextMeta.originalCharCount) && Intrinsics.areEqual(this.actualCharCount, parsedContextMeta.actualCharCount) && Intrinsics.areEqual(this.truncateReason, parsedContextMeta.truncateReason) && Intrinsics.areEqual(this.truncateStage, parsedContextMeta.truncateStage) && Intrinsics.areEqual(this.toolcallId, parsedContextMeta.toolcallId) && Intrinsics.areEqual(this.action, parsedContextMeta.action) && Intrinsics.areEqual(this.contentTotalChars, parsedContextMeta.contentTotalChars) && Intrinsics.areEqual(this.contentIncludedChars, parsedContextMeta.contentIncludedChars);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.contextType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.displayType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.source;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.status;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.uri;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.startLine;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.endLine;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.originalCharCount;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.actualCharCount;
        int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str8 = this.truncateReason;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.truncateStage;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.toolcallId;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.action;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num5 = this.contentTotalChars;
        int hashCode16 = (hashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.contentIncludedChars;
        return hashCode16 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParsedContextMeta(id=");
        sb.append(this.id).append(", contextType=").append(this.contextType).append(", displayType=").append(this.displayType).append(", source=").append(this.source).append(", name=").append(this.name).append(", status=").append(this.status).append(", uri=").append(this.uri).append(", startLine=").append(this.startLine).append(", endLine=").append(this.endLine).append(", originalCharCount=").append(this.originalCharCount).append(", actualCharCount=").append(this.actualCharCount).append(", truncateReason=");
        sb.append(this.truncateReason).append(", truncateStage=").append(this.truncateStage).append(", toolcallId=").append(this.toolcallId).append(", action=").append(this.action).append(", contentTotalChars=").append(this.contentTotalChars).append(", contentIncludedChars=").append(this.contentIncludedChars).append(')');
        return sb.toString();
    }

    public ParsedContextMeta(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, Integer num5, Integer num6) {
        this.id = str;
        this.contextType = str2;
        this.displayType = str3;
        this.source = str4;
        this.name = str5;
        this.status = str6;
        this.uri = str7;
        this.startLine = num;
        this.endLine = num2;
        this.originalCharCount = num3;
        this.actualCharCount = num4;
        this.truncateReason = str8;
        this.truncateStage = str9;
        this.toolcallId = str10;
        this.action = str11;
        this.contentTotalChars = num5;
        this.contentIncludedChars = num6;
    }

    public /* synthetic */ ParsedContextMeta(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : num5, (i & 65536) != 0 ? null : num6);
    }

    public final String getId() {
        return this.id;
    }

    public final String getContextType() {
        return this.contextType;
    }

    public final String getDisplayType() {
        return this.displayType;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Integer getStartLine() {
        return this.startLine;
    }

    public final Integer getEndLine() {
        return this.endLine;
    }

    public final Integer getOriginalCharCount() {
        return this.originalCharCount;
    }

    public final Integer getActualCharCount() {
        return this.actualCharCount;
    }

    public final String getTruncateReason() {
        return this.truncateReason;
    }

    public final String getTruncateStage() {
        return this.truncateStage;
    }

    public final String getToolcallId() {
        return this.toolcallId;
    }

    public final String getAction() {
        return this.action;
    }

    public final Integer getContentTotalChars() {
        return this.contentTotalChars;
    }

    public final Integer getContentIncludedChars() {
        return this.contentIncludedChars;
    }
}
