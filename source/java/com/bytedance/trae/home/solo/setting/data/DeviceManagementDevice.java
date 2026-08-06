package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u001dH×\u0001J\t\u0010\u001e\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "", "id", "", "name", StrategyConstants.MODEL, "online", "", "product", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)V", "getId", "()Ljava/lang/String;", "getName", "getModel", "getOnline", "()Z", "getProduct", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceManagementDevice {
    public static final int $stable = 0;
    private final String id;
    private final String model;
    private final String name;
    private final boolean online;
    private final DeviceManagementProduct product;

    public static /* synthetic */ DeviceManagementDevice copy$default(DeviceManagementDevice deviceManagementDevice, String str, String str2, String str3, boolean z, DeviceManagementProduct deviceManagementProduct, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceManagementDevice.id;
        }
        if ((i & 2) != 0) {
            str2 = deviceManagementDevice.name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = deviceManagementDevice.model;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = deviceManagementDevice.online;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            deviceManagementProduct = deviceManagementDevice.product;
        }
        return deviceManagementDevice.copy(str, str4, str5, z2, deviceManagementProduct);
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
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    /* renamed from: component5, reason: from getter */
    public final DeviceManagementProduct getProduct() {
        return this.product;
    }

    public final DeviceManagementDevice copy(String id, String name, String model, boolean online, DeviceManagementProduct product) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(product, "product");
        return new DeviceManagementDevice(id, name, model, online, product);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceManagementDevice)) {
            return false;
        }
        DeviceManagementDevice deviceManagementDevice = (DeviceManagementDevice) other;
        return Intrinsics.areEqual(this.id, deviceManagementDevice.id) && Intrinsics.areEqual(this.name, deviceManagementDevice.name) && Intrinsics.areEqual(this.model, deviceManagementDevice.model) && this.online == deviceManagementDevice.online && this.product == deviceManagementDevice.product;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.model.hashCode()) * 31) + Boolean.hashCode(this.online)) * 31) + this.product.hashCode();
    }

    public String toString() {
        return "DeviceManagementDevice(id=" + this.id + ", name=" + this.name + ", model=" + this.model + ", online=" + this.online + ", product=" + this.product + ')';
    }

    public DeviceManagementDevice(String id, String name, String model, boolean z, DeviceManagementProduct product) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(product, "product");
        this.id = id;
        this.name = name;
        this.model = model;
        this.online = z;
        this.product = product;
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

    public final boolean getOnline() {
        return this.online;
    }

    public final DeviceManagementProduct getProduct() {
        return this.product;
    }
}
