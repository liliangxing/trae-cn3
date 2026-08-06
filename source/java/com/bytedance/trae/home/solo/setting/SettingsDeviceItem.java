package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\u001bH×\u0001J\t\u0010\u001c\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "", "id", "", "name", "isOnline", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "isPaired", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/trae/conversation/devices/DeviceProductType;Z)V", "getId", "()Ljava/lang/String;", "getName", "()Z", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SettingsDeviceItem {
    public static final int $stable = 0;
    private final String id;
    private final boolean isOnline;
    private final boolean isPaired;
    private final String name;
    private final DeviceProductType productType;

    public static /* synthetic */ SettingsDeviceItem copy$default(SettingsDeviceItem settingsDeviceItem, String str, String str2, boolean z, DeviceProductType deviceProductType, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsDeviceItem.id;
        }
        if ((i & 2) != 0) {
            str2 = settingsDeviceItem.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = settingsDeviceItem.isOnline;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            deviceProductType = settingsDeviceItem.productType;
        }
        DeviceProductType deviceProductType2 = deviceProductType;
        if ((i & 16) != 0) {
            z2 = settingsDeviceItem.isPaired;
        }
        return settingsDeviceItem.copy(str, str3, z3, deviceProductType2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    /* renamed from: component4, reason: from getter */
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsPaired() {
        return this.isPaired;
    }

    public final SettingsDeviceItem copy(String id, String name, boolean isOnline, DeviceProductType productType, boolean isPaired) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new SettingsDeviceItem(id, name, isOnline, productType, isPaired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsDeviceItem)) {
            return false;
        }
        SettingsDeviceItem settingsDeviceItem = (SettingsDeviceItem) other;
        return Intrinsics.areEqual(this.id, settingsDeviceItem.id) && Intrinsics.areEqual(this.name, settingsDeviceItem.name) && this.isOnline == settingsDeviceItem.isOnline && this.productType == settingsDeviceItem.productType && this.isPaired == settingsDeviceItem.isPaired;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isOnline)) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.isPaired);
    }

    public String toString() {
        return "SettingsDeviceItem(id=" + this.id + ", name=" + this.name + ", isOnline=" + this.isOnline + ", productType=" + this.productType + ", isPaired=" + this.isPaired + ')';
    }

    public SettingsDeviceItem(String id, String name, boolean z, DeviceProductType productType, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.id = id;
        this.name = name;
        this.isOnline = z;
        this.productType = productType;
        this.isPaired = z2;
    }

    public /* synthetic */ SettingsDeviceItem(String str, String str2, boolean z, DeviceProductType deviceProductType, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, deviceProductType, (i & 16) != 0 ? true : z2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final boolean isPaired() {
        return this.isPaired;
    }
}
