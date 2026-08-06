package com.bytedance.trae.conversation.devices;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;", "", "<init>", "()V", "findNewlyBoundDevice", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "target", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "devices", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceBindingPolicy {
    public static final DeviceBindingPolicy INSTANCE = new DeviceBindingPolicy();

    private DeviceBindingPolicy() {
    }

    public final MobileDevice findNewlyBoundDevice(BindingTarget target, List<MobileDevice> devices) {
        Object obj;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(devices, "devices");
        Iterator<T> it = devices.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            MobileDevice mobileDevice = (MobileDevice) obj;
            if (mobileDevice.isPaired() && mobileDevice.getProductType() == target.getProductType() && !target.getExistingDeviceIds().contains(mobileDevice.getId())) {
                break;
            }
        }
        return (MobileDevice) obj;
    }
}
