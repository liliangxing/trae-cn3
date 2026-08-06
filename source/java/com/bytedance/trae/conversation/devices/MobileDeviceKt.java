package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MobileDevice.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"toMobileDeviceOrNull", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "Lcom/bytedance/trae/im/service/Cli;", "isPaired", "", "DEFAULT_WORK_DEVICE_NAME", "", "DEFAULT_IDE_DEVICE_NAME", "hasBoundDevice", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MobileDeviceKt {
    private static final String DEFAULT_IDE_DEVICE_NAME = "TRAE IDE PC";
    private static final String DEFAULT_WORK_DEVICE_NAME = "TRAE Work PC";

    /* compiled from: MobileDevice.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceProductType.values().length];
            try {
                iArr[DeviceProductType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceProductType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ MobileDevice toMobileDeviceOrNull$default(Cli cli, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toMobileDeviceOrNull(cli, z);
    }

    public static final MobileDevice toMobileDeviceOrNull(Cli cli, boolean z) {
        DeviceProductType deviceProductType;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(cli, "<this>");
        String id = cli.getId();
        if (id != null) {
            String str3 = StringsKt.isBlank(id) ^ true ? id : null;
            if (str3 != null) {
                String type = cli.getType();
                if (Intrinsics.areEqual(type, CliType.LOCAL.getValue())) {
                    deviceProductType = DeviceProductType.WORK;
                } else if (Intrinsics.areEqual(type, CliType.IDE.getValue())) {
                    deviceProductType = DeviceProductType.IDE;
                }
                DeviceProductType deviceProductType2 = deviceProductType;
                String name = cli.getName();
                if (name != null) {
                    String str4 = StringsKt.isBlank(name) ^ true ? name : null;
                    if (str4 != null) {
                        str2 = str4;
                        return new MobileDevice(str3, str2, deviceProductType2, Intrinsics.areEqual(cli.getStatus(), "online"), cli.getIdeVersion(), z);
                    }
                }
                int i = WhenMappings.$EnumSwitchMapping$0[deviceProductType2.ordinal()];
                if (i == 1) {
                    str = DEFAULT_WORK_DEVICE_NAME;
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = DEFAULT_IDE_DEVICE_NAME;
                }
                str2 = str;
                return new MobileDevice(str3, str2, deviceProductType2, Intrinsics.areEqual(cli.getStatus(), "online"), cli.getIdeVersion(), z);
            }
        }
        return null;
    }

    public static final boolean hasBoundDevice(List<MobileDevice> list, DeviceProductType deviceProductType) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(deviceProductType, "productType");
        List<MobileDevice> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((MobileDevice) it.next()).getProductType() == deviceProductType) {
                return true;
            }
        }
        return false;
    }
}
