package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "<init>", "()V", "displayState", "getDisplayState", "()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "WaitingForDesktop", "WaitingForAuthorization", "Succeeded", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForAuthorization;", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BindingGuideStableState implements BindingGuideState {
    public /* synthetic */ BindingGuideStableState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.bytedance.trae.conversation.devices.BindingGuideState
    public BindingGuideStableState getDisplayState() {
        return this;
    }

    private BindingGuideStableState() {
    }

    /* compiled from: DeviceBindingPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "deviceId", "", "<init>", "(Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class WaitingForDesktop extends BindingGuideStableState {
        private final String deviceId;

        public static /* synthetic */ WaitingForDesktop copy$default(WaitingForDesktop waitingForDesktop, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = waitingForDesktop.deviceId;
            }
            return waitingForDesktop.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        public final WaitingForDesktop copy(String deviceId) {
            return new WaitingForDesktop(deviceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForDesktop) && Intrinsics.areEqual(this.deviceId, ((WaitingForDesktop) other).deviceId);
        }

        public int hashCode() {
            String str = this.deviceId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "WaitingForDesktop(deviceId=" + this.deviceId + ')';
        }

        public WaitingForDesktop(String str) {
            super(null);
            this.deviceId = str;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    /* compiled from: DeviceBindingPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForAuthorization;", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "deviceId", "", "<init>", "(Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class WaitingForAuthorization extends BindingGuideStableState {
        private final String deviceId;

        public static /* synthetic */ WaitingForAuthorization copy$default(WaitingForAuthorization waitingForAuthorization, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = waitingForAuthorization.deviceId;
            }
            return waitingForAuthorization.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        public final WaitingForAuthorization copy(String deviceId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            return new WaitingForAuthorization(deviceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForAuthorization) && Intrinsics.areEqual(this.deviceId, ((WaitingForAuthorization) other).deviceId);
        }

        public int hashCode() {
            return this.deviceId.hashCode();
        }

        public String toString() {
            return "WaitingForAuthorization(deviceId=" + this.deviceId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForAuthorization(String deviceId) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            this.deviceId = deviceId;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    /* compiled from: DeviceBindingPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "device", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "<init>", "(Lcom/bytedance/trae/conversation/devices/MobileDevice;)V", "getDevice", "()Lcom/bytedance/trae/conversation/devices/MobileDevice;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Succeeded extends BindingGuideStableState {
        private final MobileDevice device;

        public static /* synthetic */ Succeeded copy$default(Succeeded succeeded, MobileDevice mobileDevice, int i, Object obj) {
            if ((i & 1) != 0) {
                mobileDevice = succeeded.device;
            }
            return succeeded.copy(mobileDevice);
        }

        /* renamed from: component1, reason: from getter */
        public final MobileDevice getDevice() {
            return this.device;
        }

        public final Succeeded copy(MobileDevice device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new Succeeded(device);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Succeeded) && Intrinsics.areEqual(this.device, ((Succeeded) other).device);
        }

        public int hashCode() {
            return this.device.hashCode();
        }

        public String toString() {
            return "Succeeded(device=" + this.device + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Succeeded(MobileDevice device) {
            super(null);
            Intrinsics.checkNotNullParameter(device, "device");
            this.device = device;
        }

        public final MobileDevice getDevice() {
            return this.device;
        }
    }
}
