package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowCallbacks.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003J\u0093\u0001\u0010 \u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;", "", "onDeviceSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "", "onDeviceListChanged", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "onNewFeaturePromptConfirmed", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "onConnectionSuccess", "Lkotlin/Function0;", "onConnectionSuccessWithDevice", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "onDismiss", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getOnDeviceSelected", "()Lkotlin/jvm/functions/Function1;", "getOnDeviceListChanged", "getOnNewFeaturePromptConfirmed", "getOnConnectionSuccess", "()Lkotlin/jvm/functions/Function0;", "getOnConnectionSuccessWithDevice", "getOnDismiss", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class DeviceFlowCallbacks {
    private final Function0<Unit> onConnectionSuccess;
    private final Function1<MobileDevice, Unit> onConnectionSuccessWithDevice;
    private final Function1<List<DeviceItem>, Unit> onDeviceListChanged;
    private final Function1<SelectedDeviceItem, Unit> onDeviceSelected;
    private final Function0<Unit> onDismiss;
    private final Function1<DeviceProductType, Unit> onNewFeaturePromptConfirmed;

    public DeviceFlowCallbacks() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DeviceFlowCallbacks copy$default(DeviceFlowCallbacks deviceFlowCallbacks, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function1 function14, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = deviceFlowCallbacks.onDeviceSelected;
        }
        if ((i & 2) != 0) {
            function12 = deviceFlowCallbacks.onDeviceListChanged;
        }
        Function1 function15 = function12;
        if ((i & 4) != 0) {
            function13 = deviceFlowCallbacks.onNewFeaturePromptConfirmed;
        }
        Function1 function16 = function13;
        if ((i & 8) != 0) {
            function0 = deviceFlowCallbacks.onConnectionSuccess;
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function14 = deviceFlowCallbacks.onConnectionSuccessWithDevice;
        }
        Function1 function17 = function14;
        if ((i & 32) != 0) {
            function02 = deviceFlowCallbacks.onDismiss;
        }
        return deviceFlowCallbacks.copy(function1, function15, function16, function03, function17, function02);
    }

    public final Function1<SelectedDeviceItem, Unit> component1() {
        return this.onDeviceSelected;
    }

    public final Function1<List<DeviceItem>, Unit> component2() {
        return this.onDeviceListChanged;
    }

    public final Function1<DeviceProductType, Unit> component3() {
        return this.onNewFeaturePromptConfirmed;
    }

    public final Function0<Unit> component4() {
        return this.onConnectionSuccess;
    }

    public final Function1<MobileDevice, Unit> component5() {
        return this.onConnectionSuccessWithDevice;
    }

    public final Function0<Unit> component6() {
        return this.onDismiss;
    }

    public final DeviceFlowCallbacks copy(Function1<? super SelectedDeviceItem, Unit> onDeviceSelected, Function1<? super List<DeviceItem>, Unit> onDeviceListChanged, Function1<? super DeviceProductType, Unit> onNewFeaturePromptConfirmed, Function0<Unit> onConnectionSuccess, Function1<? super MobileDevice, Unit> onConnectionSuccessWithDevice, Function0<Unit> onDismiss) {
        return new DeviceFlowCallbacks(onDeviceSelected, onDeviceListChanged, onNewFeaturePromptConfirmed, onConnectionSuccess, onConnectionSuccessWithDevice, onDismiss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceFlowCallbacks)) {
            return false;
        }
        DeviceFlowCallbacks deviceFlowCallbacks = (DeviceFlowCallbacks) other;
        return Intrinsics.areEqual(this.onDeviceSelected, deviceFlowCallbacks.onDeviceSelected) && Intrinsics.areEqual(this.onDeviceListChanged, deviceFlowCallbacks.onDeviceListChanged) && Intrinsics.areEqual(this.onNewFeaturePromptConfirmed, deviceFlowCallbacks.onNewFeaturePromptConfirmed) && Intrinsics.areEqual(this.onConnectionSuccess, deviceFlowCallbacks.onConnectionSuccess) && Intrinsics.areEqual(this.onConnectionSuccessWithDevice, deviceFlowCallbacks.onConnectionSuccessWithDevice) && Intrinsics.areEqual(this.onDismiss, deviceFlowCallbacks.onDismiss);
    }

    public int hashCode() {
        Function1<SelectedDeviceItem, Unit> function1 = this.onDeviceSelected;
        int hashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<List<DeviceItem>, Unit> function12 = this.onDeviceListChanged;
        int hashCode2 = (hashCode + (function12 == null ? 0 : function12.hashCode())) * 31;
        Function1<DeviceProductType, Unit> function13 = this.onNewFeaturePromptConfirmed;
        int hashCode3 = (hashCode2 + (function13 == null ? 0 : function13.hashCode())) * 31;
        Function0<Unit> function0 = this.onConnectionSuccess;
        int hashCode4 = (hashCode3 + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function1<MobileDevice, Unit> function14 = this.onConnectionSuccessWithDevice;
        int hashCode5 = (hashCode4 + (function14 == null ? 0 : function14.hashCode())) * 31;
        Function0<Unit> function02 = this.onDismiss;
        return hashCode5 + (function02 != null ? function02.hashCode() : 0);
    }

    public String toString() {
        return "DeviceFlowCallbacks(onDeviceSelected=" + this.onDeviceSelected + ", onDeviceListChanged=" + this.onDeviceListChanged + ", onNewFeaturePromptConfirmed=" + this.onNewFeaturePromptConfirmed + ", onConnectionSuccess=" + this.onConnectionSuccess + ", onConnectionSuccessWithDevice=" + this.onConnectionSuccessWithDevice + ", onDismiss=" + this.onDismiss + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceFlowCallbacks(Function1<? super SelectedDeviceItem, Unit> function1, Function1<? super List<DeviceItem>, Unit> function12, Function1<? super DeviceProductType, Unit> function13, Function0<Unit> function0, Function1<? super MobileDevice, Unit> function14, Function0<Unit> function02) {
        this.onDeviceSelected = function1;
        this.onDeviceListChanged = function12;
        this.onNewFeaturePromptConfirmed = function13;
        this.onConnectionSuccess = function0;
        this.onConnectionSuccessWithDevice = function14;
        this.onDismiss = function02;
    }

    public /* synthetic */ DeviceFlowCallbacks(Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function1 function14, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? null : function0, (i & 16) != 0 ? null : function14, (i & 32) != 0 ? null : function02);
    }

    public final Function1<SelectedDeviceItem, Unit> getOnDeviceSelected() {
        return this.onDeviceSelected;
    }

    public final Function1<List<DeviceItem>, Unit> getOnDeviceListChanged() {
        return this.onDeviceListChanged;
    }

    public final Function1<DeviceProductType, Unit> getOnNewFeaturePromptConfirmed() {
        return this.onNewFeaturePromptConfirmed;
    }

    public final Function0<Unit> getOnConnectionSuccess() {
        return this.onConnectionSuccess;
    }

    public final Function1<MobileDevice, Unit> getOnConnectionSuccessWithDevice() {
        return this.onConnectionSuccessWithDevice;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }
}
