package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u001dH×\u0001J\t\u0010\u001e\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;", "", "key", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "trailingText", "", "destructive", "", "clickable", "showTrailingIcon", "<init>", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;Ljava/lang/String;ZZZ)V", "getKey", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "getTrailingText", "()Ljava/lang/String;", "getDestructive", "()Z", "getClickable", "getShowTrailingIcon", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SettingsItem {
    public static final int $stable = 0;
    private final boolean clickable;
    private final boolean destructive;
    private final SettingsItemKey key;
    private final boolean showTrailingIcon;
    private final String trailingText;

    public static /* synthetic */ SettingsItem copy$default(SettingsItem settingsItem, SettingsItemKey settingsItemKey, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            settingsItemKey = settingsItem.key;
        }
        if ((i & 2) != 0) {
            str = settingsItem.trailingText;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z = settingsItem.destructive;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = settingsItem.clickable;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = settingsItem.showTrailingIcon;
        }
        return settingsItem.copy(settingsItemKey, str2, z4, z5, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final SettingsItemKey getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTrailingText() {
        return this.trailingText;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDestructive() {
        return this.destructive;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getClickable() {
        return this.clickable;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowTrailingIcon() {
        return this.showTrailingIcon;
    }

    public final SettingsItem copy(SettingsItemKey key, String trailingText, boolean destructive, boolean clickable, boolean showTrailingIcon) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new SettingsItem(key, trailingText, destructive, clickable, showTrailingIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsItem)) {
            return false;
        }
        SettingsItem settingsItem = (SettingsItem) other;
        return this.key == settingsItem.key && Intrinsics.areEqual(this.trailingText, settingsItem.trailingText) && this.destructive == settingsItem.destructive && this.clickable == settingsItem.clickable && this.showTrailingIcon == settingsItem.showTrailingIcon;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        String str = this.trailingText;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.destructive)) * 31) + Boolean.hashCode(this.clickable)) * 31) + Boolean.hashCode(this.showTrailingIcon);
    }

    public String toString() {
        return "SettingsItem(key=" + this.key + ", trailingText=" + this.trailingText + ", destructive=" + this.destructive + ", clickable=" + this.clickable + ", showTrailingIcon=" + this.showTrailingIcon + ')';
    }

    public SettingsItem(SettingsItemKey key, String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.trailingText = str;
        this.destructive = z;
        this.clickable = z2;
        this.showTrailingIcon = z3;
    }

    public /* synthetic */ SettingsItem(SettingsItemKey settingsItemKey, String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(settingsItemKey, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3);
    }

    public final SettingsItemKey getKey() {
        return this.key;
    }

    public final String getTrailingText() {
        return this.trailingText;
    }

    public final boolean getDestructive() {
        return this.destructive;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final boolean getShowTrailingIcon() {
        return this.showTrailingIcon;
    }
}
