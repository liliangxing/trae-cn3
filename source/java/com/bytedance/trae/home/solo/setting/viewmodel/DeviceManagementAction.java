package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u0082\u0001\u000b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "", "Refresh", "SelectGuideProduct", "CopyGuideUrl", "OpenMenu", "CloseMenu", "OpenRename", "CloseRename", "SubmitRename", "OpenDelete", "CloseDelete", "ConfirmDelete", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseMenu;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CopyGuideUrl;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenRename;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$Refresh;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SelectGuideProduct;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface DeviceManagementAction {

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$Refresh;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Refresh implements DeviceManagementAction {
        public static final int $stable = 0;
        public static final Refresh INSTANCE = new Refresh();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Refresh)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1136135520;
        }

        public String toString() {
            return "Refresh";
        }

        private Refresh() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SelectGuideProduct;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "product", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)V", "getProduct", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SelectGuideProduct implements DeviceManagementAction {
        public static final int $stable = 0;
        private final DeviceManagementProduct product;

        public static /* synthetic */ SelectGuideProduct copy$default(SelectGuideProduct selectGuideProduct, DeviceManagementProduct deviceManagementProduct, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementProduct = selectGuideProduct.product;
            }
            return selectGuideProduct.copy(deviceManagementProduct);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementProduct getProduct() {
            return this.product;
        }

        public final SelectGuideProduct copy(DeviceManagementProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new SelectGuideProduct(product);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SelectGuideProduct) && this.product == ((SelectGuideProduct) other).product;
        }

        public int hashCode() {
            return this.product.hashCode();
        }

        public String toString() {
            return "SelectGuideProduct(product=" + this.product + ')';
        }

        public SelectGuideProduct(DeviceManagementProduct deviceManagementProduct) {
            Intrinsics.checkNotNullParameter(deviceManagementProduct, "product");
            this.product = deviceManagementProduct;
        }

        public final DeviceManagementProduct getProduct() {
            return this.product;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CopyGuideUrl;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CopyGuideUrl implements DeviceManagementAction {
        public static final int $stable = 0;
        public static final CopyGuideUrl INSTANCE = new CopyGuideUrl();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CopyGuideUrl)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1563131907;
        }

        public String toString() {
            return "CopyGuideUrl";
        }

        private CopyGuideUrl() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH×\u0003J\t\u0010\u001b\u001a\u00020\u001cH×\u0001J\t\u0010\u001d\u001a\u00020\u001eH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;", "anchorX", "", "anchorY", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;FF)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "getSource", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;", "getAnchorX", "()F", "getAnchorY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OpenMenu implements DeviceManagementAction {
        public static final int $stable = 0;
        private final float anchorX;
        private final float anchorY;
        private final DeviceManagementDevice device;
        private final DeviceManagementMenuSource source;

        public static /* synthetic */ OpenMenu copy$default(OpenMenu openMenu, DeviceManagementDevice deviceManagementDevice, DeviceManagementMenuSource deviceManagementMenuSource, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementDevice = openMenu.device;
            }
            if ((i & 2) != 0) {
                deviceManagementMenuSource = openMenu.source;
            }
            if ((i & 4) != 0) {
                f = openMenu.anchorX;
            }
            if ((i & 8) != 0) {
                f2 = openMenu.anchorY;
            }
            return openMenu.copy(deviceManagementDevice, deviceManagementMenuSource, f, f2);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        /* renamed from: component2, reason: from getter */
        public final DeviceManagementMenuSource getSource() {
            return this.source;
        }

        /* renamed from: component3, reason: from getter */
        public final float getAnchorX() {
            return this.anchorX;
        }

        /* renamed from: component4, reason: from getter */
        public final float getAnchorY() {
            return this.anchorY;
        }

        public final OpenMenu copy(DeviceManagementDevice device, DeviceManagementMenuSource source, float anchorX, float anchorY) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
            return new OpenMenu(device, source, anchorX, anchorY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenMenu)) {
                return false;
            }
            OpenMenu openMenu = (OpenMenu) other;
            return Intrinsics.areEqual(this.device, openMenu.device) && this.source == openMenu.source && Float.compare(this.anchorX, openMenu.anchorX) == 0 && Float.compare(this.anchorY, openMenu.anchorY) == 0;
        }

        public int hashCode() {
            return (((((this.device.hashCode() * 31) + this.source.hashCode()) * 31) + Float.hashCode(this.anchorX)) * 31) + Float.hashCode(this.anchorY);
        }

        public String toString() {
            return "OpenMenu(device=" + this.device + ", source=" + this.source + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ')';
        }

        public OpenMenu(DeviceManagementDevice deviceManagementDevice, DeviceManagementMenuSource deviceManagementMenuSource, float f, float f2) {
            Intrinsics.checkNotNullParameter(deviceManagementDevice, "device");
            Intrinsics.checkNotNullParameter(deviceManagementMenuSource, TimonPipeline.KEY_SOURCE);
            this.device = deviceManagementDevice;
            this.source = deviceManagementMenuSource;
            this.anchorX = f;
            this.anchorY = f2;
        }

        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        public final DeviceManagementMenuSource getSource() {
            return this.source;
        }

        public final float getAnchorX() {
            return this.anchorX;
        }

        public final float getAnchorY() {
            return this.anchorY;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseMenu;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CloseMenu implements DeviceManagementAction {
        public static final int $stable = 0;
        public static final CloseMenu INSTANCE = new CloseMenu();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseMenu)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 986421436;
        }

        public String toString() {
            return "CloseMenu";
        }

        private CloseMenu() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenRename;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OpenRename implements DeviceManagementAction {
        public static final int $stable = 0;
        private final DeviceManagementDevice device;

        public static /* synthetic */ OpenRename copy$default(OpenRename openRename, DeviceManagementDevice deviceManagementDevice, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementDevice = openRename.device;
            }
            return openRename.copy(deviceManagementDevice);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        public final OpenRename copy(DeviceManagementDevice device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new OpenRename(device);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OpenRename) && Intrinsics.areEqual(this.device, ((OpenRename) other).device);
        }

        public int hashCode() {
            return this.device.hashCode();
        }

        public String toString() {
            return "OpenRename(device=" + this.device + ')';
        }

        public OpenRename(DeviceManagementDevice deviceManagementDevice) {
            Intrinsics.checkNotNullParameter(deviceManagementDevice, "device");
            this.device = deviceManagementDevice;
        }

        public final DeviceManagementDevice getDevice() {
            return this.device;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CloseRename implements DeviceManagementAction {
        public static final int $stable = 0;
        public static final CloseRename INSTANCE = new CloseRename();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseRename)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1093642405;
        }

        public String toString() {
            return "CloseRename";
        }

        private CloseRename() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "name", "", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;Ljava/lang/String;)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubmitRename implements DeviceManagementAction {
        public static final int $stable = 0;
        private final DeviceManagementDevice device;
        private final String name;

        public static /* synthetic */ SubmitRename copy$default(SubmitRename submitRename, DeviceManagementDevice deviceManagementDevice, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementDevice = submitRename.device;
            }
            if ((i & 2) != 0) {
                str = submitRename.name;
            }
            return submitRename.copy(deviceManagementDevice, str);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final SubmitRename copy(DeviceManagementDevice device, String name) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(name, "name");
            return new SubmitRename(device, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubmitRename)) {
                return false;
            }
            SubmitRename submitRename = (SubmitRename) other;
            return Intrinsics.areEqual(this.device, submitRename.device) && Intrinsics.areEqual(this.name, submitRename.name);
        }

        public int hashCode() {
            return (this.device.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "SubmitRename(device=" + this.device + ", name=" + this.name + ')';
        }

        public SubmitRename(DeviceManagementDevice deviceManagementDevice, String str) {
            Intrinsics.checkNotNullParameter(deviceManagementDevice, "device");
            Intrinsics.checkNotNullParameter(str, "name");
            this.device = deviceManagementDevice;
            this.name = str;
        }

        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OpenDelete implements DeviceManagementAction {
        public static final int $stable = 0;
        private final DeviceManagementDevice device;

        public static /* synthetic */ OpenDelete copy$default(OpenDelete openDelete, DeviceManagementDevice deviceManagementDevice, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementDevice = openDelete.device;
            }
            return openDelete.copy(deviceManagementDevice);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        public final OpenDelete copy(DeviceManagementDevice device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new OpenDelete(device);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OpenDelete) && Intrinsics.areEqual(this.device, ((OpenDelete) other).device);
        }

        public int hashCode() {
            return this.device.hashCode();
        }

        public String toString() {
            return "OpenDelete(device=" + this.device + ')';
        }

        public OpenDelete(DeviceManagementDevice deviceManagementDevice) {
            Intrinsics.checkNotNullParameter(deviceManagementDevice, "device");
            this.device = deviceManagementDevice;
        }

        public final DeviceManagementDevice getDevice() {
            return this.device;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CloseDelete implements DeviceManagementAction {
        public static final int $stable = 0;
        public static final CloseDelete INSTANCE = new CloseDelete();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseDelete)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1494506040;
        }

        public String toString() {
            return "CloseDelete";
        }

        private CloseDelete() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ConfirmDelete implements DeviceManagementAction {
        public static final int $stable = 0;
        private final DeviceManagementDevice device;

        public static /* synthetic */ ConfirmDelete copy$default(ConfirmDelete confirmDelete, DeviceManagementDevice deviceManagementDevice, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceManagementDevice = confirmDelete.device;
            }
            return confirmDelete.copy(deviceManagementDevice);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceManagementDevice getDevice() {
            return this.device;
        }

        public final ConfirmDelete copy(DeviceManagementDevice device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new ConfirmDelete(device);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConfirmDelete) && Intrinsics.areEqual(this.device, ((ConfirmDelete) other).device);
        }

        public int hashCode() {
            return this.device.hashCode();
        }

        public String toString() {
            return "ConfirmDelete(device=" + this.device + ')';
        }

        public ConfirmDelete(DeviceManagementDevice deviceManagementDevice) {
            Intrinsics.checkNotNullParameter(deviceManagementDevice, "device");
            this.device = deviceManagementDevice;
        }

        public final DeviceManagementDevice getDevice() {
            return this.device;
        }
    }
}
