package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowDeviceClickPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "", "<init>", "()V", "SelectDeviceDirectly", "ProjectSelect", "OfflineActivation", "BindingGuide", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DeviceFlowDeviceClickRoute {
    public /* synthetic */ DeviceFlowDeviceClickRoute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DeviceFlowDeviceClickPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SelectDeviceDirectly extends DeviceFlowDeviceClickRoute {
        public static final SelectDeviceDirectly INSTANCE = new SelectDeviceDirectly();

        private SelectDeviceDirectly() {
            super(null);
        }
    }

    private DeviceFlowDeviceClickRoute() {
    }

    /* compiled from: DeviceFlowDeviceClickPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ProjectSelect extends DeviceFlowDeviceClickRoute {
        public static final ProjectSelect INSTANCE = new ProjectSelect();

        private ProjectSelect() {
            super(null);
        }
    }

    /* compiled from: DeviceFlowDeviceClickPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "isPaired", "", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;Z)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OfflineActivation extends DeviceFlowDeviceClickRoute {
        private final boolean isPaired;
        private final DeviceProductType productType;

        public static /* synthetic */ OfflineActivation copy$default(OfflineActivation offlineActivation, DeviceProductType deviceProductType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceProductType = offlineActivation.productType;
            }
            if ((i & 2) != 0) {
                z = offlineActivation.isPaired;
            }
            return offlineActivation.copy(deviceProductType, z);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceProductType getProductType() {
            return this.productType;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsPaired() {
            return this.isPaired;
        }

        public final OfflineActivation copy(DeviceProductType productType, boolean isPaired) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            return new OfflineActivation(productType, isPaired);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfflineActivation)) {
                return false;
            }
            OfflineActivation offlineActivation = (OfflineActivation) other;
            return this.productType == offlineActivation.productType && this.isPaired == offlineActivation.isPaired;
        }

        public int hashCode() {
            return (this.productType.hashCode() * 31) + Boolean.hashCode(this.isPaired);
        }

        public String toString() {
            return "OfflineActivation(productType=" + this.productType + ", isPaired=" + this.isPaired + ')';
        }

        public /* synthetic */ OfflineActivation(DeviceProductType deviceProductType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(deviceProductType, (i & 2) != 0 ? true : z);
        }

        public final DeviceProductType getProductType() {
            return this.productType;
        }

        public final boolean isPaired() {
            return this.isPaired;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfflineActivation(DeviceProductType productType, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(productType, "productType");
            this.productType = productType;
            this.isPaired = z;
        }
    }

    /* compiled from: DeviceFlowDeviceClickPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class BindingGuide extends DeviceFlowDeviceClickRoute {
        private final DeviceProductType productType;

        public static /* synthetic */ BindingGuide copy$default(BindingGuide bindingGuide, DeviceProductType deviceProductType, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceProductType = bindingGuide.productType;
            }
            return bindingGuide.copy(deviceProductType);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceProductType getProductType() {
            return this.productType;
        }

        public final BindingGuide copy(DeviceProductType productType) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            return new BindingGuide(productType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BindingGuide) && this.productType == ((BindingGuide) other).productType;
        }

        public int hashCode() {
            return this.productType.hashCode();
        }

        public String toString() {
            return "BindingGuide(productType=" + this.productType + ')';
        }

        public final DeviceProductType getProductType() {
            return this.productType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BindingGuide(DeviceProductType productType) {
            super(null);
            Intrinsics.checkNotNullParameter(productType, "productType");
            this.productType = productType;
        }
    }
}
