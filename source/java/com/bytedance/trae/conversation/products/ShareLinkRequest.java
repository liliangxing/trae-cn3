package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IShareLinkApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/products/ShareLinkRequest;", "", "chatSessionId", "", "artifactPath", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatSessionId", "()Ljava/lang/String;", "getArtifactPath", "getTitle", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ShareLinkRequest {

    @SerializedName("artifact_path")
    private final String artifactPath;

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("title")
    private final String title;

    public static /* synthetic */ ShareLinkRequest copy$default(ShareLinkRequest shareLinkRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareLinkRequest.chatSessionId;
        }
        if ((i & 2) != 0) {
            str2 = shareLinkRequest.artifactPath;
        }
        if ((i & 4) != 0) {
            str3 = shareLinkRequest.title;
        }
        return shareLinkRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getArtifactPath() {
        return this.artifactPath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final ShareLinkRequest copy(String chatSessionId, String artifactPath, String title) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
        Intrinsics.checkNotNullParameter(title, "title");
        return new ShareLinkRequest(chatSessionId, artifactPath, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareLinkRequest)) {
            return false;
        }
        ShareLinkRequest shareLinkRequest = (ShareLinkRequest) other;
        return Intrinsics.areEqual(this.chatSessionId, shareLinkRequest.chatSessionId) && Intrinsics.areEqual(this.artifactPath, shareLinkRequest.artifactPath) && Intrinsics.areEqual(this.title, shareLinkRequest.title);
    }

    public int hashCode() {
        return (((this.chatSessionId.hashCode() * 31) + this.artifactPath.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "ShareLinkRequest(chatSessionId=" + this.chatSessionId + ", artifactPath=" + this.artifactPath + ", title=" + this.title + ')';
    }

    public ShareLinkRequest(String chatSessionId, String artifactPath, String title) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
        Intrinsics.checkNotNullParameter(title, "title");
        this.chatSessionId = chatSessionId;
        this.artifactPath = artifactPath;
        this.title = title;
    }

    public /* synthetic */ ShareLinkRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getArtifactPath() {
        return this.artifactPath;
    }

    public final String getTitle() {
        return this.title;
    }
}
