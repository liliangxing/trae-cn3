package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeDeviceItemAdapter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"shouldShowStatusChip", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeDeviceItemAdapterKt {
    public static final boolean shouldShowStatusChip(DeviceItem deviceItem) {
        Intrinsics.checkNotNullParameter(deviceItem, "<this>");
        return deviceItem.getType() == CliType.LOCAL || deviceItem.getType() == CliType.IDE;
    }
}
