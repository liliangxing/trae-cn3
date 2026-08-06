package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003J[\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÇ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010*\u001a\u00020+H×\u0001J\t\u0010,\u001a\u00020-H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u0006."}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;", "", "loading", "", "loadFailed", "devices", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "selectedGuideProduct", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "actionMenu", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;", "renameDialog", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;", "deleteDialog", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;", "<init>", "(ZZLjava/util/List;Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)V", "getLoading", "()Z", "getLoadFailed", "getDevices", "()Ljava/util/List;", "getSelectedGuideProduct", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "getActionMenu", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;", "getRenameDialog", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;", "getDeleteDialog", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;", "isEmpty", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class DeviceManagementUiState {
    public static final int $stable = 8;
    private final DeviceManagementMenuState actionMenu;
    private final DeviceManagementDeleteState deleteDialog;
    private final List<DeviceManagementDevice> devices;
    private final boolean loadFailed;
    private final boolean loading;
    private final DeviceManagementRenameState renameDialog;
    private final DeviceManagementProduct selectedGuideProduct;

    public DeviceManagementUiState() {
        this(false, false, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ DeviceManagementUiState copy$default(DeviceManagementUiState deviceManagementUiState, boolean z, boolean z2, List list, DeviceManagementProduct deviceManagementProduct, DeviceManagementMenuState deviceManagementMenuState, DeviceManagementRenameState deviceManagementRenameState, DeviceManagementDeleteState deviceManagementDeleteState, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deviceManagementUiState.loading;
        }
        if ((i & 2) != 0) {
            z2 = deviceManagementUiState.loadFailed;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            list = deviceManagementUiState.devices;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            deviceManagementProduct = deviceManagementUiState.selectedGuideProduct;
        }
        DeviceManagementProduct deviceManagementProduct2 = deviceManagementProduct;
        if ((i & 16) != 0) {
            deviceManagementMenuState = deviceManagementUiState.actionMenu;
        }
        DeviceManagementMenuState deviceManagementMenuState2 = deviceManagementMenuState;
        if ((i & 32) != 0) {
            deviceManagementRenameState = deviceManagementUiState.renameDialog;
        }
        DeviceManagementRenameState deviceManagementRenameState2 = deviceManagementRenameState;
        if ((i & 64) != 0) {
            deviceManagementDeleteState = deviceManagementUiState.deleteDialog;
        }
        return deviceManagementUiState.copy(z, z3, list2, deviceManagementProduct2, deviceManagementMenuState2, deviceManagementRenameState2, deviceManagementDeleteState);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLoadFailed() {
        return this.loadFailed;
    }

    public final List<DeviceManagementDevice> component3() {
        return this.devices;
    }

    /* renamed from: component4, reason: from getter */
    public final DeviceManagementProduct getSelectedGuideProduct() {
        return this.selectedGuideProduct;
    }

    /* renamed from: component5, reason: from getter */
    public final DeviceManagementMenuState getActionMenu() {
        return this.actionMenu;
    }

    /* renamed from: component6, reason: from getter */
    public final DeviceManagementRenameState getRenameDialog() {
        return this.renameDialog;
    }

    /* renamed from: component7, reason: from getter */
    public final DeviceManagementDeleteState getDeleteDialog() {
        return this.deleteDialog;
    }

    public final DeviceManagementUiState copy(boolean loading, boolean loadFailed, List<DeviceManagementDevice> devices, DeviceManagementProduct selectedGuideProduct, DeviceManagementMenuState actionMenu, DeviceManagementRenameState renameDialog, DeviceManagementDeleteState deleteDialog) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        Intrinsics.checkNotNullParameter(selectedGuideProduct, "selectedGuideProduct");
        return new DeviceManagementUiState(loading, loadFailed, devices, selectedGuideProduct, actionMenu, renameDialog, deleteDialog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceManagementUiState)) {
            return false;
        }
        DeviceManagementUiState deviceManagementUiState = (DeviceManagementUiState) other;
        return this.loading == deviceManagementUiState.loading && this.loadFailed == deviceManagementUiState.loadFailed && Intrinsics.areEqual(this.devices, deviceManagementUiState.devices) && this.selectedGuideProduct == deviceManagementUiState.selectedGuideProduct && Intrinsics.areEqual(this.actionMenu, deviceManagementUiState.actionMenu) && Intrinsics.areEqual(this.renameDialog, deviceManagementUiState.renameDialog) && Intrinsics.areEqual(this.deleteDialog, deviceManagementUiState.deleteDialog);
    }

    public int hashCode() {
        int hashCode = ((((((Boolean.hashCode(this.loading) * 31) + Boolean.hashCode(this.loadFailed)) * 31) + this.devices.hashCode()) * 31) + this.selectedGuideProduct.hashCode()) * 31;
        DeviceManagementMenuState deviceManagementMenuState = this.actionMenu;
        int hashCode2 = (hashCode + (deviceManagementMenuState == null ? 0 : deviceManagementMenuState.hashCode())) * 31;
        DeviceManagementRenameState deviceManagementRenameState = this.renameDialog;
        int hashCode3 = (hashCode2 + (deviceManagementRenameState == null ? 0 : deviceManagementRenameState.hashCode())) * 31;
        DeviceManagementDeleteState deviceManagementDeleteState = this.deleteDialog;
        return hashCode3 + (deviceManagementDeleteState != null ? deviceManagementDeleteState.hashCode() : 0);
    }

    public String toString() {
        return "DeviceManagementUiState(loading=" + this.loading + ", loadFailed=" + this.loadFailed + ", devices=" + this.devices + ", selectedGuideProduct=" + this.selectedGuideProduct + ", actionMenu=" + this.actionMenu + ", renameDialog=" + this.renameDialog + ", deleteDialog=" + this.deleteDialog + ')';
    }

    public DeviceManagementUiState(boolean z, boolean z2, List<DeviceManagementDevice> list, DeviceManagementProduct deviceManagementProduct, DeviceManagementMenuState deviceManagementMenuState, DeviceManagementRenameState deviceManagementRenameState, DeviceManagementDeleteState deviceManagementDeleteState) {
        Intrinsics.checkNotNullParameter(list, "devices");
        Intrinsics.checkNotNullParameter(deviceManagementProduct, "selectedGuideProduct");
        this.loading = z;
        this.loadFailed = z2;
        this.devices = list;
        this.selectedGuideProduct = deviceManagementProduct;
        this.actionMenu = deviceManagementMenuState;
        this.renameDialog = deviceManagementRenameState;
        this.deleteDialog = deviceManagementDeleteState;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final boolean getLoadFailed() {
        return this.loadFailed;
    }

    public /* synthetic */ DeviceManagementUiState(boolean z, boolean z2, List list, DeviceManagementProduct deviceManagementProduct, DeviceManagementMenuState deviceManagementMenuState, DeviceManagementRenameState deviceManagementRenameState, DeviceManagementDeleteState deviceManagementDeleteState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? DeviceManagementProduct.Work : deviceManagementProduct, (i & 16) != 0 ? null : deviceManagementMenuState, (i & 32) != 0 ? null : deviceManagementRenameState, (i & 64) != 0 ? null : deviceManagementDeleteState);
    }

    public final List<DeviceManagementDevice> getDevices() {
        return this.devices;
    }

    public final DeviceManagementProduct getSelectedGuideProduct() {
        return this.selectedGuideProduct;
    }

    public final DeviceManagementMenuState getActionMenu() {
        return this.actionMenu;
    }

    public final DeviceManagementRenameState getRenameDialog() {
        return this.renameDialog;
    }

    public final DeviceManagementDeleteState getDeleteDialog() {
        return this.deleteDialog;
    }

    public final boolean isEmpty() {
        return !this.loading && this.devices.isEmpty();
    }
}
