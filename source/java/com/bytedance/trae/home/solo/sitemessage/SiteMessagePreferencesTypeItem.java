package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;", "", "key", "", "title", "Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "description", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;)V", "getKey", "()Ljava/lang/String;", "getTitle", "()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "getDescription", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessagePreferencesTypeItem {
    public static final int $stable = 0;

    @SerializedName("description")
    private final LocalizedText description;

    @SerializedName("key")
    private final String key;

    @SerializedName("title")
    private final LocalizedText title;

    public static /* synthetic */ SiteMessagePreferencesTypeItem copy$default(SiteMessagePreferencesTypeItem siteMessagePreferencesTypeItem, String str, LocalizedText localizedText, LocalizedText localizedText2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = siteMessagePreferencesTypeItem.key;
        }
        if ((i & 2) != 0) {
            localizedText = siteMessagePreferencesTypeItem.title;
        }
        if ((i & 4) != 0) {
            localizedText2 = siteMessagePreferencesTypeItem.description;
        }
        return siteMessagePreferencesTypeItem.copy(str, localizedText, localizedText2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalizedText getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalizedText getDescription() {
        return this.description;
    }

    public final SiteMessagePreferencesTypeItem copy(String key, LocalizedText title, LocalizedText description) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new SiteMessagePreferencesTypeItem(key, title, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteMessagePreferencesTypeItem)) {
            return false;
        }
        SiteMessagePreferencesTypeItem siteMessagePreferencesTypeItem = (SiteMessagePreferencesTypeItem) other;
        return Intrinsics.areEqual(this.key, siteMessagePreferencesTypeItem.key) && Intrinsics.areEqual(this.title, siteMessagePreferencesTypeItem.title) && Intrinsics.areEqual(this.description, siteMessagePreferencesTypeItem.description);
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        LocalizedText localizedText = this.title;
        int hashCode2 = (hashCode + (localizedText == null ? 0 : localizedText.hashCode())) * 31;
        LocalizedText localizedText2 = this.description;
        return hashCode2 + (localizedText2 != null ? localizedText2.hashCode() : 0);
    }

    public String toString() {
        return "SiteMessagePreferencesTypeItem(key=" + this.key + ", title=" + this.title + ", description=" + this.description + ')';
    }

    public SiteMessagePreferencesTypeItem(String key, LocalizedText localizedText, LocalizedText localizedText2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.title = localizedText;
        this.description = localizedText2;
    }

    public /* synthetic */ SiteMessagePreferencesTypeItem(String str, LocalizedText localizedText, LocalizedText localizedText2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : localizedText, (i & 4) != 0 ? null : localizedText2);
    }

    public final String getKey() {
        return this.key;
    }

    public final LocalizedText getTitle() {
        return this.title;
    }

    public final LocalizedText getDescription() {
        return this.description;
    }
}
