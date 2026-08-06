package com.bytedance.trae.conversation.devices.flow;

import kotlin.Metadata;

/* compiled from: DeviceFlowBackPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;", "", "<init>", "()V", "leftAction", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;", "backStackEntryCount", "", "canNavigate", "", "systemBack", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceFlowBackPolicy {
    public static final DeviceFlowBackPolicy INSTANCE = new DeviceFlowBackPolicy();

    private DeviceFlowBackPolicy() {
    }

    public final DeviceFlowBackAction leftAction(int backStackEntryCount, boolean canNavigate) {
        if (!canNavigate) {
            return DeviceFlowBackAction.Defer;
        }
        if (backStackEntryCount > 0) {
            return DeviceFlowBackAction.PopRoute;
        }
        return DeviceFlowBackAction.CloseFlow;
    }

    public final DeviceFlowBackAction systemBack(int backStackEntryCount) {
        return DeviceFlowBackAction.CloseFlow;
    }
}
