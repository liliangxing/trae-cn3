package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkwonPerformance.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "", "markwonCreateDuration", "", "markwonParseDuration", "markwonRenderDuration", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getMarkwonCreateDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMarkwonParseDuration", "getMarkwonRenderDuration", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MarkwonPerformance {
    private final Long markwonCreateDuration;
    private final Long markwonParseDuration;
    private final Long markwonRenderDuration;

    public MarkwonPerformance() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MarkwonPerformance copy$default(MarkwonPerformance markwonPerformance, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = markwonPerformance.markwonCreateDuration;
        }
        if ((i & 2) != 0) {
            l2 = markwonPerformance.markwonParseDuration;
        }
        if ((i & 4) != 0) {
            l3 = markwonPerformance.markwonRenderDuration;
        }
        return markwonPerformance.copy(l, l2, l3);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getMarkwonCreateDuration() {
        return this.markwonCreateDuration;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getMarkwonParseDuration() {
        return this.markwonParseDuration;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getMarkwonRenderDuration() {
        return this.markwonRenderDuration;
    }

    public final MarkwonPerformance copy(Long markwonCreateDuration, Long markwonParseDuration, Long markwonRenderDuration) {
        return new MarkwonPerformance(markwonCreateDuration, markwonParseDuration, markwonRenderDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkwonPerformance)) {
            return false;
        }
        MarkwonPerformance markwonPerformance = (MarkwonPerformance) other;
        return Intrinsics.areEqual(this.markwonCreateDuration, markwonPerformance.markwonCreateDuration) && Intrinsics.areEqual(this.markwonParseDuration, markwonPerformance.markwonParseDuration) && Intrinsics.areEqual(this.markwonRenderDuration, markwonPerformance.markwonRenderDuration);
    }

    public int hashCode() {
        Long l = this.markwonCreateDuration;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.markwonParseDuration;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.markwonRenderDuration;
        return hashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "MarkwonPerformance(markwonCreateDuration=" + this.markwonCreateDuration + ", markwonParseDuration=" + this.markwonParseDuration + ", markwonRenderDuration=" + this.markwonRenderDuration + ')';
    }

    public MarkwonPerformance(Long l, Long l2, Long l3) {
        this.markwonCreateDuration = l;
        this.markwonParseDuration = l2;
        this.markwonRenderDuration = l3;
    }

    public /* synthetic */ MarkwonPerformance(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
    }

    public final Long getMarkwonCreateDuration() {
        return this.markwonCreateDuration;
    }

    public final Long getMarkwonParseDuration() {
        return this.markwonParseDuration;
    }

    public final Long getMarkwonRenderDuration() {
        return this.markwonRenderDuration;
    }
}
