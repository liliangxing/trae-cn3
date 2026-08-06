package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÇ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010 \u001a\u00020!H×\u0001J\t\u0010\"\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;", "", EventConstants.PARAM_SOURCE, "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "cliConversationId", "", "conversationId", "messageId", "artifactPath", "rendition", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)V", "getSource", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "getCliConversationId", "()Ljava/lang/String;", "getConversationId", "getMessageId", "getArtifactPath", "getRendition", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ArtifactResourceRequest {
    public static final int $stable = 0;
    private final String artifactPath;
    private final String cliConversationId;
    private final String conversationId;
    private final String messageId;
    private final ArtifactRendition rendition;
    private final ArtifactSource source;

    public static /* synthetic */ ArtifactResourceRequest copy$default(ArtifactResourceRequest artifactResourceRequest, ArtifactSource artifactSource, String str, String str2, String str3, String str4, ArtifactRendition artifactRendition, int i, Object obj) {
        if ((i & 1) != 0) {
            artifactSource = artifactResourceRequest.source;
        }
        if ((i & 2) != 0) {
            str = artifactResourceRequest.cliConversationId;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = artifactResourceRequest.conversationId;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = artifactResourceRequest.messageId;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = artifactResourceRequest.artifactPath;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            artifactRendition = artifactResourceRequest.rendition;
        }
        return artifactResourceRequest.copy(artifactSource, str5, str6, str7, str8, artifactRendition);
    }

    /* renamed from: component1, reason: from getter */
    public final ArtifactSource getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArtifactPath() {
        return this.artifactPath;
    }

    /* renamed from: component6, reason: from getter */
    public final ArtifactRendition getRendition() {
        return this.rendition;
    }

    public final ArtifactResourceRequest copy(ArtifactSource source, String cliConversationId, String conversationId, String messageId, String artifactPath, ArtifactRendition rendition) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(cliConversationId, "cliConversationId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
        Intrinsics.checkNotNullParameter(rendition, "rendition");
        return new ArtifactResourceRequest(source, cliConversationId, conversationId, messageId, artifactPath, rendition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactResourceRequest)) {
            return false;
        }
        ArtifactResourceRequest artifactResourceRequest = (ArtifactResourceRequest) other;
        return this.source == artifactResourceRequest.source && Intrinsics.areEqual(this.cliConversationId, artifactResourceRequest.cliConversationId) && Intrinsics.areEqual(this.conversationId, artifactResourceRequest.conversationId) && Intrinsics.areEqual(this.messageId, artifactResourceRequest.messageId) && Intrinsics.areEqual(this.artifactPath, artifactResourceRequest.artifactPath) && this.rendition == artifactResourceRequest.rendition;
    }

    public int hashCode() {
        return (((((((((this.source.hashCode() * 31) + this.cliConversationId.hashCode()) * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.artifactPath.hashCode()) * 31) + this.rendition.hashCode();
    }

    public String toString() {
        return "ArtifactResourceRequest(source=" + this.source + ", cliConversationId=" + this.cliConversationId + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", artifactPath=" + this.artifactPath + ", rendition=" + this.rendition + ')';
    }

    public ArtifactResourceRequest(ArtifactSource artifactSource, String str, String str2, String str3, String str4, ArtifactRendition artifactRendition) {
        Intrinsics.checkNotNullParameter(artifactSource, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(str, "cliConversationId");
        Intrinsics.checkNotNullParameter(str2, "conversationId");
        Intrinsics.checkNotNullParameter(str3, "messageId");
        Intrinsics.checkNotNullParameter(str4, "artifactPath");
        Intrinsics.checkNotNullParameter(artifactRendition, "rendition");
        this.source = artifactSource;
        this.cliConversationId = str;
        this.conversationId = str2;
        this.messageId = str3;
        this.artifactPath = str4;
        this.rendition = artifactRendition;
    }

    public final ArtifactSource getSource() {
        return this.source;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getArtifactPath() {
        return this.artifactPath;
    }

    public final ArtifactRendition getRendition() {
        return this.rendition;
    }
}
