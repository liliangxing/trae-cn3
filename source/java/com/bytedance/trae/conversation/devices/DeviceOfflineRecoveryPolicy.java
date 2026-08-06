package com.bytedance.trae.conversation.devices;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceOfflineRecoveryPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;", "", "<init>", "()V", "isRecovered", "", "target", "Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "devices", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "findRecoveredDevice", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceOfflineRecoveryPolicy {
    public static final DeviceOfflineRecoveryPolicy INSTANCE = new DeviceOfflineRecoveryPolicy();

    private DeviceOfflineRecoveryPolicy() {
    }

    public final boolean isRecovered(OfflineDeviceTarget target, List<MobileDevice> devices) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(devices, "devices");
        return findRecoveredDevice(target, devices) != null;
    }

    public final MobileDevice findRecoveredDevice(OfflineDeviceTarget target, List<MobileDevice> devices) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(devices, "devices");
        Object obj = null;
        if (StringsKt.isBlank(target.getDeviceId())) {
            return null;
        }
        Iterator<T> it = devices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MobileDevice mobileDevice = (MobileDevice) next;
            if (Intrinsics.areEqual(mobileDevice.getId(), target.getDeviceId()) && mobileDevice.getProductType() == target.getProductType() && mobileDevice.isOnline()) {
                obj = next;
                break;
            }
        }
        return (MobileDevice) obj;
    }
}
