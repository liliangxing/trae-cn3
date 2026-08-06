package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.MobileDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowContainerBottomSheet.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class DeviceFlowContainerBottomSheet$openNewFlow$2 extends FunctionReferenceImpl implements Function1<MobileDevice, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceFlowContainerBottomSheet$openNewFlow$2(Object obj) {
        super(1, obj, DeviceFlowContainerBottomSheet.class, "returnToDeviceSelectionAfterBinding", "returnToDeviceSelectionAfterBinding(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z", 0);
    }

    public final Boolean invoke(MobileDevice mobileDevice) {
        boolean returnToDeviceSelectionAfterBinding;
        Intrinsics.checkNotNullParameter(mobileDevice, "p0");
        returnToDeviceSelectionAfterBinding = ((DeviceFlowContainerBottomSheet) this.receiver).returnToDeviceSelectionAfterBinding(mobileDevice);
        return Boolean.valueOf(returnToDeviceSelectionAfterBinding);
    }
}
