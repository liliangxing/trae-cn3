package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.devices.BindingTarget;
import com.bytedance.trae.conversation.devices.DevicePairingTrigger;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsDeviceMapper.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u001a\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000\u001a\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a$\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\n*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a$\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\n*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a$\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¨\u0006\u0011"}, d2 = {"toSettingsDeviceItems", "", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "findNewlyBoundDeviceName", "", "previousDeviceIds", "", "pairedDeviceIds", "pairedDeviceIdsByProduct", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "deviceIdsByProduct", "unpairedBindingRoute", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;", "currentDevices", "enterFrom", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceMapperKt {
    public static final List<SettingsDeviceItem> toSettingsDeviceItems(List<MobileDevice> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<MobileDevice> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MobileDevice mobileDevice : list2) {
            arrayList.add(new SettingsDeviceItem(mobileDevice.getId(), mobileDevice.getName(), mobileDevice.isOnline(), mobileDevice.getProductType(), mobileDevice.isPaired()));
        }
        return arrayList;
    }

    public static final String findNewlyBoundDeviceName(List<SettingsDeviceItem> list, Set<String> set) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(set, "previousDeviceIds");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SettingsDeviceItem settingsDeviceItem = (SettingsDeviceItem) obj;
            if (settingsDeviceItem.isPaired() && !set.contains(settingsDeviceItem.getId())) {
                break;
            }
        }
        SettingsDeviceItem settingsDeviceItem2 = (SettingsDeviceItem) obj;
        if (settingsDeviceItem2 != null) {
            return settingsDeviceItem2.getName();
        }
        return null;
    }

    public static final Set<String> pairedDeviceIds(List<SettingsDeviceItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SettingsDeviceItem) obj).isPaired()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((SettingsDeviceItem) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList3);
    }

    public static final Map<DeviceProductType, Set<String>> pairedDeviceIdsByProduct(List<SettingsDeviceItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList<SettingsDeviceItem> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SettingsDeviceItem) obj).isPaired()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SettingsDeviceItem settingsDeviceItem : arrayList) {
            DeviceProductType productType = settingsDeviceItem.getProductType();
            Object obj2 = linkedHashMap.get(productType);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(productType, obj2);
            }
            ((List) obj2).add(settingsDeviceItem.getId());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return linkedHashMap2;
    }

    public static final Map<DeviceProductType, Set<String>> deviceIdsByProduct(List<SettingsDeviceItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SettingsDeviceItem settingsDeviceItem : list) {
            DeviceProductType productType = settingsDeviceItem.getProductType();
            Object obj = linkedHashMap.get(productType);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(productType, obj);
            }
            ((List) obj).add(settingsDeviceItem.getId());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return linkedHashMap2;
    }

    public static final DeviceFlowRoute.ConnectGuide unpairedBindingRoute(SettingsDeviceItem settingsDeviceItem, List<SettingsDeviceItem> list, String str) {
        Intrinsics.checkNotNullParameter(settingsDeviceItem, "<this>");
        Intrinsics.checkNotNullParameter(list, "currentDevices");
        Intrinsics.checkNotNullParameter(str, "enterFrom");
        if (settingsDeviceItem.isPaired()) {
            return null;
        }
        DeviceProductType productType = settingsDeviceItem.getProductType();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SettingsDeviceItem) obj).getProductType() == settingsDeviceItem.getProductType()) {
                arrayList.add(obj);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((SettingsDeviceItem) it.next()).getId());
        }
        return new DeviceFlowRoute.ConnectGuide(new BindingTarget(productType, linkedHashSet, str, DevicePairingTrigger.UNBOUND_DEVICE, settingsDeviceItem.getId(), settingsDeviceItem.getName()));
    }
}
