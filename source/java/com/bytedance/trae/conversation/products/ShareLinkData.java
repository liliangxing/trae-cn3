package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IShareLinkApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/products/ShareLinkData;", "", "shareSessionId", "", "title", "anonymous", "", "createdAt", "status", "artifactPath", "expiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getShareSessionId", "()Ljava/lang/String;", "getTitle", "getAnonymous", "()Z", "getCreatedAt", "getStatus", "getArtifactPath", "getExpiresAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ShareLinkData {

    @SerializedName("anonymous")
    private final boolean anonymous;

    @SerializedName("artifact_path")
    private final String artifactPath;

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("expires_at")
    private final String expiresAt;

    @SerializedName("share_session_id")
    private final String shareSessionId;

    @SerializedName("status")
    private final String status;

    @SerializedName("title")
    private final String title;

    public ShareLinkData() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ShareLinkData copy$default(ShareLinkData shareLinkData, String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareLinkData.shareSessionId;
        }
        if ((i & 2) != 0) {
            str2 = shareLinkData.title;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            z = shareLinkData.anonymous;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = shareLinkData.createdAt;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = shareLinkData.status;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = shareLinkData.artifactPath;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = shareLinkData.expiresAt;
        }
        return shareLinkData.copy(str, str7, z2, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getShareSessionId() {
        return this.shareSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAnonymous() {
        return this.anonymous;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getArtifactPath() {
        return this.artifactPath;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final ShareLinkData copy(String shareSessionId, String title, boolean anonymous, String createdAt, String status, String artifactPath, String expiresAt) {
        return new ShareLinkData(shareSessionId, title, anonymous, createdAt, status, artifactPath, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareLinkData)) {
            return false;
        }
        ShareLinkData shareLinkData = (ShareLinkData) other;
        return Intrinsics.areEqual(this.shareSessionId, shareLinkData.shareSessionId) && Intrinsics.areEqual(this.title, shareLinkData.title) && this.anonymous == shareLinkData.anonymous && Intrinsics.areEqual(this.createdAt, shareLinkData.createdAt) && Intrinsics.areEqual(this.status, shareLinkData.status) && Intrinsics.areEqual(this.artifactPath, shareLinkData.artifactPath) && Intrinsics.areEqual(this.expiresAt, shareLinkData.expiresAt);
    }

    public int hashCode() {
        String str = this.shareSessionId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.anonymous)) * 31;
        String str3 = this.createdAt;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.artifactPath;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.expiresAt;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "ShareLinkData(shareSessionId=" + this.shareSessionId + ", title=" + this.title + ", anonymous=" + this.anonymous + ", createdAt=" + this.createdAt + ", status=" + this.status + ", artifactPath=" + this.artifactPath + ", expiresAt=" + this.expiresAt + ')';
    }

    public ShareLinkData(String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        this.shareSessionId = str;
        this.title = str2;
        this.anonymous = z;
        this.createdAt = str3;
        this.status = str4;
        this.artifactPath = str5;
        this.expiresAt = str6;
    }

    public /* synthetic */ ShareLinkData(String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }

    public final String getShareSessionId() {
        return this.shareSessionId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getAnonymous() {
        return this.anonymous;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getArtifactPath() {
        return this.artifactPath;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }
}
