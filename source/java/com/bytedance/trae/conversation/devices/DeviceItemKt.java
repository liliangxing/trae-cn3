package com.bytedance.trae.conversation.devices;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceItem.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"toDeviceLogSummary", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "toDeviceLogId", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceItemKt {
    public static final String toDeviceLogSummary(DeviceItem deviceItem) {
        Intrinsics.checkNotNullParameter(deviceItem, "<this>");
        return "id=" + toDeviceLogId(deviceItem.getId()) + ",type=" + deviceItem.getType().getValue() + ",online=" + deviceItem.isOnline() + ",paired=" + deviceItem.isPaired() + ",selected=" + deviceItem.isSelected();
    }

    public static final String toDeviceLogSummary(OfflineDeviceTarget offlineDeviceTarget) {
        Intrinsics.checkNotNullParameter(offlineDeviceTarget, "<this>");
        return "id=" + toDeviceLogId(offlineDeviceTarget.getDeviceId()) + ",productType=" + offlineDeviceTarget.getProductType().name() + ",paired=" + offlineDeviceTarget.isPaired();
    }

    public static final String toDeviceLogId(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.isBlank(str) ? "" : str.length() <= 8 ? str : StringsKt.take(str, 4) + "..." + StringsKt.takeLast(str, 4);
    }
}
