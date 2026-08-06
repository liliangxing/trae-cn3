package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkDownLinkInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/api/model/MarkDownLinkInfo;", "", "linkUrl", "", "linkText", "startIndex", "", "endIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLinkText", "()Ljava/lang/String;", "getLinkUrl", "getStartIndex", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/MarkDownLinkInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MarkDownLinkInfo {
    private final Integer endIndex;
    private final String linkText;
    private final String linkUrl;
    private final Integer startIndex;

    public MarkDownLinkInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MarkDownLinkInfo copy$default(MarkDownLinkInfo markDownLinkInfo, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markDownLinkInfo.linkUrl;
        }
        if ((i & 2) != 0) {
            str2 = markDownLinkInfo.linkText;
        }
        if ((i & 4) != 0) {
            num = markDownLinkInfo.startIndex;
        }
        if ((i & 8) != 0) {
            num2 = markDownLinkInfo.endIndex;
        }
        return markDownLinkInfo.copy(str, str2, num, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLinkText() {
        return this.linkText;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStartIndex() {
        return this.startIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getEndIndex() {
        return this.endIndex;
    }

    public final MarkDownLinkInfo copy(String linkUrl, String linkText, Integer startIndex, Integer endIndex) {
        return new MarkDownLinkInfo(linkUrl, linkText, startIndex, endIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkDownLinkInfo)) {
            return false;
        }
        MarkDownLinkInfo markDownLinkInfo = (MarkDownLinkInfo) other;
        return Intrinsics.areEqual(this.linkUrl, markDownLinkInfo.linkUrl) && Intrinsics.areEqual(this.linkText, markDownLinkInfo.linkText) && Intrinsics.areEqual(this.startIndex, markDownLinkInfo.startIndex) && Intrinsics.areEqual(this.endIndex, markDownLinkInfo.endIndex);
    }

    public int hashCode() {
        String str = this.linkUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.linkText;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.startIndex;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.endIndex;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MarkDownLinkInfo(linkUrl=" + this.linkUrl + ", linkText=" + this.linkText + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ')';
    }

    public MarkDownLinkInfo(String str, String str2, Integer num, Integer num2) {
        this.linkUrl = str;
        this.linkText = str2;
        this.startIndex = num;
        this.endIndex = num2;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getLinkText() {
        return this.linkText;
    }

    public /* synthetic */ MarkDownLinkInfo(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? 0 : num2);
    }

    public final Integer getStartIndex() {
        return this.startIndex;
    }

    public final Integer getEndIndex() {
        return this.endIndex;
    }
}
