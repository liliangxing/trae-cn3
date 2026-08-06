package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowCallbacks.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;", "", "initialRoute", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "callbacks", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;", "<init>", "(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V", "getInitialRoute", "()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "getCallbacks", "()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceFlowRequest {
    private final DeviceFlowCallbacks callbacks;
    private final DeviceFlowRoute initialRoute;

    public static /* synthetic */ DeviceFlowRequest copy$default(DeviceFlowRequest deviceFlowRequest, DeviceFlowRoute deviceFlowRoute, DeviceFlowCallbacks deviceFlowCallbacks, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceFlowRoute = deviceFlowRequest.initialRoute;
        }
        if ((i & 2) != 0) {
            deviceFlowCallbacks = deviceFlowRequest.callbacks;
        }
        return deviceFlowRequest.copy(deviceFlowRoute, deviceFlowCallbacks);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceFlowRoute getInitialRoute() {
        return this.initialRoute;
    }

    /* renamed from: component2, reason: from getter */
    public final DeviceFlowCallbacks getCallbacks() {
        return this.callbacks;
    }

    public final DeviceFlowRequest copy(DeviceFlowRoute initialRoute, DeviceFlowCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(initialRoute, "initialRoute");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        return new DeviceFlowRequest(initialRoute, callbacks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceFlowRequest)) {
            return false;
        }
        DeviceFlowRequest deviceFlowRequest = (DeviceFlowRequest) other;
        return Intrinsics.areEqual(this.initialRoute, deviceFlowRequest.initialRoute) && Intrinsics.areEqual(this.callbacks, deviceFlowRequest.callbacks);
    }

    public int hashCode() {
        return (this.initialRoute.hashCode() * 31) + this.callbacks.hashCode();
    }

    public String toString() {
        return "DeviceFlowRequest(initialRoute=" + this.initialRoute + ", callbacks=" + this.callbacks + ')';
    }

    public DeviceFlowRequest(DeviceFlowRoute initialRoute, DeviceFlowCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(initialRoute, "initialRoute");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.initialRoute = initialRoute;
        this.callbacks = callbacks;
    }

    public final DeviceFlowRoute getInitialRoute() {
        return this.initialRoute;
    }

    public /* synthetic */ DeviceFlowRequest(DeviceFlowRoute deviceFlowRoute, DeviceFlowCallbacks deviceFlowCallbacks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceFlowRoute, (i & 2) != 0 ? new DeviceFlowCallbacks(null, null, null, null, null, null, 63, null) : deviceFlowCallbacks);
    }

    public final DeviceFlowCallbacks getCallbacks() {
        return this.callbacks;
    }
}
