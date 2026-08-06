package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.MobileDeviceKt;
import com.bytedance.trae.im.service.Cli;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\u0000¨\u0006\u0005"}, d2 = {"mapDiscoverableDevices", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "clis", "Lcom/bytedance/trae/im/service/Cli;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CliListRepositoryKt {
    public static final List<MobileDevice> mapDiscoverableDevices(List<Cli> list) {
        Intrinsics.checkNotNullParameter(list, "clis");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Cli cli : list) {
            String id = cli.getId();
            if (id != null) {
                if (!(!StringsKt.isBlank(id))) {
                    id = null;
                }
                if (id != null && hashSet.add(id)) {
                    String registeredAt = cli.getRegisteredAt();
                    MobileDevice mobileDeviceOrNull = MobileDeviceKt.toMobileDeviceOrNull(cli, !(registeredAt == null || StringsKt.isBlank(registeredAt)));
                    if (mobileDeviceOrNull != null) {
                        arrayList.add(mobileDeviceOrNull);
                    }
                }
            }
        }
        return arrayList;
    }
}
