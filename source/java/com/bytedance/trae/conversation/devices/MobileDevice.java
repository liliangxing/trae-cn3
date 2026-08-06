package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MobileDevice.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/devices/MobileDevice;", "", "id", "", "name", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "isOnline", "", "ideVersion", "isPaired", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/devices/DeviceProductType;ZLjava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getName", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "()Z", "getIdeVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MobileDevice {
    private final String id;
    private final String ideVersion;
    private final boolean isOnline;
    private final boolean isPaired;
    private final String name;
    private final DeviceProductType productType;

    public static /* synthetic */ MobileDevice copy$default(MobileDevice mobileDevice, String str, String str2, DeviceProductType deviceProductType, boolean z, String str3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileDevice.id;
        }
        if ((i & 2) != 0) {
            str2 = mobileDevice.name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            deviceProductType = mobileDevice.productType;
        }
        DeviceProductType deviceProductType2 = deviceProductType;
        if ((i & 8) != 0) {
            z = mobileDevice.isOnline;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            str3 = mobileDevice.ideVersion;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            z2 = mobileDevice.isPaired;
        }
        return mobileDevice.copy(str, str4, deviceProductType2, z3, str5, z2);
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
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIdeVersion() {
        return this.ideVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsPaired() {
        return this.isPaired;
    }

    public final MobileDevice copy(String id, String name, DeviceProductType productType, boolean isOnline, String ideVersion, boolean isPaired) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new MobileDevice(id, name, productType, isOnline, ideVersion, isPaired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileDevice)) {
            return false;
        }
        MobileDevice mobileDevice = (MobileDevice) other;
        return Intrinsics.areEqual(this.id, mobileDevice.id) && Intrinsics.areEqual(this.name, mobileDevice.name) && this.productType == mobileDevice.productType && this.isOnline == mobileDevice.isOnline && Intrinsics.areEqual(this.ideVersion, mobileDevice.ideVersion) && this.isPaired == mobileDevice.isPaired;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.isOnline)) * 31;
        String str = this.ideVersion;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isPaired);
    }

    public String toString() {
        return "MobileDevice(id=" + this.id + ", name=" + this.name + ", productType=" + this.productType + ", isOnline=" + this.isOnline + ", ideVersion=" + this.ideVersion + ", isPaired=" + this.isPaired + ')';
    }

    public MobileDevice(String id, String name, DeviceProductType productType, boolean z, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.isOnline = z;
        this.ideVersion = str;
        this.isPaired = z2;
    }

    public /* synthetic */ MobileDevice(String str, String str2, DeviceProductType deviceProductType, boolean z, String str3, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, deviceProductType, z, str3, (i & 32) != 0 ? true : z2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final String getIdeVersion() {
        return this.ideVersion;
    }

    public final boolean isPaired() {
        return this.isPaired;
    }
}
