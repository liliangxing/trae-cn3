package com.bytedance.trae.conversation.devices;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceListSelectionPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;", "", "<init>", "()V", "applySelection", "Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;", "devices", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "sessionSelectedDeviceId", "", "preselectedDeviceId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceListSelectionPolicy {
    public static final DeviceListSelectionPolicy INSTANCE = new DeviceListSelectionPolicy();

    private DeviceListSelectionPolicy() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        if (r6 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
    
        if (r4 != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DeviceListSelectionResult applySelection(List<DeviceItem> devices, String sessionSelectedDeviceId, String preselectedDeviceId) {
        DeviceItem copy;
        boolean z;
        boolean z2;
        String str = sessionSelectedDeviceId;
        String str2 = preselectedDeviceId;
        Intrinsics.checkNotNullParameter(devices, "devices");
        String str3 = null;
        boolean z3 = false;
        if (str != null) {
            if (!StringsKt.isBlank(str)) {
                List<DeviceItem> list = devices;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((DeviceItem) it.next()).getId(), str)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                boolean z4 = z2;
            }
        }
        str = null;
        if (str == null) {
            if (str2 != null) {
                if (!StringsKt.isBlank(str2)) {
                    List<DeviceItem> list2 = devices;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        for (DeviceItem deviceItem : list2) {
                            if (Intrinsics.areEqual(deviceItem.getId(), str2) && deviceItem.isOnline()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        z3 = true;
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
                DeviceItem deviceItem2 = (DeviceItem) CollectionsKt.firstOrNull(devices);
                if (deviceItem2 != null) {
                    str3 = deviceItem2.getId();
                }
            } else {
                str3 = str2;
            }
        } else {
            str3 = str;
        }
        List<DeviceItem> list3 = devices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (DeviceItem deviceItem3 : list3) {
            copy = deviceItem3.copy((r20 & 1) != 0 ? deviceItem3.id : null, (r20 & 2) != 0 ? deviceItem3.name : null, (r20 & 4) != 0 ? deviceItem3.model : null, (r20 & 8) != 0 ? deviceItem3.iconResId : 0, (r20 & 16) != 0 ? deviceItem3.isOnline : false, (r20 & 32) != 0 ? deviceItem3.isSelected : Intrinsics.areEqual(deviceItem3.getId(), str3), (r20 & 64) != 0 ? deviceItem3.type : null, (r20 & 128) != 0 ? deviceItem3.ideVersion : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? deviceItem3.isPaired : false);
            arrayList.add(copy);
        }
        return new DeviceListSelectionResult(arrayList, str);
    }
}
