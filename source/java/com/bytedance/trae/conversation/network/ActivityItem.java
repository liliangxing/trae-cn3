package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomActivityApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/network/ActivityItem;", "", "hitActivityTime", "", DBDefinition.ICON_URL, "", "h5Url", WebViewContainer.EVENT_postUrl, "shareUrl", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHitActivityTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIconUrl", "()Ljava/lang/String;", "getH5Url", "getPostUrl", "getShareUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ActivityItem;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityItem {

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("hit_activity_time")
    private final Boolean hitActivityTime;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("post_url")
    private final String postUrl;

    @SerializedName("share_url")
    private final String shareUrl;

    public ActivityItem() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ActivityItem copy$default(ActivityItem activityItem, Boolean bool, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = activityItem.hitActivityTime;
        }
        if ((i & 2) != 0) {
            str = activityItem.iconUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = activityItem.h5Url;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = activityItem.postUrl;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = activityItem.shareUrl;
        }
        return activityItem.copy(bool, str5, str6, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getHitActivityTime() {
        return this.hitActivityTime;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPostUrl() {
        return this.postUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final ActivityItem copy(Boolean hitActivityTime, String iconUrl, String h5Url, String postUrl, String shareUrl) {
        return new ActivityItem(hitActivityTime, iconUrl, h5Url, postUrl, shareUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityItem)) {
            return false;
        }
        ActivityItem activityItem = (ActivityItem) other;
        return Intrinsics.areEqual(this.hitActivityTime, activityItem.hitActivityTime) && Intrinsics.areEqual(this.iconUrl, activityItem.iconUrl) && Intrinsics.areEqual(this.h5Url, activityItem.h5Url) && Intrinsics.areEqual(this.postUrl, activityItem.postUrl) && Intrinsics.areEqual(this.shareUrl, activityItem.shareUrl);
    }

    public int hashCode() {
        Boolean bool = this.hitActivityTime;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.iconUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.h5Url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.postUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shareUrl;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ActivityItem(hitActivityTime=" + this.hitActivityTime + ", iconUrl=" + this.iconUrl + ", h5Url=" + this.h5Url + ", postUrl=" + this.postUrl + ", shareUrl=" + this.shareUrl + ')';
    }

    public ActivityItem(Boolean bool, String str, String str2, String str3, String str4) {
        this.hitActivityTime = bool;
        this.iconUrl = str;
        this.h5Url = str2;
        this.postUrl = str3;
        this.shareUrl = str4;
    }

    public /* synthetic */ ActivityItem(Boolean bool, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final Boolean getHitActivityTime() {
        return this.hitActivityTime;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final String getPostUrl() {
        return this.postUrl;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }
}
