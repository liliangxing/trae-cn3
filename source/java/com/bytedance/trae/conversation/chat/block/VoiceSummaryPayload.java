package com.bytedance.trae.conversation.chat.block;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceSummaryPayloadParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;", "", "header", "", "markdown", "bottom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getMarkdown", "getBottom", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VoiceSummaryPayload {
    private final String bottom;
    private final String header;
    private final String markdown;

    public static /* synthetic */ VoiceSummaryPayload copy$default(VoiceSummaryPayload voiceSummaryPayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceSummaryPayload.header;
        }
        if ((i & 2) != 0) {
            str2 = voiceSummaryPayload.markdown;
        }
        if ((i & 4) != 0) {
            str3 = voiceSummaryPayload.bottom;
        }
        return voiceSummaryPayload.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMarkdown() {
        return this.markdown;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBottom() {
        return this.bottom;
    }

    public final VoiceSummaryPayload copy(String header, String markdown, String bottom) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        return new VoiceSummaryPayload(header, markdown, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceSummaryPayload)) {
            return false;
        }
        VoiceSummaryPayload voiceSummaryPayload = (VoiceSummaryPayload) other;
        return Intrinsics.areEqual(this.header, voiceSummaryPayload.header) && Intrinsics.areEqual(this.markdown, voiceSummaryPayload.markdown) && Intrinsics.areEqual(this.bottom, voiceSummaryPayload.bottom);
    }

    public int hashCode() {
        return (((this.header.hashCode() * 31) + this.markdown.hashCode()) * 31) + this.bottom.hashCode();
    }

    public String toString() {
        return "VoiceSummaryPayload(header=" + this.header + ", markdown=" + this.markdown + ", bottom=" + this.bottom + ')';
    }

    public VoiceSummaryPayload(String header, String markdown, String bottom) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        this.header = header;
        this.markdown = markdown;
        this.bottom = bottom;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getMarkdown() {
        return this.markdown;
    }

    public final String getBottom() {
        return this.bottom;
    }
}
