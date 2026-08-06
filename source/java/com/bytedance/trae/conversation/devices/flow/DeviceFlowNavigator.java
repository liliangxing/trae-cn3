package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import java.util.List;
import kotlin.Metadata;

/* compiled from: DeviceFlowNavigator.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;", "", "navigate", "", "route", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "openNewFlow", "onRouteBack", "", "closeCurrentFlow", "notifyDeviceSelected", "device", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "notifyDeviceListChanged", "devices", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "notifyConnectionSuccess", "notifyConnectionSuccessWithDevice", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface DeviceFlowNavigator {
    void closeCurrentFlow();

    void navigate(DeviceFlowRoute route);

    void notifyConnectionSuccess();

    void notifyConnectionSuccessWithDevice(MobileDevice device);

    void notifyDeviceListChanged(List<DeviceItem> devices);

    void notifyDeviceSelected(SelectedDeviceItem device);

    boolean onRouteBack();

    void openNewFlow(DeviceFlowRoute route);
}
