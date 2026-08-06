package com.bytedance.trae.conversation.devices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"idsForProduct", "", "", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceBindingPolicyKt {
    public static final Set<String> idsForProduct(List<MobileDevice> list, DeviceProductType deviceProductType) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(deviceProductType, "productType");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MobileDevice) obj).getProductType() == deviceProductType) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((MobileDevice) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList3);
    }
}
