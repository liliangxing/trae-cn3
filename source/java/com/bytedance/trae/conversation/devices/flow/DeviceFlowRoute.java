package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.BindingTarget;
import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.OfflineDeviceTarget;
import com.bytedance.trae.conversation.widget.ChatMode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowRoute.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "", "<init>", "()V", "DeviceSelect", "TargetSelect", "NewFeaturePrompt", "ConnectGuide", "ProjectSelect", "OfflineActivation", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class DeviceFlowRoute {
    public /* synthetic */ DeviceFlowRoute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeviceFlowRoute() {
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "mode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "preselectedDeviceId", "", "codeMode", "", "<init>", "(Lcom/bytedance/trae/conversation/widget/ChatMode;Ljava/lang/String;Z)V", "getMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "getPreselectedDeviceId", "()Ljava/lang/String;", "getCodeMode", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class DeviceSelect extends DeviceFlowRoute {
        private final boolean codeMode;
        private final ChatMode mode;
        private final String preselectedDeviceId;

        public static /* synthetic */ DeviceSelect copy$default(DeviceSelect deviceSelect, ChatMode chatMode, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                chatMode = deviceSelect.mode;
            }
            if ((i & 2) != 0) {
                str = deviceSelect.preselectedDeviceId;
            }
            if ((i & 4) != 0) {
                z = deviceSelect.codeMode;
            }
            return deviceSelect.copy(chatMode, str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final ChatMode getMode() {
            return this.mode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPreselectedDeviceId() {
            return this.preselectedDeviceId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCodeMode() {
            return this.codeMode;
        }

        public final DeviceSelect copy(ChatMode mode, String preselectedDeviceId, boolean codeMode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new DeviceSelect(mode, preselectedDeviceId, codeMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeviceSelect)) {
                return false;
            }
            DeviceSelect deviceSelect = (DeviceSelect) other;
            return this.mode == deviceSelect.mode && Intrinsics.areEqual(this.preselectedDeviceId, deviceSelect.preselectedDeviceId) && this.codeMode == deviceSelect.codeMode;
        }

        public int hashCode() {
            int hashCode = this.mode.hashCode() * 31;
            String str = this.preselectedDeviceId;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.codeMode);
        }

        public String toString() {
            return "DeviceSelect(mode=" + this.mode + ", preselectedDeviceId=" + this.preselectedDeviceId + ", codeMode=" + this.codeMode + ')';
        }

        public final ChatMode getMode() {
            return this.mode;
        }

        public final String getPreselectedDeviceId() {
            return this.preselectedDeviceId;
        }

        public final boolean getCodeMode() {
            return this.codeMode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceSelect(ChatMode chatMode, String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(chatMode, "mode");
            this.mode = chatMode;
            this.preselectedDeviceId = str;
            this.codeMode = z;
        }
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "availableTargets", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "existingDeviceIdsByProduct", "", "", "", "enterFrom", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getAvailableTargets", "()Ljava/util/List;", "getExistingDeviceIdsByProduct", "()Ljava/util/Map;", "getEnterFrom", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TargetSelect extends DeviceFlowRoute {
        private final List<DeviceProductType> availableTargets;
        private final String enterFrom;
        private final Map<DeviceProductType, Set<String>> existingDeviceIdsByProduct;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TargetSelect copy$default(TargetSelect targetSelect, List list, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = targetSelect.availableTargets;
            }
            if ((i & 2) != 0) {
                map = targetSelect.existingDeviceIdsByProduct;
            }
            if ((i & 4) != 0) {
                str = targetSelect.enterFrom;
            }
            return targetSelect.copy(list, map, str);
        }

        public final List<DeviceProductType> component1() {
            return this.availableTargets;
        }

        public final Map<DeviceProductType, Set<String>> component2() {
            return this.existingDeviceIdsByProduct;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final TargetSelect copy(List<? extends DeviceProductType> availableTargets, Map<DeviceProductType, ? extends Set<String>> existingDeviceIdsByProduct, String enterFrom) {
            Intrinsics.checkNotNullParameter(availableTargets, "availableTargets");
            Intrinsics.checkNotNullParameter(existingDeviceIdsByProduct, "existingDeviceIdsByProduct");
            Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
            return new TargetSelect(availableTargets, existingDeviceIdsByProduct, enterFrom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetSelect)) {
                return false;
            }
            TargetSelect targetSelect = (TargetSelect) other;
            return Intrinsics.areEqual(this.availableTargets, targetSelect.availableTargets) && Intrinsics.areEqual(this.existingDeviceIdsByProduct, targetSelect.existingDeviceIdsByProduct) && Intrinsics.areEqual(this.enterFrom, targetSelect.enterFrom);
        }

        public int hashCode() {
            return (((this.availableTargets.hashCode() * 31) + this.existingDeviceIdsByProduct.hashCode()) * 31) + this.enterFrom.hashCode();
        }

        public String toString() {
            return "TargetSelect(availableTargets=" + this.availableTargets + ", existingDeviceIdsByProduct=" + this.existingDeviceIdsByProduct + ", enterFrom=" + this.enterFrom + ')';
        }

        public final List<DeviceProductType> getAvailableTargets() {
            return this.availableTargets;
        }

        public final Map<DeviceProductType, Set<String>> getExistingDeviceIdsByProduct() {
            return this.existingDeviceIdsByProduct;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TargetSelect(List<? extends DeviceProductType> list, Map<DeviceProductType, ? extends Set<String>> map, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "availableTargets");
            Intrinsics.checkNotNullParameter(map, "existingDeviceIdsByProduct");
            Intrinsics.checkNotNullParameter(str, "enterFrom");
            this.availableTargets = list;
            this.existingDeviceIdsByProduct = map;
            this.enterFrom = str;
        }
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "devices", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "hasRegisteredWork", "", "hasRegisteredIDE", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;Ljava/util/List;ZZ)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getDevices", "()Ljava/util/List;", "getHasRegisteredWork", "()Z", "getHasRegisteredIDE", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class NewFeaturePrompt extends DeviceFlowRoute {
        private final List<MobileDevice> devices;
        private final boolean hasRegisteredIDE;
        private final boolean hasRegisteredWork;
        private final DeviceProductType productType;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NewFeaturePrompt copy$default(NewFeaturePrompt newFeaturePrompt, DeviceProductType deviceProductType, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceProductType = newFeaturePrompt.productType;
            }
            if ((i & 2) != 0) {
                list = newFeaturePrompt.devices;
            }
            if ((i & 4) != 0) {
                z = newFeaturePrompt.hasRegisteredWork;
            }
            if ((i & 8) != 0) {
                z2 = newFeaturePrompt.hasRegisteredIDE;
            }
            return newFeaturePrompt.copy(deviceProductType, list, z, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceProductType getProductType() {
            return this.productType;
        }

        public final List<MobileDevice> component2() {
            return this.devices;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHasRegisteredWork() {
            return this.hasRegisteredWork;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasRegisteredIDE() {
            return this.hasRegisteredIDE;
        }

        public final NewFeaturePrompt copy(DeviceProductType productType, List<MobileDevice> devices, boolean hasRegisteredWork, boolean hasRegisteredIDE) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(devices, "devices");
            return new NewFeaturePrompt(productType, devices, hasRegisteredWork, hasRegisteredIDE);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewFeaturePrompt)) {
                return false;
            }
            NewFeaturePrompt newFeaturePrompt = (NewFeaturePrompt) other;
            return this.productType == newFeaturePrompt.productType && Intrinsics.areEqual(this.devices, newFeaturePrompt.devices) && this.hasRegisteredWork == newFeaturePrompt.hasRegisteredWork && this.hasRegisteredIDE == newFeaturePrompt.hasRegisteredIDE;
        }

        public int hashCode() {
            return (((((this.productType.hashCode() * 31) + this.devices.hashCode()) * 31) + Boolean.hashCode(this.hasRegisteredWork)) * 31) + Boolean.hashCode(this.hasRegisteredIDE);
        }

        public String toString() {
            return "NewFeaturePrompt(productType=" + this.productType + ", devices=" + this.devices + ", hasRegisteredWork=" + this.hasRegisteredWork + ", hasRegisteredIDE=" + this.hasRegisteredIDE + ')';
        }

        public final DeviceProductType getProductType() {
            return this.productType;
        }

        public final List<MobileDevice> getDevices() {
            return this.devices;
        }

        public final boolean getHasRegisteredWork() {
            return this.hasRegisteredWork;
        }

        public final boolean getHasRegisteredIDE() {
            return this.hasRegisteredIDE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewFeaturePrompt(DeviceProductType deviceProductType, List<MobileDevice> list, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceProductType, "productType");
            Intrinsics.checkNotNullParameter(list, "devices");
            this.productType = deviceProductType;
            this.devices = list;
            this.hasRegisteredWork = z;
            this.hasRegisteredIDE = z2;
        }
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "target", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "<init>", "(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V", "getTarget", "()Lcom/bytedance/trae/conversation/devices/BindingTarget;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ConnectGuide extends DeviceFlowRoute {
        private final BindingTarget target;

        public static /* synthetic */ ConnectGuide copy$default(ConnectGuide connectGuide, BindingTarget bindingTarget, int i, Object obj) {
            if ((i & 1) != 0) {
                bindingTarget = connectGuide.target;
            }
            return connectGuide.copy(bindingTarget);
        }

        /* renamed from: component1, reason: from getter */
        public final BindingTarget getTarget() {
            return this.target;
        }

        public final ConnectGuide copy(BindingTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            return new ConnectGuide(target);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConnectGuide) && Intrinsics.areEqual(this.target, ((ConnectGuide) other).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "ConnectGuide(target=" + this.target + ')';
        }

        public final BindingTarget getTarget() {
            return this.target;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectGuide(BindingTarget bindingTarget) {
            super(null);
            Intrinsics.checkNotNullParameter(bindingTarget, "target");
            this.target = bindingTarget;
        }
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "device", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "mode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "showProductType", "", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceItem;Lcom/bytedance/trae/conversation/widget/ChatMode;Z)V", "getDevice", "()Lcom/bytedance/trae/conversation/devices/DeviceItem;", "getMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "getShowProductType", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ProjectSelect extends DeviceFlowRoute {
        private final DeviceItem device;
        private final ChatMode mode;
        private final boolean showProductType;

        public static /* synthetic */ ProjectSelect copy$default(ProjectSelect projectSelect, DeviceItem deviceItem, ChatMode chatMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceItem = projectSelect.device;
            }
            if ((i & 2) != 0) {
                chatMode = projectSelect.mode;
            }
            if ((i & 4) != 0) {
                z = projectSelect.showProductType;
            }
            return projectSelect.copy(deviceItem, chatMode, z);
        }

        /* renamed from: component1, reason: from getter */
        public final DeviceItem getDevice() {
            return this.device;
        }

        /* renamed from: component2, reason: from getter */
        public final ChatMode getMode() {
            return this.mode;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowProductType() {
            return this.showProductType;
        }

        public final ProjectSelect copy(DeviceItem device, ChatMode mode, boolean showProductType) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new ProjectSelect(device, mode, showProductType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProjectSelect)) {
                return false;
            }
            ProjectSelect projectSelect = (ProjectSelect) other;
            return Intrinsics.areEqual(this.device, projectSelect.device) && this.mode == projectSelect.mode && this.showProductType == projectSelect.showProductType;
        }

        public int hashCode() {
            return (((this.device.hashCode() * 31) + this.mode.hashCode()) * 31) + Boolean.hashCode(this.showProductType);
        }

        public String toString() {
            return "ProjectSelect(device=" + this.device + ", mode=" + this.mode + ", showProductType=" + this.showProductType + ')';
        }

        public final DeviceItem getDevice() {
            return this.device;
        }

        public final ChatMode getMode() {
            return this.mode;
        }

        public final boolean getShowProductType() {
            return this.showProductType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProjectSelect(DeviceItem deviceItem, ChatMode chatMode, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceItem, "device");
            Intrinsics.checkNotNullParameter(chatMode, "mode");
            this.device = deviceItem;
            this.mode = chatMode;
            this.showProductType = z;
        }
    }

    /* compiled from: DeviceFlowRoute.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "target", "Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "onClosed", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;Lkotlin/jvm/functions/Function0;)V", "getTarget", "()Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "getOnClosed", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OfflineActivation extends DeviceFlowRoute {
        private final Function0<Unit> onClosed;
        private final OfflineDeviceTarget target;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OfflineActivation copy$default(OfflineActivation offlineActivation, OfflineDeviceTarget offlineDeviceTarget, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                offlineDeviceTarget = offlineActivation.target;
            }
            if ((i & 2) != 0) {
                function0 = offlineActivation.onClosed;
            }
            return offlineActivation.copy(offlineDeviceTarget, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final OfflineDeviceTarget getTarget() {
            return this.target;
        }

        public final Function0<Unit> component2() {
            return this.onClosed;
        }

        public final OfflineActivation copy(OfflineDeviceTarget target, Function0<Unit> onClosed) {
            Intrinsics.checkNotNullParameter(target, "target");
            return new OfflineActivation(target, onClosed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfflineActivation)) {
                return false;
            }
            OfflineActivation offlineActivation = (OfflineActivation) other;
            return Intrinsics.areEqual(this.target, offlineActivation.target) && Intrinsics.areEqual(this.onClosed, offlineActivation.onClosed);
        }

        public int hashCode() {
            int hashCode = this.target.hashCode() * 31;
            Function0<Unit> function0 = this.onClosed;
            return hashCode + (function0 == null ? 0 : function0.hashCode());
        }

        public String toString() {
            return "OfflineActivation(target=" + this.target + ", onClosed=" + this.onClosed + ')';
        }

        public /* synthetic */ OfflineActivation(OfflineDeviceTarget offlineDeviceTarget, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(offlineDeviceTarget, (i & 2) != 0 ? null : function0);
        }

        public final OfflineDeviceTarget getTarget() {
            return this.target;
        }

        public final Function0<Unit> getOnClosed() {
            return this.onClosed;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfflineActivation(OfflineDeviceTarget offlineDeviceTarget, Function0<Unit> function0) {
            super(null);
            Intrinsics.checkNotNullParameter(offlineDeviceTarget, "target");
            this.target = offlineDeviceTarget;
            this.onClosed = function0;
        }
    }
}
