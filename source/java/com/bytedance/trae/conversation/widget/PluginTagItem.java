package com.bytedance.trae.conversation.widget;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginTagItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "", "id", "", "displayName", "iconRes", "", DBDefinition.ICON_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDisplayName", "getIconRes", "()I", "getIconUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PluginTagItem {
    private final String displayName;
    private final int iconRes;
    private final String iconUrl;
    private final String id;

    public static /* synthetic */ PluginTagItem copy$default(PluginTagItem pluginTagItem, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pluginTagItem.id;
        }
        if ((i2 & 2) != 0) {
            str2 = pluginTagItem.displayName;
        }
        if ((i2 & 4) != 0) {
            i = pluginTagItem.iconRes;
        }
        if ((i2 & 8) != 0) {
            str3 = pluginTagItem.iconUrl;
        }
        return pluginTagItem.copy(str, str2, i, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component4, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final PluginTagItem copy(String id, String displayName, int iconRes, String iconUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new PluginTagItem(id, displayName, iconRes, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PluginTagItem)) {
            return false;
        }
        PluginTagItem pluginTagItem = (PluginTagItem) other;
        return Intrinsics.areEqual(this.id, pluginTagItem.id) && Intrinsics.areEqual(this.displayName, pluginTagItem.displayName) && this.iconRes == pluginTagItem.iconRes && Intrinsics.areEqual(this.iconUrl, pluginTagItem.iconUrl);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + Integer.hashCode(this.iconRes)) * 31;
        String str = this.iconUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PluginTagItem(id=" + this.id + ", displayName=" + this.displayName + ", iconRes=" + this.iconRes + ", iconUrl=" + this.iconUrl + ')';
    }

    public PluginTagItem(String id, String displayName, int i, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.id = id;
        this.displayName = displayName;
        this.iconRes = i;
        this.iconUrl = str;
    }

    public /* synthetic */ PluginTagItem(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }
}
