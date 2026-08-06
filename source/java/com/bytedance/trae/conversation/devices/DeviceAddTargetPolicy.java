package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.im.service.CliType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceAddTargetPolicy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0006*\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;", "", "<init>", "()V", "availableTargets", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "canShowIdeTarget", "", "bindingTarget", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "productType", "currentDevices", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "enterFrom", "", "toProductTypeOrNull", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceAddTargetPolicy {
    public static final DeviceAddTargetPolicy INSTANCE = new DeviceAddTargetPolicy();

    /* compiled from: DeviceAddTargetPolicy.kt */
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DeviceAddTargetPolicy() {
    }

    public static /* synthetic */ List availableTargets$default(DeviceAddTargetPolicy deviceAddTargetPolicy, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = MobileIdeFeatureGate.INSTANCE.isGuideEnabled();
        }
        return deviceAddTargetPolicy.availableTargets(z);
    }

    public final List<DeviceProductType> availableTargets(boolean canShowIdeTarget) {
        return canShowIdeTarget ? CollectionsKt.listOf(new DeviceProductType[]{DeviceProductType.WORK, DeviceProductType.IDE}) : CollectionsKt.listOf(DeviceProductType.WORK);
    }

    public final BindingTarget bindingTarget(DeviceProductType productType, List<DeviceItem> currentDevices, String enterFrom) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(currentDevices, "currentDevices");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentDevices) {
            if (INSTANCE.toProductTypeOrNull((DeviceItem) obj) == productType) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((DeviceItem) it.next()).getId());
        }
        return new BindingTarget(productType, CollectionsKt.toSet(arrayList3), enterFrom, null, null, null, 56, null);
    }

    private final DeviceProductType toProductTypeOrNull(DeviceItem deviceItem) {
        int i = WhenMappings.$EnumSwitchMapping$0[deviceItem.getType().ordinal()];
        if (i == 1) {
            return DeviceProductType.WORK;
        }
        if (i != 2) {
            return null;
        }
        return DeviceProductType.IDE;
    }
}
