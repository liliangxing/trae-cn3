package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.download.api.constant.Downloads;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0015H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;", "", "key", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;", Downloads.Impl.COLUMN_DESTINATION, "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;)V", "getKey", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;", "getDestination", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SettingsAboutItem {
    public static final int $stable = 8;
    private final SettingsAboutDestination destination;
    private final SettingsAboutItemKey key;

    public static /* synthetic */ SettingsAboutItem copy$default(SettingsAboutItem settingsAboutItem, SettingsAboutItemKey settingsAboutItemKey, SettingsAboutDestination settingsAboutDestination, int i, Object obj) {
        if ((i & 1) != 0) {
            settingsAboutItemKey = settingsAboutItem.key;
        }
        if ((i & 2) != 0) {
            settingsAboutDestination = settingsAboutItem.destination;
        }
        return settingsAboutItem.copy(settingsAboutItemKey, settingsAboutDestination);
    }

    /* renamed from: component1, reason: from getter */
    public final SettingsAboutItemKey getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final SettingsAboutDestination getDestination() {
        return this.destination;
    }

    public final SettingsAboutItem copy(SettingsAboutItemKey key, SettingsAboutDestination destination) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return new SettingsAboutItem(key, destination);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsAboutItem)) {
            return false;
        }
        SettingsAboutItem settingsAboutItem = (SettingsAboutItem) other;
        return this.key == settingsAboutItem.key && Intrinsics.areEqual(this.destination, settingsAboutItem.destination);
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.destination.hashCode();
    }

    public String toString() {
        return "SettingsAboutItem(key=" + this.key + ", destination=" + this.destination + ')';
    }

    public SettingsAboutItem(SettingsAboutItemKey key, SettingsAboutDestination destination) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.key = key;
        this.destination = destination;
    }

    public final SettingsAboutItemKey getKey() {
        return this.key;
    }

    public final SettingsAboutDestination getDestination() {
        return this.destination;
    }
}
