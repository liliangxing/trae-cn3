package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;", "", "appName", "", "versionName", "items", "", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getVersionName", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SettingsAboutState {
    public static final int $stable = 8;
    private final String appName;
    private final List<SettingsAboutItem> items;
    private final String versionName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsAboutState copy$default(SettingsAboutState settingsAboutState, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsAboutState.appName;
        }
        if ((i & 2) != 0) {
            str2 = settingsAboutState.versionName;
        }
        if ((i & 4) != 0) {
            list = settingsAboutState.items;
        }
        return settingsAboutState.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    public final List<SettingsAboutItem> component3() {
        return this.items;
    }

    public final SettingsAboutState copy(String appName, String versionName, List<SettingsAboutItem> items) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(items, "items");
        return new SettingsAboutState(appName, versionName, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsAboutState)) {
            return false;
        }
        SettingsAboutState settingsAboutState = (SettingsAboutState) other;
        return Intrinsics.areEqual(this.appName, settingsAboutState.appName) && Intrinsics.areEqual(this.versionName, settingsAboutState.versionName) && Intrinsics.areEqual(this.items, settingsAboutState.items);
    }

    public int hashCode() {
        return (((this.appName.hashCode() * 31) + this.versionName.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "SettingsAboutState(appName=" + this.appName + ", versionName=" + this.versionName + ", items=" + this.items + ')';
    }

    public SettingsAboutState(String appName, String versionName, List<SettingsAboutItem> items) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(items, "items");
        this.appName = appName;
        this.versionName = versionName;
        this.items = items;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final List<SettingsAboutItem> getItems() {
        return this.items;
    }
}
