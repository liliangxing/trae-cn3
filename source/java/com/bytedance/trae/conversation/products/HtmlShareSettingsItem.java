package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHtmlShareSettings.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;", "", "minSupportedIdeVersion", "", "bytedanceEnable", "", "<init>", "(Ljava/lang/String;Z)V", "getMinSupportedIdeVersion", "()Ljava/lang/String;", "getBytedanceEnable", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HtmlShareSettingsItem {
    private final boolean bytedanceEnable;
    private final String minSupportedIdeVersion;

    public static /* synthetic */ HtmlShareSettingsItem copy$default(HtmlShareSettingsItem htmlShareSettingsItem, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = htmlShareSettingsItem.minSupportedIdeVersion;
        }
        if ((i & 2) != 0) {
            z = htmlShareSettingsItem.bytedanceEnable;
        }
        return htmlShareSettingsItem.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMinSupportedIdeVersion() {
        return this.minSupportedIdeVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getBytedanceEnable() {
        return this.bytedanceEnable;
    }

    public final HtmlShareSettingsItem copy(String minSupportedIdeVersion, boolean bytedanceEnable) {
        return new HtmlShareSettingsItem(minSupportedIdeVersion, bytedanceEnable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HtmlShareSettingsItem)) {
            return false;
        }
        HtmlShareSettingsItem htmlShareSettingsItem = (HtmlShareSettingsItem) other;
        return Intrinsics.areEqual(this.minSupportedIdeVersion, htmlShareSettingsItem.minSupportedIdeVersion) && this.bytedanceEnable == htmlShareSettingsItem.bytedanceEnable;
    }

    public int hashCode() {
        String str = this.minSupportedIdeVersion;
        return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.bytedanceEnable);
    }

    public String toString() {
        return "HtmlShareSettingsItem(minSupportedIdeVersion=" + this.minSupportedIdeVersion + ", bytedanceEnable=" + this.bytedanceEnable + ')';
    }

    public HtmlShareSettingsItem(String str, boolean z) {
        this.minSupportedIdeVersion = str;
        this.bytedanceEnable = z;
    }

    public final String getMinSupportedIdeVersion() {
        return this.minSupportedIdeVersion;
    }

    public final boolean getBytedanceEnable() {
        return this.bytedanceEnable;
    }
}
