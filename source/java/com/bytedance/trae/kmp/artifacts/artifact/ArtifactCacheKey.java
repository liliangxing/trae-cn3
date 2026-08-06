package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0005J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\u001fH×\u0001J\t\u0010 \u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheKey;", "", EventConstants.PARAM_SOURCE, "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "cliConversationId", "", "messageId", "artifactPath", "rendition", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)V", "getSource", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "getCliConversationId", "()Ljava/lang/String;", "getMessageId", "getArtifactPath", "getRendition", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;", "stableId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ArtifactCacheKey {
    public static final int $stable = 0;
    private final String artifactPath;
    private final String cliConversationId;
    private final String messageId;
    private final ArtifactRendition rendition;
    private final ArtifactSource source;

    public static /* synthetic */ ArtifactCacheKey copy$default(ArtifactCacheKey artifactCacheKey, ArtifactSource artifactSource, String str, String str2, String str3, ArtifactRendition artifactRendition, int i, Object obj) {
        if ((i & 1) != 0) {
            artifactSource = artifactCacheKey.source;
        }
        if ((i & 2) != 0) {
            str = artifactCacheKey.cliConversationId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = artifactCacheKey.messageId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = artifactCacheKey.artifactPath;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            artifactRendition = artifactCacheKey.rendition;
        }
        return artifactCacheKey.copy(artifactSource, str4, str5, str6, artifactRendition);
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
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getArtifactPath() {
        return this.artifactPath;
    }

    /* renamed from: component5, reason: from getter */
    public final ArtifactRendition getRendition() {
        return this.rendition;
    }

    public final ArtifactCacheKey copy(ArtifactSource source, String cliConversationId, String messageId, String artifactPath, ArtifactRendition rendition) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(cliConversationId, "cliConversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
        Intrinsics.checkNotNullParameter(rendition, "rendition");
        return new ArtifactCacheKey(source, cliConversationId, messageId, artifactPath, rendition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactCacheKey)) {
            return false;
        }
        ArtifactCacheKey artifactCacheKey = (ArtifactCacheKey) other;
        return this.source == artifactCacheKey.source && Intrinsics.areEqual(this.cliConversationId, artifactCacheKey.cliConversationId) && Intrinsics.areEqual(this.messageId, artifactCacheKey.messageId) && Intrinsics.areEqual(this.artifactPath, artifactCacheKey.artifactPath) && this.rendition == artifactCacheKey.rendition;
    }

    public int hashCode() {
        return (((((((this.source.hashCode() * 31) + this.cliConversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.artifactPath.hashCode()) * 31) + this.rendition.hashCode();
    }

    public String toString() {
        return "ArtifactCacheKey(source=" + this.source + ", cliConversationId=" + this.cliConversationId + ", messageId=" + this.messageId + ", artifactPath=" + this.artifactPath + ", rendition=" + this.rendition + ')';
    }

    public ArtifactCacheKey(ArtifactSource artifactSource, String str, String str2, String str3, ArtifactRendition artifactRendition) {
        Intrinsics.checkNotNullParameter(artifactSource, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(str, "cliConversationId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Intrinsics.checkNotNullParameter(str3, "artifactPath");
        Intrinsics.checkNotNullParameter(artifactRendition, "rendition");
        this.source = artifactSource;
        this.cliConversationId = str;
        this.messageId = str2;
        this.artifactPath = str3;
        this.rendition = artifactRendition;
    }

    public final ArtifactSource getSource() {
        return this.source;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
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

    public final String stableId() {
        return ArtifactModelsKt.stableHash(this.source.name() + '|' + this.cliConversationId + '|' + this.messageId + '|' + this.artifactPath + '|' + this.rendition.name());
    }
}
