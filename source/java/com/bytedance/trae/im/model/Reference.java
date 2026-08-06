package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedance/trae/im/model/Reference;", "", "uri", "", "startLine", "", "endLine", "terminalId", "referenceType", "fileName", "scheme", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getStartLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndLine", "getTerminalId", "getReferenceType", "getFileName", "getScheme", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/model/Reference;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Reference {

    @SerializedName("end_line")
    private final Integer endLine;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("reference_type")
    private final Integer referenceType;

    @SerializedName("scheme")
    private final String scheme;

    @SerializedName("start_line")
    private final Integer startLine;

    @SerializedName("terminal_id")
    private final String terminalId;

    @SerializedName("uri")
    private final String uri;

    public Reference() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Reference copy$default(Reference reference, String str, Integer num, Integer num2, String str2, Integer num3, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reference.uri;
        }
        if ((i & 2) != 0) {
            num = reference.startLine;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = reference.endLine;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            str2 = reference.terminalId;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            num3 = reference.referenceType;
        }
        Integer num6 = num3;
        if ((i & 32) != 0) {
            str3 = reference.fileName;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            str4 = reference.scheme;
        }
        return reference.copy(str, num4, num5, str5, num6, str6, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getStartLine() {
        return this.startLine;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getEndLine() {
        return this.endLine;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTerminalId() {
        return this.terminalId;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getReferenceType() {
        return this.referenceType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public final Reference copy(String uri, Integer startLine, Integer endLine, String terminalId, Integer referenceType, String fileName, String scheme) {
        return new Reference(uri, startLine, endLine, terminalId, referenceType, fileName, scheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reference)) {
            return false;
        }
        Reference reference = (Reference) other;
        return Intrinsics.areEqual(this.uri, reference.uri) && Intrinsics.areEqual(this.startLine, reference.startLine) && Intrinsics.areEqual(this.endLine, reference.endLine) && Intrinsics.areEqual(this.terminalId, reference.terminalId) && Intrinsics.areEqual(this.referenceType, reference.referenceType) && Intrinsics.areEqual(this.fileName, reference.fileName) && Intrinsics.areEqual(this.scheme, reference.scheme);
    }

    public int hashCode() {
        String str = this.uri;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.startLine;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.endLine;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.terminalId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.referenceType;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.fileName;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scheme;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Reference(uri=" + this.uri + ", startLine=" + this.startLine + ", endLine=" + this.endLine + ", terminalId=" + this.terminalId + ", referenceType=" + this.referenceType + ", fileName=" + this.fileName + ", scheme=" + this.scheme + ')';
    }

    public Reference(String str, Integer num, Integer num2, String str2, Integer num3, String str3, String str4) {
        this.uri = str;
        this.startLine = num;
        this.endLine = num2;
        this.terminalId = str2;
        this.referenceType = num3;
        this.fileName = str3;
        this.scheme = str4;
    }

    public /* synthetic */ Reference(String str, Integer num, Integer num2, String str2, Integer num3, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
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

    public final String getTerminalId() {
        return this.terminalId;
    }

    public final Integer getReferenceType() {
        return this.referenceType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getScheme() {
        return this.scheme;
    }
}
