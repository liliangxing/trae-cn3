package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.im.service.CliType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceListMapper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"toSelectableDeviceItems", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "isCodeMode", "", "iconResId", "", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceListMapperKt {

    /* compiled from: DeviceListMapper.kt */
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

    public static final List<DeviceItem> toSelectableDeviceItems(List<MobileDevice> list, boolean z, int i) {
        CliType cliType;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                ArrayList<MobileDevice> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (MobileDevice mobileDevice : arrayList2) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[mobileDevice.getProductType().ordinal()];
                    if (i2 == 1) {
                        cliType = CliType.LOCAL;
                    } else {
                        if (i2 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        cliType = CliType.IDE;
                    }
                    arrayList3.add(new DeviceItem(mobileDevice.getId(), mobileDevice.getName(), null, i, mobileDevice.isOnline(), false, cliType, mobileDevice.getIdeVersion(), mobileDevice.isPaired(), 4, null));
                }
                return arrayList3;
            }
            Object next = it.next();
            int i3 = WhenMappings.$EnumSwitchMapping$0[((MobileDevice) next).getProductType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                z2 = z;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }
}
