package com.bytedance.trae.conversation.devices;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0017¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceItem;", "", "id", "", "name", StrategyConstants.MODEL, "iconResId", "", "isOnline", "", "isSelected", "type", "Lcom/bytedance/trae/im/service/CliType;", "ideVersion", "isPaired", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZLcom/bytedance/trae/im/service/CliType;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getName", "getModel", "getIconResId", "()I", "()Z", "getType", "()Lcom/bytedance/trae/im/service/CliType;", "getIdeVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceItem {
    private final int iconResId;
    private final String id;
    private final String ideVersion;
    private final boolean isOnline;
    private final boolean isPaired;
    private final boolean isSelected;
    private final String model;
    private final String name;
    private final CliType type;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component7, reason: from getter */
    public final CliType getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final String getIdeVersion() {
        return this.ideVersion;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsPaired() {
        return this.isPaired;
    }

    public final DeviceItem copy(String id, String name, String model, int iconResId, boolean isOnline, boolean isSelected, CliType type, String ideVersion, boolean isPaired) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DeviceItem(id, name, model, iconResId, isOnline, isSelected, type, ideVersion, isPaired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceItem)) {
            return false;
        }
        DeviceItem deviceItem = (DeviceItem) other;
        return Intrinsics.areEqual(this.id, deviceItem.id) && Intrinsics.areEqual(this.name, deviceItem.name) && Intrinsics.areEqual(this.model, deviceItem.model) && this.iconResId == deviceItem.iconResId && this.isOnline == deviceItem.isOnline && this.isSelected == deviceItem.isSelected && this.type == deviceItem.type && Intrinsics.areEqual(this.ideVersion, deviceItem.ideVersion) && this.isPaired == deviceItem.isPaired;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.model.hashCode()) * 31) + Integer.hashCode(this.iconResId)) * 31) + Boolean.hashCode(this.isOnline)) * 31) + Boolean.hashCode(this.isSelected)) * 31) + this.type.hashCode()) * 31;
        String str = this.ideVersion;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isPaired);
    }

    public String toString() {
        return "DeviceItem(id=" + this.id + ", name=" + this.name + ", model=" + this.model + ", iconResId=" + this.iconResId + ", isOnline=" + this.isOnline + ", isSelected=" + this.isSelected + ", type=" + this.type + ", ideVersion=" + this.ideVersion + ", isPaired=" + this.isPaired + ')';
    }

    public DeviceItem(String id, String name, String model, int i, boolean z, boolean z2, CliType type, String str, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.model = model;
        this.iconResId = i;
        this.isOnline = z;
        this.isSelected = z2;
        this.type = type;
        this.ideVersion = str;
        this.isPaired = z3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public /* synthetic */ DeviceItem(String str, String str2, String str3, int i, boolean z, boolean z2, CliType cliType, String str4, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? "" : str3, i, z, z2, (i2 & 64) != 0 ? CliType.LOCAL : cliType, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? true : z3);
    }

    public final CliType getType() {
        return this.type;
    }

    public final String getIdeVersion() {
        return this.ideVersion;
    }

    public final boolean isPaired() {
        return this.isPaired;
    }
}
