package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "", "devices", "", "Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "maxDeviceCount", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getDevices", "()Ljava/util/List;", "getMaxDeviceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ListDevicesResult {

    @SerializedName("Devices")
    private final List<DeviceSummary> devices;

    @SerializedName("MaxDeviceCount")
    private final Integer maxDeviceCount;

    /* JADX WARN: Multi-variable type inference failed */
    public ListDevicesResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListDevicesResult copy$default(ListDevicesResult listDevicesResult, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listDevicesResult.devices;
        }
        if ((i & 2) != 0) {
            num = listDevicesResult.maxDeviceCount;
        }
        return listDevicesResult.copy(list, num);
    }

    public final List<DeviceSummary> component1() {
        return this.devices;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMaxDeviceCount() {
        return this.maxDeviceCount;
    }

    public final ListDevicesResult copy(List<DeviceSummary> devices, Integer maxDeviceCount) {
        return new ListDevicesResult(devices, maxDeviceCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListDevicesResult)) {
            return false;
        }
        ListDevicesResult listDevicesResult = (ListDevicesResult) other;
        return Intrinsics.areEqual(this.devices, listDevicesResult.devices) && Intrinsics.areEqual(this.maxDeviceCount, listDevicesResult.maxDeviceCount);
    }

    public int hashCode() {
        List<DeviceSummary> list = this.devices;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.maxDeviceCount;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ListDevicesResult(devices=" + this.devices + ", maxDeviceCount=" + this.maxDeviceCount + ')';
    }

    public ListDevicesResult(List<DeviceSummary> list, Integer num) {
        this.devices = list;
        this.maxDeviceCount = num;
    }

    public /* synthetic */ ListDevicesResult(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num);
    }

    public final List<DeviceSummary> getDevices() {
        return this.devices;
    }

    public final Integer getMaxDeviceCount() {
        return this.maxDeviceCount;
    }
}
