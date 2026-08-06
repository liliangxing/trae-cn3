package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;", "", "cleanedText", "", "sourceTaskId", "sourceStatus", "isIncompleteHead", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCleanedText", "()Ljava/lang/String;", "getSourceTaskId", "getSourceStatus", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedSubTaskTag {
    private final String cleanedText;
    private final boolean isIncompleteHead;
    private final String sourceStatus;
    private final String sourceTaskId;

    public static /* synthetic */ ParsedSubTaskTag copy$default(ParsedSubTaskTag parsedSubTaskTag, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedSubTaskTag.cleanedText;
        }
        if ((i & 2) != 0) {
            str2 = parsedSubTaskTag.sourceTaskId;
        }
        if ((i & 4) != 0) {
            str3 = parsedSubTaskTag.sourceStatus;
        }
        if ((i & 8) != 0) {
            z = parsedSubTaskTag.isIncompleteHead;
        }
        return parsedSubTaskTag.copy(str, str2, str3, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCleanedText() {
        return this.cleanedText;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceTaskId() {
        return this.sourceTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSourceStatus() {
        return this.sourceStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsIncompleteHead() {
        return this.isIncompleteHead;
    }

    public final ParsedSubTaskTag copy(String cleanedText, String sourceTaskId, String sourceStatus, boolean isIncompleteHead) {
        Intrinsics.checkNotNullParameter(cleanedText, "cleanedText");
        return new ParsedSubTaskTag(cleanedText, sourceTaskId, sourceStatus, isIncompleteHead);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedSubTaskTag)) {
            return false;
        }
        ParsedSubTaskTag parsedSubTaskTag = (ParsedSubTaskTag) other;
        return Intrinsics.areEqual(this.cleanedText, parsedSubTaskTag.cleanedText) && Intrinsics.areEqual(this.sourceTaskId, parsedSubTaskTag.sourceTaskId) && Intrinsics.areEqual(this.sourceStatus, parsedSubTaskTag.sourceStatus) && this.isIncompleteHead == parsedSubTaskTag.isIncompleteHead;
    }

    public int hashCode() {
        int hashCode = this.cleanedText.hashCode() * 31;
        String str = this.sourceTaskId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sourceStatus;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isIncompleteHead);
    }

    public String toString() {
        return "ParsedSubTaskTag(cleanedText=" + this.cleanedText + ", sourceTaskId=" + this.sourceTaskId + ", sourceStatus=" + this.sourceStatus + ", isIncompleteHead=" + this.isIncompleteHead + ')';
    }

    public ParsedSubTaskTag(String cleanedText, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(cleanedText, "cleanedText");
        this.cleanedText = cleanedText;
        this.sourceTaskId = str;
        this.sourceStatus = str2;
        this.isIncompleteHead = z;
    }

    public /* synthetic */ ParsedSubTaskTag(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z);
    }

    public final String getCleanedText() {
        return this.cleanedText;
    }

    public final String getSourceTaskId() {
        return this.sourceTaskId;
    }

    public final String getSourceStatus() {
        return this.sourceStatus;
    }

    public final boolean isIncompleteHead() {
        return this.isIncompleteHead;
    }
}
