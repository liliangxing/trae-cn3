package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.im.service.CliType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowExistingDeviceIds.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¨\u0006\n"}, d2 = {"deviceItemIdsByProduct", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "", "", "devices", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "mobileDeviceIdsByProduct", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowExistingDeviceIdsKt {

    /* compiled from: DeviceFlowExistingDeviceIds.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliType.values().length];
            try {
                iArr[CliType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CliType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CliType.REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Map<DeviceProductType, Set<String>> deviceItemIdsByProduct(List<DeviceItem> list) {
        Pair pair;
        Intrinsics.checkNotNullParameter(list, "devices");
        ArrayList<Pair> arrayList = new ArrayList();
        for (DeviceItem deviceItem : list) {
            int i = WhenMappings.$EnumSwitchMapping$0[deviceItem.getType().ordinal()];
            if (i == 1) {
                pair = TuplesKt.to(DeviceProductType.WORK, deviceItem.getId());
            } else if (i == 2) {
                pair = TuplesKt.to(DeviceProductType.IDE, deviceItem.getId());
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair2 : arrayList) {
            DeviceProductType deviceProductType = (DeviceProductType) pair2.getFirst();
            Object obj = linkedHashMap.get(deviceProductType);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(deviceProductType, obj);
            }
            ((List) obj).add((String) pair2.getSecond());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return linkedHashMap2;
    }

    public static final Map<DeviceProductType, Set<String>> mobileDeviceIdsByProduct(List<MobileDevice> list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MobileDevice mobileDevice : list) {
            DeviceProductType productType = mobileDevice.getProductType();
            Object obj = linkedHashMap.get(productType);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(productType, obj);
            }
            ((List) obj).add(mobileDevice.getId());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return linkedHashMap2;
    }
}
