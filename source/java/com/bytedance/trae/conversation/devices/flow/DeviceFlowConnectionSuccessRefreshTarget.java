package com.bytedance.trae.conversation.devices.flow;

import kotlin.Metadata;

/* compiled from: DeviceFlowConnectionSuccessRefreshTarget.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;", "", "onDeviceConnectionSuccess", "", "selectedDeviceId", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceFlowConnectionSuccessRefreshTarget {
    void onDeviceConnectionSuccess(String selectedDeviceId);

    /* compiled from: DeviceFlowConnectionSuccessRefreshTarget.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onDeviceConnectionSuccess$default(DeviceFlowConnectionSuccessRefreshTarget deviceFlowConnectionSuccessRefreshTarget, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDeviceConnectionSuccess");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            deviceFlowConnectionSuccessRefreshTarget.onDeviceConnectionSuccess(str);
        }
    }
}
