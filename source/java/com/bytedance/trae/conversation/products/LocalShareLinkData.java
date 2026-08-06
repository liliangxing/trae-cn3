package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IShareLinkApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/products/LocalShareLinkData;", "", "shareUrl", "", "shareId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShareUrl", "()Ljava/lang/String;", "getShareId", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LocalShareLinkData {

    @SerializedName("share_id")
    private final String shareId;

    @SerializedName("share_url")
    private final String shareUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalShareLinkData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LocalShareLinkData copy$default(LocalShareLinkData localShareLinkData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localShareLinkData.shareUrl;
        }
        if ((i & 2) != 0) {
            str2 = localShareLinkData.shareId;
        }
        return localShareLinkData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getShareId() {
        return this.shareId;
    }

    public final LocalShareLinkData copy(String shareUrl, String shareId) {
        return new LocalShareLinkData(shareUrl, shareId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalShareLinkData)) {
            return false;
        }
        LocalShareLinkData localShareLinkData = (LocalShareLinkData) other;
        return Intrinsics.areEqual(this.shareUrl, localShareLinkData.shareUrl) && Intrinsics.areEqual(this.shareId, localShareLinkData.shareId);
    }

    public int hashCode() {
        String str = this.shareUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.shareId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LocalShareLinkData(shareUrl=" + this.shareUrl + ", shareId=" + this.shareId + ')';
    }

    public LocalShareLinkData(String str, String str2) {
        this.shareUrl = str;
        this.shareId = str2;
    }

    public /* synthetic */ LocalShareLinkData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getShareId() {
        return this.shareId;
    }
}
